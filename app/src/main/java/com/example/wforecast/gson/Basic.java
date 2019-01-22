package com.example.wforecast.gson;

import com.google.gson.annotations.SerializedName;

//contains some basic information about the city.
public class Basic {

    @SerializedName("location")
    public String cityName;

    @SerializedName("cid")
    public String weatherId;
}
