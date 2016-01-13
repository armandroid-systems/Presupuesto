package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ModelGenerator {

    public static void main(String args[]) throws Exception{
        Schema schema = new Schema(1, "com.armandroid.presupuesto.model");

        Entity users = schema.addEntity("Users");

        users.addIdProperty().columnName("idUser");
        users.addStringProperty("name");
        users.addStringProperty("email");

        Entity categories = schema.addEntity("Categories");

        categories.addIdProperty().columnName("idCategory");
        categories.addIntProperty("idFatherCategory");
        categories.addStringProperty("nameCategory");

        Entity catTdc = schema.addEntity("Tdc");

        catTdc.addIdProperty().columnName("idTdc");
        catTdc.addStringProperty("cardName");
        catTdc.addFloatProperty("credit");
        catTdc.addFloatProperty("expended");

        Entity budget = schema.addEntity("Budget");

        budget.addIdProperty().columnName("idBudget");
        budget.addIntProperty("idUser");
        budget.addStringProperty("description");
        budget.addStringProperty("date");

        Entity moneyEntry = schema.addEntity("MoneyEntry");

        moneyEntry.addIdProperty().columnName("idMoneyEntry");
        moneyEntry.addIntProperty("idBudget");
        moneyEntry.addFloatProperty("mount");
        moneyEntry.addStringProperty("date");

        Entity expenses = schema.addEntity("Expenses");

        expenses.addIdProperty().columnName("idExpense");
        expenses.addIntProperty("idBudget");
        expenses.addIntProperty("idCategory");
        expenses.addIntProperty("idTdc");
        expenses.addFloatProperty("mount");
        expenses.addStringProperty("description");
        expenses.addIntProperty("months");

        new DaoGenerator().generateAll(schema,"../app/src/main/java");
    }
}
