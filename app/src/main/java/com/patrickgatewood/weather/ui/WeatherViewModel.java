package com.patrickgatewood.weather.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.patrickgatewood.weather.data.model.local.Constants;
import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.data.model.remote.response.Forecast;

import java.util.Observable;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends Observable {

    public static final String TAG = "WeatherViewModel";

    @NonNull
    private DarkSkyApi darkSkyApi;

    @Nullable
    private Forecast currentForecast = null;

    @Inject
    public WeatherViewModel(@NonNull DarkSkyApi darkSkyApi) {
        this.darkSkyApi = darkSkyApi;
    }

    public void onFetchButtonTap() {
        Log.v(TAG, "API call initiated");

        // TODO get user's location
        Call<Forecast> apiCall = darkSkyApi.fetchCurrentForecast(
                Constants.API_KEY, "38.029306", "-78.476678");

        // Execute the call asynchronously. Get a positive or negative callback.
        apiCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(@NonNull Call<Forecast> call, @Nullable Response<Forecast> response) {
                Log.v(TAG, "API call was a success!");
                Log.v(TAG, response.body().toString());
                currentForecast = response.body();
                setChanged();
                notifyObservers();
            }

            @Override
            public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                Log.e("WeatherViewModel", "API call failed: " + t.getLocalizedMessage());
            }
        });
    }

    @Nullable
    public Forecast getCurrentForecast() {
        return currentForecast;
    }

}

