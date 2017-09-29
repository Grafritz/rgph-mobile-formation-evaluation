package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Personnel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Tbl_Personnel".
*/
public class PersonnelDao extends AbstractDao<Personnel, Long> {

    public static final String TABLENAME = "Tbl_Personnel";

    /**
     * Properties of entity Personnel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PersId = new Property(0, Long.class, "persId", true, "persId");
        public final static Property SdeId = new Property(1, String.class, "sdeId", false, "sdeId");
        public final static Property Nom = new Property(2, String.class, "nom", false, "nom");
        public final static Property Prenom = new Property(3, String.class, "prenom", false, "prenom");
        public final static Property Sexe = new Property(4, String.class, "sexe", false, "sexe");
        public final static Property NomUtilisateur = new Property(5, String.class, "nomUtilisateur", false, "nomUtilisateur");
        public final static Property MotDePasse = new Property(6, String.class, "motDePasse", false, "motDePasse");
        public final static Property Email = new Property(7, String.class, "email", false, "email");
        public final static Property DeptId = new Property(8, String.class, "deptId", false, "deptId");
        public final static Property ComId = new Property(9, String.class, "comId", false, "comId");
        public final static Property VqseId = new Property(10, String.class, "vqseId", false, "vqseId");
        public final static Property Zone = new Property(11, String.class, "zone", false, "zone");
        public final static Property CodeDistrict = new Property(12, String.class, "codeDistrict", false, "codeDistrict");
        public final static Property EstActif = new Property(13, Boolean.class, "estActif", false, "estActif");
        public final static Property ProfileId = new Property(14, Integer.class, "ProfileId", false, "ProfileId");
        public final static Property DateDebutCollecte = new Property(15, String.class, "dateDebutCollecte", false, "dateDebutCollecte");
        public final static Property DateFinCollecte = new Property(16, String.class, "dateFinCollecte", false, "dateFinCollecte");
    };


    public PersonnelDao(DaoConfig config) {
        super(config);
    }
    
    public PersonnelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Tbl_Personnel\" (" + //
                "\"persId\" INTEGER PRIMARY KEY ," + // 0: persId
                "\"sdeId\" TEXT," + // 1: sdeId
                "\"nom\" TEXT," + // 2: nom
                "\"prenom\" TEXT," + // 3: prenom
                "\"sexe\" TEXT," + // 4: sexe
                "\"nomUtilisateur\" TEXT," + // 5: nomUtilisateur
                "\"motDePasse\" TEXT," + // 6: motDePasse
                "\"email\" TEXT," + // 7: email
                "\"deptId\" TEXT," + // 8: deptId
                "\"comId\" TEXT," + // 9: comId
                "\"vqseId\" TEXT," + // 10: vqseId
                "\"zone\" TEXT," + // 11: zone
                "\"codeDistrict\" TEXT," + // 12: codeDistrict
                "\"estActif\" INTEGER," + // 13: estActif
                "\"ProfileId\" INTEGER," + // 14: ProfileId
                "\"dateDebutCollecte\" TEXT," + // 15: dateDebutCollecte
                "\"dateFinCollecte\" TEXT);"); // 16: dateFinCollecte
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Tbl_Personnel\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Personnel entity) {
        stmt.clearBindings();
 
        Long persId = entity.getPersId();
        if (persId != null) {
            stmt.bindLong(1, persId);
        }
 
        String sdeId = entity.getSdeId();
        if (sdeId != null) {
            stmt.bindString(2, sdeId);
        }
 
        String nom = entity.getNom();
        if (nom != null) {
            stmt.bindString(3, nom);
        }
 
        String prenom = entity.getPrenom();
        if (prenom != null) {
            stmt.bindString(4, prenom);
        }
 
        String sexe = entity.getSexe();
        if (sexe != null) {
            stmt.bindString(5, sexe);
        }
 
        String nomUtilisateur = entity.getNomUtilisateur();
        if (nomUtilisateur != null) {
            stmt.bindString(6, nomUtilisateur);
        }
 
        String motDePasse = entity.getMotDePasse();
        if (motDePasse != null) {
            stmt.bindString(7, motDePasse);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(8, email);
        }
 
        String deptId = entity.getDeptId();
        if (deptId != null) {
            stmt.bindString(9, deptId);
        }
 
        String comId = entity.getComId();
        if (comId != null) {
            stmt.bindString(10, comId);
        }
 
        String vqseId = entity.getVqseId();
        if (vqseId != null) {
            stmt.bindString(11, vqseId);
        }
 
        String zone = entity.getZone();
        if (zone != null) {
            stmt.bindString(12, zone);
        }
 
        String codeDistrict = entity.getCodeDistrict();
        if (codeDistrict != null) {
            stmt.bindString(13, codeDistrict);
        }
 
        Boolean estActif = entity.getEstActif();
        if (estActif != null) {
            stmt.bindLong(14, estActif ? 1L: 0L);
        }
 
        Integer ProfileId = entity.getProfileId();
        if (ProfileId != null) {
            stmt.bindLong(15, ProfileId);
        }
 
        String dateDebutCollecte = entity.getDateDebutCollecte();
        if (dateDebutCollecte != null) {
            stmt.bindString(16, dateDebutCollecte);
        }
 
        String dateFinCollecte = entity.getDateFinCollecte();
        if (dateFinCollecte != null) {
            stmt.bindString(17, dateFinCollecte);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Personnel readEntity(Cursor cursor, int offset) {
        Personnel entity = new Personnel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // persId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // sdeId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nom
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // prenom
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sexe
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // nomUtilisateur
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // motDePasse
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // email
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // deptId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // comId
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // vqseId
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // zone
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // codeDistrict
            cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0, // estActif
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // ProfileId
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // dateDebutCollecte
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // dateFinCollecte
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Personnel entity, int offset) {
        entity.setPersId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSdeId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNom(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPrenom(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSexe(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setNomUtilisateur(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMotDePasse(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEmail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDeptId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setComId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setVqseId(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setZone(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCodeDistrict(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setEstActif(cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0);
        entity.setProfileId(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setDateDebutCollecte(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setDateFinCollecte(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Personnel entity, long rowId) {
        entity.setPersId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Personnel entity) {
        if(entity != null) {
            return entity.getPersId();
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
