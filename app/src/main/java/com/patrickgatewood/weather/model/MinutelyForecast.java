package com.patrickgatewood.weather.model;

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
        private long precipIntensity;

        @SerializedName("precipIntensityError")
        private long precipIntensityError;

        @SerializedName("precipProbability")
        private long precipProbability;

        @SerializedName("precipType")
        private String precipType;
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
