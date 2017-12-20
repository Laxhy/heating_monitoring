-- -----------------------------------------------------
-- Table `weather`
-- -----------------------------------------------------
CREATE TABLE weather (
  `id`                     BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `date`                   DATETIME(3)     NOT NULL,
  `temperature`            FLOAT,
  `pressure`               INTEGER,
  `humidity`               INTEGER,
  `wind_speed`              INTEGER,
  PRIMARY KEY (`id`)
);