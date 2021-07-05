package com.example.weatherretro.mvp;


import com.example.weatherretro.Rest.ApiClient;
import com.example.weatherretro.Rest.ApiInterface;
import com.example.weatherretro.model.Model;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class WeatherListPresenter_Impl implements IWeatherListContract.IPresenter {

    IWeatherListContract.IView iView;
    String query;
    /**
     * Can be replaced by mock API interface
     */
    private ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    public WeatherListPresenter_Impl(IWeatherListContract.IView iView, String query){
        this.iView=iView;
        this.query= query;
    }
    @Override
    public void LoadWeatherData() {
        apiService.getWeather(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Model>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Model> weather_models) {
                        iView.passDataAdapter(weather_models);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void start() {
        iView.setPresenter(WeatherListPresenter_Impl.this);
    }




}