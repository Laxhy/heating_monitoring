package eu.laxhy.heating.monitoring.repository;

import eu.laxhy.heating.monitoring.domain.Weather;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Libor Laichmann.
 */
public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
