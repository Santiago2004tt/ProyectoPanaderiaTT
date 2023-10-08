module com.proyect.proyectopanaderiatt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyect.proyectopanaderiatt to javafx.fxml;
    exports com.proyect.proyectopanaderiatt.Application;
    opens com.proyect.proyectopanaderiatt.Application to javafx.fxml;
    exports com.proyect.proyectopanaderiatt.controllers;
    opens com.proyect.proyectopanaderiatt.controllers to javafx.fxml;
}