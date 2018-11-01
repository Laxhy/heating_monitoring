package eu.laxhy.heating.monitoring.domain;

import eu.laxhy.heating.monitoring.influxdb.SinglePoint;
import eu.laxhy.heating.monitoring.influxdb.Value;
import eu.laxhy.heating.monitoring.service.Tariff;
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
public class LowTariffStatus {

  @NonNull
  @Value
  private Boolean low;

}
