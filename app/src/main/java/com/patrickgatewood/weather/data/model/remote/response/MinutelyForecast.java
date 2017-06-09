package com.patrickgatewood.weather.data.model.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class MinutelyForecast {

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;

    @SerializedName("data")
    private List<MinutelyForecastData> minutelyForecastDataList;


    private class MinutelyForecastData {

        @SerializedName("time")
        private long time;

        @SerializedName("precipIntensity")
        private double precipIntensity;

        @SerializedName("precipIntensityError")
        private double precipIntensityError;

        @SerializedName("precipProbability")
        private double precipProbability;

        @SerializedName("precipType")
        private String precipType;
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

    public List<MinutelyForecastData> getMinutelyForecastDataList() {
        return minutelyForecastDataList;
    }

    public void setMinutelyForecastDataList(List<MinutelyForecastData> minutelyForecastDataList) {
        this.minutelyForecastDataList = minutelyForecastDataList;
    }

    @Override
    public String toString() {
        return "MinutelyForecast{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", minutelyForecastDataList=" + minutelyForecastDataList +
                '}';
    }
}
