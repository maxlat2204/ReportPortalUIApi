package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SidebarPage extends BasePages {

    public SidebarPage(WebDriver driver) {
        super(driver);
    }

    protected final By buttonDashboards = By.xpath(".//a[@href='#default_personal/dashboard']");//Кнопка Dashboards

    //Метод клика по кнопке Dashboards
    @Step("Клик на кнопку Dashboards, на боковой панели")
    public void clickButtonDashboards(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonDashboards));
        assertTrue(driver.findElement(buttonDashboards).isEnabled());
        driver.findElement(buttonDashboards).click();
    }

}
