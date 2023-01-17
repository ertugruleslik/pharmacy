package com.pharmacy.pharmacyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDto {
	
	private String slug;
	private String name;

}
