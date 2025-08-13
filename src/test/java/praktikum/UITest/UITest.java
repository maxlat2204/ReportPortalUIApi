package praktikum.UITest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import praktikum.EnvConfig;

public class UITest extends BaseSetupStatic{

    @BeforeEach
    public void logSystem(){
        loginPage.loginSystem(EnvConfig.USER_LOGIN, EnvConfig.USER_PASSWORD);
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
        addNewWidgetPage.fillWidgetNameAndClickButtonAdd(EnvConfig.NAME_WIDGET);

        dashboardPage.checkCreatedWidget();
    }

}
