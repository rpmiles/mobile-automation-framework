package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.CloneReport_PO;
import pageObjects.Homepage_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class cloneReportPhotosOnly_Steps extends Base_PO {

    CloneReport_PO cloneReport_po;
    Homepage_PO homepage_po;
    confirmationFunctions confirmationFunctions;
    TestAllControlsRM_PO testAllControlsRM_po;


    // -------------------------Initialise Page Objects -----------------------
 public cloneReportPhotosOnly_Steps() throws IOException, URISyntaxException {

     homepage_po = new Homepage_PO();
     homepage_po.initElements();

     cloneReport_po = new CloneReport_PO();
     cloneReport_po.initElements();

     testAllControlsRM_po = new TestAllControlsRM_PO();
     testAllControlsRM_po.initElements();

     confirmationFunctions = new confirmationFunctions();
     confirmationFunctions.initElements();

    }

// --------------------------- Report View ----------------------------------------

    @And("I confirm the cloned images for Preformatted Text for Copy and Paste Tests in report view are correct")
    public void i_confirm_the_cloned_images_for_preformatted_text_for_copy_paste_tests_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewPreformattedTextImages();
    }

    @And("I confirm the cloned images in this is single text report view are correct")
    public void i_confirm_the_cloned_images_in_this_is_single_text_report_view_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewSingleTextImages();
    }

    @And("I confirm the cloned images in Multi Text RTF report view are correct")
    public void i_confirm_the_cloned__images_in_multi_text_rtf_report_view_are_correct() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmClonedReportViewMultiTextImages();
    }

//----------------------------- Steps ------------------------------------------
    @And("I confirm the correct photos are displayed")
    public void i_confirm_the_correct_photos_are_displayed() throws Exception {
        TestAllControlsRM_PO.PhotoTestUtils.compareFirstTwoPhotosUnderLibPhotoRow(getDriver(), "src/test/resources", 5);
    }


    @And("I confirm the image {string} is correct for {string}")
    public void the_image_should_perfectly_match(String expectedFileName, String item) throws Exception {

        // 1. Wait for the image to be visible (using your existing wait method)
        waitForWebElementToBeVisible(TestAllControlsRM_PO.fullSizePhoto);

        // 2. Call the validator directly on the element
        TestAllControlsRM_PO.SimpleImageValidator validator = new TestAllControlsRM_PO.SimpleImageValidator();
        validator.verifyImage(getDriver(), TestAllControlsRM_PO.fullSizePhoto, expectedFileName);
    }

    @And("I close the image viewer")
    public void i_close_the_image_viewer() throws IOException, URISyntaxException {
        System.out.println("Closing image viewer");
        WebElement closeImageViewer = getDriver().findElement(By.id("close-gallery-button"));

        waitForWebElementToBeVisible(closeImageViewer);
        waitForWebElementAndClickElement(closeImageViewer);
    }

    @And("I close the image list")
    public void i_close_the_image_list() throws IOException, URISyntaxException {
        System.out.println("Closing image list");
        WebElement closeImageViewer = getDriver().findElement(By.id("close-gallery-button"));

        waitForWebElementToBeVisible(closeImageViewer);
        waitForWebElementAndClickElement(closeImageViewer);
    }

    @And("I confirm there is audio attached")
    public void i_confirm_audio_is_attached() throws IOException, URISyntaxException {
        confirmationFunctions.confirmAudioPresent();
    }

    @And("I confirm there is no audio attached")
    public void i_confirm_audio_is_no_attached() throws IOException, URISyntaxException, InterruptedException {
        confirmationFunctions.confirmAudioNotPresent();
    }

}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/