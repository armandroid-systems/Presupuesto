package com.armandroid.presupuesto.interactor;

import android.content.Context;

import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.model.AppDaoClass;
import com.armandroid.presupuesto.model.Users;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public class UserInteractorImpl implements UserInteractor {
    private final static String TAG = UserInteractorImpl.class.getSimpleName();

    private AppDaoClass mDaoClass;

    public UserInteractorImpl(Context ctx) {
        this.mDaoClass = new AppDaoClass(ctx);
    }

    @Override
    public void checkForUsers(int id, BousinessCallback callback) {
        callback.onSucces(mDaoClass.getGeneric(Users.class,id));
    }

    @Override
    public void updateUser(Users user, BousinessCallback callback) {
        callback.onSucces(mDaoClass.updateGeneric(user));
    }

    @Override
    public void firstConfiguration(String desc, float moneyEntry, Users user, BousinessCallback callback) {
        try{
            callback.onSucces(mDaoClass.insertBundle(desc, moneyEntry,user));
        }catch(Exception e){
            callback.onError(e.getMessage());
        }
    }

    @Override
    public void checkUsersAndCatalogs(String[] params, BousinessCallback callback) {
        callback.onSucces(mDaoClass.checkUserAndCatalogs(params));
    }
}
