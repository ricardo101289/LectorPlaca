package com.example.ricardo.lectorplaca;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.example.ricardo.lectorplaca.R.*;


public class MainActivity extends AppCompatActivity {
    //String url = "https://www.google.com.ec/";
    AsyncTask<Void, Void, String[]> DatosVehiculo;
    String url;
    Intent intent;
    ProgressDialog progressDialog;
    private static final String TAG = "MyTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        // Seteamos en una Variable donde tenemos la fuente (podemos omitir este paso y ponerla directamente cuando cargamos la fuente)
        String carpetaFuente = "font/Airstream.ttf";
        String carpetaFuente2 = "font/Roboto-ThinItalic.ttf";
        // Obtenemos la id del TextView donde queremos cambiar la fuente
        // Cargamos la fuente
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);
        Typeface fuente2 = Typeface.createFromAsset(getAssets(), carpetaFuente2);
        // Aplicamos la fuente
        TextView vistaFuente = (TextView) findViewById(id.textView);
        vistaFuente.setTypeface(fuente);
        Button button = (Button)findViewById(id.button);
        button.setTypeface(fuente2);
        final EditText texto = (EditText)findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url ="<!DOCTYPE html>\n" +
                        "\n" +
                        "<html lang=\"es\">\n" +
                        "\n" +
                        "<head>\n" +
                        "<title>Titulo de la web</title>\n" +
                        "<meta charset=\"utf-8\" />\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <header>\n" +
                        "       <h1>Mi sitio web</h1>\n" +
                        "       <p>Mi sitio web creado en html5</p>\n" +
                        "    </header>\n" +
                        "    <section>\n" +
                        "    <form name=\"buscarVehiculoValoresPagarForm\" id =\"buscar\"  method=\"post\" action=\"https://declaraciones.sri.gob.ec/mat-vehicular-internet/reportes/general/buscarVehiculoValoresPagar.jspa\" onsubmit=\"return validateBuscarVehiculoValoresPagarForm(this);\">\n" +
                        "   <input type=\"hidden\" name=\"codConsultaRubro\">\n" +
                        "  <table class=\"formulario\" cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n" +
                        "      <input type=\"text\" name=\"placaCamv\" value=\""+texto.getText().toString()+"\">\n" +
                        "  </table>\n" +
                        "  </form>\n" +
                        "    </section>\n" +
                        "</body>\n" +
                        "</html>";

                Log.i(TAG, "Mensaje de información");
                System.out.println("mensaje");
                new Title().execute();
                System.out.println("vamos al otro activiti :D");



            }
        });

    }

    public class Title extends AsyncTask<Void, Void, String[]> {
        public  String arreglos (){

            return null;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Title");
            progressDialog.setTitle("Loading.......");
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }

        @Override
        protected String[] doInBackground(Void... params) {
            Document document, doc, avaluo;
            doc = Jsoup.parse(url);
            FormElement formulario = (FormElement) doc.getElementById("buscar");
            Connection con = formulario.submit();
            if (con != null)
                progressDialog.cancel();
            try {
                document = con.get();
                String atri = document.select("input").attr("name","btnAvaluo").attr("onclick").toString();//extraer atributo avaluo
                String atributo = atri.substring(106,111);//sacar dato para uri
                avaluo = Jsoup.connect("https://declaraciones.sri.gob.ec/mat-vehicular-internet/avaluos/buscarAvaluosInternetSubCategoria.jspa?subcategoria="+atributo).get();//obtener documento de Avaluos
                //Trabajamos con documento de Avaluos
                Element divprincipal = avaluo.getElementById("contenedorPrincipalPopUp");
                Elements th_avaluo = divprincipal.select("td");
                int contArray  = 0,contIngreso = 0;
                String s = "";
                for (Element link : th_avaluo) {//sacar tamaña de arreglo
                    s = link.text();
                    if (s != ""){
                        contArray = contArray+1;
                    }
                }
                String[] arrayAvaluo = new String[contArray];//declaracion de arreglo con el tamaño de datos extraidos
                for (Element link : th_avaluo) {//añadir elementos a arreglo
                    s = link.text();
                    if (s != ""){
                        arrayAvaluo[contIngreso] = s;
                        System.out.println("contador:  "+contIngreso+" Valor Avaluosss"+s);
                        contIngreso = contIngreso+1;
                    }
                }

                //Trabajamos con documento de Datos Generales
                Element div = document.select("table").attr("class","formulario").last();
                Elements th = div.select("td");
                //System.out.println(th);
                contArray  = 0;
                contIngreso = 0;
                s = "";//Variable controla la informcion extraida
                for (Element link : th) {//sacar tamaña de arreglo
                    s = link.text();
                    if (s != ""){
                        contArray = contArray+1;
                    }
                }
                String[] array = new String[contArray];//declaracion de arreglo con el tamaño de datos extraidos
                for (Element link : th) {//añadir elementos a arreglo
                    s = link.text();
                    if (s != ""){
                        array[contIngreso] = s;
                        System.out.println("contador:  "+contIngreso+" Valor"+s);
                        contIngreso = contIngreso+1;
                    }
                }

                System.out.println("tamaño del array: "+array.length);
                System.out.println("valor del cont Array: "+contArray);
                System.out.println("valor del cont Ingreso: "+contIngreso);
                intent = new Intent(MainActivity.this,Menu.class);//cargar nueva activity
                intent.putExtra("Array",array);//cargar array
                intent.putExtra("ArrayAvaluo",arrayAvaluo);//cargar array
                startActivity(intent);//llamar actividad
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
    }
}



