package com.armandroid.presupuesto.interfaces;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface BudgetHistoryViewPresenter {

    void onElementClicked(ClickListener listener);
    void getBudgets(int idUser);
}
