package com.armandroid.presupuesto.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Entity mapped to table "EXPENSES".
 */
public class Expenses implements Parcelable{

    private Long id;
    private Integer idBudget;
    private Integer idCategory;
    private Integer idTdc;
    private Float mount;
    private String description;
    private Integer months;
    private String categoryName;
    private String nameTDC;

    public Expenses() {
    }

    public Expenses(Parcel in) {
        this.id = in.readLong();
        this.idBudget = in.readInt();
        this.idCategory = in.readInt();
        this.idTdc = in.readInt();
        this.mount = in.readFloat();
        this.description = in.readString();
        this.months = in.readInt();
        this.categoryName = in.readString();
        this.nameTDC = in.readString();
    }

    public Expenses(Long id) {
        this.id = id;
    }

    public Expenses(Long id, Integer idBudget, Integer idCategory, Integer idTdc, Float mount, String description, Integer months) {
        this.id = id;
        this.idBudget = idBudget;
        this.idCategory = idCategory;
        this.idTdc = idTdc;
        this.mount = mount;
        this.description = description;
        this.months = months;
    }

    public Expenses(Long id, Integer idBudget, Integer idTdc, Float mount, String description, Integer months, String categoryName, String nameTDC) {
        this.id = id;
        this.idBudget = idBudget;
        this.idTdc = idTdc;
        this.mount = mount;
        this.description = description;
        this.months = months;
        this.categoryName = categoryName;
        this.nameTDC = nameTDC;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(Integer idBudget) {
        this.idBudget = idBudget;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdTdc() {
        return idTdc;
    }

    public void setIdTdc(Integer idTdc) {
        this.idTdc = idTdc;
    }

    public Float getMount() {
        return mount;
    }

    public void setMount(Float mount) {
        this.mount = mount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNameTDC() {
        return nameTDC;
    }

    public void setNameTDC(String nameTDC) {
        this.nameTDC = nameTDC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.idBudget);
        dest.writeInt(this.idCategory);
        dest.writeInt(this.idTdc);
        dest.writeFloat(this.mount);
        dest.writeInt(this.months);
        dest.writeString(this.description);
        dest.writeString(this.categoryName);
        dest.writeString(this.nameTDC);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Expenses createFromParcel(Parcel in) {
            return new Expenses(in);
        }

        public Expenses[] newArray(int size) {
            return new Expenses[size];
        }
    };
}
