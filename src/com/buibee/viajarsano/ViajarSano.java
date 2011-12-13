package com.buibee.viajarsano;
//import android.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class ViajarSano extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // setup handler to close the splash screen
        Handler x = new Handler();
        x.postDelayed(new SplashHandler(), 800);
        
    }
    
    class SplashHandler implements Runnable {

        public void run() {

            // start new activity
        	if (isOnline()) {
        		startActivity(new Intent(getApplication(), ContinentesActivity.class));
        		finish();
        	} else {
        		AlertDialog.Builder alt_bld = new AlertDialog.Builder(ViajarSano.this);
			    alt_bld.setMessage("Error. Se necesita acceso a Internet para poder continuar.")
			    .setCancelable(false)
			    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int id) {
			    // Action for 'Yes' Button
			    	// close out this activity
	                finish();
			    }
			    });
			    AlertDialog alert = alt_bld.create();
			    // Title for AlertDialog
			    alert.setTitle("Atención");
			    // Icon for AlertDialog
			    //alert.setIcon(R.drawable.icon);
			    alert.show();
			    
        		
        	}
        }
    }
    
    public boolean isOnline() 
    {
    	try
    	{
    		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    		return cm.getActiveNetworkInfo().isConnectedOrConnecting();
    	}
    	catch(NullPointerException ex)
    	{
    		return false;
    	}
    }
	
}