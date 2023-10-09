package com.proyect.proyectopanaderiatt.model;

import java.security.Key;

public class Cuenta {

    private String usuario;
    private String contrasena;
    private String codigoSeguridad;
    private String fechaCreacion;
    private Persona persona;

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

    public boolean verificarUsuario(String usuario) {
        if (getUsuario().equals(usuario)){
            return true;
        }
        return false;
    }
}
