package com.example.wforecast.gson;

import com.google.gson.annotations.SerializedName;

//Contains information about the air quality status
public class Air {

//    public AQICity city;
//
//    public class AQICity {
//        public String aqi;
//        public String pm25;
//    }

    public String status;

    @SerializedName("air_now_city")
    public AQIData aqiData;

}
