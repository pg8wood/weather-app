package com.patrickgatewood.weather.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.patrickgatewood.weather.data.Constants;
import com.patrickgatewood.weather.data.DarkSkyApi;
import com.patrickgatewood.weather.data.model.Forecast;

import java.util.Observable;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends Observable {

    private Context context;
    private DarkSkyApi darkSkyApi;

    private Forecast currentForecast;

    public WeatherViewModel(@NonNull Context context, DarkSkyApi darkSkyApi) {
        this.context = context;
        this.darkSkyApi = darkSkyApi;
    }

    public void onFetchButtonTap(View view) {
        Log.v("WeatherViewModel", "API call initiated");

        // TODO get user's location
        Call<Forecast> apiCall = darkSkyApi.fetchCurrentForecast(
                Constants.API_KEY, "38.029306", "-78.476678");

        // Execute the call asynchronously. Get a positive or negative callback.
        apiCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(@NonNull Call<Forecast> call, @Nullable Response<Forecast> response) {
                Log.v("WeatherViewModel", "API call was a success!");
                Log.v("WeatherViewModel", response.body().toString());
                currentForecast = response.body();
                notifyObservers();
            }

            @Override
            public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                Log.e("WeatherViewModel", "API call failed");
                Log.e("WeatherViewModel", t.getLocalizedMessage());
            }
        });
    }

    public Forecast getCurrentForecast() {
        return currentForecast;
    }

}
