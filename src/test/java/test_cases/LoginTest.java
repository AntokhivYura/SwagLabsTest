package test_cases;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "First test")
    @Description("Test Description")
    public void loginPageTest() {

        initialize();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginInValidUser();
        String a = loginPage.getErrorText();
        System.out.println(a);
    }
}
