package mi.app.app_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }


    public void inicioClick(View view) {
        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
    }
}
