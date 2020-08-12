package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("Base Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private final String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @Test(priority = 1, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("some text")
                .enterPassword("some password")
                .clickLoginButton()
                .verifyLoginPassword(expectedErrorMessage);

    }
}
