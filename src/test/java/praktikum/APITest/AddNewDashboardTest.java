package praktikum.APITest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import praktikum.dashboard.DashboardModel;
import praktikum.dashboard.DashboardSteps;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNewDashboardTest extends BaseApiTest {

    @Test
    @DisplayName("Позитивный тест на создание нового Dashboard")
    @Description("Создаем Dashboard с рандомным именем и описанием, и проверяем что Dashboard появился в списке Dashboard-ов")
    public void createAddDashboard(){
        dashboardId = DashboardSteps.createDashboardStep(dashboard)
                .statusCode(HTTP_CREATED)
                .body("id", notNullValue())
                .extract()
                .path("id");

        DashboardSteps.getDashboardStep(dashboardId)
                .statusCode(HTTP_OK);
    }

    @Test
    @DisplayName("Негативный тест на создание нового Dashboard, с недостаточными параметрами")
    @Description("Смотрим начальное количество Dashboard-ов, Создаем Dashboard с недостаточными параметрами, чтобы проверить что Dashboard не создался, сравниваем начальное и конечное количество Dashboard-ов")
    public void createAddDashboardNoParameter(){
        int initialTotalElementCount = DashboardSteps.getAllDashboardsCount();

        DashboardModel dashboardNoValid = new DashboardModel(null, null);
                DashboardSteps.createDashboardStep(dashboardNoValid)
                .statusCode(HTTP_BAD_REQUEST);

        int updatedTotalElementCount = DashboardSteps.getAllDashboardsCount();

        assertEquals(initialTotalElementCount, updatedTotalElementCount, "Количество dashboard'ов не должно измениться после неудачной попытки создания");
    }

}
