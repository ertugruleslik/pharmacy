package com.pharmacy.pharmacyapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.pharmacyapi.dto.CityDto;
import com.pharmacy.pharmacyapi.dto.CountyDto;
import com.pharmacy.pharmacyapi.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LocationController {
	
	private final LocationService locationService;

	@GetMapping(value = "/city")
	public List<CityDto> city() {
		return locationService.city();
	}
	
	@GetMapping(value = "/county")
	public List<CountyDto> county(@RequestParam(value = "city") String city) {
		return locationService.county(city);
	}
}
