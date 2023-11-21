package com.proyect.proyectopanaderiatt.model;

public class PQRS {

    private String id;
    private String fechaCreacion;
    private String fechaResolucion;
    private ESTADO_PQRS estadoPqrs;
    private String descripcion;
    private TipoPQRS tipoPQRS;
    private Cliente cliente;

    public PQRS(String id, String fechaCreacion, String fechaResolucion, ESTADO_PQRS estadoPqrs, String descripcion, TipoPQRS tipoPQRS, Cliente cliente) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.estadoPqrs = estadoPqrs;
        this.descripcion = descripcion;
        this.tipoPQRS = tipoPQRS;
        this.cliente = cliente;
    }

    public PQRS() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public ESTADO_PQRS getEstadoPqrs() {
        return estadoPqrs;
    }

    public void setEstadoPqrs(ESTADO_PQRS estadoPqrs) {
        this.estadoPqrs = estadoPqrs;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPQRS getTipoPQRS() {
        return tipoPQRS;
    }

    public void setTipoPQRS(TipoPQRS tipoPQRS) {
        this.tipoPQRS = tipoPQRS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
