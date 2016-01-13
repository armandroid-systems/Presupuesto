package com.armandroid.presupuesto.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.holders.BudgetViewHolder;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Budget;

/**
 * Created by armando.dominguez on 30/12/2015.
 */
public class BudgetRecyclerAdapter extends RecyclerView.Adapter<BudgetViewHolder>  {
    private static final String TAG = BudgetRecyclerAdapter.class.getSimpleName();

    private Budget[] mData;
    private ClickListener something;

    public BudgetRecyclerAdapter(Budget[] data, ClickListener something) {
        this.something = something;
        this.mData = data;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public BudgetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_recycler_item,parent,false);
        return new BudgetViewHolder(itemView,something);
    }

    @Override
    public void onBindViewHolder(BudgetViewHolder holder, int position) {
        holder.budgetDate.setText(mData[position].getDate());
        //TODO check format number
        holder.initialMount.setText("" + mData[position].getMoney());
        holder.expensesMount.setText("" + mData[position].getBalance());
        holder.balance.setText(""+(mData[position].getMoney() - mData[position].getBalance()));

    }

    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.length;
        }else{
            return 0;
        }
    }


}
