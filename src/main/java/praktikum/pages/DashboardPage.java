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
    protected final By buttonDeleteDashboard = By.xpath(".//span[text()='Delete']");//Кнопка удаления Dashboard
    protected final By buttonDeleteForWindow = By.xpath(".//button[text()='Delete']");//Кнопка удаления во всплывающем окне


    protected final By buttonAddNewWidget = By.xpath(".//span[text()='Add new widget']");//Кнопка создать новый Widget
    protected final By widgetCreated = By.xpath(".//div[text()='Test Case Maksim']");//Созданный виджет
//    protected final By buttonDeleteWidget = By.xpath(".//svg[@xmlns='http://www.w3.org/2000/svg']");//Кнопка удаления виджета
    protected final By buttonDeleteWidget = By.cssSelector("svg[viewBox='-3 -3 20 20'] > path");//Кнопка удаления виджета

    protected final By inputNameDashboard = By.xpath(".//input[@placeholder='Enter dashboard name']");//Поле для ввода NameDashboard
    protected final By buttonAddForNewDashboard = By.xpath(".//button[text()='Add']");//Кнопка создания DemoDashboard





    //Метод клика по DemoDashboard
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

    //Метод клика по кнопке Delete
    public void clickButtonDeleteDashboard () {
        clickElement(buttonDeleteDashboard);
    }

    //Метод клика по кнопке Delete во всплывающем окне
    public void clickButtonDeleteDashboardWindow () {
        clickElement(buttonDeleteForWindow);
    }

    //Метод удаления Dashboard
    public void deleteDashboard () {
        clickButtonDeleteDashboard();
        clickButtonDeleteDashboardWindow();
    }

    //Метод удаления Виджета
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
