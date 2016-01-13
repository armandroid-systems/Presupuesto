package com.armandroid.presupuesto.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by armando.dominguez on 11/01/2016.
 */
public class UtilFunctions {

    public static String getCurrentDate(){
        SimpleDateFormat mFormat = new SimpleDateFormat("dd/MM/yyyy");
        mFormat.format(new Date());
        return mFormat.toString();
    }
}
