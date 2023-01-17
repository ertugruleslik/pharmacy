package com.pharmacy.pharmacyapi.converter;

import com.pharmacy.pharmacyapi.client.response.dto.Pharmacy;
import com.pharmacy.pharmacyapi.dto.FilePharmacyAreaDto;
import com.pharmacy.pharmacyapi.dto.FilePharmacyDto;
import com.pharmacy.pharmacyapi.dto.PharmacyDto;
import com.pharmacy.pharmacyapi.util.DistanceCalculater;
import com.pharmacy.pharmacyapi.util.MapUtil;
import org.springframework.stereotype.Service;

@Service
public class PharmacyDtoConverter {

    public PharmacyDto convert(String cityName, FilePharmacyAreaDto filePharmacyAreaDto, FilePharmacyDto filePharmacyDto) {
        return PharmacyDto.builder()
                .name(filePharmacyDto.getName())
                .city(cityName)
                .county(filePharmacyAreaDto.getAreaName())
                .area(filePharmacyAreaDto.getAreaName())
                .address(filePharmacyDto.getAddress())
                .addressDescription(filePharmacyDto.getAddress())
                .phone1(filePharmacyDto.getPhone())
                .longitude(MapUtil.getLongitude(filePharmacyDto.getMaps()))
                .latitude(MapUtil.getLatitude(filePharmacyDto.getMaps()))
                .build();
    }

    public PharmacyDto convert(Double reqLongitude, Double reqLatitude, String cityName, FilePharmacyAreaDto filePharmacyAreaDto, FilePharmacyDto filePharmacyDto) {
        return PharmacyDto.builder()
                .name(filePharmacyDto.getName())
                .city(cityName)
                .county(filePharmacyAreaDto.getAreaName())
                .area(filePharmacyAreaDto.getAreaName())
                .address(filePharmacyDto.getAddress())
                .addressDescription(filePharmacyDto.getAddress())
                .phone1(filePharmacyDto.getPhone())
                .longitude(MapUtil.getLongitude(filePharmacyDto.getMaps()))
                .latitude(MapUtil.getLatitude(filePharmacyDto.getMaps()))
                .distanceKm(DistanceCalculater.distance(MapUtil.getLatitude(filePharmacyDto.getMaps()), MapUtil.getLongitude(filePharmacyDto.getMaps()), reqLatitude, reqLongitude, 'K'))
                .distanceMil(DistanceCalculater.distance(MapUtil.getLatitude(filePharmacyDto.getMaps()), MapUtil.getLongitude(filePharmacyDto.getMaps()), reqLatitude, reqLongitude, 'M'))
                .build();
    }

    public PharmacyDto convert(Pharmacy pharmacy) {
        return PharmacyDto.builder()
                .name(pharmacy.getName())
                .city(pharmacy.getCity())
                .county(pharmacy.getCounty())
                .area(pharmacy.getArea())
                .address(pharmacy.getAddress())
                .addressDescription(pharmacy.getAddressDescription())
                .phone1(pharmacy.getPhone1())
                .phone2(pharmacy.getPhone2())
                .longitude(pharmacy.getLongitude())
                .latitude(pharmacy.getLatitude())
                .distanceMt(pharmacy.getDistanceMt())
                .distanceKm(pharmacy.getDistanceKm())
                .distanceMil(pharmacy.getDistanceMil())
                .build();
    }

}
