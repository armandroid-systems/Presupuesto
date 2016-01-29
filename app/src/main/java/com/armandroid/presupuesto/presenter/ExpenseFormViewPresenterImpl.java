package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.ExpenseFormView;
import com.armandroid.presupuesto.interfaces.ExpenseFormViewPresenter;
import com.armandroid.presupuesto.model.CatWrapper;
import com.armandroid.presupuesto.model.Categories;
import com.armandroid.presupuesto.model.Expenses;
import com.armandroid.presupuesto.model.Tdc;

/**
 * Created by armando.dominguez on 28/01/2016.
 */
public class ExpenseFormViewPresenterImpl implements ExpenseFormViewPresenter, BousinessCallback{
    private final static String TAG = ExpenseFormViewPresenterImpl.class.getSimpleName();

    private ExpenseFormView expenseView;
    private CurdBoussinesInteractorImpl interactor;
    private CatWrapper dataPack;

    public ExpenseFormViewPresenterImpl(ExpenseFormView expenseView, CurdBoussinesInteractorImpl interactor) {
        this.expenseView = expenseView;
        this.interactor = interactor;
    }

    @Override
    public void getCatalogObject(int idUser) {
        interactor.getConfigData(null,this);
    }

    @Override
    public void putFormDataIfExists(Expenses expense) {
        if(expense != null){
            expenseView.setDataForm(expense);
        }
    }

    @Override
    public void saveExpense(Expenses expense) {
        if(validateExpense(expense)){
            if(expense.getId() == 0l){
                expense.setId(null);
                interactor.insertRecord(expense,this);
                expense.setId(0l);
            }else{
                interactor.updateARecord(expense,this);
                expense.setId(0l);
            }
        }else{
            expenseView.showMessageState("WRONG");
        }
    }

    @Override
    public void onSucces(Object param) {
        dataPack = (CatWrapper)param;
        expenseView.setCategoriesData(dataPack.arrayCategories);
        expenseView.setMonthsData();
        expenseView.hideCheckMonths();
        if(!dataPack.arrayTdc.isEmpty()) {
            expenseView.setCardData(dataPack.arrayTdc);
            expenseView.showCheckCredit();
        }else{
            expenseView.hideCheckCredit();
        }

    }

    @Override
    public void onSuccesInsert(long param) {
        expenseView.cleanFields();
    }

    @Override
    public void onSuccessUpdate(boolean updateState) {
        if(updateState){
            expenseView.showMessageState("DONE");
            expenseView.cleanFields();
        }else{
            expenseView.showMessageState("FAIL");
        }
    }

    @Override
    public void onCheckedChange(int viewId, Expenses expense, boolean state) {
        expenseView.onCheckedButton(viewId, expense, state);
    }

    @Override
    public void onSpinnerItemClicked(int viewId, Expenses expense, int position) {
        expenseView.onSpinnerItemSelected(viewId, expense, position);
    }

    @Override
    public void onSavePressed(int viewId, Expenses expense) {
        expenseView.onClickPressed(viewId, expense);
    }

    @Override
    public void setCategorie(Expenses expense, int position) {
        expense.setIdCategory(((Categories) dataPack.arrayCategories.get(position)).getId().intValue());
    }

    @Override
    public void setCard(Expenses expense, int position) {
        expense.setIdCategory(((Tdc) dataPack.arrayTdc.get(position)).getId().intValue());
    }

    @Override
    public void setMonths(Expenses expense, int position) {
        expense.setMonths(position);
    }

    @Override
    public void onError(Object param) {
        expenseView.showMessageState("WRONG");
    }

    public boolean validateExpense(Expenses expense){
        boolean flag = false;
        if(expense.getMount() != 0){
            flag = true;
        }
        return flag;
    }

}
