package com.armandroid.presupuesto.presenter;

import android.app.Activity;
import android.content.Intent;

import com.armandroid.presupuesto.activities.IntroActivity;
import com.armandroid.presupuesto.activities.MainActivity;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.SplashView;
import com.armandroid.presupuesto.interfaces.SplashViewPresenter;
import com.armandroid.presupuesto.model.CatWrapper;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class SplashViewPresenterImpl implements SplashViewPresenter, BousinessCallback{

    private SplashView mSplashView;
    private Activity mActivity;
    private CurdBoussinesInteractorImpl interactor;
    private CatWrapper element;

    public SplashViewPresenterImpl(SplashView mSplashView, Activity mActivity) {
        this.mSplashView = mSplashView;
        this.mActivity = mActivity;
        this.interactor = new CurdBoussinesInteractorImpl(mActivity);
    }

    @Override
    public void getInitialData(String[] initialLoad) {
        mSplashView.showProgress();
        interactor.getConfigData(initialLoad, this);
    }

    @Override
    public void onSucces(Object param) {
        element = (CatWrapper) param;
        if(element.arrayUsers.isEmpty()){
            mActivity.startActivity(new Intent(mActivity, IntroActivity.class));
            mActivity.finish();
        }else{
            mActivity.startActivity(new Intent(mActivity, MainActivity.class));
            mActivity.finish();
        }
        mSplashView.hideProgress();
    }

    @Override
    public void onError(Object param) {
        mSplashView.hideProgress();
        mSplashView.showNotificationMessage();
    }
}
