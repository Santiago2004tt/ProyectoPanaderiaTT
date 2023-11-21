package com.proyect.proyectopanaderiatt.controllers;
import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Pastel;
import com.proyect.proyectopanaderiatt.model.Pedido;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class HistorialController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pedido pedidoSeleccionado;
    ObservableList<Pedido> listaPedidosData = FXCollections.observableArrayList();


    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Pedido, Double> colTotal;

    @FXML
    private TableColumn<Pedido,String> colFechaEmision;

    @FXML
    private TableView<Pedido> tblPedidos;

    @FXML
    private Button btnAcceder;

    @FXML
    private TableColumn<Pedido, String > colId;

    @FXML
    void salir(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    @FXML
    void accederPedido(ActionEvent event) {
        accederPedidoAction();
    }

    private void accederPedidoAction() {
        if(pedidoSeleccionado!=null){
            application.mostrarDetallePedido(cliente,pedidoSeleccionado);
        }else {
            MensajeUtil.mensajeAlerta("Error","Selecciona un detalle para acceder");
        }
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        inicializarTabla();
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        actualizarTabla();
    }
    private void inicializarTabla() {
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colFechaEmision.setCellValueFactory(new PropertyValueFactory<>("fechaEmision"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        tblPedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            pedidoSeleccionado= newSelection;
        });
    }
    private void actualizarTabla() {
        listaPedidosData.clear();
        listaPedidosData.addAll(cliente.getListaPedidos());
        tblPedidos.setItems(listaPedidosData);
    }


}