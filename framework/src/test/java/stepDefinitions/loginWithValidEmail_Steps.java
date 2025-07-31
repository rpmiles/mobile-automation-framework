package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import static utils.globalVariables.adminUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class loginWithValidEmail_Steps extends Base_PO {

    Login_PO login_po;


    @FindBy(id = "mat-mdc-error-2") WebElement visible;

    public loginWithValidEmail_Steps() throws IOException, URISyntaxException {
        //System.out.println("LoginPage constructor called");

        login_po = new Login_PO();
        login_po.initElements();  //  Initialize elements AFTER driver is ready

    }

    @Given("I do not enter an email in the email address field")
    public void i_do_not_enter_an_email_in_the_email_address_field() throws IOException, URISyntaxException {
        sendKeys(login_po.userName, "This is not an email");
        System.out.println("Invalid email entered");
    }

    @And("I am displayed a message saying only emails valid")
    public void i_am_displayed_a_message_saying_only_emails_valid() throws IOException, URISyntaxException {
        WebElement validEmailReq = getDriver().findElement(By.id("mat-mdc-error-2"));
        Assert.assertEquals(validEmailReq.getText(), "Please enter a valid email address");
        System.out.println("Valid email required displayed");
    }

    @And("I enter an email in the email address field")
    public void i_enter_an_email_in_the_email_address_field() throws IOException, URISyntaxException {
        login_po.userName.clear();
        System.out.println("Entering a valid email");
        sendKeys(login_po.userName, adminUser);

    }

    @Then("I do not get the error saying only emails are valid")
    public void i_do_not_get_the_error_saying_only_emails_are_valid() throws IOException, URISyntaxException {
        List<WebElement> validEmailReq = getDriver().findElements(By.id("mat-mdc-error-2"));
        Assert.assertTrue(validEmailReq.isEmpty(), "'Please enter a valid email address' should not be shown.");
        System.out.println("'Valid email required' message not displayed");

        }
    }

