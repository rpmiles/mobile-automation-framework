package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.Base_PO;
import pageObjects.CloneReport_PO;
import pageObjects.Homepage_PO;


import java.io.IOException;
import java.net.URISyntaxException;

public class cloneReportContent_Steps extends Base_PO {

    CloneReport_PO cloneReport_po;
    Homepage_PO homepage_po;
    confirmationFunctions confirmationFunctions;


// -------------------------Initialise Page Objects -----------------------
 public cloneReportContent_Steps() throws IOException, URISyntaxException {

     homepage_po = new Homepage_PO();
     homepage_po.initElements();

     cloneReport_po = new CloneReport_PO();
     cloneReport_po.initElements();

     confirmationFunctions = new confirmationFunctions();
     confirmationFunctions.initElements();
    }

    //----------------------Clone the report-------------------------
    @Given("I clone a report {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_clone_a_report(String targetReport, String nameOfReport, String referenceText,
                                 String inspectionDateReq, String inspectionDate, String dueDateReq, String dueDate, String notesText, String addNotes, String addPhotos) throws IOException, URISyntaxException, InterruptedException {
        cloneReport_po.cloneReport(targetReport, nameOfReport, referenceText, inspectionDateReq, inspectionDate, dueDateReq, dueDate, notesText, addNotes, addPhotos);
    }


    @And("I select if I want to include photos and audio {string}")
    public void i_select_if_i_want_to_include_photos_and_audio(String addPhotos) throws IOException, URISyntaxException, InterruptedException {
        if ("true".equals(addPhotos)) {
            System.out.println("Including photos and audio");
            waitForWebElementAndClickElement(homepage_po.addPhotos);
        }
    }

    @And("I select if I want to include notes {string}")
    public void i_select_if_i_want_to_include_notes (String addNotes) throws IOException, URISyntaxException, InterruptedException {
        if ("true".equals(addNotes)) {
            System.out.println("Including notes");
            waitForWebElementAndClickElement(homepage_po.addNotes);
        }
    }

/*
    //------------------------Report View----------------------------
    @And("I confirm the cloned text for Preformatted Text for Copy and Paste Tests in report view are correct")
    public void i_confirm_the_cloned_text_for_preformatted_text_for_copy_and_paste_tests_in_report_view_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPreformattedText();
    }

    @And("I confirm the cloned text in this is single text report view is correct")
    public void i_confirm_the_cloned_text_in_this_is_single_text_report_view_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewSingleText();
    }

    @And("I confirm the cloned text in Multi Text RTF report view is correct")
    public void i_confirm_the_cloned_text_in_multi_text_rtf_report_view_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewMultiText();
    }

    @And("I confirm the cloned text in Single Text Prefilled is correct in report view")
    public void i_confirm_the_cloned_text_in_single_text_prefilled_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPrefilledSingle();
    }

    @And("I confirm the modified text in Multi Text Prefilled is correct in report view")
    public void i_confirm_the_modified_text_in_multi_text_prefilled_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPrefilledMulti();
    }

    @And("I confirm the cloned date entry is correct {string} in report view")
    public void  i_confirm_the_cloned_date_entry_is_correct(String clonedReportViewDate) throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewDate(clonedReportViewDate);

    }

    @And("I confirm the cloned this is a switch is correct in report view")
    public void i_confirm_the_cloned_this_is_a_switch_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewSwitch();
    }

    @And("I confirm the cloned single select pick list is correct")
    public void i_confirm_the_cloned_single_select_pick_list_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewSingleSelectPicklist();
    }

    @And("I confirm the cloned multi select pick list is correct")
    public void i_confirm_the_cloned_multi_select_pick_list_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewMultiSelectPicklist();
    }

    @And("I confirm the cloned this has baked in tokens is correct in report view")
    public void i_confirm_the_cloned_this_has_baked_in_tokens_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportReportViewBakedInTokens();
    }

    @And("I confirm the cloned this is predefined responses is correct in report view")
    public void i_confirm_the_cloned_this_is_predefined_response_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewPredefinedResponses();
    }

    @And("I confirm the cloned this is a numeric is correct in report view")
    public void i_confirm_the_cloned_this_is_a_numeric_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewNumeric();
    }

    @And("I confirm the cloned enter bold text is correct in report view")
    public void i_confirm_the_cloned_enter_bold_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewEnterBold();
    }

    @And("I confirm the cloned enter italics text is correct in report view")
    public void  i_confirm_the_cloned_enter_italics_text_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewEnterItalics();
    }

    @And("I confirm the cloned enter underlined text is correct in report view")
    public void  i_confirm_the_cloned_enter_underlined_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewEnterUnderlined();
    }

    @And("I confirm the cloned multi formatted text is correct in report view")
    public void  i_confirm_the_cloned_enter_multi_formatted_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewMultiFormatted();
    }

    @And("And I confirm for {string}, {string} is selected")
    public void  i_confirm_the_cloned_this_is_a_rating_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewRating();
    }

    @And("I confirm the cloned rating in Multi Text RTF report view is correct")
    public void i_confirm_the_cloned_rating_in_multi_text_rtf_report_view_is_correct () throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewMultiTextRating();
    }



    // --------------------------- Steps ----------------------------------------
    @And("I confirm the cloned text for Preformatted Text for Copy and Paste Tests is correct")
    public void i_confirm_the_cloned_text_for_preformatted_text_for_copy_and_paste_tests_is_correct () throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedPreformattedTextForCopyPaste();
    }

    @And("I confirm the cloned text in this is single text is correct")
    public void i_confirm_the_cloned_text_in_this_single_text_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedSingleText();
    }

    @And("I confirm the cloned text in the item Multi Text RTF is correct")
    public void i_confirm_the_cloned_text_in_multi_rtf_report_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedMultiTextRTF();
    }

    @And("I confirm for {string} the {string} rating is selected")
    public void i_confirm_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmMultiTextRating(option);
    }

    @And("I confirm the cloned text in the item this is prefilled text single is correct")
    public void i_confirm_the_cloned_item_this_is_prefilled_text_single_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedSinglePrefilledText();
    }

    @And("I confirm the cloned text in the item Multi Text Prefilled is correct")
    public void i_confirm_the_cloned_text_in_the_item_this_is_prefilled_text_multi_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedMultiPrefilledText();
    }

    @And("I confirm the cloned date entry is correct {string}")
    public void i_confirm_the_cloned_date_entry_is_correct() throws IOException, URISyntaxException {

    }

    @And("I confirm the cloned item this is a switch is correct")
    public void i_confirm_the_cloned_item_this_is_a_switch_is_correct() throws IOException, URISyntaxException {

    }

    @And("I confirm switch {string} is selected")
    public void i_Confirm_Switch_Is_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchSelected(switchConfirm);
    }

    @And("I confirm Multi Select Pick List holds the correct value")
    public void i_confirm_this_is_a_pick_list_holds_the_correct_value() throws IOException, URISyntaxException {
        //confirmationFunctions.confirmReportViewMultiPicklist();
    }

    @And("I confirm the cloned this has baked in tokens is correct")
    public void i_confirm_the_cloned_this_is_baked_in_tokens_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBakedInTokens();
    }

    @And("I confirm the cloned item this is predefined responses is correct")
    public void i_confirm_the_cloned_item_this_is_predefined_responses_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedPredefinedResponses();
    }

    @And("I confirm the cloned item this is a numeric is correct")
    public void i_confirm_the_cloned_item_this_is_a_numeric_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedNumeric();
    }

    @And("I confirm the cloned item enter bold text is correct")
    public void i_confirm_the_cloned_item_enter_bold_text_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedEnterBoldText();
    }

    @And("I confirm the cloned item enter italics text is correct")
    public void i_confirm_the_cloned_item_enter_italics_text_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedEnterItalicsText();
    }

    @And("I confirm the cloned item enter underlined text is correct")
    public void i_confirm_the_cloned_item_enter_underlined_text_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedEnterUnderlinedText();
    }

    @And("I confirm the cloned item enter multi formatted text is correct")
    public void i_confirm_the_cloned_item_enter_multi_formatted_text_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmEnterMultiFormattedText();
    }

    @And("I confirm the cloned item this is a rating is correct")
    public void i_confirm_the_cloned_item_this_is_a_rating_is_correct(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmRating(item, option);
    }*/


}
/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/