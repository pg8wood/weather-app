package com.patrickgatewood.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.patrickgatewood.weather.R;
import com.patrickgatewood.weather.viewmodel.WeatherViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.fetchApiDataButton)
    Button fetchApiDataButton;

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
}
