package com.patrickgatewood.weather.ui;


public interface WeatherPresenter {

    void onFetchButtonClick();

    void attachView(WeatherView weatherView);

    void detachView();
}
