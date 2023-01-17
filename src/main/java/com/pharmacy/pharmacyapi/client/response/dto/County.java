package com.pharmacy.pharmacyapi.client.response.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class County {

	@JsonProperty("ilceSlug")
	private String slug;
	
	@JsonProperty("ilceAd")
	private String name;

}
