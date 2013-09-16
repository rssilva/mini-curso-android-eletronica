package com.silva.specht.rafael.inputs;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.view.View.OnClickListener;

public class Input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        
        this.fillAdapter();
        
        this.setCheckboxEvent();
    }
        
    protected void fillAdapter () {
    	Spinner spinner = (Spinner) findViewById(R.id.numbers_spinner);
    	
    	List<String> list = new ArrayList<String>();
    	
    	list.add("0");
    	list.add("1");
    	list.add("2");
    	list.add("3");
    	
    	Log.i("tro", "preenchendo...");
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	
    	spinner.setAdapter(dataAdapter);
    }
    
    public void setCheckboxEvent () {
    	ViewGroup boxes = (ViewGroup) findViewById(R.id.checkboxes);
    	int len = boxes.getChildCount();
    	
    	for (int i = 0; i < len; i++) {
    		
    		boxes.getChildAt(i).setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				CheckBox checkbox = (CheckBox) view;
    				String text = checkbox.getText().toString();
    				Log.v("tro", "Clicked " + text);
    			}
        	});
    	}
    }
}