package com.armandroid.presupuesto.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "CATEGORIES".
 */
public class Categories {

    private Long id;
    private Integer idFatherCategory;
    private String nameCategory;

    public Categories() {
    }

    public Categories(Long id) {
        this.id = id;
    }

    public Categories(Long id, Integer idFatherCategory, String nameCategory) {
        this.id = id;
        this.idFatherCategory = idFatherCategory;
        this.nameCategory = nameCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdFatherCategory() {
        return idFatherCategory;
    }

    public void setIdFatherCategory(Integer idFatherCategory) {
        this.idFatherCategory = idFatherCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return nameCategory;

    }
}
