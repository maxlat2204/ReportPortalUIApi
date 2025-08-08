package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardPage extends BasePages {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    protected final By aDemoDashboard = By.xpath(".//a[contains(@class, 'dashboardTable__name') and text()='DEMO DASHBOARD']");//DemoDashboard
    protected final By buttonAddDashboard = By.xpath(".//span[text()='Add New Dashboard']");//Кнопка создать новый Dashboard

    protected final By buttonAddNewWidget = By.xpath(".//span[text()='Add new widget']");//Кнопка создать новый Widget
    protected final By widgetCreated = By.xpath(".//div[text()='Test Case Maksim']");//Созданный виджет

    protected final By inputNameDashboard = By.xpath(".//input[@placeholder='Enter dashboard name']");//Поле для ввода NameDashboard
    protected final By buttonAddForNewDashboard = By.xpath(".//button[text()='Add']");//Кнопка создания DemoDashboard



    //Метод клика по DemoDashboard
    public void clickButtonDemoDashboard() {
        try {
            driver.findElement(aDemoDashboard).isDisplayed();
            clickElement(aDemoDashboard);
        } catch (NoSuchElementException e){
            clickButtonAddNewDashboard();
            createNewDemoDashboard();
        }
    }

        //Метод клика по Add New Dashboard
        public void clickButtonAddNewDashboard () {
            clickElement(buttonAddDashboard);
        }

        //Метод клика по Add new widget
        public void clickButtonAddNewWidget () {
            clickElement(buttonAddNewWidget);
        }

        //Метод проверки создался ли виджет
        public void checkCreatedWidget () {
            wait.until(ExpectedConditions.visibilityOfElementLocated(widgetCreated));
            assertTrue(driver.findElement(widgetCreated).isDisplayed());
        }

        //Метод создания нового DemoDashboard
        public void createNewDemoDashboard(){
            fillData(inputNameDashboard, "DEMO DASHBOARD");
            clickElement(buttonAddForNewDashboard);
        }


}
