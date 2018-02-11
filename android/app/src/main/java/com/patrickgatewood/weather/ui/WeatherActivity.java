package com.patrickgatewood.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.patrickgatewood.weather.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

    @BindView(R.id.temperatureTextView)
    TextView temperatureTextView;

    @BindView(R.id.feelsLikeTextView)
    TextView feelsLikeTextView;

    @BindView(R.id.summaryTextView)
    TextView summaryTextView;

    @Inject
    WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_slider);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        weatherPresenter.attachView(this);
        fetchApiDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.onFetchButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        weatherPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void updateCurrentConditionsTextViews(String temperature, String feelsLikeTemp, String summary) {
        String temp = "Current temperature: " + temperature + " degrees";
        String feelsLike = "Feels like: " + feelsLikeTemp + " degrees";

        temperatureTextView.setText(temp);
        feelsLikeTextView.setText(feelsLike);
        summaryTextView.setText(summary);
    }
}