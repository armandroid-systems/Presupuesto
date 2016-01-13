package com.armandroid.presupuesto.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.holders.ExpenseHolder;
import com.armandroid.presupuesto.model.Expenses;

/**
 * Created by armando.dominguez on 04/01/2016.
 */
public class ExpenseRecyclerAdapter extends RecyclerView.Adapter<ExpenseHolder> {

    private Expenses[] theExpense;

    public ExpenseRecyclerAdapter(Expenses[] theExpense) {
        this.theExpense = theExpense;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return theExpense.length;
    }

    @Override
    public ExpenseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expenseItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_recycler_item,parent, false);
        return new ExpenseHolder(expenseItemView);
    }

    @Override
    public void onBindViewHolder(ExpenseHolder holder, int position) {
        holder.mount.setText("Monto: "+theExpense[position].getMount());
        holder.category.setText("Categoria:"+theExpense[position].getCategoryName());
    }
}
