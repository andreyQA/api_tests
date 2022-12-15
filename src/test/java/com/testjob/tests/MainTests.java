package com.testjob.tests;

import com.testjob.pages.ObjectPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTests extends BaseConfig {
    ObjectPage objectPage = new ObjectPage();
    @Owner("Andrey I")
    @Test
    @DisplayName("Проверка тайтла на главной")
    void testOpeningPage() {
        objectPage.openMainPage();
        objectPage.checkTextInTitle("Работа в Москве, поиск персонала и публикация вакансий - hh.ru");
    }
    @Disabled("Отключен потому что на странице находятся ошибки")
    @Test
    @DisplayName("Проверка критических ошибок в консоли на главной")
    void testConsoleLog() {
        objectPage.openMainPage();
        objectPage.checkErrorsInConsole("SEVERE");
    }
    @Test
    @DisplayName("Проверка перехода на страницу авторизации")
    void checkLoginButton() {
        objectPage.openMainPage();
        objectPage.clickOnButton("a[data-qa='login']");
        objectPage.checkTextInTitle("Вход в личный кабинет");
    }
    @Test
    @DisplayName("Проверка перехода на страницу регистрации")
    void checkSignUpButton() {
        objectPage.openMainPage();
        objectPage.clickOnButton("a[data-qa='signup']");
        objectPage.checkTextInTitle("Регистрация соискателя");
    }
    @Test
    @DisplayName("Проверка поиска вакансии")
    void checkSearchInput() {
        String query = "QA";
        objectPage.openMainPage();
        objectPage.setInfoToSearchField(query);
        objectPage.clickOnButton("button[data-qa='search-button']");
        objectPage.checkQueryOnVacanciesPage(query);
    }
}