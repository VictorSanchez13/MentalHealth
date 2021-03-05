package mi.app.app_proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }

    public void volverClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void infoClick(View view){
        String url = "https://psicologiaymente.com/clinica/desensibilizacion-sistematica";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
