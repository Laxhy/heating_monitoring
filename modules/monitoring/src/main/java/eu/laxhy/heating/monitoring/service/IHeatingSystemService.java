package eu.laxhy.heating.monitoring.service;

/**
 * Created by Libor Laichmann.
 */
public interface IHeatingSystemService {

  String getHeatingInfo(int roomOrder);

  void login();

  Tariff getHDOTariff();

}
