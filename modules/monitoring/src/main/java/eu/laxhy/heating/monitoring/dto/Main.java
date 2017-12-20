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
public class Main {
    private Double temp;
    private Integer pressure;
    private Integer humidity;
    private Integer temp_min;
    private Integer temp_max;
}
