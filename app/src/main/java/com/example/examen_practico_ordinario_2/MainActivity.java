package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void controlUsuarios(View v) {
        Intent intent = new Intent(this, ControlUsuarios.class);
        startActivity(intent);
    }

    public void controlArchivos(View view) {
        Intent intent = new Intent(this, ControlArchivosLogin.class);
        startActivity(intent);
    }

    public void salir(View v) {
        finish();
    }
}
