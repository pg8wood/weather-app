package com.patrickgatewood.weather.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.models.Forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel {

    private Context context;

    public WeatherViewModel(@NonNull Context context) {
        this.context = context;
    }

    public void onFetchButtonTap(View view) {

    }

    private void fetchCurrentForecast() {
        Log.v("Weather", "API call initiated");

        // TODO get user's current location
        double latitude = 38.029306;
        double longitude = -78.476678;

        // TODO API call to current forecast
    }

}

