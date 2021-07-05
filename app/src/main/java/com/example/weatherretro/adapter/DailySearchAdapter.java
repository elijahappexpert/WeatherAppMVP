package com.example.weatherretro.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherretro.HomeView.DailySearchClickListener;
import com.example.weatherretro.R;
import com.example.weatherretro.model.DailyModel;

import java.util.List;

import static com.example.weatherretro.Constants.Constants.Clear;
import static com.example.weatherretro.Constants.Constants.Hail;
import static com.example.weatherretro.Constants.Constants.Heavy_Cloud;
import static com.example.weatherretro.Constants.Constants.Heavy_Rain;
import static com.example.weatherretro.Constants.Constants.Light_Cloud;
import static com.example.weatherretro.Constants.Constants.Light_Rain;
import static com.example.weatherretro.Constants.Constants.SNOW;
import static com.example.weatherretro.Constants.Constants.Showers;
import static com.example.weatherretro.Constants.Constants.Sleet;
import static com.example.weatherretro.Constants.Constants.Thunderstorm;

public class DailySearchAdapter extends LinearLayout implements View.OnClickListener{

    private List<DailyModel> DailySearches;
    private Context mContext;
    private final DailySearchClickListener mListener;


    private TextView mMonText;
    private TextView mTueText;
    private TextView mWedText;
    private TextView mThurText;
    private TextView mFriText;
    private TextView mSatText;
    private TextView mSunText;


    private ImageView mMonImg;
    private ImageView mTueImg;
    private ImageView mWedImg;
    private ImageView mThurImg;
    private ImageView mFriImg;
    private ImageView mSatImg;
    private ImageView mSunImg;



    public DailySearchAdapter(Context context,List<DailyModel> DailySearches, DailySearchClickListener listener ){
        super(context);
        this.mContext =context;
        this.DailySearches = DailySearches;
        mListener = listener;


    }


    public void SetDailySearch(List<DailyModel> searchResult){
        this.DailySearches = searchResult;


    }


    public void onBindViewHolder(int position) {

        DailyModel SearcheResult = DailySearches.get(position);

        String Date = SearcheResult.getApplicableDate();
        String WeatherState = SearcheResult.getWeatherStateAbbr();

        dateWeatherAdapter(Date,WeatherState);

    }


    public void dateWeatherAdapter(String Date, String WeatherState){


        if(Date.equalsIgnoreCase("Mon")){
            Log.d("Date Log",Date);
            //set text on Mon
            mMonText.setText(Date.toString());
            setWeatherImg(WeatherState,mMonImg);

        }

        else if(Date.equalsIgnoreCase("Tue")){
            Log.d("Date Log",Date);
            mTueText.setText(Date.toString());
            //set text on Tue
            setWeatherImg(WeatherState,mTueImg);
        }

        else if(Date.equalsIgnoreCase("Wed")){
            Log.d("Date Log",Date);
            mWedText.setText(Date.toString());
            //set text on Wed
            setWeatherImg(WeatherState,mWedImg);
        }
        else if(Date.equalsIgnoreCase("Thur")){
            Log.d("Date Log",Date);
            mThurText.setText(Date.toString());
            //set text on Thur
            setWeatherImg(WeatherState,mThurImg);
        }
        else if(Date.equalsIgnoreCase("Fri")){

            Log.d("Date Log",Date);
            mFriText.setText(Date.toString());
            //set text on Fri
            setWeatherImg(WeatherState,mFriImg);
        }
        else if(Date.equalsIgnoreCase("Sat")){
            Log.d("Date Log",Date);
            mSatText.setText(Date.toString());
            //set text on Sat
            setWeatherImg(WeatherState,mSatImg);
        }
        else if(Date.equalsIgnoreCase("Sun")){
            Log.d("Date Log",Date);
            mSunText.setText(Date.toString());
            //set text on Sun
            setWeatherImg(WeatherState,mSunImg);
        }


    }

    private void setWeatherImg(String weatherState ,ImageView weatherImg) {
        if(weatherState.equalsIgnoreCase("hr")){

            provideGlide(Heavy_Rain,weatherImg);
            //assign weatherImg
        }
        else if(weatherState.equalsIgnoreCase("sn")){
            //assign weatherImg
            provideGlide(SNOW,weatherImg);

        }
        else if(weatherState.equalsIgnoreCase("sl")){
            //assign weatherImg
            provideGlide(Sleet,weatherImg);
        }

        else if(weatherState.equalsIgnoreCase("h")){
            //assign weatherImg
            provideGlide(Hail,weatherImg);
        }
        else if(weatherState.equalsIgnoreCase("t")){
            //assign weatherImg
            provideGlide(Thunderstorm,weatherImg);
        }

        else if(weatherState.equalsIgnoreCase("lr")){
            //assign weatherImg
            provideGlide(Light_Rain,weatherImg);
        }

        else if(weatherState.equalsIgnoreCase("s")){
            //assign weatherImg
            provideGlide(Showers,weatherImg);
        }
        else if(weatherState.equalsIgnoreCase("hc")){
            //assign weatherImg
            provideGlide(Heavy_Cloud,weatherImg);
        }
        else if(weatherState.equalsIgnoreCase("lc")){
            //assign weatherImg
            provideGlide(Light_Cloud,weatherImg);
        }
        else if(weatherState.equalsIgnoreCase("c")){
            //assign weatherImg
            provideGlide(Clear,weatherImg);
        }
    }



    public void  provideGlide(String Url, ImageView imageView) {

        Glide.with(mContext)
                .load(Url)
                .into(imageView);


    }


        public void  DailySearchViewHolder() {


            mMonText = findViewById(R.id.textMon);
            mTueText = findViewById(R.id.textTue);
            mWedText = findViewById(R.id.textWed);
            mThurText =findViewById(R.id.textThur);
            mFriText = findViewById(R.id.textFri);
            mSatText = findViewById(R.id.textSat);
            mSunText = findViewById(R.id.textSun);


            mMonImg = findViewById(R.id.imgMonImg);
            mTueImg = findViewById(R.id.imgTueImg);
            mWedImg = findViewById(R.id.imgWedImg);
            mThurImg = findViewById(R.id.imgThurImg);
            mFriImg = findViewById(R.id.imgFriImg);
            mSatImg = findViewById(R.id.imgSatImg);
            mSunImg = findViewById(R.id.imgSunImg);


            setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {




        }




}
