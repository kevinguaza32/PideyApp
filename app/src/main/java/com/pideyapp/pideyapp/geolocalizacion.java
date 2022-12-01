package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class geolocalizacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geolocalizacion);
    }

    public void RegresarMensajeCerrarSesion(View view){
        Intent regresarMensajeCerrarSesions = new Intent(geolocalizacion.this,mensajeCerrarSesion.class);
        startActivity(regresarMensajeCerrarSesions);
    }

    public void MenuRestaurante(View view){
        Intent menuRestaurantes = new Intent(geolocalizacion.this,activvity_nombreRestaurantes.class);
        startActivity(menuRestaurantes);
    }



}