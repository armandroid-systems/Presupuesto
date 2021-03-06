package com.armandroid.presupuesto.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.armandroid.presupuesto.model.Users;
import com.armandroid.presupuesto.model.Categories;
import com.armandroid.presupuesto.model.Tdc;
import com.armandroid.presupuesto.model.Budget;
import com.armandroid.presupuesto.model.MoneyEntry;
import com.armandroid.presupuesto.model.Expenses;

import com.armandroid.presupuesto.model.UsersDao;
import com.armandroid.presupuesto.model.CategoriesDao;
import com.armandroid.presupuesto.model.TdcDao;
import com.armandroid.presupuesto.model.BudgetDao;
import com.armandroid.presupuesto.model.MoneyEntryDao;
import com.armandroid.presupuesto.model.ExpensesDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig usersDaoConfig;
    private final DaoConfig categoriesDaoConfig;
    private final DaoConfig tdcDaoConfig;
    private final DaoConfig budgetDaoConfig;
    private final DaoConfig moneyEntryDaoConfig;
    private final DaoConfig expensesDaoConfig;

    private final UsersDao usersDao;
    private final CategoriesDao categoriesDao;
    private final TdcDao tdcDao;
    private final BudgetDao budgetDao;
    private final MoneyEntryDao moneyEntryDao;
    private final ExpensesDao expensesDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        usersDaoConfig = daoConfigMap.get(UsersDao.class).clone();
        usersDaoConfig.initIdentityScope(type);

        categoriesDaoConfig = daoConfigMap.get(CategoriesDao.class).clone();
        categoriesDaoConfig.initIdentityScope(type);

        tdcDaoConfig = daoConfigMap.get(TdcDao.class).clone();
        tdcDaoConfig.initIdentityScope(type);

        budgetDaoConfig = daoConfigMap.get(BudgetDao.class).clone();
        budgetDaoConfig.initIdentityScope(type);

        moneyEntryDaoConfig = daoConfigMap.get(MoneyEntryDao.class).clone();
        moneyEntryDaoConfig.initIdentityScope(type);

        expensesDaoConfig = daoConfigMap.get(ExpensesDao.class).clone();
        expensesDaoConfig.initIdentityScope(type);

        usersDao = new UsersDao(usersDaoConfig, this);
        categoriesDao = new CategoriesDao(categoriesDaoConfig, this);
        tdcDao = new TdcDao(tdcDaoConfig, this);
        budgetDao = new BudgetDao(budgetDaoConfig, this);
        moneyEntryDao = new MoneyEntryDao(moneyEntryDaoConfig, this);
        expensesDao = new ExpensesDao(expensesDaoConfig, this);

        registerDao(Users.class, usersDao);
        registerDao(Categories.class, categoriesDao);
        registerDao(Tdc.class, tdcDao);
        registerDao(Budget.class, budgetDao);
        registerDao(MoneyEntry.class, moneyEntryDao);
        registerDao(Expenses.class, expensesDao);
    }



    public void clear() {
        usersDaoConfig.getIdentityScope().clear();
        categoriesDaoConfig.getIdentityScope().clear();
        tdcDaoConfig.getIdentityScope().clear();
        budgetDaoConfig.getIdentityScope().clear();
        moneyEntryDaoConfig.getIdentityScope().clear();
        expensesDaoConfig.getIdentityScope().clear();
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public CategoriesDao getCategoriesDao() {
        return categoriesDao;
    }

    public TdcDao getTdcDao() {
        return tdcDao;
    }

    public BudgetDao getBudgetDao() {
        return budgetDao;
    }

    public MoneyEntryDao getMoneyEntryDao() {
        return moneyEntryDao;
    }

    public ExpensesDao getExpensesDao() {
        return expensesDao;
    }

}
