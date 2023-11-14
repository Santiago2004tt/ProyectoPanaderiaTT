package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.DetallePedido;
import com.proyect.proyectopanaderiatt.model.Pastel;
import com.proyect.proyectopanaderiatt.model.Pedido;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CarritoController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;

    @FXML
    private Button btnRealizarCompra;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblEnvio;

    @FXML
    private Label lblPasteles;

    @FXML
    private Label lblTotal;

    @FXML
    private VBox vbPasteles;

    @FXML
    void realizarCompraAction(ActionEvent event) {
        if (cliente.getCarrito() == null) {
            MensajeUtil.mensajeAlerta("Alerta", "El carrito esta vacio");
            return;
        }
        application.mostrarDireccionEnvio(cliente, cliente.getCarrito());
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarCatalogo(cliente);
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        cargarCarrito();
    }

    private void cargarCarrito() {
        Pedido pedido = cliente.getCarrito();
        if (pedido == null) {
            return;
        }
        ArrayList<DetallePedido> detallesPedido = pedido.getListaDetallesPedido();
        ArrayList<HBox> filas = new ArrayList<>();
        for (DetallePedido detallePedido : detallesPedido) {
            filas.add(filaCarrito(detallePedido));
        }
        vbPasteles.getChildren().addAll(filas);
        vbPasteles.setSpacing(10);

        llenarFichaTotal(pedido);
    }

    private void llenarFichaTotal(Pedido pedido) {
        lblPasteles.setText(String.format("Pasteles (%s): %s$", pedido.getListaDetallesPedido().size(), pedido.getTotal()));
        lblEnvio.setText("Envio: " + 10000 + "$");
        lblTotal.setText("Total: " + (pedido.getTotal() + 10000) + "$");
    }

    private HBox filaCarrito(DetallePedido detallePedido) {
        Pastel pastel = detallePedido.getPastel();
        HBox fila = new HBox();
        fila.setSpacing(30);
        fila.setFillHeight(true);
        fila.setStyle("-fx-background-color: rgb(238,219,199)");

        Image imagen;
        if (pastel.getImagen() != null) {
            imagen = new Image(pastel.getImagen());
        } else {
            imagen = new Image(String.valueOf(getClass().getResource("/images/generico.jpeg")));
        }
        ImageView imageView = new ImageView(imagen);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        VBox vBox = new VBox(new Text("Precio: " + detallePedido.getSubTotal() + "$"));
        vBox.setAlignment(Pos.CENTER);

        fila.getChildren().add(imageView);
        fila.getChildren().add(vBox);

        return fila;
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
