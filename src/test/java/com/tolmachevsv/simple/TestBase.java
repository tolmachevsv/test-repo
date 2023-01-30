package com.tolmachevsv.simple;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tolmachevsv.config.CredentialsConfig;
import com.tolmachevsv.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

@Tag("properties")
public class TestBase {

    @BeforeAll
    static void beforeAll() {
        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);

        String login = credentials.login();
        String password = credentials.password();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub");
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "3840x2160");
        System.out.println(url);
        System.out.println(browserSize);
        System.out.println(browser);

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.remote = format("https://%s:%s@%s", login, password, url);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
