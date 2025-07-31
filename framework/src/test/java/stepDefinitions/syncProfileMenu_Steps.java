package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class syncProfileMenu_Steps extends Base_PO {

    private Homepage_PO hompeage_po;

    public syncProfileMenu_Steps(Homepage_PO homepagePo) throws IOException, URISyntaxException {
        super();
        this.hompeage_po = homepagePo;
        //System.out.println("SyncProfileMenu_Steps constructor called");
    }

    @And("I select the profile menu")
    public void select_the_profile_menu() throws IOException, URISyntaxException {
        System.out.println("Selecting Profile menu");
        hompeage_po.clickProfileMenu();
    }
    @And("I select sync")
    public void select_sync() throws IOException, URISyntaxException {
        System.out.println("Selecting Profile menu Sync");
        hompeage_po.clickProfileSync();

    }

    @And("I select sync without wait")
    public void i_select_sync_without_wait() throws IOException, URISyntaxException {
        System.out.println("Selecting Profile menu Sync");
        hompeage_po.clickProfileSyncWithoutWait();

    }



}
