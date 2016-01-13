package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.adapters.CardRecyclerAdapter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.CardVO;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardList extends BaseFragment implements ClickListener {

    private RecyclerView cardList;
    private CardVO[] cardsArray = {new CardVO(1,"BBVA BANCOMER","N/A",24600),new CardVO(2,"SANTANDER","N/A",18700)};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardView = inflater.inflate(R.layout.fragment_card_list,container, false);

        cardList = (RecyclerView) cardView.findViewById(R.id.recyclerCards);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cardList.setLayoutManager(llm);
        cardList.setAdapter(new CardRecyclerAdapter(cardsArray,this));
        return cardView;
    }

    @Override
    public void onClickLinkListener(int identifier) {
        try {
            ScreenManager.screenChange(getActivity(),R.id.mainActivityWrapper,FragmentCardDetail.class,cardsArray[identifier],"0", Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }
}
