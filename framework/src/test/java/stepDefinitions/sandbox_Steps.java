package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class sandbox_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    NotesControl_PO notesControl_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;


    public sandbox_Steps() throws IOException, URISyntaxException {
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
    }



    @And("Export the preformatted text field in report view")
    public void export_the_preformatted_text_field_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(confirmationFunctions.preformattedReportView);
        String preformatted = confirmationFunctions.preformattedReportView.getText();
        System.out.println("Preformatted Text: " + preformatted);
    }

    @And("Export the single text field in report view")
    public void export_the_single_text_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.singleTextReportView);
        String singleText = confirmationFunctions.singleTextReportView.getText();
        System.out.println("Single Text: " + singleText);
    }

    @And("Export the multi text field in report view")
    public void export_the_multi_text_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.multiTextReportView);
        String multiText = confirmationFunctions.multiTextReportView.getText();
        System.out.println("Multi Text: " + multiText);
    }

    @And("Export the prefilled single field in report view")
    public void export_the_prefilled_single_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.prefilledTextSingleReportView);
        String prefilledSingle = confirmationFunctions.prefilledTextSingleReportView.getText();
        System.out.println("Prefilled Single: " + prefilledSingle);
    }

    @And("Export the prefilled multi field in report view")
    public void export_the_prefilled_multi_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.prefilledTextMultiReportView);
        String prefilledMulti = confirmationFunctions.prefilledTextMultiReportView.getText();
        System.out.println("Prefilled Multi: " + prefilledMulti);
    }

    @And("Export the date field in report view")
    public void export_the_date_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.dateReportView);
        String date = confirmationFunctions.dateReportView.getText();
        System.out.println("Date" + date);
    }

    @And("Export the switch field in report view")
    public void export_the_switch_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.switchReportView);
        String switchReport = confirmationFunctions.switchReportView.getText();
        System.out.println("Switch: " + switchReport);
    }

    @And("Export the picklist field in report view")
    public void export_the_picklist_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.picklistReportView);
        String picklist = confirmationFunctions.picklistReportView.getText();
        System.out.println("Picklist: " + picklist);
    }

    @And("Export the baked in tokens field in report view")
    public void export_the_baked_in_tokens_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.bakedInReportView);
        String baked = confirmationFunctions.bakedInReportView.getText();
        System.out.println("Baked In: " + baked);
    }

    @And("Export the predefined responses field in report view")
    public void export_The_PredefinedResponses_Field_In_Report_View() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.predefinedResponsesReportView);
        String predef = confirmationFunctions.predefinedResponsesReportView.getText();
        System.out.println("Predefined: " + predef);
    }

    @And("Export the numeric field in report view")
    public void export_the_numeric_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.numericReportView);
        String numeric = confirmationFunctions.numericReportView.getText();
        System.out.println("Numeric: " + numeric);
    }

    @And("Export the enter bold field in report view")
    public void export_the_enter_bold_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.boldItemReportView);
        String bold = confirmationFunctions.boldItemReportView.getText();
        System.out.println("Bold: " + bold);
    }

    @And("Export the enter italics field in report view")
    public void export_the_enter_italics_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.italicsItemReportView);
        String italics = confirmationFunctions.italicsItemReportView.getText();
        System.out.println("Italics: " + italics);
    }

    @And("Export the enter underlined field in report view")
    public void export_the_enter_underlined_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.underlinedItemReportView);
        String underlined = confirmationFunctions.underlinedItemReportView.getText();
        System.out.println("Underlined: " + underlined);
    }

    @And("Export the enter multiformat field in report view")
    public void export_the_enter_multiformat_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.multiFormattedItemReportView);
        String multiFormatted = confirmationFunctions.multiFormattedItemReportView.getText();
        System.out.println("Multi Formatted: " + multiFormatted);
    }

    @And("Export the rating field in report view")
    public void export_the_rating_field_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(confirmationFunctions.ratingReportView);
        String rating = confirmationFunctions.ratingReportView.getText();
        System.out.println("Rating: " + rating);
    }
}

