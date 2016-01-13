package com.armandroid.presupuesto.presenter;

import android.content.Context;

import com.armandroid.presupuesto.interactor.ExpenseIntereactorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.ViewListener;

/**
 * Created by armando.dominguez on 12/01/2016.
 */
public class ExpensePresenterImpl implements ExpensePresenter, BousinessCallback{
    private final static String TAG = ExpensePresenterImpl.class.getSimpleName();

    private ViewListener mListener;
    private ExpenseIntereactorImpl expenseInteractor;

    public ExpensePresenterImpl(Context ctx, ViewListener mListener) {
        this.mListener = mListener;
        this.expenseInteractor = new ExpenseIntereactorImpl(ctx);
    }

    @Override
    public void getCatalogs(int key) {
        expenseInteractor.getCategories(key, this);
    }

    @Override
    public void insertExpense(Object param) {
        expenseInteractor.insertGeneric(param, this);
    }

    @Override
    public void onSucces(Object param) {
        mListener.navigate(param);
    }

    @Override
    public void onError(Object param) {

    }
}
