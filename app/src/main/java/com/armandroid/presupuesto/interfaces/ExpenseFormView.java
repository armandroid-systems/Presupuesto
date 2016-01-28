package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Expenses;
import com.armandroid.presupuesto.model.Tdc;

import java.util.List;

/**
 * Created by armando.dominguez on 28/01/2016.
 */
public interface ExpenseFormView {

    void setCategoriesData(List categories);
    void setMonthsData();
    void setCardData(List cardData);
    void showSpinnerMonths();
    void hideSpinnerMonths();
    void showSpinnerCards();
    void hideSpinnerCards();
    void showCheckMonths();
    void hideCheckMonths();
    void hideCheckCredit();
    void showCheckCredit();
    void cleanFields();
    void showMessageState(String message);
    void onCheckedButton(int viewId, Expenses expense, boolean state);
    void onSpinnerItemSelected(int viewId, Expenses expense, int position);
    void onClickPressed(int viewId, Expenses expense);
    void setDataForm(Expenses expenses);
}
