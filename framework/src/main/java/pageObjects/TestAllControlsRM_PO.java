package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ImageCompare;
import utils.globalVariables;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import javax.imageio.ImageIO;


public class TestAllControlsRM_PO extends Base_PO {


    //Phone context menu
    public @FindBy(xpath = "//button[contains(@aria-haspopup, 'menu') and not(contains(@id, 'open-report-item-list-filter'))]") WebElement phoneContextMenu;
    public @FindBy(xpath = "//button//*[@data-icon='location-crosshairs']") WebElement phoneLocation;
    public @FindBy(xpath = "//button//*[@data-icon='arrow-down']")WebElement phoneCarriageReturn;

    //Items
    public @FindBy(xpath = "//div[contains(text(), 'This is Predefined Responses')]") WebElement thisIsPredefinedResponses;
    public @FindBy(id = "confirm-button") WebElement confirmButton;

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
    public @FindBy(css = "svg[data-icon='location-crosshairs']") WebElement locationCrosshairs;


    //Single Text Field
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

    //Rating
    public @FindBy(xpath = "//div[contains(@class, 'report-item-name') and contains(., 'This is Multi Text')]") WebElement ratingHeader;

    //Numeric
    public @FindBy(xpath = "//input[@numericfield]") WebElement numericField;

    //Photos
    public @FindBy(xpath = "//*[@data-icon= 'grid']") WebElement photoGrid;

    //Tables
    public @FindBy(xpath = "//button[.//span[text()=' Add ']]") WebElement addRow;
    public @FindBy(xpath = "//button[@data-cy='back-to-editor-items-header-button']") WebElement closeRow;
    public @FindBy(xpath = "//button[contains(normalize-space(), 'Bulk Edit')]") WebElement bulkEditRowsButton;
    public @FindBy(xpath = "//button//span[text()=' Clone ']") WebElement cloneRow;
    public @FindBy(id = "confirm-button") WebElement confirmClone;
    public @FindBy(xpath = "//button[.//span[text()=' Delete ']]") WebElement deleteRow;
    public @FindBy(xpath = "//button[@data-cy='next-item-button']") WebElement scrollToNextField;
    public @FindBy(xpath = "//button[@data-cy='previous-item-button']") WebElement scrollToPrevField;


    //Images
    public static @FindBy(css = ".full-size-photo-container img") WebElement fullSizePhoto;
    public @FindBy(xpath = "//button[contains(@aria-label, 'Open menu')]") WebElement imageContextMenu;
    public @FindBy(xpath = "//button//*[@data-icon='trash-can']") WebElement imageTrash;
    public @FindBy(id = "confirm-button") WebElement confirmImageDelete;
    public @FindBy(xpath = "//lib-photo-caption//div[@contenteditable='true']") WebElement imageListCaptionBox;
    public @FindBy(xpath = "//lib-photo-caption-dialog//div[@contenteditable='true']") WebElement captionBox;
    public @FindBy(xpath = "//div[contains(@class, 'items-end')]//div[contains(@class, 'italic')]") WebElement captionLink;
    public @FindBy(xpath = "//Span[text()=' Save ']") WebElement saveCaption;


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


        //Select report view items
        public void selectPredefinedResponses() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Selecting Predefined Responses");
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


        //Shared operations
        public void selectNotes() throws IOException, URISyntaxException {
            System.out.println("- Selecting Notes");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(notesButton));
            waitForWebElementAndClickElement(notesButton);
        }

        public void enterNotes(String notesTextToEnter) throws IOException, URISyntaxException {
            try {
                waitForWebElementToBeVisible(multiText);
                sendKeys(multiText, notesTextToEnter);
                System.out.println("- Entering text");
                sendKeys(multiText, String.valueOf(Keys.ENTER));
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to enter notes");
            }

        }

        public void sendCursorToEnd() throws IOException, URISyntaxException {
            sendKeys(multiText, String.valueOf(Keys.END));
        }

        public void selectDone() throws IOException, URISyntaxException {
                System.out.println("- Returning to report");
                waitForWebElementAndClickElement(doneTick);
            }

        public void backToReports() throws IOException, URISyntaxException {
        System.out.println("- Returning to reports list");
        waitForWebElementAndClickElement(loadReports);
    }


        //Single Text Operations
        public void enterSingleTextItem(String textToEnter) {
            System.out.println("- Entering text into single field");
            singleText.sendKeys(textToEnter);
        }

        public void clearSingleTextX() throws IOException, URISyntaxException {
            System.out.println("- Clicking X");
            waitForWebElementAndClickElement(clearSingleText);
        }


        //Multi Text Operations
        public void enterMultiTextItem(String textToEnter) throws IOException, URISyntaxException {
            try {
                waitForWebElementToBeVisible(multiTextEditor);
                sendKeys(multiText, textToEnter);
                System.out.println("- Entering text");
                sendKeys(multiText, String.valueOf(Keys.ENTER));
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to enter multi text");
            }
        }

        public void selectAllMultiText() throws IOException, URISyntaxException {
            multiText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

        public void selectAllAndDeleteMultiText() throws IOException, URISyntaxException, InterruptedException {
            Thread.sleep(1000);
            System.out.println("- Selecting all text");
            multiText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            System.out.println("- Deleting text from multi text field");
            multiText.sendKeys(Keys.chord(Keys.BACK_SPACE));
        }

        public void clearMultiText() throws IOException, URISyntaxException {
            System.out.println("- Clearing multi-text field");
            multiText.clear();
        }

        public void selectMultiTextCrosshairs() throws IOException, URISyntaxException, InterruptedException {
            try {
                //FOR MULTI LINE TEXT BOXES
                System.out.println("- Selecting crosshairs icon");
                waitForWebElementAndClickElement(phoneLocation);
                Thread.sleep(2000);
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to locate crosshairs icon");
            }

        }

        public void selectMultiTextCrosshairsOn(String device) throws IOException, URISyntaxException {

            if (device.equals("phone")) {
                try {
                    System.out.println("- Selecting crosshairs icon for phone field");
                    waitForWebElementAndClickElement(phoneLocation);
                    Thread.sleep(2000);
                } catch (NoSuchElementException | InterruptedException e) {
                    Assert.fail("Unable to locate crosshairs icon");
                }

            }

            if (device.equals("tablet")) {
                try {
                    System.out.println("- Selecting crosshairs icon for tablet field");
                    waitForWebElementAndClickElement(locationCrosshairs);
                    Thread.sleep(2000);
                } catch (NoSuchElementException e) {
                    Assert.fail("Unable to locate crosshairs icon");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        public void selectMultiTextCarriageReturnButton() throws IOException, URISyntaxException {
            By arrowBtn = By.xpath(
                    "//button//*[@data-icon='arrow-down']"
            );
            System.out.println("- Selecting carriage return button");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(arrowBtn));

        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver())
                    .executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles:true}));", btn);
        }
        }

        public void selectMultiTextCarriageReturnButtonOn(String device) throws IOException, URISyntaxException {

       if (device.equals("phone")) {
            System.out.println("- Selecting context menu on phone");
            waitForWebElementAndClickElement(phoneContextMenu);
            System.out.println("- Selecting carriage return button");
            waitForWebElementAndClickElement(phoneCarriageReturn);

       }

       if (device.equals("tablet")) {
            By arrowBtn = By.xpath("//*[@data-icon='arrow-down']");
            System.out.println("- Selecting carriage return button on tablet");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            waitForWebElementAndClickBy(arrowBtn);

       }

    }

        public void selectToolbarContextButtonOn(String device) throws IOException, URISyntaxException {

        if (device.equals("phone")) {
            System.out.println("- Selecting context menu on phone");
            waitForWebElementAndClickElement(phoneContextMenu);
        }

        if (device.equals("tablet")) {
            System.out.println("- Selecting context menu on tablet");
        }
    }

        public void selectMultiTextEnterKey() throws IOException, URISyntaxException {
            sendKeys(multiText, String.valueOf(Keys.ENTER));
        }


        //Extra Text operations
        public void deleteSpecificText(String textToDelete, String item) {

            try {
                System.out.println("- Deleting specified text from " + item);
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
            System.out.println("- Selecting Bold");
            waitForWebElementAndClickElement(bold);
        }

        public void enterBoldText(String text) throws IOException, URISyntaxException {
            System.out.println("- Entering bold text");
            waitForWebElementAndClickElement(bold);
            sendKeys(multiText, text);
        }

        public void selectItalics() throws IOException, URISyntaxException {
            System.out.println("- Selecting Italics");
            waitForWebElementAndClickElement(italics);
        }

        public void enterItalicsText(String text) throws IOException, URISyntaxException {
            System.out.println("- Entering italics text");
            waitForWebElementAndClickElement(italics);
            sendKeys(multiText, text);
        }

        public void selectUnderline() throws IOException, URISyntaxException {
            System.out.println("- Selecting Underlined");
            waitForWebElementAndClickElement(underline);
        }

        public void enterUnderlinedText(String text) throws IOException, URISyntaxException {
            System.out.println("- Entering underlined text");
            waitForWebElementAndClickElement(underline);
            sendKeys(multiText, text);
        }

        public void selectStrikethrough() throws IOException, URISyntaxException {
            System.out.println("- Selecting Strikethrough");
            waitForWebElementAndClickElement(strikethrough);
        }

        public void enterStrikethroughText(String text) throws IOException, URISyntaxException {
            System.out.println("- Entering strikethrough text");
            waitForWebElementAndClickElement(strikethrough);
            sendKeys(multiText, text);
        }

        public void enterMultiFormatText() throws IOException, URISyntaxException {
            try {
                System.out.println("- Entering single line multiformatted text");
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
                System.out.println("- Selecting bullet list");
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='bullet']")));
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to select bullet list");
            }
        }

        public void selectNumList() throws IOException, URISyntaxException {
            try {
                System.out.println("- Selecting number list");
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
                System.out.println("- Selecting Year: " + selectedYear);
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
                System.out.println("- Selecting Month: " + selectedMonth);
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
                System.out.println("- Selecting Day: " + selectedDay);
                selectedDay.click();
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to select day");
            }
        }



        //Switch & Picklist tests
        public void selectOption(String option) throws IOException, URISyntaxException {
            try {
                //System.out.print("Selecting Picklist item");
                By actualOptionLocator = By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(., '" + option + "')]");
                waitForWebElementAndClickBy(actualOptionLocator);
                System.out.println("- Selected " + option);
                Thread.sleep(1000);

            } catch (NoSuchElementException e) {
                Assert.fail("Unable to select " + option);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


        //Predefined Responses tests
        public void selectSingleResponse(String response) throws IOException, URISyntaxException {
            try {
                System.out.println("- Selecting predefined response: '" + response + "'");
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
        public void selectNumericButton(String value) throws IOException, URISyntaxException {
            try {
                System.out.println("- Selecting numeric button " + value);

                WebElement button = getDriver().findElement(
                        By.xpath("//lib-options-list-item//*[text()=' " + value +  " ']")
                );

                button.click();

            } catch (NoSuchElementException e) {
                Assert.fail("Failed to select button");
            }
        }

        public void sendNumericValue(String inputText) {
            try {
                System.out.println("- Sending text to numeric input: " + inputText);

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                By numericFieldLocator = By.cssSelector("input[numericfield]");

                // Wait until the input field is visible and enabled
                WebElement numericFieldElement = wait.until(ExpectedConditions.elementToBeClickable(numericFieldLocator));

                // Clear any existing value
                numericFieldElement.clear();

                // Send new value
                numericFieldElement.sendKeys(inputText);

                System.out.println("- Successfully sent text: '" + inputText + "' to numeric field");

            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Failed to send numeric input: " + e.getMessage());
            }
        }


        //Photos
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
            System.out.println("- DBG: found imgs = " + imgs.size());
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

            System.out.println("- All compared images are within tolerance");
        }
    }

        public static class SimpleImageValidator {

            public void verifyImage(WebDriver driver, WebElement imageElement, String expectedFileName) throws Exception {

                File expectedFile = new File("src/test/resources/" + expectedFileName);

                if (!expectedFile.exists()) {
                    throw new java.io.FileNotFoundException("ERROR: Cannot find the baseline image at: " + expectedFile.getAbsolutePath());
                }

                // Download the actual source file using JS
                BufferedImage actualImg = downloadImageDirectly(driver, imageElement);
                BufferedImage expectedImg = ImageIO.read(expectedFile);

                if (actualImg == null || expectedImg == null) {
                    throw new RuntimeException("Failed to parse one of the images.");
                }

                // --- Handle EXIF Auto-Rotation ---
                if (actualImg.getWidth() == expectedImg.getHeight() && actualImg.getHeight() == expectedImg.getWidth()) {
                    System.out.println("- Dimensions are perfectly swapped! Auto-rotating expected image 90 degrees...");
                    expectedImg = rotateImage90Degrees(expectedImg);
                }

                // --- START OF DEBUGGING CODE ---
                try {
                    System.out.println("\n--- IMAGE DEBUG INFO ---");
                    System.out.println("Expected Dimensions: " + expectedImg.getWidth() + "x" + expectedImg.getHeight());
                    System.out.println("Actual Dimensions  : " + actualImg.getWidth() + "x" + actualImg.getHeight());

                    File debugActual = new File("DEBUG_actual_downloaded.png");
                    ImageIO.write(actualImg, "png", debugActual);

                    File debugExpected = new File("DEBUG_expected_baseline.png");
                    ImageIO.write(expectedImg, "png", debugExpected);
                    System.out.println("DEBUG files saved to project root.");
                    System.out.println("------------------------\n");
                } catch (Exception e) {
                    System.out.println("Failed to write debug images: " + e.getMessage());
                }
                // --- END OF DEBUGGING CODE ---

                // Compare (Allowing up to a 3.0% difference in pixels)
                if (!imagesMatchWithTolerance(actualImg, expectedImg, 8.0)) {
                    throw new AssertionError("The images do not match! Check the DEBUG files in your project root.");
                }
            }

            // Helper method to rotate an image 90 degrees clockwise
            private BufferedImage rotateImage90Degrees(BufferedImage img) {
                int width = img.getWidth();
                int height = img.getHeight();

                // Swap width and height for the new canvas
                BufferedImage rotatedImg = new BufferedImage(height, width, img.getType());
                Graphics2D g2d = rotatedImg.createGraphics();

                // Pivot the image 90 degrees counter-clockwise
                g2d.translate(0, width);
                g2d.rotate(-Math.PI / 2);
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();

                return rotatedImg;
            }

            // This forces the browser to fetch the raw file from the src URL and return it as Base64 data
            private BufferedImage downloadImageDirectly(WebDriver driver, WebElement imageElement) throws Exception {
                String script =
                        "var img = arguments[0];" +
                                "var callback = arguments[arguments.length - 1];" +
                                "fetch(img.src)" +
                                "  .then(response => response.blob())" +
                                "  .then(blob => {" +
                                "      var reader = new FileReader();" +
                                "      reader.onloadend = () => callback(reader.result);" +
                                "      reader.readAsDataURL(blob);" +
                                "  })" +
                                "  .catch(error => callback('ERROR'));";

                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                String dataUrl = (String) js.executeAsyncScript(script, imageElement);

                if (dataUrl == null || dataUrl.startsWith("ERROR")) {
                    throw new RuntimeException("Failed to download the actual image source from the browser.");
                }

                String base64Data = dataUrl.substring(dataUrl.indexOf(",") + 1);
                byte[] imageBytes = Base64.getDecoder().decode(base64Data);
                return ImageIO.read(new ByteArrayInputStream(imageBytes));
            }

            private boolean imagesMatchExactly(BufferedImage img1, BufferedImage img2) {
                if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
                    return false;
                }

                for (int y = 0; y < img1.getHeight(); y++) {
                    for (int x = 0; x < img1.getWidth(); x++) {
                        if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                            return false;
                        }
                    }
                }
                return true;
            }

            private boolean imagesMatchWithTolerance(BufferedImage img1, BufferedImage img2, double allowedDifferencePercent) {
                if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
                    System.out.println("Dimensions do not match!");
                    return false;
                }

                long diffPixels = 0;
                long totalPixels = (long) img1.getWidth() * img1.getHeight();

                for (int y = 0; y < img1.getHeight(); y++) {
                    for (int x = 0; x < img1.getWidth(); x++) {
                        int rgb1 = img1.getRGB(x, y);
                        int rgb2 = img2.getRGB(x, y);

                        // Extract the Red, Green, and Blue values for both pixels
                        int r1 = (rgb1 >> 16) & 0xff;
                        int g1 = (rgb1 >> 8) & 0xff;
                        int b1 = rgb1 & 0xff;

                        int r2 = (rgb2 >> 16) & 0xff;
                        int g2 = (rgb2 >> 8) & 0xff;
                        int b2 = rgb2 & 0xff;

                        // Calculate how far apart the colors are (max possible difference is 255 * 3 = 765)
                        int colorDifference = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);

                        // If the color is off by more than a tiny margin (e.g., 15/765), flag the pixel as different
                        if (colorDifference > 15) {
                            diffPixels++;
                        }
                    }
                }

                // Calculate the total percentage of mismatched pixels
                double diffPercent = ((double) diffPixels / totalPixels) * 100.0;
                System.out.println("- Image variance: " + String.format("%.2f", diffPercent) + "%");

                return diffPercent <= allowedDifferencePercent;
            }
        }

        public void selectImageContextMenu() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(imageContextMenu);
        }

        public void deleteImage() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(imageTrash);
        }

        public void confirmImageDelete() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(confirmImageDelete);
        }

        public void confirmPhotoGridNotPresent() throws IOException, URISyntaxException {
            List<WebElement> photoGrid = getDriver().findElements(By.xpath("//*[@data-icon= 'grid']"));
            Assert.assertTrue(photoGrid.isEmpty(), "Expected report date field to be visible.");
        }

        public void enterCaptionImageList(String caption) throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(imageListCaptionBox);
            sendKeys(imageListCaptionBox, caption);
        }

        public void deleteCaptionImageList() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(imageListCaptionBox);
            imageListCaptionBox.clear();
        }

        public void enterCaption(String caption) throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(captionBox);
            sendKeys(captionBox, caption);
            saveCaption.click();
        }

        public void selectCaptionLink() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(captionLink);
        }

        public void confirmCaptionImageList(String caption) throws IOException, URISyntaxException {
            String displayedText = imageListCaptionBox.getText();
            Assert.assertTrue(displayedText.contains(caption),
                    "Expected text not found! Found: '" + displayedText + "'");
        }

        public void deletecaptionBox() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(captionBox);
            captionBox.clear();
            saveCaption.click();
        }

        public void confirmImageListCaptionNotPresent() throws IOException, URISyntaxException {
            String existingText = imageListCaptionBox.getText().trim();
            Assert.assertTrue(existingText.isEmpty(), "Error: The editable div still contained text: '" + existingText + "'");
        }




    //Tables
        public void selectTableEntry(String column, int row) {

        int actualRow = row - 1;

        try {
            String dynamicXPath = "//div[@row-id='" + actualRow + "']//div[@col-id='" + column + "']";

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

            // 1. Wait for the element to exist in the DOM (even if it's off-screen)
            WebElement cell = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", cell);
            waitForWebElementAndClickElement(cell);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }



        public void closeRow() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(closeRow);

    }

        public void bulkEditRows() throws IOException, URISyntaxException {
            waitForWebElementAndClickElement(bulkEditRowsButton);

        }

        public void cloneRows() throws IOException, URISyntaxException, InterruptedException {
            waitForWebElementAndClickElement(cloneRow);
            Thread.sleep(500);
            waitForWebElementAndClickElement(confirmClone);
        }

        public void filterBy(String filter) throws IOException, URISyntaxException {

            WebElement button = getDriver().findElement(
                    By.xpath("//mat-radio-button//label[text()=' " + filter + " ')]")
            );
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();

        }

        public void deleteRow() throws IOException, URISyntaxException, InterruptedException {
            waitForWebElementAndClickElement(deleteRow);
            Thread.sleep(500);
            waitForWebElementAndClickElement(confirmClone);
        }

        public void scrollToNext() throws IOException, URISyntaxException, InterruptedException {
            waitForWebElementAndClickElement(scrollToNextField);
    }

        public void scrollToPrev() throws IOException, URISyntaxException, InterruptedException {
            waitForWebElementAndClickElement(scrollToPrevField);
        }

}

