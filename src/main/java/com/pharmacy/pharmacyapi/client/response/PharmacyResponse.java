package com.pharmacy.pharmacyapi.client.response;

import java.util.List;

import com.pharmacy.pharmacyapi.client.response.dto.Pharmacy;

import lombok.Data;

@Data
public class PharmacyResponse {
	
	private String status;
	private String message;
	private long systemTime;
	private int rowCount;
	private List<Pharmacy> data;

}
