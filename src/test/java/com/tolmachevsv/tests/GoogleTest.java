package com.tolmachevsv.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void SimpleTest() {
        open("https://google.com");
        $(".gLFyf").setValue("Steam");
        $(".gLFyf").submit();
    }
}
