package praktikum;

import com.github.javafaker.Faker;

public class EnvConfig {
    public static final String BASE_URL = "https://demo.reportportal.io";

    public static final int EXPLICIT_WAIT = 5;
    public static final int PAUSE_HOVER = 600;

    public static Faker faker = new Faker();
    public static final String DASHBOARD_DESCRIPTION = faker.lorem().sentence(); //генератор случайного описания
    public static final String DASHBOARD_NAME = faker.name().username(); //генератор случайного имя DASHBOARD

    public static String projectName = "default_personal";
    public static String accessToken = "maksim_m0ocM0hyTfW6u2CvNdHnfhHKsMPfod-sCluzG1pXm5OxchaDmA2JvzXLOjlSK0-5";
    public static String username = "default";
    public static String password = "1q2w3e";
}

