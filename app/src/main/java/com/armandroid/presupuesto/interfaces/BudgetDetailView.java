package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.adapters.ExpenseRecyclerAdapter;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.Expenses;

/**
 * Created by armando.dominguez on 27/01/2016.
 */
public interface BudgetDetailView {

    void setGraphData(Budget param);
    ExpenseRecyclerAdapter getExpenseAdapter(Expenses[] data, ClickListener listener);
    void createRecyclerExpenses(ExpenseRecyclerAdapter expenseAdapter);
    void showMessageState(String message);
    void goToExpense(Expenses expense);
    void goToAddExpense();
}
