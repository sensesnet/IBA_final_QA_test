package driver;

import config.ApplicationConfig;
import exception.DriverException;
import exception.UnknownDriverTypeException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Driver {

    private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";

    private static WebDriverTypes defaultDriverType;

    private final static int DRIVER_WAIT = 10;

    private static HashMap<String, WebDriver> instances;

    private static final Logger iLogger = Logger.getLogger(Driver.class);

    private static WebDriver iWebDriver;

    public Driver() {
    }

    static {
        instances = new HashMap<String, WebDriver>();
        defaultDriverType = WebDriverTypes.FIREFOX;
    }

    public static WebDriver getWebDriverInstance(String name,
                                                 WebDriverTypes type) throws Exception {
        WebDriver driver = null;
        try {
            if (!instances.containsKey(name)) {
                switch (type) {
                    case FIREFOX: {
                        FirefoxProfile fp = new FirefoxProfile();
                        fp.setAcceptUntrustedCertificates(true);
                        driver = new FirefoxDriver(fp);
                        break;
                    }
                    case IE: {
                        driver = new InternetExplorerDriver();
                        driver.manage().window().maximize();
                        break;
                    }
                    case CHROME: {

                        System.setProperty("webdriver.chrome.driver",
                                "src/main/java/chromedriver.exe");
                        driver = new ChromeDriver();
                        break;
                    }
                    case SAFARI: {
                        driver = new SafariDriver();
                        break;
                    }
                    case OPERA: {

                        System.setProperty("webdriver.opera.driver",
                                "src/main/java/operadriver.exe");
                        driver = new OperaDriver();
                        driver.manage().window().maximize();
                        break;
                    }/*case HTMLUNIT: {
                        driver = new HtmlUnitDriver();
						((HtmlUnitDriver)driver).setJavascriptEnabled(true);
						break;
					}case PHANTOM: {
					System.setProperty("phantomjs.binary.path", "src/main/java/phantomjs.exe");
					driver = new PhantomJSDriver();
					break;
					}*/
                    default:
                        throw new UnknownDriverTypeException(
                                "Unknown web driver specified: "
                                        + type.getDriverName());
                }
                driver.manage().timeouts()
                        .implicitlyWait(DRIVER_WAIT, TimeUnit.SECONDS);
                instances.put(name, driver);
            } else {
                driver = instances.get(name);
            }
        } finally {
            Runtime.getRuntime().addShutdownHook(new ClearShutdownHook());
        }
        return driver;
    }

    public static WebDriver getWebDriver() {
        if (iWebDriver == null) {
            try {
                iWebDriver = getWebDriverInstance(ApplicationConfig.getInstance().getDriverName(), WebDriverTypes.valueOf(ApplicationConfig.getInstance().getDriverName().toUpperCase()));
                iLogger.info("WebDriver was created: " + ApplicationConfig.getInstance().getDriverName());
            } catch (Exception e) {
                iLogger.error("WebDriver " + "'" + ApplicationConfig.getInstance().getDriverName() + "'" + " wasn't created: " + e.getLocalizedMessage());
                try {
                    iWebDriver = getDefaultWebDriver();
                    iLogger.info("Default WebDriver was created: FIREFOX.");
                } catch (Exception pex) {
                    iLogger.error("Default WebDriver wasn't created: " + e.getLocalizedMessage());
                }
            }
        }
        return iWebDriver;
    }

    public static WebDriver getDefaultWebDriver() throws Exception {
        return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverType);
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

    //_webElement
    public static WebElement findElement(By by) throws DriverException {
        List<WebElement> elements = getWebDriver().findElements(by);
        if (!elements.isEmpty()) {
            return elements.get(0);
        }
        throw new DriverException("Element with locator " + by.toString() + " not found");
    }

    public static WebElement findElement(String xpath, String args) {
        iLogger.info("Method findElement return element" + String.format(xpath, args));
        WebElement element = Driver.findElement(By.xpath(String.format(xpath, args)));
        if (element != null) {
            return element;
        }
        throw new DriverException("Element with locator " + String.format(xpath, args) + " not found");
    }

    //_ListwebElement
    public static List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    public static boolean isElementFound(By by) {
        try {
            WebElement el = findElement(by);
            if (el == null) {
                return false;
            }
        } catch (Exception e) {
            iLogger.error("Error while finding element:" + e.getLocalizedMessage());
            return false;
        }
        return true;
    }

//	public static void waitForElement(final Element element, long timeInSeconds) {
//		// Waiting "timeInSeconds" seconds for an element to be present on the page, checking
//		// for its presence once every 5 seconds.
//		Wait<Element> wait = new FluentWait<Element>(element)
//				.withTimeout(timeInSeconds, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//
//		wait.until(new Function<Element, Boolean>() {
//
//			public Boolean apply(Element element) {
//				return element.isElementPresent();
//			}
//
//		});
//	}

    public static boolean isElementPresent(WebElement element) {
        try {
            isElementAvailable(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDisplayed(By by) {
        try {
            WebElement el = findElement(by);
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementAvailable(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isVisible(WebElement element) {
        try {
            return isDisplayed(element);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isVisible(By by) {
        try {
            return isDisplayed(by);
        } catch (Exception e) {
            return false;
        }
    }


    public static void closeDriver() throws Exception {
        if (getWebDriver() != null) {
            iWebDriver.close();
            iWebDriver.quit();
            instances.clear();
            iWebDriver = null;
            iLogger.info("CloseDriver - the browser has been closed...");
        }
    }

    public static Set<String> getWindowHandles() {
        final Set<String> oldWindowsSet = getWebDriver().getWindowHandles();
        return oldWindowsSet;
    }

    public static void checkNewWindow(final Set<String> oldWindowsSet) {
        String newWindow = (new WebDriverWait(getWebDriver(), 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        getWebDriver().switchTo().window(newWindow);
    }

    private static class ClearShutdownHook extends Thread {

        private static final Logger iLogger = Logger.getLogger(Driver.class);

        @Override
        public void run() {
            iLogger.info("Running shutdown hook to shutdown webdriver...");
            try {
                closeDriver();
            } catch (Exception e) {
                iLogger.error("Error while destroy driver:"
                        + e.getLocalizedMessage());
                throw new RuntimeException(new Error(e));
            }
            iLogger.info("Running Shutdown Hook executed.");
        }

    }

    public void takeNewWindow() {
        try {
        Set<String> newWindowsSet = Driver.getWindowHandles();
        Driver.checkNewWindow(newWindowsSet);
        } catch (Exception e) {
            iLogger.info("Error when take new window!");
        }
    }

}
