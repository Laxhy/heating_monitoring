package eu.laxhy.heating.monitoring.domain;

import eu.laxhy.heating.monitoring.influxdb.SinglePoint;
import eu.laxhy.heating.monitoring.influxdb.Value;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Libor Laichmann.
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@SinglePoint
public class Weather {

  @NonNull
  @Value
  private Double temperature;

  @NonNull
  @Value
  private Integer pressure;

  @NonNull
  @Value
  private Integer humidity;

  @NonNull
  @Value
  private Integer windSpeed;


}
