package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable {
    private Cargo cargo;
    private String fechaContrato;
    private String referencia;
    private String horaTrabajo;
    private ArrayList<Pago> listaPagos;
    private static final long serialVersioUID = 1L;

    public Empleado(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String identificacion, Cuenta cuenta, Cargo cargo, String fechaContrato, String referencia, String horaTrabajo) {
        super(nombre, apellido, cedula, telefono, email, direccion, identificacion, cuenta);
        this.cargo = cargo;
        this.fechaContrato = fechaContrato;
        this.referencia = referencia;
        this.horaTrabajo = horaTrabajo;
        listaPagos = new ArrayList<>();
    }

    public Empleado() {
        listaPagos = new ArrayList<>();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getHoraTrabajo() {
        return horaTrabajo;
    }

    public void setHoraTrabajo(String horaTrabajo) {
        this.horaTrabajo = horaTrabajo;
    }

    public ArrayList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(ArrayList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }
}
