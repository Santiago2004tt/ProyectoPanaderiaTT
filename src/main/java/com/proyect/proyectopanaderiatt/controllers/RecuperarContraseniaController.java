package com.proyect.proyectopanaderiatt.controllers;

import com.proyect.proyectopanaderiatt.Application.Application;
import com.proyect.proyectopanaderiatt.model.Cliente;
import com.proyect.proyectopanaderiatt.util.BodyEmailUtil;
import com.proyect.proyectopanaderiatt.util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class RecuperarContraseniaController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnEnviarCodigo;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerificarCodigo;

    @FXML
    private PasswordField pfContrasenia;

    @FXML
    private PasswordField pfVerificarContrasenia;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfEmail;

    private Application application;

    private String codigo;
    private String email;

    private ModelFactoryController modelFactoryController;

    public void setApplication(Application application) {
        this.application = application;
    }

    @FXML
    void aceptarAction(ActionEvent event) {
        String contrasenia = pfContrasenia.getText();
        String verificarContrasenia = pfVerificarContrasenia.getText();
        if (contrasenia.isEmpty()) {
            MensajeUtil.mensajeAlerta("Alerta", "El campo contraseña es requerido");
            return;
        }
        if (verificarContrasenia.isEmpty()) {
            MensajeUtil.mensajeAlerta("Alerta", "El campo verificar contraseña es requerido");
            return;
        }
        if (!modelFactoryController.verificarContrasenaRequisitos(contrasenia)) {
            MensajeUtil.mensajeAlerta("Alerta", """
                    La contraseña tiene que ser mínimo de 8 caracteres\s
                    de longitud contener una minúscula, una mayúscula,\s
                    un número y un carácter especial""");
            return;
        }
        if (contrasenia.equals(verificarContrasenia)) {
            modelFactoryController.cambiarContrasenia(email, contrasenia);
            MensajeUtil.mensajeInformacion("Éxito", "La contraseña fue cambiada correctamente");
            application.mostrarVentanaLogin();
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "Las contraseñas no coinciden");
        }
    }

    @FXML
    void codigoReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnVerificarCodigo.fire();
        }
    }

    @FXML
    void contraseniaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pfVerificarContrasenia.requestFocus();
        }
    }

    @FXML
    void emailReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            tfCodigo.requestFocus();
        }
    }

    @FXML
    void enviarCodigoAction(ActionEvent event) {
        if (codigo != null) {
            MensajeUtil.mensajeAlerta("Alerta", "ya fue enviado un codigo");
            return;
        }
        email = tfEmail.getText();
        if (email.isEmpty()) {
            MensajeUtil.mensajeAlerta("Alerta", "EL campo email es requerido");
            return;
        }
        if(!(email.contains("@") && email.contains(".") && !email.contains(" "))){
            MensajeUtil.mensajeAlerta("Error", "El correo no es valido");
            return;
        }
        Cliente cliente = modelFactoryController.verificarEmail(email);
        if (cliente == null) {
            MensajeUtil.mensajeAlerta("Alerta", "EL correo no existe");
            return;
        }

        String nombreCliente = cliente.getNombre() + " " + cliente.getApellido();

        Random random = new Random();

        // Generar un número aleatorio de 4 dígitos
        int numeros = random.nextInt(10000);

        // Asegurarse de que el número tenga exactamente 4 dígitos
        codigo = String.format("%04d", numeros);

        String cuerpo = BodyEmailUtil.emailRecuperarContrasenia(nombreCliente, codigo);

        if (modelFactoryController.enviarEmail(email, "Recuperación de contraseña - Código de recuperación", cuerpo)) {
            tfCodigo.setDisable(false);
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "Ocurrio un error al enviar el mensaje");
        }
    }

    @FXML
    void regresarAction(ActionEvent event) {
        application.mostrarVentanaLogin();
    }

    @FXML
    void verificarCodigoAction(ActionEvent event) {
        String codigoIngresado = tfCodigo.getText();
        if (codigoIngresado.equals(codigo)) {
            pfContrasenia.setDisable(false);
            pfVerificarContrasenia.setDisable(false);
            tfCodigo.setDisable(true);
        } else {
            MensajeUtil.mensajeAlerta("Alerta", "El código es incorrecto");
        }
    }

    @FXML
    void verificarContraseniaReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnAceptar.fire();
        }
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
