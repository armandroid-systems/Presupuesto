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
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.ExpenseFormView;
import com.armandroid.presupuesto.model.Categories;
import com.armandroid.presupuesto.model.Expenses;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.presenter.ExpenseFormViewPresenterImpl;

import java.util.List;

/**
 * Created by armando.dominguez on 30/12/2015.
 */
public class FragmentExpenseForm extends BaseFragment implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, ExpenseFormView, AdapterView.OnItemSelectedListener {
    private final static String TAG = FragmentExpenseForm.class.getSimpleName();

    private EditText editDesc;
    private EditText editMounth;
    private Spinner  spinCategory;
    private Spinner  spinTdc;
    private Spinner  spinMonth;
    private CheckBox useCredit;
    private CheckBox monts;
    private Button   saveButton;
    private Expenses theExpense;

    private ExpenseFormViewPresenterImpl expensePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View expenseForm = inflater.inflate(R.layout.fragment_expense_form,container,false);

        expensePresenter = new ExpenseFormViewPresenterImpl(this,new CurdBoussinesInteractorImpl(getActivity()));
        theExpense = new Expenses();

        editDesc        = (EditText) expenseForm.findViewById(R.id.editTextExpenseDesc);
        editMounth      = (EditText) expenseForm.findViewById(R.id.editTextExpenseMount);
        spinCategory    = (Spinner)  expenseForm.findViewById(R.id.spinnerCategory);
        spinTdc         = (Spinner)  expenseForm.findViewById(R.id.spinnerTdc);
        spinMonth       = (Spinner)  expenseForm.findViewById(R.id.spinnerMonts);
        useCredit       = (CheckBox) expenseForm.findViewById(R.id.checkCredit);
        monts           = (CheckBox) expenseForm.findViewById(R.id.checkMonts);
        saveButton      = (Button)   expenseForm.findViewById(R.id.buttonSaveExpense);

        expensePresenter.getCatalogObject(0);

        if(mParam != null){
            theExpense = (Expenses)mParam;
            expensePresenter.putFormDataIfExists(theExpense);
            Log.d(TAG, "THIS IS THE FUCKING ID" + theExpense.getId());
        }

        saveButton.setOnClickListener(this);
        useCredit.setOnCheckedChangeListener(this);
        monts.setOnCheckedChangeListener(this);
        spinCategory.setOnItemSelectedListener(this);

        return expenseForm;
    }

    //SAVE BUTTON
    @Override
    public void onClick(View v) {
        expensePresenter.onSavePressed(v.getId(), theExpense);
    }

    //SPINNERS
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        expensePresenter.onSpinnerItemClicked(parent.getId(),theExpense, position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //CHECK
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        expensePresenter.onCheckedChange(buttonView.getId(),theExpense, isChecked);
    }

    @Override
    public void onClickPressed(int viewId, Expenses expense) {
        switch(viewId){
            case R.id.buttonSaveExpense:
                expense.setMount(Float.parseFloat(editMounth.getText().toString()));
                expense.setDescription(editDesc.getText().toString());
                expensePresenter.saveExpense(expense);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSpinnerItemSelected(int viewId, Expenses expense, int position) {
        switch(viewId){
            case R.id.spinnerCategory:
                expensePresenter.setCategorie(theExpense, position);
                break;
            case R.id.spinnerTdc:
                expensePresenter.setCard(theExpense,position);
                break;
            case R.id.spinnerMonts:
                expensePresenter.setMonths(theExpense,Integer.parseInt(getResources().getStringArray(R.array.months_array)[position]));
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedButton(int viewId, Expenses expense, boolean state) {

            switch(viewId){
                case R.id.checkMonts:
                    if(state){
                        showSpinnerMonths();
                    }else{
                        hideSpinnerMonths();
                        expense.setMonths(0);
                    }
                    break;
                case R.id.checkCredit:
                    if(state ){
                        showSpinnerCards();
                        showCheckMonths();
                    }else{
                        hideSpinnerCards();
                        hideCheckMonths();
                        expense.setIdTdc(0);
                    }
                    break;
                default:
                    break;
            }

    }

    @Override
    public void showMessageState(String message) {

    }

    @Override
    public void setDataForm(Expenses expenses) {
        editDesc.setText(expenses.getDescription());
        editMounth.setText(expenses.getMount().toString());
    }

    @Override
    public void cleanFields() {
        editDesc.setText("");
        editMounth.setText("");
        useCredit.setChecked(false);
        monts.setChecked(false);
    }

    @Override
    public void hideCheckMonths() {
        monts.setVisibility(View.GONE);
    }

    @Override
    public void showCheckMonths() {
        monts.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSpinnerCards() {
        spinTdc.setVisibility(View.GONE);
    }

    @Override
    public void showSpinnerCards() {
        spinTdc.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSpinnerMonths() {
        spinMonth.setVisibility(View.GONE);
    }

    @Override
    public void showSpinnerMonths() {
        spinMonth.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCheckCredit() {
        useCredit.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCheckCredit() {
        useCredit.setVisibility(View.GONE);
    }

    @Override
    public void setCardData(List cardData) {
        spinTdc.setAdapter(new ArrayAdapter<Tdc>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                cardData));
    }

    @Override
    public void setMonthsData() {
        spinMonth.setAdapter(new ArrayAdapter<>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.months_array)));
    }

    @Override
    public void setCategoriesData(List categories) {
        spinCategory.setAdapter(new ArrayAdapter<Categories>(getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                categories));
    }
}
