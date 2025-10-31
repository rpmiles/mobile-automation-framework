package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.Homepage_PO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class syncProfileMenuDuringSync_Steps {

    private final Homepage_PO homepage_po;

    public syncProfileMenuDuringSync_Steps(Homepage_PO homepagePo) throws MalformedURLException, URISyntaxException {
        this.homepage_po = homepagePo;

    }

    @Then("the signed in user is listed")
    public void the_signed_in_user_is_listed() throws IOException, URISyntaxException {
        System.out.println("Confirming correct signed in user listed in Profile menu");
        homepage_po.confirmUser();
        System.out.println("Correct user confirmed");
    }
    @And("if the Sign out button is selected the user is signed out")
    public void if_the_button_is_selected_the_user_is_signed_out() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Signing the user out");
        homepage_po.signOut();
        homepage_po.confirmSignOutButtonClick();
    }

}
