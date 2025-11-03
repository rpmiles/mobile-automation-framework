package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class cloneReportNotesOnly_Steps extends Base_PO {

    CloneReport_PO cloneReport_po;
    Homepage_PO homepage_po;
    confirmationFunctions confirmationFunctions;


// -------------------------Initialise Page Objects -----------------------
 public cloneReportNotesOnly_Steps() throws IOException, URISyntaxException {

     homepage_po = new Homepage_PO();
     homepage_po.initElements();

     cloneReport_po = new CloneReport_PO();
     cloneReport_po.initElements();

    }

// --------------------------- Steps ----------------------------------------

   /* @And("I confirm the cloned notes for preformatted text for copy and paste tests are correct in report view")
    public void i_confirm_the_cloned_notes_for_preformatted_text_for_copy_paste_tests_are_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPreformattedTextNotes();
    }

    @And("I confirm the cloned notes for this is a date are correct in report view")
    public void i_confirm_the_cloned_notes_for_this_is_a_date_are_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewDateNotes();
    }

    @And("I confirm the cloned notes for this is a switch are correct in report view")
    public void i_confirm_the_cloned_notes_for_this_is_a_switch_are_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewSwitchNotes();
    }

    @And("I confirm the cloned notes for multi select pick list is correct in report view")
    public void i_confirm_the_cloned_notes_for_multi_select_pick_list_are_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewMultiSelectPicklistNotes();
    }

    @And("I confirm the cloned notes for predefined responses is correct in report view")
    public void i_confirm_the_cloned_notes_for_predefined_responses_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPredefinedResponsesNotes();
    }

    @And("I confirm the cloned notes for this is a rating is correct in report view")
    public void i_confirm_the_cloned_notes_for_this_is_a_rating_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewRatingNotes();
    }
*/

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/