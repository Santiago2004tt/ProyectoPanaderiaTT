package com.proyect.proyectopanaderiatt.Application;

import com.proyect.proyectopanaderiatt.controllers.*;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.Pastel;
import com.proyect.proyectopanaderiatt.model.Pedido;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        mostrarVentanaLogin();
    }

    public void mostrarVentanaLogin() {
        try {
            stage.close();
            stage = new Stage();
            //Loader lee cada línea de código y la vuelve objetos en memoria
            FXMLLoader loader = new FXMLLoader();
            //Dirección del paquete donde está la interfaz
            loader.setLocation(Application.class.getResource("/views/iniciar-sesion.fxml"));
            AnchorPane rootLayout = loader.load();
            //Carga los controladores
            IniciarSecionController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this);
            Scene scene = new Scene(rootLayout);//Carga la escena Principal. En este caso carga el anchor-pane
            // de cambiar de ventana con escape
            stage.setScene(scene);//Al escenario principal se le dice que cargue la escena
            stage.show();//Muestra el escenario principal
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarRegistroCliente(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/registro-cliente.fxml"));
            AnchorPane rootLayout = loader.load();
            RegistroClienteController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarCrearCuenta(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/crear-cuenta.fxml"));
            AnchorPane rootLayout = loader.load();
            CrearCuentaController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPerfil(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/perfil-cliente.fxml"));
            AnchorPane rootLayout = loader.load();
            PerfilClienteController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrarMenuDisenio(Cliente cliente, Pastel pastel){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/menu-disenio.fxml"));
            AnchorPane rootLayout = loader.load();
            MenuDisenioController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pastel);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarRecuperarContrasenia(){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/recuperar-contrasenia.fxml"));
            AnchorPane rootLayout = loader.load();
            RecuperarContraseniaController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarCatalogo(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/catalogo.fxml"));
            AnchorPane rootLayout = loader.load();
            CatalogoController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarFactura(Cliente cliente, Pedido pedido){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/factura.fxml"));
            AnchorPane rootLayout = loader.load();
            FacturaController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pedido);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}