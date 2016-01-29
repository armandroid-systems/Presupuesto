package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.BudgetForm;
import com.armandroid.presupuesto.interfaces.BudgetFormPresenter;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class BudgetFormPresenterImpl implements BudgetFormPresenter, BousinessCallback{
    private final static String TAG = BudgetFormPresenterImpl.class.getSimpleName();

    private BudgetForm budgetForm;
    private CurdBoussinesInteractorImpl mInteractor;

    public BudgetFormPresenterImpl(CurdBoussinesInteractorImpl interactor, BudgetForm form) {
        this.budgetForm = form;
        this.mInteractor = interactor;
    }

    @Override
    public void saveBudgetInformation(String name, Float money, Users user) {
        if(budgetForm.validateData()){
            mInteractor.insertConfigData(name,money,user,this);
        }else{
            budgetForm.showNotificationMessage(TAG);
        }
    }

    @Override
    public void onSucces(Object param) {
        budgetForm.goToMenu((long)param);
        budgetForm.showNotificationMessage(TAG);
    }

    @Override
    public void onSuccesInsert(long idInsert) {

    }

    @Override
    public void onSuccessUpdate(boolean updateState) {

    }

    @Override
    public void onError(Object param) {
        budgetForm.showNotificationMessage((String)param);
    }
}
