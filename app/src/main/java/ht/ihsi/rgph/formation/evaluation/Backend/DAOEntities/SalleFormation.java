package ht.ihsi.rgph.formation.evaluation.Backend.DAOEntities;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "Tbl_Mob_SalleFormation".
 */
public class SalleFormation {

    private Long salleFormationId;
    private Long centreFormationId;
    private String nomSalle;
    private Integer capaciteSalle;

    public SalleFormation() {
    }

    public SalleFormation(Long salleFormationId) {
        this.salleFormationId = salleFormationId;
    }

    public SalleFormation(Long salleFormationId, Long centreFormationId, String nomSalle, Integer capaciteSalle) {
        this.salleFormationId = salleFormationId;
        this.centreFormationId = centreFormationId;
        this.nomSalle = nomSalle;
        this.capaciteSalle = capaciteSalle;
    }

    public Long getSalleFormationId() {
        return salleFormationId;
    }

    public void setSalleFormationId(Long salleFormationId) {
        this.salleFormationId = salleFormationId;
    }

    public Long getCentreFormationId() {
        return centreFormationId;
    }

    public void setCentreFormationId(Long centreFormationId) {
        this.centreFormationId = centreFormationId;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public Integer getCapaciteSalle() {
        return capaciteSalle;
    }

    public void setCapaciteSalle(Integer capaciteSalle) {
        this.capaciteSalle = capaciteSalle;
    }

}