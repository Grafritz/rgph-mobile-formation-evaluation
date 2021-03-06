package ht.ihsi.rgph.formation.evaluation.Managers;


import ht.ihsi.rgph.formation.evaluation.Exceptions.ManagerException;
import ht.ihsi.rgph.formation.evaluation.Exceptions.TextEmptyException;
import ht.ihsi.rgph.formation.evaluation.Models.Agent_Evaluation_ExercicesModel;
import ht.ihsi.rgph.formation.evaluation.Models.PersonnelModel;
import ht.ihsi.rgph.formation.evaluation.Models.ReponseEntreeModel;

/**
 * Created by jadme on 3/22/2016.
 */
public interface CURecordMngr {


    PersonnelModel savePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException;

    PersonnelModel SavePersonnel(long id, PersonnelModel personnelModel, String userCode) throws ManagerException, TextEmptyException;
    /**
     * Save a new entity
     *
     * @param entite
     * @param <T>    the type of the entity
     * @return
     */
    <T> T saveEntity(T entite) throws ManagerException;

    PersonnelModel updatePersonnel(PersonnelModel personnelModel, String userCode) throws ManagerException;

    PersonnelModel updateAllPersonnel(long persId, String userCode) throws ManagerException;
    /**
     * Update an entity
     *
     * @param entite
     * @param <T>    the entity type.
     * @return T entity.
     */
    <T> T updateEntity(T entite) throws ManagerException;

    void closeDbConnections();

    ReponseEntreeModel InsertReponseEntree(ReponseEntreeModel reponseEntreeModel) throws ManagerException, TextEmptyException;

    Agent_Evaluation_ExercicesModel SaveAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel, long codeAgentEvaluationExercices) throws ManagerException;
    Agent_Evaluation_ExercicesModel InsertAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel) throws ManagerException;
    Agent_Evaluation_ExercicesModel UpdateAgent_Evaluation_Exercices(Agent_Evaluation_ExercicesModel agent_evaluation_exercicesModel) throws ManagerException;

}
