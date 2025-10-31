package stepDefinitions;

import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMNumeric_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;


    private String expectedNumber;

    public testAllControlsRMNumeric_Steps() throws IOException, URISyntaxException {

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



    @And("I select the numeric value {string}")
    public void i_select_the_numeric_value(String value) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting value");
        globalFunctions.scrollAndSelectNumeric(value);
    }

    @And("I confirm there is a decimal point {string}")
    public void i_confirm_there_is_a_decimal_point(String decimal) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmNumeric(decimal);
    }

    @And("I confirm the correct value is listed {string}")
    public void i_confirm_the_correct_value_is_listed(String value0) {
        {
            expectedNumber = (value0);
            System.out.println("Entered number" + expectedNumber);
            confirmationFunctions.confirmNumeric(expectedNumber);
        }
    }

    @And("I confirm the correct amount is listed {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_confirm_the_correct_amount_is_listed(String value0, String valueDot, String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value00, String value000) {
        {
            expectedNumber = (value0 + valueDot + value1 + value2 + value3 +
                    value4 + value5 + value6 + value7 + value8 +
                    value9 + value00 + value000);

            System.out.println("Entered number" + expectedNumber);
            confirmationFunctions.confirmNumeric(expectedNumber);
        }
    }

    @And("I select the decimal point {string}")
    public void i_select_the_decimal_point(String valueDot) throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectNumeric(valueDot);
    }

    @And("I confirm another decimal point has not been entered {string}, {string}, {string}, {string}, {string}")
    public void i_confirm_another_decimal_point_has_not_been_entered(String value1, String valueDot, String value2, String value3, String value0000) {
        expectedNumber = (value1 + valueDot + value2 + value3 + value0000);
        System.out.println(expectedNumber);
        confirmationFunctions.confirmNumeric(expectedNumber);

    }

    @And("I confirm the correct numeric value is listed in report view {string}")
    public void i_confirm_the_correct_value_is_listed_in_report_view (String expectedNumber) throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsNumeric);
        confirmationFunctions.confirmReportViewNumeric(expectedNumber);
    }

    @And("I confirm the correct number is listed {string}, {string}, {string}, {string}, {string}")
    public void i_confirm_the_correct_number_is_listed(String value1, String valueDot, String value2, String value3, String value0000) {
        expectedNumber = (value1 + valueDot + value2 + value3 + value0000);
        System.out.println(expectedNumber);
        confirmationFunctions.confirmNumeric(expectedNumber);

    }

    @And("I enter the numeric value {string}")
    public void i_enter_the_value(String numericValue) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Entering  numericvalue");
        testAllControlsRM_po.sendNumericValue(numericValue);

    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







