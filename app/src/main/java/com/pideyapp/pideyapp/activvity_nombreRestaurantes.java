package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activvity_nombreRestaurantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activvity_nombre_restaurantes);
    }

    public void Prodcuto(View view){
        Intent productos = new Intent(activvity_nombreRestaurantes.this,Producto.class);
        startActivity(productos);
    }
    public void RegresarBrestaurante(View view) {
        Intent regresarBrestaurantes = new Intent(activvity_nombreRestaurantes.this, geolocalizacion.class);
        startActivity(regresarBrestaurantes);
    }
}