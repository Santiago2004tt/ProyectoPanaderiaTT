package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class MenuDisenioController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Image imageAux;
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private ComboBox<SaborBizcocho> cbSaborBizcocho;

    @FXML
    private ComboBox<SaborRelleno> cbSaborRelleno;

    @FXML
    private ComboBox<TipoTorta> cbTipoTorta;

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


    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
    }

    @FXML
    void aceptarAction(ActionEvent event) {
        aceptar();
    }

    private void aceptar() {

    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {
        seleccionarImagen();
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();
        cbTipoTorta.getItems().setAll(TipoTorta.values());
        cbSaborBizcocho.getItems().setAll(SaborBizcocho.values());
        cbSaborRelleno.getItems().setAll(SaborRelleno.values());

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

    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la búsqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        //Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(btnSeleccionarImagen.getScene().getWindow());

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            ivImagen.setImage(image);  //Se llama al objeto de tipo ImagenView y se muestra
            this.imageAux=image;
        }
    }

}
