package com.armandroid.presupuesto.presenter;

import com.armandroid.presupuesto.R;
import com.armandroid.presupuesto.interactor.CurdBoussinesInteractorImpl;
import com.armandroid.presupuesto.interfaces.BousinessCallback;
import com.armandroid.presupuesto.interfaces.CardDetailView;
import com.armandroid.presupuesto.interfaces.CardDetailViewPresenter;
import com.armandroid.presupuesto.model.Tdc;

/**
 * Created by armando.dominguez on 29/01/2016.
 */
public class CardDetailViewPresenterImpl implements CardDetailViewPresenter, BousinessCallback{

    private CurdBoussinesInteractorImpl mInteractor;
    private CardDetailView detailView;

    public CardDetailViewPresenterImpl(CurdBoussinesInteractorImpl mInteractor, CardDetailView detailView) {
        this.mInteractor = mInteractor;
        this.detailView = detailView;
    }

    @Override
    public void setDataFromObject(Tdc element) {
        if(element != null){
            detailView.setDataIfExists(element);
            detailView.changeLabelCheck();
        }else{
            detailView.changeLabelCheck();
        }
    }

    @Override
    public void saveElement(Tdc element) {
        if(validateExpense(element)){
            if(element.getId() == 0){
                element.setId(null);
                mInteractor.insertRecord(element, this);
                element.setId(0l);
            }else{
                mInteractor.updateARecord(element,this);
                element.setId(0l);
            }
        }else{
            detailView.showMessageState("NO VALID");
        }

    }


    @Override
    public void onSucces(Object param) {

    }

    @Override
    public void onSuccesInsert(long idInsert) {
        detailView.cleanFields();
    }

    @Override
    public void onSuccessUpdate(boolean updateState) {
        detailView.cleanFields();
    }

    @Override
    public void onError(Object param) {
        detailView.showMessageState((String)param);
    }

    @Override
    public void getCheckedChangeState(int viewId, boolean state) {
        switch(viewId){
            case R.id.checkAddToCalendar:
                if(state){
                    detailView.changeLabelCheck();
                    detailView.dataToCalendar(state);
                }else{
                    detailView.changeLabelCheck();
                    detailView.dataToCalendar(state);
                }
                break;
            default:
                break;
        }
    }

    public boolean validateExpense(Tdc card){
        boolean flag = false;
        if(card.getCredit() != 0){
            flag = true;
        }
        return flag;
    }

}
