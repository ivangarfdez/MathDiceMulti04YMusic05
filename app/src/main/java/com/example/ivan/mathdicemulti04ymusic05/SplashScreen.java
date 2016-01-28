package com.example.ivan.mathdicemulti04ymusic05;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Ivan García Fernández on 23/10/15.
 */
public class SplashScreen extends Activity {

    // Temporizador para la pantalla de bienvenida
    private static int ContadorTiempo = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Este es el layout que tiene que mostrar.
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            //Usamos un contador par poder mostrar la imagen
            //3 segundos

            @Override
            public void run() {
                // Cuando el contador del tiempo llega a cero, se ejecuta este método.
                // Cambiamos de Activity
                Intent i = new Intent(getApplicationContext(), Activity_perfil.class);
                startActivity(i);

                // Finalizamos el activity
                finish();
            }
        }, ContadorTiempo);
    }
}