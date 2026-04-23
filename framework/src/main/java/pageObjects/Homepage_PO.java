package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import utils.globalVariables;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utils.globalVariables.adminUser;

public class Homepage_PO extends Base_PO {

    CreateReport_PO createReport_po;

    public @FindBy(id = "email") WebElement userName;
    public @FindBy(id = "password") WebElement password;
    public @FindBy(xpath = "//*[text()='Got it!']") WebElement cookieDialog;
    public @FindBy(id = "sign-in") WebElement signInButton;
    private @FindBy(id = "mat-mdc-error-1") WebElement emailReq;
    private @FindBy(xpath = "//div[text()=' Wrong email or password ']") WebElement wrongUserPsw;
    public @FindBy(xpath = "//div[@id='no-reports' and contains(., ' You do not have any local reports on this device. ')]") WebElement noReports;
    public @FindBy(xpath = "//button[@role='menuitem'][.//span[text()='Support']]") WebElement supportData;;
    public @FindBy(xpath = "//div[text()=' Logged in user key: ']//span[text()='admin@beta.com']") WebElement supportUserKey;
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
    public @FindBy(xpath = "//button[.//span[text()=' Delete Report ']]") WebElement deleteButton;
    public @FindBy(xpath = "//button[.//span[text()=' Clone Report ']]") WebElement cloneButton;
    public @FindBy(xpath = "//span[contains(text(), 'Backup Report')]") WebElement backupReportButton;
    public @FindBy(xpath = "//button[@id='confirm-button']") WebElement confirmDelete;
    public @FindBy(xpath = "//button[.//span[text()=' Delete ']]") WebElement deleteReport;
    public @FindBy(xpath = "//input[@formcontrolname='confirmationText']") WebElement confirmDeleteText;
    public @FindBy(xpath = "//button[.//span[contains(., 'Remove Report')]]") WebElement removeButton;
    public @FindBy(xpath = "//button[@id='confirm-button']") WebElement confirmRemove;
    public @FindBy(xpath = "//input[@formcontrolname='confirmationText']") WebElement confirmRemoveText;
    public @FindBy(xpath = "//button[.//span[text()=' Remove ']]") WebElement removeReport;
    public @FindBy(xpath = "//p[contains(.,' Your report has been uploaded successfully')]") WebElement uploadCompleted;
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

    public @FindBy (xpath = "//*[contains(text(), 'Cloud Reports')]") WebElement cloudSearchButton;
    public @FindBy (id = "cloud-report-search-input") WebElement searchBoxCloud;
    public @FindBy (id = "close-cloud-report-search")  WebElement closeCloudSearch;

    public @FindBy (xpath = "//*[@data-icon='magnifying-glass']") WebElement magnifyingGlass;


    public Homepage_PO() throws IOException, URISyntaxException
    {
        super();
        //System.out.println("Homepage_PO constructor called");
        PageFactory.initElements(getDriver(), this);
        //System.out.println("Homepage_PO elements initialised");

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();
    }


    //Sync and profile menu
    public void clickSync() throws IOException, URISyntaxException {
        System.out.println("- Performing initial sync");
        waitForWebElementAndClickElement(syncButton);
    }

    public void clickProfileMenu() throws IOException, URISyntaxException {
        System.out.println("- Selecting profile menu");
        waitForWebElementAndClickElement(profileMenu);

    }

    public void clickProfileSync() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Sychronising from profile menu");
        waitForWebElementAndClickElement(profileSync);
        Thread.sleep(2000);
        waitForSyncFinish(cloudReports);
    }

    public void clickProfileSyncWithoutWait() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Sychronising from profile menu");
        waitForWebElementAndClickElement(profileSync);
    }

    public void validateSuccessfulSync() throws IOException, URISyntaxException {
        waitForSyncFinish(localReports);
        Assert.assertEquals(localReports.getText(), "Local Reports");
    }

    public void confirmUser() throws IOException, URISyntaxException {
        try {
            System.out.println("- Checking logged in user");
            waitForWebElement(profileUser);
            String actualText = profileUser.getText();
            System.out.println(actualText);
            System.out.println("Profile menu displays: " + actualText);
            Assert.assertTrue(actualText.contains(adminUser), "Logged in User is " + adminUser);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm logged in user");
        }

    }


    //Cloud or local report functions
    public void selectLocalReports() throws IOException, URISyntaxException {
        System.out.println("- Selecting local reports");
        waitForWebElementAndClickElement(localReports);

    }

    public void selectCloudReports() throws IOException, URISyntaxException {
        System.out.println("- Selecting cloud reports");
        waitForWebElementAndClickElement(cloudReports);

    }

    public void clearCloudReportSearch() throws Exception { // Changed to void
        try {
            System.out.println("- Clearing the cloud report search");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBoxCloud));
            searchInput.clear();

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", searchBoxCloud);

            System.out.println("- Waiting for default view to return...");
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".text-xl"), 1));

            System.out.println("- Default view restored.");

        } catch (Exception e) {
            Assert.fail("Unable to clear the search bar and verify default view: " + e.getMessage());
        }
        // No return needed now!
    }

    public void searchForLocal(String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Searching local reports for: " + searchTerm);


        System.out.println("- Opening local reports search box");
        waitForWebElementAndClickElement(magnifyingGlass);

        // sendKeys should also be taking the WebElement
        searchBoxLocal.clear();
        sendKeys(searchBoxLocal, searchTerm);

        // Trigger the JS event we discussed to make the filter actually work
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", searchBoxLocal);


        //        waitForWebElementAndClickElement(cloudReports);
//        waitForWebElementAndClickElement(localReports);
//
//        waitForWebElementAndClickElement(localSearchButton);
//
//        sendKeys(searchBoxLocal, searchTerm);
    }

    public void searchForCloud(String searchTerm) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Searching cloud reports for: " + searchTerm);

        // Ensure these all use the 'Element' version, NOT 'By'
        waitForWebElementAndClickElement(cloudSearchButton);

        System.out.println("- Opening cloud reports search box");
        waitForWebElementAndClickElement(magnifyingGlass);

        // sendKeys should also be taking the WebElement
        sendKeys(searchBoxCloud, searchTerm);

        // Trigger the JS event we discussed to make the filter actually work
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", searchBoxCloud);
    }

    public void confirmReportListed(String expectedTitle) {
        try {
            // 1. Grab whatever is currently on the screen
            List<WebElement> actualReportElements = getDriver().findElements(By.cssSelector(".text-xl"));

            // 2. Build a simple list of the text found
            List<String> reportTitles = new ArrayList<>();
            for (WebElement element : actualReportElements) {
                reportTitles.add(element.getText().trim());
            }

            System.out.println("Current reports on screen: " + reportTitles);

            // 3. Simple check: Does the list of found titles contain our expected string?
            boolean isFound = reportTitles.stream().anyMatch(title -> title.contains(expectedTitle));

            Assert.assertTrue(isFound, "Expected report '" + expectedTitle + "' not found in: " + reportTitles);

        } catch (Exception e) {
            Assert.fail("Report list check failed: " + e.getMessage());
        }
    }

    public void confirmOnlyReportListed(String expectedTitle) {
        try {
            System.out.println("- Checking if report containing '" + expectedTitle + "' is on screen...");

            // 1. Build an XPath that looks for the class AND contains the text
            String dynamicXpath = String.format("//*[contains(@class, 'text-xl') and contains(text(), '%s')]", expectedTitle);

            // 2. Just check if the browser can find at least one element that matches
            boolean isFound = getDriver().findElements(By.xpath(dynamicXpath)).size() > 0;

            // 3. Assert
            Assert.assertTrue(isFound, "Expected report '" + expectedTitle + "' was not found on the screen.");

            System.out.println("- Success: Report was found!");

        } catch (Exception e) {
            Assert.fail("Report list check failed: " + e.getMessage());
        }
    }

    public void noReportsListed() throws Exception {
        try {
            System.out.println("- Verifying 'No Reports' message is displayed...");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.SYNC_WAIT_TIMEOUT));

            WebElement noReportsElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("no-reports")));
            Assert.assertTrue(noReportsElement.isDisplayed(), "The 'No Reports' container is in the DOM but not visible on screen.");

            String actualText = noReportsElement.getText().trim();
            String expectedText = "You do not have any local reports on this device.";

            Assert.assertTrue(actualText.contains(expectedText),
                    "Expected text not found! Found: '" + actualText + "'");

            System.out.println("- Confirmation successful: 'No Reports' message is visible.");

        } catch (Exception e) {
            Assert.fail("The 'No Reports' message was not found on the screen: " + e.getMessage());
        }
    }



    //Report functions
    public void downloadReport() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(downloadReport);
        waitForWebElementAndClickElement(downloadConfirm);

    Thread.sleep(3000);
    }

    public void confirmReport() throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming correct report downloaded");
            waitForWebElement(singleText);
            String actualText = singleText.getText();
            System.out.println(actualText);
            Assert.assertEquals(singleText.getText(), "Confirmation text for sync test");
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm correct report downloaded");
        }
    }

    public void checkFirstReport() throws IOException, URISyntaxException {
        String firstReportText = firstReport.getText();
        //System.out.println("First report text: " + firstReportText);

        Assert.assertTrue(firstReportText != null && !firstReportText.trim().isEmpty(), "Expected some text to be present, but it was empty or null.");


    }

    public void editReport() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Editing report");
        waitForWebElementAndClickElement(editReport);
    }

    public void selectSpecificReport(String reportName) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Selecting report: " + reportName);
        WebElement report = getDriver().findElement(By.xpath("//div[contains(@class, 'text-xl') and contains(normalize-space(), '" + reportName + "')]"));
        waitForWebElementAndClickElement(report);
    }

    public void confirmReportUploaded() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Confirming report upload");
        waitForWebElementToBeVisible(uploadCompleted);
        String reportStatus = uploadCompleted.getText();
        System.out.println("- Upload completed dialog status: " + reportStatus);
        System.out.println("- Confirming report successfully uploaded");
        Assert.assertTrue(reportStatus.contains("uploaded successfully"), "Element text does not contain 'Upload Complete' it contains " + reportStatus);
    }


    //Sign out functions
    public void signOut() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("- Clicking Sign Out");

        waitForWebElementAndClickElement(signOutButton);
        Thread.sleep(1000);

    }

    public void confirmSignOutButtonClick() throws IOException, URISyntaxException {
        try {
            System.out.println("- Confirming sign out");
            waitForWebElementAndClickElement(confirmButton);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to click confirm signout");
        }
    }

    public void confirmSignout() throws IOException, URISyntaxException {
        try {
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


}
