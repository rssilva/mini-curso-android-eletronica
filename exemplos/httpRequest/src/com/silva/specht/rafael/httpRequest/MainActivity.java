package com.silva.specht.rafael.httpRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public View textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.textView = findViewById(R.id.text);
		this.setButtonGet();
		this.setButtonPost();
	}
	
	public void setButtonGet () {
		final Button button = (Button) findViewById(R.id.buttonGet);
		
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	try {
					getData();
				} catch (JSONException e) {
					e.printStackTrace();
				}
            }
        });
	}
	
	public void setButtonPost () {
		final Button button = (Button) findViewById(R.id.buttonPost);
		
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	try {
					postData();
				} catch (JSONException e) {
					e.printStackTrace();
				}
            }
        });
	}
	
	public void getData () throws JSONException {
	    // Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    
	    //HttpGet httpget = new HttpGet("http://192.168.2.103/random");
	    HttpGet httpget = new HttpGet("http://192.168.2.103:5000");

	    try {
	        // Execute HTTP Post Request
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
	        
	        String responseBody = httpclient.execute(httpget, responseHandler);
	        
	        Log.i("tro", "response");
	        Log.i("tro", responseBody.toString());
	        
	        ((TextView) this.textView).setText( responseBody.toString() );
	        
	    } catch (ClientProtocolException e) {
	    	Log.i("tro", "ClientProtocolException " + e);
	    } catch (IOException e) {
	    	Log.i("tro", "IOException " + e);
	    }
	}
	

	
	public void postData () throws JSONException {
	    // Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://192.168.2.103:5000/post-test");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("id", "12345"));
	        nameValuePairs.add(new BasicNameValuePair("stringdata", "Test"));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        String result = EntityUtils.toString(response.getEntity());
	        
	        Log.i("tro", "result " + result.toString());
	        
	        ((TextView) this.textView).setText( result.toString() );
	        
	    } catch (ClientProtocolException e) {
	    	Log.i("tro", "ClientProtocolException " + e);
	    } catch (IOException e) {
	    	Log.i("tro", "IOException " + e);
	    }
	} 
}