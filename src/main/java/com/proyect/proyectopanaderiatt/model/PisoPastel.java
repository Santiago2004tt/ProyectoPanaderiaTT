package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;

public class PisoPastel implements Serializable {
    private String id;
    private Tamano tamano;
    private int numeroPiso;
    Pastel pastel;
    private static final long serialVersioUID = 1L;

    public PisoPastel(String id, Tamano tamano, int numeroPiso, Pastel pastel) {
        this.id = id;
        this.tamano = tamano;
        this.numeroPiso = numeroPiso;
        this.pastel = pastel;
    }

    public PisoPastel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public Pastel getPastel() {
        return pastel;
    }

    public void setPastel(Pastel pastel) {
        this.pastel = pastel;
    }
}
