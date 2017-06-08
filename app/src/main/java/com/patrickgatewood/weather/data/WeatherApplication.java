package com.patrickgatewood.weather.data;

import android.app.Application;
import android.content.Context;

public class WeatherApplication extends Application {


    private static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }

    public static WeatherApplication create(Context context) {
        return WeatherApplication.get(context);
    }
}
