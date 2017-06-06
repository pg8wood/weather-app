package com.patrickgatewood.weather.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

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


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ForecastData getCurrentForecastData() {
        return currentForecastData;
    }

    public void setCurrentForecastData(ForecastData currentForecastData) {
        this.currentForecastData = currentForecastData;
    }

    public MinutelyForecast getMinutely() {
        return minutely;
    }

    public void setMinutely(MinutelyForecast minutely) {
        this.minutely = minutely;
    }

    public ForecastData getHourlyForecastData() {
        return hourlyForecastData;
    }

    public void setHourlyForecastData(ForecastData hourlyForecastData) {
        this.hourlyForecastData = hourlyForecastData;
    }

    public Forecast getDailyForecastData() {
        return dailyForecastData;
    }

    public void setDailyForecastData(Forecast dailyForecastData) {
        this.dailyForecastData = dailyForecastData;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timeZone='" + timeZone + '\'' +
                ", currentForecastData=" + currentForecastData +
                ", minutely=" + minutely +
                ", hourlyForecastData=" + hourlyForecastData +
                ", dailyForecastData=" + dailyForecastData +
                '}';
    }
}