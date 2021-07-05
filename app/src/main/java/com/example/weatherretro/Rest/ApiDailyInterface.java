package com.example.weatherretro.Rest;

import com.example.weatherretro.model.DailyModel;
import com.example.weatherretro.model.Model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDailyInterface {

    @GET("api/location/{woeid}/")
    public Observable<List<DailyModel>> getDailyWeather(
            @Path("woeid") int WoeId);

}
