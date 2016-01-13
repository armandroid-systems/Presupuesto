package com.armandroid.presupuesto.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.armandroid.presupuesto.R;

/**
 * Created by armando.dominguez on 04/01/2016.
 */
public class ExpenseHolder extends RecyclerView.ViewHolder {

    public TextView mount;
    public TextView category;

    public ExpenseHolder(View itemView) {
        super(itemView);
        mount    = (TextView) itemView.findViewById(R.id.expenseMount);
        category = (TextView) itemView.findViewById(R.id.expenseCategory);
    }
}
