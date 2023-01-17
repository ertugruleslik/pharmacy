package com.pharmacy.pharmacyapi.service;

import com.pharmacy.pharmacyapi.client.LocationClient;
import com.pharmacy.pharmacyapi.client.response.CityResponse;
import com.pharmacy.pharmacyapi.client.response.CountyResponse;
import com.pharmacy.pharmacyapi.dto.CityDto;
import com.pharmacy.pharmacyapi.dto.CountyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationClient locationClient;

    @Value("${feign.location.accessKey}")
    private String accessKey;

    @Override
    public List<CityDto> city() {
        CityResponse cityResponse = locationClient.city(accessKey);

        if (cityResponse == null || CollectionUtils.isEmpty(cityResponse.getData())) {
            return Collections.emptyList();
        }

        return cityResponse.getData().stream()
                .map(city -> new CityDto(city.getName(), city.getSlug()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountyDto> county(String city) {
        CountyResponse countyResponse = locationClient.county(accessKey, city);

        if (countyResponse == null || CollectionUtils.isEmpty(countyResponse.getData())) {
            return Collections.emptyList();
        }

        return countyResponse.getData().stream()
                .map(county -> new CountyDto(county.getSlug(), county.getName()))
                .collect(Collectors.toList());
    }

}
