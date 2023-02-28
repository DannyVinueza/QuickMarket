package com.aplication.interfaces.Iclases;

import java.sql.Connection;

public interface ConectarBD {
    Connection conectarBD();

    void cerrarConexionBD();
}
