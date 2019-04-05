package ht.ihsi.rgph.formation.evaluation.Models;

/**
 * Created by JFDuverseau on 9/23/2017.
 */

public class Agent_Evaluation_ExercicesModel extends BaseModel {

    private Long codeAgentEvaluationExercices;
    private Long codeExercice;
    private Long personnelId;
    private Long codeFormulaireExercice;
    private String scoreTotalFormulaire;
    private String scoreFinalAtteint;
    private String dureeEvaluationEnSeconde;
    private String dureeDuRepondantEnSeconde;
    private String dateDebutEvaluationDuRepondant;
    private String dateFinEvaluationDuRepondant;

    public Agent_Evaluation_ExercicesModel() {
    }

    public Agent_Evaluation_ExercicesModel(Long codeAgentEvaluationExercices) {
        this.codeAgentEvaluationExercices = codeAgentEvaluationExercices;
    }

    public Agent_Evaluation_ExercicesModel(Long codeAgentEvaluationExercices, Long codeExercice, Long personnelId, Long codeFormulaireExercice, String scoreTotalFormulaire, String scoreFinalAtteint, String dureeEvaluationEnSeconde, String dureeDuRepondantEnSeconde, String dateDebutEvaluationDuRepondant, String dateFinEvaluationDuRepondant) {
        this.codeAgentEvaluationExercices = codeAgentEvaluationExercices;
        this.codeExercice = codeExercice;
        this.personnelId = personnelId;
        this.codeFormulaireExercice = codeFormulaireExercice;
        this.scoreTotalFormulaire = scoreTotalFormulaire;
        this.scoreFinalAtteint = scoreFinalAtteint;
        this.dureeEvaluationEnSeconde = dureeEvaluationEnSeconde;
        this.dureeDuRepondantEnSeconde = dureeDuRepondantEnSeconde;
        this.dateDebutEvaluationDuRepondant = dateDebutEvaluationDuRepondant;
        this.dateFinEvaluationDuRepondant = dateFinEvaluationDuRepondant;
    }

    public Long getCodeAgentEvaluationExercices() {
        return codeAgentEvaluationExercices;
    }

    public void setCodeAgentEvaluationExercices(Long codeAgentEvaluationExercices) {
        this.codeAgentEvaluationExercices = codeAgentEvaluationExercices;
    }

    public Long getCodeExercice() {
        return codeExercice;
    }

    public void setCodeExercice(Long codeExercice) {
        this.codeExercice = codeExercice;
    }

    public Long getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Long personnelId) {
        this.personnelId = personnelId;
    }

    public Long getCodeFormulaireExercice() {
        return codeFormulaireExercice;
    }

    public void setCodeFormulaireExercice(Long codeFormulaireExercice) {
        this.codeFormulaireExercice = codeFormulaireExercice;
    }

    public String getScoreTotalFormulaire() {
        return scoreTotalFormulaire;
    }

    public void setScoreTotalFormulaire(String scoreTotalFormulaire) {
        this.scoreTotalFormulaire = scoreTotalFormulaire;
    }

    public String getScoreFinalAtteint() {
        return scoreFinalAtteint;
    }

    public void setScoreFinalAtteint(String scoreFinalAtteint) {
        this.scoreFinalAtteint = scoreFinalAtteint;
    }

    public String getDureeEvaluationEnSeconde() {
        return dureeEvaluationEnSeconde;
    }

    public void setDureeEvaluationEnSeconde(String dureeEvaluationEnSeconde) {
        this.dureeEvaluationEnSeconde = dureeEvaluationEnSeconde;
    }

    public String getDureeDuRepondantEnSeconde() {
        return dureeDuRepondantEnSeconde;
    }

    public void setDureeDuRepondantEnSeconde(String dureeDuRepondantEnSeconde) {
        this.dureeDuRepondantEnSeconde = dureeDuRepondantEnSeconde;
    }

    public String getDateDebutEvaluationDuRepondant() {
        return dateDebutEvaluationDuRepondant;
    }

    public void setDateDebutEvaluationDuRepondant(String dateDebutEvaluationDuRepondant) {
        this.dateDebutEvaluationDuRepondant = dateDebutEvaluationDuRepondant;
    }

    public String getDateFinEvaluationDuRepondant() {
        return dateFinEvaluationDuRepondant;
    }

    public void setDateFinEvaluationDuRepondant(String dateFinEvaluationDuRepondant) {
        this.dateFinEvaluationDuRepondant = dateFinEvaluationDuRepondant;
    }

}
