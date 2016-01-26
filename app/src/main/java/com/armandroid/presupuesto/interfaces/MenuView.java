package com.armandroid.presupuesto.interfaces;

import com.armandroid.presupuesto.model.Budget;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface MenuView {
    void setDataInGraph(Budget param);
    void showGraph();
    void hideGraph();
    void showMessage();
}
