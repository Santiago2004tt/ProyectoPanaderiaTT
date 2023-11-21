package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.ValorRequeridoException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.TIPO_PQRS;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PqrsController {

    private Application application;
    private ModelFactoryController modelFactoryController;
    private Cliente cliente;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnEnviar;

    @FXML
    private ComboBox<TIPO_PQRS> cbTipoPeticion;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTelefono;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private TextField tfAsunto;

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        cargarDatosCliente();
    }

    /**
     * Carga los datos del cliente en los campos necesarios
     */
    private void cargarDatosCliente() {
        lblNombre.setText("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
        lblTelefono.setText("Telefono: " + cliente.getTelefono());
        lblEmail.setText("Email: " + cliente.getEmail());
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarCatalogo(cliente);
    }

    @FXML
    void enviarAction(ActionEvent event) {
        try {
            enviar();
        } catch (ValorRequeridoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    private void enviar() throws ValorRequeridoException {
        TIPO_PQRS tipoPqrs = cbTipoPeticion.getValue();
        String asunto = tfAsunto.getText();
        String descripcion = taDescripcion.getText();
        if (tipoPqrs == null) throw new ValorRequeridoException("El valor tipo solicitud es requerido");
        if (asunto.isEmpty()) throw new ValorRequeridoException("El valor asunto es requerido");
        if (descripcion.isEmpty()) throw new ValorRequeridoException("El valor descripcion es requerido");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MM:yy : hh:mm:ss");;
        LocalDateTime localDate = LocalDateTime.now();
        String fechaCreacion = localDate.format(dateTimeFormatter);

        modelFactoryController.getPanaderia().crearPqrs(tipoPqrs, asunto, descripcion, fechaCreacion, cliente);
        modelFactoryController.iniciarSalvarDatosPrueba();

        MensajeUtil.mensajeInformacion("Exito", "Se creo la solicitud exitosamente");
        application.mostrarCatalogo(cliente);
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        cbTipoPeticion.setItems(FXCollections.observableArrayList(TIPO_PQRS.values()));
        cbTipoPeticion.setPromptText("Seleccionar");
    }

}
