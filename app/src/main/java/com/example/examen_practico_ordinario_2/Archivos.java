package com.example.examen_practico_ordinario_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class Archivos extends AppCompatActivity {

    EditText editTxtTexto;
    Button btnNuevo, btnGuardar, btnAbrir;
    ListView listView;
    Intent intentLista, intent2;
    Bundle bundle, bundle2;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivos);

        final SQLiteDatabase databaseUsers = this.openOrCreateDatabase("usersDB", MODE_PRIVATE, null);

        verifyStoragePermissions(this);

        editTxtTexto = findViewById(R.id.editTxtTexto);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnAbrir = findViewById(R.id.btnAbrir);

        listView = findViewById(R.id.listaId);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTxtTexto.setText("");
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String newPath = "";
                System.out.println(sdPath);
                String userCursor = "";
                int bound = 100;

                Cursor cursor = databaseUsers.rawQuery("select * from usersLogin", null);
                cursor.moveToPosition(-1);

                Random randomNum = new Random(System.currentTimeMillis());

                while (cursor.moveToNext()) {
                    userCursor = cursor.getString(cursor.getColumnIndex("usuario"));
                }

                File userFolder = new File(Environment.getExternalStorageDirectory() + "/" + userCursor + "/");
                if (!userFolder.exists()) {
                    userFolder.mkdirs();
                }

                newPath = sdPath + "/" + userCursor + "/";

                System.out.println(userFolder);

                try {

                    if (editTxtTexto.getText().toString().equals("")) {
                        Toast.makeText(getBaseContext(), "El campo no puede ir vacío", Toast.LENGTH_SHORT).show();
                    } else {
                        File myFile = new File(newPath + userCursor + randomNum.nextInt(bound) + ".txt");

                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(myFile));

                        outputStreamWriter.append(editTxtTexto.getText());
                        outputStreamWriter.close();

                        Toast.makeText(getBaseContext(), "Archivo guardado en la SD", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String userCursor = "";
                int i = -1;

                bundle = new Bundle();
                bundle2 = new Bundle();

                String[] listaArchivos = new String[50];

                Cursor cursor = databaseUsers.rawQuery("select * from usersLogin", null);
                cursor.moveToPosition(-1);

                while (cursor.moveToNext()) {
                    userCursor = cursor.getString(cursor.getColumnIndex("usuario"));
                }

                String newPath = sdPath + "/" + userCursor + "/";

                File findFolder = new File(newPath);

                System.out.println("Findfolder: " + findFolder);

                for (File file : findFolder.listFiles()) {
                    i++;
                    //System.out.println("Archivo: " + file);
                    try {
                        String textoArchivo = Files.toString(file, Charsets.UTF_8);
                        listaArchivos[i] = textoArchivo;
                        System.out.println(i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                bundle.putStringArray("array", listaArchivos);

                intentLista = new Intent(getApplicationContext(), ListaActivity.class);
                intentLista.putExtras(bundle);
                startActivity(intentLista);

            }
        });

    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}
