package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public interface CurdPresenter {

    void insertRecord(Object param);
    void getAListOfRecords(Class param, int key);
    void updateARecord(Object param);
    void getConfigData(String[] params);
    void insertConfigData(String desc, float mount, Users user);
    void getBudget(int keyUser);
    void getBudgetDetail(int keyBudget);
}
