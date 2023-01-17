package com.pharmacy.pharmacyapi.client.response;

import java.util.List;

import com.pharmacy.pharmacyapi.client.response.dto.County;

import lombok.Data;

@Data
public class CountyResponse {

	private String status;
	private String message;
	private long systemTime;
	private int rowCount;
	private List<County> data;
	
}
