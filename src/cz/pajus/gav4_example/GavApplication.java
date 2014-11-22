package cz.pajus.gav4_example;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class GavApplication extends Application {

	Tracker mTracker = null; 
	GoogleAnalytics analyticsInstance;
	@Override
	public void onCreate(){
		super.onCreate();
		analyticsInstance = GoogleAnalytics
				.getInstance(getApplicationContext());
		mTracker = analyticsInstance.newTracker("UA-57007712-1");
		
		analyticsInstance.setAppOptOut(false);
		analyticsInstance.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
		
		
	}
	
	
	synchronized Tracker getTracker() {
		Log.d("TRACKER", "get");
		if (mTracker == null) {
			Log.d("TRACKER", "get");
			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			Tracker t = analytics.newTracker("UA-57007712-1");
		}

		return mTracker;
	}
}
