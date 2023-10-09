package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.util.SortedSet;
import java.util.TreeSet;

public class ModelFactoryController {

    /**
     * atributos
     */
    private Panaderia panaderia;

    private static class SingletonHolder {
        private final static ModelFactoryController eInstance = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eInstance;
    }

    public ModelFactoryController() {

        if(panaderia == null) {
            panaderia = new Panaderia();
            panaderia.setNombre("panaderiaTT");
        }
    }

}
