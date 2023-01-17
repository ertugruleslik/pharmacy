package com.pharmacy.pharmacyapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacyapi.client.response.PharmacyResponse;

@FeignClient(name = "${feign.night-pharmacy.name}", url = "${feign.night-pharmacy.url}")
public interface NightPharmacyClient {
	
	@RequestMapping(method = RequestMethod.GET)
	PharmacyResponse pharmacy(@RequestHeader(value = "Authorization") String accessKey, @RequestParam(value = "city") String city, @RequestParam(value = "county", required = false) String county);

	@RequestMapping(method = RequestMethod.GET, value = "/distance")
	PharmacyResponse pharmacy(@RequestHeader(value = "Authorization") String accessKey, @RequestParam(value = "latitude") Double latitude, @RequestParam(value = "longitude") Double longitude);
	
}
