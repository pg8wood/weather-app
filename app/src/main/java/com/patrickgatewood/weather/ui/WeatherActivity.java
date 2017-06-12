package com.patrickgatewood.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.data.model.remote.response.ForecastData;
import com.patrickgatewood.weather.R;

import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements Observer {

    public static final String TAG = "WeatherActivity";

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

    @BindView(R.id.temperatureTextView)
    TextView temperatureTextView;

    @BindView(R.id.feelsLikeTextView)
    TextView feelsLikeTextView;

    @BindView(R.id.summaryTextView)
    TextView summaryTextView;

    @Inject
    DarkSkyApi darkSkyApi;

    @Inject
    WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_slider);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        weatherViewModel.addObserver(this);
        fetchApiDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherViewModel.onFetchButtonTap();
            }
        });
    }

    @Override
    public void update(Observable observable, Object arg) {
        Log.v(TAG, "Update called");

        if (observable instanceof WeatherViewModel)     {
            Log.v(TAG, "Received correct updates from viewmodel");
            WeatherViewModel weatherViewModel = (WeatherViewModel) observable;
            ForecastData currentForecastData = weatherViewModel.getCurrentForecast().getCurrentForecastData();
            String temperature = Double.toString(currentForecastData.getTemperature()) + " degrees";
            String feelsLikeTemperature = "Feels like: " + Double.toString(currentForecastData.getApparentTemperature()) + " degrees";
            temperatureTextView.setText(temperature);
            feelsLikeTextView.setText(feelsLikeTemperature);
            summaryTextView.setText(currentForecastData.getSummary());
        }
    }
}