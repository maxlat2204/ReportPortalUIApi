package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewWidgetPage extends BasePages {

    public AddNewWidgetPage(WebDriver driver) {
        super(driver);
    }

    protected final By radioTestCaseSearch = By.xpath(".//div[text()='Test case search']/ancestor::label");//Радио кнопка TestCaseSearch
    protected final By buttonNextStep = By.xpath(".//span[text()='Next step']/parent::button");//Кнопка NextStep

    protected final By inputWidgetName = By.className("input__input--iYEmM");//Поле WidgetName
    protected final By buttonAdd = By.xpath(".//button[text()='Add']");//Кнопка Add


    //Метод клика по radioTestCaseSearch
    @Step("Клик по радио кнопке TestCaseSearch, на странице AddNewWidget")
    public void clickButtonDemoDashboard() {
        clickElement(radioTestCaseSearch);
    }

    //Метод клика по buttonNextStep
    @Step("Клик по кнопке NextStep, на странице AddNewWidget")
    public void clickButtonNextStep() {
        clickElement(buttonNextStep);
    }

    //Метод ввода данных в поле WidgetName
    @Step("Ввод данных в поле WidgetName, на странице AddNewWidget")
    public void fillWidgetName(String widgetName){
        fillData(inputWidgetName, widgetName);
    }

    //Метод клика по ButtonAdd
    @Step("Клик по кнопке Add, на странице AddNewWidget")
    public void clickButtonAdd() {
        clickElement(buttonAdd);
    }

    //Метод ввода WidgetName и клика по ButtonAdd
    @Step("Ввод данных в поле WidgetName и клик по кнопке Add, на странице AddNewWidget")
    public void fillWidgetNameAndClickButtonAdd(String widgetName) {
        fillWidgetName(widgetName);
        clickButtonAdd();
    }




}
