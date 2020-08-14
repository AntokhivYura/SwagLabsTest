package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utility.constants.Credentials.STANDART_USER_USERNAME;
import static utility.constants.ErrorMessages.PASSWORD_IS_REQUIRED;
import static utility.constants.ErrorMessages.USERNAME_IS_REQUIRED;

@Epic("Base Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Invalid Login Scenario with empty username field.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with empty username.")
    @Story("Empty username login test")
    public void invalidLoginTest_EmptyUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton()
                .isErrorMessageDisplayed(true)
                .verifyLoginPassword(USERNAME_IS_REQUIRED);
    }


    @Test(priority = 1, description = "Invalid Login Scenario with correct username and empty password field.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with correct username and empty password.")
    @Story("Correct username and empty password login test")
    public void invalidLoginTest_CorrectUserNameEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(STANDART_USER_USERNAME)
                .clickLoginButton()
                .isErrorMessageDisplayed(true)
                .verifyLoginPassword(PASSWORD_IS_REQUIRED);
    }


}
