package com.proyect.proyectopanaderiatt.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class IniciarSecionController {

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
    void inicisrSesionAction(ActionEvent event) {

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

}