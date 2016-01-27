package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.adapters.BudgetRecyclerAdapter;
import com.armandroid.presupuesto.model.Budget;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface BudgetHistoryView {

    BudgetRecyclerAdapter getBudgetAdapter(Budget[] elements, ClickListener listener);
    void createRecyclerView(BudgetRecyclerAdapter adapter);
    void goToDetail(int id);
    void goToBudgetForm();
}
