package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;
import utils.globalVariables;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertTrue;

public class confirmationFunctions extends Base_PO {
    CreateReport_PO createReport_po;
    TestAllControlsRM_PO testAllControlsRM_po;


    private @FindBy(id = "client-name") WebElement client;

    public @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and @spellcheck='false']") WebElement extractedCoordinates;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiTextItem;
    public @FindBy(xpath = "//lib-single-text//span[contains(@class,'single-text')][1]") WebElement singleText;
    public @FindBy(xpath = "//div[@class='editor-item__title'and contains(., ' This is Prefilled Text (Single) ')]/following::lib-single-text/span[@class='single-text']") WebElement singlePrefilledText;
    public @FindBy(xpath = "//lib-numeric-input//input[@numericfield]") WebElement numericItem;


    private String boldText = "This is bold text";
    private String italicsText = "This is italicized text";
    private String underlineText = "This is underlined text";
    private String strikethroughText = "This is strikethrough text";
    private String bulletlist1Text = "Bullet list entry 1";
    private String bulletlist2Text = "Bullet list entry 2";
    private String bulletlist3Text = "Bullet list entry 3";
    private String numlist1Text = "Number list entry 1";
    private String numlist2Text = "Number list entry 2";
    private String numlist3Text = "Number list entry 3";
    private String actualValue;


    //Report details
    public @FindBy(xpath = "//input[@id='report-date']") WebElement detailsInspectionDate;
    public @FindBy(xpath = "//input[@id='due-date']") WebElement detailsDueDate;

    //Co-ordinates check
    public @FindBy(css= "[id*='mat-input-']") WebElement coordinatesCheck;


    //Ratings
        //Define selected/deselected options 'This is a Rating'
        public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'selected')]//span[contains(text(), 'Y')]") WebElement selectedY;
        public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'selected')]//span[contains(text(), 'N')]") WebElement selectedN;
        public @FindBy(xpath = "//lib-read-only-rating[contains(@class, 'selected')]//span[contains(text(), 'M')]") WebElement selectedM;

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


    //Ratings report view
    public @FindBy(xpath = "//lib-read-only-rating[@class='ng-star-inserted']//span[normalize-space(text())='1']") WebElement multiTextReportViewRating1;
    public @FindBy(xpath = "//lib-editor-item[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'N')]") WebElement reportViewNRating;
    public @FindBy(xpath = "//lib-editor-item[contains(@class, 'ng-star-inserted')]//span[contains(text(),' M')]") WebElement reportViewMRating;



    //Baked In
    public @FindBy(xpath = "//quill-editor//p[contains (text(), 'These are the baked in values:')]") WebElement bakedInTokens;
    //public @FindBy(xpath = "//quill-editor//div[contains(@class, 'ql-editor')]") WebElement bakedInTokens;


    //Numeric elements
    public @FindBy(css = "//lib-numeric-input//input") WebElement numeric;

    //Targeted Notes
    private @FindBy(css = "div.multi-text-item") WebElement targetedNotesText;
    private @FindBy(css = "div.notes-item") WebElement notesItem;

    //Images Report View
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This is Multi Text')]/ancestor::lib-editor-item[1]//span[contains(@class,'attachment-count')]") WebElement multiTextAttachmentsReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This Is Single Text')]/ancestor::lib-editor-item[1]//span[contains(@class,'attachment-count')]") WebElement singleTextAttachmentsReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'Preformatted Text for Copy/Paste Tests')]/ancestor::lib-editor-item[1]//span[contains(@class,'attachment-count')]") WebElement preformattedAttachmentsReportView;

    //Notes Report View
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'Preformatted Text for Copy/Paste Tests')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement preformattedNotesReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This is a Date')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement dateNotesReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This is a Switch')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement switchNotesReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'Multi Select Pick List')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement multiPickListNotesReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This is Predefined Responses')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement predefinedResponsesNotesReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This is a Rating')]/ancestor::lib-editor-item[1]//lib-notes//div[contains(@class,'notes-item')]") WebElement ratingNotesReportView;


    //Report view expected values
    private String preformattedTextExpected = "This is normal text\n" +
             "This is bold text\n" +
             "This is italicised text\n" +
             "This is underlined text\n" +
             "This is multiple formats text which needs to be slightly longer\n";
    private String singleTextExpected = "Single line of text entered into the single item text item";
    private String multiTextExpected = "This is bold text\n" +
            "This is italicized text\n" +
            "This is underlined text\n" +
            "This is strikethrough text";
    private String multiTextRatingExpected = "1";
    private String prefilledSingleExpected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.";
    private String prefilledSingleEditedExpected = "This item was previously prefilled but has now been replaced with this text";
    private String prefilledMultiExpected = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateExpected = "10 October 2025";
    private String switchExpected = "Switch 2";
    private String multiPicklistExpected = "Option 2,Option 3";
    private String bakedInTokensExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private String predefinedResponsesExpected = "Multiple more entries are required to test\n" +
            " Third option specifically for testing \n" +
            " Text the same as the button for testing purposes";

    private String numericExpected = "0.123";
    private String numericExpected2 = "1.23";
    private String enterBoldExpected = "Entering some bold text to confirm form uploads correctly";
    private String enterItalicsExpected = "Entering some italics text to confirm form uploads correctly";
    private String enterUnderlinedExpected = "Entering some underlined text to confirm form uploads correctly";
    private String enterMultiformatExpected = "Bold text with some added italics, added underline but removed bold, completed with strikethrough changed with simple bold and finally removed all formatting";
    private String ratingExpected = "N";

    //Cloned Report View Expected
    private String enterMultiFormattedExpectedCloned = "Multi formatted text to check that all of the options will work together if a single sentenc is entered. We have a couple here a couple here as well but here's 3";
    private String preformattedAttachmentsReportViewExpectedCloned = "3";
    private String singleTextAttachmentsReportViewExpectedCloned = "1";
    private String multiTextAttachmentsReportViewExpectedCloned = "2";





    public confirmationFunctions() throws IOException, URISyntaxException {

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
    }

    
    //Report details
    public void confirmReportDetailsInspectionDate(String date) throws IOException, URISyntaxException {
        try {
            String inspectionDate    = globalFunctions.jsRetriever(detailsInspectionDate);

            String enteredDate = globalFunctions.reportDateGenerator(date);
            System.out.println("Confirming Date displayed in report details");
            System.out.println("\"" + inspectionDate + "\" is displayed in report details");
            //System.out.println("\"" + enteredDate + "\" is passed in date");
            Assert.assertTrue(inspectionDate.contains(enteredDate));

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmReportDetailsDueDate(String date) throws IOException, URISyntaxException {
        try {
            String dueDate    = globalFunctions.jsRetriever(detailsDueDate);

            String enteredDate = globalFunctions.reportDateGenerator(date);
            System.out.println("Confirming Date displayed in report details");
            System.out.println("\"" + dueDate + "\" is displayed in report details");
            //System.out.println("\"" + enteredDate + "\" is passed in date");
            Assert.assertTrue(dueDate.contains(enteredDate));

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmReportDetailsNotes(String notes) throws IOException, URISyntaxException {
        try {
            String detailsNotes = globalFunctions.jsRetriever(createReport_po.extraNotes);

            System.out.println("Confirming notes displayed in report details");
            System.out.println("\"" + detailsNotes + "\" is displayed in report details");
            Assert.assertTrue(detailsNotes.contains(notes));

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmNotesFormatting() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming formatting");
            waitForWebElementToBeVisible(multiTextItem);

            String enteredText = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", multiTextItem);

            //System.out.println("Retrieved Text: " + enteredText);

            // Confirm normal text
            System.out.println("Confirming normal text is present");
            Assert.assertTrue(enteredText.contains("<p>This is normal text</p>"), "Actual text does not contain bold text.");


            // Confirm bold text
            System.out.println("Confirming bold text is present");
            Assert.assertTrue(enteredText.contains("<p><strong>This is bold text</strong></p>"), "Actual text does not contain bold text.");

            // Confirm italicised text
            System.out.println("Confirming italicised text is present");
            Assert.assertTrue(enteredText.contains("<p><em>This is italicised text</em></p>"), "Actual text does not contain italicised text.");

            // Confirm underlined text
            System.out.println("Confirming underlined text is present");
            Assert.assertTrue(enteredText.contains("<p><u>This is underlined text</u></p>"), "Actual text does not contain underlined text.");

            // Confirm strikethrough text
            System.out.println("Confirming strikethrough text is present");
            Assert.assertTrue(enteredText.contains("<p><s>This is strikethrough text</s></p>"), "Actual text does not contain strikethrough text.");


        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm text formatting");
        }

    }

   /* public void confirmReportViewSwitch(String selectSwitch) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(switchReportView);
            System.out.println("- Confirming selected Switch in report view");
            String actualSwitchReportViewText = switchReportView.getText();
            System.out.println("- \"" + actualSwitchReportViewText + "\" is displayed in report view");
            Assert.assertTrue(switchExpected.contains(actualSwitchReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("unable to confirm switch selection in report view");
        }

    }


    //Notes tests
    public void confirmNotesFormatting() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming formatting");
            waitForWebElementToBeVisible(multiTextItem);

            String enteredText = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", multiTextItem);

            //System.out.println("Retrieved Text: " + enteredText);

            // Confirm normal text
            System.out.println("Confirming normal text is present");
            Assert.assertTrue(enteredText.contains("<p>This is normal text</p>"), "Actual text does not contain bold text.");


            // Confirm bold text
            System.out.println("Confirming bold text is present");
            Assert.assertTrue(enteredText.contains("<p><strong>This is bold text</strong></p>"), "Actual text does not contain bold text.");

            // Confirm italicised text
            System.out.println("Confirming italicised text is present");
            Assert.assertTrue(enteredText.contains("<p><em>This is italicised text</em></p>"), "Actual text does not contain italicised text.");

            // Confirm underlined text
            System.out.println("Confirming underlined text is present");
            Assert.assertTrue(enteredText.contains("<p><u>This is underlined text</u></p>"), "Actual text does not contain underlined text.");

            // Confirm strikethrough text
            System.out.println("Confirming strikethrough text is present");
            Assert.assertTrue(enteredText.contains("<p><s>This is strikethrough text</s></p>"), "Actual text does not contain strikethrough text.");


        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm text formatting");
        }

    }

    public void confirmReportViewNumeric(String number) throws IOException, URISyntaxException {
        try {
            System.out.println("Checking Numeric report view value");
            waitForWebElementToBeVisible(numericReportView);
            String actualNumericReportViewText = numericReportView.getText();
            System.out.println("\"" + actualNumericReportViewText + "\" is displayed in report view");
            Assert.assertTrue(numericExpected.contains(actualNumericReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm numeric entry");
        }
    }

    public void confirmReportViewDate(String specifiedViewDate) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming Date displayed in report view");
            waitForWebElementToBeVisible(dateReportView);
            System.out.println("Confirming report view date");
            String actualReportViewText = dateReportView.getText();
            System.out.println("\"" + actualReportViewText + "\" is displayed in report view");
            Assert.assertTrue(actualReportViewText.contains(specifiedViewDate));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmReportViewRating(String option) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Checking Rating report view value");
        try{
            waitForWebElementToBeVisible(ratingReportView);
            String actualRatingReportViewText = ratingReportView.getText();
            System.out.println("\"" + actualRatingReportViewText + "\" is displayed in report view");
            Assert.assertTrue(ratingExpected.contains(actualRatingReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmReportViewMultiRating(String option) throws IOException, URISyntaxException, InterruptedException {
        // Confirm first rating entry //lib-read-only-rating[contains(@class, 'ng-star-inserted')]//span[contains(text(), 'Y')]
        try{
            System.out.println("Confirming selected Multi Text Rating in report view");
            WebElement reportViewRating = getDriver().findElement(By.xpath("//lib-read-only-rating[@class='ng-star-inserted']//span[normalize-space(text())='" + option + "']"));
            Assert.assertTrue(reportViewRating.isDisplayed());
            System.out.println("\"" + reportViewRating + "\" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text rating in report view");
        }

    }

    public void confirmReportViewPredefinedResponses() {


        try{
            String actual   = predefinedResponsesReportView.getText();
            System.out.println("Confirming Predefined Responses in report view");
            // 1) Debug print with delimiters and lengths
            //System.out.printf("EXPECTED → «%s» (len=%d)%n", predefinedResponsesExpected, predefinedResponsesExpected.length());
            //System.out.printf("ACTUAL   → «%s» (len=%d)%n", actual,   actual.length());

            // 2) Normalize line endings to Unix style (just in case)
            predefinedResponsesExpected = predefinedResponsesExpected.replaceAll("\\r\\n?", "\n");
            actual   = actual  .replaceAll("\\r\\n?", "\n");

            // 3) Trim leading/trailing whitespace and collapse any run of whitespace to a single space
            String normExpected = predefinedResponsesExpected.trim().replaceAll("\\s+", " ");
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
            System.out.println("\"" + actual + "\" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm predefined responses");
        }
    }*/

    //Images and Notes
    public void confirmClonedReportViewPreformattedTextImages() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Preformatted Text with Images in report view");
            waitForWebElementToBeVisible(preformattedAttachmentsReportView);
            String reportViewPreformattedAttachments = preformattedAttachmentsReportView.getText();
            System.out.println("\"" + reportViewPreformattedAttachments + "\" images are displayed in report view");
            Assert.assertTrue(preformattedAttachmentsReportViewExpectedCloned.contains(reportViewPreformattedAttachments), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text and images in report view");
        }
    }

    public void confirmClonedReportViewSingleTextImages() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Single Text and Images in report view");
            //waitForWebElementToBeVisible(singleTextAttachmentsReportView);
            String reportViewSingleTextAttachments = singleTextAttachmentsReportView.getText();
            System.out.println("\"" + reportViewSingleTextAttachments + "\" images are displayed in report view");
            Assert.assertTrue(singleTextAttachmentsReportViewExpectedCloned.contains(reportViewSingleTextAttachments), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text and images in report view");
        }
    }

    public void confirmClonedReportViewMultiTextImages() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Multi Text and Images in report view");
            waitForWebElementToBeVisible(multiTextAttachmentsReportView);
            String reportViewMultiTextAttachments = multiTextAttachmentsReportView.getText();
            System.out.println("\"" + reportViewMultiTextAttachments + "\" images are displayed in report view");
            Assert.assertTrue(multiTextAttachmentsReportViewExpectedCloned.contains(reportViewMultiTextAttachments), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text and images in report view");
        }
    }


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

    
    //Items
    public void confirmCorrectMultiText(String entry, String multiItem) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming text in: " + multiItem);
            waitForWebElementToBeVisible(multiTextItem);

            String itemText = multiTextItem.getText();

            String normActual   = norm(itemText);
            String normExpected = norm(entry);

            System.out.println("- " + multiItem + " value (norm): " + normActual);
            System.out.println("- Expected (norm): " + normExpected);

            Assert.assertTrue(
                    normActual.contains(normExpected),
                    "Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmCorrectSingleText(String entry, String singleItem) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming text in: " + singleItem);
            waitForWebElementToBeVisible(singleText);

            String itemText = singleText.getText();

            String normActual   = norm(itemText);
            String normExpected = norm(entry);

            System.out.println("- " + singleText + " value (norm): " + normActual);
            System.out.println("- Expected (norm): " + normExpected);

            Assert.assertTrue(
                    normActual.contains(normExpected),
                    "Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text");
        }
    }

    public void confirmDateValue(String item, String value) throws IOException, URISyntaxException {
        try {
            WebElement selectedDateValue = getDriver().findElement(
                    By.xpath("//span[contains(@class, 'mat-calendar-body-selected')]")
            );
            System.out.println("- Confirming " + item + " value");
            String selectedValue = selectedDateValue.getText();
            System.out.println("- Current selected date value: " + selectedValue);
            Assert.assertTrue(
                    selectedValue.contains(value),
                    "Actual text does not contain expected text."
            );
            selectedDateValue.click();


        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text");
        }
        }

    public void confirmOptionNotSelected(String option, String item) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming " + item + "" + option + " is NOT selected");

            WebElement notSelectedOption = getDriver().findElement(
                    By.xpath("//lib-options-list-item[contains(., '" + option + "')]")
            );

            Assert.assertNull(notSelectedOption.getAttribute("selected-option"),
                    "Element should not have 'selected-option' attribute");

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm option not selected");
        }
    }

    public void confirmOptionSelected(String option, String item) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming " + item + " " + option + " is selected");

            WebElement selectedOption = getDriver().findElement(
                    By.xpath("//*[contains(@class, 'selected-option') and contains(., '" + option + "')]")
            );

            Assert.assertTrue(selectedOption.isDisplayed(), "Option element not visible");
            System.out.println("- " + option + " is selected");

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm option selected");
        }
    }

    public void confirmTextFormat(String entry, String item) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming text in: " + item);
            waitForWebElementToBeVisible(multiTextItem);

            String itemText = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", multiTextItem);


            String normActual   = norm(itemText);
            String normExpected = norm(entry);

            System.out.println("- " + item + " value (norm): " + normActual);
            System.out.println("- Expected (norm): " + normExpected);

            Assert.assertTrue(normActual.contains(normExpected),"Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmRating(String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming " + rating + " is the selected entry for '" + item + "' ");
            if (item.equals("This is a Rating")) {
                if (rating.equals("Y")) {
                    Assert.assertTrue(selectedY.isDisplayed());
                    Assert.assertTrue(deselectedN.isDisplayed());
                    Assert.assertTrue(deselectedM.isDisplayed());

                }
                if (rating.equals("M")) {
                    Assert.assertTrue(deselectedY.isDisplayed());
                    Assert.assertTrue(deselectedN.isDisplayed());
                    Assert.assertTrue(selectedM.isDisplayed());
                }
                if (rating.equals("N")) {
                    Assert.assertTrue(deselectedY.isDisplayed());
                    Assert.assertTrue(selectedN.isDisplayed());
                    Assert.assertTrue(deselectedM.isDisplayed());
                }
            }

            if (item.equals("This is Multi Text")) {
                if (rating.equals("1")) {
                    Assert.assertTrue(selected1.isDisplayed());
                    Assert.assertTrue(deselected2.isDisplayed());
                    Assert.assertTrue(deselected3.isDisplayed());
                }
                if (rating.equals("2")) {
                    Assert.assertTrue(deselected1.isDisplayed());
                    Assert.assertTrue(selected2.isDisplayed());
                    Assert.assertTrue(deselected3.isDisplayed());
                }
                if (rating.equals("3")) {
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

    public void confirmMultiText(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming text in multi text item");
            waitForWebElementToBeVisible(multiTextItem);
            System.out.println("Text parsed: " + text);
            String multiText = multiTextItem.getText();
            System.out.println("multiText: " + multiText);
            Assert.assertTrue(multiText.contains(text), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text");
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

    public void confirmSinglePrefilledText() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in prefilled text (single) item");
            waitForWebElementToBeVisible(singleText);
            String reportPrefilledSingleText = singleText.getText();
            System.out.println("singleText: " + reportPrefilledSingleText);
            Assert.assertTrue(prefilledSingleExpected.contains(reportPrefilledSingleText), "Actual text does not contain expected text.");
            System.out.println("Confirmed Single Text Prefilled item contains correct text");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single prefilled text");
        }

    }
    
    public void confirmCorrectMultiPrefilledText() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in multi text prefilleditem");
            waitForWebElementToBeVisible(multiTextItem);
            String prefilledText = multiTextItem.getText();
            System.out.println("multiTextItem: " + multiTextItem);
            Assert.assertEquals(prefilledText, "Single Sentence\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.\n" +
                    "\n" +
                    "New Paragraph\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.");
            System.out.println(" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmBakedInTokens() throws IOException, URISyntaxException {

        try {
            waitForWebElementToBeVisible(bakedInTokens);
            System.out.println("Confirming baked in tokens value:");
            String actualBakedInTokensText = bakedInTokens.getText();
            //System.out.println(actualBakedInTokensText);
            System.out.println("Expected Baked In: \n" + bakedInTokensExpected + "\n");
            System.out.println("Baked in Tokens value: \n" + actualBakedInTokensText + "\n");
            Assert.assertTrue(bakedInTokensExpected.contains(actualBakedInTokensText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }
    }

    public void confirmSingleResponse(String response) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming single response '" + response + "' saved");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String enteredResponse = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            //System.out.println("Expected text: " + response);
            //System.out.println("Actual text: " + enteredResponse);
            Assert.assertTrue(enteredResponse.contains(response),
                    "Expected response to contain: " + response + ", but was: " + enteredResponse);
            System.out.println("- Previous response confirmed saved");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to confirm single response");
        }
    }
    
    public void confirmNumeric(String expectedText) {
        try {
            //System.out.println("Confirming text in numeric item, expected value: " + expectedText);

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

            System.out.println("- Numeric field value: " + actualValue);

            Assert.assertTrue(actualValue.contains(expectedText),
                    "Expected value to contain: '" + expectedText + "', but was: '" + actualValue + "'");

            //System.out.println("Confirmed presence of expected text: '" + expectedText + "'");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to confirm numeric field()");
        }
    }

    public void confirmEnterMultiFormattedText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'Enter Bold Text' ");
            String actualEnterMultiFormattedText = multiTextItem.getText();
            System.out.println("- \"" + actualEnterMultiFormattedText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(enterMultiFormattedExpectedCloned.contains(actualEnterMultiFormattedText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm enter multiformatted text");
        }
    }


    public void confirmTextDeletion(String textToDelete) throws MalformedURLException, URISyntaxException {
        try{
            String itemText = multiTextItem.getText();
            System.out.println("- Confirming text deleted");

            Assert.assertFalse(itemText.contains(textToDelete),
                    "Text should NOT contain: '" + textToDelete + "', but it was found.");

            System.out.println("- Text confirmed deleted");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date");
        }
    }

    public void confirmCoordinates() throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming co-ordinates present (requires actual location validation)");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", extractedCoordinates);

            System.out.println("- Extracted co-ordinates - " + coordinatesText);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm co-ordinates");
        }
    }

    public void confirmNotEmpty() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming data maintained");
            Thread.sleep(2000);
            waitForWebElement(coordinatesCheck);
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", coordinatesCheck);
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void confirmEmpty() throws IOException, URISyntaxException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String coordinatesText = (String) js.executeScript("return arguments[0].value;", createReport_po.referenceText);
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

    public void confirmRatingMultiItemsDeselected(String option) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming rating " + option + " is not selected");

            // 1. UPDATED XPATH
            // We look for the parent div (rating-option) that contains the text span.
            // We removed 'opacity-30' so we can find the element even if it IS selected (to fail the assertion properly).
            String xpath = "//lib-rating[contains(@class, 'ng-star-inserted')]//div[contains(@class, 'rating-option') and .//span[normalize-space(text())='" + option + "']]";

            WebElement ratingItem = getDriver().findElement(By.xpath(xpath));

            // 2. CHECK CLASS ATTRIBUTE
            String classAttribute = ratingItem.getAttribute("class");
            List<String> classes = Arrays.asList(classAttribute.split("\\s+"));

            // 3. ASSERTION
            // We expect "selected" to NOT be present.
            Assert.assertFalse(classes.contains("selected"),
                    "Error: Expected item '" + option + "' to be deselected, but it has the 'selected' class.");

            System.out.println(option + " is not selected");

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to find rating item '" + option + "' in the DOM.");
        }
    }

    public void confirmRatingItemDeselected(String option) {
        try {
            System.out.println("Confirming rating " + option + " is not selected");

            // 1. DYNAMIC XPATH
            // This finds the DIV with class 'rating-option' that contains a SPAN with your specific text
            String xpath = "//div[contains(@class, 'rating-option') and .//span[normalize-space(text())='" + option + "']]";

            WebElement ratingItem = getDriver().findElement(By.xpath(xpath));

            // 2. CHECK CLASS ATTRIBUTE
            String classAttribute = ratingItem.getAttribute("class");

            // Split classes into a list to avoid partial matches
            List<String> classes = Arrays.asList(classAttribute.split("\\s+"));

            // 3. ASSERTION
            // We assert False: "selected" should NOT be in the list
            Assert.assertFalse(classes.contains("selected"),
                    "Error: The option '" + option + "' implies it IS selected (found 'selected' class).");

            System.out.println(option + " is not selected");

        } catch (NoSuchElementException | IOException | URISyntaxException e) {
            Assert.fail("Unable to find rating item '" + option + "' in the DOM.");
        }
    }


    //Text formatting confirmation
    public void confirmFormatting() throws IOException, URISyntaxException {
        try {
            System.out.print("Confirming MultiText retained \n");
            //System.out.println("Confirming formatting");
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

    public void confirmSpecificMultiFormat() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming Multiformatted text");

            By editorLocator = By.xpath("//div[contains(@class, 'ql-editor')]");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(editorLocator));

            String htmlContent = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", editor);

            String firstPart = "<strong>Bold text with <em>some added italics, ";
            String secondPart = "<em><u>added underline but removed bold, ";
            String thirdPart = "<s><u>completed with strikethrough";
            String fourthPart = "<strong><s>changed with simple bold and finally";

            Assert.assertTrue(htmlContent.contains("<strong>Bold text with <em>some added italics,"), "Expected bold with italic text");
            Assert.assertTrue(htmlContent.contains("<em><u>added underline but removed bold,"), "Expected underlined italic text");
            Assert.assertTrue(htmlContent.contains("<s><u>completed with strikethrough"), "Expected underlined strikethrough");
            Assert.assertTrue(htmlContent.contains("<strong><s>changed with simple bold and finally"), "Expected bold strikethrough");

            System.out.println("\"" + firstPart + secondPart + thirdPart + fourthPart + "\" is displayed");
            //System.out.println("Confirmed correct Multiformatted text present");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single multi formatting");
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
            waitForWebElement(numberItem);
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

    public void confirmNumToBulletlist() throws IOException, URISyntaxException {
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

    public void confirmMultiTextBulletlist() throws IOException, URISyntaxException {
        try{
            // Confirm bullet list entries
            WebElement bulletItem = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bulletlist1Text + "')]"));
            Assert.assertTrue(bulletItem.isDisplayed());
            System.out.println("Bullet list entry 1 is correctly formatted");
            //System.out.println(bullet1Text);


            WebElement bulletItem2 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bulletlist2Text + "')]"));
            Assert.assertTrue(bulletItem2.isDisplayed());
            System.out.println("Bullet list entry 2 is correctly formatted");
            //System.out.println(bullet2Text);

            WebElement bulletItem3 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bulletlist3Text + "')]"));
            Assert.assertTrue(bulletItem3.isDisplayed());
            System.out.println("Bullet list entry 3 is correctly formatted");
            //System.out.println(bullet3Text);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm bullet list");
        }
    }

    public void confirmFormattedNotesTextInReportView() throws IOException, URISyntaxException {
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

    public void confirmExtraTextSaved(String additionalText) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming saved extra text present: '" + additionalText + "'");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String prefilledText = (String) js.executeScript("return arguments[0].textContent;", multiTextItem);
            //System.out.println("Actual text: " + prefilledText);

            assertTrue("- Expected text to contain: '" + additionalText + "', but was: '" + prefilledText + "'",
                    prefilledText.contains(additionalText));
            //System.out.println("Extracted text - " + prefilledText);
            System.out.println("Extra text successfully saved");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        }

    }

    public void confirmLocationCoordinates() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming co-ordinates present (requires actual location validation)");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //String coordinatesText = (String) js.executeScript("return arguments[0].value;", multiTextItem);
            System.out.println("- Extracting coordinates");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(multiTextItem));
            String coordinatesText = multiTextItem.getText();

            System.out.println("- Extracted co-ordinates: " + coordinatesText);

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm co-ordinates");
        }
    }

    public void confirmOnlyReportIsListed(String expectedTitle) throws Exception {
        try {
            System.out.println("- Confirming ONLY this report is listed: " + expectedTitle);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));

            // 1. SMART WAIT: Wait until the list actually filters down to exactly 1 report
            // Using .text-xl as we did in the previous working step
            By reportLocator = By.cssSelector(".text-xl");
            wait.until(ExpectedConditions.numberOfElementsToBe(reportLocator, 1));

            // 2. Grab the single element
            List<WebElement> actualReportElements = getDriver().findElements(reportLocator);
            String actualTitle = actualReportElements.get(0).getText().trim();

            System.out.println("- Found 1 report: " + actualTitle);

            // 3. Verify it contains the text (contains is safer than equals for partial matches)
            Assert.assertTrue(actualTitle.contains(expectedTitle),
                    "Expected report to contain '" + expectedTitle + "' but found: " + actualTitle);

        } catch (Exception e) {
            Assert.fail("Failed to verify single report listing: " + e.getMessage());
        }
    }

    public void confirmReportAndSubtitleExists(String expectedTitle, String expectedSubtitle) throws Exception {
        try {
            System.out.println("- Searching list for: " + expectedTitle + " | " + expectedSubtitle);

            // 1. Grab all card containers
            // Based on your HTML: <div class="flex flex-col w-full h-full pt-4 pb-2 px-6">
            List<WebElement> allCards = getDriver().findElements(By.cssSelector(".flex-col.px-6"));

            boolean isMatchFound = false;

            // 2. Loop through every card found
            for (WebElement card : allCards) {
                String actualTitle = card.findElement(By.cssSelector(".text-xl")).getText().trim();

                // Note: Using the mb-3 class to isolate the subtitle from the "TIC" header
                String actualSubtitle = card.findElement(By.cssSelector(".text-secondary.mb-3")).getText().trim();

                if (actualTitle.contains(expectedTitle) && actualSubtitle.contains(expectedSubtitle)) {
                    System.out.println("- Match found: " + actualTitle + " [" + actualSubtitle + "]");
                    isMatchFound = true;
                    break; // Stop looking once we find the winner
                }
            }

            // 3. Final Assertion
            Assert.assertTrue(isMatchFound,
                    "Could not find a report card with Title: '" + expectedTitle +
                            "' and Subtitle: '" + expectedSubtitle + "'. Searched " + allCards.size() + " cards.");

        } catch (Exception e) {
            Assert.fail("Error while searching through report cards: " + e.getMessage());
        }
    }

    public void confirmOnlyReportWithSubtitle(String expectedTitle, String expectedSubtitle) throws Exception {
        try {
            System.out.println("- Verifying single report: " + expectedTitle + " | " + expectedSubtitle);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));

            // 1. Wait for exactly 1 card to exist (using the outer container class)
            By cardLocator = By.cssSelector(".flex-col.px-6");
            wait.until(ExpectedConditions.numberOfElementsToBe(cardLocator, 1));

            WebElement card = getDriver().findElement(cardLocator);

            // 2. Extract Main Title (Tables - Image Checking...)
            String actualTitle = card.findElement(By.cssSelector(".text-xl")).getText().trim();

            // 3. Extract Secondary Text (TABLE ROW EDITING...)
            // Note: There are multiple text-secondary classes, we want the first one with text
            String actualSubtitle = card.findElement(By.cssSelector(".text-secondary.mb-3")).getText().trim();

            System.out.println("- Found Title: " + actualTitle);
            System.out.println("- Found Subtitle: " + actualSubtitle);

            // 4. Assertions
            Assert.assertTrue(actualTitle.contains(expectedTitle),
                    "Title mismatch! Expected to contain: " + expectedTitle + " but got: " + actualTitle);

            Assert.assertTrue(actualSubtitle.contains(expectedSubtitle),
                    "Subtitle mismatch! Expected to contain: " + expectedSubtitle + " but got: " + actualSubtitle);

        } catch (Exception e) {
            Assert.fail("Failed to verify report and subtitle: " + e.getMessage());
        }
    }

    public void confirmDatacaptureSearch(String reportName, String datacapture) throws Exception {
        try {

            String normReportName = norm(reportName);
            Assert.assertFalse(
                    getDriver().findElements(By.xpath("//div[contains(text(), '" +  normReportName + "')]")).isEmpty(),
                    "The 'TEST ALL CONTROLS RM' text was NOT found on the page!"
            );

            Assert.assertFalse(
                    getDriver().findElements(By.xpath("//div[contains(text(), '" +  datacapture + "')]")).isEmpty(),
                    "The 'Search - Found Me' text was NOT found on the page!"
            );

        } catch (Exception e) {
            Assert.fail("Failed to verify report and subtitle: " + e.getMessage());
        }
    }

    public void confirmProjectSaved(String project) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming project correct: '" + project + "'");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String displayedProject = createReport_po.project.getText();
            //System.out.println("Actual text: " + prefilledText);

            assertTrue("- Expected text to contain: '" + project + "', but was: '" + displayedProject + "'",
                    displayedProject.contains(project));

            System.out.println("Project verified");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        }

    }

    public void confirmProjectCard(String projectCard) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming project in report card correct: '" + projectCard + "'");
            Assert.assertFalse(
                    getDriver().findElements(By.xpath("//div[contains(@class, 'text-secondary') and contains(text(), '" + projectCard + "')]")).isEmpty(),
                    "The project card '" + projectCard + "' was not found on the page!");

            System.out.println("Project card verified");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        }

    }

    public void confirmClientSaved(String client) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming client correct: '" + client + "'");
            //System.out.println("Extracting text");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            Thread.sleep(1000);
            String displayedClient = createReport_po.client.getText();
            //System.out.println("Actual text: " + prefilledText);

            assertTrue("- Expected text to contain: '" + client + "', but was: '" + displayedClient + "'",
                    displayedClient.contains(client));

            System.out.println("Client verified");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void confirmClientCard(String clientCard) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming client in report card correct: '" + clientCard + "'");
            Thread.sleep(1000);
            Assert.assertFalse(
                    getDriver().findElements(By.xpath("//div[contains(@class, 'text-secondary') and contains(text(), '" + clientCard + "')]")).isEmpty(),
                    "The client card '" + clientCard + "' was not found on the page!");

            System.out.println("Project card verified");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm extra text has been saved");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

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

    public void confirmTableEntry(String column, int row, String fieldValue) {

        int actualRow = row - 1;
        String dynamicXPath = "//div[contains(@row-id, '" + actualRow + "')]//div[contains(@col-id, '" + column + "')]";
        WebElement cell = null;

        try {
            try {
                WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
                cell = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));

            } catch (TimeoutException e) {
                System.out.println("- Cell not found on screen. Scrolling grid to the right...");
                ((JavascriptExecutor) getDriver()).executeScript(
                        "document.querySelectorAll('.ag-body-viewport, .ag-center-cols-viewport').forEach(vp => vp.scrollLeft += 1000);"
                );
                Thread.sleep(500);

                WebDriverWait longWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
                cell = longWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
            }

            System.out.println("cell variable holds: " + cell);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", cell);

            String actualFieldEntry = cell.getText().trim();

            System.out.println("- tableField " + column + " value = " + actualFieldEntry);
            Assert.assertTrue(actualFieldEntry.contains(fieldValue),
                    "The table field did not match! Expected it to contain: '" + fieldValue + "', but found: '" + actualFieldEntry + "'");

            System.out.println("Table field " + column + " contains value '" + actualFieldEntry + "' so is correct");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void confirmImagesGridNotPresent() throws IOException, URISyntaxException {
        Assert.assertTrue(getDriver().findElements(By.xpath("//*[@data-icon='grid']")).isEmpty(), "The element is still on the page!");

    }

    public void confirmAudioPresent() throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//lib-audio-browser")));

        Assert.assertFalse(getDriver().findElements(By.xpath("//lib-audio-browser")).isEmpty(), "The element is not on the page!");

    }

    public void confirmAudioNotPresent() throws IOException, URISyntaxException, InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(getDriver().findElements(By.xpath("//lib-audio-browser")).isEmpty(), "The element is still on the page!");

    }



/*
    public void confirmTableEntry(String column,int row , String fieldValue ) throws IOException, URISyntaxException {
        try{
            WebElement tableField = getDriver().findElement(By.xpath("//div[@row-index='" + row + "']//div[@col-id='" + column + "']"));

            // 'block' handles vertical, 'inline' handles horizontal
            String script = "arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});";
            ((JavascriptExecutor) getDriver()).executeScript(script, tableField);

            String actualFieldEntry = tableField.getText();
            System.out.println("- tableField value = " + actualFieldEntry);

            Assert.assertTrue(fieldValue.contains(actualFieldEntry));
            System.out.println("Table field is correct");

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm table field");
        }
    }

/*


    public void confirmSingleText(String text) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming text in single text item");
            waitForWebElementToBeVisible(singleText);
            String reportSingleText = singleText.getText();
            System.out.println("Single Text value: " + reportSingleText);
            Assert.assertTrue(text.contains(reportSingleText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text");
        }
    }

*/


}


