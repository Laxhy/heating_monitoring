package eu.laxhy.heating.monitoring.service;

import eu.laxhy.heating.monitoring.domain.MeasureHeat;
import eu.laxhy.heating.monitoring.domain.LowTariffStatus;
import eu.laxhy.heating.monitoring.domain.Weather;
import eu.laxhy.heating.monitoring.dto.WeatherDto;
import eu.laxhy.heating.monitoring.influxdb.InfluxDbStorageEngine;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Libor Laichmann. Sample class for reading data.
 */
@Service
@Slf4j
public class ReadDataService implements IReadDataService {

  @Autowired
  private IRoomDataService roomDataService;

  @Autowired
  private IHeatingSystemService heatingSystemService;

  @Autowired
  private IWeatherService weatherService;

  @Autowired
  private InfluxDbStorageEngine influxDbStorageEngine;

  @Override
  public void readAndStoreAllRoomsDataTemperature() {
    log.info("Start reading data for all rooms.");
    heatingSystemService.login();

    Arrays.asList(Room.values()).forEach(room -> {
      String resultFloor = heatingSystemService.getHeatingInfo(room.getFloorOrder());
      log.info("Used result for floor: " + resultFloor);
      String resultRoom = heatingSystemService.getHeatingInfo(room.getRoomOrder());
      log.info("Used result for room: " + resultRoom);
      Double floorTemperature = roomDataService.getActualTemperature(resultFloor);
      Double floorSetTemperature = roomDataService.getSetTemperature(resultFloor);
      Double roomTemperature = roomDataService.getActualTemperature(resultRoom);
      Double roomSetTemperature = roomDataService.getSetTemperature(resultRoom);
      boolean isHeatingOn = roomDataService.isHeatingOn(resultFloor);
      Integer manualChange = roomDataService.manualChange(resultRoom);
      log.info(room.toString() + " air temperature: " + roomTemperature + " set: " + roomSetTemperature +
          " floor: " + floorTemperature + " set: " + floorSetTemperature +
          " is heating on: " + isHeatingOn + " manual change: " + manualChange);
      MeasureHeat measureHeat = new MeasureHeat(room.toString(), roomTemperature, roomSetTemperature, floorTemperature, floorSetTemperature, isHeatingOn, manualChange);
      try {
        influxDbStorageEngine.store(measureHeat);
      } catch (IllegalAccessException e) {
        log.error("Problem with storage temperature...", e);
      }
    });

    Tariff tariffState = heatingSystemService.getHDOTariff();
    log.info("Tariff: " + tariffState);
    try {
      influxDbStorageEngine.store(new LowTariffStatus(tariffState.equals(Tariff.LOW)));
    } catch (IllegalAccessException e) {
      log.error("Problem with storage tariff...", e);
    }

    WeatherDto weatherDto = weatherService.getWeatherInfo();
    try {
      influxDbStorageEngine.store(new Weather(weatherDto.getMain().getTemp(), weatherDto.getMain().getPressure(), weatherDto.getMain().getHumidity(), weatherDto.getWind().getSpeed()));
    } catch (IllegalAccessException e) {
      log.error("Problem with storage weather...", e);
    }
  }

}
