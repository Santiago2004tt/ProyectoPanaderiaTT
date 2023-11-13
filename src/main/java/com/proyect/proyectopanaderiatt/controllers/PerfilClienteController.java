package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PerfilClienteController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    @FXML
    private Button btnCrearPedido;

    @FXML
    private ImageView ivFotoPerfil;

    @FXML
    private Button btnHistorialPedidos;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTelefono;

    @FXML
    void crearPedidoAction(ActionEvent event) {
        application.mostrarMenuDisenio(cliente, null);
    }

    @FXML
    void historialPedidosAction(ActionEvent event) {

    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarCatalogo(cliente);
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        anadirDatos();
    }

    private void anadirDatos() {
        lblNombre.setText("Nombre: "+cliente.getNombre());
        lblApellido.setText("Apellido: "+cliente.getApellido());
        lblCedula.setText("Cedula: "+cliente.getCedula());
        lblTelefono.setText("Telefono: "+ cliente.getTelefono());
        lblEmail.setText("Email: "+cliente.getEmail());
        lblDireccion.setText("Direccion: "+cliente.getDireccion());
        ivFotoPerfil.setImage(new Image(cliente.getFoto()));
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();
    }
}
