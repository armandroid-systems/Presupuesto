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
import com.armandroid.presupuesto.adapters.BudgetRecyclerAdapter;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BudgetHistoryView;
import com.armandroid.presupuesto.interfaces.ClickListener;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.presenter.BudgetHistoryViewPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;
import com.armandroid.presupuesto.utils.ScreenManager;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentBudgetHistory extends BaseFragment implements BudgetHistoryView, View.OnClickListener {
    private final static String TAG = FragmentBudgetHistory.class.getSimpleName();

    private RecyclerView mRecycler;
    private FloatingActionButton budgetFab;
    private BudgetHistoryViewPresenterImpl budgetPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View budgetHistory = inflater.inflate(R.layout.fragment_budget, container, false);

        budgetPresenter = new BudgetHistoryViewPresenterImpl(new CurdBoussinesInteractorImpl(getActivity()),this);

        mRecycler = (RecyclerView) budgetHistory.findViewById(R.id.recyclerBudget);
        budgetFab = (FloatingActionButton) budgetHistory.findViewById(R.id.toBudget);

        budgetFab.setOnClickListener(this);

        if(mParam != null){
            budgetPresenter.getBudgets(((Long)mParam).intValue());
        }

        return budgetHistory;
    }


    @Override
    public void onClick(View v) {
        budgetPresenter.onElementClicked(v.getId());
    }

    @Override
    public void createRecyclerView(BudgetRecyclerAdapter adapter) {
        Log.d(TAG,"Reach the create method...");
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(llm);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public BudgetRecyclerAdapter getBudgetAdapter(Budget[] elements, ClickListener listener) {
        Log.d(TAG,"SIZE ELEMENTS"+elements.length);
        return new BudgetRecyclerAdapter(elements,listener);
    }

    @Override
    public void goToBudgetForm() {

    }

    @Override
    public void goToDetail(int id) {
        Bundle mBundle = new Bundle();
        mBundle.putInt(Constants.KEY_PARAMS_FRAGMENT,id);
        try {
            ScreenManager.screenChange(getActivity(),
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
}
