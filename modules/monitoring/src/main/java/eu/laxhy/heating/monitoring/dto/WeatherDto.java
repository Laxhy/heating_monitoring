package eu.laxhy.heating.monitoring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * Created by Libor Laichmann.
 */
@Getter
@Setter
@ToString
public class WeatherDto {
    private Main main;
    private Wind wind;
}
