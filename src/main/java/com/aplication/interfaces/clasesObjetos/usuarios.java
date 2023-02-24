package com.aplication.interfaces.clasesObjetos;

public class usuarios
{
    private int idusuario;
    private int idroles;
    private String usario;
    private String password;

    public usuarios(){

    }
    public usuarios(int idusuario, int idroles, String usario, String password) {
        this.idusuario = idusuario;
        this.idroles = idroles;
        this.usario = usario;
        this.password = password;
    }

    public usuarios(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public int getIdroles() {
        return idroles;
    }

    public String getUsario() {
        return usario;
    }

    public String getPassword() {
        return password;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setIdroles(int idroles) {
        this.idroles = idroles;
    }

    public void setUsario(String usario) {
        this.usario = usario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
