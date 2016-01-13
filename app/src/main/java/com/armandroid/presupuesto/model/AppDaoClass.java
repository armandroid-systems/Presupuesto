package com.armandroid.presupuesto.model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.armandroid.presupuesto.utils.UtilFunctions;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by armando.dominguez on 08/01/2016.
 */
public class AppDaoClass<T> extends ConnectionFactory{

    private final static String TAG = AppDaoClass.class.getSimpleName();
    private DaoSession mDaoSession;

    public AppDaoClass(Context context) {
        super(context);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        this.mDaoSession = daoMaster.newSession();
    }

    ///////GENERIC METHODS////////
    public Long genericInsert(Object param){
        Long responseId = 0L;
        try{
            responseId = mDaoSession.insertOrReplace(param);
        }catch(Exception e){
            Log.e(TAG,"ERROR INSERT GENERIC "+e);
        }
        return responseId;
    }

    public boolean updateGeneric(Object param){
        try{
            mDaoSession.update(param);
            return true;
        }catch(Exception e){
            Log.e(TAG,"Exception on update method ["+param+"]");
            return false;
        }
    }

    public List<Object> getGeneric(Class entity, int key){
        List<Object> mResult = new ArrayList<>();
        if(key != 0){
            mResult.add(mDaoSession.load(entity,(long)key));
        }else{
            mResult = mDaoSession.loadAll(entity);
        }

        return mResult;
    }

    //////CURD USER AND CONF/////

    public boolean insertCategories(String[] elements){
        boolean flag = false;
        if(getGeneric(Categories.class,0).isEmpty()){
            try{
                if(elements.length != 0){
                    for(int i = 0; i < elements.length; i++){
                        genericInsert(new Categories(null,null,elements[i]));
                    }
                    flag = true;
                }
            }catch(Exception e){
                Log.e(TAG,"ERROR INSERTING CATEGORIES ["+e+"]");

            }
        }
        return flag;
    }

    public List<Object> checkUserAndCatalogs(String[] elements){
        insertCategories(elements);
        return getGeneric(Users.class,0);

    }


    public long insertBundle(String desc,float money, Object user) throws Exception{
        return genericInsert(new MoneyEntry(
                null, genericInsert(new Budget(
                null, genericInsert(user).intValue(),
                UtilFunctions.getCurrentDate(),
                desc)).intValue(),
                money, UtilFunctions.getCurrentDate()));
    }

    ////////////////////////BUDGET METHODS////////////////////////////////////
    public List<Budget> getBudget(Class entity, int key){
        String query = "SELECT T0.idBudget, T0.id_User, T0.description, T0.date, T2.mount, SUM(T1.mount) FROM Budget AS T0 " +
                "LEFT JOIN Expenses AS T1 ON T1.id_Budget = T0.idBudget " +
                "JOIN Money_Entry AS T2 ON T2.id_Budget = T0.idBudget " +
                "WHERE T0.id_User = "+key+" GROUP BY T0.idBudget ORDER BY T0.date DESC";
        List<Budget> result = new ArrayList<>();
        try{
            Log.d(TAG, "EXECUTE QUERY FOR CURRENT BUDGET...");
            Cursor c = mDaoSession.getDatabase().rawQuery(query,null);
            if (c.moveToFirst()) {
                do {
                    result.add(new Budget(c.getLong(0),c.getInt(1),c.getString(2),c.getString(3),c.getFloat(5),c.getFloat(4)));
                } while (c.moveToNext());
            }
            c.close();
        }catch(Exception e){
            Log.e(TAG,"QUERY RAW ERROR ["+e+"]");
        }

        return result;
    }

    public List<Expenses> getExpensesByBudgetId (int key){
        String Q0 ="SELECT T0.idexpense,T0.id_budget, T0.id_tdc, T1.name_category, T0.description, T0.mount, T0.months, T2.card_name FROM Expenses AS T0 " +
                "JOIN categories AS T1 ON T1.idcategory = T0.id_category " +
                "JOIN Tdc AS T2 ON T2.idTdc = T0.id_Tdc " +
                "WHERE T0.id_budget = "+key;
        List<Expenses> expenses = new ArrayList<>();
        try{
            Log.d(TAG, "EXECUTE QUERY FOR EXPENSES...");
            Cursor c = mDaoSession.getDatabase().rawQuery(Q0,null);
            if(c.moveToFirst()){
                do{
                    expenses.add(new Expenses(c.getLong(0),c.getInt(1),c.getInt(2),c.getFloat(5), c.getString(4), c.getInt(6), c.getString(3),c.getString(7)));
                }while(c.moveToNext());
            }
            c.close();
        }catch(Exception e){
            Log.e(TAG,"QUERY ERROR ["+e+"]");
        }
        return expenses;
    }

    public Budget getAllAboutBudget(int key){
        Budget result = null;
        List<Expenses> comodin;

        try{
            Log.d(TAG,"GETTING COMPLETE BUDGET INFORMATION...");
            result = getBudget(null,key).get(0);
            if(result != null){
                comodin = getExpensesByBudgetId(key);
                Expenses[] array = new Expenses [comodin.size()];
                comodin.toArray(array);
                result.setBudgetExpenses(array);
            }
        }catch(Exception e){
            Log.e(TAG,"ERROR FILLING DATA ["+e+"]");
        }

        return result;
    }

    //////////////GET CATALOGS///////////////////////
    public CatWrapper getCatalogs(int key){
        CatWrapper response = new CatWrapper();
        response.arrayCategories = (List<Categories>)(Object)getGeneric(Categories.class,0);
        response.arrayTdc = (List<Tdc>)(Object)getGeneric(Tdc.class,0);
        return response;
    }


}
