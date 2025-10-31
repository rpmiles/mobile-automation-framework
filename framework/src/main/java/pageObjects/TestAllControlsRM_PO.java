package pageObjects;

import io.cucumber.java.en.And;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public @FindBy(xpath = "//div[contains(text(), 'Preformatted Text for Copy/Paste Tests')]") WebElement preformattedTextCopyPaste;
    public @FindBy(xpath = "//div[contains(text(), 'This Is Single Text')]") WebElement thisIsSingleText;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Single)')]") WebElement singleTextPrefilled;
    public @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]") WebElement thisIsMultiText;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Multi)')]") WebElement multiTextPrefilled;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Date')]") WebElement thisIsDate;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Switch')]") WebElement thisIsSwitch;
    public @FindBy(xpath = "//div[contains(text(), 'Single Select Pick List')]") WebElement singleSelectPicklist;
    public @FindBy(xpath = "//div[contains(text(), 'Multi Select Pick List')]") WebElement multiSelectPicklist;
    public @FindBy(xpath = "//div[contains(text(), 'This is Predefined Responses')]") WebElement thisIsPredefinedResponses;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Numeric')]") WebElement thisIsNumeric;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Rating')]") WebElement thisIsRating;


    //Operations
    public @FindBy(id = "back-to-report-button") WebElement loadReports;
    public @FindBy(xpath = "//button[contains(@data-cy, 'back-to-editor-items-header-button')]") WebElement doneTick;
    public @FindBy(xpath = "//span[contains(@class, 'note-icon text-on-primary')]") WebElement notesButton;

    //Multi-Text editor
    public @FindBy(className = "ql-editor") WebElement multiTextEditor;
    public @FindBy(className = "ql-bold") WebElement bold;
    public @FindBy(className = "ql-italic") WebElement italics;
    public @FindBy(className = "ql-underline") WebElement underline;
    public @FindBy(className = "ql-strike") WebElement strikethrough;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiText;
    public @FindBy(css = ".svg-inline--fa.fa-paragraph.fa-2xl") WebElement carriageReturn;
    public @FindBy(css = "svg[data-icon='location-crosshairs']") WebElement locationCrosshairs;


    //Single Text Field
    public @FindBy(css = "app-location div.cursor-pointer") WebElement singleCrosshairsIcon;
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


        //Input commands
        public void selectEnter() throws IOException, URISyntaxException {
            sendKeys(multiText, String.valueOf(Keys.ENTER));

        }

        public void selectBackspace() throws IOException, URISyntaxException {
            sendKeys(multiText, String.valueOf(Keys.BACK_SPACE));

        }


        //Select an item
        @And("I select item {string}")
        public void i_select_item(String item) throws IOException, URISyntaxException, InterruptedException {
            By element = By.xpath("//div[contains(text(), '" + item +  "')]");

            waitForWebElementAndClickBy(element);
        }


        //Select report view items
        public void selectThisIsSingleText() throws IOException, URISyntaxException {
            System.out.println("Selecting single text item");
            waitForWebElementAndClickElement(thisIsSingleText);
        }

        public void selectThisIsMultiText() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(thisIsMultiText);
        }

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

        public void selectPreformattedText() throws IOException, URISyntaxException {
            System.out.println("Selecting Preformatted Text for Copy/Paste Tests item");
            waitForWebElementAndClickElement(preformattedTextCopyPaste);
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
            waitForWebElementAndClickElement(doneTick);

        }

        public void backToReports() throws IOException, URISyntaxException {
            System.out.println("Returning to reports list");
            waitForWebElementAndClickElement(loadReports);
        }

        public void selectNotes() throws IOException, URISyntaxException {
            System.out.println("Selecting Notes");
            waitForWebElementAndClickElement(notesButton);
        }


        //Single Text Operations
        public void selectSingleTextCrosshairs() throws IOException, URISyntaxException, InterruptedException {

            System.out.println("Selecting single text line crosshairs");

            waitForWebElementToBeVisible(singleCrosshairsIcon);
            waitForWebElementAndClickElement(singleCrosshairsIcon);
            Thread.sleep(2000);

        }

        public void enterSingleTextItem(String textToEnter) {
            System.out.println("Entering text into single field");
            singleText.sendKeys(textToEnter);
        }

        public void selectAllSingleText() throws IOException, URISyntaxException {
            singleText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

        public void selectAllAndDeleteSingleText() throws IOException, URISyntaxException {
            System.out.println("Selecting all text");
            singleText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            System.out.println("Deleting text from single text field");
            singleText.sendKeys(Keys.chord(Keys.BACK_SPACE));
        }

        public void clearSingleTextX() {
            System.out.println("Clicking X");
            clearSingleText.click();
        }



        //Multi Text Operations
        public void enterMultiTextItem(String textToEnter) throws IOException, URISyntaxException {
            try {
                waitForWebElementToBeVisible(multiTextEditor);
                sendKeys(multiText, textToEnter);
                System.out.println("Entering text");
                sendKeys(multiText, String.valueOf(Keys.ENTER));
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to enter multi text");
            }
        }

        public void selectAllMultiText() throws IOException, URISyntaxException {
            multiText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

        public void selectAllAndDeleteMultiText() throws IOException, URISyntaxException {
            System.out.println("Selecting all text");
            multiText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            System.out.println("Deleting text from multi text field");
            multiText.sendKeys(Keys.chord(Keys.BACK_SPACE));
        }

        public void clearMultiText() throws IOException, URISyntaxException {
            System.out.println("Clearing multi-text field");
            multiText.clear();
        }

        public void selectMultiTextCrosshairs() throws IOException, URISyntaxException, InterruptedException {
            try {
                //FOR MULTI LINE TEXT BOXES
                System.out.println("Selecting crosshairs icon");
                waitForWebElementAndClickElement(locationCrosshairs);
                Thread.sleep(2000);
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to locate crosshairs icon");
            }

        }

        public void selectMultiTextCarriageReturnButton() throws IOException, URISyntaxException {
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

        public void selectMultiTextEnterButton() throws IOException, URISyntaxException {
            sendKeys(multiText, String.valueOf(Keys.ENTER));
        }


        //Extra Text operations
        public void deleteSpecificText(String textToDelete) {

            try {
                System.out.println("Deleting specified text");
                String textElement = multiText.getText();
                //System.out.println("Full text: " + textElement);
                //System.out.println("Text to remove: " + response3);


                String newText = textElement.replace(textToDelete, "").trim();
                //System.out.println("New text value: " + newText);

                multiText.clear();
                multiText.sendKeys(newText);

            } catch (NoSuchElementException e) {
                Assert.fail("Failed to remove text");
            }
        }


        //Formatting Operations

        public void selectBold() throws IOException, URISyntaxException {
            System.out.println("Selecting Bold");
            waitForWebElementAndClickElement(bold);
        }

        public void enterBoldText(String text) throws IOException, URISyntaxException {
            System.out.println("Entering bold text");
            waitForWebElementAndClickElement(bold);
            sendKeys(multiText, text);
        }

        public void selectItalics() throws IOException, URISyntaxException {
            System.out.println("Selecting Italics");
            waitForWebElementAndClickElement(italics);
        }

        public void enterItalicsText(String text) throws IOException, URISyntaxException {
            System.out.println("Entering bold text");
            waitForWebElementAndClickElement(italics);
            sendKeys(multiText, text);
        }

        public void selectUnderline() throws IOException, URISyntaxException {
            System.out.println("Selecting Underlined");
            waitForWebElementAndClickElement(underline);
        }

        public void enterUnderlinedText(String text) throws IOException, URISyntaxException {
            System.out.println("Entering bold text");
            waitForWebElementAndClickElement(underline);
            sendKeys(multiText, text);
        }

        public void selectStrikethrough() throws IOException, URISyntaxException {
            System.out.println("Selecting Strikethrough");
            waitForWebElementAndClickElement(strikethrough);
        }

        public void enterStrikethroughText(String text) throws IOException, URISyntaxException {
            System.out.println("Entering strikethrough text");
            waitForWebElementAndClickElement(strikethrough);
            sendKeys(multiText, text);
        }

        public void enterMultiFormatText() throws IOException, URISyntaxException {
            try {
                System.out.println("Entering single line multiformatted text");
                waitForWebElementAndClickElement(bold);
                sendKeys(multiText, "Bold text with ");
                waitForWebElementAndClickElement(italics);
                sendKeys(multiText, "some added italics, ");
                waitForWebElementAndClickElement(bold);
                waitForWebElementAndClickElement(underline);
                sendKeys(multiText, "added underline but removed bold, ");
                waitForWebElementAndClickElement(strikethrough);
                sendKeys(multiText, "completed with strikethrough ");
                waitForWebElementAndClickElement(bold);
                waitForWebElementAndClickElement(italics);
                waitForWebElementAndClickElement(underline);
                sendKeys(multiText, "changed with simple bold and finally ");
                waitForWebElementAndClickElement(bold);
                waitForWebElementAndClickElement(strikethrough);
                sendKeys(multiText, "removed all formatting");
            } catch (NoSuchElementException e) {
                Assert.fail("Error entering multi formatted text");
            }
        }

        public void selectBulletList() throws IOException, URISyntaxException {
            try {
                System.out.println("Selecting bullet list");
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='bullet']")));
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to select bullet list");
            }
        }

        public void selectNumList() throws IOException, URISyntaxException {
            try {
                System.out.println("Selecting number list");
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='ordered']")));
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to select number list");
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
            public String roundedDecimal(String expectedNumber) {

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


        //Rating tests

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

