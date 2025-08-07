package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SidebarPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT));
    }

    protected final By buttonDashboards = By.xpath(".//a[@href='#default_personal/dashboard']");//Кнопка Dashboards

    //Метод клика по кнопке Dashboards
    public void clickButtonDashboards(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonDashboards));
        assertTrue(driver.findElement(buttonDashboards).isEnabled());
        driver.findElement(buttonDashboards).click();
    }


}
