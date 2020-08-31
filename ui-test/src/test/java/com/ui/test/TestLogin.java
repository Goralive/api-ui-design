package com.ui.test;

import com.codeborne.selenide.Condition;
import com.api.payloads.UserPayload;
import com.api.services.UserApiService;
import com.ui.LoggedUserPage;
import com.ui.LoginPage;
import com.ui.MainPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestLogin extends BaseUITest {
    UserPayload userPayload;

    @BeforeTest
    public void createUser() {
        userPayload = new UserPayload()
                .email("demo321@gmail.com")
                .password("123456");
    }

    private LoggedUserPage loginWithUser() {
        MainPage.open()
                .clickSignInBtn()
                .loginAs(userPayload.email(), userPayload.password());
        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
        loggedUserPage.logoutBtn().shouldHave(Condition.text("Sign out"));
        loggedUserPage.userName().shouldHave(Condition.text("Bobby Charlton"));
        return loggedUserPage;
    }

    @Test
    public void userCanLoginWithValidCredentialsAndLogoutViaUI() {
        loginWithUser().logoutBtn().click();

        LoginPage loginPage = at(LoginPage.class);
        loginPage.authenticationElem().shouldHave(Condition.text("Authentication"));
        Assert.assertTrue(loginPage.isLogout());
    }

    @Test
    public void userCanLoginWithValidCredentialsAndLogoutUsingURI() {
        MainPage mainPage = loginWithUser().logoutViaUrl();
        Assert.assertTrue(mainPage.isLoginPage());
    }
}
