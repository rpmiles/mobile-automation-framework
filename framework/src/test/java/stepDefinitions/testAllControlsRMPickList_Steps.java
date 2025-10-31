package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMPickList_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;


    public testAllControlsRMPickList_Steps() throws IOException, URISyntaxException {


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

    //Picklist steps
    @And("I select option one {string}")
    public void i_select_option_one(String option1) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectOption(option1);
    }

    @And("I select option two {string}")
    public void i_select_option_two(String option2) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectOption(option2);
    }

    @And("I deselect the first option {string}")
    public void i_deselect_the_first_option(String option1) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectOption(option1);
    }

    @And("I select option three {string}")
    public void i_select_option_three(String option3) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectOption(option3);
    }

    @Then("I confirm the previous options are selected {string}, {string}")
    public void i_confirm_the_previous_options_are_selected(String option2, String option3) throws IOException, URISyntaxException {
        confirmationFunctions.confirmMultiPicklist(option2, option3);
    }

    @And("I confirm the previous option is selected {string}")
    public void iConfirmThePreviousOptionIsSelected(String option) throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewSinglePicklist(option);
    }

    @And("I confirm the options displayed in report view are correct {string}, {string}")
    public void i_confirm_the_options_displayed_in_report_view_are_correct(String option2, String option3) throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.multiSelectPicklist);
        confirmationFunctions.confirmMultiPicklist(option2, option3);

    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







