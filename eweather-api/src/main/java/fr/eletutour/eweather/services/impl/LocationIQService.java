package fr.eletutour.eweather.services.impl;

import fr.eletutour.eweather.constantes.Constants;
import fr.eletutour.eweather.services.IApiService;
import fr.eletutour.eweather.services.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationIQService implements ILocationService {

    @Autowired
    private IApiService apiService;

    @Override
    public String callApi(String location) {
        return apiService.callApiWithUrl(Constants.getLocationiqUrl(location));
    }

    @Override
    public String callApi(String latitude, String longitude) {
        return apiService.callApiWithUrl(Constants.getLocationReverseGeocoding(latitude, longitude));
    }
}
