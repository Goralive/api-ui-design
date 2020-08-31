package com.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchResponse{

	@JsonProperty("name")
	private String name;

	@JsonProperty("updatedAt")
	private String updatedAt;
}