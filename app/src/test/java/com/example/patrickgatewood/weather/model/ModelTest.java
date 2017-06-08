package com.example.patrickgatewood.weather.model;

import com.google.gson.Gson;
import com.patrickgatewood.weather.data.model.Forecast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


@RunWith(RobolectricTestRunner.class)
public class ModelTest {
    private static final String MOCK_JSON_RELATIVE_PATH = "/app/src/test/java/com/example/patrickgatewood/weather/model/mockJSON";
    private String mockJSONResponse;

    @Before
    public void setUpClass() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + MOCK_JSON_RELATIVE_PATH;
        mockJSONResponse = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
    }

    @Test
    public void testForecastDeserialization() {
        Gson gson = new Gson();
        Forecast forecast = gson.fromJson(mockJSONResponse, Forecast.class);
    }

}
