package stepDefinitions;


import functions.confirmationFunctions;
import functions.confirmationFunctionsConfirmCloned;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class confirmationFunctionsConfirmCloned_Steps extends Base_PO {

    private confirmationFunctionsConfirmCloned confirmCloned;

    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    confirmationFunctionsConfirmCloned confirmationFunctionsConfirmCloned;



    public confirmationFunctionsConfirmCloned_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();

        confirmCloned = new confirmationFunctionsConfirmCloned();
        confirmCloned.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();

    }


    //Items
    @And("I confirm the specific cloned text is displayed for the multi text item {string}")
    public void i_confirm_the_specific_Cloned_text_is_displayed_for_the_multi_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedCorrectMultiText(item);
    }

    @And("I confirm the specific cloned text is displayed for the single text item {string}")
    public void i_confirm_the_specific_Cloned_text_is_displayed_for_the_single_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedCorrectSingleText(item);
    }


    @And("I confirm the cloned predefined responses are correct")
    public void i_Confirm_The_Cloned_Predefined_Responses_Are_Correct() throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmReportPredefinedResponsesCloned();
    }

    @And("I confirm the cloned text in {string} is correct and formatted correctly")
    public void i_Confirm_The_Cloned_Text_In_Is_Correct_And_Formatted_Correctly(String format) throws IOException, URISyntaxException {
        confirmCloned.confirmClonedTextFormat(format);
    }

    @And("I confirm the specific cloned rating {string} is displayed for This is Multi Text")
    public void i_confirm_the_specific_Cloned_rating_is_displayed_for_this_is_multi_text(String rating) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedReportViewMultiTextRating(rating);
    }

    @And("I confirm the cloned rating {string} is correct for {string}")
    public void i_Confirm_The_Cloned_RatingIs_Correct_For_This_is_a_Rating (String rating, String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedRating(item, rating);
    }




    /*@And("I confirm the cloned switch {string} is selected")
    public void i_Confirm_Switch_Is_Not_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchNotSelected(switchConfirm);
    }


    @And("I confirm the cloned switch {string} is not selected")
    public void i_Confirm_Switch_Is_Not_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchNotSelected(switchConfirm);
    }*/

    //Confirming cloned report view
    @And("I confirm the cloned value for {string} in report view is correct")
    public void i_confirm_report_view_holds_the_correct_value(String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedCorrectReportView(item);
    }


    @And("I confirm the cloned report view text for {string} is correct and formatted correctly")
    public void i_Confirm_The_Uploaded__Report_View_Text_Is_Correct_And_Formatted_Correctly(String format) throws IOException, URISyntaxException {
        confirmCloned.confirmClonedReportViewTextFormat(format);
    }


   /* @And("I confirm the specific cloned rating {string} is displayed for This is Multi Text")
    public void i_confirm_the_uploaded_rating_for_This_is_Multi_Text_holds_the_correct_value_in_report_view(String rating) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedReportViewMultiTextRating(rating);
    }*/

    @And("I confirm for the cloned {string}, {string} is selected")
    public void i_confirm_for_the_uploaded_rating_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedRating(item, option);
    }


    /*//Items
    @And("I confirm the specific cloned text is displayed for the multi text item {string}")
    public void i_confirm_the_specific_uploaded_text_is_displayed_for_the_multi_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedCorrectMultiText(item);
    }

    @And("I confirm the specific cloned text is displayed for the single text item {string}")
    public void i_confirm_the_specific_uploaded_text_is_displayed_for_the_single_text_item (String item) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedCorrectSingleText(item);
    }

    @And("I confirm the cloned predefined responses are correct")
    public void i_Confirm_The_Predefined_Responses_Are_Correct() throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmReportPredefinedResponsesCloned();
    }

    @And("I confirm the cloned text in {string} is correct and formatted correctly")
    public void i_Confirm_The_Uploaded_Text_In_Is_Correct_And_Formatted_Correctly(String format) throws IOException, URISyntaxException {
        confirmCloned.confirmClonedTextFormat(format);
    }

    @And("I confirm the specific cloned rating {string} is displayed for This is Multi Text")
    public void i_confirm_the_specific_uploaded_rating_is_displayed_for_this_is_multi_text(String rating) throws IOException, URISyntaxException, InterruptedException {
        confirmCloned.confirmClonedMultiTextRating(rating);
    }*/
}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/