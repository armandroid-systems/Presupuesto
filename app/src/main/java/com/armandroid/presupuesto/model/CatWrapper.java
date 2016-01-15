package com.armandroid.presupuesto.model;

import android.app.Application;
import android.util.Log;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.presenter.ExpensePresenterImpl;

import java.util.List;

/**
 * Created by armando.dominguez on 04/01/2016.
 */
public class CatWrapper extends Application implements ViewListener{
    private final static String TAG = CatWrapper.class.getSimpleName();

    public List arrayTdc;
    public List arrayCategories;
    public List arrayUsers;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"GETTING CATALOGS...");
        new ExpensePresenterImpl(getApplicationContext(),this).getCatalogsAndUsers(getResources().getStringArray(R.array.categories_array));
    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        CatWrapper response = (CatWrapper) param;
        arrayCategories = response.arrayCategories;
        arrayTdc = response.arrayTdc;
        arrayUsers = response.arrayUsers;
    }
}
