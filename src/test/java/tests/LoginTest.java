package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utility.constants.ErrorMessages.*;

@Epic("Base Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("some text")
                .enterPassword("some password")
                .clickLoginButton()
                .isErrorMessageDisplayed(true)
                .verifyLoginPassword(NO_MATCHES_FOR_USERNAME_AND_PASSWORD);
    }
}
