package com.patrickgatewood.weather.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.icu.text.BreakIterator;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.ForecastConfiguration;

import com.example.patrickgatewood.weather.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.patrickgatewood.weather.Constants;
import com.patrickgatewood.weather.viewmodel.WeatherViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

    private WeatherViewModel weatherViewModel;
    private GoogleApiClient googleApi;
    private Location lastLocation;
    private BreakIterator latitudeText;
    private BreakIterator longitudeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_slider);
        ButterKnife.bind(this);

        configureForecastApi();
        configureGoogleAPIClient();

        weatherViewModel = new WeatherViewModel(this.getApplicationContext());
        fetchApiDataButton.setOnClickListener((view) -> {
            weatherViewModel.onFetchButtonTap(view);
        });
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(
                googleApi);
        if (lastLocation != null) {
            latitudeText.setText(String.valueOf(lastLocation.getLatitude()));
            longitudeText.setText(String.valueOf(lastLocation.getLongitude()));
        }
    }

    protected void onStart() {
        googleApi.connect();
        super.onStart();
    }

    protected void onStop() {
        googleApi.disconnect();
        super.onStop();
    }

    private void configureForecastApi() {
        ForecastConfiguration configuration =
                new ForecastConfiguration.Builder(Constants.API_KEY)
                        .setCacheDirectory(getCacheDir())
                        .build();
        ForecastClient.create(configuration);
    }

    private void configureGoogleAPIClient() {
        if (googleApi == null) {
            googleApi = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
