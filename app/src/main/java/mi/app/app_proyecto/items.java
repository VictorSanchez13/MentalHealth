package mi.app.app_proyecto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class items extends AppCompatActivity {

    String [] itemList;
    int[] itemUSA;
    ArrayList<Integer> puntos = new ArrayList<Integer>();
    int numItems = 0;

    TextView it, pt;
    SeekBar bar;
    int pos;
    String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("position");

        cargarArray();

        cargarElementos();




        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub

                pt.setText(String.valueOf(progress));


            }
        });
    }

    private void cargarElementos() {
        TextView titulo = (TextView)findViewById(R.id.tit);
        titulo.setText("Autonomatofobia");

        it = (TextView)findViewById(R.id.item);
        it.setText(itemList[pos]);

        bar = (SeekBar)findViewById(R.id.pointBar);

        pt = (TextView)findViewById(R.id.textView5);
    }

    private void cargarArray() {

        itemList = getResources().getStringArray(R.array.Autonomatofobia);

        numItems = itemList.length;

        for(int i = 0; i < numItems; i++){
            puntos.add(0);
        }
    }


    public void nextClick(View view) {
        Intent i = new Intent(this, listaItems.class);
        SharedPreferences pref = getSharedPreferences("Autonomatofobia", Context.MODE_PRIVATE);

        boolean datos = checkOptions();

        if (datos){
            SharedPreferences.Editor editor = pref.edit();

            if(bar.getProgress() != 0){
                puntos.add(bar.getProgress());
            }
            else{
                puntos.add(0);
            }


            editor.putInt(itemList[pos], puntos.get(puntos.size()-1));

            editor.commit();

            //Se añade la puntuacion a un array
            bar.setProgress(0);
            startActivity(i);
        }
        else{
            genAlert();

        }


    }

    private void genAlert() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("¿Quieres permitir que se guarden datos sobre tus tests?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        savePref();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void volverClick (View view){
        Intent i = new Intent(this, listaItems.class);
        startActivity(i);
    }

    public boolean checkOptions(){
        SharedPreferences data = getSharedPreferences("Opciones", Context.MODE_PRIVATE);
        return data.getBoolean("datos", false);
    }

    public void savePref(){
        SharedPreferences data = getSharedPreferences("Opciones", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();

        editor.putBoolean("datos", true);

        editor.commit();
    }
}
