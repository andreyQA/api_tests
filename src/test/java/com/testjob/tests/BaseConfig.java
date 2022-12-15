package com.testjob.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.testjob.helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseConfig {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://hh.ru/";
        Configuration.holdBrowserOpen = false;
        Configuration.browser = System.getProperty("browser", "chrome");

        //System.setProperty("browser_version","105");
        Configuration.browserVersion = System.getProperty("browser_version", "100");

        //System.setProperty("browser_size","1920x1080");
        Configuration.browserSize = System.getProperty("browser_size");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;

        String remoteUrl = System.getProperty("remote_url");
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            //Configuration.browserCapabilities = capabilities;
        }

    }
    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("screenshot");
        Attachments.pageSource();
        Attachments.consoleLogs();
        Attachments.addVideo();
    }
//    @AfterAll
//    void addVideo() {
//     Attachments.addVideo();
//    }
}
