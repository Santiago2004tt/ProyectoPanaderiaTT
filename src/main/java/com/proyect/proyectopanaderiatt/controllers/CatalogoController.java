package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Pastel;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.ArrayList;

public class CatalogoController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;

    @FXML
    private Button btnCarrito;

    @FXML
    private Button btnDerecha;

    @FXML
    private Button btnIzquierda;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnUsuario;

    @FXML
    private HBox hBoxCatalogo;

    @FXML
    private Label lblCantidadCarrito;

    @FXML
    void carritoAction(ActionEvent event) {
        application.mostrarCarrito(cliente);
    }

    @FXML
    void derechaAction(ActionEvent event) {
        moveRight();
    }

    @FXML
    void izquierdaAction(ActionEvent event) {
        moveLeft();
    }

    @FXML
    void pqrsAction(ActionEvent event) {
        application.mostrarPqrs(cliente);
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarVentanaLogin();
    }

    @FXML
    void usuarioAction(ActionEvent event) {
        application.mostrarPerfil(cliente);
    }

    private ObservableList<Pastel> pastelesData = FXCollections.observableArrayList();

    public ObservableList<Pastel> getPastelesData() {
        pastelesData.clear();
        pastelesData.addAll(modelFactoryController.getPanaderia().getListaPasteles());
        return pastelesData;
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        this.cliente = cliente;
        if (cliente.getCarrito() != null)
            lblCantidadCarrito.setText(String.valueOf(cliente.getCarrito().getListaDetallesPedido().size()));
    }

    private void moveLeft() {
        animate(-300);
    }

    private void moveRight() {
        animate(300);
    }

    /**
     * metodo que da la animacion y el movimiento al hbox
     *
     * @param delta
     */
    private void animate(double delta) {
        double tope = (hBoxCatalogo.getWidth() - 444);
        double currentPosition = Math.min(Math.max(-hBoxCatalogo.getTranslateX() + delta, 0), tope);

        if (currentPosition != hBoxCatalogo.getTranslateX()) {
            if (currentPosition == tope && hBoxCatalogo.getTranslateX() + delta != tope) {
                delta = tope + hBoxCatalogo.getTranslateX();
            } else if (currentPosition == 0 && hBoxCatalogo.getTranslateX() + delta != 0) {
                delta = hBoxCatalogo.getTranslateX();
            }
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), hBoxCatalogo);
            transition.setByX(-delta);
            transition.play();
        }
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        hBoxCatalogo.getChildren().addAll(inicializarPasteles());
    }

    private ArrayList<VBox> inicializarPasteles() {
        ArrayList<VBox> vBoxes = new ArrayList<>();
        for (Pastel pastel : getPastelesData()) {
            VBox contenedor = new VBox();
            contenedor.setAlignment(Pos.CENTER);
            contenedor.setStyle("-fx-background-color: lightblue");
            contenedor.setOnMouseClicked(x -> application.mostrarMenuDisenio(cliente, pastel));
            contenedor.setCursor(Cursor.HAND);

            Image image = new Image(pastel.getImagen());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);

            Text text = new Text(pastel.getDescripcion());
            text.setWrappingWidth(150);
            text.setTextAlignment(TextAlignment.CENTER);

            contenedor.getChildren().add(imageView);
            contenedor.getChildren().add(text);
            vBoxes.add(contenedor);
        }

        return vBoxes;
    }

    public void verificarRespaldo() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                if (cliente.getRespaldoPastel() != null) {
                    if (confirmacion("Se encontraron datos de un pedido sin terminar, desea continuar")) {
                        application.mostrarMenuDisenio(cliente, cliente.getRespaldoPastel());
                    } else {
                        cliente.setRespaldoPastel(null);
                        modelFactoryController.iniciarSalvarDatosPrueba();
                    }
                }
            }
            );
        }).start();
    }

    private boolean confirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        ButtonType resultado = alert.showAndWait().orElse(ButtonType.CANCEL);
        return resultado == ButtonType.OK;
    }
}
