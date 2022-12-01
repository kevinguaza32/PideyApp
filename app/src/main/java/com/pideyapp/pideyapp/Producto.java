package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }
    public void Tupedido(View view){
        Intent tuPedidos = new Intent(Producto.this,tuPedido.class);
        startActivity(tuPedidos);


    }
    public void RegresarRestauranteMenu(View view) {
        Intent regresarRestauranteMenus = new Intent(Producto.this,activvity_nombreRestaurantes.class);
        startActivity(regresarRestauranteMenus);
    }



}