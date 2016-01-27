package com.armandroid.presupuesto.interfaces;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface BudgetForm {
    void showNotificationMessage(String message);
    boolean validateData();
    void goToMenu(long id);
}
