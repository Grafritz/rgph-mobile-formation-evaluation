package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.MaterielExercice;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Tbl_Mob_MaterielExercice".
*/
public class MaterielExerciceDao extends AbstractDao<MaterielExercice, Long> {

    public static final String TABLENAME = "Tbl_Mob_MaterielExercice";

    /**
     * Properties of entity MaterielExercice.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MaterielExerciceId = new Property(0, Long.class, "MaterielExerciceId", true, "MaterielExerciceId");
        public final static Property CodeFormulaireExercice = new Property(1, Long.class, "CodeFormulaireExercice", false, "CodeFormulaireExercice");
        public final static Property PersonnelId = new Property(2, Long.class, "PersonnelId", false, "PersonnelId");
        public final static Property Imei = new Property(3, String.class, "Imei", false, "Imei");
        public final static Property Serial = new Property(4, String.class, "Serial", false, "Serial");
        public final static Property Model = new Property(5, String.class, "Model", false, "Model");
        public final static Property Version = new Property(6, String.class, "Version", false, "Version");
        public final static Property DateTransfert = new Property(7, String.class, "DateTransfert", false, "DateTransfert");
    };


    public MaterielExerciceDao(DaoConfig config) {
        super(config);
    }
    
    public MaterielExerciceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Tbl_Mob_MaterielExercice\" (" + //
                "\"MaterielExerciceId\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: MaterielExerciceId
                "\"CodeFormulaireExercice\" INTEGER," + // 1: CodeFormulaireExercice
                "\"PersonnelId\" INTEGER," + // 2: PersonnelId
                "\"Imei\" TEXT," + // 3: Imei
                "\"Serial\" TEXT," + // 4: Serial
                "\"Model\" TEXT," + // 5: Model
                "\"Version\" TEXT," + // 6: Version
                "\"DateTransfert\" TEXT);"); // 7: DateTransfert
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Tbl_Mob_MaterielExercice\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MaterielExercice entity) {
        stmt.clearBindings();
 
        Long MaterielExerciceId = entity.getMaterielExerciceId();
        if (MaterielExerciceId != null) {
            stmt.bindLong(1, MaterielExerciceId);
        }
 
        Long CodeFormulaireExercice = entity.getCodeFormulaireExercice();
        if (CodeFormulaireExercice != null) {
            stmt.bindLong(2, CodeFormulaireExercice);
        }
 
        Long PersonnelId = entity.getPersonnelId();
        if (PersonnelId != null) {
            stmt.bindLong(3, PersonnelId);
        }
 
        String Imei = entity.getImei();
        if (Imei != null) {
            stmt.bindString(4, Imei);
        }
 
        String Serial = entity.getSerial();
        if (Serial != null) {
            stmt.bindString(5, Serial);
        }
 
        String Model = entity.getModel();
        if (Model != null) {
            stmt.bindString(6, Model);
        }
 
        String Version = entity.getVersion();
        if (Version != null) {
            stmt.bindString(7, Version);
        }
 
        String DateTransfert = entity.getDateTransfert();
        if (DateTransfert != null) {
            stmt.bindString(8, DateTransfert);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MaterielExercice readEntity(Cursor cursor, int offset) {
        MaterielExercice entity = new MaterielExercice( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // MaterielExerciceId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // CodeFormulaireExercice
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // PersonnelId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Imei
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Serial
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Model
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Version
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // DateTransfert
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MaterielExercice entity, int offset) {
        entity.setMaterielExerciceId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCodeFormulaireExercice(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setPersonnelId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setImei(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSerial(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setModel(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVersion(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDateTransfert(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MaterielExercice entity, long rowId) {
        entity.setMaterielExerciceId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MaterielExercice entity) {
        if(entity != null) {
            return entity.getMaterielExerciceId();
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
