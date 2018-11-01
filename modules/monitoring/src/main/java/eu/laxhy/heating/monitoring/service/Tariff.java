package eu.laxhy.heating.monitoring.service;

/**
 * Created by Libor Laichmann.
 */
public enum Tariff {

  HIGH('0'),
  LOW('1');

  char value;

  Tariff(char value) {
    this.value = value;
  }

  public static Tariff getByValue(char value) {
    if ('2' == value) {
      return HIGH;
    } else {
      return LOW;
    }
  }

}
