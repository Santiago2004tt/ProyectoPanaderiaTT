package com.proyect.proyectopanaderiatt.model;

import java.util.ArrayList;

public class Pastel {

    private String id;
    private SaborRelleno saborRelleno;
    private TipoTorta tipoTorta;
    private SaborBizcocho saborBizcocho;
    private Forma forma;
    private String descripcion;
    private String imagen;
    private ArrayList<PisoPastel> listaPisoPasteles;
    private Pedido pedido;
}
