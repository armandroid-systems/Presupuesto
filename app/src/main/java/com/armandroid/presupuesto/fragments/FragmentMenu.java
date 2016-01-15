package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.adapters.GridViewAdapter;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.MenuItem;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.presenter.BudgetPresenter;
import com.armandroid.presupuesto.presenter.BudgetPresenterImpl;
import com.armandroid.presupuesto.presenter.UsersPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;
import com.armandroid.presupuesto.utils.UtilFunctions;
import com.txusballesteros.widgets.FitChart;

import java.util.List;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentMenu extends BaseFragment implements AdapterView.OnItemClickListener, ViewListener{
    private final static String TAG = FragmentMenu.class.getSimpleName();

    private GridView mGrid;
    private FitChart budgetChartMain;
    private BudgetPresenterImpl mPresenterImpl;
    private TextView textTotal;
    private TextView textExpenses;
    private TextView textBalance;
    private TextView title;
    private MenuItem[] mArray = {
            new MenuItem("BUDGETS",R.mipmap.ic_launcher),
            new MenuItem("CARDS",R.mipmap.ic_launcher),
            new MenuItem("MY CREDITS",R.mipmap.ic_launcher),
            new MenuItem("CALCULATOR",R.mipmap.ic_launcher),
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View menuView = inflater.inflate(R.layout.fragment_menu,container,false);

        mPresenterImpl = new BudgetPresenterImpl(getContext(),this);

        title           = (TextView) menuView.findViewById(R.id.textViewBudgetTitle);
        textTotal       = (TextView) menuView.findViewById(R.id.textViewTotal);
        textExpenses    = (TextView) menuView.findViewById(R.id.textViewExpenses);
        textBalance     = (TextView) menuView.findViewById(R.id.textViewBalance);
        mGrid           = (GridView) menuView.findViewById(R.id.gridView);
        budgetChartMain = (FitChart) menuView.findViewById(R.id.budgetChart);

        if (mParam != null){
            mPresenterImpl.getBudget(((Users) mParam).getId().intValue());
        }


        mGrid.setAdapter(new GridViewAdapter(getContext(),mArray));

        mGrid.setOnItemClickListener(this);


        return menuView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
        switch(position+1){

            case Constants.OPTION_BUDGET:
                ScreenManager.screenChange(getActivity(),
                        R.id.mainActivityWrapper,
                        FragmentBudgetHistory.class,
                        mParam,
                        Constants.VIEW_BUDGET,
                        Constants.BIN_FALSE);
                break;
            case Constants.OPTION_CARD:
                ScreenManager.screenChange(getActivity(),
                        R.id.mainActivityWrapper,
                        FragmentCardList.class,
                        mParam,
                        Constants.VIEW_CARD,
                        Constants.BIN_FALSE);
                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;

        }
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (java.lang.InstantiationException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        List<Budget> results = (List<Budget>)param;
        if(!results.isEmpty()){
            float mBalance = results.get(0).getMoney()-results.get(0).getBalance();
            title.setText(getString(R.string.budget_title)+results.get(0).getDescription()+" "+results.get(0).getDate());
            textTotal.setText(getActivity().getString(R.string.budget_total)+ UtilFunctions.formatTwoDecimals(results.get(0).getMoney()));
            textExpenses.setText(getActivity().getString(R.string.budget_balance)+UtilFunctions.formatTwoDecimals(results.get(0).getBalance()));
            textBalance.setText(getActivity().getString(R.string.budget_expense) + UtilFunctions.formatTwoDecimals(mBalance));

            budgetChartMain.setMaxValue(results.get(0).getMoney());
            budgetChartMain.setMinValue(0f);
            budgetChartMain.setValue(results.get(0).getBalance());
        }

    }
}
