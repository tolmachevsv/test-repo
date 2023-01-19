package com.tolmachevsv.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest extends TestBase {

    @Test
    public void SimpleTest() {
        open("https://ya.ru");
        $("#text").sendKeys("Steam");
        $("#text").submit();
    }
}
