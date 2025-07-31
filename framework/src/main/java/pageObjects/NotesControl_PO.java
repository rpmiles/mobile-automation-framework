package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class NotesControl_PO extends Base_PO{

    public @FindBy(xpath = "//span[contains(@class, 'note-icon text-on-primary')]") WebElement notesButton;
    public @FindBy(xpath = "//div[contains(@class, 'ql-editor')]") WebElement notesText;
    public @FindBy(className = "ql-bold") WebElement bold;
    public @FindBy(className = "ql-italic") WebElement italics;
    public @FindBy(className = "ql-underline") WebElement underline;
    public @FindBy(className = "ql-strike") WebElement strikethrough;
    public @FindBy(xpath = "//button[value='ordered']") WebElement numList;
    public @FindBy(xpath = "//button[value='bullet']") WebElement bulletList;

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



    public NotesControl_PO() throws IOException, URISyntaxException {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    public void selectNotes() throws IOException, URISyntaxException {
        System.out.println("Selecting Notes");
        waitForWebElementAndClick(notesButton);
    }

    public void enterNotes(String notesTextToEnter) throws IOException, URISyntaxException {
        try {
            System.out.println("Entering Notes: '" + notesTextToEnter + "'");
            waitForWebElementToBeVisible(notesText);
            sendKeys(notesText, notesTextToEnter);
            sendKeys(notesText, String.valueOf(Keys.ENTER));
            } catch (NoSuchElementException e) {
                Assert.fail("Unable to enter notes");
                }
    }

    public void selectEnter() throws IOException, URISyntaxException {
        sendKeys(notesText, String.valueOf(Keys.ENTER));

    }

    public void selectBackspace() throws IOException, URISyntaxException {
        sendKeys(notesText, String.valueOf(Keys.BACK_SPACE));

    }

    public void selectBold() throws IOException, URISyntaxException {
        System.out.println("Selecting bold");
        waitForWebElementAndClick(bold);
    }

    public void selectItalics() throws IOException, URISyntaxException {
        System.out.println("Selecting italics");
        waitForWebElementAndClick(italics);
    }

    public void selectUnderline() throws IOException, URISyntaxException {
        System.out.println("Selecting underlined");
        waitForWebElementAndClick(underline);
    }

    public void selectStrikethrough() throws IOException, URISyntaxException {
        System.out.println("Selecting strikethrough");
        waitForWebElementAndClick(strikethrough);
    }

    public void selectBulletList() throws IOException, URISyntaxException {
        try {WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='bullet']")));
            System.out.println("Selecting bullet list");
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select bullet list");
            }

    }

    public void selectNumList() throws IOException, URISyntaxException {
        try {WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='ordered']")));
            System.out.println("Selecting number list");
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to select number list");
            }
    }

    public void confirmFormattingNoLists() throws IOException, URISyntaxException {
        try {
            System.out.println("Confirming formatting");

            // Confirm bold text
            WebElement boldElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + boldText + "')]"));
            Assert.assertTrue(boldElement.isDisplayed());
            System.out.println("Bold text is formatted in bold");
            //System.out.println(boldText);


            // Confirm italicised text
            WebElement italicsElement = getDriver().findElement(By.xpath("//em[contains(text(),'" + italicsText + "')]"));
            Assert.assertTrue(italicsElement.isDisplayed());
            System.out.println("Italics text is formatted in italics");
            //System.out.println(italicsText);

            // Confirm underlined text
            WebElement underlineElement = getDriver().findElement(By.xpath("//u[contains(text(),'" + underlineText + "')]"));
            Assert.assertTrue(underlineElement.isDisplayed());
            System.out.println("Underlined text is underlined");
            //System.out.println(underlineText);

            // Confirm strikethrough text
            WebElement strikethroughElement = getDriver().findElement(By.xpath("//s[contains(text(),'" + strikethroughText + "')]"));
            Assert.assertTrue(strikethroughElement.isDisplayed());
            System.out.println("Strikethrough text is struck through");
            //System.out.println(strikethroughText);



        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm text formatting");
        }

    }

    public void confirmFormatting() throws IOException, URISyntaxException {
        try {
        System.out.println("Confirming formatting");

        // Confirm bold text
        WebElement boldElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + boldText + "')]"));
        Assert.assertTrue(boldElement.isDisplayed());
        System.out.println("Bold text is formatted in bold");
        //System.out.println(boldText);


        // Confirm italicised text
        WebElement italicsElement = getDriver().findElement(By.xpath("//em[contains(text(),'" + italicsText + "')]"));
        Assert.assertTrue(italicsElement.isDisplayed());
        System.out.println("Italics text is formatted in italics");
        //System.out.println(italicsText);

        // Confirm underlined text
        WebElement underlineElement = getDriver().findElement(By.xpath("//u[contains(text(),'" + underlineText + "')]"));
        Assert.assertTrue(underlineElement.isDisplayed());
        System.out.println("Underlined text is underlined");
        //System.out.println(underlineText);

        // Confirm strikethrough text
        WebElement strikethroughElement = getDriver().findElement(By.xpath("//s[contains(text(),'" + strikethroughText + "')]"));
        Assert.assertTrue(strikethroughElement.isDisplayed());
        System.out.println("Strikethrough text is struck through");
        //System.out.println(strikethroughText);


        // Confirm bullet list entries
        WebElement bulletItem = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bullet1Text + "')]"));
        Assert.assertTrue(bulletItem.isDisplayed());
        System.out.println("Bullet list entry 1 is correctly formatted");
        //System.out.println(bullet1Text);


        WebElement bulletItem2 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bullet2Text + "')]"));
        Assert.assertTrue(bulletItem2.isDisplayed());
        System.out.println("Bullet list entry 2 is correctly formatted");
        //System.out.println(bullet2Text);

        WebElement bulletItem3 = getDriver().findElement(By.xpath("//li[@data-list='bullet' and contains(text(),'" + bullet3Text + "')]"));
        Assert.assertTrue(bulletItem3.isDisplayed());
        System.out.println("Bullet list entry 3 is correctly formatted");
        //System.out.println(bullet3Text);

        // Confirm number list entries
        WebElement numberItem = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist1Text + "')]"));
        Assert.assertTrue(numberItem.isDisplayed());
        System.out.println("Number list entry 1 is correctly formatted");
        //System.out.println(numlist1Text);


        WebElement numberItem2 = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist2Text + "')]"));
        Assert.assertTrue(numberItem2.isDisplayed());
        System.out.println("Number list entry 2 is correctly formatted");
        //System.out.println(numlist2Text);

        WebElement numberItem3 = getDriver().findElement(By.xpath("//li[@data-list='ordered' and contains(text(),'" + numlist3Text + "')]"));
        Assert.assertTrue(numberItem3.isDisplayed());
        System.out.println("Number list entry 3 is correctly formatted");
        //System.out.println(numlist3Text);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to confirm text formatting");
        }

    }

}


