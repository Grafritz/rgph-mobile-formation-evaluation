package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "Tbl_Mob_ReponseEntree".
 */
public class ReponseEntree {

    private Long codeReponseEntree;
    private Long personnelId;
    private Long codeFormulaireExercice;
    private Long codeQuestion;
    private Long codeReponse;
    private Long CodeJustificationReponse;
    private String reponseSaisie;
    private Boolean IsSynchroToAppFormation;
    private Boolean IsSynchroToCentrale;
    private String createdBy;
    private String dateCreated;
    private String modifBy;
    private String dateModif;

    public ReponseEntree() {
    }

    public ReponseEntree(Long codeReponseEntree) {
        this.codeReponseEntree = codeReponseEntree;
    }

    public ReponseEntree(Long codeReponseEntree, Long personnelId, Long codeFormulaireExercice, Long codeQuestion, Long codeReponse, Long CodeJustificationReponse, String reponseSaisie, Boolean IsSynchroToAppFormation, Boolean IsSynchroToCentrale, String createdBy, String dateCreated, String modifBy, String dateModif) {
        this.codeReponseEntree = codeReponseEntree;
        this.personnelId = personnelId;
        this.codeFormulaireExercice = codeFormulaireExercice;
        this.codeQuestion = codeQuestion;
        this.codeReponse = codeReponse;
        this.CodeJustificationReponse = CodeJustificationReponse;
        this.reponseSaisie = reponseSaisie;
        this.IsSynchroToAppFormation = IsSynchroToAppFormation;
        this.IsSynchroToCentrale = IsSynchroToCentrale;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.modifBy = modifBy;
        this.dateModif = dateModif;
    }

    public Long getCodeReponseEntree() {
        return codeReponseEntree;
    }

    public void setCodeReponseEntree(Long codeReponseEntree) {
        this.codeReponseEntree = codeReponseEntree;
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

    public Long getCodeQuestion() {
        return codeQuestion;
    }

    public void setCodeQuestion(Long codeQuestion) {
        this.codeQuestion = codeQuestion;
    }

    public Long getCodeReponse() {
        return codeReponse;
    }

    public void setCodeReponse(Long codeReponse) {
        this.codeReponse = codeReponse;
    }

    public Long getCodeJustificationReponse() {
        return CodeJustificationReponse;
    }

    public void setCodeJustificationReponse(Long CodeJustificationReponse) {
        this.CodeJustificationReponse = CodeJustificationReponse;
    }

    public String getReponseSaisie() {
        return reponseSaisie;
    }

    public void setReponseSaisie(String reponseSaisie) {
        this.reponseSaisie = reponseSaisie;
    }

    public Boolean getIsSynchroToAppFormation() {
        return IsSynchroToAppFormation;
    }

    public void setIsSynchroToAppFormation(Boolean IsSynchroToAppFormation) {
        this.IsSynchroToAppFormation = IsSynchroToAppFormation;
    }

    public Boolean getIsSynchroToCentrale() {
        return IsSynchroToCentrale;
    }

    public void setIsSynchroToCentrale(Boolean IsSynchroToCentrale) {
        this.IsSynchroToCentrale = IsSynchroToCentrale;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getModifBy() {
        return modifBy;
    }

    public void setModifBy(String modifBy) {
        this.modifBy = modifBy;
    }

    public String getDateModif() {
        return dateModif;
    }

    public void setDateModif(String dateModif) {
        this.dateModif = dateModif;
    }

}
