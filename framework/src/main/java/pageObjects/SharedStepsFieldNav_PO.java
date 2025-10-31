package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.net.URISyntaxException;


public class SharedStepsFieldNav_PO extends Base_PO {

    public @FindBy(xpath = "//button[contains(@data-cy, 'back-to-editor-items-header-button')]") WebElement doneTick;

    public SharedStepsFieldNav_PO() throws IOException, URISyntaxException {
        super();
        //System.out.println("Homepage_PO constructor called");
        PageFactory.initElements(getDriver(), this);
        //System.out.println("Homepage_PO elements initialised");

    }

    public WebElement nextItem () throws IOException, URISyntaxException {
        System.out.println("Navigate to next item");
        return getDriver().findElement(By.xpath("//button[contains(@data-cy, 'next-item-button')]"));
    }

    public WebElement previousItem () throws IOException, URISyntaxException {
            System.out.println("Navigate to previous");
        return getDriver().findElement(By.xpath("//button[contains(@data-cy, 'previous-item-button')]"));
    }

    public void selectDone () throws IOException, URISyntaxException {
        System.out.println("Selecting Tick icon");
        System.out.println("Returning to report");
        waitForWebElementAndClickElement(doneTick);

    }

}


