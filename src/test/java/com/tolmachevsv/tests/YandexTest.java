package com.tolmachevsv.tests;

import com.tolmachevsv.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class YandexTest extends TestBase {

    @Test
    @Tag("properties")
    public void SimpleTest() {
        open("https://ya.ru");
        $("#text").sendKeys("Steam");
        $("#text").submit();
    }
}
