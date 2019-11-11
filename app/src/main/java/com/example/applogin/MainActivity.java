package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        final Asistente_BD dbHelper = new Asistente_BD(this);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Estructura_BD.CAMPO_NOMBRE, "Iago");
                values.put(Estructura_BD.CAMPO_CONTRASENHA, "Limonada");


                long newRowId = db.insert(Estructura_BD.TABLE_NAME, null, values);

                if(true){

                    abrirActividad();


                }else{

                    Snackbar.make(view, "El usuario o contraseña no son correctos", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }





            }
        });
    }

    private void abrirActividad() {

            Intent intent = new Intent(this,ActividadProtegida.class);
            startActivity(intent);

    }
}
