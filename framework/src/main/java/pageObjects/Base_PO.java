package pageObjects;

import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.globalVariables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import utils.globalVariables.*;

public class Base_PO {

    public void initElements() throws IOException, URISyntaxException {
        //System.out.println("Basepage constructor called");
        if (DriverFactory.getDriver() != null) {
            PageFactory.initElements(DriverFactory.getDriver(), this);
        } else {
            throw new IllegalStateException("- Driver is not initialized yet");
        }
        //System.out.println("Basepage elements initialised");
    }

    public AndroidDriver getDriver() throws IOException, URISyntaxException {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) throws IOException, URISyntaxException {
        getDriver().get(globalVariables.mobilePortalHomepageURL);
    }

    public void sendKeys(WebElement element, String textToType) throws IOException, URISyntaxException {
        System.out.println("- Sendking keys to " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);

    }

    public void waitForWebElementAndClickElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("- Waiting for element to be clickable...");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

        System.out.println("- Executing native W3C screen tap...");

        // 1. Calculate the exact center coordinates of the element on the screen
        int centerX = clickableElement.getRect().getX() + (clickableElement.getSize().getWidth() / 2);
        int centerY = clickableElement.getRect().getY() + (clickableElement.getSize().getHeight() / 2);

        // 2. Create a virtual "finger" to perform the touch action
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        // 3. Build the tap sequence: Move to center -> Press down -> Lift up
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // 4. Command the driver to perform the sequence
        ((AppiumDriver) getDriver()).perform(Collections.singletonList(tap));
    }

    public void waitForWebElementAndClickBy(By locator) throws IOException, URISyntaxException {
        System.out.println("- Clicking element located by: " + locator);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elem.click();
    }


    public void waitForWebElementToBeVisible(WebElement element) throws IOException, URISyntaxException {
        System.out.println("- Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForSyncFinish(WebElement element) throws IOException, URISyntaxException {
        System.out.println("- Waiting for sync to complete");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Sync complete");
    }

    public void waitForWebElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("- Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAngularWebElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("- Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(d -> (Boolean)((JavascriptExecutor)d).executeScript(
                "return window.getAllAngularTestabilities ? window.getAllAngularTestabilities().every(x=>x.isStable()) : true"
        ));
    }

    public void waitForAngularBy(By locator) throws IOException, URISyntaxException {
        System.out.println("- Waiting for Angular and element: " + locator);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));

        // wait for Angular testabilities to be stable (returns true if Angular not present)
        wait.until(d -> (Boolean) ((JavascriptExecutor) d).executeScript(
                "return window.getAllAngularTestabilities ? window.getAllAngularTestabilities().every(function(x){return x.isStable();}) : true"
        ));

        // then wait for the target element to be visible and interactable
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitForPresenceOfLocated(WebElement element) throws IOException, URISyntaxException {
        WebElement el = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
        el.click();

    }

    /*public void waitForSignOutComplete () throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        By locator = By.id("username");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();

    }*/

    // 1. Method to jump into the phone's OS
    public void switchToNative() throws IOException, URISyntaxException {
        System.out.println("- Switching context to NATIVE_APP");
        ((SupportsContextSwitching) getDriver()).context("NATIVE_APP");
    }

    // 2. Method to jump back to your web app
    public void switchToWebView() throws IOException, URISyntaxException {
        System.out.println("- Switching context back to WEBVIEW");

        // Use the new cast here
        Set<String> contexts = ((SupportsContextSwitching) getDriver()).getContextHandles();

        for (String contextName : contexts) {
            if (contextName.contains("WEBVIEW")) {
                ((SupportsContextSwitching) getDriver()).context(contextName);
                System.out.println("- Successfully switched to " + contextName);
                break;
            }
        }
    }

    public void uploadImageFromNativeGallery() throws IOException, URISyntaxException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            // 2. SWITCH CONTEXT
            switchToNative();

            System.out.println("- Selecting photo...");
            By firstPhotoLocator = By.xpath("Photo taken on 9 Jan 2025 12:55");
            //WebElement firstPhoto = wait.until(ExpectedConditions.elementToBeClickable(firstPhotoLocator));
            waitForWebElementAndClickBy(firstPhotoLocator);
            //System.out.println(getDriver().getPageSource());

            //Select 'Done' to close the gallery
            By doneButtonLocator = By.xpath("//android.widget.TextView[@text='Done']/..");

            WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(doneButtonLocator));
            doneButton.click();


        } catch (Exception e) {
            throw new RuntimeException("Failed to upload image from native gallery", e);
        } finally {
            // 5. SWITCH BACK (Always put this in a 'finally' block so it switches back even if the test fails!)
            switchToWebView();
        }
    }


    public void swipeToFindPhoto(String xpathLocator, int maxSwipes) throws IOException, URISyntaxException {
        //String xpathLocator = "//*[contains(@content-desc, '" + description + "')]";

        System.out.print(("Full xpath locator: " + xpathLocator));
        System.out.println("- Starting native swipe search...");


        Dimension size = getDriver().manage().window().getSize();
        int swipes = 0;
        boolean found = false;

        // Set up the parameters for the native Appium swipe
        Map<String, Object> swipeParams = new HashMap<>();
        swipeParams.put("left", size.width / 4); // Start slightly offset from the left edge
        swipeParams.put("top", size.height / 4); // Use the middle 50% of the screen
        swipeParams.put("width", size.width / 2);
        swipeParams.put("height", size.height / 2);
        swipeParams.put("direction", "up"); // Swiping the finger UP scrolls the gallery DOWN
        swipeParams.put("percent", 0.40);// How hard/far to swipe (75% of the bounding box)

        while (swipes < maxSwipes && !found) {
            try {
                WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
                WebElement photo = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));

                System.out.println("- Photo found after " + swipes + " swipes!");
                photo.click();
                found = true;

                By doneButtonLocator = By.xpath("//android.widget.TextView[@text='Done']/..");

                WebElement doneButton = shortWait.until(ExpectedConditions.elementToBeClickable(doneButtonLocator));
                doneButton.click();

            } catch (TimeoutException e) {
                System.out.println("- Swiping... (" + (swipes + 1) + "/" + maxSwipes + ")");

                ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", swipeParams);

                // CRITICAL FIX: Give the Android XML tree 1.5 seconds to fully rebuild before searching again
                try { Thread.sleep(1500); } catch (InterruptedException ignored) {}

                swipes++;
            }
        }

        if (!found) {
            //XML Dump screen to check why image not found
            System.out.println("=== ELEMENT NOT FOUND. DUMPING FINAL PAGE XML ===");
            System.out.println(getDriver().getPageSource());
            throw new RuntimeException("Scrolled " + maxSwipes + " times but never found the photo. Check the XML dump above to verify the exact content-desc formatting.");
        }
    }


}

