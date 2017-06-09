package com.patrickgatewood.weather.data.model.remote.response;

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(double nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public long getSunserTime() {
        return sunserTime;
    }

    public void setSunserTime(long sunserTime) {
        this.sunserTime = sunserTime;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public double getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(double precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

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
