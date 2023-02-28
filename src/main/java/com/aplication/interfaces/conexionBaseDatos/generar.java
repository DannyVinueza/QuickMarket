package com.aplication.interfaces.conexionBaseDatos;

import com.aplication.interfaces.clasesObjetos.usuarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class generar {
    private conexion conBD = conexion.obtenerInstancia();
    private Connection conn = conBD.conectarBD();
    private Properties PRSQL;
    private usuarios uss;

    private Object objeto;
    private ArrayList<String> datosBD = new ArrayList<>();
    private ArrayList<Object> listaDatos = new ArrayList<>();

    private static Properties cargarArchivo() throws IOException{
        Properties pSql = new Properties();
        InputStream sqlArchivo = new FileInputStream("src/main/resources/com/example/interfaces/sentenciassql.properties");
        pSql.load(sqlArchivo);
        return pSql;
    }

    private void cargarClase(){
        if (objeto instanceof usuarios) {
            uss = (usuarios) objeto;
        }
    }

    public generar(Object obj) throws IOException {
        this.objeto = obj;
        PRSQL = cargarArchivo();
        cargarClase();
    }

    public generar() throws IOException {
        PRSQL = cargarArchivo();
    }

    public ArrayList consultarDatosUsuarios(ResultSet r) throws SQLException {
        listaDatos.add(new usuarios(
                r.getInt(1),
                r.getInt(2),
                r.getString(3),
                r.getString(4)
        ));
        return listaDatos;
    }
    public String generarSQLConsult() {
        if (objeto instanceof  usuarios ){
            return construirQueryConsultar("usuarios.consultar");
        }else{
            return null;
        }
    }

    private String construirQueryConsultar(String str) {
        String sql = PRSQL.getProperty(str);
        return sql;
    }
    private String construirQueryInsertar(String str) {
        String sql = PRSQL.getProperty(str);
        return sql;
    }

}
