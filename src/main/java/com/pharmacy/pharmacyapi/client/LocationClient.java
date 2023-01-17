package com.pharmacy.pharmacyapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacyapi.client.response.CityResponse;
import com.pharmacy.pharmacyapi.client.response.CountyResponse;


@FeignClient(name = "${feign.location.name}", url = "${feign.location.url}")
public interface LocationClient {

	@RequestMapping(method = RequestMethod.GET, value = "/city")
    CityResponse city(@RequestHeader(value = "Authorization") String accessKey);
	
	@RequestMapping(method = RequestMethod.GET, value = "/city")
    CountyResponse county(@RequestHeader(value = "Authorization") String accessKey, @RequestParam(value = "city") String city);
}
