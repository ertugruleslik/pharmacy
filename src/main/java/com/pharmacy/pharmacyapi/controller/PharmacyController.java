package com.pharmacy.pharmacyapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.pharmacyapi.dto.PharmacyDto;
import com.pharmacy.pharmacyapi.service.PharmacyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PharmacyController {
	
	private final PharmacyService pharmacyService;
	
	@GetMapping(value = "/pharmacy")
	public List<PharmacyDto> pharmacy(@RequestParam(value = "city") String city, @RequestParam(value = "citySlug") String citySlug, @RequestParam(value = "county", required = false) String county, @RequestParam(value = "countySlug", required = false) String countySlug, @RequestParam(value = "timestamp", required = false) Long timestamp){
		return pharmacyService.pharmacy(city, citySlug, county, countySlug, timestamp);
	}
	
	@GetMapping(value = "/pharmacy/location")
	public List<PharmacyDto> pharmacy(@RequestParam(value = "longitute") Double longitute, @RequestParam(value = "latitude") Double latitude, @RequestParam(value = "timestamp", required = false) Long timestamp){
		return pharmacyService.pharmacy(longitute, latitude, timestamp);
	}
	
}