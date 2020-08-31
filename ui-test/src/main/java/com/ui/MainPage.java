package com.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static MainPage open() {
        Selenide.open("");
        return new MainPage();
    }

    public LoginPage clickSignInBtn() {
        $("a.login").click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isLoginPage() {
        return WebDriverRunner.url().equals(Configuration.baseUrl);
    }
}
