package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.Homepage_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class syncLogin_Steps {

    private static final Logger log = LoggerFactory.getLogger(syncLogin_Steps.class);
    private final Homepage_PO homepage_po;
    private final Login_PO login_po;

    public syncLogin_Steps(Homepage_PO homepagePo, Login_PO loginPo) throws MalformedURLException, URISyntaxException {
        //System.out.println("SyncLogin+Steps constructor called");

        homepage_po = homepagePo;
        login_po = loginPo;
    }

    @And("I select Cloud Reports")
    public void select_cloud_reports() throws IOException, URISyntaxException {
        System.out.println("Selecting 'Cloud reports'");
        homepage_po.selectCloudReports();
    }

    @And("I download a specific report")
    public void download_a_specific_report() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Downloading report");
        homepage_po.downloadSyncTemplate();
    }


    @And("I open the report")
    public void open_the_report() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Opening report");
        homepage_po.editReport();
    }

    @And("I confirm the reports data")
    public void confirm_the_reports_data() throws IOException, URISyntaxException {
        System.out.println("Confirming downloaded report is correct");
        homepage_po.confirmReport();
    }

    @And("I sign out")
    public void i_sign_out() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Signing out");
        homepage_po.signOut();
    }

    @And("I confirm the sign out")
    public void confirm_the_sign_out() throws IOException, URISyntaxException {
        System.out.println("Confirming Sign Out");
        homepage_po.confirmSignOutButtonClick();
    }

    @Then("I receive a confirmation")
    public void i_receive_a_confirmation() throws IOException, URISyntaxException, InterruptedException {
        homepage_po.confirmSignout();
        System.out.println("Sign out confirmed");
    }
}
