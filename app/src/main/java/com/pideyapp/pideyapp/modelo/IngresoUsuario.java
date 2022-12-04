package com.pideyapp.pideyapp.modelo;

public class IngresoUsuario {

    private String email;
    private String contraseña;


    public  IngresoUsuario () {


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "IngresoUsuario{" +
                "email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
