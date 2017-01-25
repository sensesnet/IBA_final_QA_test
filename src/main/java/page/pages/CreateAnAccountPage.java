package page.pages;


import driver.NameOfElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class CreateAnAccountPage extends AbstractPage
{

    @NameOfElement("Spinner")
    @FindBy(css = ".spinner-container")
    WebElement spinner;

    @NameOfElement("КУПИТЬ")
    @FindBy(xpath = ".//button[.='КУПИТЬ']")
    WebElement btnBuy;


}
