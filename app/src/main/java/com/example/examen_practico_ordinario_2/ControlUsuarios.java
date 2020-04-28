package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.security.Guard;

public class ControlUsuarios extends AppCompatActivity {
    Intent intent;
    EditText nombre, apellido, username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_usuarios);

        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        username = findViewById(R.id.etNombreUsuario);
        pass = findViewById(R.id.etPassword);

        nombre.setText(getIntent().getStringExtra("nombre"));
        username.setText(getIntent().getStringExtra("username"));

    }

    public void nuevoUsuario(View v){
        nombre.setText(null);
        apellido.setText(null);
        username.setText(null);
        pass.setText(null);
    }

    public void guardarUsuario(View v){

    }

    public void abrirUsuario(View v){
        intent = new Intent(this, ListaUsuarios.class);
        startActivity(intent);
    }

    public void passUsuario(View v){

    }

}
