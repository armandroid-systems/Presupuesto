package com.armandroid.presupuesto.interactor;

import com.armandroid.presupuesto.interfaces.BousinessCallback;

import javax.security.auth.callback.Callback;

/**
 * Created by armando.dominguez on 11/01/2016.
 */
public interface BudgetInteractor {

    void getBudgets(int id, BousinessCallback callaback);
    void getBudgetDetail(int id, BousinessCallback callback);
}
