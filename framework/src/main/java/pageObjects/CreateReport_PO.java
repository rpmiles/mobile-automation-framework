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
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement createReportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class, 'mdc-button__label') and contains(normalize-space(.), 'Create Report')]")
        ));
        String buttonText = createReportButton.getText();
        //System.out.println(buttonText);
            System.out.println("Selecting 'Create Report' button");
        waitForWebElementAndClickElement(createReport);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select 'Create Report' button");
        }
    }

    public void selectDataCapture(String dataCap) throws IOException, URISyntaxException {
        try {waitForWebElementAndClickElement(dataCapture);

        List<WebElement> datacaptures = getDriver().findElements(By.cssSelector("#template-name-panel mat-option"));
        //System.out.println("Number of items: " + datacaptures.size());
        int count = 0;
        for (WebElement item : datacaptures) {
            String datacaptureName = item.getText();
            if (datacaptureName.contains(dataCap)) {
                //System.out.println(count);
                //System.out.println("Located Report!");
                datacaptures.get(count).click();

                break;
            }
            count++;
        }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select datacapture");
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

        System.out.println("Confirming report name");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String text = (String) js.executeScript("return arguments[0].textContent;", reportNameText);
        System.out.println("Report Name: " + text  );

        Assert.assertTrue(text.contains(nameOfReport));
    }

    public void selectReportName() throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(reportName);
    }

    public void confirmReference(String reference) throws IOException, URISyntaxException {

        System.out.println("Confirming reference");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String text = (String) js.executeScript("return arguments[0].textContent;", referenceText);
        System.out.println("Report Name: " + referenceText  );

        Assert.assertTrue(text.contains(reference));
    }

    public void deleteReference() throws IOException, URISyntaxException {
        sendKeys(reference,  (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reference, (Keys.chord(Keys.BACK_SPACE)));
    }

    public void enterReference (String referenceText) throws IOException, URISyntaxException {
        sendKeys(reference, referenceText );
    }

    public void selectInspectionDate (String date) throws IOException, URISyntaxException, InterruptedException {
        try {
        //Thread.sleep(2000);

        List<WebElement> buttons = getDriver().findElements(By.tagName("button"));
        int count = 0;

        //System.out.println("Total buttons found: " + buttons.size());

        for (WebElement calenderPicker : buttons) {
            //System.out.println("Is the " + calenderPicker.getText() + " button displayed? =  " + calenderPicker.isDisplayed());
            String label = calenderPicker.getAttribute("aria-label");
            if (label != null && label.contains("Open calendar")) {
                System.out.println("Selecting inspection date picker");
                calenderPicker.click();
                break;
            }
            count++;
        }

        List<WebElement> buttonsInMyTable = getDriver().findElements(By.xpath("//table[contains(@class, 'mat-calendar-table')]//button"));
        //System.out.println("Entering inspection day loop");
        for (WebElement datePicker : buttonsInMyTable) {
            String label = datePicker.getText();
            String actualDate = String.valueOf(Integer.parseInt(date)); // result = "2"
            if (label.contains(actualDate)) {
                System.out.println("Selecting inspection date day " + label);
                datePicker.click();
                //System.out.println("Exiting inspection day loop");
                break;
            }
            count++;
        }
        // Actions actions = new Actions(getDriver());
        // actions.sendKeys(Keys.ESCAPE).perform();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select inspection date");
            }
    }

    public void enterInvalidInspectionDate (String invalidInspectionDate) throws IOException, URISyntaxException {
        sendKeys(reportDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDate, invalidInspectionDate);
    }

    public void confirmInvalidInspectionDate () throws IOException, URISyntaxException {
        Assert.assertTrue(reportDateInvalid.isDisplayed(), "Expected report date field to be visible.");
    }

    public void selectDueDate (String dueDate) throws IOException, URISyntaxException, InterruptedException {
        try {
        //Thread.sleep(2000);
            LocalDate today = LocalDate.now();
            LocalDate twoWeeksLater = today.plusWeeks(2);
            //String dayOfMonth = String.valueOf(twoWeeksLater.getDayOfMonth());

            System.out.println("Selecting the due date as in two weeks");

        List<WebElement> buttons = getDriver().findElements(By.tagName("button"));
        int matchCount = 0;
        //System.out.println("Opening due date calender");
        for (WebElement button : buttons) {
            String label = button.getAttribute("aria-label");
            //System.out.println("Found button " + label);
            if ("Open calendar".equals(label)) {
                matchCount++;

                if (matchCount == 2) { // second instance
                    System.out.println("Selecting due date calender picker");
                    button.click(); // or perform any action here

                    break;
                }
            }
        }


        List<WebElement> buttonsInMyTable = getDriver().findElements(By.xpath("//table[contains(@class, 'mat-calendar-table')]//button"));
        //System.out.println("Entering due date day loop");

        for (WebElement datePicker : buttonsInMyTable) {
            //System.out.println("Is the " + datePicker.getText() + " button displayed? =  " + datePicker.isDisplayed());
            String label = datePicker.getText();
            if (label.contains(dueDate)) {
                System.out.println("Selecting due date day " + label);
                datePicker.click();
                //System.out.println("Exiting due date day loop");
                break;
            }

        }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select due date");
            }
    }

    public void enterInvalidDueDate (String invalidDueDate) throws IOException, URISyntaxException {
        sendKeys(reportDueDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(reportDueDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(reportDueDate, invalidDueDate);
    }

    public void confirmInvalidDueDate () throws IOException, URISyntaxException {
        Assert.assertTrue(dueDateInvalid.isDisplayed(), "Expected report date field to be visible.");
    }

    public void enterNotes (String notesText) throws IOException, URISyntaxException {
        sendKeys(extraNotes, notesText);
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
            WebElement createReportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class, 'mdc-button__label') and contains(normalize-space(.), 'Create Report')]")
            ));
            String buttonText = createReport.getText();
            //System.out.println(buttonText);
            waitForWebElementAndClickElement(createReport);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select 'Create Report' button");
        }

        /////////////////////////Select Datacapture////////////////////////////
        System.out.println("Selecting Datacapture");
        try {
            waitForWebElementAndClickElement(dataCapture);

            List<WebElement> datacaptures = getDriver().findElements(By.cssSelector("#template-name-panel mat-option"));
            //System.out.println("Number of items: " + datacaptures.size());
            int count = 0;
            for (WebElement item : datacaptures) {
                String datacaptureName = item.getText();
                if (datacaptureName.equals(dataCap)) {
                    //System.out.println(count);
                    //System.out.println("Located Report!");
                    datacaptures.get(count).click();

                    break;
                }
                count++;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select datacapture");
        }

        /////////////////////////Enter Report Name////////////////////////////
        nameOfReport = (nameOfReport + " <" + globalVariables.releaseVersion + ">");
        sendKeys(reportName, nameOfReport);

        /////////////////////////Enter Reference////////////////////////////
        String fullReferenceText = (referenceText + " <" + globalVariables.releaseVersion + ">");
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

        System.out.println("Performing scroll and select to 'Create' button");

        waitForWebElementAndClickElement(saveReport);

    }
}
