package page.pages;

import driver.Driver;
import driver.NameOfElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

/**
 * Created by KIRILL on 24.01.2017.
 */
public class AuthenticationPage extends AbstractPage {

    private final Logger iLogger = Logger.getLogger(AuthenticationPage.class);
    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";


    @NameOfElement("HEADER")
    @FindBy(xpath = "//*[@id='center_column']/h1")
    public WebElement header;

    @NameOfElement("Email address")
    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement emailAddreesField;

    public void loadPage() {
        Driver.getWebDriver().get(URL);
        Assert.assertTrue(header.isDisplayed());
    }

    public void setValueToField(String fieldName, String value) {
        WebElement element = get(fieldName);
        Assert.assertTrue("WebElement isn't displayed!", Driver.isDisplayed(element));
        element.sendKeys(value);

    }

    public void pressButton(String buttonName) {
        WebElement button = get(buttonName);
        Assert.assertTrue("WebElement isn't displayed!", Driver.isDisplayed(button));
        button.click();
        iLogger.info("Button " + buttonName + "was pressed!");
    }
}
