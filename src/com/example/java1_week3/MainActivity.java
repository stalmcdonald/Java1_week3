/*
 * Crystal McDonald
 * Java 1 1302
 * Week 3
 */
package com.example.java1_week3;

import com.cmcdonald.lib.WebStuff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search; 
	TempDisplay _temperature;
	LocDisplay _locations;
	Boolean _connected = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LinearLayout
        _context = this;
        _appLayout = new LinearLayout(this);
        
        
        //add it to view to see it
      		_search = new SearchForm(_context, "Enter City", "Go");
      		
      		//get buttons and fields
      		//add search handler
      		//building this way using more of a class method instead of tags approach
      		//EditText searchField = _search.getField();
      		Button searchButton = _search.getButton();
      		
      		//Adding functionality to get buttons to do something
      		searchButton.setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v){
      				Log.i("CITY ENTERED: ",_search.getField().getText().toString());
      			}
      			
      		});
      		
      		
      		//Detects the network connection
      		_connected = WebStuff.getConnectionStatus(_context);
      		if(_connected){
      			Log.i("NETWORK CONNECTION ", WebStuff.getConnnectionType(_context));
      		}
      		
      		//add stock display
      		_temperature = new TempDisplay(_context);
      		
      		//add faves display
      		_locations = new LocDisplay(_context);
      		
      		//add views to main layout
      		//added button to LinearLayout
      		_appLayout.addView(_search);
      		_appLayout.addView(_temperature);
      		_appLayout.addView(_locations);
      		
      		//to display under the search bar
      		_appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
