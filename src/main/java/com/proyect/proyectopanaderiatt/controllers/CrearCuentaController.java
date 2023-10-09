package com.proyect.proyectopanaderiatt.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CrearCuentaController {

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

    }

    @FXML
    void registrerseAction(ActionEvent event) {

    }

    @FXML
    void regresarAction(ActionEvent event) {

    }

    @FXML
    void usuarioReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pfContrasenia.requestFocus();
        }
    }

}
