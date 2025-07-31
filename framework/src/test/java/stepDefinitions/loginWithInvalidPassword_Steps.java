package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class loginWithInvalidPassword_Steps extends Base_PO {

    Login_PO login_po;

    public loginWithInvalidPassword_Steps() throws IOException, URISyntaxException {
        //System.out.println("LoginPage constructor called");

        login_po = new Login_PO();
        login_po.initElements();  //  Initialize elements AFTER driver is ready

    }

    @And("I enter an incorrect password")
    public void i_enter_an_incorrect_password() throws IOException, URISyntaxException {
        System.out.println("Setting incorrect password");
        sendKeys(login_po.password, "anypassword");
    }
}
