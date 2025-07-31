package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Homepage_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class loginPageContactUs_Steps extends Base_PO {

    Login_PO login_po;

   private @FindBy(xpath = "//main[@id='main']//h1[normalize-space(text())='Speak to our Team?']") WebElement speakToUsConf;

    public loginPageContactUs_Steps() throws IOException, URISyntaxException {
        //System.out.println("ContactUs_Steps constructor called");

        login_po = new Login_PO();
        login_po.initElements();
    }


    @When("I select the contact-us page")
    public void i_select_the_contact_us_page() throws IOException, URISyntaxException {
        System.out.println("Selecting 'Contact-us' link");

        WebElement contactUsLink = getDriver().findElement(By.xpath("//a[text()=' Talk to us ']"));
        contactUsLink.click();


        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main']//h1[normalize-space(text())='Speak to our Team?']")));


        WebElement heading = (WebElement) getDriver().findElement(By.xpath("//main[@id='main']//h1[normalize-space(text())='Speak to our Team?']"));
        Assert.assertTrue(heading.isDisplayed(), "Expected heading is not displayed");


    }

    @Then("I am taken to the contact-us page")
    public void i_am_taken_to_the_contact_us_page() throws IOException, URISyntaxException {
        System.out.println("Confirming navigated to 'Contact-us' page");
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    speakToUsConf = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//main[@id='main']//h1[normalize-space(text())='Speak to our Team?']")
    ));


        Assert.assertEquals(speakToUsConf.getText(), "Speak to our Team?");


    }

}
