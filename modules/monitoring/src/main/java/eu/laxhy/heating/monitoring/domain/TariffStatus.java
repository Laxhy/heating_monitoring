package eu.laxhy.heating.monitoring.domain;

import eu.laxhy.heating.monitoring.service.Tariff;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class TariffStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private Date date;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Tariff state;

}
