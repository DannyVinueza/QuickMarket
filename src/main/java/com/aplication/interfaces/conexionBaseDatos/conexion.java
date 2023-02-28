package com.aplication.interfaces.conexionBaseDatos;

import com.aplication.interfaces.Iclases.ConectarBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion implements ConectarBD {

    private static final String NAMEBD = "quickmarket";
    private static final String URL = "jdbc:mysql://localhost:3306/" + NAMEBD;

    private static final String USER = "root";
    private static final String PASSWORD = "Danny.2002";
    private static conexion instancia;
    private Connection cone ;

    private conexion(){

    }

    @Override
    public Connection conectarBD(){
        try{
            cone = DriverManager.getConnection(URL, USER, PASSWORD);
            return cone;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cerrarConexionBD(){
        try{
            cone.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static conexion obtenerInstancia(){
        if(instancia == null){
            instancia = new conexion();
        }
        return instancia;
    }
    /*public static  Connection conecionBD(){
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
    }*/
}
