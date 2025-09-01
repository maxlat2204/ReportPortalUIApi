package praktikum.APITest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import praktikum.EnvConfig;
import praktikum.dashboard.DashboardModel;

import static java.net.HttpURLConnection.HTTP_OK;
import static praktikum.dashboard.DashboardSteps.deleteDashboardStep;

public class BaseApiTest {
    protected int dashboardId;
    protected DashboardModel dashboard = DashboardModel.random();

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = EnvConfig.BASE_URL;
    }

    @AfterEach
    public void delUser(){
        if (dashboardId > 0){
            deleteDashboardStep(dashboardId)
                    .statusCode(HTTP_OK);
        }
    }
}
