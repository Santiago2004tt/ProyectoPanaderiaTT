package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.PedidoException;
import com.proyect.proyectopanaderiatt.Exceptions.ValorRequeridoException;
import com.proyect.proyectopanaderiatt.model.*;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class PagoPedidoController {

    Application application;
    ModelFactoryController modelFactoryController;
    Panaderia panaderia;
    Cliente cliente;
    Pedido pedido;

    @FXML
    private Button btnRealizarPago;

    @FXML
    private Button btnRegresar;

    @FXML
    private ComboBox<MetodoAutorizacion> cbTipoTarjeta;

    @FXML
    private ComboBox<String> cbValorPago;

    @FXML
    private Label lblTotalPagar;

    @FXML
    private PasswordField pfCodigoSeguridad;

    @FXML
    private TextField tfFechaVencimiento;

    @FXML
    private TextField tfNombreBanco;

    @FXML
    private TextField tfNumeroTarjeta;

    @FXML
    void codigoSeguridadReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            tfNombreBanco.requestFocus();
    }

    @FXML
    void fechaVencimientoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            pfCodigoSeguridad.requestFocus();
    }

    @FXML
    void nombreBancoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            cbTipoTarjeta.requestFocus();
    }

    @FXML
    void numeroTarjetaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            tfFechaVencimiento.requestFocus();
    }

    @FXML
    void realizarPagoAction(ActionEvent event) {
        try {
            realizarPago();
        } catch (ValorRequeridoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    private void realizarPago() throws ValorRequeridoException {
        String numeroTarjeta = tfNumeroTarjeta.getText();
        String fechaVencimiento = tfFechaVencimiento.getText();
        String codigoSeguridad = pfCodigoSeguridad.getText();
        String nombreBanco = tfNombreBanco.getText();
        MetodoAutorizacion metodoAutorizacion = cbTipoTarjeta.getValue();
        String valorPago = cbValorPago.getValue();
        double monto = 0;

        if (numeroTarjeta.isEmpty()) throw new ValorRequeridoException("El valor numero tarjeta es requerido");
        if (fechaVencimiento.isEmpty()) throw new ValorRequeridoException("El valor fecha vencimiento es requerido");
        if (codigoSeguridad.isEmpty()) throw new ValorRequeridoException("El valor codigo seguridad es requerido");
        if (nombreBanco.isEmpty()) throw new ValorRequeridoException("El valor nombre banco es requerido");
        if (metodoAutorizacion == null) throw new ValorRequeridoException("El valor tipo tarjeta es requerido");
        if (valorPago == null) throw new ValorRequeridoException("El valor valor pago es requerido");

        if (valorPago.equals("50%"))
            monto = pedido.getTotal() * 0.5;
        else
            monto = pedido.getTotal() * 1;

        Pago pago = new Pago(monto, EstadoPago.COMPLETADO, numeroTarjeta, fechaVencimiento, codigoSeguridad, nombreBanco, metodoAutorizacion, cliente, pedido);

        try {
            panaderia.crearPedido(pedido);
            cliente.getListaPedidos().add(pedido);
            pedido.setPago(pago);
            modelFactoryController.iniciarSalvarDatosPrueba();
        } catch (PedidoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarDireccionEnvio(cliente, pedido);
    }

    @FXML
    void tipoTarjetaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            btnRealizarPago.fire();
    }

    public void setApplication(Application application, Cliente cliente, Pedido pedido) {
        this.application = application;
        this.cliente = cliente;
        this.pedido = pedido;
        lblTotalPagar.setText(String.valueOf(pedido.getTotal() + 10000 + "$"));
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        panaderia = modelFactoryController.getPanaderia();

        cbTipoTarjeta.getItems().setAll(MetodoAutorizacion.values());
        cbTipoTarjeta.setPromptText("Seleccionar");

        cbValorPago.getItems().setAll(List.of("50%", "100%"));
        cbValorPago.setPromptText("Seleccionar");
    }
}
