package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePages {

    public LoginPage(WebDriver driver) {
            super(driver);
}

    protected final By inputLogin = By.xpath(".//input[@name='login']");//Поле для ввода логина
    protected final By inputPassword = By.xpath(".//input[@name='password']");//Поле для ввода пароля
    protected final By buttonLogin = By.className("bigButton__color-organish--gj0Mz");

    //Метод ввода данных в поле логин
    @Step("Ввод логина, на странице входа")
    public void fillFromLogin(String login){
        fillData(inputLogin, login);
    }

    //Метод ввода данных в поле пароль
    @Step("Ввод пароля, на странице входа")
    public void fillFromPassword(String password){
        fillData(inputPassword, password);
    }

    //Метод клика по кнопке Логин
    @Step("Клик по кнопке Логин, на странице входа")
    public void clickButtonLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        assertTrue(driver.findElement(buttonLogin).isEnabled());
        driver.findElement(buttonLogin).click();
    }

    //Метод входа в аккаунт
    @Step("Ввод логина,пароля и вход, на странице входа")
    public void loginSystem(String login, String password){
        fillFromLogin(login);
        fillFromPassword(password);
        clickButtonLogin();
    }

}
