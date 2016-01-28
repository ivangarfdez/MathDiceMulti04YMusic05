package com.example.ivan.mathdicemulti04ymusic05;

/**
 * Created by IvanGarciaFernandez on 18/11/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity implements Fragment_Lista.ListFragmentListener {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check dispositivo grande
        if (findViewById(R.id.contenido) != null) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


            Bundle bundle = getIntent().getExtras();
            //Recogemos los datos.
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");


            //Hacemos el log y para ver lo que pasa
            Log.i(nombre, "nombre");
            Log.i(edad, "edad");

            //Declaramos un nuevo Fragment para mostrar al lanzar...
            Fragment_Blank fragmentContenido = new Fragment_Blank();

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.contenido, fragmentContenido).commit();


        }
    }


    public void onListSelected(int position) {

        if (position == 0) {
            if (findViewById(R.id.contenido) != null) {
                Toast.makeText(this, "Perfil", Toast.LENGTH_LONG).show();

                Fragment_Perfil fragmentPerfil = new Fragment_Perfil();

                getFragmentManager().beginTransaction().replace(R.id.contenido, fragmentPerfil).commit();


            } else {
                Intent i = new Intent(this, MainActivity2.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        }

        if (position == 1) {
            Toast.makeText(this, "Juego todavía no implemntado", Toast.LENGTH_LONG).show();
        }

        if (position == 2) {
            Toast.makeText(this, "Instrucciones", Toast.LENGTH_LONG).show();
        }
        if (position == 3) {

            if (findViewById(R.id.contenido) != null) {
                Toast.makeText(this, "Pantalla Inicial", Toast.LENGTH_LONG).show();

                //Mostramos el fragment en blanco, una especie de inicio de la app.
                Fragment_Blank fragmentblank = new Fragment_Blank();

                getFragmentManager().beginTransaction().replace(R.id.contenido, fragmentblank).commit();
            } else {
                Intent i = new Intent(this, MainActivity2.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        }
        if (position == 4) {
            Toast.makeText(this, "¡¡¡Musica Activada!!!", Toast.LENGTH_LONG).show();

            //Musica
            cleanMusica();
            //Seleccionamos el directorio y la pista
            mp = MediaPlayer.create(this, R.raw.mathdice);
            mp.start();

        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }


    //Metodo clean para musica
    private void cleanMusica() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}

