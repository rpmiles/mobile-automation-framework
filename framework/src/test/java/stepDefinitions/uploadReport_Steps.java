package stepDefinitions;

import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import utils.globalVariables;

import java.io.IOException;
import java.net.URISyntaxException;

public class uploadReport_Steps extends Base_PO {

    Homepage_PO homepage_po;
    functions.globalFunctions globalFunctions;

    private String boldText = "This is bold text";
    private String italicsText = "This is italicized text";
    private String underlineText = "This is underlined text";
    private String strikethroughText = "This is strikethrough text";
    private String bullet1Text = "Bullet list entry 1";
    private String bullet2Text = "Bullet list entry 2";
    private String bullet3Text = "Bullet list entry 3";
    private String numlist1Text = "Number list entry 1";
    private String numlist2Text = "Number list entry 2";
    private String numlist3Text = "Number list entry 3";
    private String expectedNumber;

    public uploadReport_Steps() throws IOException, URISyntaxException, URISyntaxException {

        homepage_po = new Homepage_PO();
        homepage_po.initElements();

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();
    }


    @And("I select the upload button")
    public void i_select_the_upload_button() throws IOException, URISyntaxException, InterruptedException {
        //Thread.sleep(2000);
        globalFunctions.scrollAndSelectHomepage("//gr-icon-button[@id='upload-report']");
    }

    @And("I select cancel")
    public void i_select_cancel() throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectHomepage("//button[@id='cancel']");
    }

    @When("I select upload")
    public void i_select_upload() throws IOException, URISyntaxException, InterruptedException {
        By firstUploadConfirm = By.xpath("//span[contains(text(), 'Cancel')]");

        WebElement upload = getDriver().findElement(firstUploadConfirm);
        waitForWebElementToBeVisible(upload);
        globalFunctions.scrollAndSelectHomepage("//button[@id='confirm-button']");
    }

    @And("I cancel the upload")
    public void i_cancel_the_upload() throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectHomepage("//button[@id='close-gallery-button']");
    }

    /*@And("I upload the report")
    public void i_upload_the_report() throws IOException, URISyntaxException, InterruptedException {
        By uploadConfirm = By.xpath("//button[@id='cancel-confirm-button']");

        WebElement finalUpload = getDriver().findElement(uploadConfirm);
        waitForWebElementToBeVisible(finalUpload);
        globalFunctions.scrollAndSelectHomepage("//button[@id='cancel-confirm-button']");
    }*/

    @And("I confirm the upload has completed")
    public void i_confirm_the_upload_has_completed() throws IOException, URISyntaxException, InterruptedException {
        homepage_po.confirmReportUploaded();
    }

    @And("I close the upload dialog")
    public void i_close_the_upload_dialog() throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectHomepage("//button[@id='close-gallery-button']");
    };

    @Given("I download a specific report with name {string}")
    public void i_Download_A_Specific_Report_With_Name(String reportName) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(homepage_po.cloudReports);
        String updatedReportName = (reportName + " <" + globalVariables.releaseVersion + ">");
        homepage_po.searchForCloud(updatedReportName);
        System.out.println("Report to download: " + updatedReportName);
        waitForWebElementAndClickElement(homepage_po.downloadReport);
        waitForWebElementAndClickElement(homepage_po.confirmButton);
    }


}
