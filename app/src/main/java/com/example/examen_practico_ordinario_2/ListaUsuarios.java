package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListaUsuarios extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Usuario> datos;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        db = this.openOrCreateDatabase("controlUsuarios", MODE_PRIVATE, null);

        recyclerView = findViewById(R.id.listaUsuariosView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        datos = new ArrayList<>();

        consultarUsuarios();

        final Adaptador adp = new Adaptador(datos);

        adp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Seleccion: " + datos.get(recyclerView.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_LONG).show();
                Intent in = new Intent(getApplicationContext(), ControlUsuarios.class);
                in.putExtra("id", datos.get(recyclerView.getChildAdapterPosition(v)).getId());
                in.putExtra("apellido", datos.get(recyclerView.getChildAdapterPosition(v)).getApellido());
                in.putExtra("nombre", datos.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                in.putExtra("username", datos.get(recyclerView.getChildAdapterPosition(v)).getUsername());
                in.putExtra("pass", datos.get(recyclerView.getChildAdapterPosition(v)).getPass());
                startActivity(in);
                finish();
            }
        });

        recyclerView.setAdapter(adp);
    }

    public void consultarUsuarios(){
        //Cursor cursor = db.rawQuery("select ape, name, user, pass from usuario", null);
        Cursor cursor = db.rawQuery("select * from usuario", null);
        Usuario user = null;

        while (cursor.moveToNext()){
            user = new Usuario();
            user.setId(cursor.getString(0));
            user.setNombre(cursor.getString(1));
            user.setApellido(cursor.getString(2));
            user.setUsername(cursor.getString(3));
            user.setPass(cursor.getString(4));

            datos.add(user);
        }
    }

}
