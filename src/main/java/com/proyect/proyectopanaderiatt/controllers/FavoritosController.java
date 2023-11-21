package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FavoritosController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pastel pastelSeleccionado;
    ObservableList<Pastel> listaPastelData = FXCollections.observableArrayList();

    @FXML
    private TableView<Pastel> tblPastel;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Pastel, SaborRelleno> colSaborRelleno;

    @FXML
    private TableColumn<Pastel, SaborBizcocho> colSaborBizcocho;

    @FXML
    private ImageView iviImagen;

    @FXML
    private TableColumn<Pastel, TipoTorta> colTipoPastel;

    @FXML
    void salir(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application=application;
        this.cliente = cliente;
        actualizarTabla();
    }

    private void actualizarTabla() {
        listaPastelData.clear();
        listaPastelData.addAll(cliente.getListaFavoritos());
        tblPastel.setItems(listaPastelData);
    }

    private void inicializarTabla() {
        this.colSaborRelleno.setCellValueFactory(new PropertyValueFactory<>("saborRelleno"));
        this.colTipoPastel.setCellValueFactory(new PropertyValueFactory<>("tipoTorta"));
        this.colSaborBizcocho.setCellValueFactory(new PropertyValueFactory<>("saborBizcocho"));

        tblPastel.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            pastelSeleccionado= newSelection;
            mostrarInfo();
        });
    }

    private void mostrarInfo() {
        Image image = new Image(pastelSeleccionado.getImagen());
        iviImagen.setImage(image);
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        inicializarTabla();
    }
}