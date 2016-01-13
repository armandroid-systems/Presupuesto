package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public interface UsersPresenter {
    void checkUser(int id);
    void insertUser(String desc, float moneyUser, Users user);
    void checkUsersAndCatalogs(String[] elements);
}
