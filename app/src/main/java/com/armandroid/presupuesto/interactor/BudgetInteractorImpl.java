package com.armandroid.presupuesto.interactor;

import android.content.Context;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.AppDaoClass;
import com.armandroid.presupuesto.model.Budget;

/**
 * Created by armando.dominguez on 11/01/2016.
 */
public class BudgetInteractorImpl implements BudgetInteractor {

    private AppDaoClass mDaoClass;

    public BudgetInteractorImpl(Context ctx) {
        this.mDaoClass = new AppDaoClass(ctx);
    }

    @Override
    public void getBudgets(int id, BousinessCallback callback) {
            callback.onSucces(mDaoClass.getBudget(Budget.class,id));
    }

    @Override
    public void getBudgetDetail(int id, BousinessCallback callback) {
        callback.onSucces(mDaoClass.getAllAboutBudget(id));
    }
}
