-- -----------------------------------------------------
-- Table `tariff_status`
-- -----------------------------------------------------
CREATE TABLE tariff_status (
  `id`                     BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `date`                   DATETIME(3)     NOT NULL,
  `state`                   VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`)
);