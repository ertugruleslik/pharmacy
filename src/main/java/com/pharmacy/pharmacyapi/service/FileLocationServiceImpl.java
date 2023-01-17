package com.pharmacy.pharmacyapi.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.pharmacyapi.dto.FileDataDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class FileLocationServiceImpl implements FileLocationService {

	@Override
	public FileDataDto readFile() throws JsonProcessingException{

		StringBuilder sb = new StringBuilder();
		try {
			System.out.println("Reading file starting");
			
			InputStream in = getClass().getClassLoader().getResourceAsStream("eczane-api.json");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line + System.lineSeparator());
	        }
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			System.out.println("Reading file ended");
		}
		
		

		String context = sb.toString();

		ObjectMapper mapper = new ObjectMapper();
		FileDataDto fileData = mapper.readValue(context, FileDataDto.class);
		
		System.out.println("End");
		
		return fileData;
	}

}
