package com.example.weatherretro.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DailyModel implements Parcelable {

        private long id;
        private String weatherStateName;
        private String weatherStateAbbr;
        private String windDirectionCompass;
        private String created;
        private String applicableDate;
        private float minTemp;
        private float maxTemp;
        private float theTemp;
        private float windSpeed;
        private float windDirection;
        private float airPressure;
        private int humidity;
        private float visibility;
        private int predictability;


    protected DailyModel(Parcel in) {
        id = in.readLong();
        weatherStateName = in.readString();
        weatherStateAbbr = in.readString();
        windDirectionCompass = in.readString();
        created = in.readString();
        applicableDate = in.readString();
        minTemp = in.readFloat();
        maxTemp = in.readFloat();
        theTemp = in.readFloat();
        windSpeed = in.readFloat();
        windDirection = in.readFloat();
        airPressure = in.readFloat();
        humidity = in.readInt();
        visibility = in.readFloat();
        predictability = in.readInt();

    }

    public static final Creator<DailyModel> CREATOR = new Creator<DailyModel>() {
        @Override
        public DailyModel createFromParcel(Parcel in) {
            return new DailyModel(in);
        }


        @Override
        public DailyModel[] newArray(int size) {
            return new DailyModel[size];
        }
    };



    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getWeatherStateName() {
            return weatherStateName;
        }

        public void setWeatherStateName(String weatherStateName) {
            this.weatherStateName = weatherStateName;
        }

        public String getWeatherStateAbbr() {
            return weatherStateAbbr;
        }

        public void setWeatherStateAbbr(String weatherStateAbbr) {
            this.weatherStateAbbr = weatherStateAbbr;
        }

        public String getWindDirectionCompass() {
            return windDirectionCompass;
        }

        public void setWindDirectionCompass(String windDirectionCompass) {
            this.windDirectionCompass = windDirectionCompass;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getApplicableDate() {
            return applicableDate;
        }

        public void setApplicableDate(String applicableDate) {
            this.applicableDate = applicableDate;
        }

        public float getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(float minTemp) {
            this.minTemp = minTemp;
        }

        public float getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(float maxTemp) {
            this.maxTemp = maxTemp;
        }

        public float getTheTemp() {
            return theTemp;
        }

        public void setTheTemp(float theTemp) {
            this.theTemp = theTemp;
        }

        public float getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(float windSpeed) {
            this.windSpeed = windSpeed;
        }

        public float getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(float windDirection) {
            this.windDirection = windDirection;
        }

        public float getAirPressure() {
            return airPressure;
        }

        public void setAirPressure(float airPressure) {
            this.airPressure = airPressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public float getVisibility() {
            return visibility;
        }

        public void setVisibility(float visibility) {
            this.visibility = visibility;
        }

        public int getPredictability() {
            return predictability;
        }

        public void setPredictability(int predictability) {
            this.predictability = predictability;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(weatherStateName);
        dest.writeString(weatherStateAbbr);
        dest.writeString(windDirectionCompass);
        dest.writeString(created);
        dest.writeString(applicableDate);
        dest.writeFloat(minTemp);
        dest.writeFloat(maxTemp);
        dest.writeFloat(theTemp);
        dest.writeFloat(windSpeed);
        dest.writeFloat(windDirection);
        dest.writeFloat(airPressure);
        dest.writeInt(humidity);
        dest.writeFloat(visibility);
        dest.writeInt(predictability);
    }
}
