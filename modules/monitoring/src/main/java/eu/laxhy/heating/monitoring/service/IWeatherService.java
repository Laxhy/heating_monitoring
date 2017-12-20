package eu.laxhy.heating.monitoring.service;

import eu.laxhy.heating.monitoring.dto.WeatherDto;

/**
 * Created by Libor Laichmann.
 */
public interface IWeatherService {

    WeatherDto getWeatherInfo();

}
