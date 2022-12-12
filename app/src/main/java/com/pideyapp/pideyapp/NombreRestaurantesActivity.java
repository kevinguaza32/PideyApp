package com.pideyapp.pideyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NombreRestaurantesActivity extends AppCompatActivity {

    private ImageView cerrarsesion;
    private TextView perfilname;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_restaurantes);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        cerrarsesion = (ImageView) findViewById(R.id.imvcerrarsesion);
        perfilname = (TextView) findViewById(R.id.txtnombrerestaurante);

        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(NombreRestaurantesActivity.this, MainActivityRestaurante.class));
                finish();

            }
        });

        getUserInfo();

    }

    private void getUserInfo() {


        String id = mAuth.getCurrentUser().getUid();
        databaseReference.child("registroRestaurante").child(id).addValueEventListener(new ValueEventListener()  {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("nombre").getValue().toString();

                    perfilname.setText(name);
                    ;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    // Botones movilidad dentro de la aplicacion--------------------------------------------------------

    public void CantidadProducto(View view) {
        Intent cantidadProductos = new Intent(NombreRestaurantesActivity.this, cantidadProducto.class);
        startActivity(cantidadProductos);
    }

    public void EnPreparacion(View view) {
        Intent enPreparacions = new Intent(NombreRestaurantesActivity.this, PreparacionProceso.class);
        startActivity(enPreparacions);
    }

    public void PorEntregar(View view) {
        Intent porEntregars = new Intent(NombreRestaurantesActivity.this, porEntregar.class);
        startActivity(porEntregars);
    }

    public void RegresarIncioSesion(View view) {
        Intent regresarIncioSesions = new Intent(NombreRestaurantesActivity.this, mensajeCerrarSesion.class);
        startActivity(regresarIncioSesions);
    }

    public void CartaDelDia(View view) {
        Intent cartaDelDias = new Intent(NombreRestaurantesActivity.this, cartaDelDia.class);
        startActivity(cartaDelDias);
    }
    // ---------------------------------- Fin botones//----------------------------------------------------

}