package utils;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Base_PO;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public class globalVariables {
    public static final int DEFAULT_EXPLICIT_TIMEOUT = 30;
    public static final int SYNC_WAIT_TIMEOUT = 180;

    public static final String mobilePortalHomepageURL = "https://mobile.test-goreport.services/";
    public static String adminUser = "admin@beta.com";
    public static String adminPsw = "Run my testing decisively@1";
    //public static String adminUser = "russell.miles+richard_watterson@goreport.com";
    //public static String adminPsw = "(Richard.Watterson1)";
    //public static String adminUser = "russell.miles@goreport.com";
    //public static String adminPsw = "((Password.1))";
    public static String standardUser = "user@beta.com";
    public static String standardPsw = "run my testing decisively";
    //public static String releaseVersion = "202568";
    public static String releaseVersion = "20250826-0";


    public class ElementHelper extends Base_PO {

        private WebDriver driver;
        private WebDriverWait wait;

        public ElementHelper() throws MalformedURLException, URISyntaxException {
            this.driver = DriverFactory.getDriver(); // get from driver factory
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        /**
         * Angular-aware click: waits for Angular to be stable and attempts a click with JS fallback.
         */
        public void waitForAngularAndClick(WebElement element) {
            try {
                // Wait for Angular stability
                wait.until(d -> {
                    try {
                        return (Boolean) ((JavascriptExecutor) d)
                                .executeScript("return window.getAllAngularTestabilities && window.getAllAngularTestabilities()[0].isStable();");
                    } catch (Exception e) {
                        return true; // Ignore if Angular not available
                    }
                });

                // Scroll to element
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

                // Wait for clickability and click
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                System.out.println("Clicked element using standard click.");
            } catch (Exception e) {
                System.out.println("Standard click failed, using JavaScript click.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        }

        /**
         * Waits until a field has a non-empty value and returns it.
         */
        public String waitForNonEmptyValue(WebElement element) {
            wait.until(d -> {
                String value = element.getAttribute("value");
                return value != null && !value.trim().isEmpty();
            });
            return element.getAttribute("value");
        }

    }
}






