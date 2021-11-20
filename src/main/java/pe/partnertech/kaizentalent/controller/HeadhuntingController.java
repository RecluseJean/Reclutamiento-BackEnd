/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_Format;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.headhunting.ExperienciaLaboralHeadhuntingResponse;
import pe.partnertech.kaizentalent.dto.response.headhunting.ListHeadHuntingResponse;
import pe.partnertech.kaizentalent.dto.response.headhunting.SkillFilterHeadhuntingResponse;
import pe.partnertech.kaizentalent.model.*;
import pe.partnertech.kaizentalent.service.IExperienciaLaboralService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeadhuntingController {

    final
    IUsuarioService usuarioService;

    final
    IExperienciaLaboralService experienciaLaboralService;

    public HeadhuntingController(IUsuarioService usuarioService, IExperienciaLaboralService experienciaLaboralService) {
        this.usuarioService = usuarioService;
        this.experienciaLaboralService = experienciaLaboralService;
    }

    @GetMapping("/headhunting/display")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> Headhunting() {

        Set<ListHeadHuntingResponse> list_headhunting = new HashSet<>();

        usuarioService.MostrarPostulantes().forEach(
                postulantes -> list_headhunting.add(
                        new ListHeadHuntingResponse(
                                postulantes.getIdUsuario(),
                                new ImagenResponse(
                                        postulantes.getImagenUsuario().getNombreImagen(),
                                        postulantes.getImagenUsuario().getUrlImagen()
                                ),
                                SendSueldo(postulantes.getSueldoUsuario()),
                                postulantes.getNombreUsuario() + " " + postulantes.getApellidoUsuario(),
                                postulantes.getExperienciaslaboralesUsuario(),
                                SendExperienciaLaboral(postulantes.getExperienciaslaboralesUsuario()),
                                postulantes.getTituloUsuario(),
                                postulantes.getTelefonoUsuario(),
                                postulantes.getCiudadUsuario(),
                                postulantes.getEducacionesUsuario(),
                                SendInstituciones(postulantes.getEducacionesUsuario()),
                                postulantes.getConocimientosUsuario(),
                                SendConocimientos(postulantes.getConocimientosUsuario()),
                                postulantes.getHabilidadesUsuario(),
                                SendHabilidades(postulantes.getHabilidadesUsuario()),
                                postulantes.getIdiomasUsuario(),
                                SendIdiomas(postulantes.getIdiomasUsuario()),
                                postulantes.getFechanacimientoUsuario(),
                                SendEdad(postulantes.getFechanacimientoUsuario())
                        ))
        );

        return new ResponseEntity<>(list_headhunting, HttpStatus.OK);
    }

    Double SendSueldo(String sueldo_postulante) {

        if (sueldo_postulante == null) {
            return 0.00;
        } else if (sueldo_postulante.equals("")) {
            return 0.00;
        } else {
            return Double.parseDouble(sueldo_postulante);
        }
    }

    ExperienciaLaboralHeadhuntingResponse SendExperienciaLaboral(Set<ExperienciaLaboral> list_experienciaslaborales) {

        if (list_experienciaslaborales.size() == 0) {
            return null;
        } else {
            Set<ExperienciaLaboralHeadhuntingResponse> experienciaslaborales = new HashSet<>();

            list_experienciaslaborales.forEach(
                    experienciaLaboral -> {
                        if (experienciaLaboral.getMesfinExperienciaLaboral().equals("") &&
                                experienciaLaboral.getAniofinExperienciaLaboral().equals("")) {
                            experienciaslaborales.add(new ExperienciaLaboralHeadhuntingResponse(
                                    experienciaLaboral.getIdExperienciaLaboral(),
                                    experienciaLaboral.getNombreExperienciaLaboral(),
                                    experienciaLaboral.getEmpresaExperienciaLaboral(),
                                    Integer.parseInt(experienciaLaboral.getMesinicioExperienciaLaboral()),
                                    Integer.parseInt(experienciaLaboral.getAnioinicioExperienciaLaboral()),
                                    Code_Format.ConvierteMes(experienciaLaboral.getMesinicioExperienciaLaboral()) + " " +
                                            experienciaLaboral.getAnioinicioExperienciaLaboral(),
                                    null,
                                    null,
                                    "En Curso",
                                    experienciaLaboral.getDescripcionExperienciaLaboral())
                            );
                        } else {
                            experienciaslaborales.add(new ExperienciaLaboralHeadhuntingResponse(
                                    experienciaLaboral.getIdExperienciaLaboral(),
                                    experienciaLaboral.getNombreExperienciaLaboral(),
                                    experienciaLaboral.getEmpresaExperienciaLaboral(),
                                    Integer.parseInt(experienciaLaboral.getMesinicioExperienciaLaboral()),
                                    Integer.parseInt(experienciaLaboral.getAnioinicioExperienciaLaboral()),
                                    Code_Format.ConvierteMes(experienciaLaboral.getMesinicioExperienciaLaboral()) + " " +
                                            experienciaLaboral.getAnioinicioExperienciaLaboral(),
                                    experienciaLaboral.getMesfinExperienciaLaboral(),
                                    experienciaLaboral.getAniofinExperienciaLaboral(),
                                    Code_Format.ConvierteMes(experienciaLaboral.getMesfinExperienciaLaboral()) + " " +
                                            experienciaLaboral.getAniofinExperienciaLaboral(),
                                    experienciaLaboral.getDescripcionExperienciaLaboral())
                            );
                        }
                    }
            );

            Set<ExperienciaLaboralHeadhuntingResponse> list_experiencialaboral_sorted = experienciaslaborales.stream()
                    .sorted(Comparator.comparing(ExperienciaLaboralHeadhuntingResponse::getAnioinicioExperienciaLaboral)
                            .thenComparing(ExperienciaLaboralHeadhuntingResponse::getMesinicioExperienciaLaboral).reversed())
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            new ExperienciaLaboralHeadhuntingResponse();
            ExperienciaLaboralHeadhuntingResponse experiencialaboral_actual;
            experiencialaboral_actual = list_experiencialaboral_sorted.iterator().next();

            return experiencialaboral_actual;
        }
    }

    String SendInstituciones(Set<Educacion> list_educaciones) {

        if (list_educaciones.size() == 0) {
            return null;
        } else {
            Set<String> instituciones = list_educaciones.stream()
                    .map(Educacion::getInstitucionEducacion)
                    .collect(Collectors.toSet());

            return String.join(", ", instituciones);
        }
    }

    String SendConocimientos(Set<Conocimiento> list_conocimientos) {

        if (list_conocimientos.size() == 0) {
            return null;
        } else {
            Set<SkillFilterHeadhuntingResponse> conocimientos_postulante = new HashSet<>();

            list_conocimientos.forEach(
                    conocimiento -> conocimientos_postulante.add(
                            new SkillFilterHeadhuntingResponse(
                                    conocimiento.getNombreConocimiento() + conocimiento.getNivelConocimiento()
                            ))
            );

            Set<String> conocimientos = conocimientos_postulante.stream()
                    .map(SkillFilterHeadhuntingResponse::getSkill)
                    .collect(Collectors.toSet());

            return String.join(", ", conocimientos);
        }
    }

    String SendHabilidades(Set<Habilidad> list_habilidades) {

        if (list_habilidades.size() == 0) {
            return null;
        } else {
            Set<SkillFilterHeadhuntingResponse> habilidades_postulante = new HashSet<>();

            list_habilidades.forEach(
                    habilidad -> habilidades_postulante.add(
                            new SkillFilterHeadhuntingResponse(
                                    habilidad.getNombreHabilidad() + habilidad.getNivelHabilidad()
                            ))
            );

            Set<String> habilidades = habilidades_postulante.stream()
                    .map(SkillFilterHeadhuntingResponse::getSkill)
                    .collect(Collectors.toSet());

            return String.join(", ", habilidades);
        }
    }

    String SendIdiomas(Set<Idioma> list_idiomas) {

        if (list_idiomas.size() == 0) {
            return null;
        } else {
            Set<SkillFilterHeadhuntingResponse> idiomas_postulante = new HashSet<>();

            list_idiomas.forEach(
                    idioma -> idiomas_postulante.add(
                            new SkillFilterHeadhuntingResponse(
                                    idioma.getNombreIdioma() + idioma.getNivelIdioma()
                            ))
            );

            Set<String> idiomas = idiomas_postulante.stream()
                    .map(SkillFilterHeadhuntingResponse::getSkill)
                    .collect(Collectors.toSet());

            return String.join(", ", idiomas);
        }
    }

    int SendEdad(LocalDate fecha_nacimiento) {

        return (int) YEARS.between(fecha_nacimiento, LocalDate.now());
    }
}
