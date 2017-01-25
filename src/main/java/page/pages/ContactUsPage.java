package page.pages;

import driver.Driver;
import driver.IDriverConstant;
import driver.NameOfElement;
import entity.ContactUsEntity;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import page.AbstractPage;

import java.util.List;

public class ContactUsPage extends AbstractPage implements IDriverConstant {

    private final Logger iLogger = Logger.getLogger(ContactUsPage.class);

    private static final String URL = "http://automationpractice.com/index.php?controller=contact";

    @NameOfElement("HEADER")
    @FindBy(xpath = "//*[@id='center_column']/h1")
    public WebElement header;

    @NameOfElement("subject_heading")
    @FindBy(xpath = "//select[@id='id_contact']")
    public WebElement subject_headin_input;

    @NameOfElement("email_address")
    @FindBy(xpath = "//*[@id='email']")
    public WebElement email_address_input;

    @NameOfElement("order_reference")
    @FindBy(xpath = "//*[@id='id_order']")
    public WebElement order_reference_input;

    @NameOfElement("message")
    @FindBy(xpath = "//*[@id='message']")
    public WebElement message_input;

    @NameOfElement("Send")
    @FindBy(xpath = "//*[@id='submitMessage']")
    public WebElement sendButton;

    @NameOfElement("Your message has been successfully sent to our team.")
    @FindBy(xpath = "//*[@id='center_column']/p")
    public WebElement positiveMSG;

    @NameOfElement("The message cannot be blank.")
    @FindBy(xpath = "//*[@id='center_column']/div/ol/li")
    public WebElement negativeMSG;

    @NameOfElement("Webmaster")
    @FindBy(xpath = "//*[@id='id_contact']/option[text()='Webmaster']")
    public WebElement webmaster;

    public void loadPage() {
        Driver.getWebDriver().get(URL);
        Assert.assertTrue(header.isDisplayed());
    }

    public void setContactUsFields(List<ContactUsEntity> entities) throws InterruptedException {
        Assert.assertNotNull("No data to be settings!", entities);
        Assert.assertTrue("Data to be settings is empty!", !entities.isEmpty());
        ContactUsEntity entity = entities.get(0);
        iLogger.info("Choose Subject_heading: " + entity.getSubject_heading());
        clickAndSelectedValuetoInput(entity.getSubject_heading(), "subject_heading");
        iLogger.info("Choose Email_address: " + entity.getEmail_address());
        clickAndSetValuetoInput(entity.getEmail_address(), "email_address");
        iLogger.info("Choose Order_reference: " + entity.getEmail_address());
        clickAndSetValuetoInput(entity.getOrder_reference(), "order_reference");
        iLogger.info("Choose Message: " + entity.getMessage());
        clickAndSetValuetoInput(entity.getMessage(), "message");
    }

    private void clickAndSelectedValuetoInput(String inputValue, String inputName) throws InterruptedException {
        WebElement element = get(inputName);
        Select dropdown = new Select(element);
        element.click();
        WebElement value = get(inputValue);
        value.click();
//        dropdown.deselectByVisibleText(inputValue);
        //dropdown.selectByValue("2");
    }

    public void clickAndSetValuetoInput(String inputValue, String inputName) {
        WebElement element = get(inputName);
        element.sendKeys(inputValue);
    }

    public void pressButton(String buttonName) {
        get(buttonName).click();
    }

    public void checkMessage(String msg) {
        WebElement message = get(msg);
        Assert.assertTrue(message.getText().contains(msg));
        Assert.assertTrue(message.isDisplayed());
    }
}
