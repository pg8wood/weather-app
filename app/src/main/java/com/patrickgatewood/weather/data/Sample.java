package com.patrickgatewood.weather.data;

import com.google.gson.annotations.SerializedName;

public class Sample {

    @SerializedName("latitude")
    long latitude;

    @SerializedName("currently")
    Currently currently;
}
