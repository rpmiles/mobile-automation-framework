package stepDefinitions.base;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.PrintStream;
import java.util.logging.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

import static driver.DriverFactory.*;
import static utils.globalVariables.mobilePortalHomepageURL;


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
            // else: filter out the message silently
        }

        @Override
        public void print(String s) {
            if (shouldPrint(s)) {
                original.print(s);
            }
        }

        private boolean shouldPrint(String message) {
            if (message == null) return true;
            // Filter out unwanted messages here (case-insensitive)
            String lower = message.toLowerCase();

            // Filter Clicking logs
            if (lower.contains("clicking") && lower.contains("androiddriver")) {
                return false;
            }

            // Filter Clicking Proxy logs
            if (lower.contains("clicking proxy")) {
                return false;
            }

            // Filter Sending keys logs
            if (lower.contains("sendkeys") || lower.contains("sendking keys")) {
                return false;
            }

            // Filter Waiting logs (like ExpectedCondition waits)
            if (lower.contains("waiting for") || lower.contains("waited for")) {
                return false;
            }

            // Filter androidDriver logs
            if (lower.contains("androiddriver")) {
                return false;
            }

            return true;
        }
    }


    @Before
    public void setup() throws IOException, URISyntaxException {
        System.setOut(new SystemOutFilter(System.out));
        DriverFactory.getDriver();
        getDriver().get(mobilePortalHomepageURL);
        switchToWebView();
    }

    private void switchToWebView() throws MalformedURLException, URISyntaxException {
        AndroidDriver driver = DriverFactory.getDriver();

        // Wait for the WebView to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d -> {
            Set<String> contexts = driver.getContextHandles();
            System.out.println("Available contexts: " + contexts);
            return contexts.stream().anyMatch(c -> c.toLowerCase().contains("webview"));
        });

        // Switch to the WEBVIEW context
        for (String context : driver.getContextHandles()) {
            System.out.println("Checking context: " + context);
            if (context.toLowerCase().contains("webview")) {
                try {
                    driver.context(context);
                    System.out.println("Switched to context: " + context);
                } catch (Exception e) {
                    System.out.println("Failed to switch context: " + e.getMessage());
                }
                break;
            }
        }
    }



    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        DriverFactory.cleanupDriver();
    }
}