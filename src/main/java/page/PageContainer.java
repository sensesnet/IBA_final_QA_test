package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.pages.*;

public class PageContainer {

    private static AuthenticationPage authenticationPage;

    private static ContactUsPage contactUsPage;

    private static CreateAnAccountPage createAnAccountPage;

    private static OrderHistoryPage orderHistoryPage;

    private static PreAuthorithationPage preAuthorithationPage;

    private static SearchPage searchPage;

    private static ShoppingCartSummaryPage shoppingCartSummaryPage;

    private static WomenPage womenPage;

    private static CommonPage commonPage;

    private PageContainer() {
    }

    public static AuthenticationPage getAuthenticationPage(WebDriver driver) {
        if (authenticationPage == null) {
            authenticationPage = new AuthenticationPage();
            PageFactory.initElements(driver, authenticationPage);
        }
        return authenticationPage;
    }

    public static ContactUsPage getContactUsPage(WebDriver driver) {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
            PageFactory.initElements(driver, contactUsPage);
        }
        return contactUsPage;
    }

    public static CreateAnAccountPage getCreateAnAccountPage(WebDriver driver) {
        if (createAnAccountPage == null) {
            createAnAccountPage = new CreateAnAccountPage();
            PageFactory.initElements(driver, createAnAccountPage);
        }
        return createAnAccountPage;
    }

    public static OrderHistoryPage getOrderHistoryPage(WebDriver driver) {
        if (orderHistoryPage == null) {
            orderHistoryPage = new OrderHistoryPage();
            PageFactory.initElements(driver, orderHistoryPage);
        }
        return orderHistoryPage;
    }

    public static PreAuthorithationPage getPreAuthorithationPage(WebDriver driver) {
        if (preAuthorithationPage == null) {
            preAuthorithationPage = new PreAuthorithationPage();
            PageFactory.initElements(driver, preAuthorithationPage);
        }
        return preAuthorithationPage;
    }

    public static SearchPage getSearchPage(WebDriver driver) {
        if (searchPage == null) {
            searchPage = new SearchPage();
            PageFactory.initElements(driver, searchPage);
        }
        return searchPage;
    }

    public static ShoppingCartSummaryPage getShoppingCartSummaryPage(WebDriver driver) {
        if (shoppingCartSummaryPage == null) {
            shoppingCartSummaryPage = new ShoppingCartSummaryPage();
            PageFactory.initElements(driver, shoppingCartSummaryPage);
        }
        return shoppingCartSummaryPage;

    }

    public static WomenPage getWomenPage(WebDriver driver) {
        if (womenPage == null) {
            womenPage = new WomenPage();
            PageFactory.initElements(driver, womenPage);
        }
        return womenPage;
    }

    public static CommonPage getCommonPage(WebDriver driver) {
        if (commonPage == null) {
            commonPage = new CommonPage();
            PageFactory.initElements(driver, womenPage);
        }
        return commonPage;
    }

}
