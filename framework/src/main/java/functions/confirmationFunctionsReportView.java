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

public class confirmationFunctionsReportView extends Base_PO {

    CreateReport_PO createReport_po;

    public @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and @spellcheck='false']") WebElement extractedTextField;
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
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., ' Preformatted Text for Copy/Paste Tests ')]") WebElement preformattedTextReportView;
    public @FindBy(xpath = "//div[contains(@class,'editor-item__title') and contains(., 'This Is Single Text')]") WebElement singleTextReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement multiTextReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Multi Text')]/following::span[contains(@class, 'read-only-rating-title')]") WebElement multiTextRatingReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Single)')]/following::span[contains(@class, 'single-text')]") WebElement prefilledTextSingleReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Prefilled Text (Multi)')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement prefilledTextMultiReportView;
    public @FindBy(xpath = "//lib-date//span[contains(@class, 'date')]") WebElement dateReportView;
    public @FindBy(xpath = "//lib-switch[contains(@class, 'ng-star-inserted')]") WebElement switchReportView;
    public @FindBy(xpath = "//lib-editor-item[.//div[contains(@class,'editor-item__title') and normalize-space(.)='Single Select Pick List']]//lib-placeholder//span") WebElement singlePickListReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Multi Select Pick List')]/following::lib-pick-list[contains(@class, 'ng-star-inserted')]") WebElement multiPickListReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This Has Baked In Tokens')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')]") WebElement bakedInReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is Predefined Responses')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]//div[contains(@class,'multi-text-item')][1]") WebElement predefinedResponsesReportView;
    public @FindBy(css = "div span.numeric") WebElement numericReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Bold Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement boldItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Italics Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement italicsItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Underlined Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement underlinedItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'Enter Multi Formatted Text')]/following::lib-multi-input[contains(@class, 'ng-star-inserted')][1]") WebElement multiFormattedItemReportView;
    public @FindBy(xpath = "//div[contains(text(), 'This is a Rating')]/following::lib-read-only-rating[contains(@class, 'ng-star-inserted')]") WebElement ratingReportView;

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
    private static String singleTextExpected = "Single line of text entered into the single item text item";
    private static String multiTextExpected = "This is bold text\n" +
            "This is italicized text\n" +
            "This is underlined text\n" +
            "This is strikethrough text";
    private static String multiTextRatingExpected = "1";
    private String prefilledSingleExpected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.";
    private static String prefilledSingleEditedExpected = "This item was previously prefilled but has now been replaced with this text";
    private static String prefilledMultiExpected = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateExpected = "10 October 2025";
    private String switchReportViewExpected = "Switch 2";
    private String multiPicklistExpected = "Option 2,Option 3";
    private static String bakedInTokensExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private static String predefinedResponsesExpected = "Multiple more entries are required to test\n" +
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
    private String preformattedTextReportViewExpectedCloned = "This is normal text\n" +
            "This is bold text\n" +
            "This is italicised text\n" +
            "This is underlined text\n" +
            "This is multiple formats text which needs to be slightly longer\n";
    private String singleTextReportViewExpectedCloned = "Photo in Notes so what happens if photo without notes?";
    private String multiTextReportViewExpectedCloned = "Enter\n" +
            "Multi\n" +
            "Two photos attached\n";
    private String prefilledTextMultiReportViewExpectedCloned = "Single Sentence\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tempor maximus faucibus. Vivamus blandit lorem.\n\n"+ "New Paragraph\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";

    private String switchReportViewExpectedCloned = "Switch 2";
    private String picklistExpectedCloned = "Option 4,Option 3";
    private String singlePicklistExpectedCloned = "Tap to add information";
    private String bakedInTokensExpectedCloned = "These are the baked in values:\n\n" + "Date : .Date.\n" + "Author Name : .AuthorName.\n" + "Author Initials : .AuthorInitials.\" is displayed in Baked In Tokens report view";
    private String predefinedResponsesExpectedCloned = "This sentence should be bold.\n\n\n" + "This sentence has multiple formats so needs to be slightly longer.\n\n\n" + "This is to allow for more than a single category to appear in the search results" ;
    private String numericReportViewExpectedCloned = "1,045";
    private String enterBoldExpectedCloned = "Bold Text";
    private String enterItalicsExpectedCloned = "Italicised Text";
    private String enterUnderlinedExpectedCloned = "Underlined Text";
    private String enterMultiFormattedExpectedCloned = "Multi formatted text to check that all of the options will work together if a single sentenc is entered. We have a couple here a couple here as well but here's 3";
    private String ratingExpectedCloned = "M";
    private String multiTextRatingExpectedCloned = "1";
    private String preformattedAttachmentsReportViewExpectedCloned = "3";
    private String singleTextAttachmentsReportViewExpectedCloned = "1";
    private String multiTextAttachmentsReportViewExpectedCloned = "2";
    private String preformattedNotesReportViewExpected = "Pictures added to Notes";
    private String dateNotesReportViewExpected = "25th December 2028";
    private String sw0itchNotesReportViewExpected = "Second Switch selected";
    private String multiPickListNotesReportViewExpected = "Options 3 and 4 selected";
    private String predefinedResponsesNotesReportViewExpected = "This sentence has multiple formats so needs to be slightly longer.\n\n" +
            "This sentence should be bold.\n\n" +
            "This is to allow for more than a single category to appear in the search results\" are the displayed notes in report view";
    private String ratingNotesReportViewExpected = "M is selected rating";




    public confirmationFunctionsReportView() throws IOException, URISyntaxException {

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
    }


    // Report View confirmations

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

    public void confirmReportViewSwitch(String selectedSwitch) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(switchReportView);
            System.out.println("- Confirming selected Switch in report view");
            String actualSwitchReportViewText = switchReportView.getText();
            System.out.println("- \"" + actualSwitchReportViewText + "\" is displayed in report view");
            Assert.assertTrue(selectedSwitch.contains(actualSwitchReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("unable to confirm switch selection in report view");
        }

    }

    public void confirmReportViewMultiPicklist() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(multiPickListReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualmultiPickListReportViewText = multiPickListReportView.getText();
            System.out.println("\"" + actualmultiPickListReportViewText + "\" is displayed in report view");
            Assert.assertTrue(multiPicklistExpected.contains(actualmultiPickListReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmReportViewSinglePicklist(String option) throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(multiPickListReportView);
            System.out.println("Confirming selected picklist options in report view");
            String actualmultiPickListReportViewText = multiPickListReportView.getText();
            System.out.println("\"" + actualmultiPickListReportViewText + "\" is displayed in report view");
            String supposedReportViewPicklist = (option);
            Assert.assertTrue(
                    actualmultiPickListReportViewText.contains(supposedReportViewPicklist),
                    "Expected the actual text to contain: " + supposedReportViewPicklist + ", but got: \"" + actualmultiPickListReportViewText + "\""
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
            System.out.println("\"" + actualBakedInReportViewText + "\" is displayed in report view");
            Assert.assertTrue(bakedInTokensExpected.contains(actualBakedInReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm picklist selections in report view");
        }

    }

    public void confirmReportViewSwitch() throws IOException, URISyntaxException {
        try {
            waitForWebElementToBeVisible(switchReportView);
            System.out.println("- Confirming selected Switch in report view");
            String actualSwitchReportViewText = switchReportView.getText();
            System.out.println("- \"" + actualSwitchReportViewText + "\" is displayed in report view");
            Assert.assertTrue(switchReportViewExpected.contains(actualSwitchReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("unable to confirm switch selection in report view");
        }

    }

    public void confirmReportViewNumeric(String expectedNumber) throws IOException, URISyntaxException {
        try {
            System.out.println("Checking Numeric report view value");
            waitForWebElementToBeVisible(numericReportView);
            String actualNumericReportViewText = numericReportView.getText();
            System.out.println("\"" + actualNumericReportViewText + "\" is displayed in report view");
            Assert.assertTrue(expectedNumber.contains(actualNumericReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm numeric entry");
        }
    }

    public void confirmReportViewBoldItem() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking 'Enter Bold Text' report view value");
            waitForWebElementToBeVisible(boldItemReportView);
            String actualBoldItemReportViewText = boldItemReportView.getText();
            System.out.println("\"" + actualBoldItemReportViewText + "\" is displayed in report view");
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
            System.out.println("\"" + actualItalicsItemReportViewText + "\" is displayed in report view");
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
            System.out.println("\"" + actualUnderlinedItemReportViewText + "\" is displayed in report view");
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
            System.out.println("\"" + actualMultiFormattedTextItemReportViewText + "\" is displayed in report view");
            Assert.assertTrue(enterMultiformatExpected.contains(actualMultiFormattedTextItemReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi formatted text");
        }

    }

    public void confirmReportViewRating(String option) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Checking Rating report view value");
        try{
            waitForWebElementToBeVisible(ratingReportView);
            String actualRatingReportViewText = ratingReportView.getText();
            System.out.println("\"" + actualRatingReportViewText + "\" is displayed in report view");
            Assert.assertTrue(option.contains(actualRatingReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }

    public void confirmReportViewMultiRating(String option) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Checking Rating report view value");
        try{
            waitForWebElementToBeVisible(multiTextRatingReportView);
            String actualRatingReportViewText = multiTextRatingReportView.getText();
            System.out.println("\"" + actualRatingReportViewText + "\" is displayed in report view");
            Assert.assertTrue(option.contains(actualRatingReportViewText));
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm rating in report view");
        }

    }
}


