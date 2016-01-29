package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.CardListView;
import com.armandroid.presupuesto.interfaces.CardListViewPresenter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.utils.Constants;

import java.util.List;

/**
 * Created by armando.dominguez on 29/01/2016.
 */
public class CardListVIewPresenterImpl implements CardListViewPresenter, BousinessCallback, ClickListener{

    private CurdBoussinesInteractorImpl interactor;
    private CardListView cardListView;
    private Tdc[] cardsArray;

    public CardListVIewPresenterImpl(CurdBoussinesInteractorImpl interactor, CardListView cardListView) {
        this.interactor = interactor;
        this.cardListView = cardListView;
    }

    @Override
    public void getCardsOfUser(long idUser) {
        interactor.getAListOfRecords(Tdc.class,0,this);

    }

    @Override
    public void getOnClickListener(int viewId) {
        cardListView.addNewCard();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSucces(Object param) {
        cardsArray = new Tdc[((List<Tdc>)param).size()];
        cardsArray = ((List<Tdc>) param).toArray(cardsArray);
        cardListView.createRecyclerCard(cardListView.getCardRecyclerAdapter(cardsArray, this));
    }

    @Override
    public void onSuccesInsert(long idInsert) {

    }

    @Override
    public void onSuccessUpdate(boolean updateState) {

    }

    @Override
    public void onError(Object param) {
        cardListView.showMessageState((String)param);
    }

    @Override
    public void onClickLinkListener(int identifier) {
        cardListView.goToCardDetail(cardsArray[identifier]);
    }

    @Override
    public void actionClickListener(int identifier, int operation) {

    }
}
