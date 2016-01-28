package com.example.ivan.mathdicemulti04ymusic05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ivan on 25/11/15.
 */
public class Activity_perfil extends Activity implements Fragment_Perfil.PerfilFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perfil);

        final EditText txtnombre = (EditText) findViewById(R.id.escribenombre);
        final EditText txtedad = (EditText) findViewById(R.id.escribeedad);

        Button button = (Button) findViewById(R.id.btnaceptar);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent intent = new Intent(Activity_perfil.this, MainActivity.class);

                //Declaramos nombre y edad que tiene que introducir
                String nombre = txtnombre.getText().toString();
                String edad = txtedad.getText().toString();


                intent.putExtra("nombre", nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);

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
    public void onListSelected(int position){

    }
}
