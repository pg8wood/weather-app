package com.patrickgatewood.weather.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.patrickgatewood.weather.data.model.local.Constants;
import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.data.model.remote.response.Forecast;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenter implements Presenter {

    public static final String TAG = "WeatherPresenter";

    @NonNull
    private DarkSkyApi darkSkyApi;

    @Nullable
    private Forecast currentForecast = null;

    @NonNull
    private WeatherActivity weatherActivity;

    @Inject
    public WeatherPresenter(@NonNull DarkSkyApi darkSkyApi) {
        this.darkSkyApi = darkSkyApi;
    }

    public void onFetchButtonClick() {
        Log.v(TAG, "API call initiated");

        // TODO get user's location and pass to query
        queryApi();
    }

    public void queryApi() {

        Call<Forecast> apiCall = darkSkyApi.fetchCurrentForecast(
                Constants.API_KEY, "38.029306", "-78.476678");

        // Execute the call asynchronously. Get a positive or negative callback.
        apiCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(@NonNull Call<Forecast> call, @Nullable Response<Forecast> response) {
                Log.v(TAG, "API call was a success!");
                Log.v(TAG, response.body().toString());
                currentForecast = response.body();
                updateView();
            }

            @Override
            public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                Log.e("WeatherPresenter", "API call failed: " + t.getLocalizedMessage());
            }
        });
    }

    private void updateView() {
        // Tell the view what should be updated
        weatherActivity.getSummaryTextView().setText(currentForecast.getCurrentForecastData().getSummary());
        // ...
    }

    @Override
    public void onResume() {
        // TODO get user's location and pass to query
        queryApi();
    }

    @NonNull
    public WeatherActivity getWeatherActivity() {
        return weatherActivity;
    }

    public void setWeatherActivity(@NonNull WeatherActivity weatherActivity) {
        this.weatherActivity = weatherActivity;
    }
}

