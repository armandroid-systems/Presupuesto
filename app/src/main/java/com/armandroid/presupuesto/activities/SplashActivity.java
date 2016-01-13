package com.armandroid.presupuesto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.presenter.UsersPresenter;
import com.armandroid.presupuesto.presenter.UsersPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;

import java.util.List;

public class SplashActivity extends BaseActivity implements ViewListener{
    private final static String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new UsersPresenterImpl(SplashActivity.this, this).checkUsersAndCatalogs(getResources().getStringArray(R.array.categories_array));

    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        if(!((List<Users>)param).isEmpty()){
            Log.d(TAG, "PARAM NOT NULL...");
            Users data = ((List<Users>)param).get(0);
            startActivity(new Intent(SplashActivity.this, MainActivity.class).putExtra(Constants.KEY_ACTIVITY_PARAM,data));
            finish();
        }else{
            Log.d(TAG,"PARAM NULL...");
            startActivity(new Intent(SplashActivity.this,IntroActivity.class));
            finish();
        }
    }
}
