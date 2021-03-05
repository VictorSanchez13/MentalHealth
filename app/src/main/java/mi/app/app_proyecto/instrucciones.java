package mi.app.app_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class instrucciones extends AppCompatActivity {
    String item;
    String [] fobias = {"Autonomatofobia", "Aracnofobia (No disponible)"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones);

        Spinner sp = (Spinner)findViewById(R.id.fobiasList);

        sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, fobias));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        switch (position) {
                            case (0):
                                item = fobias[0];
                                Toast.makeText(instrucciones.this, "Miedo a las estatuas", Toast.LENGTH_SHORT).show();
                                break;
                            case (1):
                                item = fobias[0];
                                Toast.makeText(instrucciones.this, "Miedo a las arañas", Toast.LENGTH_SHORT).show();
                                break;

                            default:
                                break;
                        }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void nextClick(View view){
        if(!item.isEmpty()){
            Intent i = new Intent(this, listaItems.class);
            i.putExtra("item", item);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Selecciona una fobia", Toast.LENGTH_SHORT).show();
        }
    }

    public void inicioClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void resumenClick (View view){
        Intent i = new Intent(this, resumen.class);
        i.putExtra("fob", item);
        startActivity(i);
    }



}
