package com.buibee.viajarsano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import util.Continente;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DescargasActivity extends Activity {

	//Atributos.
	//private ProvinciasParser pp;
	//private ArrayList<Provincia> listaProvincias;
	private List<String> continentes = Arrays.asList("AFRICA CENTRAL", "AFRICA DEL ESTE", "AFRICA DEL NORTE", "AFRICA DEL OESTE", "AFRICA DEL SUR", "AMERICA CENTRAL", "AMERICA DEL NORTE", "AMERICA DEL SUR", "ASIA ORIENTAL", "CARIBE", "EUROPA DEL ESTE", "EUROPA OCCIDENTAL", "OCEAN�A", "ORIENTE MEDIO", "SUBCONTINENTE INDIO", "SUDESTE ASI�TICO");
	
	//private ArrayAdapter<String> adapContinentes;
	//private ArrayList<Continente> listaContinentes;
	
	
	//Componentes.
	/*private LinearLayout layPrin;
	private LinearLayout laySep;
	private ProgressDialog dialog;
	private ListView listaContinentesGrafica;
	private TextView txtProvincia;
	private EditText buscador;
	private ImageButton imgOk;
     */
	//Constantes.
	public final static String TAG = "PROVINCIA";
	public static final String PROVINCIA_ELEGIDA = "NNNPPPEEE";
	public final static String DIALOGO_MAPA = "DDDMMM";
	public final static int DIALOGO_SI = 1;
	public final static int DIALOGO_NO = 2;
	
	//Variable booleana para controlar cuando finaliza el hilo, y así rellenar la lista
	private boolean hiloTerminado;
	
	//Shared preferences.
	private  SharedPreferences sharedPreferences;
	
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        hiloTerminado=false;
        setContentView(R.layout.descargas);
        findViews();
        rellenaLista();
		//configBuscador();
        
        //Inicializo el array list de continentes
		setListeners();
    }
	
	private void findViews() {
		//dialog = ProgressDialog.show(ContinentesActivity.this, "Servicio de continentes",  "Accediendo a continentes", true);  
	/*	txtProvincia = (TextView)findViewById(R.id.titularprovincia);
		buscador = (EditText)findViewById(R.id.buscadorprov);
	    listaContinentesGrafica = (ListView)findViewById(android.R.id.list);
	    imgOk = (ImageButton)findViewById(R.id.buscadorbotonprov);
	    layPrin = (LinearLayout)findViewById(R.id.lfiestaprov);
	    laySep = (LinearLayout)findViewById(R.id.lseparadorprov);*/
	    
	    //La opción de menú de Fiestas se queda seleccionada
	    Button btn_press = (Button) findViewById(R.id.menu_mi_perfil);
        btn_press.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu4focused));        
	}
	
	private void rellenaLista() {
		//adapContinentes = new ArrayAdapter<String>(DescargasActivity.this,R.layout.listadoitem,continentes);
		//setListAdapter(adapContinentes);
	}
	
	private void setListeners() {
		
		
		
		 
		
		// Aquí definiremos los listeners de los Img Button para comprobar la descarga del PDF
         
		ImageButton button_Africa = (ImageButton) findViewById(R.id.button_africa);
		button_Africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              
                    Uri path = Uri.parse(getResources().getString(R.string.URLServidor) +getResources().getString (R.string.URLDescargasAfrica));
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try {
                        startActivity(intent);
                    } 
                    catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(),  getResources().getString(R.string.PDFno),  Toast.LENGTH_SHORT).show();
                    }
                }
        });
		
        
		ImageButton button_Asia = (ImageButton) findViewById(R.id.button_asia);
		button_Asia.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             
                   Uri path = Uri.parse(getResources().getString(R.string.URLServidor) +getResources().getString (R.string.URLDescargasAfrica));
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setDataAndType(path, "application/pdf");
                   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                   try {
                       startActivity(intent);
                   } 
                   catch (ActivityNotFoundException e) {
                       Toast.makeText(getApplicationContext(),   getResources().getString(R.string.PDFno),  Toast.LENGTH_SHORT).show();
                   }
               }
       });
		
        
		ImageButton button_America = (ImageButton) findViewById(R.id.button_america);
		button_America.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             
                   Uri path = Uri.parse(getResources().getString(R.string.URLServidor) +getResources().getString (R.string.URLDescargasAfrica));
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setDataAndType(path, "application/pdf");
                   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                   try {
                       startActivity(intent);
                   } 
                   catch (ActivityNotFoundException e) {
                       Toast.makeText(getApplicationContext(),   getResources().getString(R.string.PDFno),  Toast.LENGTH_SHORT).show();
                   }
               }
       });
		
        
		ImageButton button_Europa = (ImageButton) findViewById(R.id.button_europa);
		button_Europa.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             
                   Uri path = Uri.parse(getResources().getString(R.string.URLServidor) +getResources().getString (R.string.URLDescargasAfrica));
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setDataAndType(path, "application/pdf");
                   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                   try {
                       startActivity(intent);
                   } 
                   catch (ActivityNotFoundException e) {
                       Toast.makeText(getApplicationContext(),   getResources().getString(R.string.PDFno),  Toast.LENGTH_SHORT).show();
                   }
               }
       });
		
        
		ImageButton button_Oceania = (ImageButton) findViewById(R.id.button_oceania);
		button_Oceania.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             
                   Uri path = Uri.parse(getResources().getString(R.string.URLServidor) +getResources().getString (R.string.URLDescargasAfrica));
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setDataAndType(path, "application/pdf");
                   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                   try {
                       startActivity(intent);
                   } 
                   catch (ActivityNotFoundException e) {
                       Toast.makeText(getApplicationContext(),  getResources().getString(R.string.PDFno),  Toast.LENGTH_SHORT).show();
                   }
               }
       });
		
		
		
	        
	        
		
	}

}
