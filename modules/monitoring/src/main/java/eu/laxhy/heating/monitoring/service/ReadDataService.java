package eu.laxhy.heating.monitoring.service;

import eu.laxhy.heating.monitoring.domain.MeasureHeat;
import eu.laxhy.heating.monitoring.domain.TariffStatus;
import eu.laxhy.heating.monitoring.repository.MeasureHeatRepository;
import eu.laxhy.heating.monitoring.repository.TariffStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Libor Laichmann.
 * Sample class for reading data.
 */
@Service
@Slf4j
public class ReadDataService implements IReadDataService {

    @Autowired
    private MeasureHeatRepository measureHeatRepository;

    @Autowired
    private TariffStatusRepository tariffStatusRepository;

    @Autowired
    private IRoomDataService roomDataService;

    @Autowired
    private IHeatingSystemService heatingSystemService;

    @Override
    public void readAndStoreAllRoomsDataTemperature() {
        log.info("Start reading data for all rooms.");
        heatingSystemService.login();
        Date measureDate = new Date();

        Arrays.asList(Rooms.values()).forEach(room -> {
            String resultFloor = heatingSystemService.getHeatingInfo(room.getFloorOrder());
            log.info("Used result for floor: " + resultFloor);
            String resultRoom = heatingSystemService.getHeatingInfo(room.getRoomOrder());
            log.info("Used result for room: " + resultRoom);
            Double floorTemperature = roomDataService.getActualTemperature(resultFloor);
            Double floorSetTemperature = roomDataService.getSetTemperature(resultFloor);
            Double roomTemperature = roomDataService.getActualTemperature(resultRoom);
            Double roomSetTemperature = roomDataService.getSetTemperature(resultRoom);
            log.info(room.toString() + " air temperature: " + roomTemperature + " set: " + roomSetTemperature + " floor: " + floorTemperature + " set: " + floorSetTemperature);
            measureHeatRepository.save(new MeasureHeat(measureDate, room.toString(), roomTemperature, roomSetTemperature, floorTemperature, floorSetTemperature));
        });

        Tariff tariffState = heatingSystemService.getHDOTariff();
        log.info("Tariff: " + tariffState);
        tariffStatusRepository.save(new TariffStatus(measureDate, tariffState));

    }

}
