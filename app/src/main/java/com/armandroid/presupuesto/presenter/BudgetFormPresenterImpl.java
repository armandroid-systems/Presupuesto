package com.armandroid.presupuesto.presenter;

import android.app.Activity;
import android.content.Intent;

import com.armandroid.presupuesto.activities.MainActivity;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.BudgetForm;
import com.armandroid.presupuesto.interfaces.BudgetFormPresenter;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.utils.Constants;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class BudgetFormPresenterImpl implements BudgetFormPresenter, BousinessCallback{
    private final static String TAG = BudgetFormPresenterImpl.class.getSimpleName();

    private Activity mActivity;
    private BudgetForm budgetForm;
    private CurdBoussinesInteractorImpl mInteractor;

    public BudgetFormPresenterImpl(Activity mActivity, BudgetForm form) {
        this.mActivity = mActivity;
        this.budgetForm = form;
        this.mInteractor =  new CurdBoussinesInteractorImpl(mActivity);
    }

    @Override
    public void saveBudgetInformation(String name, Float money, Users user) {
        if(budgetForm.validateData()){
            mInteractor.insertConfigData(name,money,user,this);
        }else{
            budgetForm.showNotificationMessage();
        }
    }

    @Override
    public void onSucces(Object param) {
        mActivity.startActivity(new Intent(mActivity, MainActivity.class).putExtra(Constants.KEY_PARAMS_FRAGMENT,(long)param));
    }

    @Override
    public void onError(Object param) {
        budgetForm.showNotificationMessage();
    }
}
