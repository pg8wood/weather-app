package com.patrickgatewood.weather.data.model.remote.request;

import com.patrickgatewood.weather.data.model.remote.response.Forecast;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Singleton
public interface DarkSkyApi {

    String BASE_URL = "https://api.darksky.net/forecast/";

    @GET("{api_key}/{latitude},{longitude}")
    Call<Forecast> fetchCurrentForecast(
            @Path("api_key") String api_key,
            @Path("latitude") String latitude,
            @Path("longitude") String longitude
    );
}
