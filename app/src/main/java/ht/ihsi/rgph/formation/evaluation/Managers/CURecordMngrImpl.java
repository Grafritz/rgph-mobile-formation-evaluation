package ht.ihsi.rgph.formation.evaluation.Managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_Exercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_ExercicesDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.DaoSession;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Personnel;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.PersonnelDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.ReponseEntree;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.ReponseEntreeDao;
import ht.ihsi.rgph.formation.evaluation.Constant.Constant;
import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Exceptions.TextEmptyException;
import ht.ihsi.rgph.formation.evaluation.Mappers.ModelMapper;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.PersonnelModel;
import ht.ihsi.rgph.formation.evaluation.Models.ReponseEntreeModel;
import ht.ihsi.rgph.formation.evaluation.Utilities.Tools;


/**
 * Created by jadme on 3/22/2016.
 */
public class CURecordMngrImpl extends AbstractDatabaseManager implements CURecordMngr {

    private static CURecordMngrImpl instance;

    public CURecordMngrImpl(final Context content) {
        super(content);
    }

    //region required methods
    public static CURecordMngrImpl getInstance(Context context) {

        if (instance == null) {
            instance = new CURecordMngrImpl(context);
        }

        return instance;
    }

    public DaoSession getDaoSession() {
        DaoSession session = daoSession;
        return session;
    }

    @Override
    public void closeDbConnections() {
        closeConnections();
        if (instance != null) {
            instance = null;
        }
    }

    @Override
    public synchronized ReponseEntreeModel InsertReponseEntree(ReponseEntreeModel reponseEntreeModel) throws ManagerException, TextEmptyException {
        if ( reponseEntreeModel != null ) {
            openWritableDb();
            ReponseEntreeDao obj = daoSession.getReponseEntreeDao();
            long idpersonne = obj.insert(ModelMapper.MapTo(reponseEntreeModel));
            if ( idpersonne != 0 ) {
                //ReponseEntree bat = obj.load(idpersonne);
                Log.d(Tools.TAG, "ReponseEntree / Insert ID:" + idpersonne );
                reponseEntreeModel.setCodeReponseEntree(idpersonne);
                daoSession.clear();
                return reponseEntreeModel;
            } else {
                throw new ManagerException("Une erreur est survenue lors de l'enregistrement ");
            }
        } else {
            Log.d(Tools.TAG + "savePersonnel", "personnel is null ");
        }
        return null;
    }

    @Override
    public Agent_Evaluation_ExercicesModel SaveAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel, long codeAgentEvaluationExercices) throws ManagerException {
        try {
            if ( codeAgentEvaluationExercices <= 0 ) {
                //Validation(personnelModel);
                agent_evaluation_exercicesModel = InsertAgent_Evaluation_Exercices(agent_evaluation_exercicesModel);
            } else {
                agent_evaluation_exercicesModel.setCodeAgentEvaluationExercices(codeAgentEvaluationExercices);
                agent_evaluation_exercicesModel = UpdateAgent_Evaluation_Exercices(agent_evaluation_exercicesModel);
            }
        }catch (Exception ex){
            throw ex;
        }
        return agent_evaluation_exercicesModel;
    }

    @Override
    public Agent_Evaluation_ExercicesModel InsertAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel) throws ManagerException {
        if ( agent_evaluation_exercicesModel != null ) {
            openWritableDb();
            Agent_Evaluation_ExercicesDao obj = daoSession.getAgent_Evaluation_ExercicesDao();
            try {
                long _id = obj.insert(ModelMapper.MapTo(agent_evaluation_exercicesModel));
                agent_evaluation_exercicesModel.setCodeAgentEvaluationExercices(_id);
                if ( _id != 0 ) {
                    //ReponseEntree bat = obj.load(_id);
                    Log.d(Tools.TAG, "Agent_Evaluation_ExercicesModel / Insert ID:" + _id );
                    daoSession.clear();
                    return agent_evaluation_exercicesModel;
                } else {
                    throw new ManagerException("Une erreur est survenue lors de l'enregistrement ");
                }
            } catch (Exception ex) {
                throw new ManagerException("Une erreur est survenue lors de l'enregistrement "+ ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public Agent_Evaluation_ExercicesModel UpdateAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel) throws ManagerException {
        if (agent_evaluation_exercicesModel != null) {
            openReadableDb();
            Agent_Evaluation_ExercicesDao dao = daoSession.getAgent_Evaluation_ExercicesDao();
            Agent_Evaluation_Exercices obj = dao.load(agent_evaluation_exercicesModel.getCodeAgentEvaluationExercices());
            //Log.d(ToastUtility.TAG, " B. UPDATING / BID:"+personnelModel.getPersId()  );
            if (obj != null) {
                obj = ModelMapper.MapTo(agent_evaluation_exercicesModel);
                obj.setCodeAgentEvaluationExercices(agent_evaluation_exercicesModel.getCodeAgentEvaluationExercices());
                try {
                    dao.update(obj);
                    //Log.d(ToastUtility.TAG, "PERSONNEL UPDATING / BID:"+personnelModel.getPersId()  );
                    daoSession.clear();
                    return ModelMapper.MapTo(obj);
                } catch (Exception ex) {
                    throw new ManagerException("Manager Exception: " + ex.getMessage());
                }
            }
        }
        return null;
    }
    //endregion

    //region database managers

    @Override
    public PersonnelModel savePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException {
        if ( personnelModel != null ) {
            openWritableDb();
            PersonnelDao personnelDao = daoSession.getPersonnelDao();
            long idpersonne = personnelDao.insert(ModelMapper.MapTo(personnelModel));
            if ( idpersonne != 0 ) {
                Personnel bat = personnelDao.load(idpersonne);
                Log.d(Tools.TAG, "savePersonnelModel / Insert ID:" + bat.getPersId() );
                personnelModel.setPersId(idpersonne);
                daoSession.clear();
                return personnelModel;
            } else {
                throw new ManagerException("Error while Inserting the personnelModel ");
            }
        } else {
            Log.d(Tools.TAG + "savePersonnel", "personnel is null ");
        }
        return null;
    }

    @Override
    public PersonnelModel SavePersonnel(long id, PersonnelModel personnelModel, String userCode) throws ManagerException, TextEmptyException {
        try {
            if (id <= 0) {
                Validation(personnelModel);
                personnelModel = savePersonnel(personnelModel, userCode);
            } else if (id > 0) {
                personnelModel.setPersId(id);
                personnelModel = updatePersonnel(personnelModel, userCode);
            }
        }catch (TextEmptyException ex){
            throw ex;
        }
        return personnelModel;
    }
    private void Validation(PersonnelModel personnelModel) throws TextEmptyException {
        if( GetPersonnelByCompteUtilisateur(personnelModel) ){
            throw new TextEmptyException("Ce Compte Utilisateur [ "+ personnelModel.getNomUtilisateur() +" ] est déjà enregistré");
        }
    }
    private boolean GetPersonnelByCompteUtilisateur(PersonnelModel personnelModel) {
        Log.i(MANAGERS, "Inside of GetPersonnelByCompteUtilisateur! / codeSDE :"+personnelModel.getPersId());
        boolean result = false;
        //try {
        openReadableDb();
        Personnel loges = daoSession.getPersonnelDao().queryBuilder()
                .where(PersonnelDao.Properties.NomUtilisateur.eq(personnelModel.getNomUtilisateur())).unique();
        //result= MapToRowsBatiment(loges);
        daoSession.clear();
        if (loges == null) {
            result = false;
        }else if (loges != null) {
            long id = 0;
            if ( personnelModel.getPersId() > 0 && personnelModel != null ){
                id = personnelModel.getPersId();
            }
            if( id == 0 ){
                result = true;
            }else if (loges.getPersId() != id ){
                result = true;
            }else{
                result = false;
            }
        }
        //} catch (Exception ex) {
        //    throw ex;
        //}
        return result;
    }

    /**
     * Save a new entity
     *
     * @param entite
     * @return
     */
    @Override
    public synchronized <T> T saveEntity(T entite) throws ManagerException {
        /*if (entite.getClass() == BatimentModel.class) {
            saveBatiment((BatimentModel) entite,"");
            return entite;
        }
        if (entite.getClass() == LogementModel.class) {
            saveLogement((LogementModel) entite,"");
            return entite;
        }
        if (entite.getClass() == MenageModel.class) {
            saveMenage((MenageModel) entite,"");
            return entite;
        }
        if (entite.getClass() == EmigreModel.class) {
            saveEmigre((EmigreModel) entite,"");
            return entite;
        }
        if (entite.getClass() == DecesModel.class) {
            saveDeces((DecesModel) entite,"");
            return entite;
        }
        if (entite.getClass() == IndividuModel.class) {
            saveIndividu((IndividuModel) entite,"");
            return entite;
        }
        if (entite.getClass() == RapportRARModel.class) {
            saveRapportRAR((RapportRARModel) entite);
            return entite;
        }*/
        return null;
    }

    @Override
    public PersonnelModel updatePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException {
        if (personnelModel != null) {
            openReadableDb();
            PersonnelDao personnelDao = daoSession.getPersonnelDao();
            Personnel personnel = personnelDao.load(personnelModel.getPersId());
            //Log.d(ToastUtility.TAG, " B. UPDATING / BID:"+personnelModel.getPersId()  );
            if (personnel != null) {
                personnel = ModelMapper.MapTo(personnelModel);
                personnel.setPersId(personnelModel.getPersId());
                try {
                    personnelDao.update(personnel);
                    //Log.d(ToastUtility.TAG, "PERSONNEL UPDATING / BID:"+personnelModel.getPersId()  );
                    daoSession.clear();
                    return ModelMapper.MapTo(personnel);
                } catch (Exception ex) {
                    throw new ManagerException("Manager Exception: " + ex.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public PersonnelModel updateAllPersonnel(long persId, String userCode) throws ManagerException {
        try {
            openReadableDb();
            SQLiteDatabase db = getDatabase();

            ContentValues value = new ContentValues();
            value.put(PersonnelDao.Properties.EstActif.columnName, 0);

            db.update(PersonnelDao.TABLENAME, value, "" + PersonnelDao.Properties.PersId.columnName + " <> ?"
                            +" AND " + PersonnelDao.Properties.PersId.columnName + " <> 1"
                            +" AND " + PersonnelDao.Properties.PersId.columnName + " <> 2"
                            +" AND " + PersonnelDao.Properties.ProfileId.columnName + " = " + Constant.PRIVILEGE_AGENT,
                    new String[] { String.valueOf(persId) });

            db.close();
            daoSession.clear();
        } catch (Exception ex) {
            Log.i(MANAGERS, "<> unable to get data from the database " + ex.getMessage());
            throw new ManagerException("<> unable to get data from the database ", ex);
        }
        return null;
    }

    /**
     * Update an entity
     *
     * @param entite
     * @return T entity.
     */
    @Override
    public synchronized <T> T updateEntity(T entite) throws ManagerException {
        try {
           /* if (entite.getClass() == BatimentModel.class) {
                updateBatiment((BatimentModel) entite, "");
                return entite;
            }
            if (entite.getClass() == LogementModel.class) {
                updateLogement((LogementModel) entite, "");
                return entite;
            }
            if (entite.getClass() == MenageModel.class) {
                updateMenage((MenageModel) entite, "");
                return entite;
            }
            if (entite.getClass() == EmigreModel.class) {
                updateEmigre((EmigreModel) entite, "");
                return entite;
            }
            if (entite.getClass() == DecesModel.class) {
                updateDeces((DecesModel) entite, "");
                return entite;
            }
            if (entite.getClass() == IndividuModel.class) {
                updateIndividu((IndividuModel) entite, "");
                return entite;
            }*/
        } catch (Exception ex) {
            throw new ManagerException("" + ex.getMessage());
        }
        return null;
    }


    //endregion
}
