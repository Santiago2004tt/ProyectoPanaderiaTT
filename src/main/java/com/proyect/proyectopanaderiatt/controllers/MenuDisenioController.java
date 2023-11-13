package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.Exceptions.PedidoException;
import com.proyect.proyectopanaderiatt.model.*;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MenuDisenioController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;
    Pastel pastel;
    Image imageAux;

    @FXML
    private Button btnAgregarCarrito;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private ComboBox<Forma> cbFormaPastel;

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

    public void setApplication(Application application, Cliente cliente, Pastel pastel) {
        this.application = application;
        this.cliente = cliente;
        this.pastel = pastel;
        cargarDatos();
        respaldarPastel();
    }

    @FXML
    void agregarCarritoAction() {
        try {
            agregarCarrito();
        } catch (PedidoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    private void agregarCarrito() throws PedidoException {
        TipoTorta tipoTorta = cbTipoTorta.getValue();
        SaborBizcocho saborBizcocho = cbSaborBizcocho.getValue();
        SaborRelleno saborRelleno = cbSaborRelleno.getValue();
        Forma forma = cbFormaPastel.getValue();
        String descripcion = taDescripcion.getText();
        Image image = ivImagen.getImage();
        ArrayList<Tamano> seleccion = tomarSeleccionados();
        if (verificar()) {
            if (saborBizcocho == SaborBizcocho.TORTA_FRIA && seleccion.size() > 2)
                throw new PedidoException("La cantidad de pisos para el sabor de bizcocho de torta fria no puede ser mayor a 2");

            Pastel pastelComprar = capturarPastel(saborRelleno, tipoTorta, saborBizcocho, forma, descripcion, image, seleccion);
            DetallePedido detallePedido = new DetallePedido(pastelComprar);
            cliente.agreagarAlCarrito(detallePedido);
            MensajeUtil.mensajeInformacion("Exito", "Se agregó exitosamente el pastel al carrito");

            cliente.setRespaldoPastel(null);
            modelFactoryController.iniciarSalvarDatosPrueba();
            application.mostrarCatalogo(cliente);
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "Faltan datos por rellenar");
        }
    }

    @FXML
    void comprarAction(ActionEvent event) {
        try {
            comprar();
        } catch (PedidoException e) {
            MensajeUtil.mensajeAlerta("Alerta", e.getMessage());
        }
    }

    private void comprar() throws PedidoException {
        TipoTorta tipoTorta = cbTipoTorta.getValue();
        SaborBizcocho saborBizcocho = cbSaborBizcocho.getValue();
        SaborRelleno saborRelleno = cbSaborRelleno.getValue();
        Forma forma = cbFormaPastel.getValue();
        String descripcion = taDescripcion.getText();
        Image image = ivImagen.getImage();
        ArrayList<Tamano> seleccion = tomarSeleccionados();
        if (verificar()) {
            if (saborBizcocho == SaborBizcocho.TORTA_FRIA && seleccion.size() > 2)
                throw new PedidoException("La cantidad de pisos para el sabor de bizcocho de torta fria no puede ser mayor a 2");

            Pastel pastelComprar = capturarPastel(saborRelleno, tipoTorta, saborBizcocho, forma, descripcion, image, seleccion);

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            DetallePedido detallePedido = new DetallePedido(pastelComprar, pedido);
            pastelComprar.setPedido(pedido);
            pedido.getListaDetallesPedido().add(detallePedido);
            application.mostrarFactura(cliente, pedido);
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "Faltan datos por rellenar");
        }
    }

    private Pastel capturarPastel(SaborRelleno saborRelleno, TipoTorta tipoTorta, SaborBizcocho saborBizcocho, Forma forma,
                                  String descripcion, Image image, ArrayList<Tamano> seleccion) {
        Pastel pastel = new Pastel(saborRelleno, tipoTorta, saborBizcocho, forma);
        ArrayList<PisoPastel> pisosPastel = new ArrayList<>();
        for (int i = 0; i < seleccion.size(); i++) {
            pisosPastel.add(new PisoPastel(seleccion.get(i), 5 - i, this.pastel));
        }
        pastel.setListaPisoPasteles(pisosPastel);
        if (chbDescripcion.isSelected()) {
            String imagen;
            if (image != null)
                imagen = image.getUrl();
            else
                imagen = null;
            pastel.setDescripcion(descripcion);
            pastel.setImagen(imagen);
        }
        return pastel;
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
        if(cbFormaPastel.getValue() == null){
            return false;
        }
        if(tomarSeleccionados().isEmpty()){
            return false;
        }
        if (chbDescripcion.isSelected()) {
            if (taDescripcion.getText().isEmpty()) {
                return false;
            }
            if (ivImagen.getImage() == null) {
                return false;
            }
        }
        return true;
    }

    @FXML
    void regresarAction(ActionEvent event) {
        cliente.setRespaldoPastel(null);
        application.mostrarCatalogo(cliente);
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
        cbFormaPastel.getItems().setAll(Forma.values());

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
                                respaldarPastel();
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

        escuchadores();
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

    private void cargarDatos() {
        if (pastel == null) {
            return;
        }
        String imagen = pastel.getImagen();

        cbTipoTorta.getSelectionModel().select(pastel.getTipoTorta());
        cbSaborBizcocho.getSelectionModel().select(pastel.getSaborBizcocho());
        cbSaborRelleno.getSelectionModel().select(pastel.getSaborRelleno());
        cbFormaPastel.getSelectionModel().select(pastel.getForma());
        List<PisoPastel> pisos = pastel.getListaPisoPasteles();
        for (PisoPastel piso : pisos) {
            for (Tamano tamano : Tamano.values()) {
                if (piso.getTamano() == tamano)
                    tamano.setSeleccionado(true);
            }
        }
        if (pastel.getDescripcion() != null) {
            chbDescripcion.setSelected(true);
            taDescripcion.setText(pastel.getDescripcion());
            if (imagen != null) {
                ivImagen.setImage(new Image(imagen));
            }
        }
    }

    private void escuchadores() {

        ChangeListener<?> escuchador = (obs, oldValue, newValue) -> {
            respaldarPastel();
        };

        cbTipoTorta.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super TipoTorta>) escuchador);
        cbSaborBizcocho.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super SaborBizcocho>) escuchador);
        cbSaborRelleno.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super SaborRelleno>) escuchador);
        cbFormaPastel.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super Forma>) escuchador);

        chbDescripcion.selectedProperty().addListener((ChangeListener<? super Boolean>) escuchador);
        taDescripcion.selectionProperty().addListener((ChangeListener<? super IndexRange>) escuchador);
        ivImagen.imageProperty().addListener((ChangeListener<? super Image>) escuchador);
    }

    private void respaldarPastel() {
        TipoTorta tipoTorta = cbTipoTorta.getValue();
        SaborBizcocho saborBizcocho = cbSaborBizcocho.getValue();
        SaborRelleno saborRelleno = cbSaborRelleno.getValue();
        Forma forma = cbFormaPastel.getValue();
        ArrayList<Tamano> seleccion = tomarSeleccionados();

        String descripcion = taDescripcion.getText();
        Image image = ivImagen.getImage();

        Pastel pastel = capturarPastel(saborRelleno, tipoTorta, saborBizcocho, forma, descripcion, image, seleccion);

        cliente.setRespaldoPastel(pastel);
        modelFactoryController.iniciarSalvarDatosPrueba();
    }
}
