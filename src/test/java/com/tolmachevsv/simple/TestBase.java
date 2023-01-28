package com.tolmachevsv.simple;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tolmachevsv.config.CredentialsConfig;
import com.tolmachevsv.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {

        String login = credentials.login();
        String password = credentials.password();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        String remoteURL = System.getProperty("remoteUrl");
        System.out.println(remoteURL);
        Configuration.remote = format("https://%s:%s@%s", login, password, remoteURL);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
