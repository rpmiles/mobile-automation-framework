package stepDefinitions;

import functions.confirmationFunctions;
import functions.confirmationFunctionsConfirmUpload;
import functions.globalFunctions;
import io.cucumber.java.en.And;
import pageObjects.Base_PO;
import pageObjects.SharedStepsFieldNav_PO;
import pageObjects.TestAllControlsRM_PO;

import java.io.IOException;
import java.net.URISyntaxException;

public class sharedStepsConfirmNotes_Steps extends Base_PO {

    private TestAllControlsRM_PO testAllControlsRM_po;
    private SharedStepsFieldNav_PO sharedStepsFieldNav_po;
    private confirmationFunctions confirmationFunctions;

    private String normalText = "This is normal text";
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

        sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
        sharedStepsFieldNav_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();

    }

    public void confirmNotesSteps() throws IOException, URISyntaxException {
        sharedStepsFieldNav_po = new SharedStepsFieldNav_PO();
        sharedStepsFieldNav_po.initElements();

        confirmationFunctions = new confirmationFunctions();
        confirmationFunctions.initElements();

        testAllControlsRM_po = new TestAllControlsRM_PO();
        testAllControlsRM_po.initElements();    // now valid
    }

    @And("I confirm notes are working correctly")
    public void confirmNotes() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectNotes();
        // Add normal text
        testAllControlsRM_po.enterNotes(normalText);

        // Add bold text
        testAllControlsRM_po.selectBold();
        testAllControlsRM_po.enterNotes(boldText);

        // Add italicised text
        testAllControlsRM_po.selectItalics();
        testAllControlsRM_po.enterNotes(italicsText);

        //Add underlined text
        testAllControlsRM_po.selectUnderline();
        testAllControlsRM_po.enterNotes(underlineText);

        //Add strikethrough text
        testAllControlsRM_po.selectStrikethrough();
        testAllControlsRM_po.enterNotes(strikethroughText);
        testAllControlsRM_po.selectEnter();

        // Enter a bullet list
        testAllControlsRM_po.selectBulletList();
        testAllControlsRM_po.enterNotes(bullet1Text);
        testAllControlsRM_po.enterNotes(bullet2Text);
        testAllControlsRM_po.enterNotes(bullet3Text);
        testAllControlsRM_po.selectEnter();
        testAllControlsRM_po.selectEnter();

        // Enter a number list
        testAllControlsRM_po.selectNumList();
        testAllControlsRM_po.enterNotes(numlist1Text);
        testAllControlsRM_po.enterNotes(numlist2Text);
        testAllControlsRM_po.enterNotes(numlist3Text);
        testAllControlsRM_po.selectEnter();
        testAllControlsRM_po.selectBackspace();

        sharedStepsFieldNav_po.selectDone();

    }

    @And("I confirm the notes have saved")
    public void confirmNotesSaved() throws IOException, URISyntaxException {
        testAllControlsRM_po.selectNotes();

        // Confirm formatting
        System.out.println("Confirming notes formatting");
        confirmationFunctions.confirmNotesFormatting();


        // Return to report field
        System.out.println("Confirming navigation");
        sharedStepsFieldNav_po.selectDone();

    }
}
