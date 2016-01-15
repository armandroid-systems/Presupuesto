package com.armandroid.presupuesto.interactor;

import android.content.Context;
import android.util.Log;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.AppDaoClass;

/**
 * Created by armando.dominguez on 12/01/2016.
 */
public class ExpenseIntereactorImpl implements ExpenseInteractor{

    private AppDaoClass mDao;

    public ExpenseIntereactorImpl(Context ctx) {
        this.mDao = new AppDaoClass(ctx);
    }

    @Override
    public void getCatalogsAndUsers(String[] elements, BousinessCallback cb) {
        Log.d("INTERACTOR","GETTING CATEGORIES...");
        cb.onSucces(mDao.getCatalogs(elements));
    }

    @Override
    public void insertGeneric(Object param, BousinessCallback cb) {
        cb.onSucces(mDao.genericInsert(param));
    }
}
