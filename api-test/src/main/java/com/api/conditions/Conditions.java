package com.api.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }

    public BodyFieldCondition bodyField(String jsonPath, Matcher matcher){
        return new BodyFieldCondition(jsonPath, matcher);
    }
}
