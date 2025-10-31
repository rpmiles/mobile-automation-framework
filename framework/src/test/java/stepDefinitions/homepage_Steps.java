package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class homepage_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    functions.globalFunctions globalFunctions;
    functions.confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;

    public homepage_Steps() throws IOException, URISyntaxException {

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


    @And("I select the logo")
    public void i_Select_The_Logo() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.logo);
    }


    //Functions
    @And("I wait for the sync to complete")
    public void i_wait_for_the_sync_to_complete() throws IOException, URISyntaxException {
        System.out.println("Waiting for Sync to Complete");
        waitForPresenceOfLocated(homepage_po.noReports);
    }

    @And("I select the report with the title containing {string}")
    public void i_Select_The_Report_Which_The_Title_Contains(String title) throws IOException, URISyntaxException, InterruptedException {
        homepage_po.selectUploadReport("Upload tests");
    }

    @And("I select the cloned report {string}")
    public void i_select_the_cloned_report(String reportName) throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(homepage_po.editReport);
    }

    @And("I edit the report")
    public void i_edit_the_report() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(homepage_po.editReport);
    }

    @And("I select the context menu")
    public void i_select_the_context_menu() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(homepage_po.contextMenu);
    }

    @And("I select clone")
    public void i_select_clone() throws IOException, URISyntaxException {
        System.out.println("Clicking Clone");
        waitForWebElementAndClickElement(homepage_po.cloneButton);
    }

    @And("I delete the report")
    public void i_delete_the_report() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(homepage_po.deleteButton);
        System.out.println("Selecting Delete button from context menu");
        waitForWebElementAndClickElement(homepage_po.confirmDelete);
        System.out.println("Typing Delete");
        sendKeys(homepage_po.confirmDeleteText, "Delete");
        System.out.println("Selecting Confirm button");
        waitForWebElementAndClickElement(homepage_po.deleteReport);
        Thread.sleep(1000);
    }

    @And("I delete the master report")
    public void i_delete_the_master_report() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(homepage_po.deleteButton);
        System.out.println("Selecting Delete button from context menu");
        waitForWebElementAndClickElement(homepage_po.confirmDelete);
        System.out.println("Typing Delete");
        sendKeys(homepage_po.confirmDeleteText, "Delete");
        System.out.println("Selecting Confirm button");
        waitForWebElementAndClickElement(homepage_po.deleteReport);
        Thread.sleep(1000);
    }

    @And("I remove the report")
    public void i_remove_the_report() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting Remove button from flipped context menu");
        waitForWebElementAndClickElement(homepage_po.removeButton);
        System.out.println("Confirming removal");
        waitForWebElementAndClickElement(homepage_po.confirmRemove);
        System.out.println("Typing remove");
        sendKeys(homepage_po.confirmRemoveText, "Remove");
        System.out.println("Selecting Remove button");
        waitForWebElementAndClickElement(homepage_po.removeReport);

    }

    @And("I select Report Settings")
    public void i_select_report_settings() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting report settings from the context menu");
        waitForWebElementAndClickElement(homepage_po.reportSettings);
    }

    @And("I search cloud reports for {string}")
    public void i_search_for (String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        homepage_po.searchForCloud(searchTerm);
    }

    @And("I close the local search field")
    public void i_close_the_search_field() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(homepage_po.closeLocalSearch);
    }


    //Report settings
    @And("I delete the report name")
    public void i_delete_the_report_name() throws IOException, URISyntaxException {
        createReport_po.deleteReportName();
    }

    @And("I select the reference field")
    public void i_select_the_reference_field() {
        createReport_po.reference.click();
    }

    @And("I enter the report reference {string}")
    public void i_enter_the_report_reference(String reference) throws IOException, URISyntaxException {
        createReport_po.enterReference(reference);
    }

    @And("I delete the reference")
    public void i_delete_the_reference() throws IOException, URISyntaxException {
        createReport_po.deleteReference();
    }

    @And("I enter an invalid inspection date {string}")
    public void i_enter_an_invalid_inspection_date (String date) throws IOException, URISyntaxException {
        createReport_po.enterInvalidInspectionDate(date);
    }

    @And("I enter an invalid due date {string}")
    public void i_enter_an_invalid_due_date(String date) throws IOException, URISyntaxException {
        createReport_po.enterInvalidDueDate(date);
    }

    @And("I enter some report notes {string}")
    public void i_enter_some_report_notes(String text) {
        createReport_po.extraNotes.sendKeys(text);
    }

    @And("I clear the report notes field")
    public void i_clear_the_notes_field() {
        createReport_po.extraNotes.clear();
    }

    @And("I select update")
    public void i_select_update() throws IOException, URISyntaxException {
        createReport_po.saveReport();
    }

}


/*
@And("")
public void () throws IOException, URISyntaxException {

}
*/