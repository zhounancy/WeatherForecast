package com.example.wforecast.gson;

//Contains information about the air quality status
public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
