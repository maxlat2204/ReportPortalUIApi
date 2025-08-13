package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import praktikum.EnvConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardPage extends BasePages {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    protected final By aDemoDashboard = By.xpath(".//a[contains(@class, 'dashboardTable__name') and text()='DEMO DASHBOARD']");//DemoDashboard
    protected final By buttonAddDashboard = By.xpath(".//span[text()='Add New Dashboard']");//Кнопка создать новый Dashboard
    protected final By buttonDeleteDashboard = By.xpath(".//span[text()='Delete']");//Кнопка удаления Dashboard
    protected final By buttonDeleteForWindow = By.xpath(".//button[text()='Delete']");//Кнопка удаления во всплывающем окне

    protected final By buttonAddNewWidget = By.xpath(".//span[text()='Add new widget']");//Кнопка создать новый Widget
    protected final By widgetCreated = By.xpath(".//div[text()='" + EnvConfig.NAME_WIDGET + "']");//Созданный виджет
    protected final By buttonDeleteWidget = By.cssSelector("svg[viewBox='-3 -3 20 20'] > path");//Кнопка удаления виджета

    protected final By inputNameDashboard = By.xpath(".//input[@placeholder='Enter dashboard name']");//Поле для ввода NameDashboard
    protected final By buttonAddForNewDashboard = By.xpath(".//button[text()='Add']");//Кнопка создания DemoDashboard


    //Метод клика по DemoDashboard
    @Step("Клик по DemoDashboard, на странице Dashboard")
    public void clickButtonDemoDashboard() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(aDemoDashboard));
            driver.findElement(aDemoDashboard).isDisplayed();
            clickElement(aDemoDashboard);
        } catch (Exception e){
            clickButtonAddNewDashboard();
            createNewDemoDashboard();
        }
    }

    //Метод клика по Add New Dashboard
    @Step("Клик по кнопке создания нового Dashboard, на странице Dashboard")
    public void clickButtonAddNewDashboard () {
        clickElement(buttonAddDashboard);
    }

    //Метод клика по Add new widget
    @Step("Клик по кнопке создания нового Widget, на странице Dashboard")
    public void clickButtonAddNewWidget () {
        clickElement(buttonAddNewWidget);
    }

    //Метод проверки создался ли виджет
    @Step("Проверка создался ли новый Widget, на странице Dashboard")
    public void checkCreatedWidget () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(widgetCreated));
        assertTrue(driver.findElement(widgetCreated).isDisplayed());
    }

    //Метод создания нового DemoDashboard
    @Step("Создание DemoDashboard, на странице Dashboard")
    public void createNewDemoDashboard(){
        fillData(inputNameDashboard, "DEMO DASHBOARD");
        clickElement(buttonAddForNewDashboard);
    }

    //Метод клика по кнопке Delete
    @Step("Клик по кнопке Delete, на странице Dashboard")
    public void clickButtonDeleteDashboard () {
        clickElement(buttonDeleteDashboard);
    }

    //Метод клика по кнопке Delete во всплывающем окне
    @Step("Клик по кнопке Delete во всплывающем окне")
    public void clickButtonDeleteDashboardWindow () {
        clickElement(buttonDeleteForWindow);
    }

    //Метод удаления Dashboard
    @Step("Удаление Dashboard")
    public void deleteDashboard () {
        clickButtonDeleteDashboard();
        clickButtonDeleteDashboardWindow();
    }

    //Метод удаления Виджета
    @Step("Удаление Widget")
    public void deleteWidget () {
        try {
            hoverEffect(widgetCreated);
            clickElement(buttonDeleteWidget);
            clickElement(buttonDeleteForWindow);
        } catch (Exception e){
            System.out.println("Удаление виджета не понадобилось: " + e.getMessage());
        }
    }

}
