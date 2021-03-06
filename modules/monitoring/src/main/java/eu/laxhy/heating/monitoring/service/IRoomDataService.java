package eu.laxhy.heating.monitoring.service;

/**
 * Created by Libor Laichmann.
 */
public interface IRoomDataService {


    Double getSetTemperature(String result);

    Double getActualTemperature(String result);

    Boolean isHeatingOn(String result);

    Integer manualChange(String result);

}
