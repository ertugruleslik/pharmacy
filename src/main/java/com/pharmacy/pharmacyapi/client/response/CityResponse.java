package com.pharmacy.pharmacyapi.client.response;

import java.util.List;

import com.pharmacy.pharmacyapi.client.response.dto.City;
import lombok.Data;

@Data
public class CityResponse {

	private String status;
	private String message;
	private long systemTime;
	private int rowCount;
	private List<City> data;
	
}
