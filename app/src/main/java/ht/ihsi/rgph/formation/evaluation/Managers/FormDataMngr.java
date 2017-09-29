package ht.ihsi.rgph.formation.evaluation.Managers;

import java.util.List;

import ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities.Question_FormulaireExercices;
import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.JustificationReponsesModel;
import ht.ihsi.rgph.formation.evaluation.Models.PersonnelModel;
import ht.ihsi.rgph.formation.evaluation.Models.Question_FormulaireExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.QuestionsModel;
import ht.ihsi.rgph.formation.evaluation.Models.ReponsesModel;

/**
 * FormDataMngr - this interface provides
 *
 * @author Jordany Arnaud
 * @version 1.0
 * @copyright (C) E-rgph 2015
 * @date 22/01/2016
 */
public  interface FormDataMngr{

     void closeDbConnections();

    /**
     * Get the first question on a module
     *
     * @param moduleId the id of the module
     * @return QuestionsModel
     * @throws ManagerException
     */
     QuestionsModel getFirstQuestionOfModule(String moduleId) throws ManagerException;

    /**
     * Get the next question
     *
     * @param id the id of question
     * @return QuestionsModel
     * @throws ManagerException
     */
     QuestionsModel getNextQuestionByCode(String id) throws ManagerException;

    /**
     *
     * @param NomUtilisateur
     * @param MotDePasse
     * @return PersonnelModel
     * @throws ManagerException
     */
    PersonnelModel getPersonnelInfo(String NomUtilisateur, String MotDePasse) throws ManagerException;

    //List<Question_FormulaireExercicesModel> getListAllQuestion_FormExercices(long idFormExercice) throws ManagerException;

    QuestionsModel getQuestions_Byid(long idQuestion) throws ManagerException;

    //List<Question_FormulaireExercices> getListAllQuestion_FormulaireExercices_ByidFormExercices(long idFormExercice) throws ManagerException;

    List<QuestionsModel> getListAllQuestions_ByidFormExercices(long idFormExercice) throws ManagerException;

    List<ReponsesModel> getListAllReponsesByQuestion(long codeQuestion) throws ManagerException;

    List<JustificationReponsesModel> getListAllJustificationReponsesByQuestion(long codeQuestion) throws ManagerException;
}
