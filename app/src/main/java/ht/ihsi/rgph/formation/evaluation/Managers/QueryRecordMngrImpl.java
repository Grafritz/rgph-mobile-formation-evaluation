package ht.ihsi.rgph.formation.evaluation.Managers;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_Exercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Agent_Evaluation_ExercicesDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.FormulaireExercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.FormulaireExercicesDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Personnel;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.PersonnelDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Question_FormulaireExercices;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Question_FormulaireExercicesDao;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Questions;
import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.QuestionsDao;
import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Mappers.ModelMapper;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.FormulaireExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.KeyValueModel;
import ht.ihsi.rgph.formation.evaluation.Models.PersonnelModel;
import ht.ihsi.rgph.formation.evaluation.Models.QuestionsModel;
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

    public FormulaireExercicesModel GetInfoFormulaireExercice_ById(long CodeExercice) {
        FormulaireExercicesModel result = null;
        try {
            openReadableDb();
            FormulaireExercices frm = daoSession.getFormulaireExercicesDao().queryBuilder()
                    .where(FormulaireExercicesDao.Properties.CodeExercice.eq(CodeExercice)).unique();
            if( frm != null ){
                result = ModelMapper.MapTo(frm);
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to Get Info Formulaire Exercice By Id: " + ex.getMessage());
            //throw  new ManagerException("<> unable to Get Info Formulaire Exercice By Id: ",ex);
        }
        return result;
    }
    //region [ RowDataListModel ]
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
          List<FormulaireExercices> formulaireExercices = daoSession.getFormulaireExercicesDao().queryBuilder().list();
            result = MapToRows(formulaireExercices);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchList_FormulaireExercice_ByType(long typeExercice) throws ManagerException {
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<FormulaireExercices> formulaireExercices = daoSession.getFormulaireExercicesDao().queryBuilder()
                    .where(FormulaireExercicesDao.Properties.TypeEvaluation.eq(""+typeExercice))
                    .list();
            result = MapToRows(formulaireExercices);
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to search All  searchList_FormulaireExercice_ByType: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  searchList_FormulaireExercice_ByType ",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchList_TypeExercice() throws ManagerException {
        List<RowDataListModel> result = null;
        try {
            List<KeyValueModel> listTypeExercice = Tools.getList_TypeExercice();
            result = MapToRowsKeyValue(listTypeExercice);
        }catch(Exception ex){
            //Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  searchList_TypeExercice ",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchList_AgentParEvaluation() throws ManagerException {
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<PersonnelModel> personnelModelList = new ArrayList<PersonnelModel>();
            List<Personnel> personnelList = daoSession.getPersonnelDao().queryBuilder().list();
            if ( personnelList != null && personnelList.size() > 0 ) {
                for (Personnel obj : personnelList) {
                    int count_AEE_ByPersId = Count_AEE_ByPersId(obj.getPersId());
                    if( count_AEE_ByPersId > 0 ){
                        personnelModelList.add(ModelMapper.MapTo(obj));
                    }
                }
            }
            result = MapToRows_Pers(personnelModelList);
            daoSession.clear();
        }catch(Exception ex){
            //Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }

    @Override
    public List<RowDataListModel> searchList_Resultat_ParAgent(long personelId) throws ManagerException {
        List<RowDataListModel> result = null;
        try {
            openReadableDb();
            List<Agent_Evaluation_Exercices> evaluation_list = daoSession.getAgent_Evaluation_ExercicesDao().queryBuilder()
                    .where(Agent_Evaluation_ExercicesDao.Properties.PersonnelId.eq(personelId)).list();

            if ( evaluation_list != null && evaluation_list.size() > 0 ) {
                result = MapToRowsAEE(evaluation_list);
            }
            daoSession.clear();
        }catch(Exception ex){
            //Log.e(MANAGERS, "Exception <> unable to search All  ListProfilUser: "+ex.getMessage());
            throw  new ManagerException("<> unable to search All  ListProfilUser ",ex);
        }
        return result;
    }
    //endregion

    //endregion

    //region [ Additional ]

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


    public PersonnelModel getPersonnelInfo_ById(long persId) {
        PersonnelModel result = null;
        try {
            openReadableDb();
            Personnel personnel = daoSession.getPersonnelDao().queryBuilder()
                    .where(PersonnelDao.Properties.PersId.eq(persId)).unique();
            if( personnel != null ){
                result = ModelMapper.MapTo(personnel);
            }
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "Exception <> unable to get Personne lInfo : " + ex.getMessage());
            //throw  new ManagerException("<> unable to get Personnel Info : ",ex);
        }
        return result;
    }

    public int Count_AEE_ByPersId(long PersonnelId) {
        long result=0;
        try {
            openReadableDb();
            result = daoSession.getAgent_Evaluation_ExercicesDao().queryBuilder()
                    .where(Agent_Evaluation_ExercicesDao.Properties.PersonnelId.eq(PersonnelId)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to CountAEE_ByPersId : " + ex.getMessage());
        }
        return (int) result;
    }

    public double CountScoreQuestion_ByFExercices(long idFormExercice) {
        double result=0;
        try {
            openReadableDb();
            QueryBuilder<Question_FormulaireExercices> qb = daoSession.getQuestion_FormulaireExercicesDao().queryBuilder()
                    .where(Question_FormulaireExercicesDao.Properties.CodeFormulaireExercice.eq(idFormExercice));

            List<Question_FormulaireExercices> questionsList = qb.list();
            if(questionsList!=null){
                for (Question_FormulaireExercices qfe : questionsList) {
                    QuestionsModel qm = getQuestions_Byid(qfe.getCodeQuestion());
                    result += qm.getScoreTotal();
                }
            }else{
            }
            daoSession.clear();
        }catch(Exception ex){
            Tools.LogCat( "Exception <> unable to getListAllQuestions_ByidFormExercices: ", ex);
            //throw new ManagerException("unable to getListAllQuestions_ByidFormExercices",ex);
        }
        return result;
    }

    public QuestionsModel getQuestions_Byid(long codeQuestions) throws ManagerException {
        //Log.i(MANAGERS, "Inside of getQuestions_Byid! codeQuestions:" + codeQuestions);
        QuestionsModel result = null;
        try {
            openReadableDb();
            Questions questions = daoSession.getQuestionsDao().queryBuilder()
                    .where(QuestionsDao.Properties.CodeQuestion.eq(codeQuestions)).unique();
            if( questions != null ){
                result = ModelMapper.MapToQuestionsModel(questions);
            }
            daoSession.clear();
        }catch(Exception ex){
            //Log.e(MANAGERS, "Exception <> unable to get Personne lInfo : " + ex.getMessage());
            throw  new ManagerException("<> unable to getQuestions_Byid: ",ex);
        }
        return result;
    }

    private int CountQuestion_ByFExercices(long codeExercice) {
        long result=0;
        try {
            openReadableDb();
            result = daoSession.getQuestion_FormulaireExercicesDao().queryBuilder()
                    .where(Question_FormulaireExercicesDao.Properties.CodeFormulaireExercice.eq(codeExercice)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to Count Question FExercices : " + ex.getMessage());
        }
        return (int) result;
    }

    private int CountFormulaireExercices_ByType(String typeEvaluation) {
        long result=0;
        try {
            openReadableDb();
            result = daoSession.getFormulaireExercicesDao().queryBuilder()
                    .where(FormulaireExercicesDao.Properties.TypeEvaluation.eq(typeEvaluation)).count();
            daoSession.clear();
        }catch(Exception ex){
            Log.e(MANAGERS, "<> unable to count Formulaire Exercices Type : " + ex.getMessage());
        }
        return (int) result;
    }
 //endregion


//region [ MapToRows ]
    public KeyValueModel MapTo(KeyValueModel entity) {
        KeyValueModel m = new KeyValueModel(entity.getKey(), entity.getValue());
        return m;
    }

    public List<RowDataListModel> MapToRowsAEE(List<Agent_Evaluation_Exercices> obj_AEE) {
        List<RowDataListModel> result = new ArrayList<>();
        if (obj_AEE != null && obj_AEE.size() > 0) {
            for (Agent_Evaluation_Exercices objAEE : obj_AEE) {
                RowDataListModel r = new RowDataListModel();
                r.setId(objAEE.getCodeExercice());
                FormulaireExercicesModel frm = GetInfoFormulaireExercice_ById(objAEE.getCodeExercice());
                r.setTitle("" + frm.getLibelleExercice());
                String desc = "";

                desc = "<b>Note:</b> " + objAEE.getScoreFinalAtteint() + " / " + objAEE.getScoreTotalFormulaire();
                //desc += " | <b>Score:</b> " + ScoreFormulaire;
                //desc += "<b>Durée :</b> " + objAEE.getDureeEnSeconde() + " Sec";
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(false);
                r.setModel( ModelMapper.MapTo(objAEE));

                result.add(r);
            }
        } else {
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
                String desc = "";
                int NbrQuestion = CountQuestion_ByFExercices(fExercices.getCodeExercice());
                double ScoreFormulaire = CountScoreQuestion_ByFExercices(fExercices.getCodeExercice());

                desc = "<b>Nbr Question :</b> " + NbrQuestion;
                desc += " | <b>Score:</b> " + ScoreFormulaire;
                //desc += "<b>Durée :</b> " + fExercices.getDureeEnSeconde() + " Sec";
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(false);
                r.setModel(MapTo(fExercices, NbrQuestion, ScoreFormulaire));

                result.add(r);
            }
        } else {
        }
        return result;
    }

    public List<RowDataListModel> MapToRows_Pers(List<PersonnelModel> aee) {
        List<RowDataListModel> result = new ArrayList<>();
        if (aee != null && aee.size() > 0) {
            for (PersonnelModel persModel : aee) {
                RowDataListModel r = new RowDataListModel();
                r.setId(persModel.getPersId());
                r.setTitle("" + persModel.getPrenom() + " " + persModel.getNom());
                String desc = "";
                //int NbrQuestion = CountQuestion_ByFExercices(itemAEE.getCodeExercice());
                //double ScoreFormulaire = CountScoreQuestion_ByFExercices(itemAEE.getCodeExercice());
                //desc = "<b>Nbr Question :</b> " + NbrQuestion;
                //desc += " | <b>Score:</b> " + ScoreFormulaire;
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(true);
                r.setModel(persModel);

                result.add(r);
            }
        } else {
        }
        return result;
    }

    public List<RowDataListModel> MapToRowsKeyValue(List<KeyValueModel> keyValueModels) {
        List<RowDataListModel> result = new ArrayList<>();
        if (keyValueModels != null && keyValueModels.size() > 0) {
            for (KeyValueModel valueModel : keyValueModels) {
                RowDataListModel r = new RowDataListModel();
                r.setId(Long.parseLong(valueModel.getKey()));
                r.setTitle("" + valueModel.getValue());
                String desc = "Nbr Exercice: " + CountFormulaireExercices_ByType(valueModel.getKey());
                r.setDesc(desc);

                r.setIsComplete(true);
                r.setIsModuleMenu(false);
                //r.setModel(MapTo(valueModel));
                r.setModel(MapTo(valueModel));

                result.add(r);
            }
        } else {
        }
        return result;
    }

    public FormulaireExercicesModel MapTo(FormulaireExercices entity, int NbrQuestion, double ScoreFormulaire) {
        FormulaireExercicesModel m = new FormulaireExercicesModel();
        m.setCodeExercice(entity.getCodeExercice()) ;
        m.setLibelleExercice(entity.getLibelleExercice());
        m.setDescriptions(entity.getDescriptions());
        m.setInstructions(entity.getInstructions());
        m.setRappelExercice(entity.getRappelExercice());
        m.setTypeEvaluation(entity.getTypeEvaluation());
        m.setStatut(entity.getStatut());

        m.setNbrQuestion( NbrQuestion );
        m.setScoreFormulaire( ScoreFormulaire );

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
//endregion
