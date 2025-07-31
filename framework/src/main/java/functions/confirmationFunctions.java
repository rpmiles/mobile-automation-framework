package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertTrue;

public class confirmationFunctions extends Base_PO {

    public @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and @spellcheck='false']") WebElement extractedTextField;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiTextItem;
    public @FindBy(xpath = "//lib-single-text//input[contains(@class, 'text')]") WebElement singleText;


    private String boldText = "This is bold text";
    private String italicsText = "This is italicized text";
    private String underlineText = "This is underlined text";
    private String strikethroughText = "This is strikethrough text";
    private String multiFormat = "//p[.//strong and .//u and .//em[contains(text(), 'needs')] and .//em[contains(text(), 'slightly longer')]]";
    private String bullet1Text = "Bullet list entry 1";
    private String bullet2Text = "Bullet list entry 2";
    private String bullet3Text = "Bullet list entry 3";
    private String numlist1Text = "Number list entry 1";
    private String numlist2Text = "Number list entry 2";
    private String numlist3Text = "Number list entry 3";
    private String actualValue;

    //Ratings
    public @FindBy(xpath = "//lib-read-only-rating[@class='ng-star-inserted']//span[normalize-space(text())='1']") WebElement multiTextReportViewRating1;
    public @FindBy(xpath = "//lib-editor-item[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'N')]") WebElement reportViewNRating;
    public @FindBy(xpath = "//lib-editor-item[contains(@class, 'ng-star-inserted')]//span[contains(text(),' M')]") WebElement reportViewMRating;


    //Targeted Notes
    @FindBy(css = "div.multi-text-item")
    private WebElement targetedNotesText;
    @FindBy(css = "div.notes-item")
    private WebElement notesItem;


    //ReportView Field Values
    public @FindBy(xpath = "//div[contains(text(), 'Preformatted Text for Copy/Paste Tests')]/following::div[contains(@class, 'multi-text-item')]") WebElement preformattedReportView;
    public @FindBy(xpath = "//lib-single-text[contains(@class, 'ng-star-inserted')]") WebElement singleTextReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement multiTextReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::span[contains(@class, 'read-only-rating-title')]") WebElement multiTextRatingReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Single)')]/following::span[contains(@class, 'single-text')]") WebElement prefilledTextSingleReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Multi)')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement prefilledTextMultiReportView;
    public @FindBy(xpath = "//lib-date//span[contains(@class, 'date')]") WebElement dateReportView;
    public @FindBy(xpath = "//lib-switch[contains(@class, 'ng-star-inserted')]") WebElement switchReportView;
    public @FindBy(xpath = "//lib-pick-list[contains(@class, 'ng-star-inserted')]") WebElement picklistReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This Has Baked In Tokens')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement bakedInReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Predefined Responses')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement predefinedResponsesReportView;
    public @FindBy(xpath = "//lib-numeric[contains(@class, 'ng-star-inserted')]") WebElement numericReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Bold Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement boldItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Italics Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement italicsItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Underlined Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement underlinedItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Multi Formatted Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement multiFormattedItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Rating')]/following::lib-read-only-rating[contains(@class, 'ng-star-inserted')]") WebElement ratingReportView;


    private String preFormattedText = ("Number list entry 1\n" +
            "Number list entry 2\n" +
            "Number list entry 3");

     //Report view expected values
    private String preformattedTextExpected = "Number list entry 1\n" +
             "Number list entry 2\n" +
             "Number list entry 3";
    private String singleTextExpected = "Single line of text entered into the single item text item";
    private String multiTextExpected = "This is bold text\n" +
            "This is italicized text\n" +
            "This is underlined text\n" +
            "This is strikethrough text";
    private String multiTextRatingExpected = "3";
    private String prefilledSingleExpected = "This item was previously prefilled but has now been replaced with this text";
    private String prefilledMultiExpected = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateExpected = "10 July 2025";
    private String switchExpected = "Switch 2";
    private String picklistExpected = "Option 2,Option 3";
    private String bakedInTokensExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private String predefinedResponsesExpected = "Multiple more entries are required to test\n" +
            " Third option specifically for testing \n" +
            " Text the same as the button for testing purposes";

    private String numericExpected = "123,456,789,000,000,000";
    private String enterBoldExpected = "Entering some bold text to confirm form uploads correctly";
    private String enterItalicsExpected = "Entering some italics text to confirm form uploads correctly";
    private String enterUnderlinedExpected = "Entering some underlined text to confirm form uploads correctly";
    private String enterMultiformatExpected = "Bold text with some added italics, added underline but removed bold, completed with strikethrough changed with simple bold and finally removed all formatting";
    private String ratingExpected = "N";


    //Numeric elements
    public @FindBy(css = "div span.numeric") WebElement reportNumeric;


    //Item confirmations
    public void confirmCorrectSinglePrefilledText() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming Single Text Prefilled item contains correct text");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String prefilledText = (String) js.executeScript("return arguments[0].value;", extractedTextField);
            System.out.println("Actual text: " + prefilledText);

            Assert.assertEquals(prefilledText, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.");
            //System.out.println("Extracted text - " + prefilledText);
            System.out.println("Confirmed Single Text Prefilled item contains correct text");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single prefilled text");
        }
    }

    public void confirmCorrectMultiPrefilledText() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming Multi Text Prefilled item contains correct text");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String prefilledText = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            System.out.println("Actual text: " + prefilledText);

            Assert.assertEquals(prefilledText, "Single SentenceLorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.New ParagraphLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.");
            System.out.println("Extracted text - " + prefilledText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text is correct");
        }
    }

    public void confirmPicklist(String option1, String option2, String option3) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming selected Picklist options");

            WebElement selectedOption2 =
                    getDriver().findElement(By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted bg-gray-400') and contains(text(), '" + option2 + "')]"));

            WebElement selectedOption3 =
                    getDriver().findElement(By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted bg-gray-400') and contains(text(), '" + option3 + "')]"));

            String actualSelectedOption2 = selectedOption2.getText();
            String actualSelectedOption3 = selectedOption3.getText();
            Assert.assertEquals(selectedOption2.getText(), option2);
            Assert.assertEquals(selectedOption3.getText(), option3);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm selected Picklist selections");
        }

    }

    public void confirmLocationCoordinates() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming co-ordinates present (requires actual location validation)");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //String coordinatesText = (String) js.executeScript("return arguments[0].value;", multiTextItem);
            System.out.println("Extracting coordinates");
            String coordinatesText = multiTextItem.getText();

            System.out.println("Extracted co-ordinates: " + coordinatesText);

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm co-ordinates");
        }
    }

    public void confirmSinglePicklist(String option) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming selected Picklist options");

            WebElement selectedOption =
                    getDriver().findElement(By.xpath("//lib-options-list-item[contains(@class, 'ng-star-inserted') and contains(text(), '" + option + "')]"));

            String actualSelectedOption = selectedOption.getText();
            Assert.assertEquals(selectedOption.getText(), option);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm selected Picklist selections");
        }

    }

    public void confirmSingleResponse(String response) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming single response '" + response + "' saved");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String enteredResponse = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            //System.out.println("Expected text: " + response);
            //System.out.println("Actual text: " + enteredResponse);
            Assert.assertTrue(enteredResponse.contains(response),
                    "Expected response to contain: " + response + ", but was: " + enteredResponse);
            System.out.println("Previous response confirmed saved");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to confirm single response");
        }
    }

    public void confirmSingleText(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming text in single text item");
            waitForWebElementToBeVisible(singleText);
            String reportSingleText = singleText.getText();
            System.out.println("singleText: " + singleText);
            Assert.assertTrue(text.contains(reportSingleText), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }
    }

    public void confirmMultiText(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming text in multi text item");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String enteredText = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            //System.out.println("Expected text: " + response);
            //System.out.println("Actual text: " + enteredResponse);
            Assert.assertTrue(enteredText.contains(text),
                    "Expected response to contain: " + text + ", but was: " + enteredText);
            System.out.println("Confirmed presence of text: '" + text + "'");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text field");
        }
    }

    public void confirmMultiTextRating(String text) throws IOException, URISyntaxException, InterruptedException {
         try {
            System.out.println("Confirming rating in multi text item");
            WebElement selectedRating = getDriver().findElement(By.xpath("//lib-rating//span[contains(text(), '" + text + "')]"));
            String selectedRatingText = selectedRating.getText();
            waitForWebElementToBeVisible(selectedRating);
            System.out.println("selectedRatingText: " + selectedRatingText);
            Assert.assertTrue(selectedRatingText.contains(text), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }

    }

    public void confirmNumeric(String expectedText) {
        try {
            System.out.println("Confirming text in numeric item, expected value: " + expectedText);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            By numericFieldLocator = By.cssSelector("input[numericfield]");

            // Wait until JS value is not empty
            wait.until(driver -> {
                WebElement freshField = driver.findElement(numericFieldLocator);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String val = (String) js.executeScript("return arguments[0].value;", freshField);
                return val != null && !val.trim().isEmpty();
            });

            WebElement numericFieldElement = getDriver().findElement(numericFieldLocator);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            actualValue = (String) js.executeScript("return arguments[0].value;", numericFieldElement);

            System.out.println("Current value of numeric field: " + actualValue);

            Assert.assertTrue(actualValue.contains(expectedText),
                    "Expected value to contain: '" + expectedText + "', but was: '" + actualValue + "'");

            //System.out.println("Confirmed presence of expected text: '" + expectedText + "'");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to confirm numeric field()");
        }
    }

    public void confirmExtraTextSaved(String additionalText) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming saved extra text present: '" + additionalText + "'");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String prefilledText = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            //System.out.println("Actual text: " + prefilledText);

            assertTrue("Expected text to contain: '" + additionalText + "', but was: '" + prefilledText + "'",
                    prefilledText.contains(additionalText));
            //System.out.println("Extracted text - " + prefilledText);
            System.out.println("Extra text successfully saved");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        }

    }

    public void confirmTextDeletion(String response3) throws MalformedURLException, URISyntaxException {
        try{
        String itemText = multiTextItem.getText();
        System.out.println("Confirming text deleted");

        Assert.assertFalse(itemText.contains(response3),
                "Text should NOT contain: '" + response3 + "', but it was found.");

        System.out.println("Text confirmed deleted");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date");
        }
    }

    public void confirmCoordinates() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming co-ordinates present (requires actual location validation)");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", extractedTextField);

            System.out.println("Extracted co-ordinates - " + coordinatesText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm co-ordinates");
        }
    }

    public void confirmNotEmpty() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming data maintained");
            waitForWebElement(extractedTextField);
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", extractedTextField);
            System.out.println("Value prior to trimming: " + coordinatesText);
            String cleaned = null;
            if (coordinatesText != null) {
                cleaned = coordinatesText.replaceAll("[\\p{Z}\\p{C}]", "");
            }

            Assert.assertFalse(
                    cleaned == null || cleaned.isEmpty(),
                    "Expected there to be a value: '" + coordinatesText + "'"
            );
            System.out.println("Confirmed text is in field");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm the field is not empty");
        }
    }

    public void confirmEmpty() throws IOException, URISyntaxException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", extractedTextField);
            System.out.println("Value prior to trimming: " + coordinatesText);
            String cleaned = null;
            if (coordinatesText != null) {
                cleaned = coordinatesText.replaceAll("[\\p{Z}\\p{C}]", "");
            }

            Assert.assertTrue(
                    cleaned == null || cleaned.isEmpty(),
                    "True check - Expected value to be null or only invisible, but was: '" + coordinatesText + "'"
            );

            Assert.assertFalse(
                    cleaned != null && !cleaned.isEmpty(),
                    "False check - Expected value to be non-empty and visible, but was: '" + coordinatesText + "'"
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm field is empty");
        }

    }

    public void confirmMultiItemDeselected (String option) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming rating " + option + " is not selected");
            WebElement deselectedItem = getDriver().findElement(By.xpath("//lib-rating[contains(@class, 'ng-star-inserted')]//div[contains(@class, 'opacity-30')]//span[contains(@class, 'rating-option-title') and normalize-space(text())='" + option + "']"));

            boolean isItemDeselected = deselectedItem.isDisplayed();
            Assert.assertTrue(isItemDeselected, "Expected item to be deselected, but it was still visible");
            System.out.println(option + " is not selected");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi item rating selected in report view");
        }
    }

    public void confirmItemDeselected (String option) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming rating " + option + " is not selected");
            WebElement deselectedItem = getDriver().findElement(By.xpath("(//lib-rating-view[contains(@class, 'ng-star-inserted')]//div[contains(@class, 'opacity-30')]//span[contains(@class, 'rating-option-title') and normalize-space(text())='" + option + "'])"));
            boolean isItemDeselected = deselectedItem.isDisplayed();
            Assert.assertTrue(isItemDeselected, "Expected item to be deselected, but it was still visible");
            System.out.println(option + " is not selected");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi item rating deselected in report view");
        }
    }




    //Text formatting confirmation


    public void confirmFormatting() throws IOException, URISyntaxException {
        try {
            System.out.print("Confirming MultiText retained");
            System.out.println("Confirming formatting");
            // Confirm bold text
            WebElement boldElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + boldText + "')]"));
            Assert.assertTrue(boldElement.isDisplayed());
            System.out.println("Bold text is formatted in bold");
            //System.out.println(boldText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bold text");
        }

        try {
            // Confirm italicised text
            WebElement italicsElement = getDriver().findElement(By.xpath("//em[contains(text(),'" + italicsText + "')]"));
            Assert.assertTrue(italicsElement.isDisplayed());
            System.out.println("Italics text is formatted in italics");
            //System.out.println(italicsText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm italicised text");
        }

        try {
            // Confirm underlined text
            WebElement underlineElement = getDriver().findElement(By.xpath("//u[contains(text(),'" + underlineText + "')]"));
            Assert.assertTrue(underlineElement.isDisplayed());
            System.out.println("Underlined text is underlined");
            //System.out.println(underlineText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm underlined text");
        }

        try {
            // Confirm strikethrough text
            WebElement strikethroughElement = getDriver().findElement(By.xpath("//s[contains(text(),'" + strikethroughText + "')]"));
            Assert.assertTrue(strikethroughElement.isDisplayed());
            System.out.println("Strikethrough text is struck through");
            //System.out.println(strikethroughText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm strikethrough text");
        }

    }

    public void confirmSingleMultiFormat() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming Multiformatted text");

            By editorLocator = By.xpath("//div[contains(@class, 'ql-editor')]");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(editorLocator));

            String htmlContent = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", editor);

            String editorHtml = editor.getAttribute("innerHTML");

            Assert.assertTrue(htmlContent.contains("<strong>Bold text with <em>some added italics,"), "Expected bold with italic text");
            Assert.assertTrue(htmlContent.contains("<em><u>added underline but removed bold,"), "Expected underlined italic text");
            Assert.assertTrue(htmlContent.contains("<s><u>completed with strikethrough"), "Expected underlined strikethrough");
            Assert.assertTrue(htmlContent.contains("<strong><s>changed with simple bold and finally"), "Expected bold strikethrough");

            System.out.println("Confirmed correct Multiformatted text present");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single multi formatting");
        }
    }

    public void confirmMultiFormat() throws IOException, URISyntaxException {
        try{
        System.out.println("Confirming multiformat");
        WebElement multiElement = getDriver().findElement(By.xpath("//p[.//strong and .//u and .//em[contains(text(), 'needs')] and .//em[contains(text(), 'slightly longer')]]"));
        Assert.assertTrue(multiElement.isDisplayed());
        System.out.println("Multiformated text correct");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi formatted text");
        }
    }

    public void confirmBold() throws IOException, URISyntaxException {
        try{
        System.out.println("Confirming all bold");

        // Confirm bold text
        WebElement boldElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + boldText + "')]"));
        Assert.assertTrue(boldElement.isDisplayed());
        WebElement italicsElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + italicsText + "')]"));
        Assert.assertTrue(italicsElement.isDisplayed());
        WebElement underlinedElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + underlineText + "')]"));
        Assert.assertTrue(underlinedElement.isDisplayed());
        WebElement strikethroughElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + strikethroughText + "')]"));
        Assert.assertTrue(strikethroughElement.isDisplayed());
        System.out.println("All text is formatted in bold");
        //System.out.println(boldText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bold text");
        }
    }

    public void confirmBoldItalics() throws IOException, URISyntaxException {
        try{
        System.out.println("Confirming all bold italics");

        // Confirm bold italics text
        WebElement boldElement = getDriver().findElement(By.xpath("//p/strong/em[contains(text(), '" + boldText + "')]"));
        Assert.assertTrue(boldElement.isDisplayed());
        WebElement italicsElement = getDriver().findElement(By.xpath("//p/strong/em[contains(text(), '" + italicsText + "')]"));
        Assert.assertTrue(italicsElement.isDisplayed());
        WebElement underlinedElement = getDriver().findElement(By.xpath("//p/strong/em[contains(text(), '" + underlineText + "')]"));
        Assert.assertTrue(underlinedElement.isDisplayed());
        WebElement strikethroughElement = getDriver().findElement(By.xpath("//p/strong/em[contains(text(), '" + strikethroughText + "')]"));
        Assert.assertTrue(strikethroughElement.isDisplayed());
        System.out.println("All text is formatted in bold italics");
        //System.out.println(boldText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bold, italicised text");
        }


    }

    public void confirmUnderlined() throws IOException, URISyntaxException {
        try{
        System.out.println("Confirming all underlined");

        // Confirm underlined text
        WebElement boldElement = getDriver().findElement(By.xpath("//u[contains(text(), '" + boldText + "')]"));
        Assert.assertTrue(boldElement.isDisplayed());
        WebElement italicsElement = getDriver().findElement(By.xpath("//u[contains(text(), '" + italicsText + "')]"));
        Assert.assertTrue(italicsElement.isDisplayed());
        WebElement underlinedElement = getDriver().findElement(By.xpath("//u[contains(text(), '" + underlineText + "')]"));
        Assert.assertTrue(underlinedElement.isDisplayed());
        WebElement strikethroughElement = getDriver().findElement(By.xpath("//u[contains(text(), '" + strikethroughText + "')]"));
        Assert.assertTrue(strikethroughElement.isDisplayed());
        System.out.println("All text is underlined");
        //System.out.println(boldText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm underlined text");
        }


    }

    public void confirmUnderlinedStrikethrough() throws IOException, URISyntaxException {
        try{
        System.out.println("Confirming all underlined strikethrough");

        // Confirm underlined strikethrough text
        WebElement boldElement = getDriver().findElement(By.xpath("//p/s/u[contains(text(), '" + boldText + "')]"));
        Assert.assertTrue(boldElement.isDisplayed());
        WebElement italicsElement = getDriver().findElement(By.xpath("//p/s/u[contains(text(), '" + italicsText + "')]"));
        Assert.assertTrue(italicsElement.isDisplayed());
        WebElement underlinedElement = getDriver().findElement(By.xpath("//p/s/u[contains(text(), '" + underlineText + "')]"));
        Assert.assertTrue(underlinedElement.isDisplayed());
        WebElement strikethroughElement = getDriver().findElement(By.xpath("//p/s/u[contains(text(), '" + strikethroughText + "')]"));
        Assert.assertTrue(strikethroughElement.isDisplayed());
        System.out.println("All text is underlined strikethrough");
        //System.out.println(boldText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm underlined, strikethrough text");
        }


    }

    public void confirmNumberlist() throws IOException, URISyntaxException {
        try{
        // Confirm number list entries
        WebElement numberItem = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist1Text + "')]"));
        Assert.assertTrue(numberItem.isDisplayed());
        System.out.println("Number list entry 1 is correctly formatted");
        //System.out.println(numlist1Text);


        WebElement numberItem2 = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist2Text + "')]"));
        Assert.assertTrue(numberItem2.isDisplayed());
        System.out.println("Number list entry 2 is correctly formatted");
        //System.out.println(numlist2Text);

        WebElement numberItem3 = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist3Text + "')]"));
        Assert.assertTrue(numberItem3.isDisplayed());
        System.out.println("Number list entry 3 is correctly formatted");
        //System.out.println(numlist3Text);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm number list");
        }
    }

    public void confirmBulletlist() throws IOException, URISyntaxException {
        try{
        // Confirm bullet list entries
        WebElement bulletItem = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + numlist1Text + "')]"));
        Assert.assertTrue(bulletItem.isDisplayed());
        System.out.println("Bullet list entry 1 is correctly formatted");
        //System.out.println(bullet1Text);


        WebElement bulletItem2 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + numlist2Text + "')]"));
        Assert.assertTrue(bulletItem2.isDisplayed());
        System.out.println("Bullet list entry 2 is correctly formatted");
        //System.out.println(bullet2Text);

        WebElement bulletItem3 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + numlist3Text + "')]"));
        Assert.assertTrue(bulletItem3.isDisplayed());
        System.out.println("Bullet list entry 3 is correctly formatted");
        //System.out.println(bullet3Text);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bullet list");
        }
    }

    public void confirmFormattedTextInMultiTextItem() throws IOException, URISyntaxException {
        try {
        WebDriver driver = getDriver(); // replace with your driver factory method

        //bold
        WebElement boldText = targetedNotesText.findElement(By.xpath(".//b[contains(text(), 'This is bold text')]"));
        Assert.assertNotNull(boldText, "Bold text not found");

        //italics
        WebElement italicText = targetedNotesText.findElement(By.xpath(".//i[contains(text(), 'This is italicised text')]"));
        Assert.assertNotNull(italicText, "Italic text not found");

        //underlined
        WebElement underlineText = targetedNotesText.findElement(By.xpath(".//u[contains(text(), 'This is underlined text')]"));
        Assert.assertNotNull(underlineText, "Underline text not found");

        //bold italics
        WebElement nestedFormattedText = targetedNotesText.findElement(By.xpath(".//b[i[contains(text(), 'slightly longer')]]"));
        Assert.assertNotNull(nestedFormattedText, "Nested bold+italic text not found");

        //confirming full text
        String fullText = targetedNotesText.getText();
        Assert.assertTrue(fullText.contains("This is bold text"), "Expected bold text not present in container text");


        //confirm all notes entries present
        WebElement entry1 = notesItem.findElement(By.xpath(".//li[text()='Number list entry 1']"));
        WebElement entry2 = notesItem.findElement(By.xpath(".//li[text()='Number list entry 2']"));
        WebElement entry3 = notesItem.findElement(By.xpath(".//li[text()='Number list entry 3']"));

        Assert.assertNotNull(entry1, "Entry 1 is missing");
        Assert.assertNotNull(entry2, "Entry 2 is missing");
        Assert.assertNotNull(entry3, "Entry 3 is missing");

        System.out.println("Multiformatted text confirmed present in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text item");
        }

    }

    public void confirmNumericReport() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(reportNumeric);
            String roundedReportNumericDisplayed = reportNumeric.getText();
            String actualReturnedNumericValue = TestAllControlsRM_PO.DecimalTrimmer.roundedDecimal(actualValue);

            BigDecimal expected = new BigDecimal(roundedReportNumericDisplayed);
            BigDecimal actual = new BigDecimal(TestAllControlsRM_PO.DecimalTrimmer.roundedDecimal(actualReturnedNumericValue));

            Assert.assertTrue(expected.compareTo(actual) == 0,
                    "Expected value: " + expected + ", but got: " + actual);

            //System.out.println("Confirmed presence of expected text: '" + roundedReportNumericDisplayed + "'");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to confirm numeric entry");
        }
    }


    //Specific confirmations run during reportFunctionsUpload.feature test
    public void confirmReportViewPrefilledSingleUpload(String option) throws IOException, URISyntaxException, InterruptedException {
        // Confirm first rating entry //lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]
        try {
            waitForWebElementToBeVisible(prefilledTextSingleReportView);
            String reportViewPrefilledSingle = prefilledTextSingleReportView.getText();
            System.out.println("ReportViewPrefilledSingle Value: " + reportViewPrefilledSingle);
            Assert.assertTrue(reportViewPrefilledSingle.contains(option), "Actual text does not contain expected text.");
            System.out.println(option + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single prefilled in report view");
        }

    }

    public void confirmReportViewDateUpload(String specifiedViewDate) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(dateReportView);
            System.out.println("Confirming report view date");
            String actualReportViewText = dateReportView.getText();
            System.out.println(actualReportViewText);
            Assert.assertTrue(actualReportViewText.contains(specifiedViewDate));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmReportViewPrefilledMultiUpload(String option) throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(prefilledTextMultiReportView);
            String reportViewPrefilledMulti = prefilledTextMultiReportView.getText();
            System.out.println("ReportViewPrefilledMulti Value: " + reportViewPrefilledMulti);
            Assert.assertTrue(reportViewPrefilledMulti.contains(option), "Actual text does not contain expected text.");
            System.out.println(option + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled in report view");
        }
    }

    public void confirmReportViewPicklistUpload(String option1, String option2, String option3) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(picklistReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualPicklistReportViewText = picklistReportView.getText();
            System.out.println(actualPicklistReportViewText);
            String supposedReportViewPicklist = (option2 + "," + option3);
            Assert.assertEquals(actualPicklistReportViewText, supposedReportViewPicklist);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmReportViewRatingUpload(String option) throws IOException, URISyntaxException, InterruptedException {
        try{
            WebElement reportViewRating = getDriver().findElement(By.xpath("//lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), ' " + option + " ')]"));
            System.out.println("ReportViewRating Value: " + reportViewRating);
            Assert.assertTrue(reportViewRating.isDisplayed());
            System.out.println(option + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmReportViewMultiRatingUpload(String option) throws IOException, URISyntaxException, InterruptedException {
        // Confirm first rating entry //lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]
        try{
            WebElement reportViewRating = getDriver().findElement(By.xpath("//lib-read-only-rating[@class='ng-star-inserted']//span[normalize-space(text())='" + option + "']"));
            System.out.println("ReportViewRating Value: " + reportViewRating);
            Assert.assertTrue(reportViewRating.isDisplayed());
            System.out.println(option + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text rating in report view");
        }

    }



    // Report View confirmations (reportFunctionsConfirmUpload.feature)
    public void confirmReportViewPreformattedText() throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(preformattedReportView);
            //Thread.sleep(2000);
            String reportViewPreformattedText = preformattedReportView.getText();
            System.out.println("preformattedText value: " + reportViewPreformattedText);
            Assert.assertTrue(preformattedTextExpected.contains(preFormattedText), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmReportViewSingleTextUpload(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(singleTextReportView);
            String reportViewSingleText = singleTextReportView.getText();
            System.out.println("singleTextReportViewText: " + reportViewSingleText);
            Assert.assertTrue(expectedText.contains(reportViewSingleText), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }
    }

    public void confirmReportViewSingleText() throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(singleTextReportView);
            String reportViewSingleText = singleTextReportView.getText();
            System.out.println("singleTextReportViewText: " + reportViewSingleText);
            Assert.assertTrue(singleTextExpected.contains(reportViewSingleText), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }
    }

    public void confirmReportViewMultiText() throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(multiTextReportView);
            String reportViewMultiText = multiTextReportView.getText();
            System.out.println("multiTextReportViewText: " + reportViewMultiText);
            Assert.assertTrue(multiTextExpected.contains(reportViewMultiText), "Actual text does not contain expected text.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text in report view");
        }
    }

    public void confirmReportViewMultiTextRating() throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(multiTextRatingReportView);
            String reportViewMultiTextRating = multiTextRatingReportView.getText();
            Assert.assertTrue(multiTextRatingExpected.contains(reportViewMultiTextRating), "Actual text does not contain expected text.");
            System.out.println(reportViewMultiTextRating + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text ratingin report view");
        }
    }

    public void confirmReportViewPrefilledSingle() throws IOException, URISyntaxException, InterruptedException {
        // Confirm first rating entry //lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]
        try {
            waitForWebElementToBeVisible(prefilledTextSingleReportView);
            String reportViewPrefilledSingle = prefilledTextSingleReportView.getText();
            System.out.println("ReportViewPrefilledSingle Value: " + reportViewPrefilledSingle);
            Assert.assertTrue(prefilledSingleExpected.contains(reportViewPrefilledSingle), "Actual text does not contain expected text.");
            System.out.println(prefilledSingleExpected + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single prefilled in report view");
        }

    }

    public void confirmReportViewPrefilledMulti() throws IOException, URISyntaxException, InterruptedException {
        try {
            waitForWebElementToBeVisible(prefilledTextMultiReportView);
            String reportViewPrefilledMulti = prefilledTextMultiReportView.getText();
            System.out.println("ReportViewPrefilledMulti Value: " + reportViewPrefilledMulti);
            Assert.assertTrue(prefilledMultiExpected.contains(reportViewPrefilledMulti), "Actual text does not contain expected text.");
            System.out.println(prefilledMultiExpected + " is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled in report view");
        }
    }

    public void confirmReportViewDate() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(dateReportView);
            System.out.println("Confirming report view date");
            String actualDateReportViewText = dateReportView.getText();
            System.out.println(actualDateReportViewText);
            Assert.assertTrue(dateExpected.contains(actualDateReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmReportViewSwitch() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(switchReportView);
            System.out.println("Confirming selected Switch in report view");
            String actualSwitchReportViewText = switchReportView.getText();
            System.out.println(actualSwitchReportViewText);
            Assert.assertTrue(switchExpected.contains(actualSwitchReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("unable to confirm switch selection in report view");
        }

    }

    public void confirmReportViewPicklist() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(picklistReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualPicklistReportViewText = picklistReportView.getText();
            System.out.println(actualPicklistReportViewText);
            Assert.assertTrue(picklistExpected.contains(actualPicklistReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmReportViewSinglePicklist(String option) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(picklistReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualPicklistReportViewText = picklistReportView.getText();
            System.out.println(actualPicklistReportViewText);
            String supposedReportViewPicklist = (option);
            Assert.assertTrue(
                    actualPicklistReportViewText.contains(supposedReportViewPicklist),
                    "Expected the actual text to contain: " + supposedReportViewPicklist + ", but got: \"" + actualPicklistReportViewText + "\""
            );

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single picklist selection in report view");
        }

    }

    public void confirmReportViewBakedInTokens() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(bakedInReportView);
            System.out.println("Confirming baked in tokens in report view");
            String actualBakedInReportViewText = bakedInReportView.getText();
            System.out.println(actualBakedInReportViewText);
            Assert.assertTrue(bakedInTokensExpected.contains(actualBakedInReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmReportViewPredefinedResponses() {
        try{
            String actual   = predefinedResponsesReportView.getText();

            // 1) Debug print with delimiters and lengths
            System.out.printf("EXPECTED → «%s» (len=%d)%n", predefinedResponsesExpected, predefinedResponsesExpected.length());
            System.out.printf("ACTUAL   → «%s» (len=%d)%n", actual,   actual.length());

            // 2) Normalize line endings to Unix style (just in case)
            predefinedResponsesExpected = predefinedResponsesExpected.replaceAll("\\r\\n?", "\n");
            actual   = actual  .replaceAll("\\r\\n?", "\n");

            // 3) Trim leading/trailing whitespace and collapse any run of whitespace to a single space
            String normExpected = predefinedResponsesExpected.trim().replaceAll("\\s+", " ");
            String normActual   = actual  .trim().replaceAll("\\s+", " ");

            System.out.printf("NORM EXPECTED → «%s» (len=%d)%n", normExpected, normExpected.length());
            System.out.printf("NORM ACTUAL   → «%s» (len=%d)%n", normActual,   normActual.length());

            // 4) Now assert contains (or equals) on the normalized strings
            Assert.assertTrue(
                    normActual.contains(normExpected),
                    String.format(
                            "After normalization actual does not contain expected:%n  actual = «%s»%n  expected = «%s»",
                            normActual, normExpected
                    )
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm predefined responses");
        }
    }

    public void confirmReportViewNumericSimple() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Numeric report view value");
            waitForWebElementToBeVisible(numericReportView);
            String actualNumericReportViewText = numericReportView.getText();
            Assert.assertTrue(numericExpected.contains(actualNumericReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm numeric entry");
        }
    }

    public void confirmReportViewBoldItem() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Enter Bold Text' report view value");
            waitForWebElementToBeVisible(boldItemReportView);
            String actualBoldItemReportViewText = boldItemReportView.getText();
            System.out.println(actualBoldItemReportViewText);
            Assert.assertTrue(enterBoldExpected.contains(actualBoldItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bold text");
        }

    }

    public void confirmReportViewItalicsItem() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Enter Italics Text' report view value");
            waitForWebElementToBeVisible(italicsItemReportView);
            String actualItalicsItemReportViewText = italicsItemReportView.getText();
            System.out.println(actualItalicsItemReportViewText);
            Assert.assertTrue(enterItalicsExpected.contains(actualItalicsItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm italics text");
        }

    }

    public void confirmReportViewUnderlinedItem() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Enter underlined Text' report view value");
            waitForWebElementToBeVisible(underlinedItemReportView);
            String actualUnderlinedItemReportViewText = underlinedItemReportView.getText();
            System.out.println(actualUnderlinedItemReportViewText);
            Assert.assertTrue(enterUnderlinedExpected.contains(actualUnderlinedItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm underlined text");
        }

    }

    public void confirmReportViewMultiFormattedItem() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Enter Multi Formatted Text' report view value");
            waitForWebElementToBeVisible(multiFormattedItemReportView);
            String actualMultiFormattedTextItemReportViewText = multiFormattedItemReportView.getText();
            System.out.println(actualMultiFormattedTextItemReportViewText);
            Assert.assertTrue(enterMultiformatExpected.contains(actualMultiFormattedTextItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi formatted text");
        }

    }

    public void confirmReportViewRating() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Checking 'This is a Rating' report view value");
        try{
            waitForWebElementToBeVisible(ratingReportView);
            String actualRatingReportViewText = ratingReportView.getText();
            System.out.println(actualRatingReportViewText);
            Assert.assertTrue(ratingExpected.contains(actualRatingReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmReportViewItemRating(String option) throws IOException, URISyntaxException, InterruptedException {
        try{
        // Confirm first rating entry //lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]
        WebElement itemRating = getDriver().findElement(By.xpath("//lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), '" + option + " ')]"));
        System.out.println("Item Rating Value: " + itemRating);
        Assert.assertTrue(itemRating.isDisplayed());
        System.out.println(option + " is displayed in item view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }


}
