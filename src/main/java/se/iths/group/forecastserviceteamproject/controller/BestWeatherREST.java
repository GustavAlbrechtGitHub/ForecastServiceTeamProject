package se.iths.group.forecastserviceteamproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.group.forecastserviceteamproject.service.ForecastService;
import se.iths.group.forecastserviceteamproject.service.WeatherAttributes;

@RestController
public class BestWeatherREST {

    @Autowired
    ForecastService forecastService;

    @GetMapping("/rs/bestweather")
    public WeatherAttributes getBestWeather(){
        return forecastService.getBestWeather();
    }
}
