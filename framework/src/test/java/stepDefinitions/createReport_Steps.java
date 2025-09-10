package stepDefinitions;

import functions.globalFunctions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.CreateReport_PO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

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


    @And("I enter a Reference {string}")
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

        /*String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
        System.out.println("Setting inspection date as today");
        System.out.println("Setting date: " + date );
        createReport_po.selectInspectionDate(date);*/
    }

    @And("I select the report name")
    public void i_select_the_report_name() throws IOException, URISyntaxException, InterruptedException {
       waitForWebElementAndClick(createReport_po.reportName);
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
        //createReport_po.selectDueDate(dueDate);
    }

    @And("I add some notes {string}")
    public void i_add_some_notes(String string) throws IOException, URISyntaxException {
        System.out.println("Adding extra notes: '" + string + "'");
        waitForWebElement(createReport_po.extraNotes);
        createReport_po.enterNotes(string);
    }

    @And("I select Create")
    public void i_select_create() throws IOException, URISyntaxException {
        System.out.println("Creating report");
        waitForWebElementAndClick(createReport_po.saveReport);
    }

}
