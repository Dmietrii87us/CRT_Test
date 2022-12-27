package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.ExplicitWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод открывает страницу по url
    public void open(String url) {
        driver.get(url);
    }

    //метод ожидает, пока элемент станет видимым и возвращает его
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    //метод ожидает, пока By станет видимым и возвращает его
    public By waitLocatorPresence(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait)).until(ExpectedConditions.presenceOfElementLocated(by));
        return by;
    }
}
