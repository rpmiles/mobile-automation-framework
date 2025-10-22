package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import functions.globalFunctions;
import utils.ImageCompare;
import java.io.File;
import java.time.Duration;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;


public class TestAllControlsRM_PO extends Base_PO {

    //logo
    public @FindBy(xpath = "//modern-layout[contains(@class, 'ng-star-inserted')]//img[contains(@src, 'logo.svg')]") WebElement logo;


    //Items
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'Preformatted Text for Copy/Paste Tests')]") WebElement preformattedTextCopyPaste;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This Is Single Text')]") WebElement thisIsSingleText;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is Prefilled Text (Single)')]") WebElement singleTextPrefilled;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is Multi Text')]") WebElement thisIsMultiText;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is Prefilled Text (Multi)')]") WebElement multiTextPrefilled;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is a Date')]") WebElement thisIsDate;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is a Switch')]") WebElement thisIsSwitch;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is a Pick List')]") WebElement thisIsPicklist;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is Predefined Responses')]") WebElement thisIsPredefinedResponses;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is a Numeric')]") WebElement thisIsNumeric;
    public @FindBy(xpath = "//lib-editor-item//div[contains(text(), 'This is a Rating')]") WebElement thisIsRating;


    //Operations
    public @FindBy(id = "back-to-report-button") WebElement loadReports;
    public @FindBy(xpath = "//button[contains(@data-cy, 'back-to-editor-items-header-button')]") WebElement doneTick;


    //Multi-Text editor
    public @FindBy(className = "ql-bold") WebElement bold;
    public @FindBy(className = "ql-italic") WebElement italics;
    public @FindBy(className = "ql-underline") WebElement underline;
    public @FindBy(className = "ql-strike") WebElement strikethrough;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiText;
    public @FindBy(css = ".svg-inline--fa.fa-paragraph.fa-2xl") WebElement carriageReturn;
    public @FindBy(css = "svg[data-icon='location-crosshairs']") WebElement locationCrosshairs;


    //Single Text Field
    public @FindBy(css = "app-location div.cursor-pointer") WebElement crosshairsIcon;
    public @FindBy(xpath = "//lib-single-text//input[@matinput]") WebElement singleText;
    public @FindBy(xpath = "//button[.//mat-icon[text()='close']]") WebElement clearSingleText;


    //Date elements
    public @FindBy(xpath = "//button[@aria-label = 'Previous month']") WebElement prevMonth;
    public @FindBy(xpath = "//button[@aria-label = 'Next month']") WebElement nextMonth;
    public @FindBy(xpath = "//button[@aria-label = 'Choose month and year']") WebElement chooseMonthYear;
    public @FindBy(xpath = "//button[@aria-label = 'Next 24 years']") WebElement nextYearRange;
    public @FindBy(xpath = "//button[@aria-label = 'Previous 24 years']") WebElement prevYearRange;
    public @FindBy(xpath = "//button[@aria-label = 'Previous year']") WebElement prevYear;
    public @FindBy(xpath = "//button[@aria-label = 'Next year']") WebElement nextYear;
    public @FindBy(xpath = "//button[.//span[text()=' Clear']]") WebElement clearDate;


    //Photos
    public @FindBy(xpath = "//*[@data-icon= 'grid']") WebElement photoGrid;

    public TestAllControlsRM_PO() throws IOException, URISyntaxException {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    //Shared operations
    public void enterNotes(String notesTextToEnter) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(multiText);
            sendKeys(multiText, notesTextToEnter);
            System.out.println("Entering text");
            sendKeys(multiText, String.valueOf(Keys.ENTER));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to enter notes");
        }

    }

    public void sendCursorToEnd() throws IOException, URISyntaxException {
        sendKeys(multiText, String.valueOf(Keys.END));

    }

    public void selectDone() throws IOException, URISyntaxException {
        System.out.println("Returning to report");
        waitForWebElementAndClick(doneTick);

    }

    public void backToReports() throws IOException, URISyntaxException {
        System.out.println("Returning to reports list");
        waitForWebElementAndClick(loadReports);
    }




    //Single Text Operations
    public void selectCrosshairs() throws IOException, URISyntaxException, InterruptedException {

        //FOR SINGLE LINE TEXT BOXES
        System.out.println("Selecting crosshairs");

        waitForWebElementToBeVisible(crosshairsIcon);
        waitForWebElementAndClick(crosshairsIcon);
        Thread.sleep(2000);

    }

    public void selectThisIsSingleText() throws IOException, URISyntaxException {
        System.out.println("Selecting single text item");
        waitForWebElementAndClick(thisIsSingleText);
    }

    public void enterSingleText(String textToEnter) {
        System.out.println("Entering text into single field");
        singleText.sendKeys(textToEnter);
    }

    public void selectAllSingleText() throws IOException, URISyntaxException {
        singleText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void clearSingleTextX() {
        System.out.println("Clicking X");
        clearSingleText.click();
    }

    public void deleteAllSingleText() {
        System.out.println("Deleting text from single text field");
        singleText.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }




    //Multi Text Operations
    public void selectLocationCrosshairs() throws IOException, URISyntaxException, InterruptedException {
        try {
            //FOR MULTI LINE TEXT BOXES
            System.out.println("Selecting crosshairs icon");
            waitForWebElementAndClick(locationCrosshairs);
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to locate crosshairs icon");
        }

    }

    public void selectCarriageReturn() throws IOException, URISyntaxException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            WebElement svgIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[name()='svg' and @data-icon='arrow-down']/ancestor::div[contains(@class, 'cursor-pointer')]")
            ));
            svgIcon.click();

        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", carriageReturn);
        }
    }

    public void selectEnter() throws IOException, URISyntaxException {
        sendKeys(multiText, String.valueOf(Keys.ENTER));

    }

    public void selectMultiText() throws IOException, URISyntaxException {
        waitForWebElementAndClick(thisIsMultiText);
    }

    public void enterMultiText(String notesTextToEnter) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(thisIsMultiText);
            sendKeys(multiText, notesTextToEnter);
            System.out.println("Entering text");
            sendKeys(multiText, String.valueOf(Keys.ENTER));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to enter multi text");
        }
    }

    public void selectAllMultiText() throws IOException, URISyntaxException {
        multiText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void clearMultiText() throws IOException, URISyntaxException {
        System.out.println("Clearing multi-text field");
        multiText.clear();
    }



    //Extra Text operations
    public void addSomeExtraText(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Adding extra text: '" + text + "'");
            waitForWebElementAndClick(multiText);
            multiText.sendKeys(Keys.END);
            sendKeys(multiText, text);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to add extra text");
        }
    }

    public void deleteText(String response3) {

        try {
            System.out.println("Deleting specified text");
            String textElement = multiText.getText();
            //System.out.println("Full text: " + textElement);
            //System.out.println("Text to remove: " + response3);


            String newText = textElement.replace(response3, "").trim();
            //System.out.println("New text value: " + newText);

            multiText.clear();
            multiText.sendKeys(newText);

        } catch (NoSuchElementException e) {
            Assert.fail("Failed to remove text");
        }
    }



    //Formatting Operations
    public void selectBold() throws IOException, URISyntaxException {
        System.out.println("Entering bold text");
        waitForWebElementAndClick(bold);
    }

    public void enterBoldText(String text) throws IOException, URISyntaxException {
        System.out.println("Entering bold text");
        waitForWebElementAndClick(bold);
        sendKeys(multiText, text);
    }

    public void selectItalics() throws IOException, URISyntaxException {
        System.out.println("Entering italicised text");
        waitForWebElementAndClick(italics);
    }

    public void enterItalicsText(String text) throws IOException, URISyntaxException {
        System.out.println("Entering bold text");
        waitForWebElementAndClick(italics);
        sendKeys(multiText, text);
    }

    public void selectUnderline() throws IOException, URISyntaxException {
        System.out.println("Entering underlined text");
        waitForWebElementAndClick(underline);
    }

    public void enterUnderlinedText(String text) throws IOException, URISyntaxException {
        System.out.println("Entering bold text");
        waitForWebElementAndClick(underline);
        sendKeys(multiText, text);
    }

    public void selectStrikethrough() throws IOException, URISyntaxException {
        System.out.println("Entering strikethrough text");
        waitForWebElementAndClick(strikethrough);
    }

    public void enterStrikethroughText(String text) throws IOException, URISyntaxException {
        System.out.println("Entering bold text");
        waitForWebElementAndClick(strikethrough);
        sendKeys(multiText, text);
    }

    public void selectBulletList() throws IOException, URISyntaxException {
        try {
            System.out.println("Entering bullet list");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='bullet']")));
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select bullet list");
        }
    }

    public void selectNumList() throws IOException, URISyntaxException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='ordered']")));
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select number list");
        }
    }

    public void enterMultiFormatText() throws IOException, URISyntaxException {
        try {
            System.out.println("Entering single line multiformatted text");
            waitForWebElementAndClick(bold);
            sendKeys(multiText, "Bold text with ");
            waitForWebElementAndClick(italics);
            sendKeys(multiText, "some added italics, ");
            waitForWebElementAndClick(bold);
            waitForWebElementAndClick(underline);
            sendKeys(multiText, "added underline but removed bold, ");
            waitForWebElementAndClick(strikethrough);
            sendKeys(multiText, "completed with strikethrough ");
            waitForWebElementAndClick(bold);
            waitForWebElementAndClick(italics);
            waitForWebElementAndClick(underline);
            sendKeys(multiText, "changed with simple bold and finally ");
            waitForWebElementAndClick(bold);
            waitForWebElementAndClick(strikethrough);
            sendKeys(multiText, "removed all formatting");
        } catch (NoSuchElementException e) {
            Assert.fail("Error entering multi formatted text");
        }
    }



    //Date tests
    public WebElement requiredYear(String chosenYear) throws IOException, URISyntaxException {
        return getDriver().findElement(By.xpath("//button[@aria-label = '" + chosenYear + "']"));
    }

    public void selectYear(String selectYear) throws IOException, URISyntaxException {
        try {
            WebElement selectedYear = requiredYear(selectYear);
            System.out.println("Selecting Year: " + selectedYear);
            selectedYear.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select year");
        }
    }

    public WebElement requiredMonth(String chosenMonth) throws IOException, URISyntaxException {
        return getDriver().findElement(By.xpath("//button[.//span[contains(@class, 'mat-calendar-body-cell-content') and normalize-space(text()) = '" + chosenMonth + "']]"));
    }

    public void selectMonth(String selectMonth) throws IOException, URISyntaxException {
        try {
            WebElement selectedMonth = requiredMonth(selectMonth);
            System.out.println("Selecting Month: " + selectedMonth);
            selectedMonth.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select month");
        }
    }

    public WebElement requiredDay(String chosenDay) throws IOException, URISyntaxException {
        return getDriver().findElement(By.xpath("//button[.//span[contains(@class, 'mat-calendar-body-cell-content') and normalize-space(text()) = '" + chosenDay + "']]"));
    }

    public void selectDay(String selectDay) throws IOException, URISyntaxException {
        try {
            WebElement selectedDay = requiredDay(selectDay);
            System.out.println("Selecting Day: " + selectedDay);
            selectedDay.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select day");
        }
    }



    //Switch tests
    public void selectSwitch(String switchToSelect) throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + switchToSelect + "')]")
        ));

        By scrolledElement = By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + switchToSelect + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(scrolledElement));


        WebElement selectedSwitch = getDriver().findElement(scrolledElement);
        selectedSwitch.click();
    }

    public void switchSelected(String switchSelected) throws IOException, URISyntaxException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            List<WebElement> elements = getDriver().findElements(By.xpath("//lib-options-list-item[contains(@class, 'selected-option') and contains(., '" + switchSelected + "')]"));
            Assert.assertTrue(elements.size() > 0, "Element does not exist");
        } catch (NoSuchElementException e) {
            Assert.fail("Failed to assert " + switchSelected + " selected");
        }
    }

    public void switchNotSelected(String switchNotSelected) throws IOException, URISyntaxException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            List<WebElement> elements = getDriver().findElements(By.xpath("//lib-options-list-item[not(contains(@class, 'selected-option')) and contains(., '" + switchNotSelected + "')]"));
            Assert.assertTrue(elements.size() > 0, "Element does not exist");
        } catch (NoSuchElementException e) {
            Assert.fail("Failed to assert " + switchNotSelected + " not selected");
        }
    }



    //Picklist tests
    public void selectOption(String option) throws IOException, URISyntaxException {
        try {
            //System.out.print("Selecting Picklist item");
            WebElement actualOption = getDriver().findElement(By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + option + "')]"));
            actualOption.click();
            System.out.println("Selected " + option);

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select " + option);
        }

    }



    //Predefined Responses tests
    public void selectPredefinedResponses() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting Predefined Responses");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        By predefinedResponses = By.xpath("//div[contains(@class, 'editor-item__title') and normalize-space(text())='This is Predefined Responses']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(predefinedResponses));
        WebElement element = getDriver().findElement(predefinedResponses);

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element);

        Thread.sleep(300);


        try {
            thisIsPredefinedResponses.click();

        } catch (Exception e) {
            //System.out.println("Standard click failed, attempting JS click");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    public void selectSingleResponse(String response) throws IOException, URISyntaxException {
        try {
            System.out.println("Selecting predefined response: '" + response + "'");
            WebElement actualResponse = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//lib-options-list-item[contains(@class,'ng-star-inserted') and contains(., '" + response + "')]")
                    ));
            actualResponse.click();


        } catch (NoSuchElementException e) {
            Assert.fail("Failed to assert select predefined response");
        }
    }



    //Numeric tests
    public class DecimalTrimmer {
        public static String roundedDecimal(String expectedNumber) {

            // Convert to BigDecimal
            BigDecimal decimal = new BigDecimal(expectedNumber);

            // Round to 3 decimal places
            BigDecimal rounded = decimal.setScale(3, RoundingMode.DOWN);

            // Output the result
            System.out.println(rounded.toPlainString());  // Output: 0.123
            return rounded.toPlainString();
        }
    }

    public void sendNumericValue(String inputText) {
        try {
            System.out.println("Sending text to numeric input: " + inputText);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            By numericFieldLocator = By.cssSelector("input[numericfield]");

            // Wait until the input field is visible and enabled
            WebElement numericFieldElement = wait.until(ExpectedConditions.elementToBeClickable(numericFieldLocator));

            // Clear any existing value
            numericFieldElement.clear();

            // Send new value
            numericFieldElement.sendKeys(inputText);

            System.out.println("Successfully sent text: '" + inputText + "' to numeric field");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to send numeric input: " + e.getMessage());
        }
    }

    public void retrieveNumericValue() {
        try {
            System.out.println("Retrieving numeric input");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            By numericFieldLocator = By.cssSelector("input[numericfield]");

            // Wait until the input field is visible and enabled
            WebElement numericFieldElement = wait.until(ExpectedConditions.elementToBeClickable(numericFieldLocator));

            // Send new value
            String numericEntry = numericFieldElement.getText();

            System.out.println("Successfully retrieve numeric value: '" + numericEntry);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to send numeric input: " + e.getMessage());
        }
    }

    public class PhotoTestUtils {

        /**
         * Compare the first two photos found under //lib-photo-row with baseline images.
         *
         * @param driver             WebDriver / AppiumDriver instance
         * @param baselineFolderPath path to folder containing baseline-photo-1.png and baseline-photo-2.png
         * @param tolerancePercent   allowed percent difference (e.g. 1.0 for 1%)
         * @throws Exception on I/O or comparison failure
         */
        public static void compareFirstTwoPhotosUnderLibPhotoRow(WebDriver driver, String baselineFolderPath, double tolerancePercent) throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // find img elements inside lib-photo-row
            List<WebElement> imgs = wait.until(d -> d.findElements(By.xpath("//lib-photo-row//lib-photo//img")));
            System.out.println("DBG: found imgs = " + imgs.size());
            if (imgs.size() < 2) {
                throw new AssertionError("Expected at least 2 photos under lib-photo-row, found: " + imgs.size());
            }


            for (int i = 0; i < 2; i++) {
                WebElement img = imgs.get(i);

                // scroll into view (helps with screenshots on some drivers)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", img);

                // wait until the image element reports fully loaded (naturalWidth>0)
                wait.until(d -> ((JavascriptExecutor) d)
                        .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", img));

                // debug print src (may be blob:)
                String src = img.getAttribute("src");
                System.out.println("DBG: image[" + i + "] src = " + src);

                // baseline filename convention: baseline-photo-1.png and baseline-photo-2.png
                File baseline = new File(baselineFolderPath, String.format("baseline-photo-%d.png", i + 1));
                if (!baseline.exists()) {
                    throw new IllegalStateException("Missing baseline file: " + baseline.getAbsolutePath());
                }

                // compare element screenshot against baseline
                boolean similar = ImageCompare.imagesAreSimilarFromElement(driver, img, baseline, tolerancePercent);
                System.out.println("DBG: image[" + i + "] similar? " + similar);
                Assert.assertTrue(similar, "Image " + (i + 1) + " differs from baseline beyond tolerance");
            }

            System.out.println("All compared images are within tolerance");
        }
    }
}

