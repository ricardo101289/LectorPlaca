package com.example.ricardo.lectorplaca;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

        TableRow fila;
        TextView txtFecha;
        TextView txtMuestra;
        TextView txtResultado;


        TextView texto;
        Bundle bundle;
        String[] DatosAvaluo;
        int n = 0;
        bundle = this.getArguments();
        View rootView = inflater.inflate(R.layout.fragmentoavaluo,container,false);

        TableLayout tabladatos=(TableLayout) rootView.findViewById(R.id.tablacultivos);
        TableRow.LayoutParams layoutFila=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutFecha=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutMuestra=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutResultado=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        tabladatos.removeAllViews();


        //tabla = (TableLayout)rootView.findViewById(R.id.tabla);
        if (bundle != null){
            n = bundle.getStringArray("ArrayAvaluos").length;
            System.out.println("TAMAÑOOO DEL BUNNDLEEE: "+n);
            DatosAvaluo = new String[n];
            DatosAvaluo = bundle.getStringArray("ArrayAvaluos");

            fila = new TableRow(getActivity());
            fila.setGravity(Gravity.CENTER_HORIZONTAL);
            fila.setLayoutParams(layoutFila);


            txtFecha=new TextView(getActivity());
            txtMuestra=new TextView(getActivity());
            txtResultado=new TextView(getActivity());

            txtFecha.setText("Período");
            //txtFecha.setGravity(Gravity.RIGHT);
            txtFecha.setPadding(65,65,65,65);
            txtFecha.setTextSize(22);
            txtFecha.setGravity(Gravity.CENTER);
            txtFecha.setLayoutParams(layoutFecha);

            txtMuestra.setText("Avalúo");
            txtMuestra.setPadding(65,65,65,65);
            txtMuestra.setTextSize(22);
            txtMuestra.setGravity(Gravity.CENTER);
            txtMuestra.setLayoutParams(layoutMuestra);

            txtResultado.setText("Impuesto");
            txtResultado.setPadding(65,65,65,65);
            txtResultado.setTextSize(22);
            txtResultado.setGravity(Gravity.CENTER);
            txtResultado.setLayoutParams(layoutMuestra);

            fila.addView(txtFecha);
            fila.addView(txtMuestra);
            fila.addView(txtResultado);

            tabladatos.addView(fila);



            for (int i = 4; i<bundle.getStringArray("ArrayAvaluos").length; i++){
                //System.out.println("FRAME DE AVALUOS de Vehiculo en FRAMEEE: "+"sitio:"+i+" "+DatosAvaluo[i]);
                fila = new TableRow(getActivity());
                fila.setGravity(Gravity.CENTER_HORIZONTAL);
                fila.setLayoutParams(layoutFila);



                txtFecha=new TextView(getActivity());
                txtMuestra=new TextView(getActivity());
                txtResultado=new TextView(getActivity());

                txtFecha.setText(DatosAvaluo[i]);
                //txtFecha.setGravity(Gravity.RIGHT);
                txtFecha.setPadding(65,65,65,65);
                txtFecha.setTextSize(15);
                txtFecha.setGravity(Gravity.CENTER);
                txtFecha.setLayoutParams(layoutFecha);

                txtMuestra.setText(DatosAvaluo[i = i + 1]);
                txtMuestra.setPadding(65,65,65,65);
                txtMuestra.setTextSize(15);
                txtMuestra.setGravity(Gravity.CENTER);
                txtMuestra.setLayoutParams(layoutMuestra);

                txtResultado.setText(DatosAvaluo[i = i + 1]);
                txtResultado.setPadding(65,65,65,65);
                txtResultado.setTextSize(15);
                txtMuestra.setGravity(Gravity.CENTER);
                txtResultado.setLayoutParams(layoutMuestra);

                fila.addView(txtFecha);
                fila.addView(txtMuestra);
                fila.addView(txtResultado);

                tabladatos.addView(fila);



            }
            //ListView listanueva = (ListView) rootView.findViewById(R.id.listView2);
            //ArrayAdapter<String> adapta = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, DatosAvaluo);
            //listanueva.setAdapter(adapta);
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
