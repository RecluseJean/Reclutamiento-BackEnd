/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imagen")
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long idImagen;

    @Column(name = "nombre_imagen")
    private String nombreImagen;

    @Column(name = "tipoarchivo_imagen", length = 25)
    private String tipoarchivoImagen;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "archivo_imagen")
    private byte[] archivoImagen;

    @OneToOne
    @JoinTable(name = "usuario_imagen",
            joinColumns = @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioImagen;

    @OneToOne
    @JoinTable(name = "experiencialaboral_imagen",
            joinColumns = @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen"),
            inverseJoinColumns = @JoinColumn(name = "id_experiencialaboral", referencedColumnName = "id_experiencialaboral"))
    private ExperienciaLaboral experiencialaboralImagen;

    //Constructores
    public Imagen() {
    }

    //Imagen To User
    public Imagen(String nombreImagen, String tipoarchivoImagen, String urlImagen, byte[] archivoImagen, Usuario usuarioImagen) {
        this.nombreImagen = nombreImagen;
        this.tipoarchivoImagen = tipoarchivoImagen;
        this.urlImagen = urlImagen;
        this.archivoImagen = archivoImagen;
        this.usuarioImagen = usuarioImagen;
    }

    //Imagen To Experiencia Laboral
    public Imagen(String nombreImagen, String tipoarchivoImagen, String urlImagen, byte[] archivoImagen,
                  ExperienciaLaboral experiencialaboralImagen) {
        this.nombreImagen = nombreImagen;
        this.tipoarchivoImagen = tipoarchivoImagen;
        this.urlImagen = urlImagen;
        this.archivoImagen = archivoImagen;
        this.experiencialaboralImagen = experiencialaboralImagen;
    }

    //Getters y Setters
    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getTipoarchivoImagen() {
        return tipoarchivoImagen;
    }

    public void setTipoarchivoImagen(String tipoarchivoImagen) {
        this.tipoarchivoImagen = tipoarchivoImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public byte[] getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(byte[] archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    public Usuario getUsuarioImagen() {
        return usuarioImagen;
    }

    public void setUsuarioImagen(Usuario usuarioImagen) {
        this.usuarioImagen = usuarioImagen;
    }

    public ExperienciaLaboral getExperiencialaboralImagen() {
        return experiencialaboralImagen;
    }

    public void setExperiencialaboralImagen(ExperienciaLaboral experiencialaboralImagen) {
        this.experiencialaboralImagen = experiencialaboralImagen;
    }
}
