package test_cases;

import org.junit.Test;
import org.testng.annotations.DataProvider;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @DataProvider(name="data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "data one" }, { "data two" } };
    }


    @Test
    public void loginPageTest() {
        initialize();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginInValidUser();
        String a = loginPage.getErrorText();
        System.out.println(a);
    }
}
