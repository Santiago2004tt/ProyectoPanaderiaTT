package com.proyect.proyectopanaderiatt.Application;

import com.proyect.proyectopanaderiatt.controllers.*;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.model.PQRS;
import com.proyect.proyectopanaderiatt.model.DetallePedido;
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

    public void mostrarCatalogoConVerificacion(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/catalogo.fxml"));
            AnchorPane rootLayout = loader.load();
            CatalogoController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            controller.verificarRespaldo();
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

    public void mostrarCarrito(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/carrito.fxml"));
            AnchorPane rootLayout = loader.load();
            CarritoController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarDireccionEnvio(Cliente cliente, Pedido pedido){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/direccion-envio.fxml"));
            AnchorPane rootLayout = loader.load();
            DireccionEnvioController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pedido);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPagoPedido(Cliente cliente, Pedido pedido){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/pago-pedido.fxml"));
            AnchorPane rootLayout = loader.load();
            PagoPedidoController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pedido);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarHistorial(Cliente cliente){
      try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/historial.fxml"));
            AnchorPane rootLayout = loader.load();
            HistorialController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  
    public void mostrarPqrs(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/pqrs.fxml"));
            AnchorPane rootLayout = loader.load();
            PqrsController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  
    public void mostrarHistorialPqrs(Cliente cliente){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/historial-pqrs.fxml"));
            AnchorPane rootLayout = loader.load();
            HistorialPqrsController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  
  
    public void mostrarDetallePedido(Cliente cliente, Pedido pedido){
            loader.setLocation(Application.class.getResource("/views/detalle-pedido.fxml"));
            AnchorPane rootLayout = loader.load();
            DetallePedidoController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pedido);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarDetallePqrs(Cliente cliente, PQRS pqrs){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/views/detalle-pqrs.fxml"));
            AnchorPane rootLayout = loader.load();
            DetallePqrsController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente, pqrs);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void mostrarFavoritos(Cliente cliente) {
            loader.setLocation(Application.class.getResource("/views/favoritos.fxml"));
            AnchorPane rootLayout = loader.load();
            FavoritosController controller = loader.getController();//Obtenemos el controlador
            controller.setApplication(this, cliente);
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