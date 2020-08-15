package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utility.DriverProvider;

public abstract class BaseTest {
    public WebDriver driver;
    private DriverProvider driverProvider = new DriverProvider();

    private void driverInitialize() {
        driver = driverProvider.initDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void appSetup() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeBrowserWindow() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public LoginPage loadApplication() {
        driverInitialize();
        return new LoginPage(driver);
    }
}
