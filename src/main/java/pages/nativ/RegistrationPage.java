package pages.nativ;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class RegistrationPage extends BasePage {

    @iOSXCUITFindBy(xpath = "// *[@name='Email'] / .. /  XCUIElementTypeTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement emailField;

    @iOSXCUITFindBy(xpath = "// *[@name='Username'] / .. /  XCUIElementTypeTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement usernameField;

    @iOSXCUITFindBy(xpath = "// *[@value='Password'] // following-sibling::XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement passwordField;

    @iOSXCUITFindBy(xpath = "// *[@value='Confirm password'] // following-sibling::XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPasswordField;

    @iOSXCUITFindBy(xpath = "// XCUIElementTypeStaticText[@name='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement registerBtn;

    public RegistrationPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public LoginPage registerUser(User user) {
        emailField.sendKeys(user.getEmail());
        usernameField.sendKeys(user.getName());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
        registerBtn.click();
        if (registerBtn.isDisplayed()) {
            registerBtn.click();
        }
        return new LoginPage(appiumDriver);
    }

}
