package functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.Base_PO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;


public class confirmationFunctionsReportView extends Base_PO {

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
    public  @FindBy(xpath = "//lib-editor-item//div[contains(., ' Single Select Pick List')]//div[contains(@class, 'pick-list')]") WebElement singlePickListReportView;
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


    //Report View notes & attachments
    private String preformattedAttachmentsReportViewExpectedCloned = "3";
    private String singleTextAttachmentsReportViewExpectedCloned = "1";
    private String multiTextAttachmentsReportViewExpectedCloned = "2";
    private String preformattedNotesReportViewExpected = "Pictures added to Notes";
    private String dateNotesReportViewExpected = "25th December 2028";
    private String switchNotesReportViewExpected = "Second Switch selected";
    private String multiPickListNotesReportViewExpected = "Options 3 and 4 selected";
    private String predefinedResponsesNotesReportViewExpected = "This sentence has multiple formats so needs to be slightly longer.\n\n" +
            "This sentence should be bold.\n\n" +
            "This is to allow for more than a single category to appear in the search results\" are the displayed notes in report view";
    private String ratingNotesReportViewExpected = "M is selected rating";




    public confirmationFunctionsReportView() throws IOException, URISyntaxException {
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


    //Confirm report view
    public void confirmCorrectReportView(String item, String entry) throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming uploaded " + item + " in report view");
            System.out.println("- Looking for value " + entry + " in field " + item);

            WebElement fieldName;
            if (item.equals("Preformatted Text for Copy/Paste Tests")) {
                fieldName = preformattedReportView;
            } else if (item.equals("This is Single Text")) {
                fieldName = singleTextReportView;
            } else if (item.equals("This is Multi Text")) { // ensure exact key
                fieldName = multiTextReportView;
            } else if (item.equals("This is Prefilled Text Single")) {
                fieldName = prefilledTextSingleReportView;
            } else if (item.equals("This is Prefilled Text Multi")) {
                fieldName = prefilledTextMultiReportView;
            } else if (item.equals("This is a Date")) { // ensure exact key
                fieldName = dateReportView;
            } else if (item.equals("This is a Switch")) {
                fieldName = switchReportView;
            } else if (item.equals("Single Select Pick List")) {
                fieldName = singlePickListReportView;
            } else if (item.equals("Multi Select Pick List")) { // ensure exact key
                fieldName = multiPickListReportView;
            } else if (item.equals("This Has Baked In Tokens")) {
                fieldName = bakedInReportView;
            } else if (item.equals("This is Predefined Responses")) {
                fieldName = predefinedResponsesReportView;
            } else if (item.equals("This is a Numeric")) { // ensure exact key
                fieldName = numericReportView;
            } else if (item.equals("Enter Bold Text")) {
                fieldName = boldItemReportView;
            } else if (item.equals("Enter Italics Text")) {
                fieldName = italicsItemReportView;
            } else if (item.equals("Enter Underlined Text")) { // ensure exact key
                fieldName = underlinedItemReportView;
            } else if (item.equals("Enter Multi Formatted Text")) { // ensure exact key
                fieldName = multiFormattedItemReportView;
            } else if (item.equals("This is Rating")) { // ensure exact key
                fieldName = ratingReportView;
            } else {
                throw new IllegalArgumentException("Unknown item: " + item);
            }

            System.out.println("- Waiting for: " +item);
            waitForWebElementToBeVisible(fieldName);
            String reportViewText = fieldName.getText();
            System.out.println("- " + item + " displayed in Report View: " + reportViewText);
            Assert.assertTrue(reportViewText.contains(entry), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmReportViewMultiTextRating(String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("- Confirming Multi Text Rating in report view");
            waitForWebElementToBeVisible(multiTextRatingReportView);
            String reportViewMultiTextRating = multiTextRatingReportView.getText();
            System.out.println("Rating displayed in Report View: \n" + reportViewMultiTextRating);
            Assert.assertTrue(reportViewMultiTextRating.contains(rating), "Actual text does not contain expected text.");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }
    }

    public void confirmReportViewDate(String specifiedViewDate, String item) throws IOException, URISyntaxException {
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

    public void confirmReportViewRating(String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        try {
            Thread.sleep(2000);
            System.out.println("- Confirming uploaded " + item + " in report view");
            System.out.println("- Looking for value " + rating + " in field " + item);

            WebElement fieldName;
            if (item.equals("This is Multi Text")) {
                fieldName = multiTextRatingReportView;
            } else if (item.equals("This is a Rating")) {
                fieldName = ratingReportView;
            } else {
                throw new IllegalArgumentException("Unknown item: " + item);
            }

            System.out.println("- Waiting for: " + item);
            waitForWebElementToBeVisible(fieldName);
            String reportViewText = fieldName.getText();
            System.out.println("- " + item + " displayed in Report View: " + reportViewText);
            Assert.assertTrue(reportViewText.contains(rating), "Actual text does not contain expected text.");


        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm preformatted text in report view");
        }

    }

    public void confirmReportViewTextFormat(String format, String entry) throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming text in: " + format);

            WebElement fieldName;

            if (format.equals("Enter Bold Text")) {
                fieldName = boldItemReportView;
            } else if (format.equals("Enter Italics Text")) {
                fieldName = italicsItemReportView;
            } else if (format.equals("Enter Underlined Text")) {
                fieldName = underlinedItemReportView;
            } else if (format.equals("Enter Multi Formatted Text")) {
                fieldName = multiFormattedItemReportView;
            } else {
                throw new IllegalArgumentException("Unknown format item: " + format);
            }

            waitForWebElementToBeVisible(fieldName);
            String reportViewText = fieldName.getDomProperty("innerHTML");

            String normActual   = norm(reportViewText);
            String normExpected = norm(entry);

            System.out.println(format + " value (norm): " + normActual);
            System.out.println("Expected (norm): " + normExpected);

            Assert.assertTrue(normActual.contains(normExpected),"Actual text does not contain expected text.\n--- ACTUAL ---\n" + normActual + "\n--- EXPECTED ---\n" + normExpected
            );
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm multi prefilled text");
        }
    }

    public void confirmPreformattedNotesTextInReportView() throws IOException, URISyntaxException {
        try {

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


    //Confirm report view notes
    //TBC


    //confirm report view attachments
    //TBC

/*
    // Report View confirmations

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
*/
}


