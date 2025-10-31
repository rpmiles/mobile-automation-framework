package stepDefinitions;


import functions.confirmationFunctions;
import functions.confirmationFunctionsConfirmUpload;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;
import java.io.IOException;
import java.net.URISyntaxException;



public class confirmationFunctionsConfirmUpload_Steps extends Base_PO {

    private confirmationFunctionsConfirmUpload confirmUpload;

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    confirmationFunctionsConfirmUpload confirmationFunctionsConfirmUpload;
    CreateReport_PO createReport_po;


    public confirmationFunctionsConfirmUpload_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();

        confirmUpload = new confirmationFunctionsConfirmUpload();
        confirmUpload.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();

    }

    @And("I confirm the specific uploaded text is displayed for the multi text item {string}")
    public void i_confirm_the_specific_uploaded_text_is_displayed_for_the_multi_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedCorrectMultiText(item);
    }

    @And("I confirm the specific uploaded text is displayed for the single text item {string}")
    public void i_confirm_the_specific_uploaded_text_is_displayed_for_the_single_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedCorrectSingleText(item);
    }

    @And("I confirm the uploaded predefined responses are correct")
    public void i_Confirm_The_Predefined_Responses_Are_Correct() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmReportPredefinedResponsesUpload();
    }

    @And("I confirm the uploaded text in {string} is correct and formatted correctly")
    public void i_Confirm_The_Uploaded_Text_In_Is_Correct_And_Formatted_Correctly(String format) throws IOException, URISyntaxException {
        confirmUpload.confirmUploadTextFormat(format);
    }

    @And("I confirm the specific uploaded rating {string} is displayed for This is Multi Text")
    public void i_confirm_the_specific_uploaded_rating_is_displayed_for_this_is_multi_text(String rating) throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmMultiTextRating(rating);
    }


    //Confirming uploaded report view
    @And("I confirm the uploaded text for Preformatted Text for Copy and Paste Tests in report view are correct")
    public void i_confirm_preformatted_text_for_copy_paste_tests_in_report_view_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewPreformattedText();
    }

    @And("I confirm the uploaded text for This is Single Text holds the correct value in report view")
    public void i_confirm_the_upload_text_for_This_is_Single_Text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewSingleText();
    }

    @And("I confirm the uploaded text for This is Multi Text holds the correct value in report view")
    public void i_confirm_the_upload_text_for_This_is_Multi_Text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewMultiText();
    }

    @And("I confirm the uploaded rating for This is Multi Text Rating holds the correct value in report view")
    public void i_confirm_the_uploaded_rating_for_This_is_Multi_Text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewMultiTextRating();
    }

    @And("I confirm the uploaded text for This is Prefilled Text Single holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_this_is_prefilled_text_single_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewPrefilledSingleText();
    }

    @And("I confirm the uploaded text for This is Prefilled Text Multi holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_this_is_prefilled_text_multi_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewPrefilledMultiText();
    }

    @And("I confirm the uploaded switch for This is a Switch holds the correct value in report view")
    public void i_confirm_the_uploaded_switch_for_this_is_a_switch_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewSwitch();
    }

    @And("I confirm the uploaded options for Multi Select Pick List holds the correct value in report view")
    public void i_confirm_the_uploaded_options_for_multi_select_pick_list_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewMultiPicklist();
    }

    @And("I confirm the uploaded options for Baked in Tokens holds the correct value in report view")
    public void i_confirm_the_uploaded_options_for_baked_in_tokens_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException {
        confirmUpload.confirmUploadReportViewBakedInTokens();
    }

    @And("I confirm the uploaded predefined responses for This is Predefined Responses holds the correct value in report view")
    public void i_confirm_the_uploaded_predefined_responses_for_this_is_predefined_responses_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewPredefinedResponses();
    }

    @And("I confirm the uploaded number for This is a Numeric holds the correct value in report view")
    public void i_confirm_the_uploaded_value_for_this_is_a_numeric_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadReportViewNumeric();
    }
    @And("I confirm the uploaded text for Enter Bold Text holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_enter_bold_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewEnterBoldText();
    }

    @And("I confirm the uploaded text for Enter Italics Text holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_enter_italics_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewEnterItalicsText();
    }

    @And("I confirm the uploaded text for Enter Underlined Text holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_enter_underlined_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewEnterUnderlinedText();;
    }

    @And("I confirm the uploaded text for Enter Multi Formatted Text holds the correct value in report view")
    public void i_confirm_the_uploaded_text_for_enter_multiformatted_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewEnterMultiFormattedText();;
    }

    @And("I confirm the uploaded rating for This is a Rating holds the correct value in report view")
    public void i_confirm_the_uploaded_rating_for_this_is_a_rating_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewRating();
    }
}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/