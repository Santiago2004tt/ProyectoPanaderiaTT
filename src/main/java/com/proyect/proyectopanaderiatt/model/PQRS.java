package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;

public class PQRS implements Serializable {

    private String id;
    private String fechaCreacion;
    private String fechaResolucion;
    private ESTADO_PQRS estadoPqrs;
    private String asunto;
    private String descripcion;
    private TIPO_PQRS TIPOPQRS;
    private Cliente cliente;

    public PQRS(String id, String fechaCreacion, String fechaResolucion, ESTADO_PQRS estadoPqrs, String asunto, String descripcion, TIPO_PQRS TIPOPQRS, Cliente cliente) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.estadoPqrs = estadoPqrs;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.TIPOPQRS = TIPOPQRS;
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TIPO_PQRS getTipoPQRS() {
        return TIPOPQRS;
    }

    public void setTipoPQRS(TIPO_PQRS TIPOPQRS) {
        this.TIPOPQRS = TIPOPQRS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
