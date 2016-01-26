package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface BudgetFormPresenter {
    void saveBudgetInformation(String string, Float number, Users user);
}
