package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.PQRS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DetallePqrsController {

    private Application application;
    private ModelFactoryController modelFactoryController;
    private Cliente cliente;
    private PQRS pqrs;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblAsunto;

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblTipoSolicitud;

    @FXML
    private TextArea taDescripcion;

    public void setApplication(Application application, Cliente cliente, PQRS pqrs) {
        this.application = application;
        this.cliente = cliente;
        this.pqrs = pqrs;
        cargarDatos();
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarHistorialPqrs(cliente);
    }

    private void cargarDatos() {
        lblAsunto.setText("Asunto: " + pqrs.getAsunto());
        lblEstado.setText("Estado: " + pqrs.getEstadoPqrs());
        lblTipoSolicitud.setText("Tipo solicitud: " + pqrs.getTipoPQRS());
        taDescripcion.setText(pqrs.getDescripcion());
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
