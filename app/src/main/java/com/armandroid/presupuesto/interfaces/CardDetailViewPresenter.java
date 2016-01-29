package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Tdc;

/**
 * Created by armando.dominguez on 29/01/2016.
 */
public interface CardDetailViewPresenter {

    void saveElement(Tdc element);
    void getCheckedChangeState(int viewId, boolean state);
    void setDataFromObject(Tdc element);
}
