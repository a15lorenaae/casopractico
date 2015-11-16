package com.example.a15lorenaae.casopractico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends AppCompatActivity {
public static final String Nome_arquivo_preferencias="datosagardar";
    public static final String nome_param_dato="dato";
    private SharedPreferences datosprivados;
    private SharedPreferences datosglobales;
    @Override
    protected void onResume() {
        /*Cargamos os datos que se atopan en sharedpreferences, cando vimos da actividade secundaria
        cargamos as modificacions feitas
         */
        super.onResume();
        EditText textolocal=(EditText)findViewById(R.id.textolocal);
        textolocal.setText(datosprivados.getString(nome_param_dato,"Non hai valor gardado localmente"));
        EditText textoglobal=(EditText)findViewById(R.id.textoglobal);
        textoglobal.setText(datosglobales.getString(nome_param_dato,"Non hai valor gardado globalmente"));
    }
private void xestionareventos(){
    Button botoncardar1=(Button)findViewById(R.id.botoncargar);
    botoncardar1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText textolocal=(EditText)findViewById(R.id.textolocal);
            textolocal.setText(datosprivados.getString(nome_param_dato,"Non hai valor gardado localmente"));
            EditText textoglobal=(EditText)findViewById(R.id.textoglobal);
            textoglobal.setText(datosglobales.getString(nome_param_dato, "Non hai valor gardado globalmente"));
        }
    });
    Button botongardar1=(Button)findViewById(R.id.botongardar);
    botongardar1.setOnClickListener(new View.OnClickListener() {
        /*Xestionamos o evento click sobre o boton gardar datos
        obtemos o editor do sharedpreferences local e cambiamos o dato polo contido que esta na caixa d texto
        obtemos o editor sharedpreferences global e cambiamos o dato polo contido da caixa de texto
         */
        @Override
        public void onClick(View v) {
            EditText textolocal = (EditText) findViewById(R.id.textolocal);
            SharedPreferences.Editor editor = datosprivados.edit();
            editor.putString(nome_param_dato, textolocal.getText().toString());
            editor.commit();
            textolocal.setText("");
            Toast.makeText(getApplicationContext(), "Datos gardados", Toast.LENGTH_SHORT).show();
        }
    });
    Button botonlanzar=(Button)findViewById(R.id.botonlanzar);
    botonlanzar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
        }
    });
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        datosglobales=getSharedPreferences(Nome_arquivo_preferencias,MODE_PRIVATE);
        datosprivados=getPreferences(MODE_PRIVATE);
        xestionareventos();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
