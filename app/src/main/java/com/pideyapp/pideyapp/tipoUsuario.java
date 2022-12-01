package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tipoUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario);
    }
    public void SoyUsuario(View view){
        Intent soyUsuarios = new Intent(tipoUsuario.this,MainActivity.class);
        startActivity(soyUsuarios);
    }

    public void SoyRestaurante(View view) {
        Intent soyRestaurantes = new Intent(tipoUsuario.this, MainActivityRestaurante.class);
        startActivity(soyRestaurantes);
    }

}

