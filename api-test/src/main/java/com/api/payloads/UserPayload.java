package com.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Getter
@Setter
@ToString
@Accessors(fluent = true)
public class UserPayload{
	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;
}
