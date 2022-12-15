package com.testjob.pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class ObjectPage {
    public ObjectPage openMainPage() {
        step("Открыть url hh.ru", () ->
                open("/"));
    return this;
    }
    public ObjectPage checkTextInTitle(String title) {
        step("Заголовок страницы должен содержать текст " + title, () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(title);
        });
    return this;
    }
    public ObjectPage checkErrorsInConsole(String errorText) {
        step("В консоли не должно быть ошибок типа " + errorText, () -> {

            String consoleLogs = String.join("\n", Selenide.getWebDriverLogs(BROWSER));

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    return this;
    }
    public ObjectPage clickOnButton(String selector) {
        step("Нажатие на " + selector, () -> {
            $(selector).click();
        });
    return this;
    }
    public ObjectPage setInfoToSearchField(String query) {
            step("Ввод " + query +  " в поле поиска", () ->
                $("input[data-qa='search-input']").setValue(query));
        return this;
        }
    public ObjectPage checkQueryOnVacanciesPage(String query) {
        step("Проверка заголовка первой вакансии на наличие текста запроса", () ->
                $("a[data-qa='serp-item__title']").shouldHave(text(query)));
        return this;
        }
    }
