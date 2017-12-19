package eu.laxhy.heating.monitoring.repository;

import eu.laxhy.heating.monitoring.domain.TariffStatus;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Libor Laichmann.
 */
public interface TariffStatusRepository extends CrudRepository<TariffStatus, Long> {

}
