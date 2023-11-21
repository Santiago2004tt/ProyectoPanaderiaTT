package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.ValorRequeridoException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DevolucionController {

    private Application application;
    private ModelFactoryController modelFactoryController;
    private Cliente cliente;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextArea taMotivoDevolucion;

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
    }

    @FXML
    void aceptarAction(ActionEvent event) {
        try {
            aceptar();
        } catch (ValorRequeridoException e) {
            MensajeUtil.mensajeAlerta("Error", e.getMessage());
        }
    }


    private void aceptar() throws ValorRequeridoException {
        String motivoDevolucion = taMotivoDevolucion.getText();

        if (motivoDevolucion.isEmpty()) throw new ValorRequeridoException("El valor motivo devolucion es requerido");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MM:yy : hh:mm:ss");;
        LocalDateTime localDate = LocalDateTime.now();
        String fechaCreacion = localDate.format(dateTimeFormatter);

        modelFactoryController.getPanaderia().crearDevolucion(fechaCreacion, motivoDevolucion, cliente);
        modelFactoryController.iniciarSalvarDatosPrueba();
        MensajeUtil.mensajeInformacion("Exito", "Se creo la devolucion");
        application.mostrarCatalogo(cliente);
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarCatalogo(cliente);
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
