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
public class Weather {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private Date date;
    @NonNull
    private Double temperature;
    @NonNull
    private Integer pressure;
    @NonNull
    private Integer humidity;
    @NonNull
    private Integer windSpeed;

}
