package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ControlArchivosLogin extends AppCompatActivity {

    EditText editTxtUsuario, editTextPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_archivos);

        editTxtUsuario = findViewById(R.id.editTextUsuario);
        editTextPass = findViewById(R.id.editTxtPass);
        btnLogin = findViewById(R.id.btnLogin);

        final Intent intent = new Intent(this, Archivos.class);

        final SQLiteDatabase databaseUsers = this.openOrCreateDatabase("controlUsuarios", MODE_PRIVATE, null);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseUsers.rawQuery("select * from usuario", null);
                cursor.moveToPosition(-1);

                while (cursor.moveToNext()) {

                    String userCursor = cursor.getString(cursor.getColumnIndex("user"));
                    String passCursor = cursor.getString(cursor.getColumnIndex("pass"));
                    String userEditText = editTxtUsuario.getText().toString();
                    String passEditText = editTextPass.getText().toString();

                    if (userCursor.equals(userEditText) && passCursor.equals(passEditText)) {
                        Toast.makeText(getApplicationContext(), "Login correcto, bienvenido: " + userCursor, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login incorrecto, por favor intentalo de nuevo ", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
