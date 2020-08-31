package com.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ad{

	@JsonProperty("company")
	private String company;

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;

}