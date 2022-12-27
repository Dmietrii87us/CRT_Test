package pages.signin_login_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends HomePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By signUpBtn = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    private final By emailFieldSignUp = By.xpath("//input[@type='email']");
    private final By nameFieldSignUp = By.xpath("//input[@name='name']");
    private final By passwordFieldSignUp = By.xpath("//input[@name='password']");

    public By getEmailFieldSignUp() {
        return emailFieldSignUp;
    }

    //метод нажимает кнопку Sign Up
    public SignUpPage clickToSignUp() {
        WebElement btnSignUp = driver.findElement(signUpBtn);
        waitElementIsVisible(btnSignUp).click();
        return this;
    }

    //метод вводит Email
    public SignUpPage enterEmail(String email) {
        WebElement SignUpFieldEmail = driver.findElement(emailFieldSignUp);
        waitElementIsVisible(SignUpFieldEmail).sendKeys(email);
        return this;
    }

    //метод вводит Name
    public SignUpPage enterName(String name) {
        WebElement SignUpFieldName = driver.findElement(nameFieldSignUp);
        waitElementIsVisible(SignUpFieldName).sendKeys(name);
        return this;
    }

    //метод вводит Password
    public SignUpPage enterPassword(String password) {
        WebElement SignUpFieldPassword = driver.findElement(passwordFieldSignUp);
        waitElementIsVisible(SignUpFieldPassword).sendKeys(password);
        return this;
    }
}
