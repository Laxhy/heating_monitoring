package eu.laxhy.heating.monitoring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Libor Laichmann.
 */
@Service
@Slf4j
public class HeatingSystemService implements IHeatingSystemService {

    private static String BASIC_URL = "http://192.168.1.113/";

    @Autowired
    private IHeatingSystemAuthenticationService heatingSystemAuthenticationService;

    @Override
    public String getHeatingInfo(int roomOrder) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("param", String.valueOf(roomOrder));
        ResponseEntity<String> result = restTemplate.postForEntity(BASIC_URL + "wholeRoom", params, String.class);
        return result.getBody();
    }

    @Override
    public void login() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("loginName", heatingSystemAuthenticationService.getLogin());
        params.add("passwd", heatingSystemAuthenticationService.getPassword());
        restTemplate.postForEntity(BASIC_URL + "menu.html", params, String.class);
    }

    @Override
    public Tariff getHDOTariff() {

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("param", "");
        ResponseEntity<String> result = restTemplate.postForEntity(BASIC_URL + "loadHDO", params, String.class);
        log.info("Tarif result: " + result.getBody());
        return Tariff.getByValue(result.getBody().charAt(0));

    }
}
