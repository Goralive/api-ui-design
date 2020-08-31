package com.api.services;

import com.api.assertions.AssertableResponse;
import com.api.payloads.CreateUserPayload;
import com.api.payloads.UserPayload;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(CreateUserPayload userPayload) {
        return new AssertableResponse(setUp()
                .body(userPayload)
                .when()
                .post(""));
    }

    @Step("Get user id {}")
    public AssertableResponse getUser(int id) {
        return new AssertableResponse(setUp()
                .when()
                .get("/" + id));
    }

    @Step()
    public AssertableResponse patchUser(int id, HashMap<String, String> field) {
        return new AssertableResponse(setUp()
                .when()
                .body(field)
                .patch("/" + id));
    }

    @Step
    public AssertableResponse deleteUser(int id) {
        return new AssertableResponse(setUp()
                .when()
                .delete("/" + id));
    }
}
