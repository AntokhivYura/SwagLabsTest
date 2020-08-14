package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void appSetup() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @AfterClass
    public void closeUp() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
