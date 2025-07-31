package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementHelper;
import utils.globalVariables;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import static driver.DriverFactory.getDriver;


public class CloneReport_PO extends Base_PO{


    public @FindBy(id = "template-name") WebElement dataCapture;
    public @FindBy(id = "report-name") WebElement reportName;
    public @FindBy(id = "report-reference") WebElement reference;
    public @FindBy(id = "notes") WebElement extraNotes;
    public @FindBy(id = "save-report") WebElement saveReport;
    public @FindBy(xpath = "//span[contains(@class, 'ml-2') and normalize-space(text())='Clone Report']") WebElement cloneButton;
    public @FindBy(id = "include-notes-button") WebElement includeNotes;
   // public @FindBy(xpath = "//button[contains(@id, 'include-notes-button') and contains(@class, 'mdc-switch--checked')]") WebElement includeNotes;
    public @FindBy(id = "include-photos-audio-button") WebElement includePhotosAudio;
    public @FindBy(id = "report-date") WebElement inspectionDateElement;
    public @FindBy(id = "due-date") WebElement dueDateElement;


    public CloneReport_PO() throws IOException, URISyntaxException {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    public void selectAll(WebElement fieldToSelect) throws IOException, URISyntaxException {
        sendKeys(fieldToSelect, (Keys.chord(Keys.CONTROL, "a")));
    }
    public void cloneReport(String targetReport, String nameOfReport, String referenceText,
                            String inspectionDateReq, String inspectionDate, String dueDateReq, String dueDate,  String notesText, String addNotes, String addPhotos) throws IOException, URISyntaxException, InterruptedException {

        /////////////////////////Select Report Clone Button////////////////////////////
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVariables.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-report-list-items")));

            List<WebElement> items = getDriver().findElements(By.tagName("app-report-list-items"));
            List<WebElement> ellipsisButtons = getDriver().findElements(By.id("context-menu"));

            int count = 0;
            for (WebElement item : items) {
                String title = item.getText().trim();
                if (title.contains(targetReport)) {
                    ellipsisButtons.get(count).click();
                    break;
                }
                count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to clone template");
        }

        waitForWebElementAndClick(cloneButton);
        /////////////////////////Enter Report Name////////////////////////////
        nameOfReport = (nameOfReport + " <" + globalVariables.releaseVersion + ">");
        reportName.clear();
        sendKeys(reportName, nameOfReport);

        /////////////////////////Enter Reference////////////////////////////
        String fullReferenceText = (referenceText + " <" + globalVariables.releaseVersion + ">");
        sendKeys(reference, fullReferenceText);

        /////////////////////////Select Inspection Date////////////////////////////
        if(inspectionDateReq.equals("true")) {

            selectAll(inspectionDateElement);
            sendKeys(inspectionDateElement, inspectionDate);
        }

        /////////////////////////Select Due Date////////////////////////////
        if (dueDateReq.equals("true")) {

            selectAll(dueDateElement);
            sendKeys(dueDateElement, dueDate);

            /////////////////////////Add Notes////////////////////////////
            sendKeys(extraNotes, notesText);


            /////////////////////////Include Photo's and Audio?////////////////////////////
            String ariaChecked = includePhotosAudio.getAttribute("aria-checked");
            if (!ariaChecked.equals(addPhotos)) {
                waitForWebElementAndClick(includePhotosAudio);
                if (addPhotos.equals("true")) {
                    System.out.println("Selecting to include all photographs and audio");
                }
            }

            /////////////////////////Include Notes?////////////////////////////

            ariaChecked = includeNotes.getAttribute("aria-checked");
            if (!ariaChecked.equals(addNotes)) {
                waitForWebElementAndClick(includeNotes);
                if (addNotes.equals("true")) {
                    System.out.println("Selecting to include all photographs and audio");
                }
            }


            /////////////////////////Create Report////////////////////////////
            waitForWebElementAndClick(saveReport);

        }
    }
}
