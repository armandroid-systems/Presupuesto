package com.armandroid.presupuesto.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.armandroid.presupuesto.model.Budget;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BUDGET".
*/
public class BudgetDao extends AbstractDao<Budget, Long> {

    public static final String TABLENAME = "BUDGET";

    /**
     * Properties of entity Budget.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "idBudget");
        public final static Property IdUser = new Property(1, Integer.class, "idUser", false, "ID_USER");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Date = new Property(3, String.class, "date", false, "DATE");
    };


    public BudgetDao(DaoConfig config) {
        super(config);
    }
    
    public BudgetDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BUDGET\" (" + //
                "\"idBudget\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ID_USER\" INTEGER," + // 1: idUser
                "\"DESCRIPTION\" TEXT," + // 2: description
                "\"DATE\" TEXT);"); // 3: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BUDGET\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Budget entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer idUser = entity.getIdUser();
        if (idUser != null) {
            stmt.bindLong(2, idUser);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Budget readEntity(Cursor cursor, int offset) {
        Budget entity = new Budget( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // idUser
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Budget entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdUser(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Budget entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Budget entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
