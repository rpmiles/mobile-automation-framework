package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;


public class confirmationFunctionsConfirmUpload extends Base_PO {


    public confirmationFunctionsConfirmUpload() throws IOException, URISyntaxException {
        PageFactory.initElements(getDriver(), this);
    }


    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiTextItem;
    public @FindBy(xpath = "//input") WebElement singleTextItem;


    //ReportView Field Values
    public  @FindBy(xpath = "//div[contains(text(), 'Preformatted Text for Copy/Paste Tests')]/following::div[contains(@class, 'multi-text-item')]") WebElement preformattedReportView;
    public  @FindBy(xpath = "//lib-single-text[contains(@class, 'ng-star-inserted')]") WebElement singleTextReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement multiTextReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::span[contains(@class, 'read-only-rating-title')]") WebElement multiTextRatingReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Single)')]/following::span[contains(@class, 'single-text')]") WebElement prefilledTextSingleReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Multi)')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement prefilledTextMultiReportView;
    public  @FindBy(xpath = "//lib-date//span[contains(@class, 'date')]") WebElement dateReportView;
    public  @FindBy(xpath = "//lib-switch[contains(@class, 'ng-star-inserted')]") WebElement switchReportView;
    public  @FindBy(xpath = "//lib-editor-item[.//div[contains(@class,'editor-item__title') and normalize-space(.)='Single Select Pick List']]//lib-placeholder//span") WebElement singlePickListReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'Multi Select Pick List')]/following::lib-pick-list[contains(@class, 'ng-star-inserted')]") WebElement multiPickListReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This Has Baked In Tokens')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement bakedInReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is Predefined Responses')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]//div[contains(@class,'multi-text-item')][1]") WebElement predefinedResponsesReportView;
    public  @FindBy(css = "div span.numeric") WebElement numericReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'Enter Bold Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement boldItemReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'Enter Italics Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement italicsItemReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'Enter Underlined Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement underlinedItemReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'Enter Multi Formatted Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement multiFormattedItemReportView;
    public  @FindBy(xpath = "//div[contains(text(), 'This is a Rating')]/following::lib-read-only-rating[contains(@class, 'ng-star-inserted')]") WebElement ratingReportView;

    //Ratings
    //Define selected/deselected options 'This is a Rating'
    public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]") WebElement selectedY;
    public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'N')]") WebElement selectedN;
    public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'M')]") WebElement selectedM;

    public @FindBy(xpath = "//lib-rating-view//lib-rating//div[contains(@class, 'opacity-30')]//span[contains(text(), 'Y')]") WebElement deselectedY;
    public @FindBy(xpath = "//lib-rating-view//lib-rating//div[contains(@class, 'opacity-30')]//span[contains(text(), 'N')]") WebElement deselectedN;
    public @FindBy(xpath = "//lib-rating-view//lib-rating//div[contains(@class, 'opacity-30')]//span[contains(text(), 'M')]") WebElement deselectedM;

    //Define selected/deselected options 'This is Multi Text'
    public @FindBy(xpath = "//div[not(contains(@class, 'opacity-30'))]//span[contains(text(), '1')]") WebElement selected1 ;
    public @FindBy(xpath = "//div[not(contains(@class, 'opacity-30'))]//span[contains(text(), '2')]") WebElement selected2;
    public @FindBy(xpath = "//div[not(contains(@class, 'opacity-30'))]//span[contains(text(), '3')]") WebElement selected3;

    public @FindBy(xpath = "//div[contains(@class, 'opacity-30')]//span[contains(text(), '1')]") WebElement deselected1;
    public @FindBy(xpath = "//div[contains(@class, 'opacity-30')]//span[contains(text(), '2')]") WebElement deselected2;
    public @FindBy(xpath = "//div[contains(@class, 'opacity-30')]//span[contains(text(), '3')]") WebElement deselected3;


    //Uploaded expected
    private String preformattedUploadTextExpected = ("Number list entry 1\n" +
            "Number list entry 2\n" +
            "Number list entry 3");
    private String singleTextUploadExpected = "Single line of text entered into the single item text item";
    private String multiTextUploadExpected ="This is bold text\n" +
            "This is italicized text\n" +
            "This is underlined text\n" +
            "This is strikethrough text";;
    private String multiTextRatingUploadExpected = "3";
    private String prefilledSingleUploadExpected = "This item was previously prefilled but has now been replaced with this text";
    private String prefilledMultiUploadExpected = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING " +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. " +
            "Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus " +
            "urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac " +
            "molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna " +
            "sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. " +
            "Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateUploadExpected = "";
    private String switchUploadExpected = "Switch 2";
    private String multiPicklistUploadExpected = "Option 2,Option 3";
    private String singlePickListUploadExpected = "";
    private String bakedInTokensExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private String predefinedResponsesUploadExpected = "Multiple more entries are required to test\n" +
            "Third option specifically for testing\n" +
            "Text the same as the button for testing purposes";
    private String numericUploadExpected = "123,456,789,000,000,000";
    private String uploadEnterBoldExpectedReportView = "Entering some bold text to confirm form uploads correctly";
    private String ratingUploadExpected = "N";
    private String enterBoldUploadedExpected = "<strong>Entering some bold text to confirm form uploads correctly</strong>";
    private String enterItalicsUploadExpected = "<em>Entering some italics text to confirm form uploads correctly</em>";
    private String enterUnderlinedUploadExpected = "<u>Entering some underlined text to confirm form uploads correctly</u>";
    private String enterMultiFormattedUploadExpected = "<strong>Bold text with <em>some added italics, </em></strong><em><u>added underline but removed bold, </u><s><u>completed with strikethrough </u></s></em><strong><s>changed with simple bold and finally </s></strong>removed all formatting";


    //Normalise string
    private static String norm(String s) {
        if (s == null) return "";
        return s
                .replace("\uFEFF", "")                 // BOM
                .replace('\u00A0', ' ')                // NBSP -> space
                .replaceAll("[\\u200B-\\u200D\\u2060]", "") // zero-widths
                .replaceAll("\\r\\n?", "\n")           // CRLF/CR -> LF
                .replaceAll("\\s+", " ")               // collapse whitespace runs
                .trim();
    }


    //Confirm report view
    public void confirmUploadedCorrectReportView(String item) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming uploaded " + item + " in report view");

            WebElement fieldName;
            String expectedText;
            if (item.equals("Preformatted Text for Copy/Paste Tests")) {
                fieldName = preformattedReportView;
                expectedText = preformattedUploadTextExpected;
            } else if (item.equals("This is Single Text")) {
                fieldName = singleTextReportView;
                expectedText = singleTextUploadExpected;
            } else if (item.equals("This is Multi Text")) { // ensure exact key
                fieldName = multiTextReportView;
                expectedText = multiTextUploadExpected;
            } else if (item.equals("This is Prefilled Text Single")) {
                fieldName = prefilledTextSingleReportView;
                expectedText = prefilledSingleUploadExpected;
            } else if (item.equals("This is Prefilled Text Multi")) {
                fieldName = prefilledTextMultiReportView;
                expectedText = prefilledMultiUploadExpected;
            } else if (item.equals("This is a Date")) { // ensure exact key
                fieldName = dateReportView;
                expectedText = dateUploadExpected;
            } else if (item.equals("This is a Switch")) {
                fieldName = switchReportView;
                expectedText = switchUploadExpected;
            } else if (item.equals("Single Select Pick List")) {
                fieldName = singlePickListReportView;
                expectedText = singlePickListUploadExpected;
            } else if (item.equals("Multi Select Pick List")) { // ensure exact key
                fieldName = multiPickListReportView;
                expectedText = multiPicklistUploadExpected;
            } else if (item.equals("This Has Baked In Tokens")) {
                fieldName = bakedInReportView;
                expectedText = bakedInTokensExpected;
            } else if (item.equals("This is Predefined Responses")) {
                fieldName = predefinedResponsesReportView;
                expectedText = predefinedResponsesUploadExpected;
            } else if (item.equals("This is a Numeric")) { // ensure exact key
                fieldName = numericReportView;
                expectedText = numericUploadExpected;
            } else if (item.equals("Enter Bold Text")) {
                fieldName = boldItemReportView;
                expectedText = uploadEnterBoldExpectedReportView;
            } else if (item.equals("Enter Italics Text")) {
                fieldName = italicsItemReportView;
                expectedText = enterItalicsUploadExpected;
            } else if (item.equals("Enter Underlined Text")) { // ensure exact key
                fieldName = underlinedItemReportView;
                expectedText = enterUnderlinedUploadExpected;
            } else if (item.equals("Enter Multi Formatted Text")) { // ensure exact key
                fieldName = multiFormattedItemReportView;
                expectedText = enterMultiFormattedUploadExpected;
            } else if (item.equals("This is Rating")) { // ensure exact key
                fieldName = ratingReportView;
                expectedText = ratingUploadExpected;
            } else {
                throw new IllegalArgumentException("Unknown item: " + item);
            }

            System.out.println("Waiting for: " +item);
            waitForWebElementToBeVisible(fieldName);
            String reportViewText = fieldName.getText();
            System.out.println(item + " displayed in Report View: \n" + reportViewText);
            Assert.assertTrue(reportViewText.contains(expectedText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmUploadedReportViewMultiTextRating() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Multi Text Rating in report view");
            waitForWebElementToBeVisible(multiTextRatingReportView);
            String reportViewMultiTextRating = multiTextRatingReportView.getText();
            System.out.println("Single Text displayed in Report View: \n" + reportViewMultiTextRating);
            Assert.assertTrue(reportViewMultiTextRating.contains(multiTextRatingUploadExpected), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmUploadedReportViewRating() throws IOException, URISyntaxException, InterruptedException {
        try{
            System.out.println("Confirming selected This is a Rating in report view");
            waitForWebElementToBeVisible(ratingReportView);
            String reportViewRating = ratingReportView.getText();
            System.out.println("Rating displayed in Report View: \n" + reportViewRating);
            Assert.assertTrue(reportViewRating.contains(ratingUploadExpected), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmUploadedReportViewTextFormat(String format) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + format);

            String formatExpected;
            WebElement fieldName;

            if (format.equals("Enter Bold Text")) {
                formatExpected = enterBoldUploadedExpected;
                fieldName = boldItemReportView;
            } else if (format.equals("Enter Italics Text")) {
                formatExpected = enterItalicsUploadExpected;
                fieldName = italicsItemReportView;
            } else if (format.equals("Enter Underlined Text")) {
                formatExpected = enterUnderlinedUploadExpected;
                fieldName = underlinedItemReportView;
            } else if (format.equals("Enter Multi Formatted Text")) {
                formatExpected = enterMultiFormattedUploadExpected;
                fieldName = multiFormattedItemReportView;
            } else {
                throw new IllegalArgumentException("Unknown format item: " + format);
            }

            waitForWebElementToBeVisible(fieldName);
            String reportViewUploadedText = fieldName.getDomProperty("innerHTML");

            String normActual   = norm(reportViewUploadedText);
            String normExpected = norm(formatExpected);

            System.out.println(format + " value (norm): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(normActual.contains(normExpected),"Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }



    //Confirm items
    public void confirmUploadedCorrectMultiText(String multiItem) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + multiItem);
            waitForWebElementToBeVisible(multiTextItem);

            String multiItemExpected;
            if (multiItem.equals("Preformatted Text for Copy/Paste Tests")) {
                multiItemExpected = preformattedUploadTextExpected;
            } else if (multiItem.equals("This is Multi Text")) {
                multiItemExpected = multiTextUploadExpected;
            } else if (multiItem.equals("This is Prefilled Text (Multi)")) {
                multiItemExpected = prefilledMultiUploadExpected;
            } else if (multiItem.equals("This Has Baked In Tokens")) { // ensure exact key
                multiItemExpected = bakedInTokensExpected;
            } else {
                throw new IllegalArgumentException("Unknown multi item: " + multiItem);
            }

            String uploadedText = multiTextItem.getText();

            String normActual   = norm(uploadedText);
            String normExpected = norm(multiItemExpected);

            System.out.println(multiItem + " value (norm): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(
                    normActual.contains(normExpected),
                    "Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmUploadedCorrectSingleText(String singleItem) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + singleItem);
            waitForWebElementToBeVisible(singleTextItem);

            String singleItemExpected;
            if (singleItem.equals("This is Single Text")) {
                singleItemExpected = singleTextUploadExpected;
            } else if (singleItem.equals("This is Prefilled Text Single")) {
                singleItemExpected = prefilledSingleUploadExpected;
            } else if (singleItem.equals("This is a Numeric")) {
                singleItemExpected = numericUploadExpected;
            } else {
                throw new IllegalArgumentException("Unknown multi item: " + singleItem);
            }

            String uploadedText = singleTextItem.getDomProperty("value");
            System.out.println("uploadedText = "+ uploadedText);

            String normActual   = norm(uploadedText);
            String normExpected = norm(singleItemExpected);

            System.out.println(singleItem + " value (norm): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(
                    normActual.contains(normExpected),
                    "Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmUploadTextFormat(String format) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + format);
            waitForWebElementToBeVisible(multiTextItem);

            String uploadedText = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", multiTextItem);

            String formatExpected;
            if (format.equals("Enter Bold Text")) {
                formatExpected = enterBoldUploadedExpected;
            } else if (format.equals("Enter Italics Text")) {
                formatExpected = enterItalicsUploadExpected;
            } else if (format.equals("Enter Underlined Text")) {
                formatExpected = enterUnderlinedUploadExpected;
            } else if (format.equals("Enter Multi Formatted Text")) {
                formatExpected = enterMultiFormattedUploadExpected;
            } else {
                throw new IllegalArgumentException("Unknown format item: " + format);
            }

            String normActual   = norm(uploadedText);
            String normExpected = norm(formatExpected);

            System.out.println(format + " value (norm): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(normActual.contains(normExpected),"Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmReportPredefinedResponsesUpload() {
        try{
            String actual   = multiTextItem.getText();
            System.out.println("Predefined responses item value: \n" + actual);

            // 1) Debug print with delimiters and lengths
            //System.out.printf("EXPECTED → «%s» (len=%d)%n", predefinedResponsesExpected, predefinedResponsesExpected.length());
            // System.out.printf("ACTUAL   → «%s» (len=%d)%n", actual,   actual.length());

            // 2) Normalize line endings to Unix style (just in case)
            predefinedResponsesUploadExpected = predefinedResponsesUploadExpected.replaceAll("\\r\\n?", "\n");
            actual   = actual  .replaceAll("\\r\\n?", "\n");

            // 3) Trim leading/trailing whitespace and collapse any run of whitespace to a single space
            String normExpected = predefinedResponsesUploadExpected.trim().replaceAll("\\s+", " ");
            String normActual   = actual  .trim().replaceAll("\\s+", " ");

            //System.out.printf("NORM EXPECTED → «%s» (len=%d)%n", normExpected, normExpected.length());
            //System.out.printf("NORM ACTUAL   → «%s» (len=%d)%n", normActual,   normActual.length());

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

    public void confirmMultiTextRating(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming rating in Multi Text item");
            WebElement selectedRating = getDriver().findElement(By.xpath("//lib-rating//span[contains(text(), '" + text + "')]"));
            String selectedRatingText = selectedRating.getText();
            waitForWebElementToBeVisible(selectedRating);
            System.out.println("Multi Text Rating set to: " + selectedRatingText);
            Assert.assertTrue(selectedRatingText.contains(text), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }

    }

    public void confirmRating(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming " + option + " is the selected entry for '" + item + "' ");
            if (item.equals("This is a Rating")) {
                if (option.equals("Y")) {
                    Assert.assertTrue(selectedY.isDisplayed());
                    Assert.assertTrue(deselectedN.isDisplayed());
                    Assert.assertTrue(deselectedM.isDisplayed());

                }
                if (option.equals("M")) {
                    Assert.assertTrue(deselectedY.isDisplayed());
                    Assert.assertTrue(deselectedN.isDisplayed());
                    Assert.assertTrue(selectedM.isDisplayed());
                }
                if (option.equals("N")) {
                    Assert.assertTrue(deselectedY.isDisplayed());
                    Assert.assertTrue(selectedN.isDisplayed());
                    Assert.assertTrue(deselectedM.isDisplayed());
                }
            }

            if (item.equals("This is Multi Text")) {
                if (option.equals("1")) {
                    Assert.assertTrue(selected1.isDisplayed());
                    Assert.assertTrue(deselected2.isDisplayed());
                    Assert.assertTrue(deselected3.isDisplayed());
                }
                if (option.equals("2")) {
                    Assert.assertTrue(deselected1.isDisplayed());
                    Assert.assertTrue(selected2.isDisplayed());
                    Assert.assertTrue(deselected3.isDisplayed());
                }
                if (option.equals("3")) {
                    Assert.assertTrue(deselected1.isDisplayed());
                    Assert.assertTrue(deselected2.isDisplayed());
                    Assert.assertTrue(selected3.isDisplayed());
                }
            }
            System.out.println("Ratings are displayed correctly");

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm ratings");
        }
    }
}


