package util;

import com.buibee.viajarsano.AntesDeViajar;
import com.buibee.viajarsano.ContinentesActivity;
import com.buibee.viajarsano.DescargasActivity;
import com.buibee.viajarsano.DespuesDeViajar;
import com.buibee.viajarsano.R;
//import android.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Menu extends LinearLayout {
	
	public String tag="Menu Helper";
	
	//defino como public el acceso a los botones 
	public Button menu_provinciasbutton;
	public Button menu_rankingbutton;
	public Button menu_proximasbutton;
	public Button menu_mi_perfil_button;
		
	//Shared preferences.
	private  SharedPreferences sharedPreferences;
	
	public Menu(final Context context, AttributeSet attrs) {	
		 	super(context, attrs);
			setOrientation(HORIZONTAL);
			setGravity(Gravity.CENTER);
			setWeightSum(1.0f);			
			
			
			//Cargo el menú
			LayoutInflater.from(context).inflate(R.layout.menu, this, true);
			  
			menu_provinciasbutton = (Button) findViewById(R.id.menu_fiestas);
			menu_rankingbutton = (Button) findViewById(R.id.menu_ranking);
			menu_proximasbutton = (Button) findViewById(R.id.menu_proximas);
			menu_mi_perfil_button = (Button) findViewById(R.id.menu_mi_perfil);
					
		    /* BOTON PAIS POR PAIS */
			menu_provinciasbutton.setOnClickListener(new Button.OnClickListener() {
		
		    	public void onClick(View v) {
		            try {  
		            	//FlurryAgent.onEvent("Se accede a provincias por el menú");
		            	getContext().startActivity(new Intent(v.getContext(), ContinentesActivity.class)); 
		                
		            } catch (Exception e) {
		                Log.i(Menu.this.tag, "Fallo al presionar el botón Estaciones");
		            }
		        }
		    });	
		    menu_provinciasbutton.setFocusable(true);		    		     
		    
		    /* BOTON ANTES DE VIAJAR */
		    menu_rankingbutton.setOnClickListener(new Button.OnClickListener() {
		
		    	public void onClick(View v) {
		    		try {   
		    			Intent intent = new Intent(getContext(),AntesDeViajar.class);
		    			getContext().startActivity(intent);
			                
		    		} catch (Exception e) {
		    			Log.i(Menu.this.tag, "Fallo al presionar el botón Antes de Viajar");
			        }
		        }
		    });	
		    menu_rankingbutton.setFocusable(true);		 			
		    
		    /* BOTON DESPUES DE VIAJAR */
		    menu_proximasbutton.setOnClickListener(new Button.OnClickListener() {
		
		    	public void onClick(View v) {
		    		try {   
		    			Intent intent = new Intent(getContext(),DespuesDeViajar.class);
		    			getContext().startActivity(intent);		                
		            } catch (Exception e) {
		                Log.i(Menu.this.tag, "Fallo al presionar el botón Después de viajar");
		            }
		        }
		    });	
		    menu_proximasbutton.setFocusable(true);
		    		    
		    //sharedPreferences = context.getSharedPreferences(LoginActivity.PREFERENCIAS,Context.MODE_PRIVATE);
		    
		    /* BOTON DESCARGAS */
		    menu_mi_perfil_button.setOnClickListener(new Button.OnClickListener() {
		
		    	public void onClick(View v) {
		    		try {   
		    				//FlurryAgent.onEvent("Se accede a perfil por el menú");
		    				Intent intent = new Intent(getContext(),DescargasActivity.class);
		                	getContext().startActivity(intent);
		                	
		    		  			                
		            } catch (Exception e) {
		                Log.i(Menu.this.tag, "Fallo al presionar el botón mi Perfil");
		            }
		        }
		    });	
		    menu_mi_perfil_button.setFocusable(true);
	} 
 
}
 