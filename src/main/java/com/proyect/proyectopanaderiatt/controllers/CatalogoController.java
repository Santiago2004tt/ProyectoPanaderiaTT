package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Pastel;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class CatalogoController {

    Application application;
    ModelFactoryController modelFactoryController;
    Cliente cliente;

    @FXML
    private Button btnDerecha;

    @FXML
    private Button btnIzquierda;

    @FXML
    private Button btnRegresar;

    @FXML
    private HBox hBoxCatalogo;

    @FXML
    void derechaAction(ActionEvent event) {
        moveRight();
    }

    @FXML
    void izquierdaAction(ActionEvent event) {
        moveLeft();
    }

    @FXML
    void regresarAction(ActionEvent event) {

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
        int i = 0;
        for (Pastel pastel : getPastelesData()) {
            VBox contenedor = new VBox();
            contenedor.setAlignment(Pos.CENTER);
            contenedor.setStyle("-fx-background-color: lightblue");
            Image image = new Image(pastel.getImagen());
            ImageView imageView = new ImageView(image);
            int finalI = i;
            contenedor.setOnMouseClicked(x -> System.out.printf("click %s\n", finalI));
            contenedor.setCursor(Cursor.HAND);
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);
            contenedor.getChildren().add(imageView);
            contenedor.getChildren().add(new Text(++i + ""));
            contenedor.getChildren().add(new Text(pastel.getDescripcion()));
            vBoxes.add(contenedor);
        }
        return vBoxes;
    }
}
