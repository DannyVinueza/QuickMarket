package com.aplication.interfaces.controladores;

import com.aplication.interfaces.conexionBaseDatos.conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class login implements Initializable{
    @FXML
    public ComboBox<String> roles;
    @FXML
    public PasswordField password;
    public TextField usuario;
    public Button login;
    @FXML
    private Label rolEscogido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection conBD = conexion.conecionBD(); // Obtención de la conexión a la base de datos
        String consulta = "SELECT * FROM roles";
        try {
            Statement stm = conBD.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while (rs.next()) {
                roles.getItems().add(rs.getString("nombres"));
            }

            rs.close();
            stm.close();
            conBD.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }

        // Agregar listener al ComboBox
        roles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observarRol, String posibleRol, String rolOb) {
                if (rolOb.equals("Administrador")) {
                    rolEscogido.setText("Administrador");
                } else {
                    rolEscogido.setText("Cajero");
                }
            }
        });
    }

    public void ingresar(ActionEvent actionEvent) {
        usuario.setText("Hola mundo");
        String rol = roles.getSelectionModel().getSelectedItem();
        System.out.println(rol);
        if(rol != null){
            if(rol.equals("Administrador")){
                System.out.println("Hola Administrador");
            } else if (rol.equals("Cajero")) {
                System.out.println("Hola cajero");
            }
        }else{
            rolEscogido.setText("Seleccione un rol...");
        }

    }

}