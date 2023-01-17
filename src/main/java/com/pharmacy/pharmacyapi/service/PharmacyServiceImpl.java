package com.pharmacy.pharmacyapi.service;

import com.pharmacy.pharmacyapi.client.NightPharmacyClient;
import com.pharmacy.pharmacyapi.client.response.PharmacyResponse;
import com.pharmacy.pharmacyapi.converter.PharmacyDtoConverter;
import com.pharmacy.pharmacyapi.dto.FileDataDto;
import com.pharmacy.pharmacyapi.dto.FilePharmacyCityDto;
import com.pharmacy.pharmacyapi.dto.PharmacyDto;
import com.pharmacy.pharmacyapi.util.DistanceCalculater;
import com.pharmacy.pharmacyapi.util.MapUtil;
import com.pharmacy.pharmacyapi.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {

    private final NightPharmacyClient nightPharmacyClient;
    private final FileDataDto fileDataDto;
    private final PharmacyDtoConverter pharmacyDtoConverter;

    @Value("${feign.night-pharmacy.accessKey}")
    private String nightPharmacyAccessKey;

    @Override
    public List<PharmacyDto> pharmacy(String city, String citySlug, String county, String countySlug, Long timestamp) {
        if (TimeUtil.isOutOfWorkingHour(timestamp)) {
            PharmacyResponse pharmacyResponse = nightPharmacyClient.pharmacy(nightPharmacyAccessKey, citySlug, countySlug);
            if (pharmacyResponse == null || CollectionUtils.isEmpty(pharmacyResponse.getData())) {
                return Collections.emptyList();
            }
            return pharmacyResponse
                    .getData()
                    .stream()
                    .map(pharmacyDtoConverter::convert)
                    .collect(Collectors.toList());
        } else {
            List<FilePharmacyCityDto> filePharmacyCityList = fileDataDto.getData();

            List<PharmacyDto> pharmacyDtoList = new ArrayList<>();

            filePharmacyCityList.stream()
                    .filter(pharmacyCity -> pharmacyCity.getCityName().equals(city))
                    .forEach(filePharmacyCityDto -> filePharmacyCityDto.getArea().forEach(filePharmacyAreaDto -> {
                        if (filePharmacyAreaDto.getAreaName().equals(county) && (!CollectionUtils.isEmpty(filePharmacyAreaDto.getPharmacy()))) {
                            filePharmacyAreaDto.getPharmacy().forEach(filePharmacyDto -> {
                                PharmacyDto pharmacyDto = pharmacyDtoConverter.convert(filePharmacyCityDto.getCityName(), filePharmacyAreaDto, filePharmacyDto);
                                pharmacyDtoList.add(pharmacyDto);
                            });
                        }
                    }));
            return pharmacyDtoList;
        }
    }

    @Override
    public List<PharmacyDto> pharmacy(Double longitude, Double latitude, Long timestamp) {
        if (TimeUtil.isOutOfWorkingHour(timestamp)) {
            PharmacyResponse pharmacyResponse = nightPharmacyClient.pharmacy(nightPharmacyAccessKey, latitude, longitude);
            return pharmacyResponse.getData()
                    .stream()
                    .map(pharmacyDtoConverter::convert)
                    .collect(Collectors.toList());
        } else {
            List<FilePharmacyCityDto> filePharmacyCityList = fileDataDto.getData();

            List<PharmacyDto> pharmacyDtoList = new ArrayList<>();

            filePharmacyCityList.forEach(filePharmacyCityDto -> filePharmacyCityDto.getArea().forEach(filePharmacyAreaDto -> {
                        if (!CollectionUtils.isEmpty(filePharmacyAreaDto.getPharmacy())) {
                            filePharmacyAreaDto.getPharmacy().forEach(filePharmacyDto -> {
                                if (betweenLongituteAndLatitude(longitude, latitude, filePharmacyDto.getMaps())) {
                                    PharmacyDto pharmacyDto = pharmacyDtoConverter.convert(longitude, latitude, filePharmacyCityDto.getCityName(), filePharmacyAreaDto, filePharmacyDto);
                                    pharmacyDtoList.add(pharmacyDto);
                                }
                            });
                        }
                    }

            ));
            return pharmacyDtoList;
        }
    }


    private boolean betweenLongituteAndLatitude(Double reqLongitude, Double reqLatitude, String map) {
        if (map == null || "".equals(map)) {
            return false;
        }

        double longitude = MapUtil.getLongitude(map);
        double latitude = MapUtil.getLatitude(map);
        double distance = DistanceCalculater.distance(latitude, longitude, reqLatitude, reqLongitude, 'K');
        return distance < 1;
    }
}
