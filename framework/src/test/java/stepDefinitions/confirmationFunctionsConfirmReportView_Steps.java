package stepDefinitions;

import functions.confirmationFunctions;
import functions.confirmationFunctionsReportView;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;


public class confirmationFunctionsConfirmReportView_Steps extends Base_PO {

        TestAllControlsRM_PO testAllControlsRM_po;
        Homepage_PO homepage_po;
        SharedStepsFieldNav_PO sharedStepsFieldNav_po;
        globalFunctions globalFunctions;
        confirmationFunctionsReportView confirmReportView;
        CreateReport_PO createReport_po;


        private String expectedNumber;
        public String prefilledText = "New Paragraph\n" +
                "THIS IS NEW TEXT ADDED FOR TESTING " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. " +
                "Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus " +
                "urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac " +
                "molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna " +
                "sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. " +
                "Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";

        private String numericExpected = "123,456,789,000,000,000";
        private String enterBoldExpected = "Entering some bold text to confirm form uploads correctly";
        private String enterItalicsExpected = "Entering some italics text to confirm form uploads correctly";
        private String enterUnderlinedExpected = "Entering some underlined text to confirm form uploads correctly";
        private String enterMultiformatExpected = "Bold text with some added italics, added underline but removed bold, completed with strikethrough changed with simple bold and finally removed all formatting";

        private final String bullet1Text = "Bullet list entry 1";
        private final String bullet2Text = "Bullet list entry 2";
        private final String bullet3Text = "Bullet list entry 3";
        private final String numlist1Text = "Number list entry 1";
        private final String numlist2Text = "Number list entry 2";
        private final String numlist3Text = "Number list entry 3";

        private @FindBy(xpath = "//button[@value='ordered']") WebElement orderedList;


        public confirmationFunctionsConfirmReportView_Steps() throws IOException, URISyntaxException {

            testAllControlsRM_po = new TestAllControlsRM_PO();
            testAllControlsRM_po.initElements();

            homepage_po = new Homepage_PO();
            homepage_po.initElements();

            globalFunctions = new globalFunctions();
            globalFunctions.initElements();

            sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
            sharedStepsFieldNav_po.initElements();

            confirmReportView = new confirmationFunctionsReportView();
            confirmReportView.initElements();

            createReport_po = new CreateReport_PO();
            createReport_po.initElements();
        }


// --------------------------- Report View ----------------------------------------
    /*@And("I confirm the specific text is showing in report view")
    public void i_confirm_the_specific_text_is_showing_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(confirmationFunctions.prefilledTextMultiReportView);
        confirmationFunctions.confirmUploadReportViewPrefilledMulti(prefilledText);
    }*/

    /*@And("I confirm the entry is the same in report view {string}")
    public void i_confirm_the_entry_is_the_same_in_report_view(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSingleText);
        confirmReportView.confirmReportViewSingleText(expectedText);

    }*/



  /*  @And("I confirm This is Single Text holds the correct value in report view")
    public void i_confirm_this_is_single_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewSingleText();
    }


    @And("I confirm This is Multi Text Rating holds the correct value in report view")
    public void i_confirm_this_is_multi_text_rating_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewMultiTextRating();
    }

    @And("I confirm This is Prefilled Text \\(Single) holds the correct value in report view")
    public void i_confirm_this_is_prefilled_text_single_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        //confirmReportView.confirmReportViewPrefilledSingle();
    }


    @And("I confirm the entry is the same in report view {string}")
    public void i_confirm_the_entry_is_the_same_in_report_view(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSingleText);
        confirmReportView.confirmReportViewSingleTextModified(expectedText);
    }


    @And("I confirm This is Prefilled Text \\(Multi) holds the correct value in report view")
    public void i_confirm_this_is_prefilled_text_multi_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewPrefilledMulti();
    }

    @And("I confirm This is a Date holds the correct value in report view {string}")
    public void i_confirm_this_is_a_date_holds_the_correct_value_in_report_view(String expectedDate) throws IOException, URISyntaxException {
        confirmReportView.confirmReportViewDate(expectedDate);
    }

    @And("I confirm This Has Baked In Tokens holds the correct value in report view")
    public void i_confirm_this_has_baked_in_tokens_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException {
        confirmReportView.confirmReportViewBakedInTokens();
    }

    @And("I confirm This is Predefined Responses holds the correct value in report view")
    public void i_confirm_this_is_predefined_responses_holds_the_correct_value_in_report_view() {
        confirmReportView.confirmReportViewPredefinedResponses();
    }

    /*@And("I confirm This is Multi Text holds the correct value in report view")
    public void i_confirm_this_is_multi_text_holds_the_correct_value_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmReportView.confirmReportViewMultiText();
    }*/




}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/