package praktikum;

import com.github.javafaker.Faker;

public class EnvConfig {
    public static final String BASE_URL = "https://demo.reportportal.io";
    public static final int EXPLICIT_WAIT = 5;
    public static final int PAUSE_HOVER = 600;

    public static Faker faker = new Faker();
    public static final String DASHBOARD_DESCRIPTION = faker.lorem().sentence(); //генератор случайного описания
    public static final String DASHBOARD_NAME = faker.name().username(); //генератор случайного имя DASHBOARD
    public static String NAME_WIDGET = faker.name().name();//генератор случайного имя WIDGET

    //Токен из api key
    public static String API_KEY_TOKEN = "maksim_m0ocM0hyTfW6u2CvNdHnfhHKsMPfod-sCluzG1pXm5OxchaDmA2JvzXLOjlSK0-5";

    //Данные пользователя
    public static String PROJECT_NAME = "default_personal";
    public static String USER_LOGIN = "default";
    public static String USER_PASSWORD = "1q2w3e";

    //Работа с запросами
    public static final String PATH_PARAM_PROJECT_NAME = "projectName";
    public static final String PATH_PARAM_DASHBOARD_ID = "dashboardId";
    public static final String BODY_PATH_PAGE_TOTAL_ELEMENTS = "page.totalElements";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_BEARER = "Bearer ";
    public static final String BODY_PATH_ID = "id";

}

