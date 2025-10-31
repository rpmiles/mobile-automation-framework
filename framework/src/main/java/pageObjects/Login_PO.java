package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.net.URISyntaxException;


import static utils.globalVariables.adminPsw;
import static utils.globalVariables.adminUser;

public class Login_PO extends Base_PO {

    public @FindBy(id = "email") WebElement userName;
    public @FindBy(id = "password") WebElement password;
    public @FindBy(xpath = "//*[text()='Got it!']") WebElement cookieDialog;
    private @FindBy(id = "sign-in") WebElement signInButton;
    private @FindBy(id = "mat-mdc-error-1") WebElement emailReq;
    private @FindBy(xpath = "//div[text()=' Wrong email or password ']") WebElement wrongUserPsw;


    public Login_PO() throws IOException, URISyntaxException{
        super();
    }

    public void navigateTo_Mobile_Portal() throws IOException, URISyntaxException {
        navigateTo_URL("https://mobile.test-goreport.services"); // Make sure this line exists

    }

    public void setUserName() throws IOException, URISyntaxException {
        sendKeys(userName, adminUser);
    }

    public void setPassword () throws IOException, URISyntaxException {
        sendKeys(password, adminPsw);
    }

    public void dismissCookieMessage () throws IOException, URISyntaxException {
        waitForWebElementAndClickElement(cookieDialog);
    }

    public void clickSignIn () throws IOException, URISyntaxException, InterruptedException {
        Thread.sleep(2000);
        waitForWebElementAndClickElement(signInButton);
    }

}
