package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.adapters.CardRecyclerAdapter;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.CardListView;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.CardListVIewPresenterImpl;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

import java.util.List;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardList extends BaseFragment implements CardListView, View.OnClickListener {
    private final static String TAG = FragmentCardList.class.getSimpleName();

    private RecyclerView cardList;
    private FloatingActionButton toCreditCard;
    private CardListVIewPresenterImpl cardPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardView = inflater.inflate(R.layout.fragment_card_list,container, false);

        cardPresenter = new CardListVIewPresenterImpl(new CurdBoussinesInteractorImpl(getActivity()),this);

        cardList = (RecyclerView) cardView.findViewById(R.id.recyclerCards);

        toCreditCard = (FloatingActionButton) cardView.findViewById(R.id.toCard);
        toCreditCard.setOnClickListener(this);

        cardPresenter.getCardsOfUser(0);

        return cardView;
    }

   @Override
    public void onClick(View v) {
        cardPresenter.getOnClickListener(v.getId());
    }

    public void toNewScreen(Bundle bundle){
        try {
            ScreenManager.screenChange(getActivity(),R.id.mainActivityWrapper,
                    FragmentCardDetail.class,
                    bundle,
                    Constants.VIEW_CARD_DET,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CardRecyclerAdapter getCardRecyclerAdapter(Tdc[] arrayTdc, ClickListener listener) {
        return new CardRecyclerAdapter(arrayTdc,listener);
    }

    @Override
    public void createRecyclerCard(CardRecyclerAdapter adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        cardList.setLayoutManager(llm);
        cardList.setAdapter(adapter);
    }

    @Override
    public void goToCardDetail(Tdc element) {
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(Constants.KEY_PARAMS_FRAGMENT, element);
        toNewScreen(mBundle);
    }

    @Override
    public void addNewCard() {
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(Constants.KEY_PARAMS_FRAGMENT,
                new Tdc(0l,"",0f,0f));
        toNewScreen(mBundle);
    }

    @Override
    public void showMessageState(String message) {
        Log.d(TAG,"THIS IS HAPPENING "+message);
    }
}
