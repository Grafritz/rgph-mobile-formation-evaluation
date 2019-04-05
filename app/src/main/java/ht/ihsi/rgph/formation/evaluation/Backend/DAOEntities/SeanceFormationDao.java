package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.SeanceFormation;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Tbl_Mob_SeanceFormation".
*/
public class SeanceFormationDao extends AbstractDao<SeanceFormation, Long> {

    public static final String TABLENAME = "Tbl_Mob_SeanceFormation";

    /**
     * Properties of entity SeanceFormation.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property SeanceFormationId = new Property(0, Long.class, "seanceFormationId", true, "seanceFormationId");
        public final static Property FormationId = new Property(1, Long.class, "formationId", false, "formationId");
        public final static Property NomSeance = new Property(2, String.class, "nomSeance", false, "nomSeance");
        public final static Property DateSeance = new Property(3, String.class, "dateSeance", false, "dateSeance");
        public final static Property Jour = new Property(4, Integer.class, "jour", false, "jour");
        public final static Property HeureDebut = new Property(5, String.class, "heureDebut", false, "heureDebut");
        public final static Property HeureDeFin = new Property(6, String.class, "heureDeFin", false, "heureDeFin");
        public final static Property Domaine = new Property(7, Short.class, "domaine", false, "domaine");
        public final static Property TypeSeance = new Property(8, Short.class, "typeSeance", false, "typeSeance");
    };


    public SeanceFormationDao(DaoConfig config) {
        super(config);
    }
    
    public SeanceFormationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Tbl_Mob_SeanceFormation\" (" + //
                "\"seanceFormationId\" INTEGER PRIMARY KEY ," + // 0: seanceFormationId
                "\"formationId\" INTEGER," + // 1: formationId
                "\"nomSeance\" TEXT," + // 2: nomSeance
                "\"dateSeance\" TEXT," + // 3: dateSeance
                "\"jour\" INTEGER," + // 4: jour
                "\"heureDebut\" TEXT," + // 5: heureDebut
                "\"heureDeFin\" TEXT," + // 6: heureDeFin
                "\"domaine\" INTEGER," + // 7: domaine
                "\"typeSeance\" INTEGER);"); // 8: typeSeance
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Tbl_Mob_SeanceFormation\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SeanceFormation entity) {
        stmt.clearBindings();
 
        Long seanceFormationId = entity.getSeanceFormationId();
        if (seanceFormationId != null) {
            stmt.bindLong(1, seanceFormationId);
        }
 
        Long formationId = entity.getFormationId();
        if (formationId != null) {
            stmt.bindLong(2, formationId);
        }
 
        String nomSeance = entity.getNomSeance();
        if (nomSeance != null) {
            stmt.bindString(3, nomSeance);
        }
 
        String dateSeance = entity.getDateSeance();
        if (dateSeance != null) {
            stmt.bindString(4, dateSeance);
        }
 
        Integer jour = entity.getJour();
        if (jour != null) {
            stmt.bindLong(5, jour);
        }
 
        String heureDebut = entity.getHeureDebut();
        if (heureDebut != null) {
            stmt.bindString(6, heureDebut);
        }
 
        String heureDeFin = entity.getHeureDeFin();
        if (heureDeFin != null) {
            stmt.bindString(7, heureDeFin);
        }
 
        Short domaine = entity.getDomaine();
        if (domaine != null) {
            stmt.bindLong(8, domaine);
        }
 
        Short typeSeance = entity.getTypeSeance();
        if (typeSeance != null) {
            stmt.bindLong(9, typeSeance);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SeanceFormation readEntity(Cursor cursor, int offset) {
        SeanceFormation entity = new SeanceFormation( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // seanceFormationId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // formationId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nomSeance
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // dateSeance
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // jour
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // heureDebut
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // heureDeFin
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7), // domaine
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) // typeSeance
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SeanceFormation entity, int offset) {
        entity.setSeanceFormationId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFormationId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setNomSeance(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDateSeance(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setJour(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setHeureDebut(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setHeureDeFin(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDomaine(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7));
        entity.setTypeSeance(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SeanceFormation entity, long rowId) {
        entity.setSeanceFormationId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SeanceFormation entity) {
        if(entity != null) {
            return entity.getSeanceFormationId();
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
