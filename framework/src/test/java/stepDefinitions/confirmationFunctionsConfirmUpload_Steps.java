package stepDefinitions;


import functions.confirmationFunctions;
import functions.confirmationFunctionsConfirmUpload;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;
import java.io.IOException;
import java.net.URISyntaxException;



public class confirmationFunctionsConfirmUpload_Steps extends Base_PO {

    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    confirmationFunctionsConfirmUpload confirmUpload;

    public confirmationFunctionsConfirmUpload_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();

        confirmUpload = new confirmationFunctionsConfirmUpload();
        confirmUpload.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();
    }



    //Items
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

    @And("I confirm for the uploaded {string}, {string} is selected")
    public void i_confirm_for_the_uploaded_rating_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmRating(item, option);
    }


    //Confirming uploaded report view
    @And("I confirm the uploaded value for {string} in report view is correct")
    public void i_confirm_report_view_holds_the_correct_value(String item) throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedCorrectReportView(item);
    }


    @And("I confirm the uploaded report view text for {string} is correct and formatted correctly")
    public void i_Confirm_The_Uploaded__Report_View_Text_Is_Correct_And_Formatted_Correctly(String format) throws IOException, URISyntaxException {
        confirmUpload.confirmUploadedReportViewTextFormat(format);
    }


    @And("I confirm the uploaded rating for This is Multi Text Rating holds the correct value in report view")
    public void i_confirm_the_uploaded_rating_for_This_is_Multi_Text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmUpload.confirmUploadedReportViewMultiTextRating();
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