package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardPage extends BasePages {
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    public DashboardPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT));
//    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    protected final By aDemoDashboard = By.xpath(".//a[contains(@class, 'dashboardTable__name') and text()='DEMO DASHBOARD']");//DemoDashboard
    protected final By buttonAddDashboard = By.xpath(".//span[text()='Add New Dashboard']");//Кнопка создать новый Dashboard

    protected final By buttonAddNewWidget = By.xpath(".//span[text()='Add new widget']");//Кнопка создать новый Widget


    //Метод клика по DemoDashboard
    public void clickButtonDemoDashboard() {
        clickElement(aDemoDashboard);
    }

    //Метод клика по Add New Dashboard
    public void clickButtonAddNewDashboard() {
        clickElement(buttonAddDashboard);
    }

    //Метод клика по Add new widget
    public void clickButtonAddNewWidget() {
        clickElement(buttonAddNewWidget);
    }


}
