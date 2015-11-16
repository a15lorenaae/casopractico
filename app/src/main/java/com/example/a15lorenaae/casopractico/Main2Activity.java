package com.example.a15lorenaae.casopractico;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
private SharedPreferences datosglobales;
    private void cargarpreferencias(){
        /*Cargamos o sharedpreferences indicando o nome do arquivo. Dito nome esta definido na activity principal*/
        datosglobales=getSharedPreferences(main.Nome_arquivo_preferencias,MODE_PRIVATE);
        EditText texto=(EditText)findViewById(R.id.textoeditado3);
        String dato=datosglobales.getString(main.nome_param_dato,"Non hai dato gardado");
        texto.setText(dato);
    }
    public void xestioneventos(){
        /*obtemos o editor do sharedpreferences e gardamos o contido da caixa de texto no shared preferences sendo nome_param o definido na actividad principal*/
        Button btnactualizar=(Button)findViewById(R.id.botonactualizar);
        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText texto=(EditText)findViewById(R.id.textoeditado3);
                SharedPreferences.Editor editorGlobal=datosglobales.edit();
                editorGlobal.putString(main.nome_param_dato,texto.getText().toString());
                editorGlobal.commit();
                finish();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cargarpreferencias();
        xestioneventos();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
