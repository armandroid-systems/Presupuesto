package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Tdc;

/**
 * Created by armando.dominguez on 29/01/2016.
 */
public interface CardDetailView {

    void setDataIfExists(Tdc element);
    void cleanFields();
    void showMessageState(String message);
    void changeLabelCheck();
    void dataToCalendar(boolean state);

}
