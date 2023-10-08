package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;

public class Panaderia {

    private String id;
    private String ubicacion;
    private String horario;
    private String correoElectronico;
    private double calificacion;
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Pedido> listaPedidos;

    public Panaderia(String id, String ubicacion, String horario, String correoElectronico, double calificacion, String nombre) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.correoElectronico = correoElectronico;
        this.calificacion = calificacion;
        this.nombre = nombre;
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public Panaderia() {
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
