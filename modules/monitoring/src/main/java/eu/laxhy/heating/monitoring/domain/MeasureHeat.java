package eu.laxhy.heating.monitoring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Libor Laichmann.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class MeasureHeat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private Date date;
    @NonNull
    private String room;
    @NonNull
    private Double temperatureAir;
    @NonNull
    private Double temperatureSetAir;
    @NonNull
    private Double temperatureFloor;
    @NonNull
    private Double temperatureSetFloor;


}
