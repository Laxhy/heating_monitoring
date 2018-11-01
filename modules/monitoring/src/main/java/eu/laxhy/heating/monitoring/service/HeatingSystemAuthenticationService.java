package eu.laxhy.heating.monitoring.service;

import java.util.Calendar;
import org.springframework.stereotype.Service;

/**
 * Created by Libor Laichmann.
 */
@Service
public class HeatingSystemAuthenticationService implements IHeatingSystemAuthenticationService {

  @Override
  public String getLogin() {
    switch (Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
      case 1:
        return "6560696D6A";
      case 2:
        return "696C656166";
      case 3:
        return "6D68616562";
      case 4:
        return "71747D797E";
      case 5:
        return "7570797D7A";
      case 6:
        return "797C757176";
      case 7:
        return "7D78717572";
      case 8:
        return "41444D494E";
      case 9:
        return "4540494D4A";
      case 10:
        return "494C454146";
      case 11:
        return "4D48414542";
      case 12:
        return "51545D595E";
      case 13:
        return "5550595D5A";
      case 14:
        return "595C555156";
      case 15:
        return "5D58515552";
      case 16:
        return "21242D292E";
      case 17:
        return "2520292D2A";
      case 18:
        return "292C252126";
      case 19:
        return "2D28212522";
      case 20:
        return "31343D393E";
      case 21:
        return "3530393D3A";
      case 22:
        return "393C353136";
      case 23:
        return "3D38313532";
      case 24:
        return "01040D090E";
      case 25:
        return "0500090D0A";
      case 26:
        return "090C050106";
      case 27:
        return "0D08010502";
      case 28:
        return "11141D191E";
      case 29:
        return "1510191D1A";
      case 30:
        return "191C151116";
      case 31:
        return "1D18111512";
      default:
        throw new UnknownError("Problem with getting login for actual day");
    }
  }

  @Override
  public String getPassword() {
    switch (Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
      case 1:
        return "35363730";
      case 2:
        return "393A3B3C";
      case 3:
        return "3D3E3F38";
      case 4:
        return "21222324";
      case 5:
        return "25262720";
      case 6:
        return "292A2B2C";
      case 7:
        return "2D2E2F28";
      case 8:
        return "11121314";
      case 9:
        return "15161710";
      case 10:
        return "191A1B1C";
      case 11:
        return "1D1E1F18";
      case 12:
        return "01020304";
      case 13:
        return "05060700";
      case 14:
        return "090A0B0C";
      case 15:
        return "0D0E0F08";
      case 16:
        return "71727374";
      case 17:
        return "75767770";
      case 18:
        return "797A7B7C";
      case 19:
        return "7D7E7F78";
      case 20:
        return "61626364";
      case 21:
        return "65666760";
      case 22:
        return "696A6B6C";
      case 23:
        return "6D6E6F68";
      case 24:
        return "51525354";
      case 25:
        return "55565750";
      case 26:
        return "595A5B5C";
      case 27:
        return "5D5E5F58";
      case 28:
        return "41424344";
      case 29:
        return "45464740";
      case 30:
        return "494A4B4C";
      case 31:
        return "4D4E4F48";
      default:
        throw new UnknownError("Problem with getting login for actual day");
    }
  }
}
