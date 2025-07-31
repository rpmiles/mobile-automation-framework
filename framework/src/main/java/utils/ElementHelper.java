package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import driver.DriverFactory;
import pageObjects.Base_PO;

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
