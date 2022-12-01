package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mensajeConfirmacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_confirmacion);
    }

    public void RegresarTuPedido(View view){
        Intent regresarTuPedidos = new Intent(mensajeConfirmacion.this,tuPedido.class);
        startActivity(regresarTuPedidos);
    }

    public void FinalizaVovolverMenu(View view){
        Intent finalizaVovolverMenus = new Intent(mensajeConfirmacion.this,activvity_nombreRestaurantes.class);
        startActivity(finalizaVovolverMenus);
    }



}