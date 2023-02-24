module com.aplication.quickmarket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.aplication.interfaces to javafx.fxml;
    exports com.aplication.interfaces;
    exports com.aplication.interfaces.controladores;
    opens com.aplication.interfaces.controladores to javafx.fxml;
}