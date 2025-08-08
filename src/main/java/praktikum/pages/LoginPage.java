package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePages {
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT));
//    }
        public LoginPage(WebDriver driver) {
            super(driver);
}

    protected final By inputLogin = By.xpath(".//input[@name='login']");//Поле для ввода логина
    protected final By inputPassword = By.xpath(".//input[@name='password']");//Поле для ввода пароля
    protected final By buttonLogin = By.className("bigButton__color-organish--gj0Mz");



    //Метод ввода данных в поле логин
    public void fillFromLogin(String login){
        fillData(inputLogin, login);
    }

    //Метод ввода данных в поле пароль
    public void fillFromPassword(String password){
        fillData(inputPassword, password);
    }

    //Метод клика по кнопке Логин
    public void clickButtonLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        assertTrue(driver.findElement(buttonLogin).isEnabled());
        driver.findElement(buttonLogin).click();
    }

    //Метод входа в аккаунт
    public void loginSystem(String login, String password){
        fillFromLogin(login);
        fillFromPassword(password);
        clickButtonLogin();
    }


}
