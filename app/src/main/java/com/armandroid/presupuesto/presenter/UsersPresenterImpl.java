package com.armandroid.presupuesto.presenter;

import android.content.Context;
import android.util.Log;

import com.armandroid.presupuesto.interactor.UserInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public class UsersPresenterImpl implements UsersPresenter, BousinessCallback{
    private final static String TAG = UsersPresenterImpl.class.getSimpleName();

    private UserInteractorImpl interactorUser;
    private ViewListener viewListener;

    public UsersPresenterImpl(Context ctx, ViewListener viewListener) {
        this.interactorUser = new UserInteractorImpl(ctx);
        this.viewListener = viewListener;
    }

    @Override
    public void checkUser(int id) {
        Log.d(TAG,"CHECKING USERS...");
        interactorUser.checkForUsers(id,this);
    }

    @Override
    public void insertUser(String desc, float userMoney, Users user) {
        Log.d(TAG, "INSERTING USERS...");
        if(!user.getName().isEmpty() && userMoney != 0){
            interactorUser.firstConfiguration(desc,userMoney, user, this);
        }else{
            viewListener.showMessage("ERROR");
        }
    }

    @Override
    public void checkUsersAndCatalogs(String[] elements) {
        interactorUser.checkUsersAndCatalogs(elements, this);
    }

    @Override
    public void onSucces(Object param) {
        Log.d(TAG,"ON SUCCESS...");
        viewListener.navigate(param);
    }

    @Override
    public void onError(Object param) {
        Log.d(TAG,"ON ERROR...");
        viewListener.showMessage((String)param);
    }
}
