package Base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.BasePage;
import pages.signin_login_form.HomePage;
import pages.signin_login_form.LoginPage;
import pages.signin_login_form.ProfilePage;
import pages.signin_login_form.SignUpPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected ProfilePage profilePage = new ProfilePage(driver);
    protected SignUpPage signUpPage = new SignUpPage(driver);


    @AfterMethod
    public void clearCookieAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            js.executeScript("window.sessionStorage.clear()");
            driver.navigate().refresh();
        }
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
