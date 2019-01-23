package com.example.wforecast.gson;

import com.google.gson.annotations.SerializedName;

public class AQIData {
    @SerializedName("aqi")
    public String aqi;

    @SerializedName("pm25")
    public String pm25;
}
