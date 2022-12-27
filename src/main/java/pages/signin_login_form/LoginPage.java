package pages.signin_login_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends HomePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginBtn = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    private final By yourEmailField = By.xpath("//input[@placeholder='Your Email']");
    private final By yourPasswordField = By.xpath("//input[@placeholder='Your Password']");
    private final By rememberMeCheckBox = By.xpath("//input[@type='checkbox']");

    public By getYourEmailField() {
        return yourEmailField;
    }

    //метод нажимает кнопку Login
    public LoginPage clickToLogin() {
        WebElement BtnLogin = driver.findElement(loginBtn);
        waitElementIsVisible(BtnLogin).click();
        return this;
    }

    //метод вводит Email
    public LoginPage enterYourEmail(String email) {
        WebElement fieldYourEmail = driver.findElement(yourEmailField);
        waitElementIsVisible(fieldYourEmail).sendKeys(email);
        return this;
    }

    //метод вводит Password
    public LoginPage enterYourPassword(String password) {
        WebElement fieldYourPassword = driver.findElement(yourPasswordField);
        waitElementIsVisible(fieldYourPassword).sendKeys(password);
        return this;
    }

    //метод нажимает чек-бокс Remember me
    public LoginPage rememberMeCheckBoxClick() {
        WebElement checkBoxRememberMe = driver.findElement(rememberMeCheckBox);
        waitElementIsVisible(checkBoxRememberMe).click();
        return this;
    }
}
