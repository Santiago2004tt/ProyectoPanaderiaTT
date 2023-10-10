package com.proyect.proyectopanaderiatt.test;

import com.proyect.proyectopanaderiatt.model.Panaderia;

public class test {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

        String contrasena = "M0nd0ng0.";

        System.out.println(panaderia.verificarContrasena(contrasena));
    }
}
