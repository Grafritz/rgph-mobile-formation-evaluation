package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ht.ihsi.rgph.formation.evaluation.Managers.LoadStaticDataMngr;

/**
 * Created by JeanFritz on 5/26/2016.
 */
public class DataBaseUpgrade
{
    public final static int UPGRADE_TO_VERSION_2 = 2;
    public final static int UPGRADE_TO_VERSION_3 = 3;
    public final static int UPGRADE_TO_VERSION_5 = 5;
    public final static int UPGRADE_TO_VERSION_6 = 6;  //02 Novembre 2017
    public final static int UPGRADE_TO_VERSION_7 = 7;  //09 Novembre 2017

    //region UPDATA
    public static void onUpgrade(Context context, SQLiteDatabase db, int oldVersion, int newVersion) {
        while (oldVersion < newVersion) {
            oldVersion++;
            switch (oldVersion) {//switch (newVersion) {
                case UPGRADE_TO_VERSION_2:
                    MiseAjour_Version2(context, db, true);
                    break;
                case UPGRADE_TO_VERSION_3:
                    MiseAjour_TableChant(context, db, true);
                    break;
                case UPGRADE_TO_VERSION_5:
                    MiseAjour_Ver4_To_Ver5(context, db, true);
                    break;

                //case UPGRADE_TO_VERSION_6: //02 Novembre 2017
                    //MiseAjour_Ver5_To_Ver6(context, db, true);
                    //break;

                case UPGRADE_TO_VERSION_7: //02 Novembre 2017
                    MiseAjour_Ver6_To_Ver7(context, db, true);
                    break;

                case 8: //03-Mai-2018
                    //region [ 03-Mai-2018 : Ver 8 ]
                    /**
                     * Pas de changement au niveau des tables... mais plutot au niveau de l'application
                     * Chargement apportter dans le numero de la version de la base de Données
                     * pour passe de la version 7 a 8, au niveau de l'application de supprimer la tables Chants
                     * et de la recréee puis d'inserer les nouvelle données.
                     * */
                    //endregion
                    MiseAjour_Ver7_To_Ver8(context, db, true);
                    break;
            }
        }
    }

    //endregion

    //region VERSION 1
    public synchronized static void LoadAll_Data(Context context, SQLiteDatabase db ) {
        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.loadData(context, db);
    }
    //endregion

    //region VERSION 2 - MISE A JOUR 26-Mai-2016
    public static void MiseAjour_Version2(Context context, SQLiteDatabase db, boolean ifNotExists) {

        //db.execSQL("ALTER TABLE  CHANT ADD COLUMN  CODE_CHANT  TEXT"); // 2: CodeChant "
        //Log.i(Tools.TAG + "MiseAjour_Version2", "ADD COLUMN CODE_CHANT");

        //db.execSQL("ALTER TABLE  CHANT ADD COLUMN  IS_UPDATE   INTEGER"); // 3: IsUpdate
        //Log.i(Tools.TAG + "MiseAjour_Version2", "ADD COLUMN IS_UPDATE");

        dropAllTables_Localisation(db, ifNotExists);
        createAllTables_Version2(db, ifNotExists);
        LoadAll_DataLocalisation(context, db);
    }


    //region VERSION 2 - LOCALISATION
    public static void LoadAll_DataLocalisation(Context context, SQLiteDatabase db ) {
        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.loadData(context, db);
    }

    public static void createAllTables_Version2(SQLiteDatabase db, boolean ifNotExists) {
       /* PaysDao.createTable(db, ifNotExists);
        DepartementDao.createTable(db, ifNotExists);
        CommuneDao.createTable(db, ifNotExists);
        // CHANT Favorite
        ChantFavoriteDao.createTable(db, ifNotExists);*/
    }

    public static void dropAllTables_Localisation(SQLiteDatabase db, boolean ifExists) {
       /* PaysDao.dropTable(db, ifExists);
        Log.i(Tools.TAG + "Version2", "drop Table Pays");
        DepartementDao.dropTable(db, ifExists);
        Log.i(Tools.TAG + "Version2", "drop Table Departement");
        CommuneDao.dropTable(db, ifExists);
        Log.i(Tools.TAG + "Version2", "drop Table Commune");*/
    }
    //endregion
//endregion

    //region VERSION 3 - 03-Juin-2016 & VERSION 4 - 10-Juillet-2017
    public static void MiseAjour_TableChant(Context context, SQLiteDatabase db, boolean ifNotExists) {
       /* //db.execSQL("ALTER TABLE  CHANT ADD COLUMN  VERSION_CODE  INTEGER DEFAULT 0"); // 4: VersionCode
        //Log.i(Tools.TAG + "MiseAjour_TableChant", "ADD COLUMN VERSION_CODE");

        ChantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version3", "drop Table Chant");
        ChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version3", "Create Table Chant");

        LoadAll_DataChant(context, db);*/
    }

    public static void LoadAll_DataChant(Context context, SQLiteDatabase db ) {
       /* Log.i(Tools.TAG + "Version3", "Inside LoadAll_DataChant()");
        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.loadDataChant(context, db);*/
    }
//endregion

    //region V5:09/09/2017
    private static void MiseAjour_Ver4_To_Ver5(Context context, SQLiteDatabase db, boolean ifNotExists) {
        /*ChantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version5", "drop Table Chant");
        ChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version5", "Create Table Chant");

        LoadAll_DataChant(context, db);

        UserChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version5", "Create Table UserChant");

        UserGroupeChantantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version5", "Create Table UserGroupeChantant");*/
    }
    //endregion

    //region [ V6 : 02 Novembre 2017 ]
    private static void MiseAjour_Ver5_To_Ver6(Context context, SQLiteDatabase db, boolean ifNotExists) {
       /* Log.i(Tools.TAG + "Version6", "Inside MiseAjour_Ver5_To_Ver6()");
        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.LoadDataCommune(context, db);
        UpdateTable_Chant_Ver5_To_Ver6(db);*/
    }

    public static void UpdateTable_Chant_Ver5_To_Ver6(SQLiteDatabase db) {
        /*Log.i(Tools.TAG + "Version6", "Inside UpdateTable_ChantForV6()");
        ContentValues value = new ContentValues();
        value.put(ChantDao.Properties.AuteurChant.columnName, "");
        db.update(ChantDao.TABLENAME
                , value
                , ChantDao.Properties.AuteurChant.columnName +" = ?",
                new String[] { "N/A" });*/
    }
    //endregion

    //region [ V7 : 09 Novembre 2017 ]
    private static void MiseAjour_Ver6_To_Ver7(Context context, SQLiteDatabase db, boolean ifNotExists) {
       /* Log.i(Tools.TAG + "Version7", "Inside MiseAjour_Ver6_To_Ver7()");

        ChantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "drop Table Chant");
        ChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "Create Table Chant");

        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.loadDataChant(context, db);
        //LoadAll_DataChant(context, db);

        UserChantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "drop Table UserChant");
        UserChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "Create Table UserChant");

        UserGroupeChantantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "drop Table UserGroupeChantant");
        UserGroupeChantantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "Create Table UserGroupeChantant");

        CommuneDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "drop Table Commune");
        CommuneDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version7", "Create Table Commune");

        loadStaticDataMngr.LoadDataCommune(context, db);*/
    }
    //endregion

    //region [ 03-Mai-2018 : Ver 8 ]
    /**
     * Pas de changement au niveau des tables... mais plutot au niveau de l'application
     * Chargement apportter dans le numero de la version de la base de Données
     * pour passe de la version 7 a 8, au niveau de l'application de supprimer la tables Chants
     * et de la recréee puis d'inserer les nouvelle données.
     * */
    private static void MiseAjour_Ver7_To_Ver8(Context context, SQLiteDatabase db, boolean ifNotExists) {
       /* Log.i(Tools.TAG + "Version8", "Inside MiseAjour_Ver7_To_Ver8()");

        ChantDao.dropTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version8", "drop Table Chant");
        ChantDao.createTable(db, ifNotExists);
        Log.i(Tools.TAG + "Version8", "Create Table Chant");

        LoadStaticDataMngr loadStaticDataMngr = new LoadStaticDataMngr();
        loadStaticDataMngr.LoadAll_OnlyChant(context, db);*/
    }
    //endregion
}
