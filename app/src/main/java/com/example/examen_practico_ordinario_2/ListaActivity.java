package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView listView;
    Intent intentLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_archivos);

        listView = findViewById(R.id.listaId);

        intentLista = getIntent();

        Bundle b = intentLista.getExtras();

        String[] archivos = b.getStringArray("array");
        System.out.println("Archivos: " + archivos[0]);
        System.out.println("Archivos: " + archivos[1]);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, archivos);
        listView.setAdapter(adapter);

    }
}
