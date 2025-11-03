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
import pageObjects.CreateReport_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertTrue;

public class confirmationFunctionsConfirmCloned extends Base_PO {
    CreateReport_PO createReport_po;

    public @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and @spellcheck='false']") WebElement extractedTextField;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement multiTextItem;
    public @FindBy(xpath = "//input") WebElement singleTextItem;
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


    //Cloned Report View Expected
    private String preformattedTextClonedExpected = "This is normal text\n" +
            "This is bold text\n" +
            "This is italicised text\n" +
            "This is underlined text\n" +
            "This is multiple formats text which needs to be slightly longer\n";
    private String singleTextClonedExpected = "Photo in Notes so what happens if photo without notes?";
    private String multiTextClonedExpected = "Enter\n" +
            "Multi\n" +
            "Two photos attached\n";
    private String prefilledSingleClonedExpected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.";
    private String prefilledSingleEditedClonedExpected = "This item was previously prefilled but has now been replaced with this text";
    private String prefilledMultiClonedExpected = "Single Sentence\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.\n\n"+ "New Paragraph\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateClonedExpected = "1 May 2025";
    private String switchClonedExpected = "Switch 2";
    private String singlePickListClonedExpected = "Tap to add information";
    private String multiPicklistClonedExpected = "Option 4,Option 3";
    private String bakedInTokensClonedExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private String predefinedResponsesClonedExpected = "This sentence should be bold.\n\n\n" + "This sentence has multiple formats so needs to be slightly longer.\n\n\n" + "This is to allow for more than a single category to appear in the search results" ;
    private String numericClonedExpected = "1,045";
    private String enterBoldClonedExpected = "<strong>Bold Text</strong>";
    private String enterItalicsClonedExpected = "Italicised Text";
    private String enterUnderlinedClonedExpected = "Underlined Text";
    private String enterMultiFormattedClonedExpected = "Multi <u>formatted text</u> <strong>to check</strong> that all of <em>the options will</em> work together if a <s>single sentenc</s> is entered. <strong><u>We have a couple here</u></strong><u> </u><em><u>a couple here as well </u><s><u>but here's 3</u></s></em>";
    private String ratingClonedExpected = "M";

    //Attachments
    private String preformattedAttachmentsClonedExpected = "3";
    private String singleTextAttachmentsClonedExpected = "1";
    private String multiTextAttachmentsClonedExpected = "2";

    //Notes
    private String preformattedNotesClonedExpected = "Pictures added to Notes";
    private String dateNotesClonedExpected = "25th December 2028";
    private String switchNotesClonedExpected = "Second Switch selected";
    private String multiPickListNotesClonedExpected = "Options 3 and 4 selected";
    private String predefinedResponsesNotesClonedExpected = "This sentence has multiple formats so needs to be slightly longer.\n\n" +
            "This sentence should be bold.\n\n" +
            "This is to allow for more than a single category to appear in the search results\" are the displayed notes in report view";
    private String ratingNotesClonedExpected = "M is selected rating";




    public confirmationFunctionsConfirmCloned() throws IOException, URISyntaxException {

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
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


    //Cloned report view
    public void confirmClonedCorrectReportView(String item) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming uploaded " + item + " in report view");

            WebElement fieldName;
            String expectedText;
            if (item.equals("Preformatted Text for Copy/Paste Tests")) {
                fieldName = preformattedReportView;
                expectedText = preformattedTextClonedExpected;
            } else if (item.equals("This is Single Text")) {
                fieldName = singleTextReportView;
                expectedText = singleTextClonedExpected;
            } else if (item.equals("This is Multi Text")) { // ensure exact key
                fieldName = multiTextReportView;
                expectedText = multiTextClonedExpected;
            } else if (item.equals("This is Prefilled Text (Single)")) {
                fieldName = prefilledTextSingleReportView;
                expectedText = prefilledSingleClonedExpected;
            } else if (item.equals("This is Prefilled Text (Multi)")) {
                fieldName = prefilledTextMultiReportView;
                expectedText = prefilledMultiClonedExpected;
            } else if (item.equals("This is a Date")) { // ensure exact key
                fieldName = dateReportView;
                expectedText = dateClonedExpected;
            } else if (item.equals("This is a Switch")) {
                fieldName = switchReportView;
                expectedText = switchClonedExpected;
            } else if (item.equals("Single Select Pick List")) {
                fieldName = singlePickListReportView;
                expectedText = singlePickListClonedExpected;
            } else if (item.equals("Multi Select Pick List")) { // ensure exact key
                fieldName = multiPickListReportView;
                expectedText = multiPicklistClonedExpected;
            } else if (item.equals("This Has Baked In Tokens")) {
                fieldName = bakedInReportView;
                expectedText = bakedInTokensClonedExpected;
            } else if (item.equals("This is Predefined Responses")) {
                fieldName = predefinedResponsesReportView;
                expectedText = predefinedResponsesClonedExpected;
            } else if (item.equals("This is a Numeric")) { // ensure exact key
                fieldName = numericReportView;
                expectedText = numericClonedExpected;
            } else if (item.equals("Enter Bold Text")) {
                fieldName = boldItemReportView;
                expectedText = enterBoldClonedExpected;
            } else if (item.equals("Enter Italics Text")) {
                fieldName = italicsItemReportView;
                expectedText = enterItalicsClonedExpected;
            } else if (item.equals("Enter Underlined Text")) { // ensure exact key
                fieldName = underlinedItemReportView;
                expectedText = enterUnderlinedClonedExpected;
            } else if (item.equals("Enter Multi Formatted Text")) { // ensure exact key
                fieldName = multiFormattedItemReportView;
                expectedText = enterMultiFormattedClonedExpected;
            } else if (item.equals("This is Rating")) { // ensure exact key
                fieldName = ratingReportView;
                expectedText = ratingClonedExpected;
            } else {
                throw new IllegalArgumentException("Unknown item: " + item);
            }

            System.out.println("Waiting for: " +item);

            waitForWebElementToBeVisible(fieldName);
            String actual = fieldName.getText();

            String normActual = norm(actual);
            String normExpected = norm(expectedText);

            System.out.println(item + " (norm actual): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(
                    normActual.contains(normExpected),
                    "Actual text does not contain expected text.\nActual: " + normActual + "\nExpected: " + normExpected
            );

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmClonedReportViewMultiTextRating(String rating) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming rating in Multi Text item");
            WebElement selectedRating = getDriver().findElement(By.xpath("//div[contains(text(), 'This is Multi Text')]/following::span[contains(@class, 'read-only-rating-title')]"));
            String selectedRatingText = selectedRating.getText();
            waitForWebElementToBeVisible(selectedRating);
            System.out.println("Multi Text Rating set to: " + selectedRatingText);
            Assert.assertTrue(selectedRatingText.contains(rating), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }
    }

    public void confirmClonedReportViewRating() throws IOException, URISyntaxException, InterruptedException {
        try{
            System.out.println("Confirming selected This is a Rating in report view");
            waitForWebElementToBeVisible(ratingReportView);
            String reportViewRating = ratingReportView.getText();
            System.out.println("Rating displayed in Report View: \n" + reportViewRating);
            Assert.assertTrue(reportViewRating.contains(ratingClonedExpected), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmClonedReportViewTextFormat(String format) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + format);

            String formatExpected;
            WebElement fieldName;

            if (format.equals("Enter Bold Text")) {
                formatExpected = enterBoldClonedExpected;
                fieldName = boldItemReportView;
            } else if (format.equals("Enter Italics Text")) {
                formatExpected = enterItalicsClonedExpected;
                fieldName = italicsItemReportView;
            } else if (format.equals("Enter Underlined Text")) {
                formatExpected = enterUnderlinedClonedExpected;
                fieldName = underlinedItemReportView;
            } else if (format.equals("Enter Multi Formatted Text")) {
                formatExpected = enterMultiFormattedClonedExpected;
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


    //Cloned items
    public void confirmClonedCorrectMultiText(String multiItem) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + multiItem);
            waitForWebElementToBeVisible(multiTextItem);

            String multiItemExpected;
            if (multiItem.equals("Preformatted Text for Copy/Paste Tests")) {
                multiItemExpected = preformattedTextClonedExpected;
            } else if (multiItem.equals("This is Multi Text")) {
                multiItemExpected = multiTextClonedExpected;
            } else if (multiItem.equals("This is Prefilled Text (Multi)")) {
                multiItemExpected = prefilledMultiClonedExpected;
            } else if (multiItem.equals("This Has Baked In Tokens")) { // ensure exact key
                multiItemExpected = bakedInTokensClonedExpected;
            }  else if (multiItem.equals("This is Predefined Responses")) { // ensure exact key
                multiItemExpected = predefinedResponsesClonedExpected;
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

    public void confirmClonedCorrectSingleText(String singleItem) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + singleItem);
            waitForWebElementToBeVisible(singleTextItem);

            String singleItemExpected;
            if (singleItem.equals("This is Single Text")) {
                singleItemExpected = singleTextClonedExpected;
            } else if (singleItem.equals("This is Prefilled Text (Single)")) {
                singleItemExpected = prefilledSingleClonedExpected;
            } else if (singleItem.equals("This is a Numeric")) {
                singleItemExpected = numericClonedExpected;
            } else {
                throw new IllegalArgumentException("Unknown  item: " + singleItem);
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

    public void confirmClonedTextFormat(String format) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + format);
            waitForWebElementToBeVisible(multiTextItem);

            String uploadedText = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerHTML;", multiTextItem);

            String formatExpected;
            if (format.equals("Enter Bold Text")) {
                formatExpected = enterBoldClonedExpected;
            } else if (format.equals("Enter Italics Text")) {
                formatExpected = enterItalicsClonedExpected;
            } else if (format.equals("Enter Underlined Text")) {
                formatExpected = enterUnderlinedClonedExpected;
            } else if (format.equals("Enter Multi Formatted Text")) {
                formatExpected = enterMultiFormattedClonedExpected;
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

    public void confirmReportPredefinedResponsesCloned() {
        try{
            String actual   = multiTextItem.getText();
            System.out.println("Predefined responses item value: \n" + actual);

            // 1) Debug print with delimiters and lengths
            //System.out.printf("EXPECTED → «%s» (len=%d)%n", predefinedResponsesExpected, predefinedResponsesExpected.length());
            // System.out.printf("ACTUAL   → «%s» (len=%d)%n", actual,   actual.length());

            // 2) Normalize line endings to Unix style (just in case)
            predefinedResponsesClonedExpected = predefinedResponsesClonedExpected.replaceAll("\\r\\n?", "\n");
            actual   = actual  .replaceAll("\\r\\n?", "\n");

            // 3) Trim leading/trailing whitespace and collapse any run of whitespace to a single space
            String normExpected = predefinedResponsesClonedExpected.trim().replaceAll("\\s+", " ");
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

    public void confirmClonedRating(String item, String option) throws IOException, URISyntaxException, InterruptedException {
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


    //Cloned report view
    /* public void confirmClonedReportViewPreformattedText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Preformatted Text in report view");
            waitForWebElementToBeVisible(preformattedTextReportView);
            String reportViewPreformattedeText = singleTextReportView.getText();
            System.out.println("\"" + reportViewPreformattedeText + "\" is displayed in report view");
            Assert.assertTrue(preformattedTextReportViewExpectedCloned.contains(reportViewPreformattedeText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
        }
    }

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

    public void confirmClonedReportViewPreformattedTextNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Cloned Preformatted Text with Notes in report view");
            waitForWebElementToBeVisible(preformattedNotesReportView);
            String reportViewpreformattedNotes = preformattedNotesReportView.getText();
            System.out.println("\"" + reportViewpreformattedNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(preformattedNotesReportViewExpected.contains(reportViewpreformattedNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted notes in report view");
        }
    }

    public void confirmClonedReportViewSingleText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Single Text in report view");
            waitForWebElementToBeVisible(singleTextReportView);
            String reportViewSingleText = singleTextReportView.getText();
            System.out.println("\"" + reportViewSingleText + "\" is displayed in report view");
            Assert.assertTrue(singleTextReportViewExpectedCloned.contains(reportViewSingleText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single text in report view");
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

    public void confirmClonedReportViewMultiText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Multi Text in report view");
            waitForWebElementToBeVisible(multiTextReportView);
            String reportViewMultiText = multiTextReportView.getText();
            System.out.println("\"" + reportViewMultiText + "\" is displayed in report view");
            Assert.assertTrue(multiTextReportViewExpectedCloned.contains(reportViewMultiText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi text in report view");
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

    public void confirmClonedReportViewPrefilledSingle() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Prefilled Text (Single) in report view");
            waitForWebElementToBeVisible(prefilledTextSingleReportView);
            String reportViewPrefilledSingle = prefilledTextSingleReportView.getText();
            Assert.assertTrue(prefilledSingleEditedExpected.contains(reportViewPrefilledSingle), "Actual text does not contain expected text.");
            System.out.println("\"" + reportViewPrefilledSingle + "\" is displayed in report view");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm single prefilled in report view");
        }

    }

    public void confirmClonedReportViewPrefilledMulti() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming Prefilled Text (Multi) in report view");
            waitForWebElementToBeVisible(prefilledTextMultiReportView);
            String reportViewPrefilledMulti = prefilledTextMultiReportView.getText();
            System.out.println("Multi Prefilled Text Value: " + reportViewPrefilledMulti);
            Assert.assertTrue(prefilledTextMultiReportViewExpectedCloned.contains(reportViewPrefilledMulti), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled in report view");
        }
    }

    public void confirmClonedReportViewDate(String clonedReportViewDateExpected) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(dateReportView);
            System.out.println("Confirming report view date");
            String actualDateReportViewText = dateReportView.getText();
            System.out.println("\"" + actualDateReportViewText + "\" is displayed in report view");
            Assert.assertTrue(clonedReportViewDateExpected.contains(actualDateReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm report date in report view");
        }
    }

    public void confirmClonedReportViewDateNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Confirming This is a Date Notes report view");
            waitForWebElementToBeVisible(dateNotesReportView);
            String reportViewDateNotes = dateNotesReportView.getText();
            System.out.println("\"" + reportViewDateNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(dateNotesReportViewExpected.contains(reportViewDateNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm this is a date notes in report view");
        }
    }

    public void confirmClonedReportViewSwitch() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(switchReportView);
            System.out.println("- Confirming selected Switch in report view");
            String actualSwitchReportViewText = switchReportView.getText();
            System.out.println("- \"" + actualSwitchReportViewText + "\" is displayed in report view");
            Assert.assertTrue(switchReportViewExpectedCloned.contains(actualSwitchReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("unable to confirm switch selection in report view");
        }

    }

    public void confirmClonedReportViewSwitchNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming 'This is a Switch' Notes in report view");
            waitForWebElementToBeVisible(switchNotesReportView);
            String reportViewSwitchNotes = switchNotesReportView.getText();
            System.out.println("- \"" + reportViewSwitchNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(switchNotesReportViewExpected.contains(reportViewSwitchNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm this is a date notes in report view");
        }
    }

    public void confirmClonedReportViewMultiSelectPicklist() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(multiPickListReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualMultiPickListReportViewText = multiPickListReportView.getText();
            System.out.println("\"" + actualMultiPickListReportViewText + "\" is displayed in multi pick list report view");
            Assert.assertTrue(picklistExpectedCloned.contains(actualMultiPickListReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmClonedReportViewMultiSelectPicklistNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming 'Multi Select Pick List' Notes in report view");
            waitForWebElementToBeVisible(multiPickListNotesReportView);
            String reportViewMultiPickListNotes = multiPickListNotesReportView.getText();
            System.out.println("- \"" + reportViewMultiPickListNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(multiPickListNotesReportViewExpected.contains(reportViewMultiPickListNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi select pick list notes in report view");
        }
    }

    public void confirmClonedReportViewSingleSelectPicklist() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(singlePickListReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualSinglePickListReportViewText = singlePickListReportView.getText();
            System.out.println("\"" + actualSinglePickListReportViewText + "\" is displayed in single pick list report view");
            Assert.assertTrue(singlePicklistExpectedCloned.contains(actualSinglePickListReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmClonedReportReportViewBakedInTokens() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(bakedInReportView);
            System.out.println("Confirming Baked In Tokens in report view");
            String actualBakedInReportViewText = bakedInReportView.getText();
            System.out.println("\"" + actualBakedInReportViewText + "\" is displayed in Baked In Tokens report view");
            Assert.assertTrue(bakedInTokensExpectedCloned.contains(actualBakedInReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm Baked In Tokens in report view");
        }

    }

    public void confirmClonedReportViewPredefinedResponses() throws IOException, URISyntaxException {

        try {
            waitForWebElementToBeVisible(predefinedResponsesReportView);
            System.out.println("Confirming Predefined Responses in report view");
            String actualPredefinedResponsesReportViewText = predefinedResponsesReportView.getText();
            System.out.println("\"" + actualPredefinedResponsesReportViewText + "\" is displayed in Predefined Responses report view");
            System.out.println("\"" + predefinedResponsesExpectedCloned + "\" is the expected Predefined Responses report view value");
            Assert.assertTrue(predefinedResponsesExpectedCloned.contains(actualPredefinedResponsesReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to Predefined Responses in report view");
        }
    }

    public void confirmClonedReportViewPredefinedResponsesNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming 'This is Predefined Responses' Notes in report view");
            waitForWebElementToBeVisible(predefinedResponsesNotesReportView);
            String reportViewPredefinedResponsesNotes = predefinedResponsesNotesReportView.getText();
            System.out.println("- \"" + reportViewPredefinedResponsesNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(predefinedResponsesNotesReportViewExpected.contains(reportViewPredefinedResponsesNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm this is predefined resposnes notes in report view");
        }
    }

    public void confirmClonedReportViewNumeric() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(numericReportView);
            System.out.println("Confirming numeric in report view");
            String actualNumericReportViewText = numericReportView.getText();
            System.out.println("\"" + actualNumericReportViewText + "\" is displayed in numeric in report view");
            Assert.assertTrue(numericReportViewExpectedCloned.contains(actualNumericReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm numeric in report view");
        }

    }

    public void confirmClonedReportViewEnterBold() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(boldItemReportView);
            System.out.println("Confirming 'Enter Bold Text' in report view");
            String actualBoldItemReportViewText = boldItemReportView.getText();
            System.out.println("\"" + actualBoldItemReportViewText + "\" is displayed for 'Enter Bold Text' in report view");
            System.out.println("\"" + enterBoldExpectedCloned + "\" is displayed in report view");
            Assert.assertTrue(enterBoldExpectedCloned.contains(actualBoldItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm 'Enter Bold Text' in report view");
        }

    }

    public void confirmClonedReportViewEnterItalics() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(italicsItemReportView);
            System.out.println("Confirming 'Enter Italics Text' in report view");
            String actualEnterItalicsReportViewText = italicsItemReportView.getText();
            System.out.println("\"" + actualEnterItalicsReportViewText + "\" is displayed in 'Enter Italics Text' in report view");
            Assert.assertTrue(enterItalicsExpectedCloned.contains(actualEnterItalicsReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm 'Enter Italics Text' in report view");
        }

    }

    public void confirmClonedReportViewEnterUnderlined() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(underlinedItemReportView);
            System.out.println("Confirming 'Enter Underlined Text' in report view");
            String actualEnterUnderlinedReportViewText = underlinedItemReportView.getText();
            System.out.println("\"" + actualEnterUnderlinedReportViewText + "\" is displayed in 'Enter Underlined Text' in report view");
            Assert.assertTrue(enterUnderlinedExpectedCloned.contains(actualEnterUnderlinedReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm 'Enter Underlined Text' in report view");
        }

    }

    public void confirmClonedReportViewMultiFormatted() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(multiFormattedItemReportView);
            System.out.println("Confirming 'Enter Multiformatted Text' in report view");
            String actualEnterMultiformattedReportViewText = multiFormattedItemReportView.getText();
            System.out.println("\"" + actualEnterMultiformattedReportViewText + "\" is displayed in 'Enter Multi Formatted Text' in report view");
            Assert.assertTrue(enterMultiFormattedExpectedCloned.contains(actualEnterMultiformattedReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm 'Enter Multi Formatted Text' in report view");
        }

    }

    public void confirmClonedReportViewRating() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(ratingReportView);
            System.out.println("Confirming This is a Rating in report view");
            String actualRatingReportView = ratingReportView.getText();
            System.out.println("\"" + actualRatingReportView + "\" is displayed in This is a Rating in report view");
            Assert.assertTrue(ratingExpectedCloned.contains(actualRatingReportView));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm This is a Rating in report view");
        }

    }

    public void confirmClonedReportViewRatingNotes() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming 'This is a Rating' Notes in report view");
            waitForWebElementToBeVisible(ratingNotesReportView);
            String reportViewratingNotes = ratingNotesReportView.getText();
            System.out.println("- \"" + reportViewratingNotes + "\" are the displayed notes in report view");
            Assert.assertTrue(ratingNotesReportViewExpected.contains(reportViewratingNotes), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm this is a rating notes in report view");
        }
    }

    public void confirmClonedReportViewMultiTextRating() throws IOException, URISyntaxException, InterruptedException {
        try{
            System.out.println("Confirming selected multi text rating in report view");
            WebElement reportViewRating = getDriver().findElement(By.xpath("//lib-read-only-rating[contains(@class, 'ng-star-inserted')]"));
            String actualReportViewRatingText = reportViewRating.getText();
            System.out.println("\"" + actualReportViewRatingText + "\" is the rating displayed in report view");
            Assert.assertTrue(multiTextRatingExpectedCloned.contains(actualReportViewRatingText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

*/

    /*
    //Cloned items
    public void confirmClonedPreformattedTextForCopyPaste() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'Preformatted Text For Copy/Paste Tests' ");
            waitForWebElementToBeVisible(multiTextItem);
            String actualPreformattedText = multiTextItem.getText();
            System.out.println("- \"" + actualPreformattedText + "\": is the displayed text");
            //System.out.println("- \"" + preformattedTextExpected + "\": is the expected text");
            Assert.assertTrue(preformattedTextExpected.contains(actualPreformattedText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm x in report view");
        }
    }

    public void confirmClonedSingleText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is Single Text' ");
            waitForWebElementToBeVisible(singleText);
            String actualSingleText = singleText.getText();
            System.out.println("- \"" + actualSingleText + "\" is the displayed text");
            //System.out.println("- \"" + singleTextExpected + "\": is the expected text");
            Assert.assertTrue(singleTextReportViewExpectedCloned.contains(actualSingleText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm x in report view");
        }
    }

    public void confirmClonedMultiTextRTF() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is Multi Text' ");
            waitForWebElementToBeVisible(multiTextItem);
            String actualMultiText = multiTextItem.getText();
            System.out.println("- \"" + actualMultiText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(multiTextReportViewExpectedCloned.contains(actualMultiText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm This is Multi Text");
        }
    }

    public void confirmClonedSinglePrefilledText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is Prefilled Text (Single)' ");
            waitForWebElementToBeVisible(singlePrefilledText);
            String actualSingleTextPrefilled = singlePrefilledText.getText();
            System.out.println("- \"" + actualSingleTextPrefilled + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(prefilledSingleEditedExpected.contains(actualSingleTextPrefilled), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm 'This is Prefilled Text (Single) ");
        }
    }

    public void confirmClonedMultiPrefilledText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is Prefilled Text (Multi)' ");
            waitForWebElementToBeVisible(multiTextItem);
            String actualPrefilledMultiText = multiTextItem.getText();
            System.out.println("- \"" + actualPrefilledMultiText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(prefilledTextMultiReportViewExpectedCloned.contains(actualPrefilledMultiText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm prefilled text multi");
        }
    }

    public void confirmClonedPredefinedResponses() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is Predefined Responses' ");
            //waitForWebElementToBeVisible();
            String actualPredefinedResponses = multiTextItem.getText();
            System.out.println("- \"" + actualPredefinedResponses + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(predefinedResponsesExpectedCloned.contains(actualPredefinedResponses), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm Predefined Responses");
        }
    }

    public void confirmClonedNumeric() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'This is a Numeric' ");
            //waitForWebElementToBeVisible();
            String actualNumeric = numericItem.getText();
            System.out.println("- \"" + actualNumeric + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(numericReportViewExpectedCloned.contains(actualNumeric), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm This is a Numeric");
        }
    }

    public void confirmClonedEnterBoldText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'Enter Bold Text' ");
            String actualEnterBoldText = multiTextItem.getText();
            System.out.println("- \"" + actualEnterBoldText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(enterBoldExpectedCloned.contains(actualEnterBoldText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm Enter Bold Text");
        }
    }

    public void confirmClonedEnterItalicsText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'Enter Bold Text' ");
            String actualEnterItalicsText = multiTextItem.getText();
            System.out.println("- \"" + actualEnterItalicsText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(enterItalicsExpectedCloned.contains(actualEnterItalicsText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm Enter Italics Text");
        }
    }

    public void confirmClonedEnterUnderlinedText() throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming entry for 'Enter Bold Text' ");
            String actualEnterUnderlinedText = multiTextItem.getText();
            System.out.println("- \"" + actualEnterUnderlinedText + "\" is the displayed text");
            //System.out.println("- \"" + Expected + "\": is the expected text");
            Assert.assertTrue(enterUnderlinedExpectedCloned.contains(actualEnterUnderlinedText), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm enter underlined text");
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
    }*/

}


