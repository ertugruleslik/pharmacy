package com.pharmacy.pharmacyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pharmacy.pharmacyapi.dto.FileDataDto;

public interface FileLocationService {

	public FileDataDto readFile() throws JsonMappingException, JsonProcessingException;

}
