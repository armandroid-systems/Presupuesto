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
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BudgetDetailView;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.interfaces.CurdBoussinesInteractor;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.Expenses;
import com.armandroid.presupuesto.presenter.BudgetDetailViewPresenterImpl;
import com.armandroid.presupuesto.presenter.BudgetHistoryViewPresenterImpl;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;
import com.armandroid.presupuesto.utils.UtilFunctions;
import com.txusballesteros.widgets.FitChart;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentBudgetDetail extends BaseFragment implements BudgetDetailView, View.OnClickListener{

    private FitChart budgetChartDetail;
    private RecyclerView recyclerExpenses;
    private FloatingActionButton expenseFab;
    private TextView detailTotal;
    private TextView detailExpense;
    private TextView detailBalance;
    private Budget budgetComplete;

    private BudgetDetailViewPresenterImpl budgetDetailPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View budgetDetail = inflater.inflate(R.layout.fragment_budget_detail, container, false);

        budgetDetailPresenter = new BudgetDetailViewPresenterImpl(new CurdBoussinesInteractorImpl(getActivity()), this);

        recyclerExpenses    = (RecyclerView) budgetDetail.findViewById(R.id.recyclerDetail);
        budgetChartDetail   = (FitChart) budgetDetail.findViewById(R.id.budgetChartDetail);
        expenseFab          = (FloatingActionButton) budgetDetail.findViewById(R.id.toExpense);
        detailTotal         = (TextView) budgetDetail.findViewById(R.id.textViewDetailTotal);
        detailExpense       = (TextView) budgetDetail.findViewById(R.id.textViewDetailExpense);
        detailBalance       = (TextView) budgetDetail.findViewById(R.id.textViewDetailBalance);



        if(mParam != null){
            budgetDetailPresenter.getBudgetDetail((int)mParam);
        }

        expenseFab.setOnClickListener(this);



        return budgetDetail;
    }

    @Override
    public void onClick(View v) {
        budgetDetailPresenter.onClickResponse(v.getId());
    }

    @Override
    public void goToAddExpense() {
        Bundle transport = new Bundle();
        transport.putParcelable(Constants.KEY_PARAMS_FRAGMENT,new Expenses(null,(int)mParam,0,0,0f,"",0 ));
        try {
            ScreenManager.screenChange(getActivity(),
                    R.id.mainActivityWrapper,
                    FragmentExpenseForm.class,
                    transport,
                    Constants.VIEW_EXPENSE,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToExpense(Expenses expense) {
        Bundle transport = new Bundle();
        transport.putParcelable(Constants.KEY_PARAMS_FRAGMENT,expense);
        try {
            ScreenManager.screenChange(getActivity(),
                    R.id.mainActivityWrapper,
                    FragmentExpenseForm.class,
                    transport,
                    Constants.VIEW_EXPENSE,
                    Constants.BIN_FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showMessageState(String message) {

    }

    @Override
    public void createRecyclerExpenses(ExpenseRecyclerAdapter expenseAdapter) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        recyclerExpenses.setHasFixedSize(true);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerExpenses.setLayoutManager(llm);
        recyclerExpenses.setAdapter(expenseAdapter);
    }

    @Override
    public ExpenseRecyclerAdapter getExpenseAdapter(Expenses[] data, ClickListener listener) {
        return new ExpenseRecyclerAdapter(data, listener);
    }

    @Override
    public void setGraphData(Budget param) {

        detailTotal.setText(UtilFunctions.formatTwoDecimals(param.getMoney()));
        detailExpense.setText(UtilFunctions.formatTwoDecimals(param.getBalance()));
        detailBalance.setText(UtilFunctions.formatTwoDecimals(param.getMoney() - param.getBalance()));

        budgetChartDetail.setMaxValue(param.getMoney());
        budgetChartDetail.setMinValue(0f);

        budgetChartDetail.setValue(param.getBalance());
    }
}

