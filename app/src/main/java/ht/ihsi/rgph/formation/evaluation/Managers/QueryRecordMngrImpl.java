package ht.ihsi.rgph.formation.evaluation.Managers;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_Exercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_ExercicesDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.FormulaireExercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Personnel;
import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Mappers.ModelMapper;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.FormulaireExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.RowDataListModel;
import ht.ihsi.rgph.formation.evaluation.Utilities.Shared_Preferences;
import ht.ihsi.rgph.formation.evaluation.Utilities.Tools;

/**
 * Created by jadme on 3/21/2016.
 */
public class QueryRecordMngrImpl extends AbstractDatabaseManager implements QueryRecordMngr {

    private static QueryRecordMngrImpl instance;
    private static Context context;

    public QueryRecordMngrImpl(final Context context) {
        super(context);
        QueryRecordMngrImpl.context = context;
    }

    //region required methods
    public static QueryRecordMngrImpl getInstance(Context context){

        if (instance == null) {
            instance = new QueryRecordMngrImpl(context);
        }

        return instance;
    }

    @Override
    public void closeDbConnections(){
       closeConnections();
        if (instance != null) {
            instance = null;
        }
    }

    @Override
    public int countAllDepartement() {
        Log.i(MANAGERS, "Inside of countAllDepartement!");
        long result=0;
        try {
            openReadableDb();
            result = daoSession.getDepartementDao().queryBuilder().count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to count All Departement : " + ex.getMessage());
        }
        return (int) result;
    }

    @Override
    public List<RowDataListModel> searchListProfilUser(Shared_Preferences SPref) throws ManagerException {
        Log.i(MANAGERS, "Inside of searchListProfilUser!");
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<Personnel> personnels = daoSession.getPersonnelDao().queryBuilder().list();
            result = ModelMapper.MapToRows(SPref, personnels);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchList_FormulaireExercice() throws ManagerException {
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<FormulaireExercices> formulaireExercices = daoSession.getFormulaireExercicesDao().queryBuilder().list();
            result = MapToRows(formulaireExercices);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }


    //endregion

    //region additional

    @Override
    public synchronized Agent_Evaluation_ExercicesModel getAgent_Evaluation_Exercices_ByIdAgent(long idFormExercice, long idPersonnel) throws ManagerException {
        Agent_Evaluation_ExercicesModel result=null;
        try {
            openReadableDb();
            QueryBuilder<Agent_Evaluation_Exercices> qr = daoSession.getAgent_Evaluation_ExercicesDao().queryBuilder()
                    .where(Agent_Evaluation_ExercicesDao.Properties.CodeExercice.eq(idFormExercice))
                    .where(Agent_Evaluation_ExercicesDao.Properties.PersonnelId.eq(idPersonnel));

            Agent_Evaluation_Exercices reponsesList = qr.unique();
            daoSession.clear();
            if( reponsesList!=null)
                result = ModelMapper.MapTo(reponsesList);
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable get Agent_Evaluation_Exercices_ByIdAgent" + ex.toString());
            throw new ManagerException("Une erreur est survenue lors de la recherche",ex);
        }
        return result;
    }

    public synchronized Boolean GetIsReadyToEvaluate (long idFormExercice, long idPersonnel) throws ManagerException {
        boolean result=true;
        try {
            openReadableDb();
            QueryBuilder<Agent_Evaluation_Exercices> qr = daoSession.getAgent_Evaluation_ExercicesDao().queryBuilder()
                    .where(Agent_Evaluation_ExercicesDao.Properties.CodeExercice.eq(idFormExercice))
                    .where(Agent_Evaluation_ExercicesDao.Properties.PersonnelId.eq(idPersonnel));
            Agent_Evaluation_Exercices reponsesList = qr.unique();
            daoSession.clear();

            if( reponsesList!=null)
                result = false;
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable Get Is Ready To Evaluate" + ex.toString());
            throw new ManagerException("Une erreur est survenue lors de la recherche",ex);
        }
        return result;
    }
    public Boolean Get_IsReadyToEvaluate (long idFormExercice, long idPersonnel)  {
        boolean result=true;
        try {
            result = GetIsReadyToEvaluate(idFormExercice, idPersonnel);
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable Get Is Ready To Evaluate" + ex.toString());
        }
        return result;
    }


    public List<RowDataListModel> MapToRows(List<FormulaireExercices> formulaireExercicesList) {
        List<RowDataListModel> result = new ArrayList<>();
        if (formulaireExercicesList != null && formulaireExercicesList.size() > 0) {
            for (FormulaireExercices fExercices : formulaireExercicesList) {
                RowDataListModel r = new RowDataListModel();
                r.setId(fExercices.getCodeExercice());
                r.setTitle("" + fExercices.getLibelleExercice());
                String desc = "" + fExercices.getDescriptions().substring(0, 25) + "[...]"
                        + " | <b>Durée :</b> " + fExercices.getDureeEnSeconde() + " Sec";
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(false);
                r.setModel(MapTo(fExercices));

                result.add(r);
            }
        } else {
        }
        return result;
    }

    public FormulaireExercicesModel MapTo(FormulaireExercices entity) {
        FormulaireExercicesModel m = new FormulaireExercicesModel();
        m.setCodeExercice(entity.getCodeExercice()) ;
        m.setLibelleExercice(entity.getLibelleExercice());
        m.setDescriptions(entity.getDescriptions());
        m.setInstructions(entity.getInstructions());
        m.setRappelExercice(entity.getRappelExercice());
        m.setTypeEvaluation(entity.getTypeEvaluation());
        m.setStatut(entity.getStatut());

        Shared_Preferences infoUser = Tools.SharedPreferences(context);
        long getPersId =0;
        if (infoUser != null && infoUser.getPersId() != null) {
            getPersId = infoUser.getPersId();
        }
        boolean isReadyToEvaluate=Get_IsReadyToEvaluate(entity.getCodeExercice(), getPersId);

        m.setIsReadyToEvaluate(isReadyToEvaluate);
        m.setDureeEnSeconde(entity.getDureeEnSeconde());
        return m;
    }
    //endregion
}
