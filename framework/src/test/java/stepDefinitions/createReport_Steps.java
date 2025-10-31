package stepDefinitions;

import functions.globalFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.CreateReport_PO;
import java.io.IOException;
import java.net.URISyntaxException;
import static utils.globalVariables.releaseVersion;


public class createReport_Steps extends Base_PO {

    Homepage_PO homepage_po;
    CreateReport_PO createReport_po;

    public createReport_Steps() throws IOException, URISyntaxException {
        //System.out.println("CreateReport_Steps constructor called");

        createReport_po = new CreateReport_PO();
        createReport_po.initElements();  //  Initialize elements AFTER driver is ready

        homepage_po = new Homepage_PO();
        homepage_po.initElements();  //  Same here
    }

    @And("I select the Create Report button")
    public void i_select_the_create_report_button() throws IOException, URISyntaxException {
        System.out.println("Creating Report");
        createReport_po.selectCreateReport();
    }

    @Given("I Create a Report {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_create_a_report(String dataCap, String reportName, String referenceText, String reportDate, String dueDate, String notesText) throws IOException, URISyntaxException, InterruptedException {
        createReport_po.createReport(dataCap, reportName, referenceText, reportDate, dueDate, notesText);
        System.out.println("Creating Report");
    }

    @And("I select a Data Capture {string}")
    public void i_select_a_data_capture(String string) throws IOException, URISyntaxException {
        createReport_po.selectDataCapture(string);
        System.out.println("Selecting DataCapture: " + string);
    }
    @And("I enter a report name {string}")
    public void i_select_a_name(String reportName) throws IOException, URISyntaxException {
        String replacedName = reportName.replace("<ReleaseVersion>", releaseVersion);
        //System.out.println("Report Name after replacement: " + replacedName);

        createReport_po.enterReportName(replacedName);

        System.out.println("Entering a report name: " + replacedName);
    }

    @And("I enter a Name {string}")
    public void i_enter_a_name(String item) throws IOException, URISyntaxException {
        String replacedName = (item + " <" + releaseVersion + ">");
        createReport_po.enterReportName(replacedName);

        System.out.println("Entering a report name: " + replacedName);
    }


    @And("I enter a reference {string}")
    public void i_enter_a_reference(String reference) throws IOException, URISyntaxException {
        String replacedRef = reference.replace("<ReleaseVersion>", releaseVersion);
        System.out.println("Report Name after replacement: " + replacedRef);

        createReport_po.enterReference(replacedRef);
        System.out.println("Entering a reference: " + replacedRef);
    }

    @And("I select an inspection date {string}")
    public void i_select_an_inspection_date(String inspectionDate) throws IOException, URISyntaxException, InterruptedException {
        String processedReportDate = globalFunctions.reportDateGenerator(inspectionDate);
        sendKeys(createReport_po.reportDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(createReport_po.reportDate, (Keys.chord(Keys.BACK_SPACE)));
        sendKeys(createReport_po.reportDate, processedReportDate);
    }

    @And("I select the report name")
    public void i_select_the_report_name() throws IOException, URISyntaxException, InterruptedException {
       waitForWebElementAndClickElement(createReport_po.reportName);
       System.out.println("Selecting a report");
    }

    @And("I select a due date {string}")
    public void i_select_a_due_date(String dueDate) throws IOException, URISyntaxException, InterruptedException {
        //LocalDate today = LocalDate.now();
        //LocalDate twoWeeksLater = today.plusWeeks(2);
        //String dayOfMonth = String.valueOf(twoWeeksLater.getDayOfMonth());

        System.out.println("Selecting the due date");
        sendKeys(createReport_po.reportDueDate, (Keys.chord(Keys.CONTROL, "a")));
        sendKeys(createReport_po.reportDueDate, (Keys.chord(Keys.BACK_SPACE)));
        dueDate = globalFunctions.reportDateGenerator(dueDate);
        sendKeys(createReport_po.reportDueDate, dueDate);
    }


    @And("I select Create")
    public void i_select_create() throws IOException, URISyntaxException {
        System.out.println("Creating report");
        waitForWebElementAndClickElement(createReport_po.saveReport);
    }

}
