package com.example.wforecast.gson;

import com.google.gson.annotations.SerializedName;

//Contains data on the weather currently.
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond_txt")
    public String info;
}
