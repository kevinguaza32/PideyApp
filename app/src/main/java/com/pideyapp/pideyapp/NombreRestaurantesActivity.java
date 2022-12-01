package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NombreRestaurantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_restaurantes);
    }

    public void CantidadProducto(View view){
        Intent cantidadProductos = new Intent(NombreRestaurantesActivity.this,cantidadProducto.class);
        startActivity(cantidadProductos);
    }


    public void EnPreparacion(View view){
        Intent enPreparacions = new Intent(NombreRestaurantesActivity.this,PreparacionProceso.class);
        startActivity(enPreparacions);
    }

    public void PorEntregar(View view){
        Intent porEntregars = new Intent(NombreRestaurantesActivity.this,porEntregar.class);
        startActivity(porEntregars);
    }

    public void RegresarIncioSesion(View view){
        Intent regresarIncioSesions = new Intent(NombreRestaurantesActivity.this,mensajeCerrarSesion.class);
        startActivity(regresarIncioSesions);
    }


}