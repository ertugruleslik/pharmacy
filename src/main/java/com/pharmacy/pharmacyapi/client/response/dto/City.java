package com.pharmacy.pharmacyapi.client.response.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class City {

	@JsonProperty("SehirSlug")
	private String slug;
	
	@JsonProperty("SehirAd")
	private String name;

}
