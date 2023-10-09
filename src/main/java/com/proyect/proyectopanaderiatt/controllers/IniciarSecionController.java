package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.ClienteException;
import com.proyect.proyectopanaderiatt.Exceptions.CuentaException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class IniciarSecionController {

    Application application;
    ModelFactoryController modelFactoryController;
    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRecuperarContrasenia;

    @FXML
    private PasswordField pfContrasenia;

    @FXML
    private TextField tfUsuario;

    @FXML
    void contraseniaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnIniciarSesion.fire();
        }
    }

    @FXML
    void crearCuentaAction(ActionEvent event) {
        application.mostrarRegistroCliente(null);
    }

    @FXML
    void iniciarSesionAction(ActionEvent event) {
        iniciarSesion();
    }

    private void iniciarSesion() {
        String usuario = tfUsuario.getText();
        String contrasena = pfContrasenia.getText();
        String cedula = "";
        if(verificarDatos(usuario, contrasena)){
            try {
                cedula = modelFactoryController.verificarUsuarioContrasena(usuario, contrasena);
                Cliente cliente = modelFactoryController.buscarCliente(cedula);
                application.mostrarPerfil(cliente);
            } catch (CuentaException e){
                MensajeUtil.mensajeAlerta("Error", e.getMessage());
            }catch (ClienteException e){
                MensajeUtil.mensajeAlerta("Error", e.getMessage());
            }
        }else {
            MensajeUtil.mensajeAlerta("Error","Rellena los campos por favor");
        }
    }

    private boolean verificarDatos(String usuario, String contrasena) {
        if(usuario.equals("")){
            return false;
        }
        if(contrasena.equals("")){
            return false;
        }
        return true;
    }

    @FXML
    void recuperarContraseniaAction(ActionEvent event) {

    }

    @FXML
    void usuarioReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pfContrasenia.requestFocus();
        }
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
