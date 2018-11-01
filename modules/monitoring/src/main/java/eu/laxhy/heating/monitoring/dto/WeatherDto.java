package eu.laxhy.heating.monitoring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
