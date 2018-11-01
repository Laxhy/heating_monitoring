package eu.laxhy.heating.monitoring.scheduler;

import eu.laxhy.heating.monitoring.service.IReadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Libor Laichmann.
 */
@Service
@Slf4j
public class RoomsReadDataScheduler {

  @Autowired
  private IReadDataService dataService;

  @Scheduled(cron = "0/10 * * * * *")
  public void readAndStoreRoomsData() {
    dataService.readAndStoreAllRoomsDataTemperature();
  }

}
