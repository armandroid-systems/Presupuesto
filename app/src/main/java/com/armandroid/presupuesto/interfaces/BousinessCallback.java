package com.armandroid.presupuesto.interfaces;

import java.util.List;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public interface BousinessCallback {

    void onSucces(Object param);
    void onSuccesInsert(long idInsert);
    void onSuccessUpdate(boolean updateState);
    void onError(Object param);
}
