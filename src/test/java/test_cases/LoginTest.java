package test_cases;

import org.junit.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {


    @Test
    public void loginPageTest() {
        initialize();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginValidUser();
    }
}
