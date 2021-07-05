package com.example.weatherretro.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public String returnDay (String input) throws ParseException {
        String day = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date dt1 = format.parse(input);

        DateFormat formatDay = new SimpleDateFormat("EEEE");

        day = formatDay.format(dt1);

        return day;
    }

}
