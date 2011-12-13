package com.buibee.viajarsano;

import java.util.ListIterator;
//import com.buibee.viajarsano.R; 
//import android.R;
/*
import obj.Provincia;
import src.es.CiudadActivity;
import src.es.ProvinciaActivity;
import src.es.R;
*/


import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class PaisesActivity extends ListActivity {

	//Atributos.
	//private ProvinciasParser pp;
	//private ArrayList<Provincia> listaProvincias;
	private String[] paises = {"AFRICA CENTRAL", "AFRICA DEL ESTE", "AFRICA DEL NORTE", "AFRICA DEL OESTE", "AFRICA DEL SUR", "AMERICA CENTRAL", "AMERICA DEL NORTE", "AMERICA DEL SUR", "ASIA ORIENTAL", "CARIBE", "EUROPA DEL ESTE", "EUROPA OCCIDENTAL", "OCEAN�A", "ORIENTE MEDIO", "SUBCONTINENTE INDIO", "SUDESTE ASI�TICO"};
	private ArrayAdapter<String> adapPaises;
	
	//Componentes.
	private LinearLayout layPrin;
	private LinearLayout laySep;
	private ProgressDialog dialog;
	private ListView listaContinentesGrafica;
	private TextView txtProvincia;
	private EditText buscador;
	private ImageButton imgOk;
     
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
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hiloTerminado=false;
        setContentView(R.layout.paises);
        findViews();
        rellenaLista();
		//configBuscador();
		//setListeners();
    }
	
	private void findViews() {
		//dialog = ProgressDialog.show(ContinentesActivity.this, "Servicio de continentes",  "Accediendo a continentes", true);  
		txtProvincia = (TextView)findViewById(R.id.titularprovincia);
		buscador = (EditText)findViewById(R.id.buscadorprov);
	    listaContinentesGrafica = (ListView)findViewById(android.R.id.list);
	    imgOk = (ImageButton)findViewById(R.id.buscadorbotonprov);
	    layPrin = (LinearLayout)findViewById(R.id.lfiestaprov);
	    laySep = (LinearLayout)findViewById(R.id.lseparadorprov);
	    
	    //La opción de menú de Fiestas se queda seleccionada
	    Button btn_press = (Button) findViewById(R.id.menu_fiestas);
        btn_press.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu1focused));        
	}
	
	
	private void rellenaLista() 
	{
		/*
		adapPaises = new ArrayAdapter<String>(PaisActivity.this,R.layout.listadoitem,paises);
		setListAdapter(adapPaises);
		*/
	}
	

	/*
	private void setListeners() {
		listaContinentesGrafica.setTextFilterEnabled(true);

        listaContinentesGrafica.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {

        	//Lo que hace el item al seleccionarlo.
            Log.i(TAG,"Accede a la provincia " + ((TextView)view).getText());
            
            //Transición a la pantalla de ciudades.
            try {
            	if (listaContinentesGrafica.contains(new Pais(((TextView)view).getText().toString()))) {
            		ListIterator<Provincia> iterator = listaProvincias.listIterator();
            		String nomSeleccionado = ((TextView)view).getText().toString();
            		Provincia prov = null;
            		boolean encontrado = false;
            		while (iterator.hasNext() && !encontrado) {
            			Provincia candidato = iterator.next();
            			if (candidato.getNombre().equals(nomSeleccionado)) {
            				encontrado = true;
            				prov = candidato;
            			}
            		}
            		if (encontrado) {
            			FlurryAgent.onEvent("Se va a acceder a las ciudad de la provincia "+prov.getNombre());
			            Intent i = new Intent(ProvinciaActivity.this,CiudadActivity.class);
			            i.putExtra(PROVINCIA_ELEGIDA,prov);
			            startActivity(i);
            		}
            	}
            } catch (NullPointerException e){
            	Toast.makeText(getApplicationContext(),getResources().getString(R.string.error_listado_explicacion), 3000);
            }
          }
        });
	}
*/
}
