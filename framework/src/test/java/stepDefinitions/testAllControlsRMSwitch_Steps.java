package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMSwitch_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    confirmationFunctions confirmationFunctions;

    public testAllControlsRMSwitch_Steps() throws IOException, URISyntaxException {
        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();
    }

    @And("I select switch {string}")
    public void i_select_switch(String switchToSelect) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectSwitch(switchToSelect);
    }

    @And("switch {string} is highlighted")
    public void switch_Is_Selected(String switchHighlighted) throws IOException, URISyntaxException {
        testAllControlsRM_po.switchSelected(switchHighlighted);
    }

    @And("switch {string} is not highlighted")
    public void switch_Is_Not_Selected(String switchNotHighlighted) throws IOException, URISyntaxException {
        testAllControlsRM_po.switchNotSelected(switchNotHighlighted);
    }

    @And("Neither {string} or {string} is highlighted")
    public void neither_this_or_that_is_highlighted(String switch1, String switch2) throws IOException, URISyntaxException {
        testAllControlsRM_po.switchNotSelected(switch1);
        testAllControlsRM_po.switchNotSelected(switch2);
    }

    @Then("I confirm the switch {string} is displayed as the selected option in report view")
    public void i_confirm_the_switch_is_displayed_as_the_selected_option_in_report_view(String selectedSwitch) throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSwitch);
        confirmationFunctions.confirmReportViewSwitch(selectedSwitch);
    }


}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







