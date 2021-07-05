package com.example.weatherretro.HomeView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherretro.R;
import com.example.weatherretro.SearchView.SearchView;
import com.example.weatherretro.adapter.DailySearchAdapter;
import com.example.weatherretro.adapter.SearchAdapter;
import com.example.weatherretro.model.DailyModel;
import com.example.weatherretro.mvp.Homeviewmvp.DailyWeatherListContract;
import com.example.weatherretro.mvp.Homeviewmvp.DailyWeatherListPresenter_Impl;

import java.util.List;

import static com.example.weatherretro.Constants.Constants.FRAGMENT_LOG_TAG;
import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements DailyWeatherListContract.IView,DailySearchClickListener{

    ImageButton searchFragment;
    private Context context;
    List<DailyModel> DailySearchlist;
    DailyWeatherListContract.IPresenter mPresenter;
    DailyWeatherListPresenter_Impl dailyweatherListImplPresenter;
    int  WoeID;

    String Title;
    private DailySearchAdapter dailySearchAdapter;
    private LinearLayout mLinearDailySearch;



    private TextView mTitle;
    private TextView mDate;
    private TextView mTemp;
    private TextView mTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
        context = getBaseContext();
        searchFragment = findViewById(R.id.search);

        mTitle = findViewById(R.id.textViewTitle);
        mDate = findViewById(R.id.textViewDate);
        mLinearDailySearch = findViewById(R.id.linearLayouttop);

        context = getBaseContext();



        SearcViewIntent();

        setOnClicklisteners();

    }

    public void setOnClicklisteners(){
        searchFragment.setOnClickListener(v -> loadSearchFragment(new SearchView()));
    }



    public void SearcViewIntent(){

        Intent intent = getIntent();
        if(intent !=null)
        {
            String strdata = intent.getExtras().getString("SearchView");
            if(strdata.equals("from_SearchViewReceiver"))
            {
                 WoeID = intent.getIntExtra("WoeID",44418);
                 dailyweatherListImplPresenter= new DailyWeatherListPresenter_Impl(this,WoeID );

                 Title = intent.getStringExtra("Title");
                 mTitle.setText(Title);
            }

        }
        dailyweatherListImplPresenter.LoadWeatherData();

        if(DailySearchlist != null){

             dailySearchAdapter = new DailySearchAdapter(context,DailySearchlist,this);
            dailySearchAdapter.DailySearchViewHolder();

            for(int i = 0; i<DailySearchlist.size(); i++){
            dailySearchAdapter.onBindViewHolder(i);

            }
            mLinearDailySearch = dailySearchAdapter;

        }


    }


    public void setDays(){

      for(int i = 0; i<DailySearchlist.size(); i++){

          String date = DailySearchlist.get(i).getApplicableDate();
          Log.d("Log Date",date);

          String weatherState =  DailySearchlist.get(i).getWeatherStateAbbr();
          Log.d("weather State", weatherState);


      }



    }


    private void loadSearchFragment(SearchView searchView) {
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.add(R.id.fragment_container_view_tag,
                searchView,
                //set the tag in the third argument
                "search_fragment");

        Log.d(FRAGMENT_LOG_TAG, "SearchView Fragment Created");
        fragmentTransaction.addToBackStack("SearchView_fragment");
        Log.d(FRAGMENT_LOG_TAG, "SearchView Fragment Added To Backstack");

        fragmentTransaction.commit(); // save the changes


        }


    @Override
    public void showProgresDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void passDataAdapter(List<DailyModel> Weather) {

        DailySearchlist = Weather;

    }

    @Override
    public void setPresenter(DailyWeatherListContract.IPresenter presenter) {
        mPresenter= checkNotNull(presenter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onCityClicked(DailyModel DailySearchResults) {

    }
}