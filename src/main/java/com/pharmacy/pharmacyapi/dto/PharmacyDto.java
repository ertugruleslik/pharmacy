package com.pharmacy.pharmacyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PharmacyDto {
	
	private String name;
	private String city;
	private String county;
	private String area;
	private String address;
	private String addressDescription;
	private String phone1;
	private String phone2;
	private Double longitude;
	private Double latitude;
	private Double distanceMt;
	private Double distanceKm;
	private Double distanceMil;
	

}
