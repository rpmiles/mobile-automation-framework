package stepDefinitions;


import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;


public class testAllControlsRM_blank_Steps extends Base_PO {

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
    private String prefilledSingleEditedExpected = "This item was previously prefilled but has now been replaced with this text";
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


    public testAllControlsRM_blank_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

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



}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







