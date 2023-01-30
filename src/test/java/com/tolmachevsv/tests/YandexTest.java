package com.tolmachevsv.tests;

import com.tolmachevsv.simple.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest extends TestBase {

    @Test
    @Tag("properties")
    public void SimpleTest() {
        open("https://github.com");
        $("#text").sendKeys("Steam");
        $("#text").submit();
    }
}
