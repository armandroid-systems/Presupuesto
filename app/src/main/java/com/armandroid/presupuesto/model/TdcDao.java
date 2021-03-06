package com.armandroid.presupuesto.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.armandroid.presupuesto.model.Tdc;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TDC".
*/
public class TdcDao extends AbstractDao<Tdc, Long> {

    public static final String TABLENAME = "TDC";

    /**
     * Properties of entity Tdc.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "idTdc");
        public final static Property CardName = new Property(1, String.class, "cardName", false, "CARD_NAME");
        public final static Property Credit = new Property(2, Float.class, "credit", false, "CREDIT");
        public final static Property Expended = new Property(3, Float.class, "expended", false, "EXPENDED");
    };


    public TdcDao(DaoConfig config) {
        super(config);
    }
    
    public TdcDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TDC\" (" + //
                "\"idTdc\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CARD_NAME\" TEXT," + // 1: cardName
                "\"CREDIT\" REAL," + // 2: credit
                "\"EXPENDED\" REAL);"); // 3: expended
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TDC\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Tdc entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String cardName = entity.getCardName();
        if (cardName != null) {
            stmt.bindString(2, cardName);
        }
 
        Float credit = entity.getCredit();
        if (credit != null) {
            stmt.bindDouble(3, credit);
        }
 
        Float expended = entity.getExpended();
        if (expended != null) {
            stmt.bindDouble(4, expended);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Tdc readEntity(Cursor cursor, int offset) {
        Tdc entity = new Tdc( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cardName
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // credit
            cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3) // expended
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Tdc entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCardName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCredit(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setExpended(cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Tdc entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Tdc entity) {
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
