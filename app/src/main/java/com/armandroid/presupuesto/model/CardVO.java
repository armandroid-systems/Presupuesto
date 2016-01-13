package com.armandroid.presupuesto.model;

/**
 * Created by armando.dominguez on 05/01/2016.
 */
public class CardVO {
    public int idCard;
    public String name;
    public String comment;
    public float  creditMount;

    public CardVO(int idCard, String name, String comment, float creditMount) {
        this.idCard = idCard;
        this.name = name;
        this.comment = comment;
        this.creditMount = creditMount;
    }
}
