package ht.ihsi.rgph.formation.evaluation.Managers;

import java.util.List;

import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.RowDataListModel;
import ht.ihsi.rgph.formation.evaluation.Utilities.Shared_Preferences;


/**
 * Created by jadme on 3/21/2016.
 */
 public interface QueryRecordMngr {

    void closeDbConnections();

    int countAllDepartement();


    List<RowDataListModel> searchListProfilUser(Shared_Preferences SPref) throws ManagerException;

    List<RowDataListModel> searchList_FormulaireExercice() throws ManagerException;
    List<RowDataListModel> searchList_FormulaireExercice_ByType(long typeExercice) throws ManagerException;
   List<RowDataListModel> searchList_TypeExercice() throws ManagerException;

    Agent_Evaluation_ExercicesModel getAgent_Evaluation_Exercices_ByIdAgent(long idFormExercice, long idPersonnel) throws ManagerException;

}
