package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;



public class testAllControlsRatings_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;
    

    public testAllControlsRatings_Steps() throws IOException, URISyntaxException {

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


    @When("I select the {string} rating {string} in report view")
    public void i_select_the_rating_in_report_view(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectReportViewRatingValue(option);
    }

    @And("I select the {string} rating {string}")
    public void i_select_the_rating(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            globalFunctions.scrollAndSelectItemViewRatingValue(option);
        }

        if (item.equals("This is Multi Text")) {
            globalFunctions.scrollAndSelectMultiItemViewRatingValue(option);
        }
    }

    @And("I confirm all the {string} ratings are deselected {string}, {string}, {string}")
    public void i_confirm_all_the_ratings_are_deselected(String item, String option1, String option2, String option3) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            confirmationFunctions.confirmRatingItemDeselected(option1);
            confirmationFunctions.confirmRatingItemDeselected(option2);
            confirmationFunctions.confirmRatingItemDeselected(option3);
        }

        if (item.equals("This is Multi Text")) {
            confirmationFunctions.confirmRatingMultiItemsDeselected(option1);
            confirmationFunctions.confirmRatingMultiItemsDeselected(option2);
            confirmationFunctions.confirmRatingMultiItemsDeselected(option3);
        }

    }

    @And("I confirm the {string} rating {string} is deselected")
    public void i_confirm_the_rating_is_deselected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            confirmationFunctions.confirmRatingItemDeselected(option);
        }

        if (item.equals("This is Multi Text")) {
            confirmationFunctions.confirmRatingMultiItemsDeselected(option);
        }
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







