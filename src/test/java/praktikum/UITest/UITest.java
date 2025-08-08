package praktikum.UITest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UITest extends BaseSetupStatic{

    @BeforeEach
    public void logSystem(){
        loginPage.loginSystem("default", "1q2w3e");
    }

    @AfterEach
    public void delWidget(){
        dashboardPage.deleteWidget();
    }

    @DisplayName("Тест на создание нового виджета")
    @Description("Создаем новый виджет, типа Test Case Search, и проверяем что он создался")
    @Test
    public void addNewWidget(){
        sidebarPage.clickButtonDashboards();
        dashboardPage.clickButtonDemoDashboard();
        dashboardPage.clickButtonAddNewWidget();
        addNewWidgetPage.clickButtonDemoDashboard();
        addNewWidgetPage.clickButtonNextStep();
        addNewWidgetPage.fillWidgetNameAndClickButtonAdd("Test Case Maksim");

        dashboardPage.checkCreatedWidget();
    }

}
