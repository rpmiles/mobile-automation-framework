package pageObjects;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.globalVariables;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

import utils.globalVariables.*;

public class Base_PO {

    public void initElements() throws IOException, URISyntaxException {
        //System.out.println("Basepage constructor called");
        if (DriverFactory.getDriver() != null) {
            PageFactory.initElements(DriverFactory.getDriver(), this);
        } else {
            throw new IllegalStateException("Driver is not initialized yet");
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
        System.out.println("Sendking keys to " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);

    }

    public void waitForWebElementAndClickElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("Clicking " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForWebElementAndClickBy(By locator) throws IOException, URISyntaxException {
        System.out.println("Clicking element located by: " + locator);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elem.click();
    }


    public void waitForWebElementToBeVisible(WebElement element) throws IOException, URISyntaxException {
        System.out.println("Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForSyncFinish(WebElement element) throws IOException, URISyntaxException {
        System.out.println("Waiting for sync to complete");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Sync complete");
    }

    public void waitForWebElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAngularWebElement(WebElement element) throws IOException, URISyntaxException {
        System.out.println("Waiting for " + element);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(d -> (Boolean)((JavascriptExecutor)d).executeScript(
                "return window.getAllAngularTestabilities ? window.getAllAngularTestabilities().every(x=>x.isStable()) : true"
        ));
    }

    public void waitForAngularBy(By locator) throws IOException, URISyntaxException {
        System.out.println("Waiting for Angular and element: " + locator);

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

}

