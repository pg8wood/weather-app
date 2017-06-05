package com.patrickgatewood.weather.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("latitude")
    private long latitude;

    @SerializedName("longitude")
    private long longitude;

    @SerializedName("timezone")
    private String timeZone;

    @SerializedName("currently")
    private ForecastData forecastData;

//    @SerializedName("minutely")
//    private MinutelyForecast minutely;

    @SerializedName("hourly")
    private HourlyForecast hourly;

//    @SerializedName("daily")
//    private DailyForecast daily;
//
//    @SerializedName("alerts")
//    private Alerts alerts;




    public Forecast(ForecastData forecastData) {
        this.forecastData = forecastData;
    }
}
