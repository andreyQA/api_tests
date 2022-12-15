# <img width="4%" title="Allure TestOPS" src="images/logo/hh.ru__min_.svg"> Проект по автоматизации тестирования сайта hh.ru

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованные проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)


## :technologist: Технологии и инструменты

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins_logo.svg"></code>
<code><img width="5%" title="Jira" src="images/logo/Jira.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>


## :bookmark_tabs: Реализованные проверки:
### UI Tests

- Проверка результатов поиска работы 
- Проверка отображаения блока сервисов для соискателей 
- Проверка отображения дашборда с вакансиями
- Проверка отображения главной страницы 

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
gradle clean test
```

### Удаленный запуск тестов

```bash
gradle clean test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DremoteUrl=${remoteUrl}
-Dthreads=${THREADS}
```

## Параметры сборки

 <code>browser</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).

 <code>browserVersion</code> – версия браузера (_по умолчанию - <code>100</code>_).

 <code>browserSize</code> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).

 <code>remoteUrl</code> – логин, пароль и адрес удаленного сервера Selenoid (_по умолчанию указаны в сборке Jenkins_).

 <code>THREADS</code> - параллельный запуск тестов (_по умолчанию - <code>5</code>_).

## <img width="4%" title="Jenkins" src="images/logo/Jenkins_logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/C15-AndreyI11-Lesson15/)

Для запуска сборки необходимо нажать кнопку <code><strong>*Собрать с параметрами*</strong></code> указать значения параметров.

<p align="center">
  <img src="images/jenkins.png" alt="Jenkins" width="900">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report*, кликнув по которому, откроется страница с сформированным html-отчетом.

<p align="center">
  <img src="images/allure-report.png" alt="allure-report" width="900">
</p>


## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/C15-AndreyI11-Lesson15/15/allure/)

<p align="center">
  <img src="images/allure-report-page.png" alt="allure-report1" width="900">
</p>



## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/17638/)

### <p style="margin-left: 40px">Основной дашборд</p>

<p align="center">
  <img src="images/dashboard.png" alt="dashboard" width="900">
</p>
 
### <p style="margin-left: 40px">Тест-кейсы</p>

<p align="center">
  <img src="images/test-cases.png" alt="testcase" width="900">
</p>

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-468)

<p align="center">
  <img src="images/jira.png" alt="jira" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки бот отправляет отчет о прохождении тестов.

<p align="center">
<img src="images/telegram.png" alt="Telegram" width="900">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

К каждому тесту в отчете прилагается видео.

<p align="center">
  <img title="Selenoid Video" src="images/gif/test.gif">
</p>