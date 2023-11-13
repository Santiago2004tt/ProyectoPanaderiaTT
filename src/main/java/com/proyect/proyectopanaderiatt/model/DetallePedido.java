package com.proyect.proyectopanaderiatt.model;

import com.proyect.proyectopanaderiatt.controllers.ModelFactoryController;

import java.io.Serializable;

public class DetallePedido implements Serializable {

    private String id;
    private double subTotal;
    private Pastel pastel;
    private Pedido pedido;
    private static final long serialVersioUID = 1L;

    public DetallePedido(String id, Pastel pastel, Pedido pedido) {
        this.id = id;
        this.pastel = pastel;
        this.pedido = pedido;
        calcularSubtotal();
    }

    public DetallePedido(Pastel pastel, Pedido pedido) {
        this.pastel = pastel;
        this.pedido = pedido;
        calcularSubtotal();
    }

    public DetallePedido(Pastel pastel) {
        this.pastel = pastel;
        calcularSubtotal();
    }

    public DetallePedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Pastel getPastel() {
        return pastel;
    }

    public void setPastel(Pastel pastel) {
        this.pastel = pastel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * calcula el precio del pastel almacenado
     */
    private void calcularSubtotal() {
        subTotal = 0;
        Panaderia panaderia = ModelFactoryController.getInstance().getPanaderia();

        subTotal += panaderia.getPrecioTipoTorta().get(pastel.getTipoTorta());
        subTotal += panaderia.getPrecioSaborBizcocho().get(pastel.getSaborBizcocho());
        subTotal += panaderia.getPrecioSaborRelleno().get(pastel.getSaborRelleno());
        if (!(pastel.getDescripcion() == null)) {
            subTotal += 15000;
        }
        for (PisoPastel pisoPastel : pastel.getListaPisoPasteles()) {
            subTotal += panaderia.precioPisos.get(pisoPastel.getTamano());
        }
    }
}
