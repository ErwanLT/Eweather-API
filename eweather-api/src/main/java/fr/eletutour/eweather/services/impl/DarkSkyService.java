package fr.eletutour.eweather.services.impl;

import fr.eletutour.eweather.constantes.Constants;
import fr.eletutour.eweather.services.IApiService;
import fr.eletutour.eweather.services.IDarkSkyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class DarkSkyService implements IDarkSkyService {
    @Autowired
    private IApiService apiService;

    @Override
    public String callApi(String latitude, String longitude) {
        return apiService.callApiWithUrl(Constants.getDarkSkyUrl(latitude, longitude));

    }
}
