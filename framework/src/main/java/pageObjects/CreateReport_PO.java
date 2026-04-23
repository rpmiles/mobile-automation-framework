package pageObjects;

import functions.globalFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.globalVariables;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class CreateReport_PO extends Base_PO {

    @FindBy(xpath = "//button[.//span[contains(text(), 'Create Report')]]")
    WebElement createReport;
    public @FindBy(id = "template-name") WebElement dataCapture;
    public @FindBy(id = "project-name") WebElement project;
    public @FindBy(id = "client-name") WebElement client;
    public @FindBy(id = "report-name") WebElement reportName;
    public @FindBy(id = "report-reference") WebElement reference;
    public @FindBy(id = "report-date") WebElement reportDate;
    public @FindBy(xpath = "//input[@id='report-date' and contains(@aria-invalid, 'true')]") WebElement reportDateInvalid;
    public @FindBy(xpath = "//input[@id='due-date' and contains (@aria-invalid, 'true')]") WebElement dueDateInvalid;
    public @FindBy(id = "due-date") WebElement reportDueDate;
    public @FindBy(id = "notes") WebElement extraNotes;
    public @FindBy(xpath = "//button[@id='save-report']") WebElement saveReport;
    public @FindBy(xpath = "//div[contains(@class, 'text-xl') and contains(@class, 'line-clamp-3')]") WebElement reportNameText;
    public @FindBy(xpath = "//div[contains(@class, 'text-secondary') and contains(@class, 'text-md')]") WebElement referenceText;


    public CreateReport_PO() throws IOException, URISyntaxException {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    public void selectCreateReport() throws IOException, URISyntaxException {
        try{
        System.out.println("- Selecting 'Create Report' button");
        waitForWebElementAndClickElement(createReport);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select 'Create Report' button");
        }
    }

    public void selectDataCapture(String dataCap) throws IOException, URISyntaxException {
        try {waitForWebElementAndClickElement(dataCapture);

        List<WebElement> datacaptures = getDriver().findElements(By.cssSelector("#template-name-panel mat-option"));
        int count = 0;
            for (WebElement item : datacaptures) {
                String datacaptureName = item.getText();
                if (datacaptureName.contains(dataCap)) {
                    datacaptures.get(count).click();

                    break;
                }
            count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("- Unable to select datacapture");
        }

    }

    public void deleteReportName() throws IOException, URISyntaxException {
        reportName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        reportName.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

    public void enterReportName(String nameOfReport) throws IOException, URISyntaxException {
        sendKeys(reportName, nameOfReport);
    }

    public void confirmReportName(String nameOfReport) throws IOException, URISyntaxException {

        System.out.println("- Confirming report name");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String text = (String) js.executeScript("return arguments[0].textContent;", reportNameText);
        System.out.println("- Report Name: " + text  );

        Assert.assertTrue(text.contains(nameOfReport));
    }

    public void deleteReference() throws IOException, URISyntaxException {
        sendKeys(reference,  (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reference, (Keys.chord(Keys.BACK_SPACE)));
    }

    public void enterReference (String referenceText) throws IOException, URISyntaxException {
        sendKeys(reference, referenceText );
    }

    public void confirmReference(String reference) throws IOException, URISyntaxException {

        System.out.println("- Confirming reference");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String text = (String) js.executeScript("return arguments[0].textContent;", referenceText);
        System.out.println("- Report Name: " + referenceText  );

        Assert.assertTrue(text.contains(reference));
    }

    public void enterInvalidInspectionDate (String invalidInspectionDate) throws IOException, URISyntaxException {
        sendKeys(reportDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDate, invalidInspectionDate);
    }

    public void confirmInvalidInspectionDate () throws IOException, URISyntaxException {
        Assert.assertTrue(reportDateInvalid.isDisplayed(), "Expected report date field to be visible.");
    }

    public void enterInvalidDueDate (String invalidDueDate) throws IOException, URISyntaxException {
        sendKeys(reportDueDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDueDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDueDate, invalidDueDate);
    }

    public void confirmInvalidDueDate () throws IOException, URISyntaxException {
        Assert.assertTrue(dueDateInvalid.isDisplayed(), "Expected report date field to be visible.");
    }

    public void saveReport () throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(saveReport);
    }



/////////////////////////////////Create Report in One Step/////////////////////////////////////


    public void createReport (String dataCap, String nameOfReport, String referenceText, String inspectionDate, String dueDate, String notesText)
            throws IOException, URISyntaxException, InterruptedException {


        /////////////////////////Select Create Report Button////////////////////////////
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            waitForWebElementAndClickElement(createReport);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select 'Create Report' button");
        }

        /////////////////////////Select Datacapture////////////////////////////
            System.out.println("- Selecting Datacapture");
        try {
            waitForWebElementAndClickElement(dataCapture);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-name")));
            WebElement selectDatacapture = getDriver().findElement(By.xpath("//mat-option//span[contains(text(), '" + dataCap+ "')]"));
            selectDatacapture.click();

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select datacapture");
        }

        /////////////////////////Enter Report Name////////////////////////////
        nameOfReport = (nameOfReport + " (" + globalVariables.releaseVersion + ")");
        sendKeys(reportName, nameOfReport);

        /////////////////////////Enter Reference////////////////////////////
        String fullReferenceText = (referenceText + " (" + globalVariables.releaseVersion + ")");
        sendKeys(reference, fullReferenceText);

        /////////////////////////Select Inspection Date////////////////////////////
        String processedReportDate = globalFunctions.reportDateGenerator(inspectionDate);
        sendKeys(reportDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDate, processedReportDate);


        /////////////////////////////Select Due Date///////////////////////////////
        dueDate = globalFunctions.reportDateGenerator(dueDate);
        sendKeys(reportDueDate, dueDate);

        /////////////////////////Add Notes////////////////////////////
        sendKeys(extraNotes, notesText);

        /////////////////////////Create Report////////////////////////////
        System.out.println("- Selecting 'Create' button");
        waitForWebElementAndClickElement(saveReport);

    }


//////////////////////////Create Report with project and/or client in One Step//////////////////

    public void createFullReport (String dataCap, String isProjectRequired, String projectName, String isClientRequired, String clientName, String nameOfReport, String referenceText, String inspectionDate, String dueDate, String notesText)
            throws IOException, URISyntaxException, InterruptedException {


        /////////////////////////Select Create Report Button////////////////////////////
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            waitForWebElementAndClickElement(createReport);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select 'Create Report' button");
        }

        /////////////////////////Select Datacapture////////////////////////////
        System.out.println("- Selecting Datacapture");
        try {
            waitForWebElementAndClickElement(dataCapture);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-name")));
            WebElement selectDatacapture = getDriver().findElement(By.xpath("//mat-option//span[contains(text(), '" + dataCap+ "')]"));
            selectDatacapture.click();

        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select datacapture");
        }

        /////////////////////////Select Project////////////////////////////

        if (isProjectRequired.equalsIgnoreCase("true")) {
            System.out.println("- Project required, selecting Project '" + projectName + "'");

            try {
                waitForWebElementAndClickElement(project);

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-name")));

                WebElement selectProject = getDriver().findElement(By.xpath("//mat-option//span[contains(text(), '" + projectName + "')]"));
                selectProject.click();

            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }

        } else {
           System.out.println("- Project not required, Skipping Project Selection.");
        }

        /////////////////////////Select Client////////////////////////////
        if (isClientRequired.equalsIgnoreCase("true")) {
            System.out.println("- Client required, selecting Client '" + clientName + "'");

            try {
                waitForWebElementAndClickElement(client);

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("client-name")));
                WebElement selectClient = getDriver().findElement(By.xpath("//mat-option//span[contains(text(), '" + clientName + "')]"));
                selectClient.click();

            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("- Client not required, Skipping Client Selection.");
        }


        /////////////////////////Enter Report Name////////////////////////////
        nameOfReport = (nameOfReport + " (" + globalVariables.releaseVersion + ")");
        sendKeys(reportName, nameOfReport);

        /////////////////////////Enter Reference////////////////////////////
        String fullReferenceText = (referenceText + " (" + globalVariables.releaseVersion + ")");
        sendKeys(reference, fullReferenceText);

        /////////////////////////Select Inspection Date////////////////////////////


        String processedReportDate = globalFunctions.reportDateGenerator(inspectionDate);
        sendKeys(reportDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDate, processedReportDate);


        /////////////////////////////Select Due Date///////////////////////////////

        dueDate = globalFunctions.reportDateGenerator(dueDate);
        sendKeys(reportDueDate, dueDate);

        /////////////////////////Add Notes////////////////////////////
        sendKeys(extraNotes, notesText);


        /////////////////////////Create Report////////////////////////////

        System.out.println("- Selecting 'Create' button");

        waitForWebElementAndClickElement(saveReport);

    }
}
