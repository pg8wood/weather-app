package com.patrickgatewood.weather.ui;


import android.content.Context;

public interface WeatherPresenter {

    void attachView(Context weatherContext);

    void detachView();

    void requestPermissions();

    void onPermissionsResult();

    void onFetchButtonClick();
}
