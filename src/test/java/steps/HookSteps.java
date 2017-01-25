package steps;

import config.ApplicationConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.Driver;
import driver.IDriverConstant;
import org.apache.log4j.Logger;

public class HookSteps implements IDriverConstant{
    private static final Logger iLogger = Logger.getLogger(HookSteps.class);

    private void loadDriver() {
        iLogger.info("Load Page");
        try {
            Driver.getWebDriver().get(ApplicationConfig.getInstance().getBaseUrl());
            Driver.getWebDriver().manage().window().maximize();
        } catch (Exception e) {
            iLogger.error("Webdriver isn't created:" + e.getLocalizedMessage());
            return;
        }
//        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), DRIVER_WAIT_TIMEOUT_SEC);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id(ILoginLocators.LOGIN_INPUT)));
    }


    private void doLogin(String login, String password) {
        iLogger.info("Type Password and login...");
//        getLoginPage().typeLogin(login);
//        getLoginPage().typePassword(password);
//        getLoginPage().doLogin();
//        iLogger.info("Check if user logged in successfully or not...");
//        //CustomSleeper.SYSTEM_SLEEPER.sleep(10000L);
//        getHomePage().checkIsUserOnHomePage();
    }

    @Before("@pre_authorization")
    public void loadDriverLogout() {
        loadDriver();
    }

    @Before("@contact_us")
    public void loginForUser7ng() {
        loadDriver();
//        getLoginPage().closeHint();
//        doLogin(ApplicationConfig.getInstance().getUser7ngtl(), ApplicationConfig.getInstance().getPassword());
    }

    @After("@contact_us")
    public void afterScenario() throws Exception {
        iLogger.info("User logoff...");
//        getHomePage().logoff();
//        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
        //Driver.closeDriver();
    }

}
