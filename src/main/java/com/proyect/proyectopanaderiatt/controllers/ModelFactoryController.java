package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.Exceptions.ClienteException;
import com.proyect.proyectopanaderiatt.Exceptions.CuentaException;
import com.proyect.proyectopanaderiatt.Persistencia.Persistencia;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Panaderia;

import java.io.IOException;

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

    public boolean verificarExisteCliente(String cedula) {
        return panaderia.verificarCliente(cedula);
    }

    public boolean verificarUsuarioUnico(String usuario) {
        return panaderia.verificarUsuarioClienteUnico(usuario);
    }

    public boolean verificarContrasenaRequisitos(String contrasena) {
        return panaderia.verificarContrasena(contrasena);
    }

    public void crearCliente(Cliente cliente) throws ClienteException {
        panaderia.crearCliente(cliente);
        iniciarSalvarDatosPrueba();
    }

    private static class SingletonHolder {
        private final static ModelFactoryController eInstance = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eInstance;
    }

    public ModelFactoryController() {
        panaderia = Persistencia.cargarRecursoBinario();
        if(panaderia == null) {
            inicializarDatos();
            iniciarSalvarDatosPrueba();
        }
    }

    private void inicializarDatos() {
        inicializarPanaderia();
    }

    private void inicializarPanaderia() {
        panaderia = new Panaderia();
        panaderia.setNombre("PanaderiaTT");
        panaderia.setCalificacion(4);
        panaderia.setId("pntt01");
        panaderia.setUbicacion("Pereira");
        panaderia.setHorario("Lun-mar de 8:00 am a 9:00 pm");
    }

    private void iniciarSalvarDatosPrueba() {

        Persistencia.guardarRecursoBinario(panaderia);

    }

}
