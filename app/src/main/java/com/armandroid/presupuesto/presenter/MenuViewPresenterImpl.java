package com.armandroid.presupuesto.presenter;

import android.app.Activity;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.MenuView;
import com.armandroid.presupuesto.interfaces.MenuViewPresenter;
import com.armandroid.presupuesto.model.Budget;

import java.util.List;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public class MenuViewPresenterImpl implements MenuViewPresenter, BousinessCallback{

    private Activity mActivity;
    private MenuView mv;
    private CurdBoussinesInteractorImpl interactor;

    public MenuViewPresenterImpl(Activity mActivity, MenuView mv) {
        this.mActivity = mActivity;
        this.mv = mv;
        this.interactor = new CurdBoussinesInteractorImpl(this.mActivity);
    }

    @Override
    public void getMostRecentBudget(int idUser) {
        interactor.getBudget(idUser,this);
    }

    @Override
    public void onSucces(Object param) {
        List<Budget> results = (List<Budget>)param;
        if(!results.isEmpty()){
            mv.setDataInGraph(results.get(0));
        }
    }

    @Override
    public void onSuccesInsert(Object param) {

    }

    @Override
    public void onError(Object param) {
        mv.showMessage();
    }
}
