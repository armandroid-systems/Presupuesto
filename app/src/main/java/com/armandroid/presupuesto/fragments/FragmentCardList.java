package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.adapters.CardRecyclerAdapter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

import java.util.List;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardList extends BaseFragment implements ClickListener, ViewListener, View.OnClickListener {

    private RecyclerView cardList;
    private Tdc[] cardsArray;
    private FloatingActionButton toCreditCard;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardView = inflater.inflate(R.layout.fragment_card_list,container, false);

        cpiObject = new CurdPresenterImpl(getContext(),this);

        cardList = (RecyclerView) cardView.findViewById(R.id.recyclerCards);
        toCreditCard = (FloatingActionButton) cardView.findViewById(R.id.toCard);
        toCreditCard.setOnClickListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cardList.setLayoutManager(llm);

        cpiObject.getAListOfRecords(Tdc.class,0);

        cardList.setAdapter(new CardRecyclerAdapter(cardsArray,this));

        return cardView;
    }

    @Override
    public void onClickLinkListener(int identifier) {
        toNewScreen(cardsArray[identifier]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toCard:
                toNewScreen(new Tdc());
                break;
            default:
                break;
        }
    }

    @Override
    public void actionClickListener(int identifier, int operation) {

    }

    @Override
    public void showMessage(String error) {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void navigate(Object param) {
        cardsArray = new Tdc[((List<Tdc>)param).size()];
        cardsArray = ((List<Tdc>) param).toArray(cardsArray);

    }
    public void toNewScreen(Tdc element){
        try {
            ScreenManager.screenChange(getActivity(),R.id.mainActivityWrapper,
                    FragmentCardDetail.class,
                    element,
                    Constants.VIEW_CARD_DET,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }
}
