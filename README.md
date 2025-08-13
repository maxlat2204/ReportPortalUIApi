# Имя
ReportPortalUIApi

## Технологии
1. **Maven** 4.0.0
2. **Java** 11
3. **Junit** 5.9.3
4. **Rest-assured** 5.5.1
5. **Gson** 2.12.1
6. **Selenium-java** 4.32.0
7. **Webdrivermanager** 6.2.0
8. **Allure-junit5** 2.15.0
9. **Allure-rest-assured** 2.15.0
10. **Javafaker** 1.0.2
11. **Lombok** 1.18.38

## Запуск тестов через Chrome
```bash
mvn clean test
```

## Запуск тестов через Firefox браузер
```bash
mvn clean test -Dbrowser=firefox
```

## Запустить веб-сервер Allure (отчет Allure)
```bash
mvn allure:serve
```

## Если token api key устарел
Нужно создать API Key: по ссылке **https://demo.reportportal.io/ui/#userProfile/apiKeys** или перейти по пути **Profile → API Keys → Generate API Key**.
Скопировать токен созданного API Key и вставить в константу **API_KEY_TOKEN**, находящуюся в **src/main/java/praktikum/EnvConfig.java**.
