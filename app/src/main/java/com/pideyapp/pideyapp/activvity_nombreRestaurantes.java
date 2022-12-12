package com.pideyapp.pideyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activvity_nombreRestaurantes extends AppCompatActivity {


    private ImageView cerrarsesion;
    FirebaseAuth mAutho;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activvity_nombre_restaurantes);

        mAutho = FirebaseAuth.getInstance();

        cerrarsesion = (ImageView) findViewById(R.id.imagecerrarsesion);

        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAutho.signOut();
                startActivity(new Intent(activvity_nombreRestaurantes.this, tipoUsuario.class));
                finish();

            }
        });

    }



    // Botones --------------------------------------------------------------------------------

    public void Prodcuto(View view){
        Intent productos = new Intent(activvity_nombreRestaurantes.this,Producto.class);
        startActivity(productos);
    }
    public void RegresarBrestaurante(View view) {
        Intent regresarBrestaurantes = new Intent(activvity_nombreRestaurantes.this, geolocalizacion.class);
        startActivity(regresarBrestaurantes);
    }
}