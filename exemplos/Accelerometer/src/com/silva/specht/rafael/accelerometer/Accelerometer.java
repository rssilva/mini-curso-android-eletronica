package com.silva.specht.rafael.accelerometer;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;

public class Accelerometer extends Activity implements SensorEventListener  {

	private SensorManager sensorManager;
	private boolean color = false;
	private View view;
	private long lastUpdate;

	  
	/** Called when the activity is first created. */

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_accelerometer);
		  view = findViewById(R.id.textView);
		  view.setBackgroundColor(Color.GREEN);

		  sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		  lastUpdate = System.currentTimeMillis();
	  }

	  @Override
	  public void onSensorChanged(SensorEvent event) {
		  if ( event.sensor.getType() == Sensor.TYPE_ACCELEROMETER ) {
			  getAccelerometer(event);
		  }
	  }

	  private void getAccelerometer(SensorEvent event) {
		  float[] values = event.values;

		  float x = values[0];
		  float y = values[1];
		  float z = values[2];

		  Log.i("tro", x + "; " + y + "; " + z);
		  
		  float accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		  long actualTime = System.currentTimeMillis();
		  if (accelationSquareRoot >= 2) {
			  if (actualTime - lastUpdate < 200) {
				  return;
			  }
			  lastUpdate = actualTime;
			  
			  if (color) {
				  view.setBackgroundColor(Color.GREEN);
			  } else {
				  view.setBackgroundColor(Color.RED);
			  }
			  color = !color;
		  }
	  }

	  @Override
	  public void onAccuracyChanged(Sensor sensor, int accuracy) {

	  }

	  @Override
	  protected void onResume() {
		  super.onResume();
	    
		  sensorManager.registerListener(this,
				  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				  SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() {
		  super.onPause();
		  sensorManager.unregisterListener(this);
	  }
}