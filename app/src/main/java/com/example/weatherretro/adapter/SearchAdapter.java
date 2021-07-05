package com.example.weatherretro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherretro.R;
import com.example.weatherretro.SearchView.SearchClickListener;
import com.example.weatherretro.model.Model;

import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Model> Searches;
    private Context mContext;
    private SearchClickListener mListener;



    public SearchAdapter(List<Model> Searches, SearchClickListener listener ){
        this.Searches = Searches;
        mListener = listener;


    }


    public void SetSearch(List<Model> searchResult){
        this.Searches = searchResult;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View itemView = layoutInflater.inflate(R.layout.row_search_weather_item,
                parent,
                false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  SearchViewHolder holder, int position) {
             Model  SearcheResult = Searches.get(position);
             holder.mTitle.setText(SearcheResult.getTitle());
    }

    @Override
    public int getItemCount() {
        return Searches.size();
    }


    public class SearchViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public TextView mTitle;



        public  SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.Day);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onCityClicked(Searches.get(getBindingAdapterPosition()));
        }
    }


}