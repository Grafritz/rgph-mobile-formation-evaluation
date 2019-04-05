package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.ReponseEntree;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Tbl_Mob_ReponseEntree".
*/
public class ReponseEntreeDao extends AbstractDao<ReponseEntree, Long> {

    public static final String TABLENAME = "Tbl_Mob_ReponseEntree";

    /**
     * Properties of entity ReponseEntree.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CodeReponseEntree = new Property(0, Long.class, "codeReponseEntree", true, "codeReponseEntree");
        public final static Property PersonnelId = new Property(1, Long.class, "personnelId", false, "personnelId");
        public final static Property CodeFormulaireExercice = new Property(2, Long.class, "codeFormulaireExercice", false, "codeFormulaireExercice");
        public final static Property CodeQuestion = new Property(3, Long.class, "codeQuestion", false, "codeQuestion");
        public final static Property CodeReponse = new Property(4, Long.class, "codeReponse", false, "codeReponse");
        public final static Property CodeJustificationReponse = new Property(5, Long.class, "CodeJustificationReponse", false, "CodeJustificationReponse");
        public final static Property ReponseSaisie = new Property(6, String.class, "reponseSaisie", false, "reponseSaisie");
        public final static Property CreatedBy = new Property(7, String.class, "createdBy", false, "createdBy");
        public final static Property DateCreated = new Property(8, String.class, "dateCreated", false, "dateCreated");
        public final static Property ModifBy = new Property(9, String.class, "modifBy", false, "modifBy");
        public final static Property DateModif = new Property(10, String.class, "dateModif", false, "dateModif");
    };


    public ReponseEntreeDao(DaoConfig config) {
        super(config);
    }
    
    public ReponseEntreeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Tbl_Mob_ReponseEntree\" (" + //
                "\"codeReponseEntree\" INTEGER PRIMARY KEY ," + // 0: codeReponseEntree
                "\"personnelId\" INTEGER," + // 1: personnelId
                "\"codeFormulaireExercice\" INTEGER," + // 2: codeFormulaireExercice
                "\"codeQuestion\" INTEGER," + // 3: codeQuestion
                "\"codeReponse\" INTEGER," + // 4: codeReponse
                "\"CodeJustificationReponse\" INTEGER," + // 5: CodeJustificationReponse
                "\"reponseSaisie\" TEXT," + // 6: reponseSaisie
                "\"createdBy\" TEXT," + // 7: createdBy
                "\"dateCreated\" TEXT," + // 8: dateCreated
                "\"modifBy\" TEXT," + // 9: modifBy
                "\"dateModif\" TEXT);"); // 10: dateModif
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Tbl_Mob_ReponseEntree\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ReponseEntree entity) {
        stmt.clearBindings();
 
        Long codeReponseEntree = entity.getCodeReponseEntree();
        if (codeReponseEntree != null) {
            stmt.bindLong(1, codeReponseEntree);
        }
 
        Long personnelId = entity.getPersonnelId();
        if (personnelId != null) {
            stmt.bindLong(2, personnelId);
        }
 
        Long codeFormulaireExercice = entity.getCodeFormulaireExercice();
        if (codeFormulaireExercice != null) {
            stmt.bindLong(3, codeFormulaireExercice);
        }
 
        Long codeQuestion = entity.getCodeQuestion();
        if (codeQuestion != null) {
            stmt.bindLong(4, codeQuestion);
        }
 
        Long codeReponse = entity.getCodeReponse();
        if (codeReponse != null) {
            stmt.bindLong(5, codeReponse);
        }
 
        Long CodeJustificationReponse = entity.getCodeJustificationReponse();
        if (CodeJustificationReponse != null) {
            stmt.bindLong(6, CodeJustificationReponse);
        }
 
        String reponseSaisie = entity.getReponseSaisie();
        if (reponseSaisie != null) {
            stmt.bindString(7, reponseSaisie);
        }
 
        String createdBy = entity.getCreatedBy();
        if (createdBy != null) {
            stmt.bindString(8, createdBy);
        }
 
        String dateCreated = entity.getDateCreated();
        if (dateCreated != null) {
            stmt.bindString(9, dateCreated);
        }
 
        String modifBy = entity.getModifBy();
        if (modifBy != null) {
            stmt.bindString(10, modifBy);
        }
 
        String dateModif = entity.getDateModif();
        if (dateModif != null) {
            stmt.bindString(11, dateModif);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ReponseEntree readEntity(Cursor cursor, int offset) {
        ReponseEntree entity = new ReponseEntree( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // codeReponseEntree
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // personnelId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // codeFormulaireExercice
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // codeQuestion
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // codeReponse
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // CodeJustificationReponse
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // reponseSaisie
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // createdBy
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // dateCreated
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // modifBy
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // dateModif
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ReponseEntree entity, int offset) {
        entity.setCodeReponseEntree(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPersonnelId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCodeFormulaireExercice(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setCodeQuestion(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setCodeReponse(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setCodeJustificationReponse(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setReponseSaisie(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreatedBy(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDateCreated(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setModifBy(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDateModif(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ReponseEntree entity, long rowId) {
        entity.setCodeReponseEntree(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ReponseEntree entity) {
        if(entity != null) {
            return entity.getCodeReponseEntree();
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
