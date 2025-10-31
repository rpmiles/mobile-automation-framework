package stepDefinitions;

import functions.globalFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMNavigation_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;

    public testAllControlsRMNavigation_Steps() throws IOException, URISyntaxException {

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        homepage_po = new Homepage_PO();
        homepage_po.initElements();

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();

        sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
        sharedStepsFieldNav_po.initElements();

    }


    @And("I select the item {string}")
    public void i_select_the_item(String item) throws IOException, URISyntaxException, InterruptedException {
        //globalFunctions.scrollAndSelectReportItems(item);
        By element = By.xpath("//div[contains(text(), '" + item +  "')]");
        waitForAngularBy(element);
        waitForWebElementAndClickBy(element);
    }

    @And("I return to the report")
    public void i_return_to_the_report() throws IOException, URISyntaxException {
        sharedStepsFieldNav_po.selectDone();
    }

    @And("I select the tick or done button")
    public void i_select_the_tick_done_button() throws IOException, URISyntaxException {
        sharedStepsFieldNav_po.selectDone();
    }

    @And("I select the back arrow")
    public void i_select_the_back_arrow() throws IOException, URISyntaxException {
        testAllControlsRM_po.backToReports();
    }

    @And("I select a report")
    public void i_select_a_report() throws IOException, URISyntaxException, InterruptedException {
        homepage_po.editReport();
    }

    @And("I reselect the report")
    public void i_reselect_the_report() throws IOException, URISyntaxException, InterruptedException {
        homepage_po.editReport();
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







