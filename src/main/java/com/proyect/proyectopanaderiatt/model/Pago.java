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
}
