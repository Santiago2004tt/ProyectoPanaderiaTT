package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RegistroClienteController {

    Application application;
    ModelFactoryController modelFactoryController;
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private Button btnSiguiente;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfCedula;

    @FXML
    private TextField tfDireccion;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;

    @FXML
    void apellidoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfCedula.requestFocus();
        }
    }

    @FXML
    void cedulaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfTelefono.requestFocus();
        }
    }

    @FXML
    void direccionReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSiguiente.fire();
        }
    }

    @FXML
    void emailReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfDireccion.requestFocus();
        }
    }

    @FXML
    void iniciarSesionAction(ActionEvent event) {

    }

    @FXML
    void nombreReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfApellido.requestFocus();
        }
    }

    @FXML
    void regresarAction(ActionEvent event) {

    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {

    }

    @FXML
    void siguienteAction(ActionEvent event) {

    }

    @FXML
    void telefonoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfEmail.requestFocus();
        }
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();
    }

    public void setApplication(Application application) {
    }
}
