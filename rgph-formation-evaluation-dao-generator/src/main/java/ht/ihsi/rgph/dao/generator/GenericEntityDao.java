package ht.ihsi.rgph.dao.generator;

import de.greenrobot.daogenerator.Entity;

/**
 * Created by JFDuverseau on 8/12/2017.
 */

public class GenericEntityDao {

    public static void createPersonnelEntity(Entity entity){
        entity.addLongProperty("persId").columnName("persId").primaryKey();
        entity.addStringProperty("sdeId").columnName("sdeId");
        entity.addStringProperty("nom").columnName("nom");
        entity.addStringProperty("prenom").columnName("prenom");
        entity.addStringProperty("sexe").columnName("sexe");
        entity.addStringProperty("nomUtilisateur").columnName("nomUtilisateur");
        entity.addStringProperty("motDePasse").columnName("motDePasse");
        entity.addStringProperty("email").columnName("email");
        entity.addStringProperty("deptId").columnName("deptId");
        entity.addStringProperty("comId").columnName("comId");
        entity.addStringProperty("vqseId").columnName("vqseId");
        entity.addStringProperty("zone").columnName("zone");
        entity.addStringProperty("codeDistrict").columnName("codeDistrict");
        entity.addBooleanProperty("estActif").columnName("estActif");
        entity.addIntProperty("ProfileId").columnName("ProfileId");
        entity.addStringProperty("dateDebutCollecte").columnName("dateDebutCollecte");
        entity.addStringProperty("dateFinCollecte").columnName("dateFinCollecte");
    }


    //region [ Planification Formation ]
    public static void createFormationEntity(Entity entity){
        entity.addLongProperty("formationId").columnName("formationId").primaryKey();
        entity.addStringProperty("titreFormation").columnName("titreFormation");
        entity.addShortProperty("niveauFormation").columnName("niveauFormation");
        entity.addIntProperty("duree").columnName("duree");
        entity.addStringProperty("dateDebut").columnName("dateDebut");
        entity.addStringProperty("dateFin").columnName("dateFin");
    }

    public static void createCentreFormationEntity(Entity entity){
        entity.addLongProperty("centreFormationId").columnName("centreFormationId").primaryKey();
        entity.addStringProperty("nomCentre").columnName("nomCentre");
        entity.addStringProperty("deptId").columnName("deptId");
        entity.addStringProperty("comId").columnName("comId");
        entity.addStringProperty("vqseId").columnName("vqseId");
        entity.addStringProperty("adresse").columnName("adresse");
        entity.addStringProperty("responsable").columnName("responsable");
    }

    public static void createSalleFormationEntity(Entity entity){
        entity.addLongProperty("salleFormationId").columnName("salleFormationId").primaryKey();
        entity.addLongProperty("centreFormationId").columnName("centreFormationId");
        entity.addStringProperty("nomSalle").columnName("nomSalle");
        entity.addIntProperty("capaciteSalle").columnName("capaciteSalle");
    }

    public static void createFormation_CentreFormationEntity(Entity entity){
        entity.addLongProperty("formationCentreFormationId").columnName("formationCentreFormationId").primaryKey();
        entity.addLongProperty("formationId").columnName("formationId");
        entity.addLongProperty("centreFormationId").columnName("centreFormationId");
        entity.addShortProperty("statut").columnName("statut");
    }

    public static void createFormateurParticipant_Salle_FormationEntity(Entity entity){
        entity.addLongProperty("formateurSalleFormationId").columnName("formateurSalleFormationId").primaryKey();
        entity.addLongProperty("centreFormationId").columnName("centreFormationId");
        entity.addLongProperty("salleFormationId").columnName("salleFormationId");
        entity.addLongProperty("personnelId").columnName("personnelId");
        entity.addIntProperty("typePersonne").columnName("typePersonne");
    }

    public static void createSeanceFormationEntity(Entity entity){
        entity.addLongProperty("seanceFormationId").columnName("seanceFormationId").primaryKey();
        entity.addLongProperty("formationId").columnName("formationId");
        entity.addStringProperty("nomSeance").columnName("nomSeance");
        entity.addStringProperty("dateSeance").columnName("dateSeance");
        entity.addIntProperty("jour").columnName("jour");
        entity.addStringProperty("heureDebut").columnName("heureDebut");
        entity.addStringProperty("heureDeFin").columnName("heureDeFin");
        entity.addShortProperty("domaine").columnName("domaine");
        entity.addShortProperty("typeSeance").columnName("typeSeance");
    }
    //endregion

    //region [ Q-Evaluation ]
    public static void createFormulaireExercicesEntity(Entity entity){
        entity.addLongProperty("codeExercice").columnName("codeExercice").primaryKey();
        entity.addStringProperty("libelleExercice").columnName("libelleExercice");
        entity.addStringProperty("descriptions").columnName("descriptions");
        entity.addStringProperty("instructions").columnName("instructions");
        entity.addStringProperty("rappelExercice").columnName("rappelExercice");
        entity.addStringProperty("typeEvaluation").columnName("typeEvaluation");
        entity.addStringProperty("niveauFormation").columnName("niveauFormation");
        entity.addStringProperty("statut").columnName("statut");
        entity.addStringProperty("dureeEnSeconde").columnName("dureeEnSeconde");
        //entity.addStringProperty("createdBy").columnName("createdBy");
        //entity.addStringProperty("dateCreated").columnName("dateCreated");
    }

    public static void createQuestion_FormulaireExercicesEntity(Entity entity){
        entity.addLongProperty("ID").columnName("ID").primaryKey();
        entity.addLongProperty("codeFormulaireExercice").columnName("codeFormulaireExercice");
        entity.addLongProperty("codeQuestion").columnName("codeQuestion");
        entity.addStringProperty("ordreQuestion").columnName("ordreQuestion");
        entity.addBooleanProperty("estDebutQuestion").columnName("estDebutQuestion");
        //entity.addStringProperty("createdBy").columnName("createdBy");
        //entity.addStringProperty("dateCreated").columnName("dateCreated");
    }

    public static void createQuestionsEntity(Entity entity){
        entity.addLongProperty("codeQuestion").columnName("codeQuestion").primaryKey();
        entity.addStringProperty("libelle").columnName("libelle");
        entity.addStringProperty("detailsQuestion").columnName("detailsQuestion");
        entity.addStringProperty("indicationsQuestion").columnName("indicationsQuestion");
        entity.addBooleanProperty("avoirJustificationYN").columnName("avoirJustificationYN");
        entity.addIntProperty("typeQuestion").columnName("typeQuestion");
        entity.addDoubleProperty("scoreTotal").columnName("scoreTotal");
        entity.addIntProperty("caratereAccepte").columnName("caratereAccepte");
        entity.addIntProperty("nbreValeurMinimal").columnName("nbreValeurMinimal");
        entity.addIntProperty("nbreCaratereMaximal").columnName("nbreCaratereMaximal");
        entity.addStringProperty("qPrecedent").columnName("qPrecedent");
        entity.addStringProperty("qSuivant").columnName("qSuivant");
        //entity.addStringProperty("createdBy").columnName("createdBy");
        //entity.addStringProperty("dateCreated").columnName("dateCreated");
    }

    public static void createReponsesEntity(Entity entity){
        entity.addLongProperty("codeReponse").columnName("codeReponse").primaryKey();
        entity.addLongProperty("codeReponseManuel").columnName("codeReponseManuel");
        entity.addLongProperty("codeQuestion").columnName("codeQuestion");
        entity.addStringProperty("libelleReponse").columnName("libelleReponse");
        entity.addBooleanProperty("isCorrect").columnName("isCorrect");
        entity.addDoubleProperty("scoreTotal").columnName("scoreTotal");
        entity.addBooleanProperty("estEnfant").columnName("estEnfant");
        entity.addBooleanProperty("avoirEnfant").columnName("avoirEnfant");
        entity.addStringProperty("codeParent").columnName("codeParent");
        //entity.addStringProperty("createdBy").columnName("createdBy");
        //entity.addStringProperty("dateCreated").columnName("dateCreated");
    }

    public static void createJustificationReponsesEntity(Entity entity){
        entity.addLongProperty("codeJustification").columnName("codeJustification").primaryKey();
        entity.addLongProperty("codeQuestion").columnName("codeQuestion");
        entity.addStringProperty("libelle").columnName("libelle");
        entity.addBooleanProperty("isCorrect").columnName("isCorrect");
        entity.addStringProperty("createdBy").columnName("createdBy");
        entity.addStringProperty("dateCreated").columnName("dateCreated");
        //entity.addStringProperty("modifBy").columnName("modifBy");
        //entity.addStringProperty("dateModif").columnName("dateModif");
    }

    public static void createReponseEntreeEntity(Entity entity){
        entity.addLongProperty("codeReponseEntree").columnName("codeReponseEntree").primaryKey();
        entity.addLongProperty("personnelId").columnName("personnelId");
        entity.addLongProperty("codeFormulaireExercice").columnName("codeFormulaireExercice");
        entity.addLongProperty("codeQuestion").columnName("codeQuestion");
        entity.addLongProperty("codeReponse").columnName("codeReponse");
        entity.addLongProperty("CodeJustificationReponse").columnName("CodeJustificationReponse");
        entity.addStringProperty("reponseSaisie").columnName("reponseSaisie");
        entity.addBooleanProperty("IsSynchroToAppFormation").columnName("IsSynchroToAppFormation");
        entity.addBooleanProperty("IsSynchroToCentrale").columnName("IsSynchroToCentrale");
        entity.addStringProperty("createdBy").columnName("createdBy");
        entity.addStringProperty("dateCreated").columnName("dateCreated");
        entity.addStringProperty("modifBy").columnName("modifBy");
        entity.addStringProperty("dateModif").columnName("dateModif");
    }

    public static void createAgentEvaluationExercicesEntity(Entity entity){
        entity.addLongProperty("codeAgentEvaluationExercices").columnName("codeAgentEvaluationExercices").primaryKey().autoincrement();
        entity.addLongProperty("codeExercice").columnName("codeExercice");
        entity.addLongProperty("personnelId").columnName("personnelId");
        entity.addLongProperty("codeFormulaireExercice").columnName("codeFormulaireExercice");
        entity.addStringProperty("scoreTotalFormulaire").columnName("scoreTotalFormulaire");
        entity.addStringProperty("scoreFinalAtteint").columnName("scoreFinalAtteint");
        entity.addStringProperty("dureeEvaluationEnSeconde").columnName("dureeEvaluationEnSeconde");
        entity.addStringProperty("dureeDuRepondantEnSeconde").columnName("dureeDuRepondantEnSeconde");
        entity.addStringProperty("dateDebutEvaluationDuRepondant").columnName("dateDebutEvaluationDuRepondant");
        entity.addStringProperty("dateFinEvaluationDuRepondant").columnName("dateFinEvaluationDuRepondant");
        entity.addBooleanProperty("IsSynchroToAppFormation").columnName("IsSynchroToAppFormation");
        entity.addBooleanProperty("IsSynchroToCentrale").columnName("IsSynchroToCentrale");
    }
    //endregion

    //region [ Localisation ]
    public static void createDepartementEntity(Entity entity){
        entity.addStringProperty("DeptId").columnName("DeptId").unique().notNull();
        entity.addStringProperty("DeptNom").columnName("DeptNom");
    }

    public static void createCommuneEntity(Entity entity){
        entity.addStringProperty("ComId").columnName("ComId").unique().notNull();
        entity.addStringProperty("ComNom").columnName("ComNom");
        entity.addStringProperty("DeptId").columnName("DeptId").notNull();
    }

    public static void createVqseEntity(Entity entity){
        entity.addStringProperty("VqseId").columnName("VqseId").unique().notNull();
        entity.addStringProperty("VqseNom").columnName("VqseNom");
        entity.addStringProperty("ComId").columnName("ComId").notNull();
    }
    //endregion

    public static void createMaterielEntity(Entity entity){
        entity.addLongProperty("MaterielId").columnName("MaterielId").primaryKey().autoincrement();
        entity.addStringProperty("Imei").columnName("Imei");
        entity.addStringProperty("Serial").columnName("Serial");
        entity.addStringProperty("Model").columnName("Model");
        entity.addStringProperty("Version").columnName("Version");
        entity.addIntProperty("AgentId").columnName("AgentId");
        entity.addStringProperty("DateAssignation").columnName("DateAssignation");
        entity.addIntProperty("IsConfigured").columnName("IsConfigured");
        entity.addStringProperty("Synchronisation").columnName("Synchronisation");
    }

    public static void createMaterielExerciceEntity(Entity entity){
        entity.addLongProperty("MaterielExerciceId").columnName("MaterielExerciceId").primaryKey().autoincrement();
        entity.addLongProperty("CodeFormulaireExercice").columnName("CodeFormulaireExercice");
        entity.addLongProperty("PersonnelId").columnName("PersonnelId");
        entity.addStringProperty("Imei").columnName("Imei");
        entity.addStringProperty("Serial").columnName("Serial");
        entity.addStringProperty("Model").columnName("Model");
        entity.addStringProperty("Version").columnName("Version");
        entity.addStringProperty("DateTransfert").columnName("DateTransfert");
    }
}
