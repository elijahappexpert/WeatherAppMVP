package com.example.weatherretro.Rest;

import com.example.weatherretro.model.Model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("api/location/search/?")
    public Observable<List<Model>> getWeather(
            @Query("query") String Query);

}






