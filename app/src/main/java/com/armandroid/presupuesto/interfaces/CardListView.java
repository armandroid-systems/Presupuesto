package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.adapters.CardRecyclerAdapter;
import com.armandroid.presupuesto.model.Tdc;

/**
 * Created by armando.dominguez on 29/01/2016.
 */
public interface CardListView {

    CardRecyclerAdapter getCardRecyclerAdapter(Tdc[] arrayTdc, ClickListener listener);
    void createRecyclerCard(CardRecyclerAdapter adapter);
    void goToCardDetail(Tdc element);
    void addNewCard();
    void showMessageState(String message);


}
