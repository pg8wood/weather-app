package com.patrickgatewood.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.patrickgatewood.weather.R;
import com.patrickgatewood.weather.model.Forecast;
import com.patrickgatewood.weather.model.ForecastData;
import com.patrickgatewood.weather.viewmodel.WeatherViewModel;

import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements Observer {

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

    @BindView(R.id.summaryTextView)
    TextView summaryTextView;

    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_slider);
        ButterKnife.bind(this);

        weatherViewModel = new WeatherViewModel(this.getApplicationContext());
        fetchApiDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherViewModel.onFetchButtonTap(v);
            }
        });
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherViewModel) {
            WeatherViewModel weatherViewModel = (WeatherViewModel) observable;
            ForecastData currentForecastData = weatherViewModel.getCurrentForecast().getCurrentForecastData();
            summaryTextView.setText(currentForecastData.getSummary());
        }
    }
}
