package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityRestaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restaurante);
    }

    public void RegistrarRestaurante(View view){
        Intent registrarRestaurantes = new Intent(MainActivityRestaurante.this,RegisterRestaurantActivity.class);
        startActivity(registrarRestaurantes);
    }

    public void IniciarsesionNombrerestactivity(View view){
        Intent iniciarsesionNombrerestactivitys = new Intent(MainActivityRestaurante.this,cartaDelDia.class);
        startActivity(iniciarsesionNombrerestactivitys);
    }

}