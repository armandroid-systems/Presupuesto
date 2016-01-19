package com.armandroid.presupuesto.interactor;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 18/01/2016.
 */
public interface CurdBoussinesInteractor {

    void insertRecord(Object param, BousinessCallback bcb);
    void getAListOfRecords(Class param, int key, BousinessCallback bcb);
    void updateARecord(Object param, BousinessCallback bcb);
    void getConfigData(String[]params, BousinessCallback bcb);
    void insertConfigData(String desc, float moneyEntry, Users user, BousinessCallback bcb);
    void getBudget(int keyUser, BousinessCallback bcb);
    void getBudgetDetail(int keyBudget, BousinessCallback bcb);

}
