package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.DetallePedido;
import com.proyect.proyectopanaderiatt.model.Pastel;
import com.proyect.proyectopanaderiatt.model.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetallePedidoController {
    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pedido pedidoSeleccionado;
    DetallePedido detallePedidoSeleccionado;
    ObservableList<DetallePedido> listaDetallePedidosData = FXCollections.observableArrayList();


    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<DetallePedido, Double> colSubTotal;

    @FXML
    private Label lblTipoPastel;

    @FXML
    private Label lblSaborBizcocho;

    @FXML
    private Label lblSaborRelleno;

    @FXML
    private TableView<DetallePedido> tblDetallesPedidos;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TableColumn<DetallePedido, String> colId;

    @FXML
    void salir(ActionEvent event) {
        application.mostrarHistorial(cliente);
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        inicializarTabla();
    }

    private void inicializarTabla() {
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));

        tblDetallesPedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            detallePedidoSeleccionado= newSelection;
            if(detallePedidoSeleccionado!=null){
                mostrarInformacion(detallePedidoSeleccionado.getPastel());
            }
        });
    }

    private void mostrarInformacion(Pastel pastel) {
        Image image = new Image(pastel.getImagen());
        ivImagen.setImage(image);
        lblSaborBizcocho.setText(String.valueOf(pastel.getSaborBizcocho()));
        lblSaborRelleno.setText(String.valueOf(pastel.getSaborRelleno()));
        lblTipoPastel.setText(String.valueOf(pastel.getTipoTorta()));
    }

    public void setApplication(Application application, Cliente cliente, Pedido pedido) {
        this.application=application;
        this.cliente = cliente;
        this.pedidoSeleccionado=pedido;
        actualizarTabla();
    }

    private void actualizarTabla() {
        listaDetallePedidosData.clear();
        listaDetallePedidosData.addAll(pedidoSeleccionado.getListaDetallesPedido());
        tblDetallesPedidos.setItems(listaDetallePedidosData);
    }
}