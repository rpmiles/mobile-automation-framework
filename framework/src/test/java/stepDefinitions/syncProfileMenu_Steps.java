package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class syncProfileMenu_Steps extends Base_PO {

    private Homepage_PO homepage_po;

    public syncProfileMenu_Steps(Homepage_PO homepagePo) throws IOException, URISyntaxException {
        super();
        this.homepage_po = homepagePo;
    }

    @And("I select the profile menu")
    public void select_the_profile_menu() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(homepage_po.profileMenu);
    }

    @And("I select sync")
    public void select_sync() throws IOException, URISyntaxException {
        homepage_po.clickProfileSync();

    }

    @And("I select sync without wait")
    public void i_select_sync_without_wait() throws IOException, URISyntaxException {
        System.out.println("Selecting Profile menu Sync");
        homepage_po.clickProfileSyncWithoutWait();

    }

}
