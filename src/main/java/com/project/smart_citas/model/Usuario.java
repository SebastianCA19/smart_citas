/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.smart_citas.model;

import java.util.Objects;

/**
 *
 * @author edavi
 */
public class Usuario {
    
    private Integer idUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String clave;
    private Integer estadoActivo;

    public Usuario(Integer id ,String nombre, String primerApellido, String segundoApellido, String email, String clave, Integer estadoActivo) {
        this.idUsuario = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.clave = clave;
        this.estadoActivo = estadoActivo;
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String correo, String password, Integer estadoActivo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = correo;
        this.clave = password;
        this.estadoActivo = estadoActivo;
    }


    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", email=" + email + ", clave=" + clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idUsuario);
        hash = 41 * hash + Objects.hashCode(this.primerApellido);
        hash = 41 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.primerApellido, other.primerApellido)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.idUsuario, other.idUsuario);
    }

    public Integer getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(Integer estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
