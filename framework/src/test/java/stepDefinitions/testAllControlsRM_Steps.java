package stepDefinitions;


import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;


public class testAllControlsRM_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
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


    public String prefilledText = "New Paragraph\n" +
            "THIS IS NEW TEXT ADDED FOR TESTING " +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod rutrum lacinia. " +
            "Donec auctor, purus vel malesuada fringilla, turpis enim accumsan libero, nec tempor lectus " +
            "urna interdum sem. Maecenas et turpis scelerisque, convallis dui at, tempor orci. Vivamus ac " +
            "molestie odio. Cras in est dolor. Maecenas nec augue eu arcu tincidunt ullamcorper. In eu magna " +
            "sed diam ultrices ornare. Integer tempus magna ac vulputate imperdiet. Aliquam erat volutpat. " +
            "Sed efficitur ex sed blandit mattis. Maecenas vestibulum tempus quam nec faucibus. Quisque ultrices dapibus sodales.";



    public testAllControlsRM_Steps() throws IOException, URISyntaxException {

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

    //Text operations steps
    @And("I send the cursor to the end of the text")
    public void i_send_the_cursor_to_the_end_of_the_text() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.sendCursorToEnd();
    }

    @And("I enter a single line of text {string}")
    public void i_enter_single_text(String text) {
        testAllControlsRM_po.enterSingleTextItem(text);
    }

    @And("I enter a single line of multiformatted text")
    public void i_enter_a_single_line_of_multiformatted_text() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterMultiFormatText();
    }

    @When("I enter specific text")
    public void i_enter_specific_text() throws IOException, URISyntaxException {
        System.out.println("Selecting Multi Text item");

        // Add bold text
        testAllControlsRM_po.selectBold();
        testAllControlsRM_po.enterMultiTextItem(boldText);

        // Add italicised text
        testAllControlsRM_po.selectItalics();
        testAllControlsRM_po.enterMultiTextItem(italicsText);

        //Add underlined text
        testAllControlsRM_po.selectUnderline();
        testAllControlsRM_po.enterMultiTextItem(underlineText);

        //Add strikethrough text
        testAllControlsRM_po.selectStrikethrough();
        testAllControlsRM_po.enterMultiTextItem(strikethroughText);
        testAllControlsRM_po.selectMultiTextEnterButton();
    }

    @And("I enter specific text {string}")
    public void enter_a_specific_text(String text) throws IOException, URISyntaxException {
        testAllControlsRM_po.selectMultiTextCarriageReturnButton();
        sendKeys(testAllControlsRM_po.multiText, text);

    }

    @And("I enter specific multi text")
    public void i_enter_specific_multiText() throws IOException, URISyntaxException {
        testAllControlsRM_po.enterMultiTextItem(prefilledText);
    }

    @Then("I enter some text into the multi text item {string}")
    public void i_enter_some_text(String text) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.enterMultiTextItem(text);
    }

    @And("I copy all the text")
    public void i_copy_all_the_text() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "c")));
    }

    @And("I paste all the text into the notes field")
    public void paste_all_the_text_into_the_notes_field() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "v")));
    }

    @And("I add three lines of text")
    public void i_add_three_lines_of_text() throws IOException, URISyntaxException {
        testAllControlsRM_po.enterNotes(numlist1Text);
        testAllControlsRM_po.enterNotes(numlist2Text);
        testAllControlsRM_po.enterNotes(numlist3Text);
        testAllControlsRM_po.selectEnter();
    }
    
    @And("I select the x at the end of the single text field")
    public void i_select_the_x_at_the_end_of_the_single_text_field() {
        System.out.println("Clearing field with x");
        testAllControlsRM_po.clearSingleTextX();
    }

    @And("I clear all the text in the Multi Text Prefilled item")
    public void i_delete_all_the_text_in_the_multi_text_prefilled_item() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.clearMultiText();
    }
    
    @And("I clear the text")
    public void i_clear_the_text() {
        System.out.println("Clearing text");
        testAllControlsRM_po.multiText.clear();
    }
    
    @And("I select all the text")
    public void i_select_all_the_text() throws IOException, URISyntaxException {
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "a")));
    }

    @And("I select all and delete")
    public void i_clear_the_field() throws IOException, URISyntaxException {
        System.out.println("Selecting all text");
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.CONTROL, "a")));
        System.out.println("Deleting text");
        sendKeys(testAllControlsRM_po.multiText, (Keys.chord(Keys.BACK_SPACE)));
    }

    

    //Text formatting steps
    @And("I add unformatted text")
    public void add_unformatted_text() throws IOException, URISyntaxException {
        testAllControlsRM_po.enterNotes(boldText);
        testAllControlsRM_po.enterNotes(italicsText);
        testAllControlsRM_po.enterNotes(underlineText);
        testAllControlsRM_po.enterNotes(strikethroughText);
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

    @And("I make the text bold")
    public void i_make_it_bold() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectBold();
    }

    @And("I make the text italics")
    public void i_make_it_italics() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectItalics();
    }

    @And("I make the text strikethrough")
    public void i_make_the_notes_strikethrough() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectStrikethrough();
    }

    @And("I make the notes underlined")
    public void i_make_the_notes_underlined() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectUnderline();
    }

    @And("I remove bold")
    public void i_remove_bold() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectBold();
    }

    @And("I remove italics")
    public void i_remove_italics() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectItalics();
    }

    @And("I create a bullet list of three entries")
    public void i_create_a_bullet_list_of_three_entries() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectBulletList();
        testAllControlsRM_po.enterNotes(bullet1Text);
        testAllControlsRM_po.enterNotes(bullet2Text);
        testAllControlsRM_po.enterNotes(bullet3Text);
        testAllControlsRM_po.selectMultiTextEnterButton();
        testAllControlsRM_po.selectMultiTextEnterButton();

    }

    @And("I change the bullet list to a number list.")
    public void i_change_the_bullet_list_to_a_number_list() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectAllMultiText();
        testAllControlsRM_po.selectNumList();
    }

    @And("I select the bullet list button")
    public void i_select_the_bullet_list_button() throws IOException, URISyntaxException, InterruptedException {
        Thread.sleep(1000);
        testAllControlsRM_po.selectBulletList();
    }

    @And("I select the numbered list button")
    public void i_select_the_numbered_list_button() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectNumList();
    }


    
    //Item functions
    @And("I select the photo grid")
    public void i_select_the_photo_grid() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(testAllControlsRM_po.photoGrid);
    }

    @And("I select the crosshairs icon")
    public void i_select_the_crosshairs_icon_() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectSingleTextCrosshairs();
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

        Thread.sleep(2000);
    }

    @And("I select the location crosshairs icon")
    public void i_select_the_location_crosshairs_icon() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectMultiTextCrosshairs();
    }

    @And("I select the notes button")
    public void i_select_the_notes_button() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectNotes();
    }
    
    @And("I select the carriage return button")
    public void i_select_the_carriage_return_button() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectMultiTextCarriageReturnButton();
    }

    @And("I delete a predefined response {string}")
    public void i_delete_a_predefined_response(String response3) throws MalformedURLException, URISyntaxException {
        testAllControlsRM_po.deleteSpecificText(response3);
    }


}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







