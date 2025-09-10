package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static utils.globalVariables.adminUser;

public class homepage_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    NotesControl_PO notesControl_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    functions.globalFunctions globalFunctions;
    functions.confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;

    public homepage_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        notesControl_po = new NotesControl_PO();
        notesControl_po.initElements();

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

    @And("I sign in as Richard Watterson")
    public void i_sign_in_as_richard_watterson() throws IOException, URISyntaxException {
        sendKeys(homepage_po.userName, "user@beta.com");
        sendKeys(homepage_po.password, "run my testing decisively");
    }

    @And("I confirm the report name has not changed {string}")
    public void i_confirm_the_report_name_has_not_changed(String name) throws IOException, URISyntaxException {
        createReport_po.confirmReportName(name);
    }

    @And("I confirm the reference has not changed")
    public void i_confirm_the_reference_has_not_changed() throws IOException, URISyntaxException {
        confirmationFunctions.confirmEmpty();
    }

    @And("I enter {string} as the report reference")
    public void i_enter_as_the_report_reference(String reference) throws IOException, URISyntaxException {
        createReport_po.enterReference(reference);
    }
    @And("I select update")
    public void i_select_update() throws IOException, URISyntaxException {
        createReport_po.saveReport();
    }

    @And("I delete the reference")
    public void i_delete_the_reference() throws IOException, URISyntaxException {
        createReport_po.deleteReference();
    }

    @And("I confirm the reports list report name is {string}")
    public void i_confirm_the_report_name_is(String reportName) throws IOException, URISyntaxException {
        createReport_po.confirmReportName(reportName);
    }

    @And("I confirm the reports list reference is {string}")
    public void i_confirm_the_reports_reference_is(String reference) throws IOException, URISyntaxException {
        createReport_po.confirmReference(reference);
    }

    @And("I confirm the reference is {string}")
    public void i_confirm_the_reference_is(String reference) throws IOException, URISyntaxException {
        createReport_po.confirmReference(reference);
    }

    @And("I enter an invalid inspection date {string}")
    public void i_enter_an_invalid_inspection_date (String date) throws IOException, URISyntaxException {
        createReport_po.enterInvalidInspectionDate(date);
    }

    @And("I select the reference field")
    public void i_select_the_author_field() {
        createReport_po.reference.click();
    }

    @And("I confirm the inspection date is marked as invalid")
    public void i_confirm_the_inspection_date_is_marked_as_invalid() throws IOException, URISyntaxException {
        createReport_po.confirmInvalidInspectionDate();
    }


    @And("I enter an invalid due date {string}")
    public void i_enter_an_invalid_due_date(String date) throws IOException, URISyntaxException {
        createReport_po.enterInvalidDueDate(date);
    }

    @And("I confirm the due date is marked as invalid")
    public void i_confirm_the_due_date_is_marked_as_invalid() throws IOException, URISyntaxException {
        createReport_po.confirmInvalidDueDate();
    }

    @And("I enter some report notes {string}")
    public void i_enter_some_report_notes(String text) {
        createReport_po.extraNotes.sendKeys(text);
    }

    @And("I clear the report notes field")
    public void i_clear_the_notes_field() {
        createReport_po.extraNotes.clear();
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

    @And("I search cloud reports for {string}")
    public void i_search_for (String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        homepage_po.searchForCloud(searchTerm);
    }

    @And("I close the search field")
    public void i_search_close_the_search_field () throws IOException, URISyntaxException {
     homepage_po.closeLocalSearch.click();
    }
}