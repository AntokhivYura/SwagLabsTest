package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorText = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

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

    public String getErrorText(){
        return driver.findElement(errorText).getText();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Login with valid credentials")
    public HomePage loginValidUser() {
        setUserNameField("standard_user");
        setPasswordField("secret_sauce");
        clickLoginButton();
        return new HomePage(driver);
    }
    @Step("Login with invalid credentials")
    public HomePage loginInValidUser() {
        setUserNameField("invalid_user");
        setPasswordField("invalid_password");
        clickLoginButton();
        return new HomePage(driver);
    }
}
