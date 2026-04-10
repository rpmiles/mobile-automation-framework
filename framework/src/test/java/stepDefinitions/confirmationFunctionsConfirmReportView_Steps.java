package stepDefinitions;
import functions.confirmationFunctionsReportView;
import io.cucumber.java.en.And;
import pageObjects.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class confirmationFunctionsConfirmReportView_Steps extends Base_PO {

        confirmationFunctionsReportView confirmReportView;

        public confirmationFunctionsConfirmReportView_Steps() throws IOException, URISyntaxException {

            confirmReportView = new confirmationFunctionsReportView();
            confirmReportView.initElements();
        }


// --------------------------- Report View ----------------------------------------
    @And("I confirm the value for {string}, {string} is correct in report view")
    public void i_confirm_the_specific_text_is_showing_in_report_view(String item, String entry) throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmCorrectReportView(item, entry);
    }

    @And("I confirm the rating {string} is displayed for {string} in report view")
    public void i_confirm_the_specific_rating_is_displayed_for_this_is_multi_text(String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewRating(rating, item);
    }

    @And("I confirm the date {string} for item {string} holds the correct value in report view")
    public void i_Confirm_The_date_for_item_is_correct_in_report_view (String specifiedDate, String item) throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewDate(specifiedDate, item);
    }

    @And("I confirm the text in {string}, {string} is correct and formatted correctly in report view")
    public void i_Confirm_The_Cloned_Text_In_Is_Correct_And_Formatted_Correctly(String format, String entry) throws IOException, URISyntaxException {
        confirmReportView.confirmReportViewTextFormat(format, entry);
    }

    @And("I confirm the rating {string} is displayed in report view for {string}")
    public void i_Confirm_The_Cloned_RatingIs_Correct_For_This_is_a_Rating (String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewRating(rating, item);
    }

    @And("I confirm all the correct notes text is listed in the report view")
    public void i_confirm_all_the_correct_notes_text_is_listed_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmPreformattedNotesTextInReportView();
    }


    /*@And("I confirm the specific text is showing in report view")
    public void i_confirm_the_specific_text_is_showing_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(confirmationFunctions.prefilledTextMultiReportView);
        confirmationFunctions.confirmUploadReportViewPrefilledMulti(prefilledText);
    }

    @And("I confirm the entry is the same in report view {string}")
    public void i_confirm_the_entry_is_the_same_in_report_view(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSingleText);
        confirmReportView.confirmReportViewSingleText(expectedText);

    }



    @And("I confirm This is Single Text holds the correct value in report view")
    public void i_confirm_this_is_single_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewSingleText();
    }


    @And("I confirm This is Multi Text Rating holds the correct value in report view")
    public void i_confirm_this_is_multi_text_rating_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewMultiTextRating();
    }

    @And("I confirm This is Prefilled Text \\(Single) holds the correct value in report view")
    public void i_confirm_this_is_prefilled_text_single_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewPrefilledSingle();
    }


    @And("I confirm the entry is the same in report view {string}")
    public void i_confirm_the_entry_is_the_same_in_report_view(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSingleText);
        confirmReportView.confirmReportViewSingleTextModified(expectedText);
    }


    @And("I confirm This is Prefilled Text \\(Multi) holds the correct value in report view")
    public void i_confirm_this_is_prefilled_text_multi_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewPrefilledMulti();
    }

    @And("I confirm This is a Date holds the correct value in report view {string}")
    public void i_confirm_this_is_a_date_holds_the_correct_value_in_report_view(String expectedDate) throws IOException, URISyntaxException {
        confirmReportView.confirmReportViewDate(expectedDate);
    }

    @And("I confirm This Has Baked In Tokens holds the correct value in report view")
    public void i_confirm_this_has_baked_in_tokens_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException {
        confirmReportView.confirmReportViewBakedInTokens();
    }

    @And("I confirm This is Predefined Responses holds the correct value in report view")
    public void i_confirm_this_is_predefined_responses_holds_the_correct_value_in_report_view() {
        confirmReportView.confirmReportViewPredefinedResponses();
    }

    /*@And("I confirm This is Multi Text holds the correct value in report view")
    public void i_confirm_this_is_multi_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewMultiText();
    }*/




}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/