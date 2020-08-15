package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.builder.user_builder.IUser;

public class LoginPage extends BasePage {

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Try to login with valid credentials")
    public HomePage loginValidUser() {
        writeText(userNameField, "standard_user");
        writeText(passwordField, "secret_sauce");
        click(loginButton);
        return new HomePage(driver);
    }

    @Step("Try to login with invalid credentials")
    public LoginPage loginInvalidUser() {
        writeText(userNameField, "standard_user1");
        writeText(passwordField, "secret_sauce1");
        click(loginButton);
        return this;
    }

    @Step("Enter {username} to username field")
    public LoginPage enterUsername(String username) {
        writeText(userNameField, username);
        return this;
    }

    @Step("Enter {password} to password field")
    public LoginPage enterPassword(String password) {
        writeText(passwordField, password);
        return this;
    }

    @Step("Click on Login button")
    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    @Step("Verify Error message is displayed (expected = {isErrorDisplayed})")
    public LoginPage isErrorMessageDisplayed(boolean isErrorDisplayed) {
        boolean errorMessageDisplayed = isDisplayed(errorMessage);
        Assert.assertEquals(errorMessageDisplayed, isErrorDisplayed);
        return this;
    }

    @Step("Verify Error message is correct (expected = {expectedErrorMessage})")
    public LoginPage verifyErrorMessage(String expectedErrorMessage) {
        waitVisibility(errorMessage);
        Assert.assertEquals(readText(errorMessage), expectedErrorMessage);
        return this;
    }

    //Business Logic functions
    public HomePage successfulLogin(IUser user) {
        enterUsername(user.getUserName());
        enterPassword(user.getUserPassword());
        clickLoginButton();
        return new HomePage(driver);
    }
}
