package pageObjects;

import functions.confirmationFunctions;
import functions.globalFunctions;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import utils.globalVariables;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static utils.globalVariables.adminUser;

public class Homepage_PO extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    NotesControl_PO notesControl_po;
    Homepage_PO homepage_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    functions.globalFunctions globalFunctions;
    functions.confirmationFunctions confirmationFunctions;
    CreateReport_PO createReport_po;


    String userProfilePath = "//*[.//span[text()='" + adminUser + "']]";
    String specialChars = "!@£$%^&*()_+-={}][:'\\?></.,~`";

    public @FindBy(id = "email") WebElement userName;
    public @FindBy(id = "password") WebElement password;
    public @FindBy(xpath = "//*[text()='Got it!']") WebElement cookieDialog;
    public @FindBy(id = "sign-in") WebElement signInButton;
    private @FindBy(id = "mat-mdc-error-1") WebElement emailReq;
    private @FindBy(xpath = "//div[text()=' Wrong email or password ']") WebElement wrongUserPsw;

    public @FindBy(xpath = "//button[.//span[text()=' Sync Now ']]") WebElement syncButton;
    public @FindBy(id = "user-profile") WebElement profileMenu;
    public @FindBy(xpath = "//button[.//span[text()='Sync']]") WebElement profileSync;
    public @FindBy(xpath = "//button[.//span[text()='Local Reports']]") WebElement localReports;
    public @FindBy(xpath = "//button[@name='reportView']//span[contains(text(), 'Cloud Reports')]") WebElement cloudReports;
    public @FindBy(id = "confirm-button") WebElement downloadConfirm;
    public @FindBy(id = "close-gallery-button") WebElement cancelDownload;
    public @FindBy(id = "edit-report") WebElement editReport;
    public @FindBy(xpath = "//*[normalize-space()='Confirmation text for sync test']") WebElement singleText;
    public @FindBy(xpath = "//*[.//span[text()='admin@beta.com']]") WebElement profileUser;
    public @FindBy(xpath = "//*[text()='Sign out']") WebElement signOutButton;
    public @FindBy(tagName = "app-report-list-items") WebElement firstReport;
    public @FindBy(id = "context-menu") WebElement contextMenu;
    public @FindBy(xpath = "//button[.//span[text()='Delete Report']]") WebElement deleteButton;
    public @FindBy(xpath = "//button[.//span[text()='Clone Report']]") WebElement cloneButton;
    public @FindBy(xpath = "//button[@id='confirm-button']") WebElement confirmDelete;
    public @FindBy(xpath = "//button[.//span[text()=' Delete ']]") WebElement deleteReport;
    public @FindBy(xpath = "//input[@formcontrolname='confirmationText']") WebElement confirmDeleteText;
    public @FindBy(xpath = "//button[.//span[text()='Remove Report']]") WebElement removeButton;
    public @FindBy(xpath = "//button[@id='confirm-button']") WebElement confirmRemove;
    public @FindBy(xpath = "//input[@formcontrolname='confirmationText']") WebElement confirmRemoveText;
    public @FindBy(xpath = "//button[.//span[text()=' Remove ']]") WebElement removeReport;
    public @FindBy(xpath = "//p[contains(text(), 'Upload complete')]") WebElement uploadCompleted;
    public @FindBy(xpath = "//span[contains(text(), 'Report Settings')]") WebElement reportSettings;
    public @FindBy(xpath = "//gr-icon-button[contains(@id, 'context-menu') and not(contains(@class, 'ng-star-inserted'))]") WebElement contextX;
    public @FindBy(xpath = "//input[@id='report-name']") WebElement reportName;
    public @FindBy(id = "download-report") WebElement downloadReport;
    public @FindBy(xpath = "//button[@id='confirm-button']") WebElement confirmButton;
    public @FindBy(id = "include-photos-audio-button") WebElement addPhotos;
    public @FindBy(id = "include-notes-button") WebElement addNotes;

    public @FindBy (id = "open-local-report-search") WebElement localSearchButton;
    public @FindBy (id = "local-report-search-input") WebElement searchBoxLocal;
    public @FindBy (id = "close-local-report-search") WebElement closeLocalSearch;

    public @FindBy (id = "open-cloud-report-search") WebElement cloudSearchButton;
    public @FindBy (id = "cloud-report-search-input") WebElement searchBoxCloud;
    public @FindBy (id = "close-cloud-report-search")  WebElement closeCloudSearch;


    public Homepage_PO() throws IOException, URISyntaxException
    {
        super();
        //System.out.println("Homepage_PO constructor called");
        PageFactory.initElements(getDriver(), this);
        //System.out.println("Homepage_PO elements initialised");

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
    }


    public void clickSync() throws IOException, URISyntaxException {
        System.out.println("Performing initial sync");
        waitForWebElementAndClick(syncButton);
    }

    public void validateSuccessfulSync() throws IOException, URISyntaxException {
        waitForSyncFinish(localReports);
        Assert.assertEquals(localReports.getText(), "Local Reports");
    }

    public void selectLocalReports() throws IOException, URISyntaxException {
        System.out.println("Selecting local reports");
        waitForWebElementAndClick(localReports);

    }

    public void selectCloudReports() throws IOException, URISyntaxException {
        System.out.println("Selecting cloud reports");
        waitForWebElementAndClick(cloudReports);

    }

    public void searchForLocal(String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClick(cloudReports);
        waitForWebElementAndClick(localReports);

        waitForWebElementAndClick(localSearchButton);

        sendKeys(searchBoxLocal, searchTerm);
    }

    public void searchForCloud(String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Searching cloud reports for: " + searchTerm);
        waitForWebElementAndClick(cloudSearchButton);
        sendKeys(searchBoxCloud, searchTerm);
    }


    public void downloadReport() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClick(downloadReport);
        waitForWebElementAndClick(downloadConfirm);

        /*try {
            System.out.println("Downloading template");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));

            List<WebElement> items = getDriver().findElements(By.tagName("app-report-list-items"));
            List<WebElement> downloadButtons = getDriver().findElements(By.id("download-report"));

            int count = 0;
            for (WebElement item : items) {
                String title = item.getText().trim();
                if (title.contains("Sync Test - Template")) {

                    downloadButtons.get(count).click();
                    downloadConfirm.click();
                    waitForWebElementAndClick(cancelDownload);
                    downloadButtons.get(count).click();
                    downloadConfirm.click();
                    wait.until(ExpectedConditions.visibilityOfAllElements(editReport));
                    break;
                }
                count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to download template");
        }*/
    Thread.sleep(3000);
    }

    public void downloadUploadedReport(String reportName) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Downloading Report: " + reportName);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));

            List<WebElement> items = getDriver().findElements(By.tagName("app-report-list-items"));
            List<WebElement> downloadButtons = getDriver().findElements(By.id("download-report"));

            int count = 0;
            for (WebElement item : items) {
                String title = item.getText().trim();
                if (title.contains(reportName)) {

                    downloadButtons.get(count).click();
                    downloadConfirm.click();
                    waitForWebElementAndClick(cancelDownload);
                    downloadButtons.get(count).click();
                    downloadConfirm.click();
                    wait.until(ExpectedConditions.visibilityOfAllElements(editReport));
                    break;
                }
                count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to download report");
        }

    }

    public void editReport() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Editing report");
        waitForWebElementAndClick(editReport);
    }

    public void clickProfileMenu() throws IOException, URISyntaxException {
        System.out.println("Selecting profile menu");
        waitForWebElementAndClick(profileMenu);

    }

    public void clickProfileSync() throws IOException, URISyntaxException {
        System.out.println("Sychronising from profile menu");
        waitForWebElementAndClick(profileSync);
        waitForSyncFinish(cloudReports);
    }

    public void clickProfileSyncWithoutWait() throws IOException, URISyntaxException {
        System.out.println("Sychronising from profile menu");
        waitForWebElementAndClick(profileSync);
    }

    public void confirmReport() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming correct report downloaded");
            waitForWebElement(singleText);
            String actualText = singleText.getText();
            System.out.println(actualText);
            Assert.assertEquals(singleText.getText(), "Confirmation text for sync test");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm correct report downloaded");
        }
    }

    public void confirmUser() throws IOException, URISyntaxException {
        try {
            System.out.println("Checking logged in user");
            waitForWebElement(profileUser);
            String actualText = profileUser.getText();
            System.out.println(actualText);
            Assert.assertTrue(actualText.contains(adminUser), "Logged in User is " + adminUser);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm logged in user");
        }

    }

    public void confirmSignOutButtonClick() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming sign out");
            waitForWebElementAndClick(confirmButton);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to click confirm signout");
        }
    }


    public void checkFirstReport() throws IOException, URISyntaxException {
        String firstReportText = firstReport.getText();
        //System.out.println("First report text: " + firstReportText);

        Assert.assertTrue(firstReportText != null && !firstReportText.trim().isEmpty(), "Expected some text to be present, but it was empty or null.");


    }

    public void signOut() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Clicking Sign Out");

        waitForWebElementAndClick(signOutButton);
        Thread.sleep(1000);

    }

    public void confirmSignout() throws IOException, URISyntaxException {
        try {
        /* waitForWebElement(getAssertSignOut);
        System.out.println("Actual text = " + getAssertSignOut);
        Assert.assertEquals(getAssertSignOut.getText(), " You have signed out! ");*/
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement getAssertSignOut = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[normalize-space(text())='You have signed out!']")
            ));
            String multiFormattedText = getAssertSignOut.getText();
            System.out.println(multiFormattedText);
            Assert.assertEquals(getAssertSignOut.getText(), "You have signed out!");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirmed user signed out");
        }
    }

    public void confirmReportUploaded() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Confirming report upload");
        waitForWebElementToBeVisible(uploadCompleted);
        String reportStatus = uploadCompleted.getText();
        System.out.println("Value of uploadCompleted element: " + reportStatus);
        System.out.println("Confirming report successfully uploaded");
        Assert.assertTrue(reportStatus.contains("Upload complete"), "Element text does not contain 'Upload Complete' it contains " + reportStatus);
    }

    public void selectUploadReport(String report) throws IOException, URISyntaxException, InterruptedException {
        try {
            System.out.println("Locating uploads test report");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));
            //System.out.println("Report variable: " + report);
            List<WebElement> items = getDriver().findElements(By.tagName("app-report-list-items"));
            List<WebElement> editButton = getDriver().findElements(By.id("edit-report"));

            int count = 0;
            for (WebElement item : items) {
                String title = item.getText().trim();
                if (title.contains(report)) {

                    editButton.get(count).click();
                    break;
                }
                count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select upload report");
        }

    }

    public void selectField(String field) throws IOException, URISyntaxException {
        System.out.println("Selecting " + field + " from context menu");
        waitForWebElementToBeVisible(reportSettings);
        waitForSyncFinish(cloudReports);
    }


    public void clickWhenReady(WebElement el, int timeoutSeconds) throws IOException, URISyntaxException {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.elementToBeClickable(el));

        try {
            el.click();
            return;
        } catch (Throwable t1) {
            try {
                new Actions(driver).moveToElement(el).click().perform();
                return;
            } catch (Throwable t2) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'}); arguments[0].click();", el);
            }
        }
    }
}
