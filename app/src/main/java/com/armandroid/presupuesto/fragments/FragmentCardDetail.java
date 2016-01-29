package com.armandroid.presupuesto.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.CardDetailView;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.CardDetailViewPresenterImpl;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;
import com.armandroid.presupuesto.utils.UtilFunctions;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentCardDetail extends BaseFragment implements View.OnClickListener, CardDetailView, CompoundButton.OnCheckedChangeListener{
    private final static String TAG = FragmentCardDetail.class.getSimpleName();

    private EditText editCardName;
    private EditText editCardMount;
    private CheckBox toCalendar;
    private Button   saveData;
    private Tdc      dataToSave;

    private CardDetailViewPresenterImpl detailPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cardDetail = inflater.inflate(R.layout.fragment_card_detail,container,false);

        detailPresenter = new CardDetailViewPresenterImpl(new CurdBoussinesInteractorImpl(getActivity()),this);

        editCardName    = (EditText) cardDetail.findViewById(R.id.editTextTdcDesc);
        editCardMount   = (EditText) cardDetail.findViewById(R.id.editTextTdcMount);
        toCalendar      = (CheckBox) cardDetail.findViewById(R.id.checkAddToCalendar);
        saveData        = (Button)   cardDetail.findViewById(R.id.buttonSaveTdc);

        if(mParam != null){
            dataToSave = (Tdc)mParam;
            detailPresenter.setDataFromObject(dataToSave);
        }

        saveData.setOnClickListener(this);
        toCalendar.setOnCheckedChangeListener(this);

        return cardDetail;
    }

    @Override
    public void onClick(View v) {
        dataToSave.setCardName(editCardName.getText().toString());
        dataToSave.setCredit(Float.parseFloat(editCardMount.getText().toString()));
       detailPresenter.saveElement(dataToSave);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        detailPresenter.getCheckedChangeState(buttonView.getId(),isChecked);
    }

    @Override
    public void setDataIfExists(Tdc element) {
        Log.d(TAG,"SETTING DATA...");
        editCardName.setText(element.getCardName());
        editCardMount.setText(""+element.getCredit());
    }

    @Override
    public void cleanFields() {
        editCardName.setText("");
        editCardMount.setText("");
        toCalendar.setChecked(false);
    }

    @Override
    public void showMessageState(String message) {
        Log.d(TAG,message);
    }

    @Override
    public void changeLabelCheck() {
        toCalendar.setText("");
    }

    @Override
    public void dataToCalendar(boolean state) {
        String op;
        if(state){
            op = Intent.ACTION_INSERT;
        }else{
            op = Intent.ACTION_EDIT;
        }
        Intent intent = new Intent(op)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, getActivity().getString(R.string.app_name))
                .putExtra(CalendarContract.Events.DESCRIPTION, editCardName.getText().toString())
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
        startActivity(intent);
    }
}
