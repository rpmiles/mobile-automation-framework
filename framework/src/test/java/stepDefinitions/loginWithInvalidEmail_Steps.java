package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import static utils.globalVariables.adminPsw;
import static utils.globalVariables.adminUser;

public class loginWithInvalidEmail_Steps extends Base_PO {

    Login_PO login_po;

    private @FindBy(xpath = "//div[text()='Wrong email or password']") WebElement wrongUserPsw;

    public loginWithInvalidEmail_Steps() throws IOException, URISyntaxException {
        //System.out.println("LoginPage constructor called");

        login_po = new Login_PO();
        login_po.initElements();  //  Initialize elements AFTER driver is ready

    }

    @Given("I enter an email without an account as the username")
    public void i_enter_an_email_without_an_account_as_the_username() throws IOException, URISyntaxException {
        sendKeys(login_po.userName, "any@email.com");
    }

    @Then("an error message is displayed saying unable to login")
    public void an_error_message_is_displayed_saying_unable_to_login() throws IOException, URISyntaxException {

        By errorLocator = By.xpath("//div[contains(normalize-space(.), 'Wrong email or password')]");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator));

        WebElement errorElement = getDriver().findElement(errorLocator);
        String actualText = errorElement.getText().trim();

        System.out.println("Error text: " + actualText);
        Assert.assertTrue(actualText.contains("Wrong email or password"), "Expected error not displayed!");
        System.out.println("'Wrong email or password' displayed");

    }


}
