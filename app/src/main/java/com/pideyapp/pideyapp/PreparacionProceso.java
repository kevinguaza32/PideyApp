package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PreparacionProceso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparacion_proceso);
    }

    public void EnPreparacionPorAceptar(View view){
        Intent enPreparacionPorAceptars = new Intent(PreparacionProceso.this,NombreRestaurantesActivity.class);
        startActivity(enPreparacionPorAceptars);
    }

    public void EnPreparacionPorEntregar(View view){
        Intent enPreparacionPorEntregars = new Intent(PreparacionProceso.this,porEntregar.class);
        startActivity(enPreparacionPorEntregars);
    }


}