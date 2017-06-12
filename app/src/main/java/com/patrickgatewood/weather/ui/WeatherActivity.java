package com.patrickgatewood.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

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

        weatherPresenter.setWeatherActivity(this);

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
        weatherPresenter.onResume();
    }

    public TextView getSummaryTextView() {
        return summaryTextView;
    }

}