package eu.laxhy.heating.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Laxhy
 */
@ComponentScan(basePackages = {"eu.laxhy.heating.monitoring"})
@SpringBootApplication
@EnableScheduling
public class Application {

  /**
   * Entry point of the application
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}


