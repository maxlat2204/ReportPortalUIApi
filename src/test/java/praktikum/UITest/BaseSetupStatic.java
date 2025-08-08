package praktikum.UITest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.EnvConfig;
import praktikum.pages.*;

import java.util.Map;


public class BaseSetupStatic {
    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static SidebarPage sidebarPage;
    protected static DashboardPage dashboardPage;
    protected static AddNewWidgetPage addNewWidgetPage;



    @BeforeAll
    public static void setUp(){
        initDriver();//открывает браузер
        driver.get(EnvConfig.BASE_URL);//открывает страницу

        loginPage = new LoginPage(driver);
        sidebarPage = new SidebarPage(driver);
        dashboardPage = new DashboardPage(driver);
        addNewWidgetPage = new AddNewWidgetPage(driver);
    }

    @AfterAll
    public static void after(){
//        driver.quit();
    }

    //Запуск через firefox описан в файле readme.md
    public static void initDriver(){
        if ("firefox".equalsIgnoreCase(System.getProperty("browser"))){
            startBrowserFirefox();
        } else {
            startBrowserChrome();
        }
    }

    //    Открывает браузер Chrome
    public static void startBrowserChrome(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--password-store=basic");
        options.setExperimentalOption("prefs", Map.of(
                "profile.password_manager_leak_detection", false
        ));

        driver = new ChromeDriver(options);
    }


    //Открывает браузер Firefox
    public static void startBrowserFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
