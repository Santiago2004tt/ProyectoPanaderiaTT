package com.proyect.proyectopanaderiatt.model;

public class Pago {
    private String id;
    private double valorPago;
    private EstadoPago estadoPago;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;
    private String nombreBanco;
    private MetodoAutorizacion metodoAutorizacion;
    private Cliente cliente;
    private Empleado empleado;
    private Pedido pedido;

    public Pago(String id, double valorPago, EstadoPago estadoPago, String numeroTarjeta, String fechaVencimiento, String codigoSeguridad, String nombreBanco, MetodoAutorizacion metodoAutorizacion, Cliente cliente, Empleado empleado, Pedido pedido) {
        this.id = id;
        this.valorPago = valorPago;
        this.estadoPago = estadoPago;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.nombreBanco = nombreBanco;
        this.metodoAutorizacion = metodoAutorizacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.pedido = pedido;
    }

    public Pago() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public MetodoAutorizacion getMetodoAutorizacion() {
        return metodoAutorizacion;
    }

    public void setMetodoAutorizacion(MetodoAutorizacion metodoAutorizacion) {
        this.metodoAutorizacion = metodoAutorizacion;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
