package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.armandroid.presupuesto.utils.Constants;


/**
 * Created by armando.dominguez on 15/12/2015.
 */
public class BaseFragment extends Fragment {

    protected Object mParam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if(getArguments() != null){
            mParam = getArguments().get(Constants.KEY_PARAMS_FRAGMENT);
        }
        super.onCreate(savedInstanceState);
    }
}
