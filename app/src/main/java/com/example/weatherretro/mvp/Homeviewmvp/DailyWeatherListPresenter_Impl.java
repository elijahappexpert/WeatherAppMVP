package com.example.weatherretro.mvp.Homeviewmvp;


import com.example.weatherretro.Rest.ApiClient;
import com.example.weatherretro.Rest.ApiDailyInterface;
import com.example.weatherretro.Rest.ApiInterface;
import com.example.weatherretro.model.DailyModel;
import com.example.weatherretro.model.Model;
import com.example.weatherretro.mvp.IWeatherListContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DailyWeatherListPresenter_Impl implements DailyWeatherListContract.IPresenter {

    DailyWeatherListContract.IView iView;
    int woeID;
    /**
     * Can be replaced by mock API interface
     */
    private ApiDailyInterface apiService =
            ApiClient.getClient().create(ApiDailyInterface.class);



    public DailyWeatherListPresenter_Impl(DailyWeatherListContract.IView iView, int woeID){
        this.iView=iView;
        this.woeID= woeID;
    }
    @Override
    public void LoadWeatherData() {
        apiService.getDailyWeather(woeID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DailyModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<DailyModel> weather_models) {
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
        iView.setPresenter(DailyWeatherListPresenter_Impl.this);
    }




}