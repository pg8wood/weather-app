package com.patrickgatewood.weather.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.patrickgatewood.weather.data.model.local.Constants;
import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.data.model.remote.response.Forecast;
import com.patrickgatewood.weather.data.model.remote.response.ForecastData;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenterImpl implements WeatherPresenter, LocationListener {

    private static final String TAG = "WeatherPresenter";

    @NonNull
    private DarkSkyApi darkSkyApi;

    @Nullable
    private Forecast currentForecast = null;

    @Nullable
    private WeatherView weatherView = null;

    @Nullable
    private LocationListener locationListener = null;

    @Inject
    LocationManager locationManager;

    @Inject
    public WeatherPresenterImpl(@NonNull DarkSkyApi darkSkyApi) {
        this.darkSkyApi = darkSkyApi;
    }

    @Override
    public void attachView(Context weatherContext) {
        if (weatherContext instanceof WeatherActivity) {
            this.weatherView = (WeatherActivity) weatherContext;
        }
    }

    @Override
    public void detachView() {
        this.weatherView = null;
    }

    @Override
    public void requestPermissions() {
        if ((weatherView != null)
                && (ActivityCompat.checkSelfPermission(weatherView.getWeatherActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

        }
    }

    @Override
    public void onPermissionsResult() {

    }

    public void onFetchButtonClick() {
        Log.v(TAG, "API call initiated");

        // TODO only get the location if it's outdated
        getUserLocation();

        // Charlottesville's lat/long
        //queryApi(38.029306, -78.476678);
    }

    private void queryApi(double latitude, double longitude) {
        Call<Forecast> apiCall = darkSkyApi.fetchCurrentForecast(
                Constants.API_KEY, latitude, longitude);

        // Execute the call asynchronously. Get a positive or negative callback.
        apiCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(@NonNull Call<Forecast> call, @NonNull Response<Forecast> response) {
                Log.v(TAG, "API call was a success!");
                currentForecast = response.body();
                updateView();
            }

            @Override
            public void onFailure(@NonNull Call<Forecast> call, @NonNull Throwable t) {
                Log.e("WeatherPresenter", "API call failed: " + t.getLocalizedMessage());
            }
        });
    }

    /**
     * Tell the view what needs to be updated
     */
    private void updateView() {
        if (currentForecast == null || weatherView == null) {
            return;
        }

        ForecastData currentForecastData = currentForecast.getCurrentForecastData();
        String temperature = Double.toString(currentForecastData.getTemperature());
        String feelsLikeTemp = Double.toString(currentForecastData.getApparentTemperature());

        weatherView.updateCurrentConditionsTextViews(temperature, feelsLikeTemp, currentForecastData.getSummary());
    }

    private void getUserLocation() {
        if (locationListener == null) {
            createLocationListener();
        }


        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, locationListener, null);
    }

    private void createLocationListener() {
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }

    @Override
    public void onLocationChanged(Location location) {
        queryApi(location.getLatitude(), location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Do nothing
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Do nothing
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Do nothing
    }
}

