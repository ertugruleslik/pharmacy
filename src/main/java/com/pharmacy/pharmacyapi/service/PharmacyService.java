package com.pharmacy.pharmacyapi.service;

import java.util.List;

import com.pharmacy.pharmacyapi.dto.PharmacyDto;

public interface PharmacyService {
	
	List<PharmacyDto> pharmacy(String city, String citySlug, String county, String countySlug, Long timestamp);
	
	List<PharmacyDto> pharmacy(Double longitute, Double latitude, Long timestamp);

}
