package com.armandroid.presupuesto.presenter;



import android.util.Log;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.SplashView;
import com.armandroid.presupuesto.interfaces.SplashViewPresenter;
import com.armandroid.presupuesto.model.CatWrapper;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class SplashViewPresenterImpl implements SplashViewPresenter, BousinessCallback{
    private final static String TAG = SplashViewPresenterImpl.class.getSimpleName();

    private SplashView mSplashView;
    private CurdBoussinesInteractorImpl interactor;
    private CatWrapper element;

    public SplashViewPresenterImpl(SplashView mSplashView, CurdBoussinesInteractorImpl interactor) {
        this.mSplashView = mSplashView;
        this.interactor = interactor;
    }

    @Override
    public void getInitialData(String[] initialLoad) {
        mSplashView.showProgress();
        interactor.getConfigData(initialLoad, this);
    }

    @Override
    public void onSucces(Object param) {
        Log.d(TAG,"ON SUCCESS NORMAL...");
        element = (CatWrapper) param;
        if(element.arrayUsers.isEmpty()){
            mSplashView.goIntro();
        }else{
            mSplashView.goMain(((Users)element.arrayUsers.get(0)).getId());
        }
        mSplashView.hideProgress();
    }

    @Override
    public void onSuccesInsert(Object param) {
        Log.d(TAG,"ON SUCCESS INSERT DO NOTHING...");
    }

    @Override
    public void onError(Object param) {
        mSplashView.hideProgress();
        mSplashView.showNotificationMessage((String)param);
    }
}
