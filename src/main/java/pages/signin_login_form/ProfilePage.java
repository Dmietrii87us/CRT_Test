package pages.signin_login_form;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static testdata.TestData.Data.welcomeMessage;

public class ProfilePage extends HomePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public final By welcomeMsg = By.xpath("//h1[@class='title']");

    public By getWelcomeMsg() {
        return welcomeMsg;
    }

    //метод получает текст из приветственного сообщения
    public String getWelcomeText() {
        welcomeMessage = driver.findElement(welcomeMsg).getText();
        return welcomeMessage;
    }

    public boolean isWelcomeMessage() {
        try {
            driver.findElement(welcomeMsg);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
