package stepDefinitions;


import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMDate_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    confirmationFunctions confirmationFunctions;

    public testAllControlsRMDate_Steps() throws IOException, URISyntaxException {

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();
    }


    @And("I confirm I can move to previous and next month")
    public void i_confirm_i_can_move_to_previous_and_next_month() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.nextMonth);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevMonth);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevMonth);
        waitForWebElementAndClickElement(testAllControlsRM_po.nextMonth);
    }

    @And("I select the month and year at the top")
    public void i_select_the_month_and_year_at_the_top() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.chooseMonthYear);
    }

    @And("I confirm I can move to previous and next year ranges")
    public void i_confirm_i_can_move_to_previous_and_next_year_ranges() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.nextYearRange);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevYearRange);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevYearRange);
        waitForWebElementAndClickElement(testAllControlsRM_po.nextYearRange);
    }

    @And("I select a year {string}")
    public void i_select_a_year(String year) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectYear(year);
    }

    @And("I confirm I can move to previous and next year")
    public void i_confirm_i_can_move_to_previous_and_next_year() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.nextYear);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevYear);
        waitForWebElementAndClickElement(testAllControlsRM_po.prevYear);
        waitForWebElementAndClickElement(testAllControlsRM_po.nextYear);
    }

    @And("I select a month {string}")
    public void i_select_a_month(String month) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectMonth(month);
    }

    @And("I select a day {string}")
    public void i_select_a_day(String day) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectDay(day);
    }

    @And("I confirm the correct date is listed in the report view {string}")
    public void i_confirm_the_correct_date_is_listed_in_the_report_view(String specifiedDate) throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsDate);
        confirmationFunctions.confirmReportViewDate(specifiedDate);
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







