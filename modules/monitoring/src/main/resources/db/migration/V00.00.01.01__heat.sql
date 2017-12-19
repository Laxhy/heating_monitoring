-- -----------------------------------------------------
-- Table `measure_heat`
-- -----------------------------------------------------
CREATE TABLE measure_heat (
  `id`                     BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `date`                   DATETIME(3)     NOT NULL,
  `room`                   VARCHAR(128) NOT NULL,
  `temperature_air`            FLOAT,
  `temperature_set_air`        FLOAT,
  `temperature_floor`          FLOAT,
  `temperature_set_floor`      FLOAT,
  PRIMARY KEY (`id`)
);