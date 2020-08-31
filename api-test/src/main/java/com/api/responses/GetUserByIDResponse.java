package com.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserByIDResponse{

	@JsonProperty("ad")
	private Ad ad;

	@JsonProperty("data")
	private Data data;
}