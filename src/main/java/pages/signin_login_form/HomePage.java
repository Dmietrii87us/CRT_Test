package pages.signin_login_form;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static testdata.TestData.Data.isSignedIn;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By homeLink = By.xpath("//a[@href='/']");
    private final By loginLink = By.xpath("//a[@href='/login']");
    private final By SignUpLink = By.xpath("//a[@href='/signup']");
    private final By profileLink = By.xpath("//a[@href='/profile']");
    private final By logoutLink = By.xpath("//a[@href='/logout']");

    public By getProfileLink() {
        return profileLink;
    }

    public By getLoginLink() {
        return loginLink;
    }

    // метод метод определяет залогиненное состояние по наличию линка Profile
    public boolean isProfileLinkPresent() {
        if ((driver.findElement(profileLink).isDisplayed()) == true) {
            return true;
        } else {
            return false;
        }
    }

    //метод определяет разлогиненное состояние по наличию линка Login
    public boolean isLoginLinkPresent() {
        try {
            driver.findElement(loginLink);
            isSignedIn = false;
            return isSignedIn;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //метод переходит на страницу Home
    public HomePage toHomePage() {
        driver.findElement(homeLink).click();
        return this;
    }

    //метод переходит на страницу Login
    public HomePage toLoginForm() {
        driver.findElement(loginLink).click();
        return this;
    }

    //метод переходит на страницу SignUp
    public HomePage toSignUpForm() {
        driver.findElement(SignUpLink).click();
        return this;
    }

    //метод переходит на страницу Profile
    public HomePage toProfilePage() {
        driver.findElement(profileLink).click();
        return this;
    }

    //метод выполняет Logout
    public HomePage toLogout() {
        driver.findElement(logoutLink).click();
        return this;
    }
}
