package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.Login_PO;
import java.io.IOException;
import java.net.URISyntaxException;


public class initialLogin_Steps extends Base_PO {

    Login_PO login_po;
    Homepage_PO homepage_po;


    public initialLogin_Steps() throws IOException, URISyntaxException {

        login_po = new Login_PO();
        login_po.initElements();

        homepage_po = new Homepage_PO();
        homepage_po.initElements();
    }

    @Given("I launch the mobile app")
    public void i_launch_the_mobile_app() throws IOException, URISyntaxException {
        System.out.println("Launching app");
        login_po.navigateTo_Mobile_Portal();
    }

    @When("I dismiss the cookie message")
    public void i_dismiss_the_cookie_message() throws IOException, URISyntaxException {
        System.out.println("Dismissing Cookie Message");
        login_po.dismissCookieMessage();
    }

    @And("I enter a username")
    public void enter_a_username() throws IOException, URISyntaxException {
        System.out.println("Entering a username");
        login_po.setUserName();
    }

    @And("I enter a password")
    public void enter_a_password() throws IOException, URISyntaxException {
        System.out.println("Entering a password");
        login_po.setPassword();
    }

    @And("I select the sign-in button")
    public void select() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting 'Sign In'");
        login_po.clickSignIn();
    }

   @And("I perform an initial sync")
    public void perform_an_initial_sync() throws IOException, URISyntaxException {
       System.out.println("Executing initial sync");
        homepage_po.clickSync();
    }

    @Then("I am met with the Mobile Portal homepage")
    public void i_am_met_with_the_mobile_portal_homepage() throws IOException, URISyntaxException {
        System.out.println("Mobile Report homepage loaded confirmed");
        homepage_po.validateSuccessfulSync();

    }

}


