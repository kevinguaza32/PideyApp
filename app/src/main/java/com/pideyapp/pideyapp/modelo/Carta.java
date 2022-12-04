package com.pideyapp.pideyapp.modelo;

public class Carta {
    // declaracion de variables

    private String nombrePlato;
    private String referencia;
    private String descripcion;
    private String precio;

    public Carta () {

    }

    // Encapsulacion


    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    // metodo toString

    @Override
    public String toString() {
        return "Carta{" +
                "nombrePlato='" + nombrePlato + '\'' +
                ", referencia='" + referencia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}



