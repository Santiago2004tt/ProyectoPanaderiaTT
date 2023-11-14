package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FacturaController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pedido pedido;

    @FXML
    private Button btnPagar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblValorDecorado;

    @FXML
    private Label lblValorSaborBizcocho;

    @FXML
    private Label lblValorSaborRelleno;

    @FXML
    private Label lblValorTamanio;

    @FXML
    private Label lblValorTipoTorta;

    public void setApplication(Application application, Cliente cliente, Pedido pedido) {
        this.application = application;
        this.cliente = cliente;
        this.pedido = pedido;
        llenarCampos();
    }

    @FXML
    void pagarAction(ActionEvent event) {
        application.mostrarDireccionEnvio(cliente, pedido);
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarMenuDisenio(cliente, pedido.getListaDetallesPedido().get(0).getPastel());
    }

    private void llenarCampos() {
        Panaderia panaderia = modelFactoryController.getPanaderia();
        Pastel pastel = pedido.getListaDetallesPedido().get(0).getPastel();
        double precioTamano = 0;
        for (PisoPastel pisoPastel : pastel.getListaPisoPasteles()) {
            precioTamano += panaderia.getPrecioPisos().get(pisoPastel.getTamano());
        }

        lblValorSaborBizcocho.setText("Valor Sabor Bizcocho: " + panaderia.getPrecioSaborBizcocho().get(pastel.getSaborBizcocho()));
        lblValorTamanio.setText("Valor Tamaño: " + precioTamano);
        lblValorTipoTorta.setText("Valor Tipo de Torta: " + panaderia.getPrecioTipoTorta().get(pastel.getTipoTorta()));
        lblValorSaborRelleno.setText("Valor Sabor Relleno: " + panaderia.getPrecioSaborRelleno().get(pastel.getSaborRelleno()));

        if (!pastel.getDescripcion().isEmpty()) {
            lblValorDecorado.setText("Valor Decorado: " + 15000);
        } else {
            lblValorDecorado.setText("Valor Decorado: " + 0);
        }

        lblTotal.setText("Total: " + pedido.getListaDetallesPedido().get(0).getSubTotal());
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
