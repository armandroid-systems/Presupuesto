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
import com.armandroid.presupuesto.adapters.ExpenseRecyclerAdapter;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.presenter.BudgetPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;
import com.txusballesteros.widgets.FitChart;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentBudgetDetail extends BaseFragment implements ViewListener, View.OnClickListener{

    private FitChart budgetChartDetail;
    private RecyclerView recyclerExpenses;
    private FloatingActionButton expenseFab;
    private Budget budgetComplete;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View budgetDetail = inflater.inflate(R.layout.fragment_budget_detail, container, false);

        BudgetPresenterImpl budgetPresenter = new BudgetPresenterImpl(getContext(),this);

        recyclerExpenses = (RecyclerView) budgetDetail.findViewById(R.id.recyclerDetail);
        budgetChartDetail = (FitChart) budgetDetail.findViewById(R.id.budgetChartDetail);
        expenseFab = (FloatingActionButton) budgetDetail.findViewById(R.id.toExpense);

        if(mParam != null){
            budgetPresenter.getBudgetDetail(((Budget)mParam).getId().intValue());
        }

        expenseFab.setOnClickListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());


        recyclerExpenses.setLayoutManager(llm);
        recyclerExpenses.setAdapter(new ExpenseRecyclerAdapter(budgetComplete.getBudgetExpenses()));

        return budgetDetail;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.toExpense:
                try {
                    ScreenManager.screenChange(getActivity(),
                            R.id.mainActivityWrapper,
                            FragmentExpenseForm.class,
                            budgetComplete,
                            Constants.VIEW_EXPENSE,
                            Constants.BIN_FALSE);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void showMessage(String error) {
    }

    @Override
    public void navigate(Object param) {
        budgetComplete = (Budget)param;

        budgetChartDetail.setMaxValue(budgetComplete.getMoney());
        budgetChartDetail.setMinValue(0f);

        budgetChartDetail.setValue(budgetComplete.getBalance());
    }
}
