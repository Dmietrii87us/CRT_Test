package webFormTesting;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constant.Urls.HOME_PAGE;
import static testdata.TestData.Data.*;

public class WebFormTest extends BaseTest {

    @Test
    public void signUpAndLoginValidFields() throws InterruptedException {
        basePage.open(HOME_PAGE);
        homePage.toSignUpForm();

        int counter = 0;
        for (int i = 0; i < emailValue1.length; i++) {
            homePage.waitLocatorPresence(signUpPage.getEmailFieldSignUp());
            signUpPage.enterEmail(emailValue1[i]);
            signUpPage.enterName(nameValue1[i]);
            signUpPage.enterPassword(passwordValue1[i]);
            signUpPage.clickToSignUp();
            homePage.toLoginForm();
            loginPage.waitLocatorPresence(loginPage.getYourEmailField());
            loginPage.enterYourEmail(emailValue1[i]);
            loginPage.enterYourPassword(passwordValue1[i]);
            loginPage.clickToLogin();

            profilePage.waitLocatorPresence(homePage.getProfileLink());
            if (homePage.isProfileLinkPresent()) {
                counter += 1;
                homePage.toLogout();
            }
            homePage.toSignUpForm();
        }
        Assert.assertEquals(counter, emailValue1.length);
    }

    @Test
    public void signUpAndLoginInvalidFields() throws InterruptedException {
        basePage.open(HOME_PAGE);
        homePage.toSignUpForm();

        int counter = 0;
        for (int i = 0; i < emailValue3.length; i++) {
            signUpPage.enterEmail(emailValue3[i]);
            signUpPage.enterName(nameValue3[i]);
            signUpPage.enterPassword(passwordValue3[i]);
            signUpPage.clickToSignUp();
            homePage.toLoginForm();
            loginPage.enterYourEmail(emailValue3[i]);
            loginPage.enterYourPassword(passwordValue3[i]);
            loginPage.clickToLogin();
            profilePage.waitElementIsVisible(driver.findElement(homePage.getLoginLink()));
            if (!(homePage.isProfileLinkPresent())) {
                counter += 1;
                signUpPage.clickToSignUp();
            } else {
                homePage.toLogout().toSignUpForm();
            }
        }
        Assert.assertEquals(counter, emailValue1.length);
    }


    @Test
    public void checkedRememberMeCheckBox() {
        basePage.open(HOME_PAGE);
        homePage.toSignUpForm();
        signUpPage.enterEmail(emailValue4);
        signUpPage.enterName(nameValue4);
        signUpPage.enterPassword(passwordValue4);
        signUpPage.clickToSignUp();

        homePage.toLoginForm();
        loginPage.enterYourEmail(emailValue4);
        loginPage.enterYourPassword(passwordValue4);
        loginPage.rememberMeCheckBoxClick();
        loginPage.clickToLogin();
        driver.navigate().refresh();
        profilePage.waitLocatorPresence(homePage.getProfileLink());
        Assert.assertTrue(homePage.isProfileLinkPresent());
    }

    @Test
    public void uncheckedRememberMeCheckBox() {
        basePage.open(HOME_PAGE);

        homePage.toLoginForm();
        loginPage.enterYourEmail(emailValue4);
        loginPage.enterYourPassword(passwordValue4);
        loginPage.clickToLogin();
        driver.navigate().refresh();
        basePage.open(HOME_PAGE);
        Assert.assertTrue(!(homePage.isProfileLinkPresent()));
    }

    @Test
    public void checkWelcomeMessage() {
        basePage.open(HOME_PAGE);

        for (int i = 0; i < emailValue1.length; i++) {
            homePage.toSignUpForm();
            homePage.waitLocatorPresence(signUpPage.getEmailFieldSignUp());
            signUpPage.enterEmail(emailValue5[i]);
            signUpPage.enterName(nameValue5[i]);
            signUpPage.enterPassword(passwordValue5[i]);
            signUpPage.clickToSignUp();
            homePage.toLoginForm();
            loginPage.enterYourEmail(emailValue5[i]);
            loginPage.enterYourPassword(passwordValue5[i]);
            loginPage.clickToLogin();
            homePage.waitLocatorPresence(homePage.getProfileLink());
            homePage.toProfilePage();
            profilePage.waitLocatorPresence(profilePage.getWelcomeMsg());

            String str = profilePage.getWelcomeText();
            if (nameValue1[i].equals("")) {
                Assert.assertEquals(str, "Welcome, !");
                homePage.toLogout();
            } else {
                Assert.assertEquals(str, "Welcome, " + nameValue5[i] + "!");
                homePage.toLogout();
            }
        }
    }
}
