package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interfaces.ViewListener;
import com.armandroid.presupuesto.model.CatWrapper;
import com.armandroid.presupuesto.model.Categories;
import com.armandroid.presupuesto.model.Expenses;
import com.armandroid.presupuesto.presenter.ExpensePresenterImpl;

/**
 * Created by armando.dominguez on 30/12/2015.
 */
public class FragmentExpenseForm extends BaseFragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener, ViewListener {
    private final static String TAG = FragmentExpenseForm.class.getSimpleName();

    private EditText editDesc;
    private EditText editMounth;
    private Spinner  spinCategory;
    private Spinner  spinTdc;
    private Spinner  spinMonth;
    private CheckBox useCredit;
    private CheckBox monts;
    private Button   saveButton;
    private ExpensePresenterImpl presenterExpense;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View expenseForm = inflater.inflate(R.layout.fragment_expense_form,container,false);

        presenterExpense = new ExpensePresenterImpl(getContext(),this);

        editDesc        = (EditText) expenseForm.findViewById(R.id.editTextExpenseDesc);
        editMounth      = (EditText) expenseForm.findViewById(R.id.editTextExpenseMount);
        spinCategory    = (Spinner)  expenseForm.findViewById(R.id.spinnerCategory);
        spinTdc         = (Spinner)  expenseForm.findViewById(R.id.spinnerTdc);
        spinMonth       = (Spinner)  expenseForm.findViewById(R.id.spinnerMonts);
        useCredit       = (CheckBox) expenseForm.findViewById(R.id.checkCredit);
        monts           = (CheckBox) expenseForm.findViewById(R.id.checkMonts);
        saveButton      = (Button)   expenseForm.findViewById(R.id.buttonSaveExpense);

        presenterExpense.getCatalogs(0);


        return expenseForm;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonSaveExpense:
                //presenterExpense.insertExpense(new Expenses(null,()mParam));
                break;
            default:
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        try{



            editDesc.setText("");
            editMounth.setText("");
            useCredit.setChecked(false);
            monts.setChecked(false);
        }catch(ClassCastException e){


        }
    }
}
