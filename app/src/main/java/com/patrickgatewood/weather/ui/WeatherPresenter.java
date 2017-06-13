package com.patrickgatewood.weather.ui;


import android.content.Context;

public interface WeatherPresenter {

    void onFetchButtonClick();

    void attachView(Context weatherContext);

    void detachView();
}
