/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class ReferenciaLaboralPostulanteResponse {

    //Atributos
    private String empresaReferente;

    private String nombreReferente;

    private String emailReferente;

    private String telefonoReferente;

    private String periodoinicioExperienciaLaboral;

    private ImagenResponse logoEmpresa;

    //Constructores
    public ReferenciaLaboralPostulanteResponse() {
    }

    public ReferenciaLaboralPostulanteResponse(String empresaReferente, String nombreReferente, String emailReferente,
                                               String telefonoReferente, String periodoinicioExperienciaLaboral,
                                               ImagenResponse logoEmpresa) {
        this.empresaReferente = empresaReferente;
        this.nombreReferente = nombreReferente;
        this.emailReferente = emailReferente;
        this.telefonoReferente = telefonoReferente;
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
        this.logoEmpresa = logoEmpresa;
    }

    //Getters y Setters
    public String getEmpresaReferente() {
        return empresaReferente;
    }

    public void setEmpresaReferente(String empresaReferente) {
        this.empresaReferente = empresaReferente;
    }

    public String getNombreReferente() {
        return nombreReferente;
    }

    public void setNombreReferente(String nombreReferente) {
        this.nombreReferente = nombreReferente;
    }

    public String getEmailReferente() {
        return emailReferente;
    }

    public void setEmailReferente(String emailReferente) {
        this.emailReferente = emailReferente;
    }

    public String getTelefonoReferente() {
        return telefonoReferente;
    }

    public void setTelefonoReferente(String telefonoReferente) {
        this.telefonoReferente = telefonoReferente;
    }

    public String getPeriodoinicioExperienciaLaboral() {
        return periodoinicioExperienciaLaboral;
    }

    public void setPeriodoinicioExperienciaLaboral(String periodoinicioExperienciaLaboral) {
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }
}
