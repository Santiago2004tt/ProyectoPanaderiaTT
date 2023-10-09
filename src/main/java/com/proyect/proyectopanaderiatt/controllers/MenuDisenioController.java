package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class MenuDisenioController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private ComboBox<?> cbSaborBizcocho;

    @FXML
    private ComboBox<?> cbSaborRelleno;

    @FXML
    private ComboBox<?> cbTipoTorta;

    @FXML
    private CheckBox chbDescripcion;

    @FXML
    private TableColumn<?, ?> colSeleccionar;

    @FXML
    private TableColumn<?, ?> colTamanio;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private TableView<?> tblPisos;

    private Application application;

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
    }

    @FXML
    void aceptarAction(ActionEvent event) {

    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        chbDescripcion.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                btnSeleccionarImagen.setDisable(false);
                taDescripcion.setDisable(false);
            } else {
                btnSeleccionarImagen.setDisable(true);
                taDescripcion.setDisable(true);
            }
        });
    }

}
