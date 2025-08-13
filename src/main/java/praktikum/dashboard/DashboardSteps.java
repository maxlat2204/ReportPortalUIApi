package praktikum.dashboard;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import praktikum.EndPoints;
import praktikum.EnvConfig;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class DashboardSteps {

    @Step("Создать Dashboard")
    public static ValidatableResponse createDashboardStep(DashboardModel dashboard) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().basic(EnvConfig.USER_LOGIN, EnvConfig.USER_PASSWORD)
                .header(EnvConfig.HEADER_AUTHORIZATION, EnvConfig.HEADER_BEARER + EnvConfig.API_KEY_TOKEN)
                .pathParam(EnvConfig.PATH_PARAM_PROJECT_NAME, EnvConfig.PROJECT_NAME)
                .body(dashboard)
                .when()
                .post(EndPoints.CREATE_DASHBOARD_PATH)
                .then().log().all();
    }


    @Step("Удалить Dashboard")
    public static ValidatableResponse deleteDashboardStep(int dashboardId) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().basic(EnvConfig.USER_LOGIN, EnvConfig.USER_PASSWORD)
                .header(EnvConfig.HEADER_AUTHORIZATION, EnvConfig.HEADER_BEARER + EnvConfig.API_KEY_TOKEN)
                .pathParams(EnvConfig.PATH_PARAM_PROJECT_NAME, EnvConfig.PROJECT_NAME,
                        EnvConfig.PATH_PARAM_DASHBOARD_ID, String.valueOf(dashboardId))
                .when()
                .delete(EndPoints.GET_DASHBOARD_ID_PATH)
                .then().log().all();
    }

    @Step("Посмотреть, что Dashboard появился в списке Dashboard-ов")
    public static ValidatableResponse getDashboardStep(int dashboardId) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().basic(EnvConfig.USER_LOGIN, EnvConfig.USER_PASSWORD)
                .header(EnvConfig.HEADER_AUTHORIZATION, EnvConfig.HEADER_BEARER + EnvConfig.API_KEY_TOKEN)
                .pathParams(EnvConfig.PATH_PARAM_PROJECT_NAME, EnvConfig.PROJECT_NAME,
                        EnvConfig.PATH_PARAM_DASHBOARD_ID, String.valueOf(dashboardId))
                .when()
                .get(EndPoints.GET_DASHBOARD_ID_PATH)
                .then().log().all();
    }

    @Step("Посмотреть, весь список Dashboard-ов")
    public static ValidatableResponse getAllDashboardStep() {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().basic(EnvConfig.USER_LOGIN, EnvConfig.USER_PASSWORD)
                .header(EnvConfig.HEADER_AUTHORIZATION, EnvConfig.HEADER_BEARER + EnvConfig.API_KEY_TOKEN)
                .pathParams(EnvConfig.PATH_PARAM_PROJECT_NAME, EnvConfig.PROJECT_NAME)
                .when()
                .get(EndPoints.CREATE_DASHBOARD_PATH)
                .then().log().all();
    }

    @Step("Вернуть количество всех Dashboard-ов")
    public static int getAllDashboardsCount() {
        return getAllDashboardStep()
                .statusCode(HTTP_OK)
                .extract()
                .path(EnvConfig.BODY_PATH_PAGE_TOTAL_ELEMENTS);
    }

}
