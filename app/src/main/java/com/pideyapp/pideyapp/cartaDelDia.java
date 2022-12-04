package com.pideyapp.pideyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pideyapp.pideyapp.modelo.Carta;

import java.util.ArrayList;
import java.util.List;

public class cartaDelDia extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private EditText nombrePlato;
    private EditText referencia;
    private EditText descripcion;
    private EditText precio;
    private ListView list_Carta;

    private final List <Carta> listCarta = new ArrayList<>();
    ArrayAdapter <Carta> arrayAdapterCarta;
    Carta cartasSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_del_dia);
        nombrePlato = (EditText) findViewById(R.id.txtnombreplato);
        referencia = (EditText) findViewById(R.id.txtreferencia);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);
        precio = (EditText) findViewById(R.id.txtprecio);
        list_Carta = (ListView) findViewById(R.id.listaplatosdia);
        inicializarBD();
    }


    public void InicioRun(View view) {
        Intent inicioRuns = new Intent(cartaDelDia.this, tipoUsuario.class);
        startActivity(inicioRuns);
    }


    public void PedidosRestaurante(View view) {
        Intent pedidosRestaurantes = new Intent(cartaDelDia.this, activvity_nombreRestaurantes.class);
        startActivity(pedidosRestaurantes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_registrocartadia,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void inicializarBD() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(this, "inicializando base de datos", Toast.LENGTH_SHORT).show();

    }

    public boolean onoptionsItemSelected(MenuItem item) {

        String nombreplatos = nombrePlato.getText().toString();
        String referencias = referencia.getText().toString();
        String descripcions = descripcion.getText().toString();
        String precios = precio.getText().toString();

    }








}