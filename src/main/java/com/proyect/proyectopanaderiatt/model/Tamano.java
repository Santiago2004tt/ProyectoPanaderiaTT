package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;

public enum Tamano implements Serializable {

    unCuarto("1/4", false),
    unMedio("1/2", false),
    tresCuartos("3/4", false),
    uno("1", false),
    dos("2", false);

    private final String valor;
    private boolean seleccionado;

    Tamano(String valor, boolean seleccionado) {
        this.valor = valor;
        this.seleccionado = seleccionado;
    }

    public String getValor() {
        return valor;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
