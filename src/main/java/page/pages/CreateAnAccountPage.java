package page.pages;


import driver.Driver;
import driver.NameOfElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class CreateAnAccountPage extends AbstractPage
{
    private static final String URL = "http://automationpractice.com/index.php?controller=contact";

    @NameOfElement("HEADER")
    @FindBy(css = ".spinner-container")
    WebElement header;

    @NameOfElement("КУПИТЬ")
    @FindBy(xpath = ".//button[.='КУПИТЬ']")
    WebElement btnBuy;


    public void load() {
        Driver.getWebDriver().get(URL);
        Assert.assertTrue(header.isDisplayed());
    }
}
