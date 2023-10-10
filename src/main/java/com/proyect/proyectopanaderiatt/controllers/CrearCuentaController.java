package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.ClienteException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Cuenta;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.time.LocalDate;

public class CrearCuentaController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private Button btnRegresar;

    @FXML
    private PasswordField pfConfirmarContrasenia;

    @FXML
    private PasswordField pfContrasenia;

    @FXML
    private TextField tfUsuario;

    @FXML
    void confirmarContraseniaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnRegistrarse.fire();
        }
    }

    @FXML
    void contraseniaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pfConfirmarContrasenia.requestFocus();
        }
    }

    @FXML
    void iniciarSesionAction(ActionEvent event) {
        application.mostrarVentanaLogin();
    }

    @FXML
    void registrarseAction(ActionEvent event) {
        registrarse();
    }

    private void registrarse() {
        String usuario = tfUsuario.getText();
        String contrasena = pfContrasenia.getText();
        String contrasenaRep = pfConfirmarContrasenia.getText();
        if(verificarEspacio(usuario) && verificarRepetido(contrasena, contrasenaRep)){
            if(modelFactoryController.verificarUsuarioUnico(usuario)){
                if(modelFactoryController.verificarContrasenaRequisitos(contrasena)){
                    try {
                        Cuenta cuenta = new Cuenta();
                        cuenta.setUsuario(usuario);
                        cuenta.setContrasena(contrasena);
                        cuenta.setPersona(cliente);
                        cuenta.setFechaCreacion(String.valueOf(LocalDate.now()));
                        cliente.crearCuenta(cuenta);
                        modelFactoryController.crearCliente(cliente);
                        application.mostrarVentanaLogin();
                    }catch (ClienteException e){
                        MensajeUtil.mensajeAlerta("Error", e.getMessage());
                    }
                }else {
                    MensajeUtil.mensajeAlerta("Error", "La contraseña no cumple los requisitos");
                }
            }else {
                MensajeUtil.mensajeAlerta("Error", "El usuario no es valido, coloca otro");
            }
        }
    }

    private boolean verificarRepetido(String contrasena, String contrasenaRep) {
        if(contrasenaRep.equals(contrasena)){
            return true;
        }
        MensajeUtil.mensajeAlerta("Error", "La contraseña no coincide");
        return false;

    }

    private boolean verificarEspacio(String usuario) {
        if(usuario.equals("")){
            MensajeUtil.mensajeAlerta("Error", "El usuario no tiene");
            return false;
        }

        return true;
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarRegistroCliente(cliente);
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

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
    }
}
