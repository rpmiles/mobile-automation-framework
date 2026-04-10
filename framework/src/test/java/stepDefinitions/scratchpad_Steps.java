package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.Login_PO;
import pageObjects.scratchpad_PO;

import java.io.IOException;
import java.net.URISyntaxException;


public class scratchpad_Steps extends Base_PO {

    Login_PO login_po;
    Homepage_PO homepage_po;
    scratchpad_PO scratchpad_po;


    public scratchpad_Steps() throws IOException, URISyntaxException {

        login_po = new Login_PO();
        login_po.initElements();

        homepage_po = new Homepage_PO();
        homepage_po.initElements();

        scratchpad_po = new scratchpad_PO();
        scratchpad_po.initElements();
    }

    @Given("I visit the homepage")
    public void i_visit_the_homepage() throws IOException, URISyntaxException {
        System.out.println("Launching app");
        scratchpad_po.navigateTo_Web_Portal();
    }


    @And("I enter my username")
    public void enter_a_username() throws IOException, URISyntaxException {
        System.out.println("Entering a username");
        login_po.setUserName();
    }

    @And("I enter my password")
    public void enter_a_password() throws IOException, URISyntaxException {
        System.out.println("Entering a password");
        login_po.setPassword();
    }

    @And("I select sign-in button")
    public void select_sign() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Selecting 'Sign In'");
        login_po.clickSignIn();
    }


    @And("I open the report search")
    public void open_report_search() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Opening search");
        scratchpad_po.open_report_search();
    }

    @And("I search for the cloned report {string}")
    public void search_for_cloned_report(String clonedReport) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Searching for report'");
        scratchpad_po.searchForClonedReport(clonedReport);
    }

    @And("I select the edit button")
    public void edit_the_cloned_report(String clonedReport) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Searching for report'");
        scratchpad_po.selectCloneEdit();
    }
}


