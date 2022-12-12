package com.pideyapp.pideyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pideyapp.pideyapp.modelo.Carta;
import com.pideyapp.pideyapp.modelo.RegistroRestaurante;

import java.util.HashMap;
import java.util.Map;

public class RegisterRestaurantActivity extends AppCompatActivity {

    // {Funciones -------------------------------------------------------------------------
    public void limpiarcajas() {
        nombre.setText("");
        direccion.setText("");
        telefono.setText("");
        email.setText("");
        contraseña.setText("");
    }

    public void validacion() {
        String nombres = nombre.getText().toString();
        String direccions = direccion.getText().toString();
        String telefonos = telefono.getText().toString();
        String emails = email.getText().toString();
        String contraseñas = contraseña.getText().toString();

        if (nombres.isEmpty()) {
            nombre.setError("Requerido");
        } else if (direccions.isEmpty()) {
            direccion.setError("Requerido");
        } else if (telefonos.isEmpty()) {
            telefono.setError("Requerido");
        } else if (emails.isEmpty()) {
            email.setError("Requerido");
        } else if (contraseñas.isEmpty()){
            contraseña.setError("requerido");
        }
    }
    // --------------------------------------------------------- fin funciones}

    // Definicion de variables -----------------------------------------------------------

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;


    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    private EditText email;
    private EditText contraseña;
    private Button botoncrearcuenta;
    private CheckBox terminoAceptacion;
    //--------------------------------------------------------fin definicion de variables}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_restaurant);

        nombre = (EditText) findViewById(R.id.txtnombrerestaurante);
        direccion = (EditText) findViewById(R.id.txtdireccionrestaurante);
        telefono = (EditText) findViewById(R.id.txtTelefonoRestaurante);
        email = (EditText) findViewById(R.id.txtEmailrestaurante);
        contraseña = (EditText) findViewById(R.id.txtContraseñaRestaurante);
        botoncrearcuenta = (Button) findViewById(R.id.btnRegisterCrear3);
        terminoAceptacion = (CheckBox) findViewById(R.id.checkTerminos);


        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        botoncrearcuenta.setOnClickListener((view -> {

            String nombres = nombre.getText().toString();
            String direccions = direccion.getText().toString();
            String telefonos = telefono.getText().toString();
            String emails = email.getText().toString();
            String contraseñas = contraseña.getText().toString();
            String terminoAceptacions = terminoAceptacion.getText().toString();

            if (nombres.isEmpty() || (direccions.isEmpty()) || (telefonos.isEmpty()) || (emails.isEmpty()) || (contraseñas.isEmpty()) || (terminoAceptacions.isEmpty())) {

                validacion();
            } else {

                RegistroRestaurante objRegistroRestaurante = new RegistroRestaurante();
                objRegistroRestaurante.setNombre(nombres);
                objRegistroRestaurante.setDireccion(direccions);
                objRegistroRestaurante.setTelefono(telefonos);
                objRegistroRestaurante.setEmail(emails);
                objRegistroRestaurante.setContraseña(contraseñas);
                objRegistroRestaurante.setTerminoAceptacion(terminoAceptacions);

                    mAuth.createUserWithEmailAndPassword(emails,contraseñas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {

                                String id = mAuth.getCurrentUser().getUid();
                                databaseReference.child("registroRestaurante").child(id).setValue(objRegistroRestaurante);
                                Toast.makeText(RegisterRestaurantActivity.this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                                limpiarcajas();
                            }
                            finish();
                        }
                    });



            }}));

        }


    }




