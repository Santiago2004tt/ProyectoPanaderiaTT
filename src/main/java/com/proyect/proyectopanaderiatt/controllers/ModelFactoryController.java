package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.Exceptions.ClienteException;
import com.proyect.proyectopanaderiatt.Exceptions.CuentaException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Cuenta;
import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.util.SortedSet;
import java.util.TreeSet;

public class ModelFactoryController {

    /**
     * atributos
     */
    private Panaderia panaderia;

    public String verificarUsuarioContrasena(String usuario, String contrasena) throws CuentaException {
        return panaderia.verificarUsuarioContrasena(usuario, contrasena);
    }

    public Cliente buscarCliente(String cedula) throws ClienteException {
        return panaderia.buscarCliente(cedula);
    }

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
            Cliente cliente = new Cliente();
            Cuenta cuenta = new Cuenta();
            cliente.setCedula("1");
            cuenta.setUsuario("jere");
            cuenta.setContrasena("jere");
            cliente.setCuenta(cuenta);
            panaderia.getListaClientes().add(cliente);
        }
    }

}
