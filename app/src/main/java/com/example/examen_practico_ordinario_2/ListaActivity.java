package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Intent intentLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_archivos);

        recyclerView = findViewById(R.id.listaId);

        intentLista = getIntent();

        Bundle b = intentLista.getExtras();

        String[] archivos = b.getStringArray("array");
        System.out.println("length: " + archivos.length);
        System.out.println("Archivos: " + archivos[0]);
        System.out.println("Archivos: " + archivos[1]);

        ArchivosAdapter adapter = new ArchivosAdapter(this, archivos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
