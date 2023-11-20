package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class RegistroClienteController {

    Application application;
    ModelFactoryController modelFactoryController;
    Image imageAux;
    Cliente cliente = new Cliente();
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private Button btnSiguiente;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfCedula;

    @FXML
    private TextField tfDireccion;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;

    @FXML
    void apellidoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfCedula.requestFocus();
        }
    }

    @FXML
    void cedulaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfTelefono.requestFocus();
        }
    }

    @FXML
    void direccionReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSiguiente.fire();
        }
    }

    @FXML
    void emailReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfDireccion.requestFocus();
        }
    }

    @FXML
    void iniciarSesionAction(ActionEvent event) {
        application.mostrarVentanaLogin();
    }

    @FXML
    void nombreReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfApellido.requestFocus();
        }
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarVentanaLogin();
    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {
        seleccionarImagen();
    }

    @FXML
    void siguienteAction(ActionEvent event) {
        siguiente();
    }

    private void siguiente() {
        String nombre = tfNombre.getText();
        String apellido = tfApellido.getText();
        String cedula = tfCedula.getText();
        String telefono = tfTelefono.getText();
        String email = tfEmail.getText();
        String direccion = tfDireccion.getText();
        if(verificarEspacios(nombre,apellido,cedula,telefono,email,direccion)){
            if (verificarCorreo(email) && verificarCedula(cedula) && verificarTelefono(telefono)){
                if (modelFactoryController.verificarExisteCliente(cedula)) {
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setCedula(cedula);
                    cliente.setTelefono(telefono);
                    cliente.setEmail(email);
                    cliente.setDireccion(direccion);
                    cliente.setFoto(imageAux.getUrl());
                    application.mostrarCrearCuenta(cliente);
                } else {
                    MensajeUtil.mensajeAlerta("Alerta", "El cliente ya existe");
                }
            }
        }else{
            MensajeUtil.mensajeAlerta("Error", "Un campo esta incompleto");
        }
    }

    private boolean verificarTelefono(String telefono) {
        if( telefono.length() == 10){
            if(isNumeric(telefono)){
                return true;
            }
        }
        MensajeUtil.mensajeAlerta("Error", "El telefono no es valido");
        return false;
    }

    private boolean verificarCedula(String cedula) {
        if(isNumeric(cedula)){
            return true;
        }
        MensajeUtil.mensajeAlerta("Error", "Por favor añadir la cédula sin puntos o comas");
        return false;
    }

    private boolean isNumeric(String valor){
        boolean aux = false;
        try {
            // Intenta convertir la cadena a un número entero
            Double.parseDouble(valor);
            // Si la conversión es exitosa, la cadena es un número entero
            aux = true;
        } catch (NumberFormatException e) {
            aux = false;
        }
        return aux;
    }

    /**
     * metodo que verifique que es un correo
     * @param email
     * @return
     */
    private boolean verificarCorreo(String email) {
        if(email.contains("@") && email.contains(".") && !email.contains(" ")){
            return true;
        }
        MensajeUtil.mensajeAlerta("Error", "El correo no es valido");
        return false;
    }

    private boolean verificarEspacios(String nombre, String apellido, String cedula, String telefono, String email, String direccion) {
        if(nombre.equals("")){
            return false;
        }
        if(apellido.equals("")){
            return false;
        }
        if(cedula.equals("")){
            return false;
        }
        if(telefono.equals("")){
            return false;
        }
        if(email.equals("")){
            return false;
        }
        if(direccion.equals("")){
            return false;
        }
        if(imageAux == null){
            return false;
        }

        return true;
    }

    @FXML
    void telefonoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfEmail.requestFocus();
        }
    }

    @FXML
    void initialize() {
        this.modelFactoryController = ModelFactoryController.getInstance();
    }

    public void setApplication(Application application, Cliente cliente) {
        this.application = application;
        if(cliente != null){
            this.cliente = cliente;
            llenarDatos();
        }
    }

    private void llenarDatos() {
        tfNombre.setText(cliente.getNombre());
        tfApellido.setText(cliente.getApellido());
        tfCedula.setText(cliente.getCedula());
        tfTelefono.setText(cliente.getTelefono());
        tfEmail.setText(cliente.getEmail());
        tfDireccion.setText(cliente.getDireccion());
        imageAux = new Image(cliente.getFoto());
        ivImagen.setImage(imageAux);
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
}
