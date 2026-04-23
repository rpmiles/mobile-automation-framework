package functions;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.ElementHelper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import driver.DriverFactory;


public class globalFunctions extends Base_PO {

    ElementHelper helper = new ElementHelper();

    public globalFunctions() throws MalformedURLException, URISyntaxException {
    }


    public void scrollAndSelectReportViewRatingValue(String option)  throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting report view rating " + option);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(

                By.xpath("//lib-rating[contains(@class,'ng-star-inserted')]//span[text()='" + option + "']")
        ));


        By scrolledRating = By.xpath("//lib-rating[contains(@class,'ng-star-inserted')]//span[text()='" + option + "']");
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

    public void scrollAndSelectTableFieldValue(String option)  throws IOException, URISyntaxException, InterruptedException  {
        System.out.println("Performing scroll and select to item: '" + option + "'");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(

                By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + option + "')]")
        ));

        By scrolledOption = By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + option + "')]"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledOption));


        WebElement selectElement = getDriver().findElement(scrolledOption);

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

    public void scrollAndSelectRowCheckbox(int rowIndex) throws IOException, URISyntaxException {
        System.out.println("Performing scroll and select to row index: " + rowIndex);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        int adjustedRowIndex = rowIndex -1;

        By checkboxLocator = By.xpath("//div[@row-index='" + adjustedRowIndex + "']//input[@type='checkbox']");

        WebElement checkboxElement = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxLocator));

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", checkboxElement);

        try {
            checkboxElement.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", checkboxElement);
        }
    }

    public static String reportDateGenerator(String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        if ("TODAY".equalsIgnoreCase(dateInput)) {
            return LocalDate.now().format(formatter);
        } else if ("ONEWEEK".equalsIgnoreCase(dateInput)) {
            return LocalDate.now().plusWeeks(1).format(formatter);
        } else if ("TWOWEEK".equalsIgnoreCase(dateInput)) {
            return LocalDate.now().plusWeeks(2).format(formatter);
        }

        // Otherwise, return as-is
        return dateInput;
    }

    public static String jsRetriever(WebElement element) throws MalformedURLException, URISyntaxException {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

        String retrievedValue = (String) js.executeScript("return arguments[0].value;", element);

        return retrievedValue;

    }

    public static class DateHelper {
        public static String getFormattedDate() {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
            return today.format(formatter);
        }
    }

}
