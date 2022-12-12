package com.pideyapp.pideyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pideyapp.pideyapp.modelo.RegistroRestaurante;
import com.pideyapp.pideyapp.modelo.RegistroUsuario;

public class RegisterUserActivity extends AppCompatActivity {

    // {Funciones -------------------------------------------------------------------------
    public void limpiarcajas() {
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
        contraseña.setText("");
    }

    public void validacion() {
        String nombres = nombre.getText().toString();
        String apellidos = apellido.getText().toString();
        String telefonos = telefono.getText().toString();
        String emails = email.getText().toString();
        String contraseñas = contraseña.getText().toString();

        if (nombres.isEmpty()) {
            nombre.setError("Requerido");
        } else if (apellidos.isEmpty()) {
            apellido.setError("Requerido");
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
    private EditText apellido;
    private EditText telefono;
    private EditText email;
    private EditText contraseña;
    private Button botoncrearcuenta;
    private CheckBox terminoAceptacion;
    //--------------------------------------------------------fin definicion de variables}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        nombre = (EditText) findViewById(R.id.txtnombreUsuario);
        apellido = (EditText) findViewById(R.id.txtApellidoUsuario);
        telefono = (EditText) findViewById(R.id.txtTelefonoUsuario);
        email = (EditText) findViewById(R.id.txtEmailUsuario);
        contraseña = (EditText) findViewById(R.id.txtcontraseñaUsuario);
        botoncrearcuenta = (Button) findViewById(R.id.btnCrearUsuario);
        terminoAceptacion = (CheckBox) findViewById(R.id.chkTerminosUsuario);


        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        botoncrearcuenta.setOnClickListener((view -> {

            String nombres = nombre.getText().toString();
            String apellidos = apellido.getText().toString();
            String telefonos = telefono.getText().toString();
            String emails = email.getText().toString();
            String contrasenas = contraseña.getText().toString();

            if (nombres.isEmpty() || (apellidos.isEmpty()) || (telefonos.isEmpty()) || (emails.isEmpty()) || (contrasenas.isEmpty()))  {

                validacion();
            } else {

                RegistroUsuario objRegistroUsuario = new RegistroUsuario();
                objRegistroUsuario.setNombres(nombres);
                objRegistroUsuario.setApellidos(apellidos);
                objRegistroUsuario.setTelefono(telefonos);
                objRegistroUsuario.setEmail(emails);
                objRegistroUsuario.setContraseña(contrasenas);

                mAuth.createUserWithEmailAndPassword(emails,contrasenas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            String id = mAuth.getCurrentUser().getUid();
                            databaseReference.child("registroCliente").child(id).setValue(objRegistroUsuario);
                            Toast.makeText(RegisterUserActivity.this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                            limpiarcajas();
                            startActivity(new Intent(RegisterUserActivity.this, MainActivity.class));
                            finish();

                        }

                    }
                });



            }}));



    }
}