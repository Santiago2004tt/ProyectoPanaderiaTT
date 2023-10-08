package com.proyect.proyectopanaderiatt.model;

public class DetallePedido {

    private String id;
    private double subTotal;
    private Pastel pastel;
    private Pedido pedido;

    public DetallePedido(String id, double subTotal, Pastel pastel, Pedido pedido) {
        this.id = id;
        this.subTotal = subTotal;
        this.pastel = pastel;
        this.pedido = pedido;
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
}
