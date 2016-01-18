package com.armandroid.presupuesto.interactor;

import android.content.Context;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.AppDaoClass;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public class CurdBoussinesInteractorImpl implements CurdBoussinesInteractor{
    private final static String TAG = CurdBoussinesInteractorImpl.class.getSimpleName();

    private AppDaoClass mDao;

    public CurdBoussinesInteractorImpl(Context cntx) {
        this.mDao = new AppDaoClass(cntx);
    }

    @Override
    public void insertRecord(Object param, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.genericInsert(param));
        }catch(Exception ex){
            bcb.onError(ex.getMessage());
        }

    }

    @Override
    public void getAListOfRecords(Class param, int key, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.getGeneric(param,key));
        }catch(Exception ex){
            bcb.onError(ex.getMessage());
        }

    }

    @Override
    public void updateARecord(Object param, BousinessCallback bcb) {
        try{
            bcb.onSucces(param);
        }catch(Exception ex){
            bcb.onError(ex.getMessage());
        }
    }
}
