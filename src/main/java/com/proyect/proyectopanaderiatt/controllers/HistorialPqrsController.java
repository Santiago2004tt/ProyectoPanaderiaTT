package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.ValorRequeridoException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.ESTADO_PQRS;
import com.proyect.proyectopanaderiatt.model.PQRS;
import com.proyect.proyectopanaderiatt.model.TIPO_PQRS;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistorialPqrsController {

    private Application application;
    private ModelFactoryController modelFactoryController;
    private Cliente cliente;
    private PQRS pqrsSeleccionada;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVer;

    @FXML
    private ComboBox<String> cbFiltro;

    @FXML
    private TableColumn<PQRS, String> colAsunto;

    @FXML
    private TableColumn<PQRS, ESTADO_PQRS> colEstado;

    @FXML
    private TableColumn<PQRS, TIPO_PQRS> colTipo;

    @FXML
    private TableView<PQRS> tblPqrs;

    private ObservableList<PQRS> pqrsData = FXCollections.observableArrayList();

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        tblPqrs.setItems(getPqrsData());
    }

    public ObservableList<PQRS> getPqrsData() {
        pqrsData.clear();
        pqrsData.addAll(cliente.getListaPQRS());
        return pqrsData;
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    @FXML
    void verAction() {
        try {
            ver();
        } catch (ValorRequeridoException e) {
            MensajeUtil.mensajeAlerta("Error", e.getMessage());
        }
    }

    private void ver() throws ValorRequeridoException {
        if (pqrsSeleccionada == null) {
            throw new ValorRequeridoException("Es necesario que seleccione una fila de la tabla");
        }
        application.mostrarDetallePqrs(cliente, pqrsSeleccionada);
    }

    @FXML
    void initialize() {
        cbFiltro.setPromptText("Seleccionar");
        cbFiltro.getItems().add("TODOS");
        cbFiltro.getItems().addAll(FXCollections.observableArrayList(Arrays.stream(TIPO_PQRS.values()).map(Enum::toString).toList()));
        cbFiltro.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> listenerCombobox(newValue));


        colAsunto.setCellValueFactory(new PropertyValueFactory<>("asunto"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoPqrs"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoPQRS"));

        tblPqrs.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> pqrsSeleccionada = newValue);
    }

    private void listenerCombobox(String tipoPqrs) {
        if (tipoPqrs.equals("TODOS")) {
            getPqrsData();
            return;
        }
        ArrayList<PQRS> listaPqrs = cliente.getListaPQRS();
        pqrsData.clear();
        List<PQRS> listaFiltrada = listaPqrs.stream().filter(x -> x.getTipoPQRS().toString().equals(tipoPqrs)).toList();
        pqrsData.addAll(FXCollections.observableArrayList(listaFiltrada));
    }
}
