package com.patrickgatewood.weather.ui;


interface WeatherView {
    void updateCurrentConditionsTextViews(String temperature, String feelsLikeTemp, String summary);
}
