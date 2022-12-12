package com.pideyapp.pideyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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

        listarDatos();

        list_Carta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cartasSelected = (Carta) adapterView.getItemAtPosition(i);
                nombrePlato.setText(cartasSelected.getNombrePlato());
                referencia.setText(cartasSelected.getReferencia());
                descripcion.setText(cartasSelected.getDescripcion());
                precio.setText(cartasSelected.getPrecio());
            }
        });

    }


    public void PedidosRestaurante(View view) {
        Intent pedidosRestaurantes = new Intent(cartaDelDia.this,NombreRestaurantesActivity.class);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        String nombreplatos = nombrePlato.getText().toString();
        String referencias = referencia.getText().toString();
        String descripcions = descripcion.getText().toString();
        String precios = precio.getText().toString();
        switch (item.getItemId()) {
            case R.id.icono_nuevo:
                if (nombreplatos.isEmpty() || (referencias.isEmpty()) || (descripcions.isEmpty()) || (precios.isEmpty())) {
                    validacion();
                } else {

                    Carta objCarta = new Carta();
                    objCarta.setNombrePlato(nombreplatos);
                    objCarta.setReferencia(referencias);
                    objCarta.setDescripcion(descripcions);
                    objCarta.setPrecio(precios);
                    databaseReference.child("carta").child(objCarta.getNombrePlato()).setValue(objCarta);
                    Toast.makeText(this, "registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    limpiarcajas();

                }
                break;

            case R.id.icono_actualizar:
                Toast.makeText(this, "Se presiono el boton actualizar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.icono_eliminar:
                Toast.makeText(this, "Se presiono el boton eliminar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.icono_regresar:
                Toast.makeText(this, "Se presioo el boton regresar", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void limpiarcajas() {
        nombrePlato.setText("");
        referencia.setText("");
        descripcion.setText("");
        precio.setText("");
    }

    public void validacion() {
        String nombreplatos = nombrePlato.getText().toString();
        String referencias = referencia.getText().toString();
        String descripcions = descripcion.getText().toString();
        String precios = precio.getText().toString();

        if (nombreplatos.isEmpty()) {
            nombrePlato.setError("Requerido");
        } else if (referencias.isEmpty()) {
            referencia.setError("Requerido");
        } else if (descripcions.isEmpty()) {
            descripcion.setError("Requerido");
        } else if (precios.isEmpty()) {
            precio.setError("Requerido");
        }
    }
        public void listarDatos () {
            databaseReference.child("carta").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                 listCarta.clear();
                 for (DataSnapshot objsnapshot: snapshot.getChildren()){
                     Carta e = objsnapshot.getValue(Carta.class);
                     listCarta.add(e);
                     arrayAdapterCarta = new ArrayAdapter<Carta>(cartaDelDia.this, android.R.layout.simple_list_item_1, listCarta);
                     list_Carta.setAdapter(arrayAdapterCarta);
                 }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }




}