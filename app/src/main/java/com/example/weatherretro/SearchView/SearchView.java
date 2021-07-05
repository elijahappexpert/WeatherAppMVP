package com.example.weatherretro.SearchView;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weatherretro.HomeView.MainActivity;
import com.example.weatherretro.R;
import com.example.weatherretro.adapter.SearchAdapter;
import com.example.weatherretro.model.Model;
import com.example.weatherretro.mvp.IWeatherListContract;
import com.example.weatherretro.mvp.WeatherListPresenter_Impl;

import java.util.ArrayList;
import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class SearchView extends Fragment implements IWeatherListContract.IView, SearchClickListener {
    View view;
    private RecyclerView mEmailRecyclerview;
    private Context context;
    private EditText SearchCity;
    List<Model> Searchlist;
    IWeatherListContract.IPresenter mPresenter;
    WeatherListPresenter_Impl weatherListImplPresenter;
    private SearchAdapter searchAdapter;
    private  String query;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.search_fragment, container, false);
        SearchCity  = view.findViewById(R.id.citysearch);
        mEmailRecyclerview = view.findViewById(R.id.cities_recyclerview);

        //if(query == null){query = "dallas";}

        weatherListImplPresenter= new WeatherListPresenter_Impl(SearchView.this,query );

        context = getContext();

        displayResults(SearchCity);

        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static SearchView newInstance(String weatherDataKey, List<Model> WeatherData) {
        SearchView fragment = new SearchView();
        Bundle args = new Bundle();
        args.putParcelableArrayList(weatherDataKey, (ArrayList<? extends Parcelable>) WeatherData);
        fragment.setArguments(args);
        return fragment;
    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void displayResults(EditText editText){

        query = editText.getText().toString();



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adaptOnChange(s.toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adaptOnChange(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                adaptOnChange(s.toString());

            }


        });

       //first of all, use Viemodel providrs to initialize your viewmodel
        //the problem is, providers only works with viewmodels that have no argruments
        //TODO: implement viewmodel factory


    }

    private void adaptOnChange(String s2) {
        query = s2;

        weatherListImplPresenter = new WeatherListPresenter_Impl(SearchView.this, query);
        weatherListImplPresenter.LoadWeatherData();

        if (Searchlist != null) {

            searchAdapter = new SearchAdapter(Searchlist, SearchView.this);
            mEmailRecyclerview.setAdapter(searchAdapter);

            mEmailRecyclerview.setLayoutManager(new LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false));

            searchAdapter.notifyDataSetChanged();
            mEmailRecyclerview.setNestedScrollingEnabled(false);

        }
    }


    @Override
    public void onResume(){
        super.onResume();
        weatherListImplPresenter.start();
    }


    @Override
    public void onCityClicked(Model SearchResults) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("SearchView", "from_SearchViewReceiver");
        intent.putExtra("Title", SearchResults.getTitle());
        intent.putExtra("WoeID",SearchResults.getWoeid());
        startActivity(intent);

    }


    @Override
    public void showProgresDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void passDataAdapter(List<Model> Weather) {

       Searchlist = Weather;

    }

    @Override
    public void setPresenter(IWeatherListContract.IPresenter presenter) {
        mPresenter= checkNotNull(presenter);

    }


}