package com.example.proyectoagendapersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

    }

    // Este método se ejecuta cuando se pulsa el botón de menú
    public void grabar(View view){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();
        editor.putString(nombre, datos); //Guarda los datos en la agenda con el nombre como clave y los datos como valor

        editor.commit();
        Toast.makeText(this,"Datos grabados en agenda", Toast.LENGTH_LONG).show();

    }
    //Este metodo se utiliza para recuperar los datos guardados
    public void recuperar(View view) {
        String nombre = et1.getText().toString();
        SharedPreferences prefer = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String d = prefer.getString(nombre, "");
        if (d.length() == 0) {
            Toast.makeText(this, "No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show();

        } else {
            et2.setText(d);
        }
    }
}