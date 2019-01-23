package com.example.wforecast.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.wforecast.db.City;
import com.example.wforecast.db.County;
import com.example.wforecast.db.Province;
import com.example.wforecast.gson.Air;
import com.example.wforecast.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    private static final String TAG = "Utility";

    //Decodes and handles the response to a service request in the province level.
    //解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response); //formats the data into a json array,
                // if there is an error with formatting the data then it will throw an exception.
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Decodes and handles the response to a service request in the city level.
    //解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject CityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(CityObject.getString("name"));
                    city.setCityCode(CityObject.getInt("id"));
                    city.setProvinceID(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Decodes and handles the response to a service request in the county level.
    //解析和处理服务器返回的市级数据
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject CountyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(CountyObject.getString("name"));
                    county.setWeatherId(CountyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //将返回的JSON数据解析成weather实体类
     public static Weather handleWeatherResponse(String response) {
         try {
             JSONObject jsonObject = new JSONObject(response);
             JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
             String weatherContent = jsonArray.getJSONObject(0).toString();
             return new Gson().fromJson(weatherContent, Weather.class);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }

     public static Air handleAQIresponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
            Log.d(TAG, "handleAQIresponse: jsonArray = " + jsonArray);
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            Log.d(TAG, "handleAQIresponse: jsonObject1 is == " + jsonObject1);
            //JSONObject AQIcontent= jsonObject1.getJSONObject("air_now_city");
            return new Gson().fromJson(String.valueOf(jsonObject1), Air.class);
        } catch (Exception e) {
            e.printStackTrace();
         }
         return null;
     }


}
