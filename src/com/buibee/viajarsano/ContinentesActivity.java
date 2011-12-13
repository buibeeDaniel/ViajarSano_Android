package com.buibee.viajarsano;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

//import com.flurry.android.FlurryAgent;
/*
import obj.Provincia;
import src.es.CiudadActivity;
import src.es.ProvinciaActivity;
*/
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ContinentesActivity extends Activity {

	//Atributos.
	//private ProvinciasParser pp;
	//private ArrayList<Provincia> listaProvincias;
	private List<String> continentes = Arrays.asList("AFRICA CENTRAL", "AFRICA DEL ESTE", "AFRICA DEL NORTE", "AFRICA DEL OESTE", "AFRICA DEL SUR", "AMERICA CENTRAL", "AMERICA DEL NORTE", "AMERICA DEL SUR", "ASIA ORIENTAL", "CARIBE", "EUROPA DEL ESTE", "EUROPA OCCIDENTAL", "OCEAN�A", "ORIENTE MEDIO", "SUBCONTINENTE INDIO", "SUDESTE ASI�TICO");
	private ArrayAdapter<String> adapContinentes;
	
	private EditText buscador;
	private ImageButton imgOk;
	private String candidato;
	//private ArrayList<Continente> listaContinentes;
	
	
	//Componentes.
	/*private LinearLayout layPrin;
	private LinearLayout laySep;
	private ProgressDialog dialog;
	private ListView listaContinentesGrafica;
	private TextView txtProvincia;
	private EditText buscador;
	private ImageButton imgOk;*/
     
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
        setContentView(R.layout.continentes);
        findViews();    
        rellenaLista();
        setListeners();
		configBuscador();
        
        
		
    }
	
	private void findViews() {
		//dialog = ProgressDialog.show(ContinentesActivity.this, "Servicio de continentes",  "Accediendo a continentes", true);  
		/*
		txtProvincia = (TextView)findViewById(R.id.titularprovincia);
		buscador = (EditText)findViewById(R.id.buscadorprov);
	    listaContinentesGrafica = (ListView)findViewById(android.R.id.list);
	    imgOk = (ImageButton)findViewById(R.id.buscadorbotonprov);
	    layPrin = (LinearLayout)findViewById(R.id.lfiestaprov);
	    laySep = (LinearLayout)findViewById(R.id.lseparadorprov);*/
	    
	    buscador = (EditText)findViewById(R.id.buscadorprov);
	    imgOk = (ImageButton)findViewById(R.id.buscadorbotonprov);
	    
	    //La opción de menú de Fiestas se queda seleccionada
	    Button btn_press = (Button) findViewById(R.id.menu_fiestas);
        btn_press.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu1focused));        
	}
	
	private void rellenaLista() {
		adapContinentes = new ArrayAdapter<String>(ContinentesActivity.this,R.layout.listadoitem,continentes);
		//setListAdapter(adapContinentes);
	}
	
	private void setListeners() {
		//listaContinentesGrafica.setTextFilterEnabled(true);
	}
	
	private void configBuscador() 
	{
		/*
		 
		ListIterator<String> iterator = continentes.listIterator();
		//Copio la lista de continentes a un ArrayAdapter
		while (iterator.hasNext()) 
		{
    	    //String siguiente = iterator.next();
			candidato = iterator.toString();
			adapContinentes.add(candidato);
		}
	
	     */
	
		 buscador.setOnFocusChangeListener(new OnFocusChangeListener() {
	        	boolean click = false;
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					// TODO Auto-generated method stub
					if(!click) {
						((EditText)v).setText("");
						click = true;
					}
				}	        	
	        });
		 
		 buscador.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode == KeyEvent.KEYCODE_ENTER) {
					
					
					
					String cont = buscador.getText().toString();
					adapContinentes.getFilter().filter(cont);
					
					return true;
				}
				return false;
			}			 
		 });
		 
		 imgOk.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) 
			{
				
				/*
				ListIterator<String> iterator = continentes.listIterator();
        		//String nomSeleccionado = ((TextView)view).getText().toString();
				
				String contBuscar = buscador.getText().toString();
        		boolean encontrado = false;
        		while (iterator.hasNext() && !encontrado) {
        	    //String siguiente = iterator.next();
        			String actual = iterator.toString();
        			if (actual.equals(contBuscar)) 
        				encontrado = true;
        		}
        		if (encontrado) 
        		{
        			//Entro en la nueva pantalla
		            startActivity(new Intent(ContinentesActivity.this, PaisesActivity.class));
            		//finish();
        		}
        		
				//OCULTO EL TECLADO
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(buscador.getWindowToken(), 0);
				
				/*
				String provBuscar = buscador.getText().toString();
				adapProvincias.getFilter().filter(provBuscar);
				*/
				
			}			 
		 });		   
	}

}
