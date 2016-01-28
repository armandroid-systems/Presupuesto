package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Expenses;

/**
 * Created by armando.dominguez on 28/01/2016.
 */
public interface ExpenseFormViewPresenter {

    void getCatalogObject(int idUser);
    void saveExpense(Expenses expense);
    void onCheckedChange(int viewId, Expenses expense, boolean state);
    void onSpinnerItemClicked(int viewId, Expenses expense, int position);
    void onSavePressed(int viewId, Expenses expense);
    void putFormDataIfExists(Expenses expense);
    void setCategorie(Expenses expense, int position);
    void setCard(Expenses expense, int position);
    void setMonths(Expenses expense, int position);

}
