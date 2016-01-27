package com.armandroid.presupuesto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.SplashView;
import com.armandroid.presupuesto.presenter.SplashViewPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;

public class SplashActivity extends BaseActivity implements SplashView{
    private final static String TAG = SplashActivity.class.getSimpleName();

    private SplashViewPresenterImpl splashPresenter;
    private ProgressBar splashProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashProgress = (ProgressBar) findViewById(R.id.progressBarSplash);

        splashPresenter = new SplashViewPresenterImpl(this, new CurdBoussinesInteractorImpl(this));
        splashPresenter.getInitialData(getResources().getStringArray(R.array.categories_array));

}
    @Override
    public void showNotificationMessage(String message) {
        Log.d(TAG,"WHAT IS HAPPENING ["+message+"]");
    }

    @Override
    public void hideProgress() {
        splashProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        splashProgress.setVisibility(View.GONE);
    }

    @Override
    public void goMain(long idUser) {
        startActivity(new Intent(SplashActivity.this, MainActivity.class).
                    putExtra(Constants.KEY_PARAMS_FRAGMENT,
                            idUser));
          finish();
    }

    @Override
    public void goIntro() {
         startActivity(new Intent(SplashActivity.this, IntroActivity.class));
         finish();
    }
}


