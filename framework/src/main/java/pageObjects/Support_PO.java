package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.globalVariables.adminPsw;
import static utils.globalVariables.adminUser;

public class Support_PO extends Base_PO {

    public @FindBy(xpath = "//button[contains(text(), 'Backup Report')]") WebElement backupButton;
    public @FindBy(xpath = "//button[@id='close-gallery-button']") WebElement confirmBackup;
    public @FindBy(xpath = "//button[contains(text(), 'Back to report list')]") WebElement backToReports;


    public Support_PO() throws IOException, URISyntaxException{
        super();
    }

}
