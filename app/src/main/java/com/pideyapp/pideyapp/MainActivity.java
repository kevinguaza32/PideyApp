package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EscogerRestaurante(View view) {
        Intent escogerRestaurant = new Intent(MainActivity.this,geolocalizacion.class);
        startActivity(escogerRestaurant);
    }

    public void RegistrarUsuario(View view) {
        Intent registrarUsuarios = new Intent(MainActivity.this,RegisterUserActivity.class);
        startActivity(registrarUsuarios);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_registrousuario,menu);
        return super.onCreateOptionsMenu(menu);



    }







}