package eu.laxhy.heating.monitoring.service;

/**
 * Created by Libor Laichmann.
 */
public enum Room {

  ZADVERI(13, 1),
  TECHNICKA_MISTNOST(14, 2),
  KOUPELNA_SPODNI(17, 5),
  PRACOVNA(16, 4),
  CHODBA(15, 3),
  PRADELNA(18, 6),
  KOUPELNA_HORNI(22, 10),
  POKOJ_JAKUB(19, 7),
  POKOJ_HOLKY(20, 8),
  LOZNICE(23, 11),
  OBYVAK(12, 0);


  private int roomOrder;
  private int floorOrder;

  public int getRoomOrder() {
    return roomOrder;
  }

  public int getFloorOrder() {
    return floorOrder;
  }

  Room(int roomOrder, int floorOrder) {
    this.roomOrder = roomOrder;
    this.floorOrder = floorOrder;
  }
}
