package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtUsuario = findViewById(R.id.txt_Usuario);
        final TextView txtContrasenha = findViewById(R.id.txt_Contrasenha);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        final Asistente_BD dbHelper = new Asistente_BD(this);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase dbl = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Estructura_BD.CAMPO_NOMBRE, "iago");
                values.put(Estructura_BD.CAMPO_CONTRASENHA, "limonada");


                long newRowId = dbl.insert(Estructura_BD.TABLE_NAME, null, values);

                String usuario = txtUsuario.getText().toString().trim();
                String contrasenha = txtContrasenha.getText().toString().trim();
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String sql = "SELECT * FROM Usuarios WHERE Estructura_BD.CAMPO_NOMBRE=? AND Estructura_BD.CAMPO_CONTRASENHA=?";
                Cursor filas = db.rawQuery(sql, new String[]{usuario, contrasenha});

                if (filas.moveToFirst()) {//Si se encuentra el usuario y contrseña

                    abrirActividad();


                } else {

                    Snackbar.make(view, "El usuario o contraseña no son correctos", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }

            }
        });
    }

    private void abrirActividad() {

        Intent intent = new Intent(this, ActividadProtegida.class);
        startActivity(intent);

    }
}
