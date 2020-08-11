package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserNameField(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public WebElement getUserNameField() {
        return driver.findElement(userNameField);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public HomePage loginValidUser() {
        setUserNameField("standard_user");
        setPasswordField("secret_sauce");
        clickLoginButton();
        return new HomePage(driver);
    }
}
