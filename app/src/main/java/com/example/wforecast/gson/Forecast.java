package com.example.wforecast.gson;

import com.google.gson.annotations.SerializedName;

//contains info on the weather for the following days.
public class Forecast {

    @SerializedName("date")
    public String date;

    @SerializedName("cond_text_n")
    public String info;

    @SerializedName("tmp_max")
    public String max;

    @SerializedName("tmp_min")
    public String min;
}
