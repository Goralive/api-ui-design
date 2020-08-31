package com.api.test;

import com.api.payloads.CreateUserPayload;
import com.api.responses.GetUserByIDResponse;
import com.api.responses.PatchResponse;
import com.api.responses.UserCreatedResponse;
import com.github.javafaker.Faker;
import com.api.ProjectConfig;
import com.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.api.conditions.Conditions.bodyField;
import static com.api.conditions.Conditions.statusCode;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public class UserTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrlAPI();
        faker = new Faker();
    }


    @Test
    public void shouldRegisterNewUser() {
        CreateUserPayload userPayload = new CreateUserPayload()
                .name(faker.name().username())
                .job(faker.job().title());

        userApiService.registerUser(userPayload)
                .shouldHave(statusCode(SC_CREATED))
                .shouldHave(bodyField("id", not(isEmptyOrNullString())))
                .shouldHave(bodyField("createdAt", not(isEmptyOrNullString())))
                .shouldHave(bodyField("name", equalTo(userPayload.name())))
                .shouldHave(bodyField("job", equalTo(userPayload.job())))
                .asPojo(UserCreatedResponse.class);
    }

    @Test
    public void getSingleUserByID() {
        userApiService
                .getUser(5)
                .shouldHave(statusCode(SC_OK))
                .asPojo(GetUserByIDResponse.class);
    }

    @Test
    public void patchSingleUserByID() {
        HashMap<String, String> updateUser = new HashMap<>();
        updateUser.put("name", "Igor");
        userApiService
                .patchUser(5, updateUser)
                .shouldHave(statusCode(SC_OK))
                .asPojo(PatchResponse.class);
    }

    @Test
    public void deleteSingeUserByID() {
        userApiService
                .deleteUser(5)
                .shouldHave(statusCode(SC_NO_CONTENT));
    }
}
