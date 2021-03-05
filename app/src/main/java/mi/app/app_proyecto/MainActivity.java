package mi.app.app_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void empezarClick(View view){
        Intent i = new Intent(this, instrucciones.class);
        startActivity(i);
    }
    public void aboutClick(View view){
        Intent i = new Intent(this, about.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.Opciones:
                Intent i = new Intent(this, opciones.class);
                startActivity(i);
                return true;
            case R.id.info:
                Intent info = new Intent(this, Info.class);
                startActivity(info);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}