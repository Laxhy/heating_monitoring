package eu.laxhy.heating.monitoring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Libor Laichmann.
 */
@Service
@Slf4j
public class RoomDataService implements IRoomDataService {

    @Override
    public Double getSetTemperature(String result) {
        return Double.valueOf(result.substring(23,27));
    }

    @Override
    public Double getActualTemperature(String result) {
        return Double.valueOf(result.substring(15,19));
    }
}
