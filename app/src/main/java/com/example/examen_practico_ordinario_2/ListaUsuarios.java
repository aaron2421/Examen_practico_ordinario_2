package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaUsuarios extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Usuario> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        recyclerView = findViewById(R.id.listaUsuariosView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        datos = new ArrayList<>();

        llenarLista();

        final Adaptador adp = new Adaptador(datos);

        adp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Seleccion: " + datos.get(recyclerView.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_LONG).show();
                Intent in = new Intent(getApplicationContext(), ControlUsuarios.class);
                in.putExtra("nombre", datos.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                in.putExtra("username", datos.get(recyclerView.getChildAdapterPosition(v)).getUsername());
                startActivity(in);
            }
        });

        recyclerView.setAdapter(adp);
    }

    public void  llenarLista(){
        datos.add(new Usuario("Aarón", "aaron2421"));
        datos.add(new Usuario("Alberto", "Beetoo13"));
    }

}
