package com.example.weatherretro.mvp;

import com.example.weatherretro.model.Model;


import java.util.List;


public interface IWeatherListContract {

     interface IPresenter extends BasePresenter{
         /**
          * All API calls and calls to data sources local or remote
          * called by views
          */
         void LoadWeatherData();
     }

    interface IView extends BaseView<IPresenter>{
        /**
         * All things which view should perform
         * call by presenter
         */

        void showProgresDialog();
        void dismissProgressDialog();
        void passDataAdapter(List<Model> Weather);
    }


}
