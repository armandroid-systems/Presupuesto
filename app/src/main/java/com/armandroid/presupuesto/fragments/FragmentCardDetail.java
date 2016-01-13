package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandroid.presupuesto.R;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardDetail extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardDetail = inflater.inflate(R.layout.fragment_card_detail,container,false);
        return cardDetail;
    }
}
