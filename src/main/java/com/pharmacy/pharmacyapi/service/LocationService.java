package com.pharmacy.pharmacyapi.service;

import java.util.List;

import com.pharmacy.pharmacyapi.dto.CityDto;
import com.pharmacy.pharmacyapi.dto.CountyDto;

public interface LocationService {

    List<CityDto> city();
	
    List<CountyDto> county(String city);

}
