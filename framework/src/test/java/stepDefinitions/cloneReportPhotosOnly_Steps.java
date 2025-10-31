package stepDefinitions;

import functions.confirmationFunctions;
import io.cucumber.java.en.And;
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


}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/