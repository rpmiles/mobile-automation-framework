package stepDefinitions;


import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;
import utils.globalVariables;

import static utils.globalVariables.*;

import javax.swing.plaf.UIResource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;


public class testAllControlsRM_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    NotesControl_PO notesControl_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    globalFunctions globalFunctions;
    confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;

    private final String boldText = "This is bold text";
    private final String italicsText = "This is italicized text";
    private final String underlineText = "This is underlined text";
    private final String strikethroughText = "This is strikethrough text";
    private final String bullet1Text = "Bullet list entry 1";
    private final String bullet2Text = "Bullet list entry 2";
    private final String bullet3Text = "Bullet list entry 3";
    private final String numlist1Text = "Number list entry 1";
    private final String numlist2Text = "Number list entry 2";
    private final String numlist3Text = "Number list entry 3";
    private String expectedNumber;
    public String prefilledText = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING " +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. " +
            "Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus " +
            "urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac " +
            "molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna " +
            "sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. " +
            "Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";

    private String preFormattedText = ("Number list entry 1\n" +
            "Number list entry 2\n" +
            "Number list entry 3");

    //Report view expected values
    private String preformattedTextExpected = "Number list entry 1\n" +
            "Number list entry 2\n" +
            "Number list entry 3";
    private String singleTextExpected = "Single line of text entered into the single item text item";
    private String multiTextExpected = "This is bold text\n" +
            "This is italicized text\n" +
            "This is underlined text\n" +
            "This is strikethrough text";
    private String multiTextRatingExpected = "3";
    private String prefilledSingleExpected = "This item was previously prefilled but has now been replaced with this text";
    private String prefilledMultiExpected = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";
    private String dateExpected = "10 July 2025";
    private String switchExpected = "Switch 2";
    private String picklistExpected = "Option 4,Option 3";
    private String bakedInTokensExpected = "These are the baked in values:\n" +
            "\n" +
            "Date : .Date.\n" +
            "Author Name : .AuthorName.\n" +
            "Author Initials : .AuthorInitials.";
    private String predefinedResponsesExpected = "Multiple more entries are required to test\n" +
            " Third option specifically for testing \n" +
            " Text the same as the button for testing purposes";

    private String numericExpected = "123,456,789,000,000,000";
    private String enterBoldExpected = "Entering some bold text to confirm form uploads correctly";
    private String enterItalicsExpected = "Entering some italics text to confirm form uploads correctly";
    private String enterUnderlinedExpected = "Entering some underlined text to confirm form uploads correctly";
    private String enterMultiformatExpected = "Bold text with some added italics, added underline but removed bold, completed with strikethrough changed with simple bold and finally removed all formatting";
    private String ratingExpected = "N";

    private @FindBy(xpath = "//button[@value='ordered']") WebElement orderedList;


    public testAllControlsRM_Steps() throws IOException, URISyntaxException {
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

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
    }


    @And("I select the crosshairs icon")
    public void i_select_the_crosshairs_icon_() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectCrosshairs();
    }

    @And("I confirm the location coordinates have saved")
    public void i_confirm_the_location_coordinates_have_saved() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNotEmpty();
    }

    @And("I select the notes button")
    public void i_select_the_notes_button() throws IOException, URISyntaxException {
        notesControl_po.selectNotes();
    }

    @And("I enter some notes text")
    public void i_enter_some_notes_text() throws IOException, URISyntaxException {
        notesControl_po.enterNotes("Entered text");
    }


    //Navigation steps
    @And("I select the Preformatted Text for Copy and Paste Tests field")
    public void i_select_the_Preformatted_Text_for_Copy_and_Paste_Tests_field() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPreformattedText();
    }

    @And("I select the item {string}")
    public void i_select_the_item(String item) throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectReportItems(item);
    }

    @And("I return to the single text item")
    public void i_return_to_the_single_text_item() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectThisIsSingleText();
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

    @Then("the list of reports is displayed")
    public void the_list_of_reports_is_displayed() throws IOException, URISyntaxException {
        System.out.println("Waiting for reports");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));
        System.out.println("Checking first report");
        homepage_po.checkFirstReport();
    }

    @And("I confirm the data has been retained")
    public void i_confirm_the_data_has_been_retained() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNotEmpty();
    }


    //Text operations steps
    @And("I enter some text")
    public void i_enter_some_text() {
        testAllControlsRM_po.enterSingleText("The quick brown fox jumped over the lazy dog");
    }

    @And("I enter single text {string}")
    public void i_enter_single_text(String text) {
        testAllControlsRM_po.enterSingleText(text);
    }

    @And("I confirm the field has the correct text")
    public void i_confirm_the_field_has_the_correct_text() throws IOException, URISyntaxException {
        confirmationFunctions.confirmCorrectSinglePrefilledText();
    }

    @And("I confirm the multi field has the correct text")
    public void i_confirm_the_multi_field_has_the_correct_text() throws IOException, URISyntaxException {
        confirmationFunctions.confirmCorrectMultiPrefilledText();
    }

    @And("I delete all the text in the Multi Text Prefilled item")
    public void i_delete_all_the_text_in_the_multi_text_prefilled_item() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.clearMultiText();
    }

    @And("I add some extra text {string}")
    public void i_add_some_extra_text(String additionalText) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.addSomeExtraText(additionalText);
    }

    @And("I confirm the extra text has been saved {string}")
    public void i_confirm_the_extra_text_has_been_saved(String additionalText) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmExtraTextSaved(additionalText);

    }

    @And("I select the x at the end of the field")
    public void i_select_the_x_at_the_end_of_the_field() {
        System.out.println("Clearing field with x");
        testAllControlsRM_po.clearSingleTextX();
    }

    @And("I delete all the text")
    public void i_delete_all_the_text() {
        System.out.println("Deleting all text");
        testAllControlsRM_po.multiText.clear();
    }

    @And("I clear the field")
    public void i_clear_the_field() throws IOException, URISyntaxException {
        System.out.println("Deleting all text");
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.BACK_SPACE)));
    }

    @And("I select the location icon")
    public void i_select_the_location_icon() throws IOException, URISyntaxException, InterruptedException {
        WebElement wrapper = new WebDriverWait(getDriver(), Duration.ofSeconds(8))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-location div.cursor-pointer")));

        new Actions(getDriver())
                .moveToElement(wrapper)
                .pause(Duration.ofMillis(150))
                .click()
                .perform();
    }

    //Text formatting steps
    @When("I enter specific text")
    public void i_enter_specific_text() throws IOException, URISyntaxException {
        System.out.println("Selecting Multi Text item");

        // Add bold text
        testAllControlsRM_po.selectBold();
        testAllControlsRM_po.enterMultiText(boldText);

        // Add italicised text
        testAllControlsRM_po.selectItalics();
        testAllControlsRM_po.enterMultiText(italicsText);

        //Add underlined text
        testAllControlsRM_po.selectUnderline();
        testAllControlsRM_po.enterMultiText(underlineText);

        //Add strikethrough text
        testAllControlsRM_po.selectStrikethrough();
        testAllControlsRM_po.enterMultiText(strikethroughText);
        testAllControlsRM_po.selectEnter();
    }

    @When("I enter text {string}")
    public void i_enter_text(String text) throws IOException, URISyntaxException {


        // Add bold text
        testAllControlsRM_po.selectBold();
        testAllControlsRM_po.enterMultiText(boldText);

        // Add italicised text
        testAllControlsRM_po.selectItalics();
        testAllControlsRM_po.enterMultiText(italicsText);

        //Add underlined text
        testAllControlsRM_po.selectUnderline();
        testAllControlsRM_po.enterMultiText(underlineText);

        //Add strikethrough text
        testAllControlsRM_po.selectStrikethrough();
        testAllControlsRM_po.enterMultiText(strikethroughText);
        testAllControlsRM_po.selectEnter();
    }

    @And("I confirm all the multi text has been retained")
    public void i_confirm_all_the_multi_text_has_been_retained() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmFormatting();
    }

    @And("I enter the bold text {string}")
    public void i_enter_the_bold_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterBoldText(text);
    }

    @And("I enter the italics text {string}")
    public void i_enter_the_italics_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterItalicsText(text);
    }

    @And("I enter the underlined text {string}")
    public void i_enter_the_underlined_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterUnderlinedText(text);
    }

    @And("I enter the strikethrough text {string}")
    public void i_enter_the_strikethrough_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterStrikethroughText(text);
    }

    @And("I enter a single line of multiformatted text")
    public void i_enter_a_single_line_of_multiformatted_text() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterMultiFormatText();
    }

    @And("I confirm the previously entered multiformatted text has saved")
    public void i_confirm_the_previously_entered_multiformatted_text_has_saved() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSingleMultiFormat();
    }

    @And("I create a bullet list of three entries")
    public void i_create_a_bullet_list_of_three_entries() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectBulletList();
        testAllControlsRM_po.enterNotes(bullet1Text);
        testAllControlsRM_po.enterNotes(bullet2Text);
        testAllControlsRM_po.enterNotes(bullet3Text);
        testAllControlsRM_po.selectEnter();
        testAllControlsRM_po.selectEnter();

    }

    @And("I confirm the bullet list has saved")
    public void i_confirm_the_bullet_list_has_saved() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectDone();
        testAllControlsRM_po.selectMultiText();

        WebElement bulletItem = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bullet1Text + "')]"));
        Assert.assertTrue(bulletItem.isDisplayed());
        System.out.println("Bullet list entry 1 is correctly formatted");
    }

    @And("I change the bullet list to a number list.")
    public void i_change_the_bullet_list_to_a_number_list() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectAllMultiText();
        testAllControlsRM_po.selectNumList();
    }


    //Date steps
    @And("I confirm I can move to previous and next month")
    public void i_confirm_i_can_move_to_previous_and_next_month() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.nextMonth);
        waitForWebElementAndClick(testAllControlsRM_po.prevMonth);
        waitForWebElementAndClick(testAllControlsRM_po.prevMonth);
        waitForWebElementAndClick(testAllControlsRM_po.nextMonth);
    }

    @And("I select the month and year at the top")
    public void i_select_the_month_and_year_at_the_top() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.chooseMonthYear);
    }

    @And("I select the clear year button")
    public void i_select_the_clear_year_button() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.clearDate);
    }

    @And("I confirm I can move to previous and next year ranges")
    public void i_confirm_i_can_move_to_previous_and_next_year_ranges() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.nextYearRange);
        waitForWebElementAndClick(testAllControlsRM_po.prevYearRange);
        waitForWebElementAndClick(testAllControlsRM_po.prevYearRange);
        waitForWebElementAndClick(testAllControlsRM_po.nextYearRange);
    }

    @And("I select a year {string}")
    public void i_select_a_year(String year) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectYear(year);
    }

    @And("I select the clear month button")
    public void i_select_the_clear_month_button() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.clearDate);

    }

    @And("I confirm I can move to previous and next year")
    public void i_confirm_i_can_move_to_previous_and_next_year() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.nextYear);
        waitForWebElementAndClick(testAllControlsRM_po.prevYear);
        waitForWebElementAndClick(testAllControlsRM_po.prevYear);
        waitForWebElementAndClick(testAllControlsRM_po.nextYear);
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
        confirmationFunctions.confirmReportViewDateUpload(specifiedDate);
    }


    //Switch steps
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

    @Then("Switch 2 is displayed as the selected option in report view")
    public void switch_2_is_displayed_as_the_selected_option_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSwitch);
        confirmationFunctions.confirmReportViewSwitch();
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

    @Then("I confirm the previous options are selected {string}, {string}, {string}")
    public void i_confirm_the_previous_options_are_selected(String option1, String option2, String option3) throws IOException, URISyntaxException {
        confirmationFunctions.confirmPicklist(option1, option2, option3);
    }

    @And("I confirm the previous option is selected {string}")
    public void iConfirmThePreviousOptionIsSelected(String option) throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewSinglePicklist(option);
    }

    @And("I confirm the options displayed in report view are correct {string}, {string}, {string}")
    public void i_confirm_the_options_displayed_in_report_view_are_correct(String option1, String option2, String option3) throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsPicklist);
        confirmationFunctions.confirmReportViewPicklistUpload(option1, option2, option3);

    }


    //Predefined Responses steps
    @And("I select a single response {string}")
    public void i_select_a_single_response(String response) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectSingleResponse(response);
    }

    @And("confirm the previous entry is still present {string}")
    public void confirm_the_previous_entry_is_still_present(String response) throws IOException, URISyntaxException {
        confirmationFunctions.confirmSingleResponse(response);
    }

    @And("I select three more responses {string}, {string}, {string}")
    public void i_select_three_more_responses(String response2, String response3, String response4) throws IOException, URISyntaxException {
        testAllControlsRM_po.multiText.click();
        testAllControlsRM_po.multiText.sendKeys(Keys.END);
        System.out.println("Adding response 2");
        testAllControlsRM_po.selectSingleResponse(response2);
        testAllControlsRM_po.selectCarriageReturn();
        System.out.println("Adding response 3");
        testAllControlsRM_po.selectSingleResponse(response3);
        testAllControlsRM_po.selectCarriageReturn();
        System.out.println("Adding response 4");
        testAllControlsRM_po.selectSingleResponse(response4);
        testAllControlsRM_po.selectCarriageReturn();
    }

    @And("I can delete some text {string}")
    public void i_can_delete_some_text(String response3) throws MalformedURLException, URISyntaxException {
        testAllControlsRM_po.deleteText(response3);
    }

    @And("I confirm the text is deleted {string}")
    public void i_confirm_the_text_is_deleted(String response3) throws MalformedURLException, URISyntaxException {
        confirmationFunctions.confirmTextDeletion(response3);
    }

    @And("I select the carriage return button")
    public void i_select_the_carriage_return_button() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectCarriageReturn();
    }

    @Then("I enter some text {string}")
    public void i_enter_some_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.addSomeExtraText(text);
    }

    @And("I confirm the previously entered Text {string}")
    public void i_confirm_the_previously_entered_text(String text) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmMultiText(text);
    }

    @And("I confirm the previously entered Single Text {string}")
    public void i_confirm_the_previously_entered_single_text(String text) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSingleText(text);
    }

    @And("I select the location crosshairs icon")
    public void i_select_the_location_crosshairs_icon() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectLocationCrosshairs();
    }

    @And("I validate the location coordinates have been added")
    public void i_validate_the_location_coordinates_have_been_added() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectDone();
        testAllControlsRM_po.selectPredefinedResponses();
        confirmationFunctions.confirmLocationCoordinates();
    }

    @And("I send the cursor to the end of the text")
    public void i_send_the_cursor_to_the_end_of_the_text() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.sendCursorToEnd();
    }

    @And("I confirm all previously entered data is saved {string}")
    public void i_confirm_all_previously_entered_text_is_saved(String additionalText) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmLocationCoordinates();
        confirmationFunctions.confirmExtraTextSaved(additionalText);

    }

    @And("I confirm the data for predefined responses is correct in report view")
    public void i_confirm_the_data_for_predefine_responses_is_correct_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPredefinedResponses();

    }

    @And("I confirm the correct bold text is displayed")
    public void i_confirm_the_correct_bold_text_is_displayed() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewBoldItem();

    }

    @And("I confirm the correct italics text is displayed")
    public void i_confirm_the_correct_italics_text_is_displayed() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewItalicsItem();

    }

    @And("I confirm the correct underlined text is displayed")
    public void i_confirm_the_correct_underlined_text_is_displayed() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewUnderlinedItem();

    }

    @And("I confirm the correct multiformatted text is displayed")
    public void i_confirm_the_correct_multiformatted_text_is_displayed() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewMultiFormattedItem();

    }

    @Given("I login")
    public void i_login() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("logging in");
        globalFunctions.login();
        throw new io.cucumber.java.PendingException();
    }

    //Numeric steps
    @And("I select the value {string}")
    public void i_select_the_value(String value) throws IOException, URISyntaxException, InterruptedException {
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

    @And("I confirm the data has been saved and reformatted")
    public void i_confirm_the_data_has_been_saved_and_reformatted() throws IOException, URISyntaxException {
        confirmationFunctions.confirmNumericReport();
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

    @And("I confirm the correct value is listed in report view - simple")
    public void i_confirm_the_correct_value_is_listed_in_report_view_simple() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewNumericSimple();
    }

    @And("I confirm the correct value is listed in report view")
    public void i_confirm_the_correct_value_is_listed_in_report_view() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsNumeric);
        confirmationFunctions.confirmNumericReport();
    }

    @And("I confirm the correct number is listed {string}, {string}, {string}, {string}, {string}")
    public void i_confirm_the_correct_number_is_listed(String value1, String valueDot, String value2, String value3, String value0000) {
        expectedNumber = (value1 + valueDot + value2 + value3 + value0000);
        System.out.println(expectedNumber);
        confirmationFunctions.confirmNumeric(expectedNumber);

    }

    @And("I enter the value {string}")
    public void i_enter_the_value(String numericValue) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Entering value");
        testAllControlsRM_po.sendNumericValue(numericValue);

    }

    @And("I confirm I am unable to add another decimal point {string}")
    public void i_confirm_i_am_unable_to_add_another_decimal_point(String value1) {
        expectedNumber = (value1);
        System.out.println(expectedNumber);
        confirmationFunctions.confirmNumeric(expectedNumber);

    }

    @And("I copy all the text")
    public void i_copy_all_the_text() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "c")));
    }

    @And("select the notes icon")
    public void select_the_notes_icon() throws IOException, URISyntaxException {
        notesControl_po.selectNotes();
    }

    @And("paste all the text into the notes field")
    public void paste_all_the_text_into_the_notes_field() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "v")));
    }


    @And("confirm the formatting has been retained")
    public void confirm_the_formatting_has_been_retained() throws IOException, URISyntaxException {
        notesControl_po.confirmFormattingNoLists();
        confirmationFunctions.confirmMultiFormat();
    }

    @And("enter a specific text {string}")
    public void enter_a_specific_text(String text) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectCarriageReturn();
        sendKeys(testAllControlsRM_po.multiText, text);

    }

    @And("add unformatted text")
    public void add_unformatted_text() throws IOException, URISyntaxException {
        notesControl_po.enterNotes(boldText);
        notesControl_po.enterNotes(italicsText);
        notesControl_po.enterNotes(underlineText);
        notesControl_po.enterNotes(strikethroughText);
    }

    @And("I select all the text")
    public void i_select_all_the_text() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "a")));
    }

    @And("I make it bold")
    public void i_make_it_bold() throws IOException, URISyntaxException {
        notesControl_po.selectBold();
    }

    @And("confirm it is bold")
    public void confirm_it_is_bold() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBold();
    }

    @And("I make it italics")
    public void i_make_it_italics() throws IOException, URISyntaxException {
        notesControl_po.selectItalics();
    }

    @And("confirm it's bold italics")
    public void confirm_it_s_bold_italics() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBoldItalics();
    }

    @And("I remove bold")
    public void i_remove_bold() throws IOException, URISyntaxException {
        notesControl_po.selectBold();
    }

    @And("I remove italics")
    public void i_make_remove_italics() throws IOException, URISyntaxException {
        notesControl_po.selectItalics();
    }

    @And("I make it underlined")
    public void i_make_it_underlined() throws IOException, URISyntaxException {
        notesControl_po.selectUnderline();
    }

    @And("confirm it's underlined")
    public void confirm_it_s_underlined() throws IOException, URISyntaxException {
        confirmationFunctions.confirmUnderlined();
    }

    @And("I make it strikethrough")
    public void i_make_it_strikethrough() throws IOException, URISyntaxException {
        notesControl_po.selectStrikethrough();
    }

    @And("confirm it's underlined strikethrough")
    public void confirm_it_s_underlined_strikethrough() throws IOException, URISyntaxException {
        confirmationFunctions.confirmUnderlinedStrikethrough();
    }

    @And("I select the numbered list button")
    public void i_select_the_numbered_list_button() throws IOException, URISyntaxException {
        notesControl_po.selectNumList();
    }

    @And("I add three lines of text")
    public void i_add_three_lines_of_text() throws IOException, URISyntaxException {
        notesControl_po.enterNotes(numlist1Text);
        notesControl_po.enterNotes(numlist2Text);
        notesControl_po.enterNotes(numlist3Text);
        notesControl_po.selectEnter();
    }

    @And("I select the bullet list button")
    public void i_select_the_bullet_list_button() throws IOException, URISyntaxException {
        notesControl_po.selectBulletList();
    }

    @Then("I confirm all the correct text is listed in the report view")
    public void i_confirm_all_the_correct_text_is_listed_in_the_report_view() throws IOException, URISyntaxException {
        confirmationFunctions.confirmFormattedTextInMultiTextItem();
    }

    @And("I confirm it's in a numbered list")
    public void i_confirm_it_s_in_a_numbered_list() throws IOException, URISyntaxException, InterruptedException {
        //Thread.sleep(2000);
        waitForAngular(orderedList);
        confirmationFunctions.confirmNumberlist();
    }

    @And("I confirm it's in a bullet list")
    public void i_confirm_it_s_in_a_bullet_list() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBulletlist();
    }


    //Ratings steps
    @When("I select the {string} rating {string} in report view")
    public void i_select_the_rating_in_report_view(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectReportViewRatingValue(option);
    }

    @And("I confirm for {string} there is now a {string} at the end of the row in report view")
    public void i_confirm_there_is_now_at_the_end_of_the_row_in_report_view(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            waitForWebElementToBeVisible(testAllControlsRM_po.thisIsRating);
            confirmationFunctions.confirmReportViewRatingUpload(option);
        }

        if (item.equals("This is Multi Text")) {
            waitForWebElementToBeVisible(testAllControlsRM_po.thisIsRating);
            confirmationFunctions.confirmReportViewMultiRatingUpload(option);
        }
    }

    @And("I confirm for {string} the {string} is selected")
    public void i_confirm_rating_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewItemRating(option);
    }

    @And("I confirm for {string} the {string} rating is selected")
    public void i_confirm_is_selected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmMultiTextRating(option);
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
            confirmationFunctions.confirmItemDeselected(option1);
            confirmationFunctions.confirmItemDeselected(option2);
            confirmationFunctions.confirmItemDeselected(option3);
        }

        if (item.equals("This is Multi Text")) {
            confirmationFunctions.confirmMultiItemDeselected(option1);
            confirmationFunctions.confirmMultiItemDeselected(option2);
            confirmationFunctions.confirmMultiItemDeselected(option3);
        }

    }

    @And("I confirm the {string} rating {string} is deselected")
    public void i_confirm_the_rating_is_deselected(String item, String option) throws IOException, URISyntaxException, InterruptedException {
        if (item.equals("This is a Rating")) {
            confirmationFunctions.confirmItemDeselected(option);
        }

        if (item.equals("This is Multi Text")) {
            confirmationFunctions.confirmMultiItemDeselected(option);
        }
    }

    @And("I select the context menu")
    public void i_select_the_context_menu() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClick(homepage_po.contextMenu);
    }

    @And("I remove the report")
    public void i_remove_the_report() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting Remove button from flipped context menu");
        waitForWebElementAndClick(homepage_po.removeButton);
        System.out.println("Confirming removal");
        waitForWebElementAndClick(homepage_po.confirmRemove);
        System.out.println("Typing remove");
        sendKeys(homepage_po.confirmRemoveText, "Remove");
        System.out.println("Selecting Remove button");
        waitForWebElementAndClick(homepage_po.removeReport);

    }

    @And("I select Report Settings")
    public void i_select_report_settings() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting Remove button from flipped context menu");
        waitForWebElementAndClick(homepage_po.reportSettings);
    }

    @And("I enter specific multi text")
    public void i_Enter_Specific_MultiText() throws IOException, URISyntaxException {
        testAllControlsRM_po.enterMultiText(prefilledText);


    }

    @And("I confirm the specific text is showing in report view")
    public void i_Confirm_The_Specific_Text_Is_Showing_In_Report_View() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(confirmationFunctions.prefilledTextMultiReportView);
        confirmationFunctions.confirmReportViewPrefilledMultiUpload(prefilledText);
    }

    @And("I select the report which the title contains {string}")
    public void i_Select_The_Report_Which_The_Title_Contains(String title) throws IOException, URISyntaxException, InterruptedException {
        homepage_po.selectUploadReport("Upload tests");
    }

    @And("I confirm the modified value is displayed in report view {string}")
    public void i_Confirm_The_Modified_Value_Is_Displayed_In_Report_View(String option) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.singleTextPrefilled);
        confirmationFunctions.confirmReportViewPrefilledSingleUpload(option);
    }

    @And("I confirm the entered text matches in report view")
    public void i_confirm_the_entered_text_matches_in_report_view() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsMultiText);
        confirmationFunctions.confirmReportViewMultiText();
    }

    @And("I confirm the entry is the same in report view {string}")
    public void i_Confirm_The_Entry_Is_The_Same_In_Report_View(String expectedText) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(testAllControlsRM_po.thisIsSingleText);
        confirmationFunctions.confirmReportViewSingleTextUpload(expectedText);

    }

    @And("I confirm the new entries are listed in report view")
    public void i_Confirm_The_New_Entries_Are_Listed_In_Report_View() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(confirmationFunctions.preformattedReportView);
        confirmationFunctions.confirmReportViewPreformattedText();

    }

    //Confirming upload
    @And("I confirm Preformatted Text for Copy and Paste Tests holds the correct value")
    public void i_confirm_preformatted_text_for_copy_paste_tests_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPreformattedText();
    }

    @And("I confirm This is Single Text holds the correct value")
    public void i_confirm_this_is_single_text_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewSingleText();
    }

    @And("I confirm This is Multi Text holds the correct value")
    public void i_confirm_this_is_multi_text_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewMultiText();
    }

    @And("I confirm This is Multi Text Rating holds the correct value")
    public void i_confirm_this_is_multi_text_rating_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewMultiTextRating();
    }

    @And("I confirm This is Prefilled Text \\(Single) holds the correct value")
    public void i_confirm_this_is_prefilled_text_single_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPrefilledSingle();
    }

    @And("I confirm This is Prefilled Text \\(Multi) holds the correct value")
    public void i_confirm_this_is_prefilled_text_multi_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPrefilledMulti();
    }

    @And("I confirm This is a Date holds the correct value")
    public void i_confirm_this_is_a_date_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewDate();
    }

    @And("I confirm This is a Switch holds the correct value")
    public void i_confirm_this_is_a_switch_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewSwitch();
    }

    @And("I confirm This is a Pick List holds the correct value")
    public void i_confirm_this_is_a_pick_list_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewPicklist();
    }

    @And("I confirm This Has Baked In Tokens holds the correct value")
    public void i_confirm_this_has_baked_in_tokens_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewBakedInTokens();
    }

    @And("I confirm This is Predefined Responses holds the correct value")
    public void i_confirm_this_is_predefined_responses_holds_the_correct_value() {
        confirmationFunctions.confirmReportViewPredefinedResponses();
    }

    @And("I confirm This is a Numeric holds the correct value")
    public void i_confirm_this_is_a_numeric_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewNumericSimple();
    }

    @And("I confirm Enter Bold Text holds the correct value")
    public void i_confirm_enter_bold_text_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewBoldItem();
    }

    @And("I confirm Enter Italics Text holds the correct value")
    public void i_confirm_enter_italics_text_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewItalicsItem();
    }

    @And("I confirm Enter Underlined Text holds the correct value")
    public void i_confirm_enter_underlined_text_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewUnderlinedItem();
    }

    @And("I confirm Enter Multi Formatted Text holds the correct value")
    public void i_confirm_enter_multi_formatted_text_holds_the_correct_value() throws IOException, URISyntaxException {
        confirmationFunctions.confirmReportViewMultiFormattedItem();
    }

    @And("I confirm This is a Rating holds the correct value")
    public void i_confirm_this_is_a_rating_holds_the_correct_value() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewRating();
    }

    @And("I confirm the single text {string} is present")
    public void i_Confirm_The_Single_Text_Is_Present(String text) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportViewPrefilledSingleUpload(text);

    }

    @And("I confirm the specific uploaded text is displayed")
    public void i_Confirm_The_Specific_Uploaded_Text_Is_Displayed() throws IOException, URISyntaxException {
        confirmationFunctions.confirmCorrectMultiPrefilledTextUpload();

    }

    @And("I confirm switch {string} is selected")
    public void i_Confirm_Switch_Is_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchSelected(switchConfirm);
    }

    @And("I confirm switch {string} is not selected")
    public void i_Confirm_Switch_Is_Not_Selected(String switchConfirm) throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmSwitchNotSelected(switchConfirm);
    }

    @And("I confirm option {string} is selected")
    public void i_Confirm_Option_Is_Selected(String option) throws IOException, URISyntaxException {
        confirmationFunctions.confirmSinglePicklist(option);
    }

    @And("I confirm the Baked In Tokens Text")
    public void i_Confirm_The_Baked_In_Tokens_Text() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBakedInTokens();
    }

    @And("I confirm the predefined responses are correct")
    public void i_Confirm_The_Predefined_Responses_Are_Correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmReportPredefinedResponsesUpload();
    }

    @And("I confirm the correct number is listed")
    public void i_Confirm_The_Correct_Number_Is_Listed() {
        confirmationFunctions.confirmNumeric(numericExpected);
    }

    @And("I confirm the text is correct and formatted in bold")
    public void i_Confirm_The_Text_Is_Correct_And_Formatted_In_Bold() throws IOException, URISyntaxException {
        confirmationFunctions.confirmBoldUpload(enterBoldExpected);
    }

    @And("I confirm the text is correct and formatted in italics")
    public void i_Confirm_The_Text_Is_Correct_And_Formatted_In_Italics() throws IOException, URISyntaxException {
        confirmationFunctions.confirmItalicsUpload(enterItalicsExpected);
    }

    @And("I confirm the text is correct and formatted in underlined")
    public void i_Confirm_The_Text_Is_Correct_And_Formatted_In_Underlined() throws IOException, URISyntaxException {
        confirmationFunctions.confirmUnderlinedUpload(enterUnderlinedExpected);
    }

    @And("I confirm the text is correct and formatted correctly")
    public void i_Confirm_The_Text_Is_Correct_And_Formatted_Correctly() throws IOException, URISyntaxException {
        confirmationFunctions.confirmSingleMultiFormat();
    }

    @And("I delete the report name")
    public void i_delete_the_report_name() throws IOException, URISyntaxException {
        createReport_po.deleteReportName();
    }

    @And("I select the logo")
    public void i_Select_The_Logo() throws IOException, URISyntaxException {
        waitForWebElementAndClick(testAllControlsRM_po.logo);
    }

    @And("I flip the card")
    public void i_Flip_The_Card() throws IOException, URISyntaxException {
        System.out.println("Flipping the card back over to report details");
        waitForWebElementAndClick(homepage_po.contextX);
    }

    @And("I confirm the cloned this is single text report view value is correct")
    public void i_confirm_the_cloned_this_is_single_text_report_view_value_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewSingleText();
    }

    @And("I confirm the cloned text in Multi Text RTF report view")
    public void i_confirm_the_cloned_text_in_multi_text_rtf() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewMultiText();
    }


    @And("I confirm the cloned text in Single Text Prefilled is correct")
    public void i_confirm_the_cloned_text_in_single_text_prefilled_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPrefilledSingle();
    }


    @And("I confirm the modified text in Multi Text Prefilled is correct")
    public void i_confirm_the_modified_text_in_multi_text_prefilled_is_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPrefilledMulti();
    }

    @And("I confirm the cloned date entry is correct {string}")
    public void  i_confirm_the_cloned_date_entry_is_correct(String clonedReportViewDate) throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewDate(clonedReportViewDate);

    }


    @And("I confirm the cloned this is a switch is correct")
    public void i_confirm_the_cloned_this_is_a_switch_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewSwitch();
    }


    @And("I confirm the cloned multi select pick list is correct")
    public void i_confirm_the_cloned_multi_select_pick_list_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewMultiSelectPicklist();
    }



    @And("I confirm the cloned single select pick list is correct")
    public void i_confirm_the_cloned_single_select_pick_list_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportViewSingleSelectPicklist();
    }


    @And("I confirm the cloned this has baked in tokens is correct")
    public void i_confirm_the_cloned_this_has_baked_in_tokens_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedReportBakedInTokens();
    }


    @And("I confirm the cloned this is predefined responses is correct")
    public void i_confirm_the_cloned_this_is_predefined_response_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedPredefinedResponses();
    }


    @And("I confirm the cloned this is a numeric is correct")
    public void i_confirm_the_cloned_this_is_a_numeric_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedNumeric();
    }



    @And("I confirm the cloned enter bold text is correct")
    public void i_confirm_the_cloned_enter_bold_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedEnterBold();
    }



    @And("I confirm the cloned enter italics text is correct")
    public void  i_confirm_the_cloned_enter_italics_text_is_correct () throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedEnterItalics();
    }



    @And("I confirm the cloned enter underlined text is correct")
    public void  i_confirm_the_cloned_enter_underlined_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedEnterUnderlined();
    }


    @And("I confirm the cloned multi formatted text is correct")
    public void  i_confirm_the_cloned_enter_multi_formatted_text_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedMultiFormatted();
    }


    @And("I confirm the cloned this is a rating is correct")
    public void  i_confirm_the_cloned_this_is_a_rating_is_correct() throws IOException, URISyntaxException {
        confirmationFunctions.confirmClonedRating();
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







