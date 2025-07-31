package functions;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.ElementHelper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;


public class globalFunctions extends Base_PO {


    Login_PO login_po;
    Homepage_PO homepage_po;
    CreateReport_PO createReport_po;
    TestAllControlsRM_PO testAllControlsRM_po;
    ElementHelper helper = new ElementHelper();

    public globalFunctions() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        homepage_po = new Homepage_PO();
        homepage_po.initElements();
    }


    //Element Helper - Call using helper.waitForAngularAndClick(element);


    // Login function
    public void login() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Logging in");
        login_po.navigateTo_Mobile_Portal();
        login_po.setUserName();
        login_po.setPassword();
        login_po.clickSignIn();

    }


    public void scrollAndSelectReportItems(String elementText) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Performing scroll and select to item: '" + elementText + "'");


            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//lib-editor-item//div[contains(@class, 'editor-item__title')and contains(text(), '" + elementText + "')]")
            ));

            By scrolledElement = By.xpath("//lib-editor-item//div[contains(@class, 'editor-item__title')and contains(text(), '" + elementText + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledElement));


            WebElement selectElement = getDriver().findElement(scrolledElement);

            // Scroll into view using JavaScript
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", selectElement);
            Thread.sleep(300);

            // Try normal click, fallback to JS click
            try {
                selectElement.click();
            } catch (Exception e) {
                System.out.println("Standard click failed, attempting JS click");
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
            }

    }

    public void scrollAndSelectNumeric(String numericValue)  throws IOException, URISyntaxException, InterruptedException  {
        System.out.println("Performing scroll and select to item: '" + numericValue + "'");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(text(), '" + numericValue + "')]")
        ));

        By scrolledNumeric = By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(text(), '" + numericValue + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledNumeric));


        WebElement selectElement = getDriver().findElement(scrolledNumeric);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", selectElement);
        Thread.sleep(300);

        // Try normal click, fallback to JS click
        try {
            selectElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
        }
    }

    public void scrollAndSelectReportViewRatingValue(String option)  throws IOException, URISyntaxException, InterruptedException {
            System.out.println("Selecting report view rating " + option);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(

                    By.xpath("//lib-editor-item[@class='ng-star-inserted']//span[text()='" + option + "']")
            ));


            By scrolledRating = By.xpath("//lib-editor-item[@class='ng-star-inserted']//span[text()='" + option + "']");
            System.out.println("ScrolledRating value " + scrolledRating);
            wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledRating));

            WebElement selectElement = getDriver().findElement(scrolledRating);
            System.out.println("Selecting rating value " + selectElement);

            // Scroll into view using JavaScript
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", selectElement);

            Thread.sleep(300);

            // Try normal click, fallback to JS click
            try {
                selectElement.click();
            } catch (Exception e) {
                System.out.println("Standard click failed, attempting JS click");
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
            }


    }

    public void scrollAndSelectItemViewRatingValue(String option)  throws IOException, URISyntaxException, InterruptedException  {
        System.out.println("Performing scroll and select to item: '" + option + "'");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(

                By.xpath("//lib-rating-view[contains(@class, 'ng-star-inserted')]//span[contains(text(), '" + option + "')]")
        ));

        By scrolledRating = By.xpath("//lib-rating-view[contains(@class, 'ng-star-inserted')]//span[contains(text(), '" + option + "')]"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledRating));


        WebElement selectElement = getDriver().findElement(scrolledRating);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", selectElement);
        Thread.sleep(300);

        // Try normal click, fallback to JS click
        try {
            selectElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
        }
    }

    public void scrollAndSelectMultiItemViewRatingValue(String option)  throws IOException, URISyntaxException, InterruptedException  {
        System.out.println("Performing scroll and select to item: '" + option + "'");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(

                By.xpath("//lib-rating[contains(@class, 'ng-star-inserted')]//span[contains(@class, 'rating-option-title') and normalize-space(text())='" + option + "']")
        ));

        By scrolledRating = By.xpath("//lib-rating[contains(@class, 'ng-star-inserted')]//span[contains(@class, 'rating-option-title') and normalize-space(text())='" + option + "']"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledRating));


        WebElement selectElement = getDriver().findElement(scrolledRating);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", selectElement);
        Thread.sleep(300);

        // Try normal click, fallback to JS click
        try {
            selectElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
        }
    }

    public void scrollAndSelectItemViewRatingValueMultiText(String option)  throws IOException, URISyntaxException, InterruptedException  {
        System.out.println("Performing scroll and select to item: '" + option + "'");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(

                By.xpath("//lib-rating-view[contains(@class, 'ng-star-inserted')]//span[contains(text(), '" + option + "')]")
        ));

        By scrolledRating = By.xpath("//lib-rating-view[contains(@class, 'ng-star-inserted')]//span[contains(text(), '" + option + "')]"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledRating));


        WebElement selectElement = getDriver().findElement(scrolledRating);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", selectElement);
        Thread.sleep(300);

        // Try normal click, fallback to JS click
        try {
            selectElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
        }
    }

    public void scrollAndSelectHomepage(String buttonXpath)  throws IOException, URISyntaxException, InterruptedException  {
        //System.out.println("Performing scroll and select to item: '" + option + "'");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXpath)
        ));

        By scrolledRating = By.xpath(buttonXpath);

        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledRating));


        WebElement selectElement = getDriver().findElement(scrolledRating);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", selectElement);
        Thread.sleep(300);

        // Try normal click, fallback to JS click
        try {
            selectElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectElement);
        }
    }

}
