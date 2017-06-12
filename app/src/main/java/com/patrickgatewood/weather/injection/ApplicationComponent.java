package com.patrickgatewood.weather.injection;

import com.patrickgatewood.weather.ui.WeatherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(WeatherActivity weatherActivity);
}
