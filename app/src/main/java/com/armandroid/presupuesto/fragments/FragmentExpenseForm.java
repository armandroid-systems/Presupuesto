package com.armandroid.presupuesto.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.CurdPresenterImpl;

/**
 * Created by armando.dominguez on 30/12/2015.
 */
public class FragmentExpenseForm extends BaseFragment implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, ViewListener, AdapterView.OnItemSelectedListener {
    private final static String TAG = FragmentExpenseForm.class.getSimpleName();

    private EditText editDesc;
    private EditText editMounth;
    private Spinner  spinCategory;
    private Spinner  spinTdc;
    private Spinner  spinMonth;
    private CheckBox useCredit;
    private CheckBox monts;
    private Button   saveButton;
    private CatWrapper mData;
    private Expenses theExpense;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View expenseForm = inflater.inflate(R.layout.fragment_expense_form,container,false);

        mData = (CatWrapper)getActivity().getApplication();
        theExpense = new Expenses();

        editDesc        = (EditText) expenseForm.findViewById(R.id.editTextExpenseDesc);
        editMounth      = (EditText) expenseForm.findViewById(R.id.editTextExpenseMount);
        spinCategory    = (Spinner)  expenseForm.findViewById(R.id.spinnerCategory);
        spinTdc         = (Spinner)  expenseForm.findViewById(R.id.spinnerTdc);
        spinMonth       = (Spinner)  expenseForm.findViewById(R.id.spinnerMonts);
        useCredit       = (CheckBox) expenseForm.findViewById(R.id.checkCredit);
        monts           = (CheckBox) expenseForm.findViewById(R.id.checkMonts);
        saveButton      = (Button)   expenseForm.findViewById(R.id.buttonSaveExpense);

        spinCategory.setAdapter(new ArrayAdapter<Categories>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                mData.arrayCategories));
        spinTdc.setAdapter(new ArrayAdapter<Tdc>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                mData.arrayTdc));
        spinMonth.setAdapter(new ArrayAdapter<>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.months_array)));

        if(mData.arrayTdc.isEmpty()){
            useCredit.setVisibility(View.GONE);
        }

        if(mParam != null){
            theExpense = (Expenses)mParam;
            editDesc.setText(theExpense.getDescription());
            editMounth.setText(theExpense.getMount().toString());
        }

        saveButton.setOnClickListener(this);
        useCredit.setOnCheckedChangeListener(this);
        monts.setOnCheckedChangeListener(this);
        spinCategory.setOnItemSelectedListener(this);

        return expenseForm;
    }

    @Override
    public void onClick(View v) {
        cpiObject = new CurdPresenterImpl(getContext(),this);
        switch(v.getId()){
            case R.id.buttonSaveExpense:
                if(mParam != null){
                    theExpense.setMount(Float.parseFloat(editMounth.getText().toString()));
                    theExpense.setDescription(editDesc.getText().toString());
                    cpiObject.insertRecord(theExpense);
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.spinnerCategory:
                theExpense.setIdCategory(((Categories) (mData.arrayCategories.get(position))).getId().intValue());
                break;
            case R.id.spinnerTdc:
                theExpense.setIdTdc(((Categories) (mData.arrayTdc.get(position))).getId().intValue());
                break;
            case R.id.spinnerMonts:
                theExpense.setMonths(Integer.parseInt(getResources().getStringArray(R.array.months_array)[position]));
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()){
            case R.id.checkMonts:
                if(isChecked){
                    spinMonth.setVisibility(View.VISIBLE);
                }else{
                    spinMonth.setVisibility(View.GONE);
                }
                break;
            case R.id.checkCredit:
                if(isChecked ){
                    spinTdc.setVisibility(View.VISIBLE);
                }else{
                    spinTdc.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void showMessage(String error) {

    }

    @Override
    public void navigate(Object param) {
        if(param != 0){
            theExpense.setId((long)param+1);
        }
        editDesc.setText("");
        editMounth.setText("");
        useCredit.setChecked(false);
        monts.setChecked(false);
    }
}
