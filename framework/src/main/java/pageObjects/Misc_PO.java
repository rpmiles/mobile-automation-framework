package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.globalVariables.adminPsw;
import static utils.globalVariables.adminUser;

public class Misc_PO extends Base_PO {

    public @FindBy(id = "email") WebElement userName;
    public @FindBy(id = "password") WebElement password;
    public @FindBy(xpath = "//*[text()='Got it!']") WebElement cookieDialog;
    private @FindBy(id = "sign-in") WebElement signInButton;
    private @FindBy(id = "mat-mdc-error-1") WebElement emailReq;
    private @FindBy(xpath = "//div[text()=' Wrong email or password ']") WebElement wrongUserPsw;
    private @FindBy(id = "open-report-search") WebElement openReportSearch;
    private @FindBy(id = "open-local-report-search") WebElement openLocalReportSearch;
    private @FindBy(id = "close-report-search") WebElement closeReportSearch;
    public @FindBy(id = "search-reports-input") WebElement searchReportField;
    private @FindBy(xpath = "//div[.='Report Items - Sorting Tables <Dummy>']/following-sibling::div//button[.//*[local-name()='svg' and @data-icon='pencil']]"
    ) WebElement editButton;




    public Misc_PO() throws IOException, URISyntaxException
    {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateTo_Web_Portal() throws IOException, URISyntaxException {
        getDriver().get("https://portal.test-goreport.services/");

    }

    public void setUser() throws IOException, URISyntaxException {
        sendKeys(userName, adminUser);
    }

    public void setPsw () throws IOException, URISyntaxException {
        sendKeys(password, adminPsw);
    }

    public void open_report_search() throws IOException, URISyntaxException, InterruptedException {
        Thread.sleep(2000);
        waitForWebElementAndClickElement(openReportSearch);
    }

    public void searchForClonedReport(String clonedReport) throws IOException, URISyntaxException, InterruptedException {
        Thread.sleep(2000);
        waitForWebElementAndClickElement(closeReportSearch);
        waitForWebElementAndClickElement(openReportSearch);
        sendKeys(searchReportField, clonedReport);
    }

    public void selectCloneEdit() throws IOException, URISyntaxException {
        waitForWebElementToBeVisible(editButton);
        waitForWebElementAndClickElement(editButton);

    }
}
