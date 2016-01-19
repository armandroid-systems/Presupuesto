package com.armandroid.presupuesto.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.activities.MainActivity;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;
import com.armandroid.presupuesto.utils.Constants;

/**
 * Created by armando.dominguez on 29/12/2015.
 */
public class FragmentConfiguration extends BaseFragment implements View.OnClickListener, ViewListener {
    private final static String TAG = FragmentConfiguration.class.getSimpleName();

    private Button buttonSave;
    private EditText editName;
    private EditText editMail;
    private EditText editAmmount;
    private EditText editBudgetDesc;

    private Users object;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View configurationVew = inflater.inflate(R.layout.fragment_conf,container,false);

        buttonSave      = (Button) configurationVew.findViewById(R.id.buttonSaveConf);
        editName        = (EditText) configurationVew.findViewById(R.id.editUserName);
        editMail        = (EditText) configurationVew.findViewById(R.id.editUserMail);
        editAmmount     = (EditText) configurationVew.findViewById(R.id.editUserMount);
        editBudgetDesc  = (EditText) configurationVew.findViewById(R.id.editBudgetDesc);

        buttonSave.setOnClickListener(this);

        return configurationVew;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"CLICK RECEIVED...");
        cpiObject = new CurdPresenterImpl(getContext(),this);
        switch(v.getId()){
            case R.id.buttonSaveConf:
                object = new Users(null,
                                editName.getText().toString(),
                                editMail.getText().toString());
                cpiObject.insertConfigData(editBudgetDesc.getText().toString(),
                        Float.parseFloat(editAmmount.getText().toString()),
                        object);

                break;
            default:
                break;
        }
    }

    @Override
    public void showMessage(String error) {
        Log.e(TAG, "INPUT ERROR...");
    }

    @Override
    public void navigate(Object param) {
        Log.d(TAG, "INSERTION 0k ID[" + param + "]");
        object.setId((long)param);
        startActivity(new Intent(getActivity(), MainActivity.class).putExtra(Constants.KEY_ACTIVITY_PARAM,object));
        getActivity().finish();
    }
}
