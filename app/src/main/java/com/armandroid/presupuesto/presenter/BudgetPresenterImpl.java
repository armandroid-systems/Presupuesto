package com.armandroid.presupuesto.presenter;

import android.content.Context;

import com.armandroid.presupuesto.interactor.BudgetInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.ViewListener;

/**
 * Created by armando.dominguez on 11/01/2016.
 */
public class BudgetPresenterImpl implements BudgetPresenter, BousinessCallback {
    private final static String TAG = BudgetPresenterImpl.class.getSimpleName();

    private BudgetInteractorImpl mImpl;
    private ViewListener mViewListener;

    public BudgetPresenterImpl(Context ctx, ViewListener vListener) {
        this.mImpl = new BudgetInteractorImpl(ctx);
        mViewListener = vListener;
    }

    @Override
    public void getBudget(int id) {
        mImpl.getBudgets(id, this);
    }

    @Override
    public void getBudgetDetail(int id) {
        mImpl.getBudgetDetail(id,this);
    }

    @Override
    public void onSucces(Object param) {
        mViewListener.navigate(param);
    }

    @Override
    public void onError(Object param) {

    }
}
