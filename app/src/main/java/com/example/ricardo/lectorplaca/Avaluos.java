package com.example.ricardo.lectorplaca;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by ricardo on 27/07/16.
 */
public class Avaluos extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TableLayout tabla;
        TextView texto;
        Bundle bundle;
        String[] Datos;
        int n = 0;
        bundle = this.getArguments();
        View rootView = inflater.inflate(R.layout.fragmentauto,container,false);
        tabla = (TableLayout)rootView.findViewById(R.id.tabla);
        if (bundle != null){
            n = bundle.getStringArray("ArrayAvaluos").length;
            System.out.println("TAMAÑOOO DEL BUNNDLEEE: "+n);
            Datos = new String[n];

            Datos = bundle.getStringArray("ArrayAvaluos");
            for (int i = 0; i<bundle.getStringArray("ArrayAvaluos").length; i++){
                System.out.println("FRAME DE AVALUOS de Vehiculo en FRAMEEE: "+"sitio:"+i+" "+Datos[i]);
            }
            /*
            for (int i = 0; i<bundle.getStringArray("ArrayAvaluos").length; i++){
                System.out.println("Informacion de      avaluo de Vehiculo en FRAMEEE: "+"sitio:"+i+" "+Datos[i]);
            }

            TableRow row = new TableRow(getActivity());
            String[] cabe = {"Valor","Numero"};
            for (int i = 0; i<2; i++){
                texto = new TextView(getActivity());
                texto.setGravity(Gravity.CENTER_VERTICAL);
                texto.setPadding(12,12,12,12);
                texto.setText(cabe[i]);
                row.addView(texto);
            }
            tabla.addView(row);
            */
        }


        return rootView;
    }
}
