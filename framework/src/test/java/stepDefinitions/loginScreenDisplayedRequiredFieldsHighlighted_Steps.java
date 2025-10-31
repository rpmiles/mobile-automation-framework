package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class loginScreenDisplayedRequiredFieldsHighlighted_Steps extends Base_PO {

    Login_PO login_po;

    public loginScreenDisplayedRequiredFieldsHighlighted_Steps() throws IOException, URISyntaxException {
        //System.out.println("LoginPage constructor called");

        login_po = new Login_PO();
        login_po.initElements();  //  Initialize elements AFTER driver is ready

    }

    @When("I try and sign in I can't because the sign in button is disabled")
    public void i_try_and_sign_in_i_can_t_because_the_sign_in_button_is_disabled() throws IOException, URISyntaxException {
        System.out.println("Confirming 'Sign in' button is disabled");
        WebElement signInButton = getDriver().findElement(By.id("sign-in"));
        Assert.assertFalse(signInButton.isEnabled(), "Confirm button disabled");
        System.out.println("'Sign in' button is disabled");
    }

    @And("I select the email address field")
    public void i_select_the_email_address_field() throws IOException, URISyntaxException {
        System.out.println("Selecting Email field");
        waitForWebElementAndClickElement(login_po.userName);
        System.out.println("Email field selected");
    }

    @And("I select the password field")
    public void i_select_the_password_field() throws IOException, URISyntaxException {
        System.out.println("Selecting Password field");
        waitForWebElementAndClickElement(login_po.password);
        System.out.println("Password field selected.");
    }

    @And("a warning is displayed saying required email")
    public void a_warning_is_displayed_saying_required_email() throws IOException, URISyntaxException {
        WebElement emailReq = getDriver().findElement(By.id("mat-mdc-error-1"));
        Assert.assertEquals(emailReq.getText(), "Email address is required");
        System.out.println("'Email required' is displayed");
    }

    @Then("a warning is displayed saying password is required")
    public void a_warning_is_displayed_saying_password_is_required() throws IOException, URISyntaxException {
        WebElement pswReq = getDriver().findElement(By.id("mat-mdc-error-0"));
        Assert.assertEquals(pswReq.getText(), "Password is required");
        System.out.println("'Password is required' is displayed");

    }

}
