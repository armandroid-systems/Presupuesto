package com.armandroid.presupuesto.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ClickListener;

/**
 * Created by armando.dominguez on 04/01/2016.
 */
public class ExpenseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private final static String TAG = ExpenseHolder.class.getCanonicalName();

    public TextView mount;
    public TextView description;
    public TextView category;
    public TextView actionEdit;
    public TextView actionDelete;
    public ClickListener theListener;

    public ExpenseHolder(View itemView, ClickListener theListener) {
        super(itemView);
        this.theListener = theListener;
        mount          = (TextView) itemView.findViewById(R.id.expenseMount);
        description    = (TextView) itemView.findViewById(R.id.expenseDesc);
        category       = (TextView) itemView.findViewById(R.id.expenseCategory);
        actionDelete   = (TextView) itemView.findViewById(R.id.actionDelete);
        actionEdit     = (TextView) itemView.findViewById(R.id.actionEdit);
        actionEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.actionEdit:
                theListener.actionClickListener(getAdapterPosition(),1);
                break;
            default:
                break;

        }
    }
}
