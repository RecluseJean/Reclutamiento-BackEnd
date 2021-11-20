/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExperienciaLaboralHeadhuntingResponse {

    //Atributos
    Long idExperienciaLaboral;

    private String puestoExperienciaLaboral;

    private String empresaExperienciaLaboral;

    @JsonIgnore
    private int mesinicioExperienciaLaboral;

    @JsonIgnore
    private int anioinicioExperienciaLaboral;

    private String periodoinicioExperienciaLaboral;

    @JsonIgnore
    private String mesfinExperienciaLaboral;

    @JsonIgnore
    private String aniofinExperienciaLaboral;

    private String periodofinExperienciaLaboral;

    private String descripcionExperienciaLaboral;

    //Constructores
    public ExperienciaLaboralHeadhuntingResponse() {
    }

    public ExperienciaLaboralHeadhuntingResponse(Long idExperienciaLaboral, String puestoExperienciaLaboral,
                                                 String empresaExperienciaLaboral, int mesinicioExperienciaLaboral,
                                                 int anioinicioExperienciaLaboral, String periodoinicioExperienciaLaboral,
                                                 String mesfinExperienciaLaboral, String aniofinExperienciaLaboral,
                                                 String periodofinExperienciaLaboral, String descripcionExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.puestoExperienciaLaboral = puestoExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
        this.periodofinExperienciaLaboral = periodofinExperienciaLaboral;
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }

    //Getters y Setters
    public Long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public String getPuestoExperienciaLaboral() {
        return puestoExperienciaLaboral;
    }

    public void setPuestoExperienciaLaboral(String puestoExperienciaLaboral) {
        this.puestoExperienciaLaboral = puestoExperienciaLaboral;
    }

    public String getEmpresaExperienciaLaboral() {
        return empresaExperienciaLaboral;
    }

    public void setEmpresaExperienciaLaboral(String empresaExperienciaLaboral) {
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
    }

    public int getMesinicioExperienciaLaboral() {
        return mesinicioExperienciaLaboral;
    }

    public void setMesinicioExperienciaLaboral(int mesinicioExperienciaLaboral) {
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
    }

    public int getAnioinicioExperienciaLaboral() {
        return anioinicioExperienciaLaboral;
    }

    public void setAnioinicioExperienciaLaboral(int anioinicioExperienciaLaboral) {
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
    }

    public String getPeriodoinicioExperienciaLaboral() {
        return periodoinicioExperienciaLaboral;
    }

    public void setPeriodoinicioExperienciaLaboral(String periodoinicioExperienciaLaboral) {
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
    }

    public String getMesfinExperienciaLaboral() {
        return mesfinExperienciaLaboral;
    }

    public void setMesfinExperienciaLaboral(String mesfinExperienciaLaboral) {
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
    }

    public String getAniofinExperienciaLaboral() {
        return aniofinExperienciaLaboral;
    }

    public void setAniofinExperienciaLaboral(String aniofinExperienciaLaboral) {
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
    }

    public String getPeriodofinExperienciaLaboral() {
        return periodofinExperienciaLaboral;
    }

    public void setPeriodofinExperienciaLaboral(String periodofinExperienciaLaboral) {
        this.periodofinExperienciaLaboral = periodofinExperienciaLaboral;
    }

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }
}
