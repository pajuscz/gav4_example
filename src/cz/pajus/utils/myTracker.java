package cz.pajus.utils;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class myTracker {
	private Tracker t;
	private HitBuilders.EventBuilder event;
	
	
	private static boolean wasHit = false;
	
	public void init(Tracker tracker){
		t = tracker;
	}
	
	public void analyzeScreen(String screenName){
		t.setScreenName(screenName);
		t.send(new HitBuilders.AppViewBuilder().build());
	}
	
	public void analyzeButtonClick(String buttonName, String buttonValue){
		buttonValue = ":"+buttonValue;
		eventSender("UX Button", buttonName + buttonValue);
	}
	
	public void analyzeABclick(String buttonName, String buttonValue){
		buttonValue = ":"+buttonValue;
		eventSender("UX Action Bar", buttonName + buttonValue);
	}
	
	private void eventSender(String category, String action){
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(action)
		.build());
	}
	
	public static void analyzeButton(Tracker t, String buttonName, String buttonValue){
		String category = "UX Button";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(buttonName)
		.setLabel(buttonValue)
		.build());
	}
	
	public static void analyzeSettingsButton(Tracker t, String buttonName, String buttonValue){
		String category = "Settings Button";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(buttonName)
		.setLabel(buttonValue)
		.build());
	}
	
	public static void analyzeContentButton(Tracker t, String eventName, String eventValue){
		String category = "Content click";
		
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(eventName)
		.setLabel(eventValue)
		.build());
		
	}
	
	public static void analyzeSearchQuery(Tracker t, String query){
		String category = "Search Query";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction("Searching")
		.setLabel(query)
		.build());
	}
	
	public static void analyzeHardButton(Tracker t, String buttonName){
		String category = "Hard Button";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(buttonName)
		.build());
	}

	public static void analyzeScreen(Tracker t, String screenName) {
		t.setScreenName(screenName);
		t.send(new HitBuilders.AppViewBuilder().build());
	}
	
	public static void analyzeEvent(Tracker t, String eventName, String eventValue){
		String category = "App Event";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(eventName)
		.setLabel(eventValue)
		.build());
	}
	
	
	public static void analyzeABclick(Tracker t, String buttonName, String buttonValue){
		String action = buttonName+":"+buttonValue;
		String category = "UX Action Bar";
		t.send(new HitBuilders.EventBuilder()
		.setCategory(category)
		.setAction(buttonName)
		.setLabel(buttonValue)
		.build());
	}
	
	public static void hitTriggerSetTrue(){
		wasHit = true;
	}
	public static void hitTriggerSetFalse(){
		wasHit = false;
	}
	
	public static void analyzeEventCondition(Tracker t, String eventName, String eventValue){
		if(wasHit){
			String category = "App Special Event";
			t.send(new HitBuilders.EventBuilder()
			.setCategory(category)
			.setAction(eventName)
			.setLabel(eventValue)
			.build());
		}
		wasHit = false;
	}
}
