package com.armandroid.presupuesto.interfaces;

/**
 * Created by armando.dominguez on 26/01/2016.
 */
public interface SplashView {
    void showProgress();
    void hideProgress();
    void showNotificationMessage(String message);
    void goIntro();
    void goMain(long idUser);
}
