package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;


public class confirmationFunctions_Steps extends Base_PO {

        TestAllControlsRM_PO testAllControlsRM_po;
        Homepage_PO homepage_po;
        SharedStepsFieldNav_PO sharedStepsFieldNav_po;
        globalFunctions globalFunctions;
        confirmationFunctions confirmationFunctions;
        CreateReport_PO createReport_po;


        private String expectedNumber;
        public String prefilledText = "New Paragraph\n" +
                "THIS IS NEW TEXT ADDED FOR TESTING " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. " +
                "Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus " +
                "urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac " +
                "molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna " +
                "sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. " +
                "Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";

        private String numericExpected = "123,456,789,000,000,000";
        private String enterBoldExpected = "Entering some bold text to confirm form uploads correctly";
        private String enterItalicsExpected = "Entering some italics text to confirm form uploads correctly";
        private String enterUnderlinedExpected = "Entering some underlined text to confirm form uploads correctly";
        private String enterMultiformatExpected = "Bold text with some added italics, added underline but removed bold, completed with strikethrough changed with simple bold and finally removed all formatting";

        private final String bullet1Text = "Bullet list entry 1";
        private final String bullet2Text = "Bullet list entry 2";
        private final String bullet3Text = "Bullet list entry 3";
        private final String numlist1Text = "Number list entry 1";
        private final String numlist2Text = "Number list entry 2";
        private final String numlist3Text = "Number list entry 3";

        private @FindBy(xpath = "//button[@value='ordered']") WebElement orderedList;


        public confirmationFunctions_Steps() throws IOException, URISyntaxException {
            //System.out.println("testAllControlsRM_Steps constructor called");

            testAllControlsRM_po = new TestAllControlsRM_PO();
            testAllControlsRM_po.initElements();

            homepage_po = new Homepage_PO();
            homepage_po.initElements();

            globalFunctions = new globalFunctions();
            globalFunctions.initElements();

            sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
            sharedStepsFieldNav_po.initElements();

            confirmationFunctions = new confirmationFunctions();
            confirmationFunctions.initElements();

            createReport_po = new CreateReport_PO();
            createReport_po.initElements();
        }


// --------------------------- Report View ----------------------------------------

    @And("I confirm This is a Date holds the correct value in report view")
    public void i_confirm_this_is_a_date_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNotesFormatting();
    }


    //----------------------------- Steps ------------------------------------------
    @And("I confirm the reports list report name is {string}")
    public void i_confirm_the_report_name_is(String reportName) throws IOException, URISyntaxException {
        createReport_po.confirmReportName(reportName);
    }

    @And("I confirm the report name has not changed {string}")
    public void i_confirm_the_report_name_has_not_changed(String name) throws IOException, URISyntaxException {
        createReport_po.confirmReportName(name);
    }

    @And("I confirm the reference has not changed")
    public void i_confirm_the_reference_has_not_changed() throws IOException, URISyntaxException {
        confirmationFunctions.confirmEmpty();
    }

    @And("I confirm the reports list reference is {string}")
    public void i_confirm_the_reports_reference_is(String reference) throws IOException, URISyntaxException {
        createReport_po.confirmReference(reference);
    }

    @And("I confirm the reference is {string}")
    public void i_confirm_the_reference_is(String reference) throws IOException, URISyntaxException {
        createReport_po.confirmReference(reference);
    }

    @And("I confirm the inspection date is marked as invalid")
    public void i_confirm_the_inspection_date_is_marked_as_invalid() throws IOException, URISyntaxException {
        createReport_po.confirmInvalidInspectionDate();
    }

    @And("I confirm the due date is marked as invalid")
    public void i_confirm_the_due_date_is_marked_as_invalid() throws IOException, URISyntaxException {
        createReport_po.confirmInvalidDueDate();
    }

    @And("I confirm the report details inspection date are correct {string}")
    public void i_confirm_the_report_details_inspection_date_are_correct(String date) throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportDetailsInspectionDate(date);
    }

    @And("I confirm the report details due date are correct {string}")
    public void i_confirm_the_report_details_due_date_are_correct(String date) throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportDetailsDueDate(date);
    }

    @And("I confirm the report details notes are correct {string}")
    public void i_confirm_the_report_details_notes_are_correct(String notes) throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportDetailsNotes(notes);
    }


    @And("I confirm I am unable to add another decimal point {string}")
    public void i_confirm_i_am_unable_to_add_another_decimal_point(String value1) {
        expectedNumber = (value1);
        System.out.println(expectedNumber);
        confirmationFunctions.confirmNumeric(expectedNumber);

    }

    @And("I confirm it's bold italics")
    public void confirm_it_s_bold_italics() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBoldItalics();
    }

    @And("I confirm it's underlined")
    public void confirm_it_s_underlined() throws IOException, URISyntaxException {
        confirmationFunctions.confirmUnderlined();
    }

    @And("I confirm it's underlined strikethrough")
    public void i_confirm_it_s_underlined_strikethrough() throws IOException, URISyntaxException {
        confirmationFunctions.confirmUnderlinedStrikethrough();
    }

    @And("I confirm the specific previously entered multiformatted text has saved")
    public void i_confirm_the_previously_entered_multiformatted_text_has_saved() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSpecificMultiFormat();
    }

    @And("I confirm the extra text has been saved {string}")
    public void i_confirm_the_extra_text_has_been_saved(String additionalText) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmExtraTextSaved(additionalText);

    }

    @And("I confirm all the multi text has been retained")
    public void i_confirm_all_the_multi_text_has_been_retained() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmFormatting();
    }

    @And("I confirm the single text prefilled field holds the correct value")
    public void i_confirm_the_field_has_the_correct_text() throws IOException, URISyntaxException {
        confirmationFunctions.confirmSinglePrefilledText();
    }

    @And("I confirm the multi text prefilled field has the correct text")
    public void i_confirm_the_multi_field_has_the_correct_text() throws IOException, URISyntaxException {
        confirmationFunctions.confirmCorrectMultiPrefilledText();
    }

    @And("I confirm the location coordinates have saved")
    public void i_confirm_the_location_coordinates_have_saved() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNotEmpty();
    }

    @And("I validate the location coordinates have been added")
    public void i_validate_the_location_coordinates_have_been_added() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectDone();
        testAllControlsRM_po.selectPredefinedResponses();
        confirmationFunctions.confirmLocationCoordinates();
    }

    @And("I confirm all previously entered data is saved {string}")
    public void i_confirm_all_previously_entered_text_is_saved(String additionalText) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmLocationCoordinates();
        confirmationFunctions.confirmExtraTextSaved(additionalText);

    }

    @And("I confirm the data for predefined responses is correct in report view")
    public void i_confirm_the_data_for_predefine_responses_is_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPredefinedResponses();

    }

    @And("I confirm it is bold")
    public void confirm_it_is_bold() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBold();
    }

    @And("I confirm the previously entered Text {string}")
    public void i_confirm_the_previously_entered_text(String text) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmMultiText(text);
    }

    @And("I confirm the text is deleted {string}")
    public void i_confirm_the_text_is_deleted(String textToDelete) throws MalformedURLException, URISyntaxException {
        confirmationFunctions.confirmTextDeletion(textToDelete);
    }

    @And("I confirm the notes formatting has been retained")
    public void confirm_the_notes_formatting_has_been_retained() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNotesFormatting();
        confirmationFunctions.confirmMultiFormat();
    }

    @Then("I confirm all the correct notes text is listed in the report view")
    public void i_confirm_all_the_correct_text_is_listed_in_the_report_view() throws IOException, URISyntaxException {
        confirmationFunctions.confirmFormattedNotesTextInReportView();
    }

    @And("I confirm it's in a numbered list")
    public void i_confirm_it_s_in_a_numbered_list() throws IOException, URISyntaxException, InterruptedException {
        //Thread.sleep(2000);
        waitForAngularWebElement(orderedList);
        confirmationFunctions.confirmNumberlist();
    }

    @And("I confirm it's in a bullet list")
    public void i_confirm_it_s_in_a_bullet_list() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBulletlist();
    }

    @And("I confirm the multi text bullet list")
    public void i_confirm_the_multi_text_bullet_list() throws IOException, URISyntaxException {
        confirmationFunctions.confirmMultiTextBulletlist();
    }


    /*@And("I confirm the single text {string} is present in single text prefilled")
    public void i_Confirm_The_Single_Text_Is_Present(String text) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPrefilledSingleUpload(text);

    }*/

    @And("I confirm switch {string} is not selected")
    public void i_Confirm_Switch_Is_Not_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchNotSelected(switchConfirm);
    }

    @And("I confirm option {string} is selected")
    public void i_Confirm_Option_Is_Selected(String option) throws IOException, URISyntaxException {
        confirmationFunctions.confirmSinglePicklist(option);
    }

    @And("I confirm This Has Baked In Tokens holds the correct value")
    public void i_Confirm_this_has_baked_in_tokens_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBakedInTokens();
    }

    @And("I confirm the text is correct and formatted correctly")
    public void i_Confirm_The_Text_Is_Correct_And_Formatted_Correctly() throws IOException, URISyntaxException {
        confirmationFunctions.confirmSpecificMultiFormat();
    }

    @And("I confirm for {string} there is now a {string} at the end of the row in report view")
    public void i_confirm_there_is_now_at_the_end_of_the_row_in_report_view(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            waitForWebElementToBeVisible(testAllControlsRM_po.thisIsRating);
            confirmationFunctions.confirmReportViewRating(option);
        }

        if (item.equals("This is Multi Text")) {
            waitForWebElementToBeVisible(testAllControlsRM_po.thisIsMultiText);
            confirmationFunctions.confirmReportViewMultiRating(option);
        }
    }

    @And("I confirm for {string}, {string} is selected")
    public void i_confirm_rating_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmRating(item, option);
    }

    @Then("I confirm the list of reports is displayed")
    public void the_list_of_reports_is_displayed() throws IOException, URISyntaxException {
        System.out.println("Waiting for reports");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));
        System.out.println("Checking first report");
        homepage_po.checkFirstReport();
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/