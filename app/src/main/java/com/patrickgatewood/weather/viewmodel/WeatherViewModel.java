package com.patrickgatewood.weather.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.patrickgatewood.weather.Constants;
import com.patrickgatewood.weather.DarkSkyClient;
import com.patrickgatewood.weather.data.WeatherApplication;
import com.patrickgatewood.weather.model.Forecast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel {

    private Context context;

    public WeatherViewModel(@NonNull Context context) {
        this.context = context;
    }

    public void onFetchButtonTap(View view) {
        Log.v("Weather", "API call initiated");
        WeatherApplication weatherApplication = WeatherApplication.create(context);
        DarkSkyClient darkSkyClient = weatherApplication.getDarkSkyClient();

        // TODO get user's location
        Call<List<Forecast>> apiCall = darkSkyClient.fetchCurrentForecast(
                Constants.API_KEY, "38.029306", "-78.476678");

        // Execute the call asynchronously. Get a positive or negative callback.
        apiCall.enqueue(new Callback<List<Forecast>>() {
            @Override
            public void onResponse(@NonNull Call<List<Forecast>> call, @Nullable Response<List<Forecast>> response) {
                Log.v("Weather", "API call was a success!");
            }

            @Override
            public void onFailure(Call<List<Forecast>> call, Throwable t) {
                Log.v("Weather", "API call failed :(");
            }
        });

    }

}

