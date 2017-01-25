package page;

import driver.Driver;
import org.apache.log4j.Logger;
import page.pages.*;

public class PreCondition {

    private static final Logger iLogger = Logger.getLogger(PreCondition.class);

    private AuthenticationPage authenticationPage;

    private ContactUsPage contactUsPage;

    private CreateAnAccountPage createAnAccountPage;

    private OrderHistoryPage orderHistoryPage;

    private PreAuthorithationPage preAuthorithationPage;

    private SearchPage searchPage;

    private ShoppingCartSummaryPage shoppingCartSummaryPage;

    private WomenPage womenPage;

    private CommonPage commonPage;

    public AuthenticationPage getAuthenticationPage() {
        if (authenticationPage == null) {
            authenticationPage = PageContainer.getAuthenticationPage(Driver.getWebDriver());
        }
        return authenticationPage;
    }

    public ContactUsPage getContactUsPage() {
        if (contactUsPage == null) {
            contactUsPage = PageContainer.getContactUsPage(Driver.getWebDriver());
        }
        return contactUsPage;
    }

    public CreateAnAccountPage getCreateAnAccountPage() {
        if (createAnAccountPage == null) {
            createAnAccountPage = PageContainer.getCreateAnAccountPage(Driver.getWebDriver());
        }
        return createAnAccountPage;
    }

    public OrderHistoryPage getOrderHistoryPage() {
        if (orderHistoryPage == null) {
            orderHistoryPage = PageContainer.getOrderHistoryPage(Driver.getWebDriver());
        }
        return orderHistoryPage;
    }

    public PreAuthorithationPage getPreAuthorithationPage() {
        if (preAuthorithationPage == null) {
            preAuthorithationPage = PageContainer.getPreAuthorithationPage(Driver.getWebDriver());
        }
        return preAuthorithationPage;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = PageContainer.getSearchPage(Driver.getWebDriver());
        }
        return searchPage;
    }

    public ShoppingCartSummaryPage getShoppingCartSummaryPage() {
        if (shoppingCartSummaryPage == null) {
            shoppingCartSummaryPage = PageContainer.getShoppingCartSummaryPage(Driver.getWebDriver());
        }
        return shoppingCartSummaryPage;
    }

    public WomenPage getWomenPage() {
        if (womenPage == null) {
            womenPage = PageContainer.getWomenPage(Driver.getWebDriver());
        }
        return womenPage;
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = PageContainer.getCommonPage(Driver.getWebDriver());
        }
        return commonPage;
    }
}
