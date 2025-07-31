package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.SharedStepsFieldNav_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class sharedStepsFieldNav_Steps extends Base_PO {

    SharedStepsFieldNav_PO sharedStepsFieldNav_po;

    public sharedStepsFieldNav_Steps() throws IOException, URISyntaxException {
        //System.out.println("SharedStepsFieldNav constructor called");

        sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
        sharedStepsFieldNav_po.initElements();

    }


    @And("I check navigation")
    public void checkNavigation() throws IOException, URISyntaxException {
        //System.out.println("Selecting next item");
        waitForWebElementAndClick(sharedStepsFieldNav_po.nextItem());
        //System.out.println("Selecting previous item");
        waitForWebElementAndClick(sharedStepsFieldNav_po.previousItem());
        //System.out.println("Selecting previous item");
        waitForWebElementAndClick(sharedStepsFieldNav_po.previousItem());
        //System.out.println("Selecting next item");
        waitForWebElementAndClick(sharedStepsFieldNav_po.nextItem());
    }

}
