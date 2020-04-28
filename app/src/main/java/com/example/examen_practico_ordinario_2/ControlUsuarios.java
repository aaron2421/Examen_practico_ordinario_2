package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ControlUsuarios extends AppCompatActivity {
    Intent intent;
    EditText nombre, apellido, username, pass;
    String id="";

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_usuarios);

        db = this.openOrCreateDatabase("controlUsuarios", MODE_PRIVATE, null);
        //db.execSQL("create table  usuario(ID integer PRIMARY KEY autoincrement, name text, ape text, user text, pass text); ");

        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        username = findViewById(R.id.etNombreUsuario);
        pass = findViewById(R.id.etPassword);

        apellido.setText((getIntent().getStringExtra("apellido")));
        nombre.setText(getIntent().getStringExtra("nombre"));
        username.setText(getIntent().getStringExtra("username"));
        pass.setText(getIntent().getStringExtra("pass"));
        id = getIntent().getStringExtra("id");
    }

    public void nuevoUsuario(View v){
        nombre.setText(null);
        apellido.setText(null);
        username.setText(null);
        pass.setText(null);
    }

    public void guardarUsuario(View v){
        //Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        if (!id.equals("")){
            db.execSQL("update usuario set name='"+ nombre.getText().toString() +"'," +
                    " ape='"+ apellido.getText().toString() +"'," +
                    " user='"+ username.getText().toString() +"'," +
                    " pass='"+ pass.getText().toString() +"' " +
                    "where ID='" + id + "'");
            Toast.makeText(getApplicationContext(), "Usuario modificado con éxito", Toast.LENGTH_SHORT).show();
        }else if (id.equals("")){
            db.execSQL("insert into usuario(name, ape, user, pass) values ('" + nombre.getText().toString() + "'," +
                    " '" + apellido.getText().toString() + "'," +
                    " '" + username.getText().toString() + "'," +
                    " '" + pass.getText().toString() + "');");
            Toast.makeText(getApplicationContext(), "Usuario agregado con éxito", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirUsuario(View v){
        intent = new Intent(this, ListaUsuarios.class);
        startActivity(intent);
    }

    public void borrarUsuario(View v){
        db.execSQL("delete from usuario where name='" + nombre.getText().toString() + "'");
        Toast.makeText(getApplicationContext(), "Usuario eliminado con éxito", Toast.LENGTH_SHORT).show();
        nombre.setText(null);
        apellido.setText(null);
        username.setText(null);
        pass.setText(null);
    }

}
