package com.aplication.interfaces.Iclases;

import com.aplication.interfaces.conexionBaseDatos.conexion;

import java.sql.Connection;

public interface AccederDato<T> {
    conexion conexionData = conexion.obtenerInstancia();
    Connection conexionBD = conexionData.conectarBD();

    void introducirDatos();
    void eliminarDatos();
    void modificarDatos();
    void mostrarDatos();
}
