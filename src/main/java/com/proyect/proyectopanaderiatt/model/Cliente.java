package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Persona{

    private double nivelLealtad;
    private String ocupacion;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Pago> listaPagos;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String identificacion, Cuenta cuenta, double nivelLealtad, String ocupacion) {
        super(nombre, apellido, cedula, telefono, email, direccion, identificacion, cuenta);
        this.nivelLealtad = 0;
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

    public boolean verificarUsuario(String usuario) {
        if(!getCuenta().verificarUsuario(usuario)){
            return false;
        }
        return true;
    }

    //Crud de cliente

    /**
     * método para crear una cuenta y asignarla al cliente
     * @param cuenta
     * @return
     */
    public boolean crearCuenta(Cuenta cuenta){
        if(getCuenta() == null){
            setCuenta(cuenta);
            return true;
        }
        return false;
    }


}
