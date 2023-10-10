package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;
import java.security.Key;

public class Cuenta implements Serializable {

    private String usuario;
    private String contrasena;
    private String codigoSeguridad;
    private String fechaCreacion;
    private Persona persona;
    private static final long serialVersioUID = 1L;

    public Cuenta(String usuario, String contrasena, String codigoSeguridad, String fechaCreacion, Persona persona) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaCreacion = fechaCreacion;
        this.persona = persona;
    }

    public Cuenta() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * verifica si el usuario existe o no
     * @param usuario
     * @return
     */
    public boolean verificarUsuario(String usuario) {
        if (getUsuario().equals(usuario)){
            return true;
        }
        return false;
    }

    public boolean verificarUsuarioContrasena(String usuario, String contrasena) {
        if(getUsuario().equals(usuario) && getContrasena().equals(contrasena)){
            return true;
        }
        return false;
    }
}
