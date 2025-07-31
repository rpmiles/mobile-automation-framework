package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Base_PO;
import pageObjects.NotesControl_PO;
import pageObjects.SharedStepsFieldNav_PO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class sharedStepsConfirmNotes_Steps extends Base_PO {

    NotesControl_PO notesControl_po;
    SharedStepsFieldNav_PO sharedStepsFieldNav_po;

    private String boldText = "This is bold text";
    private String italicsText = "This is italicised text";
    private String underlineText = "This is underlined text";
    private String strikethroughText = "This is strikethrough text";
    private String bullet1Text = "Bullet list entry 1";
    private String bullet2Text = "Bullet list entry 2";
    private String bullet3Text = "Bullet list entry 3";
    private String numlist1Text = "Number list entry 1";
    private String numlist2Text = "Number list entry 2";
    private String numlist3Text = "Number list entry 3";


    public sharedStepsConfirmNotes_Steps() throws IOException, URISyntaxException {
        //System.out.println("SharedStepsConfirmNotes constructor called");

        notesControl_po = new NotesControl_PO();
        notesControl_po.initElements();

        sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
        sharedStepsFieldNav_po.initElements();

    }

    @And("I confirm notes are working correctly")
    public void confirmNotes() throws IOException, URISyntaxException {
        notesControl_po.selectNotes();

        // Add bold text
        notesControl_po.selectBold();
        notesControl_po.enterNotes(boldText);

        // Add italicised text
        notesControl_po.selectItalics();
        notesControl_po.enterNotes(italicsText);

        //Add underlined text
        notesControl_po.selectUnderline();
        notesControl_po.enterNotes(underlineText);

        //Add strikethrough text
        notesControl_po.selectStrikethrough();
        notesControl_po.enterNotes(strikethroughText);
        notesControl_po.selectEnter();

        // Enter a bullet list
        notesControl_po.selectBulletList();
        notesControl_po.enterNotes(bullet1Text);
        notesControl_po.enterNotes(bullet2Text);
        notesControl_po.enterNotes(bullet3Text);
        notesControl_po.selectEnter();
        notesControl_po.selectEnter();

        // Enter a number list
        notesControl_po.selectNumList();
        notesControl_po.enterNotes(numlist1Text);
        notesControl_po.enterNotes(numlist2Text);
        notesControl_po.enterNotes(numlist3Text);
        notesControl_po.selectEnter();
        notesControl_po.selectBackspace();

        sharedStepsFieldNav_po.selectDone();
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    }

    @And("I confirm the notes have saved")
    public void confirmNotesSaved() throws IOException, URISyntaxException {
        notesControl_po.selectNotes();

        // Confirm formatting
        notesControl_po.confirmFormatting();

        // Return to report field
        sharedStepsFieldNav_po.selectDone();

    }
}
