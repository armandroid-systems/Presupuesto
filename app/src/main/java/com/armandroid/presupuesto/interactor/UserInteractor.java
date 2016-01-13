package com.armandroid.presupuesto.interactor;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public interface UserInteractor {
    void checkForUsers(int id,BousinessCallback callback);
    void updateUser(Users user, BousinessCallback callback);
    void firstConfiguration(String desc, float moneyEntry, Users user, BousinessCallback callback);
    void checkUsersAndCatalogs(String[] params, BousinessCallback callback);
}
