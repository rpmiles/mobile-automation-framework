package stepDefinitions;


import functions.confirmationFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.Support_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;


public class support_Steps extends Base_PO {

    Homepage_PO homepage_po;
    TestAllControlsRM_PO testAllControlsRM_po;
    confirmationFunctions confirmationFunctions;
    Support_PO support_po;

    //private @FindBy(xpath = "//div[text()=' Logged in as: ']//span[text()='admin@beta.com']") WebElement supportListedUser;;
    private String targetRowText;

    public support_Steps() throws IOException, URISyntaxException {
        homepage_po = new Homepage_PO();
        homepage_po.initElements();

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();

        support_po = new Support_PO();
        support_po.initElements();
    }


    @And("I select support")
    public void i_select_support() throws IOException, URISyntaxException {
        homepage_po.supportData.click();
    }

   @And("I confirm the correct username {string} is listed")
    public void i_confirm_the_correct_date_is_listed_in_the_report_view(String user) throws IOException, URISyntaxException, InterruptedException {
        String usernameXpath = "//div[text()=' Logged in as: ']//span[text()='" + user + "']";
        Thread.sleep(1000);
        WebElement username = getDriver().findElement(By.xpath(usernameXpath));
        System.out.println("- Confirming visibility of logged in user");
        waitForWebElementToBeVisible(username);

        String displayedUsername = username.getText();
        System.out.println("- Displayed username is: " + displayedUsername);
        Assert.assertTrue(displayedUsername.contains(user), "Actual text does not contain expected text.");
    };

    @When("I confirm the correct logged in user key {string} is listed.")
    public void i_confirm_the_correct_logged_in_user_key_is_listed(String userKey) throws IOException, URISyntaxException {
        String userKeyXpath = "//div[text()=' Logged in user key: ']//span[text()='" + userKey + "']";
        WebElement userKeyElement = getDriver().findElement(By.xpath(userKeyXpath));
        waitForWebElementToBeVisible(userKeyElement);

        String displayedUserKey = userKeyElement.getText();
        System.out.println("- Displayed userkey is: " + displayedUserKey);
        Assert.assertTrue(displayedUserKey.contains(userKey), "Actual text does not contain expected text.");
    }




    @And("I confirm the working directory first line is correct")
    public void i_confirm_the_working_directory_first_line_is_correct() throws IOException, URISyntaxException {
        String rowXpath = "(//button[contains(text(), 'Backup Report')])[1]/ancestor::div[contains(@class, 'w-full')][1]";

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rowXpath)));
        targetRowText = row.getText();
        Assert.assertFalse(targetRowText.isEmpty(), "Could not read the row data.");
        System.out.println("- Row data saved: " + targetRowText);
    }

    @And("I confirm the report just created is listed")
    public void i_confirm_the_report_just_created_is_listed() {
        Assert.assertTrue(targetRowText.contains("Report Items - Support Data"),
                "The expected report name was not found in the row.");
    }

    @And("I select the Backup button")
    public void i_select_the_backup_button() throws IOException, URISyntaxException {
        System.out.println("THE BACKUP NEEDS TO BE CHECKED IS PRESENT IN AWS stuart mackay --> s3 --> test-report-upload files --> 4");
        support_po.backupButton.click();
    }

    @When("I confirm the backup was successful")
    public void i_confirm_the_backup_was_successful() throws IOException, URISyntaxException {
        support_po.confirmBackup.click();
    }

    @Then("I click the button to return to report list")
    public void i_click_the_button_to_return_to_the_report_list() {
        support_po.backToReports.click();
    }
    @Then("the report list is displayed")
    public void the_report_list_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







