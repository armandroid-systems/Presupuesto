package com.armandroid.presupuesto.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public class ConnectionFactory {
    private final static String TAG = ConnectionFactory.class.getSimpleName();

    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase database;
    public static DaoMaster daoMaster;


    public ConnectionFactory(Context context){
        Log.d(TAG, "CREATING DATABASE...");

        helper = new DaoMaster.DevOpenHelper(context,"recibos",null);
        try{
            database = helper.getWritableDatabase();
        }catch(Exception ex){
            Log.e(TAG,"EXCEPTION CREATING SCHEMA ["+ex+"]");
        }
        daoMaster = new DaoMaster(database);
        return;
    }

    public void closeDataBase(){
        Log.d(TAG,"CLOSING DATABASE CONNECTION...");
        if(helper != null){
            helper.close();
        }
    }
}
