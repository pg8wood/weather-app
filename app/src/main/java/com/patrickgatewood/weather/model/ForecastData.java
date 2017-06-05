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



}
