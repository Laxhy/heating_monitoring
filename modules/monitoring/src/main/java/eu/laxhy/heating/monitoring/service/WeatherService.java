package eu.laxhy.heating.monitoring.service;

import eu.laxhy.heating.monitoring.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Libor Laichmann.
 */
@Service
@Slf4j
public class WeatherService implements IWeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?appid=53659c3130d61fbf06b79ff300569522&lat=49.2232&lon=16.7515&units=metric";

    @Override
    public WeatherDto getWeatherInfo() {

        RestTemplate restTemplate = new RestTemplate();
        WeatherDto result = restTemplate.getForObject(WEATHER_URL, WeatherDto.class);
        log.info("Result" + result);
        return result;
    }
}
