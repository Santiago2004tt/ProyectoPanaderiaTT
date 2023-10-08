package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;

public class Pedido {
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
}
