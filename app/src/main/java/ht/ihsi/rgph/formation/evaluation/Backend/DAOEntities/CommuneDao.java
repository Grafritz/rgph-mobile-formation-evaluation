package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Commune;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tbl_Mob_commune".
*/
public class CommuneDao extends AbstractDao<Commune, Void> {

    public static final String TABLENAME = "tbl_Mob_commune";

    /**
     * Properties of entity Commune.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ComId = new Property(0, String.class, "ComId", false, "ComId");
        public final static Property ComNom = new Property(1, String.class, "ComNom", false, "ComNom");
        public final static Property DeptId = new Property(2, String.class, "DeptId", false, "DeptId");
    };


    public CommuneDao(DaoConfig config) {
        super(config);
    }
    
    public CommuneDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tbl_Mob_commune\" (" + //
                "\"ComId\" TEXT NOT NULL UNIQUE ," + // 0: ComId
                "\"ComNom\" TEXT," + // 1: ComNom
                "\"DeptId\" TEXT NOT NULL );"); // 2: DeptId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tbl_Mob_commune\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Commune entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getComId());
 
        String ComNom = entity.getComNom();
        if (ComNom != null) {
            stmt.bindString(2, ComNom);
        }
        stmt.bindString(3, entity.getDeptId());
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Commune readEntity(Cursor cursor, int offset) {
        Commune entity = new Commune( //
            cursor.getString(offset + 0), // ComId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ComNom
            cursor.getString(offset + 2) // DeptId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Commune entity, int offset) {
        entity.setComId(cursor.getString(offset + 0));
        entity.setComNom(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDeptId(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Commune entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Commune entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
