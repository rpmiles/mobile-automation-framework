package stepDefinitions;

import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.net.URISyntaxException;


public class testAllControlsRMTablesCreate_Steps extends Base_PO {

    TestAllControlsRM_PO testAllControlsRM_po;
    globalFunctions globalFunctions;

    public testAllControlsRMTablesCreate_Steps() throws IOException, URISyntaxException {
        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();

        globalFunctions = new globalFunctions();
        globalFunctions.initElements();
    }


    @And("I select Add to add a row")
    public void i_select_Add_to_add_a_row() throws IOException, URISyntaxException {
        waitForAngularWebElement(testAllControlsRM_po.addRow);
        waitForWebElementAndClickElement(testAllControlsRM_po.addRow);
    }



    @And("I select the table field option {string}")
    public void neither_this_or_that_is_highlighted(String option) throws IOException, URISyntaxException, InterruptedException {
        globalFunctions.scrollAndSelectTableFieldValue(option);
}

    @And("I close the row editor")
    public void i_close_the_row_editor() throws IOException, URISyntaxException {
        testAllControlsRM_po.closeRow();
    }

    @And("I bulk edit the rows")
    public void i_bulk_edit_the_rows() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.bulkEditRows();
    }

    @And("I confirm the bulk edit")
    public void i_confirm_the_bulk_edit() throws IOException, URISyntaxException, InterruptedException {
        waitForWebElementAndClickElement(testAllControlsRM_po.confirmButton);
    }

    @And("I close the table")
    public void i_close_the_table() throws IOException, URISyntaxException {
        testAllControlsRM_po.closeRow();
    }

    @And("I select the checkbox for row {int}")
    public void i_select_the_checkbox(int row) throws IOException, URISyntaxException {
        globalFunctions.scrollAndSelectRowCheckbox(row);
    }

    @And("I clone the table rows")
    public void i_clone_the_rows() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.cloneRows();
    }

    @And("I filter the table to show {string}")
    public void i_filter_the_table_to_show_all_entries(String filter) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.filterBy(filter);
    }

    @And("I delete the row")
    public void i_delete_the_row() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.deleteRow();
    }

    @And("I scroll to the next field")
    public void i_scroll_to_next_field() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.scrollToNext();
    }

    @And("I scroll to the previous field")
    public void i_scroll_to_prev_field() throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.scrollToPrev();
    }

    @And("I select the {string} field in row {int}")
    public void i_select_the_field_in_row(String field, int row) throws IOException, URISyntaxException, InterruptedException {
        testAllControlsRM_po.selectTableEntry(field, row);
    }
    
}

/*

@And("")
public void () throws IOException, URISyntaxException {

}

*/







