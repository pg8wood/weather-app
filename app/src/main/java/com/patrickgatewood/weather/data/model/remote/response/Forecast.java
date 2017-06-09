package com.patrickgatewood.weather.data.model.remote.response;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forecast forecast = (Forecast) o;
        if (Double.compare(forecast.latitude, latitude) != 0) return false;
        if (Double.compare(forecast.longitude, longitude) != 0) return false;
        if (timeZone != null ? !timeZone.equals(forecast.timeZone) : forecast.timeZone != null)
            return false;
        if (currentForecastData != null ? !currentForecastData.equals(forecast.currentForecastData) : forecast.currentForecastData != null)
            return false;
        if (minutely != null ? !minutely.equals(forecast.minutely) : forecast.minutely != null)
            return false;
        if (hourlyForecastData != null ? !hourlyForecastData.equals(forecast.hourlyForecastData) : forecast.hourlyForecastData != null)
            return false;
        return dailyForecastData != null ? dailyForecastData.equals(forecast.dailyForecastData) : forecast.dailyForecastData == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (currentForecastData != null ? currentForecastData.hashCode() : 0);
        result = 31 * result + (minutely != null ? minutely.hashCode() : 0);
        result = 31 * result + (hourlyForecastData != null ? hourlyForecastData.hashCode() : 0);
        result = 31 * result + (dailyForecastData != null ? dailyForecastData.hashCode() : 0);
        return result;
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