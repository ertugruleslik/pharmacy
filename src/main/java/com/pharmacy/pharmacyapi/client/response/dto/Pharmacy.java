package com.pharmacy.pharmacyapi.client.response.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Pharmacy {

	@JsonProperty("EczaneAdi")
	private String name;

	@JsonProperty("Sehir")
	private String city;
	
	@JsonProperty("ilce")
	private String county;
	
	@JsonProperty("Semt")
	private String area;
	
	@JsonProperty("Adresi")
	private String address;
	
	@JsonProperty("YolTarifi")
	private String addressDescription;
	
	@JsonProperty("Telefon")
	private String phone1;

	@JsonProperty("Telefon2")
	private String phone2;
	
	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	private Double longitude;
	
	@JsonProperty("distanceMt")
	private Double distanceMt;
	
	@JsonProperty("distanceKm")
	private Double distanceKm;
	
	@JsonProperty("distanceMil")
	private Double distanceMil;
	
}
