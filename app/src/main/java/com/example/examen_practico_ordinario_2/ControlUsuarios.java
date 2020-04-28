package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ControlUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_usuarios);
    }

    public void nuevoUsuario(View v){

    }

    public void guardarUsuario(View v){

    }

    public void abrirUsuario(View v){
        Intent intent = new Intent(this, ListaUsuarios.class);
        startActivity(intent);
    }

    public void passUsuario(View v){

    }

}
