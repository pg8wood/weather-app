package com.patrickgatewood.weather.data;

import com.patrickgatewood.weather.DarkSkyClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherFactory {

    private static final String BASE_URL = "https://api.darksky.net/forecast/";

    public static DarkSkyClient createClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();

        return retrofit.create(DarkSkyClient.class);
    }

}
