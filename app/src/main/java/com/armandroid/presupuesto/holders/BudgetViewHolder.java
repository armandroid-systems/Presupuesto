package com.armandroid.presupuesto.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ClickListener;

/**
 * Created by armando.dominguez on 04/01/2016.
 */
public class BudgetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView budgetDate;
    public TextView initialMount;
    public TextView expensesMount;
    public TextView balance;
    public TextView link;
    private ClickListener mLinkListener;

    public BudgetViewHolder(View itemView, ClickListener linkListener) {
        super(itemView);
        this.mLinkListener = linkListener;

        budgetDate      = (TextView)itemView.findViewById(R.id.budgetDate);
        initialMount    = (TextView)itemView.findViewById(R.id.budgetInitialValue);
        expensesMount   = (TextView)itemView.findViewById(R.id.budgetExpenseValue);
        balance         = (TextView)itemView.findViewById(R.id.budgetBalanceValue);
        link            = (TextView)itemView.findViewById(R.id.linkMore);
        link.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linkMore:
                mLinkListener.onClickLinkListener(getAdapterPosition());
                break;
            default:
                break;
        }
    }
}
