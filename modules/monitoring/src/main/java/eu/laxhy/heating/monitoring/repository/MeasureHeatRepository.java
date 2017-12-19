package eu.laxhy.heating.monitoring.repository;

import eu.laxhy.heating.monitoring.domain.MeasureHeat;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Libor Laichmann.
 */
public interface MeasureHeatRepository extends CrudRepository<MeasureHeat, Long> {

}
