package com.armandroid.presupuesto.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armando.dominguez on 15/12/2015.
 */
public class ScreenManager {

    public static void screenChange(FragmentActivity origin,int viewContainer, Class fragment, Object param, String id,
                                    int isMain) throws IllegalAccessException, InstantiationException {
        FragmentTransaction transaction = origin.getSupportFragmentManager().beginTransaction();
        Fragment mFragment = (Fragment) fragment.newInstance();
        if (param != null) {
            Bundle paramWrapper = new Bundle();
            if (param instanceof List<?>) {
                paramWrapper.putParcelableArrayList(Constants.KEY_PARAMS_FRAGMENT, (ArrayList<? extends Parcelable>) param);
            } else {
                paramWrapper.putParcelable(Constants.KEY_PARAMS_FRAGMENT, (Parcelable) param);
            }
            mFragment.setArguments(paramWrapper);
        }
        if (isMain == 0) {
            transaction.addToBackStack(id);
        }
        transaction.replace(viewContainer, mFragment);
        transaction.commit();
    }
}
