package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.PedidoException;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Pedido;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DireccionEnvioController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pedido pedido;

    @FXML
    private Button btnContinar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tfDireccion;

    @FXML
    void continuarAction(ActionEvent event) {
        try {
            continuar();
        } catch (PedidoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    private void continuar() throws PedidoException {
        String direccion = tfDireccion.getText();
        if (direccion.isEmpty())
            throw new PedidoException("Es necesario una direccion");

        cliente.setDireccion(direccion);
        modelFactoryController.iniciarSalvarDatosPrueba();
        application.mostrarPagoPedido(cliente, pedido);
    }

    @FXML
    void direccionEnvioAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            btnContinar.fire();
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarCarrito(cliente);
    }

    public void setApplication(Application application, Cliente cliente, Pedido pedido) {
        this.application = application;
        this.cliente = cliente;
        this.pedido = pedido;
        tfDireccion.setText(cliente.getDireccion());
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
}
