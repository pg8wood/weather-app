package com.patrickgatewood.weather.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestOverlayPermission();
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

    /**
     * Requests permission to show overlays. Required for development builds with React Native
     * so that React Native can display development errors above all other windows.
     */
    private void requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "Overlay permission not granted :(",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
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