package com.proyect.proyectopanaderiatt.Persistencia;

import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_MODELO_PANADERIA_BINARIO = "C:\\td\\persistencia_panaderiatt/Model.dat";
    public static final String RUTA_ARCHIVO_MODELO_PANADERIA_XML = "C:\\td\\persistencia_panaderiatt/Encript.xml";
    public static final String RUTA_ARCHIVO_CREDENCIALES = "C:\\td\\persistencia_panaderiatt/credenciales.txt";


    public static Panaderia cargarRecursoXML() {

        Panaderia panaderia = null;

        try {
            panaderia = (Panaderia) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PANADERIA_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return panaderia;

    }

    public static void guardarRecursoXML(Panaderia panaderia) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PANADERIA_XML, panaderia);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Panaderia cargarRecursoBinario() {

        Panaderia panaderia = null;

        try {
            panaderia = (Panaderia) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_PANADERIA_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return panaderia;
    }

    public static void guardarRecursoBinario(Panaderia panaderia) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_PANADERIA_BINARIO, panaderia);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<String> cargarCredenciales() {

        ArrayList<String> contenido = null;
        try {
            contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CREDENCIALES);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contenido;
    }
}
