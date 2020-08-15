package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static utility.constants.Credentials.PASSWORD_FOR_ALL_USERS;
import static utility.constants.Credentials.STANDARD_USER_USERNAME;
import static utility.constants.ErrorMessages.PASSWORD_IS_REQUIRED;
import static utility.constants.ErrorMessages.USERNAME_IS_REQUIRED;

@Epic("Base Tests")
@Feature("Login Tests")
@Test
public class LoginTest extends BaseTest {
    private LoginPage loginPage = new LoginPage(driver);
    private ProductsPage productsPage = new ProductsPage(driver);

    @Test(priority = 1, description = "Invalid Login Scenario with empty username field.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with empty username.")
    @Story("Empty username login test")
    public void invalidLoginTest_EmptyUserName() {
        loginPage.clickLoginButton()
                .isErrorMessageDisplayed(true)
                .verifyErrorMessage(USERNAME_IS_REQUIRED);
    }

    @Test(priority = 1, description = "Invalid Login Scenario with correct username and empty password field.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with correct username and empty password.")
    @Story("Correct username and empty password login test")
    public void invalidLoginTest_CorrectUserNameEmptyPassword() {
        loginPage.enterUsername(STANDARD_USER_USERNAME)
                .clickLoginButton()
                .isErrorMessageDisplayed(true)
                .verifyErrorMessage(PASSWORD_IS_REQUIRED);
    }

    @Test(priority = 1, description = "Valid Login Scenario with correct username and correct password.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with correct username and correct password.")
    @Story("Correct username and correct password login test")
    public void validLoginTest(){
        loginPage.enterUsername(STANDARD_USER_USERNAME)
                .enterPassword(PASSWORD_FOR_ALL_USERS)
                .clickLoginButton();
        productsPage.isCartButtonDisplayed();
    }
}
