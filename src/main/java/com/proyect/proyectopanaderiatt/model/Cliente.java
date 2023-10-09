package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Persona{

    private double nivelLealtad;
    private String ocupacion;
    private String foto;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Pago> listaPagos;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String identificacion, Cuenta cuenta, double nivelLealtad, String ocupacion, String foto) {
        super(nombre, apellido, cedula, telefono, email, direccion, identificacion, cuenta);
        this.nivelLealtad = 0;
        this.ocupacion = ocupacion;
        this.foto = foto;
    }

    public Cliente() {
        listaPedidos = new ArrayList<>();
        listaPagos = new ArrayList<>();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    /**
     * metodo que verifica si existe el usuario o no
     * @param usuario
     * @return
     */
    public boolean verificarUsuario(String usuario) {
        if(!getCuenta().verificarUsuario(usuario)){
            return false;//si lo encuentra retorna true
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


    public boolean veririficarUsuarioContrasena(String usuario, String contrasena) {
        if(getCuenta().verificarUsuarioContrasena(usuario, contrasena)){
            return true;
        }
        return false;
    }
}
