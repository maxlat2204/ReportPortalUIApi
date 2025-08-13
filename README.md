# Имя
ReportPortalUIApi

## Технологии
1. **Maven** 4.0.0
2. **Java** 11
3. **Junit** 5.10.2
4. **Rest-assured** 
5. **Gson** 
6. **Selenium-java** 4.32.0
7. **Webdrivermanager** 6.2.0
8. **Allure-junit5** 2.15.0
9. **Allure-rest-assured**
10. **Javafaker**
11. **Lombok**

## Запуск тестов через Chrome
```bash
mvn clean test
```

## Запуск тестов через Firefox браузер
```bash
mvn clean test -Dbrowser=firefox
```

## Данные отчёта всегда отображаются после запуска тестов. Они находятся в папке /target/allure-results/. Вы можете создать отчёт с помощью:
```bash
mvn allure:serve
```