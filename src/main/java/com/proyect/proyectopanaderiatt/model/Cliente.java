package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;

public class Cliente extends Persona{

    private double nivelLealtad;
    private String ocupacion;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Pago> listaPagos;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String identificacion, Cuenta cuenta, double nivelLealtad, String ocupacion) {
        super(nombre, apellido, cedula, telefono, email, direccion, identificacion, cuenta);
        this.nivelLealtad = nivelLealtad;
        this.ocupacion = ocupacion;
    }

    public Cliente() {
        listaPedidos = new ArrayList<>();
        listaPagos = new ArrayList<>();
    }

    public double getNivelLealtad() {
        return nivelLealtad;
    }

    public void setNivelLealtad(double nivelLealtad) {
        this.nivelLealtad = nivelLealtad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(ArrayList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }
}
