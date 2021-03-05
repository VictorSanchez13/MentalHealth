package mi.app.app_proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class listaItems extends AppCompatActivity {
    ArrayList<itemClass> items;
    String[] lista;
    String item;
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_items);

        lista = getResources().getStringArray(R.array.Autonomatofobia);
        cargarArray();

        cargarLista();


    }

    private void cargarLista() {

        itemsAdapter aa = new itemsAdapter(this, items);
        ListView lv = (ListView) findViewById(R.id.listItems);
        lv.setAdapter(aa);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent i = new Intent(lv.getContext(), items.class);
                i.putExtra("position", position);

                startActivity(i);

            }
        });
    }

    private void cargarArray() {
        items = new ArrayList<itemClass>();
        /*SharedPreferences pref = getSharedPreferences("Autonomatofobia", Context.MODE_PRIVATE);

        Map<String, ?> allEntries = pref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            items.add(new itemClass(entry.getKey()));
        }*/


        for (int i = 0; i < lista.length; i++){

            items.add(new itemClass(lista[i]));

        }
    }

    public void volverClick (View view){
        Intent i = new Intent(this, instrucciones.class);
        startActivity(i);
    }


}
