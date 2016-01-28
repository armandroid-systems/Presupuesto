package com.armandroid.presupuesto.interactor;

import android.content.Context;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.CurdBoussinesInteractor;
import com.armandroid.presupuesto.model.AppDaoClass;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public class CurdBoussinesInteractorImpl implements CurdBoussinesInteractor {
    private final static String TAG = CurdBoussinesInteractorImpl.class.getSimpleName();

    private AppDaoClass mDao;

    public CurdBoussinesInteractorImpl(Context cntx) {
        this.mDao = new AppDaoClass(cntx);
    }

    @Override
    public void insertRecord(Object param, BousinessCallback bcb) {
        try{
            bcb.onSuccesInsert(mDao.genericInsert(param));
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
            bcb.onSucces(mDao.updateGeneric(param));
        }catch(Exception ex){
            bcb.onError(ex.getMessage());
        }
    }

    @Override
    public void getConfigData(String[] params, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.getCatalogs(params));
        }catch(Exception e){
            bcb.onError(e.getMessage());
        }
    }

    @Override
    public void insertConfigData(String desc, float moneyEntry, Users user, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.insertBundle(desc, moneyEntry,user));
        }catch(Exception e){
            bcb.onError(e.getMessage());
        }
    }

    @Override
    public void getBudgetDetail(int keyBudget, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.getAllAboutBudget(keyBudget));
        }catch(Exception e){
            bcb.onError(e.getMessage());
        }
    }

    @Override
    public void getBudget(int keyUser, BousinessCallback bcb) {
        try{
            bcb.onSucces(mDao.getBudget(Budget.class, keyUser));
        }catch(Exception e){
            bcb.onError(e.getMessage());
        }
    }
}
