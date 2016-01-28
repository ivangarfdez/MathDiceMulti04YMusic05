package com.example.ivan.mathdicemulti04ymusic05;

/**
 * Created by IvanGarciaFernandez on 18/11/15.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<String> {

    //Primero declaramos las variables que vamos a usar
    //ArrayList con el contenido que va a tener el View
    private ArrayList<String> datos;

    //Contexto
    private Context context;

    //Sacamos las variables
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0, datos);
        this.context = context;
        this.datos = datos;
    }

    //Montamos la vista
    public View getView(int position, View convertView, ViewGroup parent) {

        //Ahora lo que tenemos que hacer es crear el inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Ahora hacemos una comprobación: Si no existe el convertView, crea uno nuevo
        if (convertView == null) {

            //El convertView recibe un item de la lista, y al ser a última opción falsa,
            //nos da un set de layoutParams para el view.
            convertView = inflater.inflate(R.layout.layout_object_list, parent, false);
        }

        //Ahora tenemos que seleccionar la imagen y el texto del XML y lo creamos
        //En este caso son imagenVi(ImagenView) y txtVi(TextView)
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imagenVi);
        TextView texto = (TextView) convertView.findViewById(R.id.txtVi);

        //Ahora a la variable que acabamos de crear=texto, le tenemos que pasar
        //la posicion del ArrayList de datos
        texto.setText(datos.get(position));

        if (datos.get(position) == "Perfil") {
            imagen.setImageDrawable(context.getDrawable(R.drawable.marciano));
            texto.setBackgroundColor(Color.LTGRAY);
            imagen.setBackgroundColor(Color.GREEN);
        }

        if (datos.get(position) == "Juego") {
            imagen.setImageDrawable(context.getDrawable(R.drawable.game));
            texto.setBackgroundColor(Color.GRAY);
            imagen.setBackgroundColor(Color.RED);
        }

        if (datos.get(position) == "Instrucciones") {
            imagen.setImageDrawable(context.getDrawable(R.drawable.description));
            texto.setBackgroundColor(Color.LTGRAY);
            imagen.setBackgroundColor(Color.YELLOW);
        }

        if (datos.get(position) == "Inicio") {
            imagen.setImageDrawable(context.getDrawable(R.drawable.info));
            texto.setBackgroundColor(Color.GRAY);
            imagen.setBackgroundColor(Color.MAGENTA);
        }

        if (datos.get(position) == "Activar Musica") {
            imagen.setImageDrawable(context.getDrawable(R.drawable.iconomusica));
            texto.setBackgroundColor(Color.LTGRAY);
            imagen.setBackgroundColor(Color.CYAN);
        }

        return convertView;

    }
}
