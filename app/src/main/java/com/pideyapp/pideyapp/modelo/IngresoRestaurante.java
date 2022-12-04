package com.pideyapp.pideyapp.modelo;

public class IngresoRestaurante {

    private String email;
    private  String contraseña;

    public IngresoRestaurante () {



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
        return "IngresoRestaurante{" +
                "email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
