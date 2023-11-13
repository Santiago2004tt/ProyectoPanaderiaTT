package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pastel implements Serializable {

    private String id;
    private SaborRelleno saborRelleno;
    private TipoTorta tipoTorta;
    private SaborBizcocho saborBizcocho;
    private Forma forma;
    private String descripcion;
    private String imagen;
    private Pedido pedido;
    private ArrayList<PisoPastel> listaPisoPasteles;
    private static final long serialVersioUID = 1L;

    public Pastel(String id, SaborRelleno saborRelleno, TipoTorta tipoTorta, SaborBizcocho saborBizcocho, Forma forma, String descripcion, String imagen, Pedido pedido) {
        this.id = id;
        this.saborRelleno = saborRelleno;
        this.tipoTorta = tipoTorta;
        this.saborBizcocho = saborBizcocho;
        this.forma = forma;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.pedido = pedido;
        listaPisoPasteles = new ArrayList<>();
    }

    public Pastel(SaborRelleno saborRelleno, TipoTorta tipoTorta, SaborBizcocho saborBizcocho, Forma forma) {
        this.saborRelleno = saborRelleno;
        this.tipoTorta = tipoTorta;
        this.saborBizcocho = saborBizcocho;
        this.forma = forma;
        listaPisoPasteles = new ArrayList<>();
    }

    public Pastel() {
        listaPisoPasteles = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SaborRelleno getSaborRelleno() {
        return saborRelleno;
    }

    public void setSaborRelleno(SaborRelleno saborRelleno) {
        this.saborRelleno = saborRelleno;
    }

    public TipoTorta getTipoTorta() {
        return tipoTorta;
    }

    public void setTipoTorta(TipoTorta tipoTorta) {
        this.tipoTorta = tipoTorta;
    }

    public SaborBizcocho getSaborBizcocho() {
        return saborBizcocho;
    }

    public void setSaborBizcocho(SaborBizcocho saborBizcocho) {
        this.saborBizcocho = saborBizcocho;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<PisoPastel> getListaPisoPasteles() {
        return listaPisoPasteles;
    }

    public void setListaPisoPasteles(ArrayList<PisoPastel> listaPisoPasteles) {
        this.listaPisoPasteles = listaPisoPasteles;
    }
}
