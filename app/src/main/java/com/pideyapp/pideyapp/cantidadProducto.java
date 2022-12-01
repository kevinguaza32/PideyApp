package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cantidadProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantidad_producto);
    }

    public void RegresarOrdene(View view){
        Intent regresarOrdenes = new Intent(cantidadProducto.this,NombreRestaurantesActivity.class);
        startActivity(regresarOrdenes);
    }


}