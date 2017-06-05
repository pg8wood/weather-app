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
    private ForecastData currentForecastData;

    @SerializedName("minutely")
    private MinutelyForecast minutely;

    @SerializedName("hourly")
    private ForecastData hourlyForecastData;

    @SerializedName("daily")
    private Forecast dailyForecastData;

//    @SerializedName("alerts")
//    private Alerts alerts;

}