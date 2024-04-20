package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Devolucion;
import com.proyect.proyectopanaderiatt.model.ESTADO_DEVOLUCION;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HistorialDevolucionesController {

    private Application application;
    private ModelFactoryController modelFactoryController;
    private Cliente cliente;
    private ObservableList<Devolucion> devolucionesData = FXCollections.observableArrayList();

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Devolucion, ESTADO_DEVOLUCION> colEstado;

    @FXML
    private TableColumn<Devolucion, String> colMotivo;

    @FXML
    private TableView<Devolucion> tblDevoluciones;

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        tblDevoluciones.setItems(getDevolucionesData());
    }

    public ObservableList<Devolucion> getDevolucionesData() {
        devolucionesData.clear();
        devolucionesData.addAll(FXCollections.observableList(cliente.getListaDevolucion()));
        return devolucionesData;
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();

        colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivoDevolucion"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoDevolucion"));
    }

}
