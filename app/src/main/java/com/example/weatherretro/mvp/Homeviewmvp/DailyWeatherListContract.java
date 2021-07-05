package com.example.weatherretro.mvp.Homeviewmvp;

import com.example.weatherretro.model.DailyModel;
import com.example.weatherretro.mvp.BasePresenter;
import com.example.weatherretro.mvp.BaseView;

import java.util.List;


public interface DailyWeatherListContract {

     interface IPresenter extends BasePresenter {
         /**
          * All API calls and calls to data sources local or remote
          * called by views
          */
         void LoadWeatherData();
     }

    interface IView extends BaseView<IPresenter> {
        /**
         * All things which view should perform
         * call by presenter
         */

        void showProgresDialog();
        void dismissProgressDialog();
        void passDataAdapter(List<DailyModel> Weather);
    }
}
