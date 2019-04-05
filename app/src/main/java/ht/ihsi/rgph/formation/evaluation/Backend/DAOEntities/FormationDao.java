package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Formation;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Tbl_Mob_Formation".
*/
public class FormationDao extends AbstractDao<Formation, Long> {

    public static final String TABLENAME = "Tbl_Mob_Formation";

    /**
     * Properties of entity Formation.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property FormationId = new Property(0, Long.class, "formationId", true, "formationId");
        public final static Property TitreFormation = new Property(1, String.class, "titreFormation", false, "titreFormation");
        public final static Property NiveauFormation = new Property(2, Short.class, "niveauFormation", false, "niveauFormation");
        public final static Property Duree = new Property(3, Integer.class, "duree", false, "duree");
        public final static Property DateDebut = new Property(4, String.class, "dateDebut", false, "dateDebut");
        public final static Property DateFin = new Property(5, String.class, "dateFin", false, "dateFin");
    };


    public FormationDao(DaoConfig config) {
        super(config);
    }
    
    public FormationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Tbl_Mob_Formation\" (" + //
                "\"formationId\" INTEGER PRIMARY KEY ," + // 0: formationId
                "\"titreFormation\" TEXT," + // 1: titreFormation
                "\"niveauFormation\" INTEGER," + // 2: niveauFormation
                "\"duree\" INTEGER," + // 3: duree
                "\"dateDebut\" TEXT," + // 4: dateDebut
                "\"dateFin\" TEXT);"); // 5: dateFin
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Tbl_Mob_Formation\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Formation entity) {
        stmt.clearBindings();
 
        Long formationId = entity.getFormationId();
        if (formationId != null) {
            stmt.bindLong(1, formationId);
        }
 
        String titreFormation = entity.getTitreFormation();
        if (titreFormation != null) {
            stmt.bindString(2, titreFormation);
        }
 
        Short niveauFormation = entity.getNiveauFormation();
        if (niveauFormation != null) {
            stmt.bindLong(3, niveauFormation);
        }
 
        Integer duree = entity.getDuree();
        if (duree != null) {
            stmt.bindLong(4, duree);
        }
 
        String dateDebut = entity.getDateDebut();
        if (dateDebut != null) {
            stmt.bindString(5, dateDebut);
        }
 
        String dateFin = entity.getDateFin();
        if (dateFin != null) {
            stmt.bindString(6, dateFin);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Formation readEntity(Cursor cursor, int offset) {
        Formation entity = new Formation( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // formationId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // titreFormation
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2), // niveauFormation
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // duree
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // dateDebut
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // dateFin
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Formation entity, int offset) {
        entity.setFormationId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitreFormation(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNiveauFormation(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2));
        entity.setDuree(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setDateDebut(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDateFin(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Formation entity, long rowId) {
        entity.setFormationId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Formation entity) {
        if(entity != null) {
            return entity.getFormationId();
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
