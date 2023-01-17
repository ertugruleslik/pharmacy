package com.pharmacy.pharmacyapi.dto;

import java.util.List;

import lombok.Data;

@Data
public class FilePharmacyAreaDto {

	private String areaName;
	private String countPharmacy;
	private List<FilePharmacyDto> pharmacy;
	
}
