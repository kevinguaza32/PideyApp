package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mensajeCerrarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_cerrar_sesion);
    }

    public void RegresarTipoUsuario(View view){
        Intent regresarTipoUsuarios = new Intent(mensajeCerrarSesion.this,tipoUsuario.class);
        startActivity(regresarTipoUsuarios);
    }

}