package cz.pajus.gav4_example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Tracker t = ((GavApplication) getApplication()).getTracker();
		
		if(t!= null){
			Log.d("TRACKER", "is here");
			// Set screen name.
	        t.setScreenName("TADA");

	        // Send a screen view.
	        t.send(new HitBuilders.AppViewBuilder().build());
	        
	        
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//UA-57007712-1

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClick(View v){
		Log.d("BTN","Click");
		
		Tracker t = ((GavApplication) getApplication()).getTracker();
		t.send(new HitBuilders.EventBuilder()
		.setCategory("BUTTON")
		.setAction("btn1")
		.setLabel("clicked")
		.build());
	}
}
