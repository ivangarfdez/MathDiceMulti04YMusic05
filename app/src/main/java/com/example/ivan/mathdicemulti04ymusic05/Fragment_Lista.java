package com.example.ivan.mathdicemulti04ymusic05;

/**
 * Created by IvanGarciaFernandez on 18/11/15.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class Fragment_Lista extends Fragment {

    ListFragmentListener mCallback;

    public interface ListFragmentListener {
        public void onListSelected(int position);
    }

    public Fragment_Lista() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_lista_fragment, container, false);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Ahora creamos todos los datos que tiene que tener la Array de
        // la lista con los items
        String[] items = new String[]{"Perfil", "Juego", "Instrucciones", "Inicio", "Activar Musica"};


        //El problema que viene ahora es que necesitamos una lista,
        //lo que tenemos que hacer es transformar la Array en una ArrayList
        ArrayList<String> listaItems = new ArrayList<String>(Arrays.asList(items));

        //Ahora, necesitamos un adaptador, para poder pasarle el "contexto"
        // y la lista de items "itemlist"
        //Utilizamos nuestro Adapter customizado
        MenuAdapter adapter = new MenuAdapter(getActivity(), listaItems);

        //Ahora creamos el listView
        final ListView lV = (ListView) getActivity().findViewById(R.id.lv);

        //Pasamos la listView al Adaptador
        lV.setAdapter(adapter);

        lV.setOnItemClickListener(new customListener());
        // Inflate the layout for this fragment

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class customListener implements AdapterView.OnItemClickListener {

        //Recibe el Adapter con el implements, el view y donde se ha clickado + la id
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //String de la posicion clickada
            //String item = (String) parent.getItemAtPosition(position);
            //Toast.makeText(MainActivity.this,item,Toast.LENGTH_LONG).show();
            //Paso de informacion

            mCallback.onListSelected(position);
        }
    }

}