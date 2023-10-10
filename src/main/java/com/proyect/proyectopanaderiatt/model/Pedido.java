package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private String id;
    private double total;
    private String domiciliario;
    private boolean pagoTotal;
    private boolean valorIva;
    private String fechaEmision;
    private String fechaEntrega;
    private Cliente cliente;
    private Empleado empleado;
    private Pago pago;
    private ArrayList<DetallePedido> listaDetallesPedido;
    private static final long serialVersioUID = 1L;

    public Pedido(String id, double total, String domiciliario, boolean pagoTotal, boolean valorIva, String fechaEmision, String fechaEntrega, Cliente cliente, Empleado empleado, Pago pago) {
        this.id = id;
        this.total = total;
        this.domiciliario = domiciliario;
        this.pagoTotal = pagoTotal;
        this.valorIva = valorIva;
        this.fechaEmision = fechaEmision;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.empleado = empleado;
        this.pago = pago;
        listaDetallesPedido = new ArrayList<>();
    }

    public Pedido() {
        listaDetallesPedido = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(String domiciliario) {
        this.domiciliario = domiciliario;
    }

    public boolean isPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(boolean pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public boolean isValorIva() {
        return valorIva;
    }

    public void setValorIva(boolean valorIva) {
        this.valorIva = valorIva;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ArrayList<DetallePedido> getListaDetallesPedido() {
        return listaDetallesPedido;
    }

    public void setListaDetallesPedido(ArrayList<DetallePedido> listaDetallesPedido) {
        this.listaDetallesPedido = listaDetallesPedido;
    }
}
