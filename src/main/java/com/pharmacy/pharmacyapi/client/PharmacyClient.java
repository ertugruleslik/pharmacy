package com.pharmacy.pharmacyapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacyapi.client.response.PharmacyResponse;

@FeignClient(name = "${feign.pharmacy.name}", url = "${feign.pharmacy.url}")
public interface PharmacyClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	PharmacyResponse pharmacy(@RequestHeader(value = "Authorization") String accessKey, @RequestParam(value = "city") String city, @RequestParam(value = "county", required = false) String county);

}
