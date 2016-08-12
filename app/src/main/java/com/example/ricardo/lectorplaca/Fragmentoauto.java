package com.example.ricardo.lectorplaca;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ricardo on 26/07/16.
 */
public class Fragmentoauto extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle;
        int n = 0;
        bundle = this.getArguments();
        View rootView = inflater.inflate(R.layout.fragmentauto,container,false);
        if (bundle != null){

            n = bundle.getStringArray("Array").length;
            String[] Datos = new String[n];
            Datos = bundle.getStringArray("Array");
            for (int i = 0; i<bundle.getStringArray("Array").length; i++){
                System.out.println("Informacion de Vehiculo en FRAMEEE: "+"sitio:"+i+" "+Datos[i]);
            }
            String myValue = bundle.getString("message");
            System.out.println("valor del bundle joder yes: "+myValue);
            ListView lista = (ListView) rootView.findViewById(R.id.listView);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Datos);
            lista.setAdapter(adaptador);

            //lista.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item_1,Datos));
        }
        System.out.println("estamos en el fragment 1");
        System.out.println("estamos en el fragment 2");

        System.out.println("estamos en el fragment 3");
        return rootView;
        //return inflater.inflate(R.layout.fragmentauto,container,false);
    }
}
