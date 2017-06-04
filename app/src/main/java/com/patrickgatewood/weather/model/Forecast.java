package com.patrickgatewood.weather.model;

import java.util.Collection;

public class Forecast {

    private CurrentForecast currentForecast;
//    private HourlyForecast hourlyForecast;

    public Forecast(CurrentForecast currentForecast) {
        this.currentForecast = currentForecast;
    }
}
