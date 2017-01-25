package page.pages;


import driver.NameOfElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class PreAuthorithationPage extends AbstractPage
{

    @NameOfElement("lastName")
    @FindBy(xpath = ".//input[@name='lastName']")
    WebElement lastName;

    @NameOfElement("firstName")
    @FindBy(xpath = ".//input[@name='firstName']")
    WebElement firstName;

    @NameOfElement("Принимаю")
    @FindBy(xpath = ".//*[contains(text(),'Принимаю')]")
    WebElement accept;

    @NameOfElement("Оформить")
    @FindBy(xpath = ".//*[@value='Оформить']")
    WebElement content;

    @NameOfElement("Оплатить")
    @FindBy(xpath = ".//button[.='Оплатить']")
    WebElement pay;

}
