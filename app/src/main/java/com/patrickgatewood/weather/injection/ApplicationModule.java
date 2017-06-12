package com.patrickgatewood.weather.injection;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi;
import com.patrickgatewood.weather.ui.WeatherViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.patrickgatewood.weather.data.model.remote.request.DarkSkyApi.BASE_URL;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        return builder.client(okHttpClient).build();
    }

    @Provides
    @Singleton
    DarkSkyApi provideDarkskyApi(Retrofit retrofit) {
        return retrofit.create(DarkSkyApi.class);
    }

    @Provides
    @Singleton
    WeatherViewModel provideWeatherViewModel(DarkSkyApi darkSkyApi) {
        return new WeatherViewModel(darkSkyApi);
    }
}
