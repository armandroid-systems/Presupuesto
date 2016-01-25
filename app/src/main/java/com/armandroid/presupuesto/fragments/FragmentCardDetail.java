package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardDetail extends BaseFragment implements View.OnClickListener, ViewListener{
    private final static String TAG = FragmentCardDetail.class.getSimpleName();

    private EditText editCardName;
    private EditText editCardMount;
    private CheckBox toCalendar;
    private Button   saveData;
    private Tdc      dataToSave;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardDetail = inflater.inflate(R.layout.fragment_card_detail,container,false);

        editCardName    = (EditText) cardDetail.findViewById(R.id.editTextTdcDesc);
        editCardMount   = (EditText) cardDetail.findViewById(R.id.editTextTdcMount);
        toCalendar      = (CheckBox) cardDetail.findViewById(R.id.checkAddToCalendar);
        saveData        = (Button)   cardDetail.findViewById(R.id.buttonSaveTdc);

        if(mParam != null){
            dataToSave = (Tdc)mParam;
            editCardName.setText(dataToSave.getCardName());
            editCardMount.setText(""+dataToSave.getCredit());
        }

        saveData.setOnClickListener(this);

        return cardDetail;
    }

    @Override
    public void onClick(View v) {
        cpiObject = new CurdPresenterImpl(getContext(),this);
        dataToSave.setCardName(editCardName.getText().toString());
        dataToSave.setCredit(Float.parseFloat(editCardMount.getText().toString()));
        cpiObject.insertRecord(dataToSave);
    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        editCardName.setText("");
        editCardMount.setText("");
        toCalendar.setChecked(false);
    }
}
