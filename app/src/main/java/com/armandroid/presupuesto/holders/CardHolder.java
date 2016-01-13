package com.armandroid.presupuesto.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ClickListener;

/**
 * Created by armando.dominguez on 05/01/2016.
 */
public class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cardName;
    public TextView cardCredit;
    public TextView moreInfo;
    private ClickListener itemClickListener;

    public CardHolder(View itemView, ClickListener paramListener) {
        super(itemView);
        this.itemClickListener = paramListener;
        cardName = (TextView) itemView.findViewById(R.id.cardCardName);
        cardCredit = (TextView) itemView.findViewById(R.id.cardCardCredit);
        moreInfo = (TextView) itemView.findViewById(R.id.linkToMore);
        moreInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linkToMore:
                itemClickListener.onClickLinkListener(getAdapterPosition());
                break;
            default:
                break;
        }
    }
}
