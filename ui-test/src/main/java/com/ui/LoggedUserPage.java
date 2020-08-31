package com.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {
    public SelenideElement logoutBtn(){
        return $("a.logout");
    }

    public SelenideElement userName(){
        return $("a.account > span");
    }

    public MainPage logoutViaUrl() {
        Selenide.open("?mylogout");
        return Selenide.page(MainPage.class);
    }
}
