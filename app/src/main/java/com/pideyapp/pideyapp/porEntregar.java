package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class porEntregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_entregar);
    }

    public void PorEntregarPorAceptar(View view){
        Intent porEntregarPorAceptars = new Intent(porEntregar.this,NombreRestaurantesActivity.class);
        startActivity(porEntregarPorAceptars);
    }

    public void PorEntregarEnPreparacion(View view){
        Intent porEntregarEnPreparacions = new Intent(porEntregar.this,PreparacionProceso.class);
        startActivity(porEntregarEnPreparacions);
    }


}