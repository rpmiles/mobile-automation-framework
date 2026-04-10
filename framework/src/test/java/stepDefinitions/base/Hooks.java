package stepDefinitions.base;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

import static driver.DriverFactory.getDriver;

public class Hooks {

    public class SystemOutFilter extends PrintStream {
        private final PrintStream original;

        public SystemOutFilter(PrintStream original) {
            super(original);
            this.original = original;
        }

        @Override
        public void println(String x) {
            if (shouldPrint(x)) {
                original.println(x);
            }
        }

        @Override
        public void print(String s) {
            if (shouldPrint(s)) {
                original.print(s);
            }
        }

        private boolean shouldPrint(String message) {
            if (message == null) return true;
            String lower = message.toLowerCase();

            if (lower.contains("clicking") && lower.contains("androiddriver")) return false;
            if (lower.contains("clicking proxy")) return false;

            // ADDED BACK: Sending keys filters
            if (lower.contains("sendkeys") || lower.contains("sendking keys")) return false;

            if (lower.contains("waiting for") || lower.contains("waited for")) return false;
            if (lower.contains("androiddriver")) return false;

            return true;
        }
    }

    @Before
    public void setup() throws IOException, URISyntaxException {
        System.setOut(new SystemOutFilter(System.out));

        AndroidDriver driver = getDriver();

        // 1. Wait for app load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2. Switch to WebView while explicitly ignoring the Samsung Terrace ghost
        switchToWebView(driver);
    }

    private void switchToWebView(AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Wait until a valid WebView (that isn't Terrace) appears
            wait.until(d -> {
                Set<String> contexts = driver.getContextHandles();
                return contexts.stream().anyMatch(c -> c.contains("WEBVIEW") && !c.contains("Terrace"));
            });

            for (String context : driver.getContextHandles()) {
                if (context.contains("WEBVIEW") && !context.contains("Terrace")) {
                    System.out.println("- Switching to valid context: " + context);
                    driver.context(context);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("- Non-critical: Could not switch to WebView. Error: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverFactory.cleanupDriver();
    }
}