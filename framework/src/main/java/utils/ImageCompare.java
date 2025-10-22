package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.time.Duration;
import java.util.Base64;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.util.List;

public class ImageCompare {

    // --- Existing URL-based method (unchanged) ---
    public static boolean imagesAreSimilar(String imageUrl, File baselineFile, double maxPercentDifference) throws IOException {
        BufferedImage expected = ImageIO.read(baselineFile);
        if (expected == null) throw new IOException("Could not read baseline image: " + baselineFile);

        BufferedImage actual = ImageIO.read(new URL(imageUrl));
        if (actual == null) throw new IOException("Could not download/parse image from URL: " + imageUrl);

        if (actual.getWidth() != expected.getWidth() || actual.getHeight() != expected.getHeight()) {
            actual = resize(actual, expected.getWidth(), expected.getHeight());
        }

        double pct = percentDifferent(actual, expected);
        System.out.println(String.format("Image difference = %.4f%% (threshold = %.4f%%)", pct, maxPercentDifference));
        return pct <= maxPercentDifference;
    }

    // --- New: compare using element screenshot (works for blob: src) ---
    public static boolean imagesAreSimilarFromElement(WebDriver driver, WebElement imgElement, File baselineFile, double maxPercentDifference) throws IOException {
        // take element screenshot (Selenium 4 / Appium)
        File tmp = imgElement.getScreenshotAs(OutputType.FILE);
        try {
            BufferedImage actual = ImageIO.read(tmp);
            if (actual == null) throw new IOException("Could not read element screenshot image");

            BufferedImage expected = ImageIO.read(baselineFile);
            if (expected == null) throw new IOException("Could not read baseline image: " + baselineFile);

            if (actual.getWidth() != expected.getWidth() || actual.getHeight() != expected.getHeight()) {
                actual = resize(actual, expected.getWidth(), expected.getHeight());
            }

            double pct = percentDifferent(actual, expected);
            System.out.println(String.format("Element screenshot difference = %.4f%% (threshold = %.4f%%)", pct, maxPercentDifference));
            return pct <= maxPercentDifference;
        } finally {
            // try to delete temporary screenshot file
            try { Files.deleteIfExists(tmp.toPath()); } catch (Exception ignored) {}
        }
    }

    // --- New: fetch the blob inside browser (works for blob: and returns original bytes) ---
    public static boolean imagesAreSimilarFromElementViaBlob(WebDriver driver, WebElement imgElement, File baselineFile, double maxPercentDifference) throws Exception {
        if (!(driver instanceof JavascriptExecutor)) throw new IllegalArgumentException("Driver must implement JavascriptExecutor");

        // JS: fetch(src) -> blob -> FileReader -> dataURL and return it via callback
        String script =
                "var img = arguments[0];" +
                        "var cb = arguments[arguments.length-1];" +
                        "var src = img.src || img.getAttribute('src');" +
                        "if (!src) { cb('ERROR: no src'); return; }" +
                        "if (src.indexOf('data:') === 0) { cb(src); return; }" +
                        "fetch(src).then(r => r.blob()).then(b => { var reader = new FileReader();" +
                        " reader.onloadend = function(){ cb(reader.result); };" +
                        " reader.readAsDataURL(b); }).catch(e => cb('ERROR:' + e.message));";

        Object res = ((JavascriptExecutor) driver).executeAsyncScript(script, imgElement);
        if (res == null) throw new IOException("No response from JS fetch");
        String dataUrl = res.toString();
        if (dataUrl.startsWith("ERROR:")) throw new IOException("JS fetch error: " + dataUrl);

        int comma = dataUrl.indexOf(',');
        if (comma < 0) throw new IOException("Invalid data URL returned");
        String base64 = dataUrl.substring(comma + 1);
        byte[] bytes = Base64.getDecoder().decode(base64);

        // read baseline and actual
        BufferedImage actual;
        try (InputStream in = new ByteArrayInputStream(bytes)) {
            actual = ImageIO.read(in);
        }
        if (actual == null) throw new IOException("Could not parse image from blob data");

        BufferedImage expected = ImageIO.read(baselineFile);
        if (expected == null) throw new IOException("Could not read baseline image: " + baselineFile);

        if (actual.getWidth() != expected.getWidth() || actual.getHeight() != expected.getHeight()) {
            actual = resize(actual, expected.getWidth(), expected.getHeight());
        }

        double pct = percentDifferent(actual, expected);
        System.out.println(String.format("Blob-fetch difference = %.4f%% (threshold = %.4f%%)", pct, maxPercentDifference));
        return pct <= maxPercentDifference;
    }

    // compute percent difference between two same-sized images (0.0 = identical, 100.0 = totally different)
    private static double percentDifferent(BufferedImage a, BufferedImage b) {
        int w = a.getWidth();
        int h = a.getHeight();

        long diff = 0L;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int rgbA = a.getRGB(x, y);
                int rgbB = b.getRGB(x, y);

                int rA = (rgbA >> 16) & 0xff;
                int gA = (rgbA >> 8) & 0xff;
                int bA = (rgbA) & 0xff;

                int rB = (rgbB >> 16) & 0xff;
                int gB = (rgbB >> 8) & 0xff;
                int bB = (rgbB) & 0xff;

                diff += Math.abs(rA - rB);
                diff += Math.abs(gA - gB);
                diff += Math.abs(bA - bB);
            }
        }

        double maxDiff = 3.0 * 255 * w * h; // 3 channels
        return 100.0 * diff / maxDiff;
    }

    // simple high-quality resize
    private static BufferedImage resize(BufferedImage src, int targetW, int targetH) {
        Image tmp = src.getScaledInstance(targetW, targetH, Image.SCALE_SMOOTH);
        BufferedImage dest = new BufferedImage(targetW, targetH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(tmp, 0, 0, null);
        g2.dispose();
        return dest;
    }


    public void compareTwoPhotosSafely(WebDriver driver, File baselineFolder, double tolerancePercent) throws Exception {
        // debug: what is the runtime class?
        System.out.println("DBG: driver class = " + driver.getClass().getName());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // find images under lib-photo (robust)
        List<WebElement> imgs = wait.until(d -> d.findElements(By.xpath("//lib-photo//img")));

        System.out.println("DBG: found imgs = " + imgs.size());
        if (imgs.size() < 2) {
            throw new AssertionError("Expected >=2 photos; found " + imgs.size());
        }

        // compare first two (index 0 and 1)
        for (int i=0; i<2; i++) {
            WebElement img = imgs.get(i);

            // scroll into view just in case (helps interactability and screenshot correctness)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", img);

            // wait until image is fully loaded (complete + naturalWidth > 0)
            wait.until(d -> ((JavascriptExecutor) d)
                    .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", img));

            // debug print src (will show blob:... if blob)
            String src = img.getAttribute("src");
            System.out.println("DBG: image[" + i + "] src = " + src);

            // pick baseline file (example: baseline-photo-1.png, baseline-photo-2.png)
            File baseline = new File(baselineFolder, String.format("baseline-photo-%d.png", i+1));
            if (!baseline.exists()) {
                throw new IllegalStateException("Missing baseline: " + baseline.getAbsolutePath());
            }

            // Use the element-screenshot compare (works for blob: URLs)
            boolean similar = ImageCompare.imagesAreSimilarFromElement(driver, img, baseline, tolerancePercent);
            System.out.println("DBG: image[" + i + "] similar? " + similar);
            if (!similar) {
                throw new AssertionError("Image " + i + " differs beyond tolerance");
            }
        }

        System.out.println("All compared images are within tolerance");
    }
}
