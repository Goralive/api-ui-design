package com.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public void loginAs(String username, String password) {
        $("#email").setValue(username);
        $("#passwd").setValue(password);
        $("button#SubmitLogin").click();
    }

    public boolean isLogout() {
        return WebDriverRunner.url().contains("=authentication&back=my-account")
                && authenticationElem().isDisplayed();
    }

    public SelenideElement authenticationElem() {
        return $("h1.page-heading");
    }
}
