package com.patrickgatewood.weather;

import com.patrickgatewood.weather.model.Forecast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkSkyClient {

    @GET("{api_key}/{latitude},{longitude}")
    Call<Forecast> fetchCurrentForecast(
            @Path("api_key") String api_key,
            @Path("latitude") String latitude,
            @Path("longitude") String longitude
    );
}
