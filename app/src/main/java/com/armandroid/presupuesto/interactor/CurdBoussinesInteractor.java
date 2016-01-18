package com.armandroid.presupuesto.interactor;

import com.armandroid.presupuesto.interfaces.BousinessCallback;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public interface CurdBoussinesInteractor {

    void insertRecord(Object param, BousinessCallback bcb);
    void getAListOfRecords(Class param, int key, BousinessCallback bcb);
    void updateARecord(Object param, BousinessCallback bcb);

}
