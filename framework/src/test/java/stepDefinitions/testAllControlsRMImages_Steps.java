package stepDefinitions;


import functions.confirmationFunctions;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;
import io.appium.java_client.remote.SupportsContextSwitching;
import java.util.Set;


public class testAllControlsRMImages_Steps extends Base_PO {

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

    private @FindBy(css="span.photo-gallery-icon") WebElement imageGrid;
    private @FindBy(xpath = "//button[@value='ordered']") WebElement orderedList;
    private @FindBy(xpath = "//*[@alt='image']") WebElement selectImage;
    private @FindBy(xpath = "//lib-add-photo//span[contains(@class, 'photo-upload-icon')]") WebElement imageGallery;

    public testAllControlsRMImages_Steps() throws IOException, URISyntaxException {
        //System.out.println("testAllControlsRM_Steps constructor called");

        PageFactory.initElements(getDriver(), this);

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

    @And("I select the images grid")
    public void i_select_the_images_grid() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(imageGrid);
        imageGrid.click();
    }

    @And("I select the image")
    public void i_select_the_image() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementToBeVisible(selectImage);
        selectImage.click();
    }

    @And("I select the gallery icon")
    public void i_select_the_add_image_icon_attached_to_the_field() throws IOException, URISyntaxException {
        System.out.println("Selecting gallery link");
        waitForWebElementAndClickElement(imageGallery);
    }

    @And("I upload the selected image")
    public void i_upload_the_selected_image() throws IOException, URISyntaxException {
        uploadImageFromNativeGallery();

    }

    @And("I upload the image containing the description {string}")
    public void i_upload_the_image_containg_the_description(String description) throws Exception {

        // Cast the driver so we can access the context engine
        SupportsContextSwitching contextDriver = (SupportsContextSwitching) getDriver();

        try {
            // 1. SWITCH TO NATIVE: Tell Appium to look at the Android OS
            System.out.println("- Switching context to NATIVE_APP...");
            contextDriver.context("NATIVE_APP");

            // 2. NOW SEARCH: Run your swipe loop (it will now see the native XML!)
            swipeToFindPhoto("//*[contains(@content-desc, '" + description + "')]", 15);

            // Give the gallery a second to close after clicking the photo
            Thread.sleep(1000);

        } finally {
            // 3. SWITCH BACK TO WEBVIEW: We put this in a 'finally' block so that even
            // if the swipe fails, Appium doesn't get permanently stuck in Native mode!
            System.out.println("- Switching context back to WEBVIEW...");
            Set<String> contexts = contextDriver.getContextHandles();
            for (String context : contexts) {
                if (context.contains("WEBVIEW")) {
                    contextDriver.context(context);
                    break;
                }
            }
        }
    }

    @And("I select the image context menu")
    public void i_select_the_image_context_menu() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectImageContextMenu();
    }

    @And("I delete the image")
    public void i_delete_the_image() throws IOException, URISyntaxException {
        testAllControlsRM_po.deleteImage();
        testAllControlsRM_po.confirmImageDelete();
    }

    @And("I confirm the photo grid is no longer present")
    public void i_confirm_the_photo_grid_is_no_longer_present() throws IOException, URISyntaxException {
        testAllControlsRM_po.confirmPhotoGridNotPresent();
    }

    @And("And I enter the caption {string}")
    public void i_enter_the_caption(String caption) throws IOException, URISyntaxException {
        testAllControlsRM_po.enterCaptionImageList(caption);
    }

    @And("I select the caption link")
    public void i_select_the_caption_link() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectCaptionLink();
    }

    @And("I enter the caption {string} in the caption box")
    public void i_enter_the_caption_in_the_caption_box(String caption) throws IOException, URISyntaxException {
        testAllControlsRM_po.enterCaption(caption);
    }

    @And("I confirm the correct caption {string} is displayed in the image list")
    public void i_confirm_the_correct_caption_is_displayed_in_the_image_list(String caption) throws IOException, URISyntaxException {
        testAllControlsRM_po.confirmCaptionImageList(caption);
    }

    @And("I delete the caption in the image list")
    public void i_delete_the_caption_in_the_image_list() throws IOException, URISyntaxException {
        testAllControlsRM_po.deleteCaptionImageList();
    }

    @And("I delete the caption in the caption box")
    public void i_delete_the_caption_in_the_caption_box() throws IOException, URISyntaxException {
        testAllControlsRM_po.deletecaptionBox();
    }

    @And("I confirm the caption has been deleted from the image list")
    public void i_confirm_the_caption_has_been_deleted_from_the_image_list() throws IOException, URISyntaxException {
        testAllControlsRM_po.confirmImageListCaptionNotPresent();
    }
}



/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







