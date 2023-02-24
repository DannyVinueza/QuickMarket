package com.aplication.interfaces.conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static  Connection conecionBD(){
        Connection con = null;
        String nameBD = "quickmarket";
        String url = "jdbc:mysql://localhost:3306/" + nameBD;
        String user = "root";
        String password = "Danny.2002";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
        }
        return con;
    }
}
