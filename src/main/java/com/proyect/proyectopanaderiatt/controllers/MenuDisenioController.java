package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.*;
import com.proyect.proyectopanaderiatt.util.BodyEmailUtil;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Tamano;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Random;


public class MenuDisenioController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Image imageAux;
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private ComboBox<SaborBizcocho> cbSaborBizcocho;

    @FXML
    private ComboBox<SaborRelleno> cbSaborRelleno;

    @FXML
    private ComboBox<TipoTorta> cbTipoTorta;

    @FXML
    private CheckBox chbDescripcion;

    @FXML
    private TableColumn<Tamano, Boolean> colSeleccionar;

    @FXML
    private TableColumn<Tamano, String> colTamanio;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private TableView<Tamano> tblPisos;


    private ObservableList<Tamano> tamanoData = FXCollections.observableArrayList();

    public ObservableList<Tamano> getTamanoData() {
        for (Tamano tamano : Tamano.values()) {
            tamano.setSeleccionado(false);
        }
        tamanoData.addAll(Tamano.values());
        return tamanoData;
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
    }

    @FXML
    void aceptarAction(ActionEvent event) {
        aceptar();
    }

    private void aceptar() {
        String email = cliente.getEmail();
        if (verificar()) {
            if (email.isEmpty()) {
                MensajeUtil.mensajeAlerta("Alerta", "EL campo email es requerido");
                return;
            }
            if (!(email.contains("@") && email.contains(".") && !email.contains(" "))) {
                MensajeUtil.mensajeAlerta("Error", "El correo no es valido");
                return;
            }
            String nombreCliente = cliente.getNombre() + " " + cliente.getApellido();


            // Asegurarse de que el número tenga exactamente 4 dígitos
            String mensaje = "El pedido se a realizado";

            String cuerpo = BodyEmailUtil.emailPedido(nombreCliente, mensaje);

            if (modelFactoryController.enviarEmail(email, "Realizacion de pedido", cuerpo)) {
                application.mostrarPerfil(cliente);
            } else {
                MensajeUtil.mensajeAlerta("Alerta", "Ocurrio un error al enviar el mensaje");
            }
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "Faltan datos por rellenar");
        }
    }

    private boolean verificar() {
        if(cbSaborRelleno.getValue() == null){
            return false;
        }
        if(cbSaborBizcocho.getValue() == null){
            return false;
        }
        if(cbTipoTorta.getValue() == null){
            return false;
        }
        if(tomarSeleccionados().isEmpty()){
            return false;
        }
        return true;
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {
        seleccionarImagen();
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();

        cbTipoTorta.getItems().setAll(TipoTorta.values());
        cbSaborBizcocho.getItems().setAll(SaborBizcocho.values());
        cbSaborRelleno.getItems().setAll(SaborRelleno.values());

        tblPisos.setItems(getTamanoData());

        colTamanio.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colSeleccionar.setCellValueFactory(new PropertyValueFactory<>("seleccionado"));
        colSeleccionar.setCellFactory(new Callback<TableColumn<Tamano, Boolean>, TableCell<Tamano, Boolean>>() {
            @Override
            public TableCell<Tamano, Boolean> call(TableColumn<Tamano, Boolean> tamanosBooleanTableColumn) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Boolean aBoolean, boolean b) {
                        super.updateItem(aBoolean, b);
                        if (aBoolean != null) {
                            CheckBox checkBox = new CheckBox();
                            checkBox.setSelected(aBoolean);
                            checkBox.selectedProperty().addListener((ons, oldValue, newValue) -> {
                                if (getTableRow() != null && getTableRow().getItem() != null) {
                                    Tamano tamano = getTableRow().getItem();
                                    // Ahora puedes acceder a la variable "tamanos" y modificarla
                                    tamano.setSeleccionado(newValue);
                                }
                            });
                            setGraphic(checkBox);
                        }
                    }
                };
            }
        });

        chbDescripcion.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                btnSeleccionarImagen.setDisable(false);
                taDescripcion.setDisable(false);
            } else {
                btnSeleccionarImagen.setDisable(true);
                taDescripcion.setDisable(true);
            }
        });
    }

    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la búsqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        //Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(btnSeleccionarImagen.getScene().getWindow());

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            ivImagen.setImage(image);  //Se llama al objeto de tipo ImagenView y se muestra
            this.imageAux=image;
        }
    }

    private ArrayList<Tamano> tomarSeleccionados() {
        ArrayList<Tamano> seleccionados = new ArrayList<>();
        ObservableList<Tamano> lista = tblPisos.getItems();
        for (Tamano tamano : lista) {
            if (tamano.isSeleccionado()) {
                seleccionados.add(tamano);
            }
        }
        return seleccionados;
    }

}
