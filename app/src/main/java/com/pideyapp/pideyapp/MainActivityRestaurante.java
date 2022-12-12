package com.pideyapp.pideyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivityRestaurante extends AppCompatActivity {


    private EditText correo;
    private EditText contrasena;
    private Button login;

    private String emails = "";
    private String passwords = "";

    private FirebaseAuth mAuth;

    public void RegistrarRestaurante(View view){
        Intent registrarRestaurantes = new Intent(MainActivityRestaurante.this,RegisterRestaurantActivity.class);
        startActivity(registrarRestaurantes);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restaurante);

        mAuth = FirebaseAuth.getInstance();

        correo = (EditText) findViewById(R.id.editTexcorreo);
        contrasena = (EditText) findViewById(R.id.editTextcontrasena);
        login = (Button) findViewById(R.id.btnlogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emails = correo.getText().toString();
                passwords = contrasena.getText().toString();

                if (!emails.isEmpty() && !passwords.isEmpty() ) {
                    loginUser();
                }else {
                    Toast.makeText(MainActivityRestaurante.this, "Complete los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void loginUser () {

        mAuth.signInWithEmailAndPassword(emails, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    startActivity(new Intent(MainActivityRestaurante.this, NombreRestaurantesActivity.class));
                    finish();

                } else {
                    Toast.makeText(MainActivityRestaurante.this, " Usuario o contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivityRestaurante.this, NombreRestaurantesActivity.class));
            finish();
        }
    }



}