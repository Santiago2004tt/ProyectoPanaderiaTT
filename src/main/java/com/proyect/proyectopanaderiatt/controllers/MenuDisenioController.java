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
import com.proyect.proyectopanaderiatt.model.Tamanos;
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
    private TableColumn<Tamanos, Boolean> colSeleccionar;

    @FXML
    private TableColumn<Tamanos, String> colTamanio;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private TableView<Tamanos> tblPisos;


    private ObservableList<Tamanos> tamanosData = FXCollections.observableArrayList(Tamanos.values());

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
        if(verificar()){
            if (email.isEmpty()) {
                MensajeUtil.mensajeAlerta("Alerta", "EL campo email es requerido");
                return;
            }
            if(!(email.contains("@") && email.contains(".") && !email.contains(" "))){
                MensajeUtil.mensajeAlerta("Error", "El correo no es valido");
                return;
            }
            String nombreCliente = cliente.getNombre() + " " + cliente.getApellido();


            // Asegurarse de que el número tenga exactamente 4 dígitos
           String mensaje = "El pedido se a realizado";

            String cuerpo = BodyEmailUtil.emailRecuperarContrasenia(nombreCliente, mensaje);

            if (modelFactoryController.enviarEmail(email, "Realizacion de pedido", cuerpo)) {
                application.mostrarPerfil(cliente);
            } else {
                MensajeUtil.mensajeAlerta("Alerta", "Ocurrio un error al enviar el mensaje");
            }
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
        tblPisos.setItems(tamanosData);
        colTamanio.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colSeleccionar.setCellValueFactory(new PropertyValueFactory<>("seleccionado"));
        colSeleccionar.setCellFactory(new Callback<TableColumn<Tamanos, Boolean>, TableCell<Tamanos, Boolean>>() {
            @Override
            public TableCell<Tamanos, Boolean> call(TableColumn<Tamanos, Boolean> tamanosBooleanTableColumn) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Boolean aBoolean, boolean b) {
                        super.updateItem(aBoolean, b);
                        if (aBoolean != null) {
                            CheckBox checkBox = new CheckBox();
                            checkBox.setSelected(aBoolean);
                            checkBox.selectedProperty().addListener((ons, oldValue, newValue) -> {
                                if (getTableRow() != null && getTableRow().getItem() != null) {
                                    Tamanos tamanos = getTableRow().getItem();
                                    // Ahora puedes acceder a la variable "tamanos" y modificarla
                                    tamanos.setSeleccionado(newValue);
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

    private ArrayList<Tamanos> tomarSeleccionados() {
        ArrayList<Tamanos> seleccionados = new ArrayList<>();
        ObservableList<Tamanos> lista = tblPisos.getItems();
        for (Tamanos tamano : lista) {
            if (tamano.isSeleccionado()) {
                seleccionados.add(tamano);
                System.out.println(tamano.getValor());
            }
        }
        return seleccionados;
    }

}
