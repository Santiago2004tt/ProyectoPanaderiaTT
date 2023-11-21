package com.proyect.proyectopanaderiatt.model;

public class Devolucion {

    private String id;
    private String fechaDevolucion;
    private String motivoDevolucion;
    private ESTADO_DEVOLUCION estadoDevolucion;
    private Cliente cliente;
    private String notasAdicionales;

    public Devolucion(String id, String fechaDevolucion, String motivoDevolucion, ESTADO_DEVOLUCION estadoDevolucion, Cliente cliente, String notasAdicionales) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
        this.motivoDevolucion = motivoDevolucion;
        this.estadoDevolucion = estadoDevolucion;
        this.cliente = cliente;
        this.notasAdicionales = notasAdicionales;
    }

    public Devolucion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public ESTADO_DEVOLUCION getEstadoDevolucion() {
        return estadoDevolucion;
    }

    public void setEstadoDevolucion(ESTADO_DEVOLUCION estadoDevolucion) {
        this.estadoDevolucion = estadoDevolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }
}
