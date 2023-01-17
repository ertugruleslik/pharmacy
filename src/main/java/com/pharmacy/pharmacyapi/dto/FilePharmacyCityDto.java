package com.pharmacy.pharmacyapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FilePharmacyCityDto {

	@JsonProperty("CityID")
	private String CityID;

	@JsonProperty("CityName")
	private String CityName;
	
	private String countPharmacy;
	
	private List<FilePharmacyAreaDto> area;

}
