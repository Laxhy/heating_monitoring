package eu.laxhy.heating.monitoring.rest;

import eu.laxhy.heating.monitoring.service.IReadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Libor Laichmann.
 */
@RestController
@RequestMapping("/heating/monitoring/data")
@Slf4j
public class GetAllDataRest {

  @Autowired
  private IReadDataService readDataService;

  /**
   * @return list of dashboard widgets
   */
  @GetMapping
  public String getDashboardWidgets() {
    log.info("Received GET request for dashboard widgets");
    readDataService.readAndStoreAllRoomsDataTemperature();
    return "Test data";
  }
}
