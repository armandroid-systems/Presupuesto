package com.armandroid.presupuesto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.SplashView;
import com.armandroid.presupuesto.model.CatWrapper;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.presenter.SplashViewPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.UtilFunctions;

import java.util.List;

public class SplashActivity extends BaseActivity implements SplashView{
    private final static String TAG = SplashActivity.class.getSimpleName();

    private SplashViewPresenterImpl splashPresenter;
    private ProgressBar splashProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashProgress = (ProgressBar) findViewById(R.id.progressBarSplash);

        splashPresenter = new SplashViewPresenterImpl(this, this);
        splashPresenter.getInitialData(getResources().getStringArray(R.array.categories_array));



/*
        List mUsers = ((CatWrapper)this.getApplication()).arrayUsers;


        if(!mUsers.isEmpty()){
            Log.d(TAG, "PARAM NOT NULL...");
            startActivity(new Intent(SplashActivity.this,
                    MainActivity.class).putExtra(Constants.KEY_ACTIVITY_PARAM,
                    (Users)mUsers.get(0)));
            finish();
        }else{
            Log.d(TAG,"PARAM NULL...");
            startActivity(new Intent(SplashActivity.this,IntroActivity.class));
            finish();
        }
    }*/



}
    @Override
    public void showNotificationMessage() {

    }

    @Override
    public void hideProgress() {
        splashProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        splashProgress.setVisibility(View.GONE);
    }
}


