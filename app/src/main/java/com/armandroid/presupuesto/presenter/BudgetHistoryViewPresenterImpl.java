package com.armandroid.presupuesto.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.fragments.FragmentBudgetDetail;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.BudgetHistoryView;
import com.armandroid.presupuesto.interfaces.BudgetHistoryViewPresenter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

import java.util.List;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class BudgetHistoryViewPresenterImpl implements BudgetHistoryViewPresenter, BousinessCallback, ClickListener{
//TEST
    private Activity mActivity;
    private BudgetHistoryView bhv;
    private CurdBoussinesInteractorImpl historyInteractor;

    public BudgetHistoryViewPresenterImpl(Activity mActivity, BudgetHistoryView bhv) {
        this.mActivity = mActivity;
        this.bhv = bhv;
        this.historyInteractor = new CurdBoussinesInteractorImpl(this.mActivity);
    }

    @Override
    public void getBudgets(int idUser) {
        historyInteractor.getBudget(idUser,this);
    }

    @Override
    public void onElementClicked(ClickListener listener) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSucces(Object param) {
       Budget[] budgetArray = new Budget[((List<Budget>)param).size()];
       ((List<Budget>)param).toArray(budgetArray);
        bhv.getBudgetAdapter(budgetArray,this);


    }

    @Override
    public void onError(Object param) {

    }

    @Override
    public void onClickLinkListener(int identifier) {
        Bundle mBundle = new Bundle();
        mBundle.putInt(Constants.KEY_PARAMS_FRAGMENT,identifier);
        try {
            ScreenManager.screenChange((FragmentActivity)mActivity,
                    R.id.mainActivityWrapper,
                    FragmentBudgetDetail.class,
                    mBundle,
                    Constants.VIEW_BUDGET_DET,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionClickListener(int identifier, int operation) {

    }
}
