package com.silva.specht.rafael.periodically;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Periodically extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_periodically);
		
		final TextView text = (TextView) findViewById(R.id.text);
		
		 new CountDownTimer(3000000, 1000) {
		
		     public void onTick(long millisUntilFinished) {
		         text.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }
		
		     public void onFinish() {
		    	 text.setText("done!");
		     }
		 }.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.periodically, menu);
		return true;
	}

}
