package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMPredefinedResponses_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    confirmationFunctions confirmationFunctions;

    public testAllControlsRMPredefinedResponses_Steps() throws IOException, URISyntaxException {

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();
    }


    //Predefined Responses steps
    @And("I select a single predefined response {string}")
    public void i_select_a_single_response(String response) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectSingleResponse(response);
    }

    @And("I select predefined responses and send the cursor to the end of the text")
    public void i_select_predefined_responses_and_send_the_cursor_to_the_end_of_the_text() throws IOException, URISyntaxException {
        testAllControlsRM_po.multiText.click();
        testAllControlsRM_po.multiText.sendKeys(Keys.END);
    }

    @And("I select three more predefined responses {string}, {string}, {string}")
    public void i_select_three_more_responses(String response2, String response3, String response4) throws IOException, URISyntaxException {
        testAllControlsRM_po.multiText.click();
        testAllControlsRM_po.multiText.sendKeys(Keys.END);
        System.out.println("- Adding response 2");
        testAllControlsRM_po.selectSingleResponse(response2);
        testAllControlsRM_po.selectMultiTextCarriageReturnButton();
        System.out.println("- Adding response 3");
        testAllControlsRM_po.selectSingleResponse(response3);
        testAllControlsRM_po.selectMultiTextCarriageReturnButton();
        System.out.println("- Adding response 4");
        testAllControlsRM_po.selectSingleResponse(response4);
        testAllControlsRM_po.selectMultiTextCarriageReturnButton();
    }

    @And("I confirm the previous predefined response is still present {string}")
    public void confirm_the_previous_entry_is_still_present(String response) throws IOException, URISyntaxException {
        confirmationFunctions.confirmSingleResponse(response);
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







