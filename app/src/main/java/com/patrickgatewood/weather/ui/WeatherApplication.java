package com.patrickgatewood.weather.ui;

import android.app.Application;
import com.patrickgatewood.weather.injection.ApplicationComponent;
import com.patrickgatewood.weather.injection.ApplicationModule;
import com.patrickgatewood.weather.injection.DaggerApplicationComponent;

public class WeatherApplication extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        super.onCreate();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
