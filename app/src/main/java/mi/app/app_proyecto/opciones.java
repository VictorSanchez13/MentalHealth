package mi.app.app_proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class opciones extends AppCompatActivity {
    Switch alertSwitch, datosSwitch;
    boolean alertas;
    boolean datos;
    String nombre;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        alertSwitch = (Switch) findViewById(R.id.switch1);
        datosSwitch = (Switch) findViewById(R.id.switch2);
        name = (EditText)findViewById(R.id.nombre);

        cargarPreferencias();
    }



    public void saveClick(View view){
        if(alertSwitch.isChecked()){
            alertas = true;
        }
        else{
            alertas = false;
        }

        if (datosSwitch.isChecked()){
            datos = true;
        }
        else{
            datos = false;
        }
        savePreferences();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void savePreferences() {
        SharedPreferences preferencias = getSharedPreferences("Opciones", Context.MODE_PRIVATE);
        nombre = name.getText().toString();

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user", nombre);
        editor.putBoolean("alerts", alertas);
        editor.putBoolean("datos", datos);

        editor.commit();

    }

    private void cargarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("Opciones", Context.MODE_PRIVATE);

        String nombre = preferencias.getString("user", "");
        boolean ck = preferencias.getBoolean("alerts", false);
        boolean data = preferencias.getBoolean("datos", false);

        alertSwitch.setChecked(ck);
        name.setText(nombre);
        datosSwitch.setChecked(data);

    }

    public void checkButtons(View view){
        if (view.getId() == R.id.switch1){

            if(alertSwitch.isChecked()){
                alertas = true;
            }

        }

        if (view.getId() == R.id.switch2){

            if(datosSwitch.isChecked()){
                datos = true;
            }

        }
    }
}
