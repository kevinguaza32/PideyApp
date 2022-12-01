package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tuPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_pedido);
    }

    public void RegresarProducto(View view){
        Intent eegresarProductos = new Intent(tuPedido.this,Producto.class);
        startActivity(eegresarProductos);
    }

    public void ConfirmacionPedido(View view){
        Intent confirmacionPedidos = new Intent(tuPedido.this,mensajeConfirmacion.class);
        startActivity(confirmacionPedidos);
    }

}