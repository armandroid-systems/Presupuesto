package com.armandroid.presupuesto.interactor;

import com.armandroid.presupuesto.interfaces.BousinessCallback;

/**
 * Created by armando.dominguez on 11/01/2016.
 */
public interface ExpenseInteractor {

    void getCatalogsAndUsers(String[] elements, BousinessCallback callback);
    void insertGeneric(Object param, BousinessCallback callback);
}
