package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewWidgetPage extends BasePages {
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    public AddNewWidgetPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT));
//    }

    public AddNewWidgetPage(WebDriver driver) {
        super(driver);
    }

    protected final By radioTestCaseSearch = By.xpath(".//div[text()='Test case search']/ancestor::label");//Радио кнопка TestCaseSearch
//    protected final By radioTestCaseSearch = By.xpath(".//div[text()='Test case search']");//Радио кнопка TestCaseSearch
    protected final By buttonNextStep = By.xpath(".//span[text()='Next step']/parent::button");//Кнопка NextStep

    protected final By inputWidgetName = By.className("input__input--iYEmM");//Поле WidgetName
    protected final By buttonAdd = By.xpath(".//button[text()='Add']");//Кнопка Add


    //Метод клика по radioTestCaseSearch
    public void clickButtonDemoDashboard() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioTestCaseSearch);
        clickElement(radioTestCaseSearch);
//        wait.until(ExpectedConditions.attributeContains(radioTestCaseSearch, "class", "active"));
    }

    //Метод клика по buttonNextStep
    public void clickButtonNextStep() {
        clickElement(buttonNextStep);
    }

    //Метод ввода данных в поле WidgetName
    public void fillWidgetName(String widgetName){
        fillData(inputWidgetName, widgetName);
    }

    //Метод клика по ButtonAdd
    public void clickButtonAdd() {
        clickElement(buttonAdd);
    }

    //Метод ввода WidgetName и клика по ButtonAdd
    public void fillWidgetNameAndClickButtonAdd(String widgetName) {
        fillWidgetName(widgetName);
        clickButtonAdd();
    }




}
