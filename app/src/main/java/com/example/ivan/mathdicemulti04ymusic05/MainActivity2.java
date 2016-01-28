package com.example.ivan.mathdicemulti04ymusic05;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ivan on 27/1/16.
 */
public class MainActivity2 extends Activity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");


        if (position == 0) {
            Toast.makeText(this, "Perfil", Toast.LENGTH_LONG).show();

            Fragment_Perfil fragmentPerfil = new Fragment_Perfil();
            getFragmentManager().beginTransaction().replace(R.id.fr_estatico, fragmentPerfil).commit();
        }

        if (position == 1) {
            Toast.makeText(this, "Juego todavía no implemntado", Toast.LENGTH_LONG).show();
        }

        if (position == 2) {
            Toast.makeText(this, "Instrucciones", Toast.LENGTH_LONG).show();
        }
        if (position == 3) {
            Toast.makeText(this, "Pantalla Inicial", Toast.LENGTH_LONG).show();

            //Mostramos el fragment en blanco, una especie de inicio de la app.
            Fragment_Blank fragmentContenido = new Fragment_Blank();

            getFragmentManager().beginTransaction()
                    .add(R.id.fr_estatico, fragmentContenido).commit();


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

    //Metodo clean para musica
    private void cleanMusica() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}

