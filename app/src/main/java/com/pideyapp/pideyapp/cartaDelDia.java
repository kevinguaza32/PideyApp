package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class cartaDelDia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_del_dia);
    }

    public void InicioRun(View view) {
        Intent inicioRuns = new Intent(cartaDelDia.this, tipoUsuario.class);
        startActivity(inicioRuns);
    }


    public void PedidosRestaurante(View view) {
        Intent pedidosRestaurantes = new Intent(cartaDelDia.this, activvity_nombreRestaurantes.class);
        startActivity(pedidosRestaurantes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_registrocartadia,menu);
        return super.onCreateOptionsMenu(menu);

    }



}