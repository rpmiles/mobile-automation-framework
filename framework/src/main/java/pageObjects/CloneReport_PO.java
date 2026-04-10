package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.globalVariables;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;


public class CloneReport_PO extends Base_PO {

    Homepage_PO homepagePo;

    public @FindBy(id = "template-name") WebElement dataCapture;
    public @FindBy(id = "report-name") WebElement reportName;
    public @FindBy(id = "report-reference") WebElement reference;
    public @FindBy(id = "notes") WebElement extraNotes;
    public @FindBy(id = "save-report") WebElement saveReport;
    public @FindBy(xpath = "//button[.//span[text()=' Clone Report ']]") WebElement cloneButton;
    public @FindBy(xpath = "//button[.//span[text()=' Author ']]") WebElement authorButton;
    public @FindBy(id = "include-notes-button") WebElement includeNotes;
    // public @FindBy(xpath = "//button[contains(@id, 'include-notes-button') and contains(@class, 'mdc-switch--checked')]") WebElement includeNotes;
    public @FindBy(id = "include-photos-audio-button") WebElement includePhotosAudio;
    public @FindBy(id = "report-date") WebElement inspectionDateElement;
    public @FindBy(id = "due-date") WebElement dueDateElement;


    public CloneReport_PO() throws IOException, URISyntaxException {
        super();
        PageFactory.initElements(getDriver(), this);
        homepagePo = new Homepage_PO();
        homepagePo.initElements();
    }

    public void selectAll(WebElement fieldToSelect) throws IOException, URISyntaxException {
        sendKeys(fieldToSelect, (Keys.chord(Keys.CONTROL, "a")));
    }

    public void cloneReport(String targetReport, String nameOfReport, String referenceText,
                            String inspectionDateReq, String inspectionDate, String dueDateReq, String dueDate, String notesText, String addNotes, String addPhotos) throws IOException, URISyntaxException, InterruptedException {

        /////////////////////////Select Report Clone Button////////////////////////////
        System.out.println("- Clicking Clone");
        waitForWebElementAndClickElement(cloneButton);

        /////////////////////////Enter Report Name////////////////////////////
        nameOfReport = (nameOfReport + " (" + globalVariables.releaseVersion + ")");
        reportName.clear();
        sendKeys(reportName, nameOfReport);

        /////////////////////////Enter Reference////////////////////////////
        String fullReferenceText = ( referenceText + " (" + globalVariables.releaseVersion + ")");
        reference.clear();
        sendKeys(reference, fullReferenceText);

        /////////////////////////Select Inspection Date////////////////////////////
        if (inspectionDateReq.equals("true")) {

            selectAll(inspectionDateElement);
            sendKeys(inspectionDateElement, inspectionDate);
        }

        /////////////////////////Select Due Date////////////////////////////
        if (dueDateReq.equals("true")) {

            selectAll(dueDateElement);
            sendKeys(dueDateElement, dueDate);
        }
        /////////////////////////Add Notes////////////////////////////
        sendKeys(extraNotes, notesText);


        /////////////////////////Include Photo's and Audio?////////////////////////////
        if ("true".equals(addPhotos)) {
            System.out.println("- Including photos and audio");
            waitForWebElementAndClickElement(homepagePo.addPhotos);
        }


        /////////////////////////Include Notes?////////////////////////////

        if ("true".equals(addNotes)) {
            System.out.println("- Including notes");
            getDriver().hideKeyboard();
            waitForWebElementAndClickElement(homepagePo.addNotes);
        }


        /////////////////////////Create Report///////////////////////////
        System.out.println("Creating Clone Report");
        waitForWebElementToBeVisible(saveReport);
        waitForWebElementAndClickElement(saveReport);

        System.out.println("Retrieving report header");
        Thread.sleep(1000);
        WebElement reportHeader = getDriver().findElement(By.xpath("//div[contains(@class, 'report-name')]"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'report-name')]")
        ));

        String reportHeaderText = reportHeader.getText();
        System.out.println("Report header text: " + reportHeader);

        System.out.println("Confirming report has loaded");
        Thread.sleep(1000);

        Assert.assertTrue(reportHeaderText.contains(nameOfReport),
                "Expected header to contain: '" + nameOfReport + "', but actual text was: '" + reportHeader + "'");
        ;

    }

}