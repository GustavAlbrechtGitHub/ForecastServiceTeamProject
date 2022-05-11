package se.iths.group.forecastserviceteamproject.restclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import se.iths.group.forecastserviceteamproject.met.ForecastMet;

public class MetClient {
    String baseurl = "https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300";
    RestTemplate restTemplate = new RestTemplateBuilder()
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.USER_AGENT, "notJava!")
            .build();
    ForecastMet forecastMet = restTemplate.getForObject(baseurl, ForecastMet.class);

    public static void main(String[] args) {
        MetClient metClient = new MetClient();
        metClient.getTime();
        metClient.getTemperature();
        metClient.getHumidity();

    }

    public void getTime(){
        String time = forecastMet.getProperties().getTimeseries().get(24).getTime();
        System.out.println(time);
    }

    public void getTemperature(){
        Double temperature = forecastMet.getProperties()
                .getTimeseries()
                .get(24)
                .getData()
                .getInstant()
                .getDetails()
                .getAirTemperature();

        System.out.println(temperature);
    }

    public void getHumidity(){
        Double humidity = forecastMet.getProperties()
                .getTimeseries()
                .get(24)
                .getData()
                .getInstant()
                .getDetails()
                .getRelativeHumidity();

        System.out.println(humidity);
    }
}
