package com.armandroid.presupuesto.presenter;

import android.content.Context;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.ViewListener;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public class CurdPresenterImpl implements CurdPresenter, BousinessCallback{
    private final static String TAG = CurdPresenterImpl.class.getSimpleName();

    private ViewListener mViewListener;
    private CurdBoussinesInteractorImpl mExecutioner;

    public CurdPresenterImpl(Context ctx, ViewListener mViewListener) {
        this.mViewListener = mViewListener;
        this.mExecutioner = new CurdBoussinesInteractorImpl(ctx);
    }

    @Override
    public void insertRecord(Object param) {
      mExecutioner.insertRecord(param, this);
    }

    @Override
    public void getAListOfRecords(Class param, int key) {
       mExecutioner.getAListOfRecords(param, key, this);
    }

    @Override
    public void updateARecord(Object param) {
       mExecutioner.updateARecord(param, this);
    }

    @Override
    public void onSucces(Object param) {
        mViewListener.navigate(param);
    }

    @Override
    public void onError(Object param) {
        mViewListener.showMessage((String)param);
    }
}
