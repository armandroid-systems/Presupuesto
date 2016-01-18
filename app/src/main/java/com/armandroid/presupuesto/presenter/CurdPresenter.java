package com.armandroid.presupuesto.presenter;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public interface CurdPresenter {

    void insertRecord(Object param);
    void getAListOfRecords(Class param, int key);
    void updateARecord(Object param);

}
