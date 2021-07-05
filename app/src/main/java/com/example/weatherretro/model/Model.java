package com.example.weatherretro.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Model implements Parcelable {
    private String title, location_type;
    private int woeid;

    public Model() {
    }

    public Model(String title, String location_type, int woeid) {
        this.title = title;
        this.location_type = location_type;
        this.woeid = woeid;

    }

    protected Model(Parcel in) {
        title = in.readString();
        location_type = in.readString();
        woeid = in.readInt();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWoeid() {
        return woeid;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(location_type);
        dest.writeInt(woeid);
    }
}