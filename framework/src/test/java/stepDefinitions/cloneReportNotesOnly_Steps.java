package stepDefinitions;

import io.cucumber.java.en.Given;
import pageObjects.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class cloneReportNotesOnly_Steps extends Base_PO {

    CloneReport_PO cloneReport_po;
    TestAllControlsRM_PO testAllControlsRM_po;
    Homepage_PO homepage_po;



 public cloneReportNotesOnly_Steps() throws IOException, URISyntaxException {

     homepage_po = new Homepage_PO();
     homepage_po.initElements();

     cloneReport_po = new CloneReport_PO();
     cloneReport_po.initElements();

    }

    @Given("I clone a report {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_clone_a_report(String targetReport, String nameOfReport, String referenceText,
                                 String inspectionDateReq, String inspectionDate, String dueDateReq, String dueDate, String notesText, String addNotes, String addPhotos) throws IOException, URISyntaxException, InterruptedException
    {
        cloneReport_po.cloneReport(targetReport, nameOfReport, referenceText, inspectionDateReq, inspectionDate, dueDateReq, dueDate, notesText, addNotes, addPhotos);
    }


}
