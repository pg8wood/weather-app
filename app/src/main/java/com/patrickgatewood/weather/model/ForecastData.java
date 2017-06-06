package com.patrickgatewood.weather.model;

import com.google.gson.annotations.SerializedName;

public class ForecastData {

    @SerializedName("time")
    private long time;

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;

    @SerializedName("nearestStormDistance")
    private double nearestStormDistance;

    @SerializedName("precipIntensity")
    private double precipIntensity;

    @SerializedName("precipIntensityError")
    private double precipIntensityError;

    @SerializedName("precipProbability")
    private double precipProbability;

    @SerializedName("precipType")
    private String precipType;

    @SerializedName("temperature")
    private double temperature;

    @SerializedName("apparentTemperature")
    private double apparentTemperature;

    @SerializedName("dewPoint")
    private double dewPoint;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("windSpeed")
    private double windSpeed;

    @SerializedName("windBearing")
    private double windBearing;

    @SerializedName("visibility")
    private double visibility;

    @SerializedName("cloudCover")
    private double cloudCover;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("ozone")
    private double ozone;


    // Fields only for daily forecast
    @SerializedName("sunriseTime")
    private long sunriseTime;

    @SerializedName("sunsetTime")
    private long sunserTime;

    @SerializedName("moonPhase")
    private double moonPhase;

    @SerializedName("precipIntensityMax")
    private double precipIntensityMax;

    @SerializedName("precipIntensityMaxTime")
    private double precipIntensityMaxTime;

    @SerializedName("temperatureMin")
    private double temperatureMin;

    @SerializedName("temperatureMinTime")
    private long temperatureMinTime;

    @SerializedName("temperatureMax")
    private double temperatureMax;

    @SerializedName("temperatureMaxTime")
    private long temperatureMaxTime;

    @SerializedName("apparentTemperatureMin")
    private double apparentTemperatureMin;

    @SerializedName("apparentTemperatureMinTime")
    private long apparentTemperatureMinTime;

    @SerializedName("apparentTemperatureMax")
    private double apparentTemperatureMax;

    @SerializedName("apparentTemperatureMaxTime")
    private long apparentTemperatureMaxTime;

    @Override
    public String toString() {
        return "ForecastData{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", nearestStormDistance=" + nearestStormDistance +
                ", precipIntensity=" + precipIntensity +
                ", precipIntensityError=" + precipIntensityError +
                ", precipProbability=" + precipProbability +
                ", precipType='" + precipType + '\'' +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windBearing=" + windBearing +
                ", visibility=" + visibility +
                ", cloudCover=" + cloudCover +
                ", pressure=" + pressure +
                ", ozone=" + ozone +
                ", sunriseTime=" + sunriseTime +
                ", sunserTime=" + sunserTime +
                ", moonPhase=" + moonPhase +
                ", precipIntensityMax=" + precipIntensityMax +
                ", precipIntensityMaxTime=" + precipIntensityMaxTime +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMinTime=" + temperatureMinTime +
                ", temperatureMax=" + temperatureMax +
                ", temperatureMaxTime=" + temperatureMaxTime +
                ", apparentTemperatureMin=" + apparentTemperatureMin +
                ", apparentTemperatureMinTime=" + apparentTemperatureMinTime +
                ", apparentTemperatureMax=" + apparentTemperatureMax +
                ", apparentTemperatureMaxTime=" + apparentTemperatureMaxTime +
                '}';
    }
}
