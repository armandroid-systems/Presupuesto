package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.adapters.ExpenseRecyclerAdapter;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.presenter.BudgetPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;
import com.armandroid.presupuesto.utils.UtilFunctions;
import com.txusballesteros.widgets.FitChart;

import org.w3c.dom.Text;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentBudgetDetail extends BaseFragment implements ViewListener, View.OnClickListener, ClickListener{

    private FitChart budgetChartDetail;
    private RecyclerView recyclerExpenses;
    private FloatingActionButton expenseFab;
    private TextView detailTotal;
    private TextView detailExpense;
    private TextView detailBalance;
    private Budget budgetComplete;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View budgetDetail = inflater.inflate(R.layout.fragment_budget_detail, container, false);

        BudgetPresenterImpl budgetPresenter = new BudgetPresenterImpl(getContext(),this);

        recyclerExpenses    = (RecyclerView) budgetDetail.findViewById(R.id.recyclerDetail);
        budgetChartDetail   = (FitChart) budgetDetail.findViewById(R.id.budgetChartDetail);
        expenseFab          = (FloatingActionButton) budgetDetail.findViewById(R.id.toExpense);
        detailTotal         = (TextView) budgetDetail.findViewById(R.id.textViewDetailTotal);
        detailExpense       = (TextView) budgetDetail.findViewById(R.id.textViewDetailExpense);
        detailBalance       = (TextView) budgetDetail.findViewById(R.id.textViewDetailBalance);

        if(mParam != null){
            budgetPresenter.getBudgetDetail(((Budget)mParam).getId().intValue());
        }

        expenseFab.setOnClickListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        recyclerExpenses.setHasFixedSize(true);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerExpenses.setLayoutManager(llm);
        recyclerExpenses.setAdapter(new ExpenseRecyclerAdapter(budgetComplete.getBudgetExpenses(), this));

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

        detailTotal.setText(UtilFunctions.formatTwoDecimals(budgetComplete.getMoney()));
        detailExpense.setText(UtilFunctions.formatTwoDecimals(budgetComplete.getBalance()));
        detailBalance.setText(UtilFunctions.formatTwoDecimals(budgetComplete.getMoney() - budgetComplete.getBalance()));

        budgetChartDetail.setMaxValue(budgetComplete.getMoney());
        budgetChartDetail.setMinValue(0f);

        budgetChartDetail.setValue(budgetComplete.getBalance());
    }

    @Override
    public void onClickLinkListener(int identifier) {

    }

    @Override
    public void actionClickListener(int identifier, int operation) {
        if(operation != 0){
            switch(operation){
                case 1:
                    try {
                        ScreenManager.screenChange(getActivity(),
                                R.id.mainActivityWrapper,
                                FragmentExpenseForm.class,
                                budgetComplete.getBudgetExpenses()[identifier],
                                Constants.VIEW_EXPENSE,
                                Constants.BIN_FALSE);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //ELIMINAR GASTO
                    break;
                default:
                    break;
            }
        }
    }
}
