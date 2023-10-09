package com.proyect.proyectopanaderiatt.Persistencia;

import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO = "C:\\td\\persistencia/Model.dat";
    public static final String RUTA_ARCHIVO_MODELO_PANADERIA_XML = "C:\\td\\persistencia/Encript.xml";


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

}
