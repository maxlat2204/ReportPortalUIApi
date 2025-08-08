package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePages {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT));
    }

    //Метод клика по элементу с ожиданием
    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        assertTrue(driver.findElement(element).isEnabled());
        driver.findElement(element).click();
    }

    //Метод ввода данных с ожиданием
    protected void fillData(By element, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        assertTrue(driver.findElement(element).isEnabled());
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
    }

    //Эффект наведения курсора
    protected void hoverEffect(By elementLocated) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(elementLocated)).pause(EnvConfig.PAUSE_HOVER).perform();
    }
}
