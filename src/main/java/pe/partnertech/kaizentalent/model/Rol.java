/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import pe.partnertech.kaizentalent.enums.RolNombre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "rolesUsuario")
    Set<Usuario> usuariosRoles;
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", length = 20)
    private RolNombre nombreRol;

    //Constructores
    public Rol() {
    }

    public Rol(RolNombre nombreRol) {
        this.nombreRol = nombreRol;
    }

    //Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public RolNombre getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(RolNombre nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<Usuario> getUsuariosRoles() {
        return usuariosRoles;
    }

    public void setUsuariosRoles(Set<Usuario> usuariosRoles) {
        this.usuariosRoles = usuariosRoles;
    }
}
