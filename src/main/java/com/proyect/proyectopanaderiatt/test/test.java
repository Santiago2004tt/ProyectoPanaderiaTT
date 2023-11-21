package com.proyect.proyectopanaderiatt.test;

import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

        String contrasena = "M0nd0ng0.";

        System.out.println(panaderia.verificarContrasena(contrasena));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MM:yy : hh:mm:ss");;
        LocalDateTime localDate = LocalDateTime.now();
        String fechaCreacion = localDate.format(dateTimeFormatter);
        System.out.println(fechaCreacion);
    }
}
