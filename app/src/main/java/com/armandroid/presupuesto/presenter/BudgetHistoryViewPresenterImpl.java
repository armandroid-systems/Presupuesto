package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.BudgetHistoryView;
import com.armandroid.presupuesto.interfaces.BudgetHistoryViewPresenter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Budget;


import java.util.List;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class BudgetHistoryViewPresenterImpl implements BudgetHistoryViewPresenter, BousinessCallback, ClickListener{

    private BudgetHistoryView budgetHistoryView;
    private CurdBoussinesInteractorImpl historyInteractor;
    private Budget[] budgetArray;

    public BudgetHistoryViewPresenterImpl(CurdBoussinesInteractorImpl interactor, BudgetHistoryView bhv) {
        this.budgetHistoryView = bhv;
        this.historyInteractor = interactor;
    }

    @Override
    public void getBudgets(int idUser) {
        historyInteractor.getBudget(idUser,this);
    }

    @Override
    public void onElementClicked(int viewId) {
        switch(viewId){
            case R.id.toBudget:
                budgetHistoryView.goToBudgetForm();
                break;
            default:
                break;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSucces(Object param) {
       budgetArray = new Budget[((List<Budget>) param).size()];
       ((List<Budget>)param).toArray(budgetArray);
        budgetHistoryView.createRecyclerView(budgetHistoryView.getBudgetAdapter(budgetArray,this));


    }

    @Override
    public void onSuccesInsert(Object param) {

    }

    @Override
    public void onError(Object param) {

    }

    @Override
    public void onClickLinkListener(int identifier) {
        budgetHistoryView.goToDetail(budgetArray[identifier].getId().intValue());
    }

    @Override
    public void actionClickListener(int identifier, int operation) {

    }
}
