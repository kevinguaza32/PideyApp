package com.pideyapp.pideyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class mensajeCerrarSesion extends AppCompatActivity {


    private Button cerrar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_cerrar_sesion);


        mAuth = FirebaseAuth.getInstance();
        cerrar = (Button) findViewById(R.id.btncerrarloginR);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(mensajeCerrarSesion.this, tipoUsuario.class));
                finish();

            }
        });


    }

}