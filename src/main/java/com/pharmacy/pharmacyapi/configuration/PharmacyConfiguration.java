package com.pharmacy.pharmacyapi.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pharmacy.pharmacyapi.dto.FileDataDto;
import com.pharmacy.pharmacyapi.service.FileLocationService;

@RequiredArgsConstructor
@Configuration
public class PharmacyConfiguration {

	private final FileLocationService fileLocationService;
	
	@Bean
	FileDataDto fileDataDto() throws JsonProcessingException {
		return fileLocationService.readFile();
	}

}
