package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.BudgetDetailView;
import com.armandroid.presupuesto.interfaces.BudgetDetailViewPresenter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Budget;

/**
 * Created by armando.dominguez on 27/01/2016.
 */
public class BudgetDetailViewPresenterImpl implements BudgetDetailViewPresenter, BousinessCallback, ClickListener{
    private final static String TAG = BudgetFormPresenterImpl.class.getSimpleName();

    private CurdBoussinesInteractorImpl interactor;
    private BudgetDetailView budgetDetailView;
    private Budget theBudget;

    public BudgetDetailViewPresenterImpl(CurdBoussinesInteractorImpl interactor, BudgetDetailView budgetDetailView) {
        this.interactor = interactor;
        this.budgetDetailView = budgetDetailView;
    }

    @Override
    public void getBudgetDetail(int idBudget) {
        interactor.getBudgetDetail(idBudget,this);
    }

    @Override
    public void onClickResponse(int viewId) {
        switch(viewId){
            case R.id.toExpense:
                budgetDetailView.goToAddExpense();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClickLinkListener(int identifier) {

    }

    @Override
    public void actionClickListener(int identifier, int operation) {
        switch(operation){
            case 1:
                budgetDetailView.goToExpense(theBudget.getBudgetExpenses()[identifier]);
                break;
            case 2:
                //ELIMINAR GASTO
                break;
            default:
                break;
        }
    }

    @Override
    public void onSucces(Object param) {
        theBudget = (Budget)param;
        budgetDetailView.createRecyclerExpenses(
                budgetDetailView.getExpenseAdapter(theBudget.getBudgetExpenses(),this));
        budgetDetailView.setGraphData(theBudget);
    }

    @Override
    public void onSuccesInsert(long idInsert) {

    }

    @Override
    public void onSuccessUpdate(boolean updateState) {

    }

    @Override
    public void onError(Object param) {
            budgetDetailView.showMessageState((String)param);
    }
}
