package com.api.assertions;

import com.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {
    private final Response response;

    @Step("API respose should have {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("Check condition {} " , condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass){
        return response.as(tClass);
    }

    public Headers headers(){
        return response.getHeaders();
    }
}
