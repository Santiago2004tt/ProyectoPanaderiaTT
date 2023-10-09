package com.proyect.proyectopanaderiatt.Application;

import com.proyect.proyectopanaderiatt.controllers.CrearCuentaController;
import com.proyect.proyectopanaderiatt.controllers.IniciarSecionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        mostrarVentanaLogin();
    }

    private void mostrarVentanaLogin() {
        try {
            stage.close();
            stage = new Stage();
            //Loader lee cada línea de código y la vuelve objetos en memoria
            FXMLLoader loader = new FXMLLoader();
            //Dirección del paquete donde está la interfaz
            loader.setLocation(Application.class.getResource("/views/iniciar-sesion.fxml"));
            AnchorPane rootLayout = loader.load();
            //Carga los controladores
            //CrearCuentaController controller = loader.getController();//Obtenemos el controlador
            //controller.setApplication(this);
            Scene scene = new Scene(rootLayout);//Carga la escena Principal. En este caso carga el anchor-pane
            // de cambiar de ventana con escape
            stage.setScene(scene);//Al escenario principal se le dice que cargue la escena
            stage.show();//Muestra el escenario principal
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}