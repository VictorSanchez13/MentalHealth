package mi.app.app_proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class resumen extends AppCompatActivity {
    ArrayList<itemClass> resumen = new  ArrayList<itemClass>();
    String[] list;
    String it;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_list);

        Bundle extras = getIntent().getExtras();
        it = extras.getString("fob");
        list = getResources().getStringArray(R.array.Autonomatofobia);

        cargarPreferencia();

        resumenAdapter aa = new resumenAdapter(getApplicationContext(),resumen);
        ListView lv = (ListView) findViewById(R.id.listResumen);
        lv.setAdapter(aa);

    }

    private void cargarPreferencia() {
        SharedPreferences preferencias = getSharedPreferences(it, Context.MODE_PRIVATE);
        String w;
        int cont;
        for (int i = 0; i < list.length; i++){
            w = list[i];
            cont = preferencias.getInt(w, 0);

            if(cont == 0){
                int aux = i +1;
                itemClass it = new itemClass(w, 0);
                resumen.add(it);
            }
            else{
                itemClass it = new itemClass(w, cont);
                resumen.add(it);
            }

        }

    }

    public void volverClick (View view){
        Intent i = new Intent(this, instrucciones.class);
        startActivity(i);
    }


}
