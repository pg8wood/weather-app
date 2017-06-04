package com.patrickgatewood.weather.data;

import android.app.Application;
import android.content.Context;

import com.patrickgatewood.weather.DarkSkyClient;

public class WeatherApplication extends Application {

    private DarkSkyClient client;

    private static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }

    public static WeatherApplication create(Context context) {
        return WeatherApplication.get(context);
    }

    public DarkSkyClient getDarkSkyClient() {
        if (client == null) {
            client = WeatherFactory.createClient();
        }

        return client;
    }

    public void setClient(DarkSkyClient client) {
        this.client = client;
    }
}
