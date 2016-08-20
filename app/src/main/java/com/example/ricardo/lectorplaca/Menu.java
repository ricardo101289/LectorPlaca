package com.example.ricardo.lectorplaca;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

/**
 * Created by ricardo on 21/07/16.
 */
public class Menu extends AppCompatActivity {
    FragmentManager fragmentManager;
    android.app.FragmentManager fragmentautoDatos;
    android.app.FragmentManager fragmentManagerAvaluos;
    android.app.FragmentTransaction fragmentTransaction;
    TabHost TbH;
    Bundle data = new Bundle();
    Bundle dataAvaluos = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        TbH = (TabHost) findViewById(R.id.tabHost); //llamamos al Tabhost
        TbH.setup();                                                         //lo activamos
        TabHost.TabSpec tab1 = TbH.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = TbH.newTabSpec("tab2");
        TabHost.TabSpec tab3 = TbH.newTabSpec("tab3");
        if (extras !=null){
            int n = extras.getStringArray("Array").length;
            int n2 = extras.getStringArray("ArrayAvaluo").length;
            String[] Datos = new String[n];
            String[] DatosAvaluos = new String[n2];
            Datos = extras.getStringArray("Array");
            DatosAvaluos = extras.getStringArray("ArrayAvaluo");
            for (int i = 0; i<extras.getStringArray("Array").length; i++){
                //System.out.println("Informacion de Vehiculo activity2: "+"sitio:"+i+" "+Datos[i]);
            }

            for (int i = 0; i<extras.getStringArray("ArrayAvaluo").length; i++){
                //System.out.println("Informacion de Avaluo activity2: "+"sitio:"+i+" "+DatosAvaluos[i]);
            }


            String hola = "hola";
            tab1.setIndicator("Datos");    //qué queremos que aparezca en las pestañas
            tab1.setContent(R.id.linearLayout); //definimos el id de cada Tab (pestaña)
            tab2.setIndicator("Avalúo");
            tab2.setContent(R.id.linearLayout2);
            tab3.setIndicator("Multas");
            tab3.setContent(R.id.linearLayout3);
            System.out.println("inten 2 joderrr si baby");
            String myMessage = "Stackoverflow is cool!";



            //Creacion de fragmento con datos de Avaluo de vehiculo
            dataAvaluos.putStringArray("ArrayAvaluos",DatosAvaluos);
            if (dataAvaluos != null){
                Avaluos avaluos = new Avaluos(); //objeto fragment
                avaluos.setArguments(dataAvaluos);//abjunto bunndle al fragment
                fragmentManagerAvaluos = getFragmentManager(); //administrador de fragment
                fragmentTransaction = fragmentManagerAvaluos.beginTransaction();//transaccion fragmente
                fragmentTransaction.add(R.id.Avaluofragment,avaluos);//se añade fragment a la vista
                fragmentTransaction.commit();//se confirman los cambios
                /*
                fragmentManagerAvaluos = getFragmentManager();
                fragmentTransaction = fragmentManagerAvaluos.beginTransaction();
                fragmentTransaction.add(R.id.Avaluofragment,avaluos);
                fragmentTransaction.commit();
                */
            }
            //Creacion del fragmento con datos generales de vehiculo
            data.putStringArray("Array",Datos);
            if (data != null){
                Fragmentoauto fragmentoauto = new Fragmentoauto();
                fragmentoauto.setArguments(data);
                fragmentautoDatos = getFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.ContenedorFragment, fragmentoauto)
                        .addToBackStack(null)
                        .commit();

            }

        }else {
            tab1.setIndicator("Datos");    //qué queremos que aparezca en las pestañas
            tab1.setContent(R.id.linearLayout); //definimos el id de cada Tab (pestaña)
            tab2.setIndicator("Avalúo");
            tab2.setContent(R.id.linearLayout2);
            tab3.setIndicator("Multas");
            tab3.setContent(R.id.linearLayout3);
        }


        TbH.addTab(tab1); //añadimos los tabs ya programados
        TbH.addTab(tab2);
        TbH.addTab(tab3);
    }

}
