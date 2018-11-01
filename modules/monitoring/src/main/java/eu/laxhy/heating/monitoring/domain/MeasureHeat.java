package eu.laxhy.heating.monitoring.domain;

import eu.laxhy.heating.monitoring.influxdb.SinglePoint;
import eu.laxhy.heating.monitoring.influxdb.Tag;
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
@SinglePoint(value = "MeasureHeat")
public class MeasureHeat {

  @NonNull
  @Tag
  private String room;
  @NonNull
  @Value
  private Double temperatureAir;
  @NonNull
  @Value
  private Double temperatureSetAir;
  @NonNull
  @Value
  private Double temperatureFloor;
  @NonNull
  @Value
  private Double temperatureSetFloor;
  @NonNull
  @Value
  private Boolean heatingOn;
  @NonNull
  @Value
  private Integer manualChange;

}
