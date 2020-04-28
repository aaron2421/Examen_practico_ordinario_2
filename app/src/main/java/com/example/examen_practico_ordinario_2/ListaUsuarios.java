package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListaUsuarios extends AppCompatActivity {
    private RecyclerView recyclerView;

    ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        recyclerView = findViewById(R.id.listaUsuariosView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        datos = new ArrayList<>();

        for (int i=0; i<=10; i++){
            datos.add("Dato #" + i);
        }

        Adaptador adp = new Adaptador(datos);
        recyclerView.setAdapter(adp);
    }
}
