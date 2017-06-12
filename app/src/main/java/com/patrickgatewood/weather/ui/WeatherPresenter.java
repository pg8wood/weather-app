package com.patrickgatewood.weather.ui;


public interface WeatherPresenter {

    void onFetchButtonClick();
    void attachView(WeatherActivity weatherActivity);
    void detachView();
}
