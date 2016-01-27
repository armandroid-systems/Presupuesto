package com.armandroid.presupuesto.interfaces;

/**
 * Created by armando.dominguez on 27/01/2016.
 */
public interface BudgetDetailViewPresenter {

    void getBudgetDetail(long idBudget);
    void onClickResponse(int viewId);
}
