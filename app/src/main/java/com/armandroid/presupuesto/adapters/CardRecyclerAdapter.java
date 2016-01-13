package com.armandroid.presupuesto.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.holders.CardHolder;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.CardVO;

/**
 * Created by armando.dominguez on 05/01/2016.
 */
public class CardRecyclerAdapter extends RecyclerView.Adapter<CardHolder> {

    private CardVO[] cardArray;
    private ClickListener elementListener;

    public CardRecyclerAdapter(CardVO[] paramArray, ClickListener listenerCardElement) {
        this.cardArray = paramArray;
        this.elementListener = listenerCardElement;
    }

    @Override
    public int getItemCount() {
        if(cardArray != null){
            return cardArray.length;
        }else{
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View creditCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler_item,parent,false);
        return new CardHolder(creditCardView, elementListener);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.cardName.setText(cardArray[position].name);
        holder.cardCredit.setText(""+cardArray[position].creditMount);
    }
}
