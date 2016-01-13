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
import com.armandroid.presupuesto.adapters.BudgetRecyclerAdapter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.presenter.BudgetPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

import java.util.List;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentBudgetHistory extends BaseFragment implements ViewListener, ClickListener,View.OnClickListener {

    private Budget[] budgetArray;
    private RecyclerView mRecycler;
    private FloatingActionButton budgetFab;
    private BudgetPresenterImpl budgetPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View budgetHistory = inflater.inflate(R.layout.fragment_budget, container, false);

        budgetPresenter = new BudgetPresenterImpl(getContext(),this);

        mRecycler = (RecyclerView) budgetHistory.findViewById(R.id.recyclerBudget);
        budgetFab = (FloatingActionButton) budgetHistory.findViewById(R.id.toBudget);

        budgetFab.setOnClickListener(this);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        mRecycler.setLayoutManager(llm);
        if(mParam != null){
            budgetPresenter.getBudget(((Users) mParam).getId().intValue());
        }
        mRecycler.setAdapter(new BudgetRecyclerAdapter(budgetArray,this));

        return budgetHistory;
    }

    @Override
    public void onClickLinkListener(int identifier) {
        try {
            ScreenManager.screenChange(getActivity(),
                    R.id.mainActivityWrapper,
                    FragmentBudgetDetail.class,
                    budgetArray[identifier],
                    Constants.VIEW_BUDGET_DET,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.toBudget:
                break;
            default:
                break;
        }
    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public void navigate(Object param) {
        budgetArray = new Budget[((List<Budget>)param).size()];
        ((List<Budget>)param).toArray(budgetArray);
    }
}
