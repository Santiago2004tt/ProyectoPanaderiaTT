package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Tamanos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.ArrayList;

public class MenuDisenioController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnRegresar;

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
    private TableColumn<Tamanos, Boolean> colSeleccionar;

    @FXML
    private TableColumn<Tamanos, String> colTamanio;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private TableView<Tamanos> tblPisos;

    private Application application;
    private Cliente cliente;
    private ObservableList<Tamanos> tamanosData = FXCollections.observableArrayList(Tamanos.values());

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
    }

    @FXML
    void aceptarAction(ActionEvent event) {

    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        tblPisos.setItems(tamanosData);
        colTamanio.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colSeleccionar.setCellValueFactory(new PropertyValueFactory<>("seleccionado"));
        colSeleccionar.setCellFactory(new Callback<TableColumn<Tamanos, Boolean>, TableCell<Tamanos, Boolean>>() {
            @Override
            public TableCell<Tamanos, Boolean> call(TableColumn<Tamanos, Boolean> tamanosBooleanTableColumn) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Boolean aBoolean, boolean b) {
                        super.updateItem(aBoolean, b);
                        if (aBoolean != null) {
                            CheckBox checkBox = new CheckBox();
                            checkBox.setSelected(aBoolean);
                            checkBox.selectedProperty().addListener((ons, oldValue, newValue) -> {
                                if (getTableRow() != null && getTableRow().getItem() != null) {
                                    Tamanos tamanos = getTableRow().getItem();
                                    // Ahora puedes acceder a la variable "tamanos" y modificarla
                                    tamanos.setSeleccionado(newValue);
                                }
                            });
                            setGraphic(checkBox);
                        }
                    }
                };
            }
        });

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

    private ArrayList<Tamanos> tomarSeleccionados() {
        ArrayList<Tamanos> seleccionados = new ArrayList<>();
        ObservableList<Tamanos> lista = tblPisos.getItems();
        for (Tamanos tamano : lista) {
            if (tamano.isSeleccionado()) {
                seleccionados.add(tamano);
                System.out.println(tamano.getValor());
            }
        }
        return seleccionados;
    }
}
