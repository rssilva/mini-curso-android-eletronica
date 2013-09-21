package com.silva.specht.rafael.Sound;

import java.util.HashMap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class Sound extends Activity {
	private static SoundPool soundPool;
	private static HashMap soundPoolMap;
	
	public static final int Ab6 = R.raw.ab6;
    public static final int G6 = R.raw.g6;
    public static final int F6 = R.raw.f6;
    
	public static final int C5 = R.raw.c5;
    public static final int B5 = R.raw.b5;
    public static final int Bb5 = R.raw.bb5;
    
    public static final int E5 = R.raw.e5;
    public static final int D5 = R.raw.d5;
    public static final int Db5 = R.raw.db5;
    
    public static final int G5 = R.raw.g5;
    public static final int Gb5 = R.raw.gb5;
    public static final int F5 = R.raw.f5;
    
    public static final int G4 = R.raw.g4;
    public static final int A4 = R.raw.a4;
    public static final int B4 = R.raw.b4;
    
    public static final int C3 = R.raw.c3;
    public static final int D3 = R.raw.d3;
    public static final int E3 = R.raw.e3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound);
		
		Sound.initSounds(getBaseContext());
		this.setButtons();
	}
	
	public void setButtons () {
		final Button buttonAb6 = (Button) findViewById(R.id.ab6);
		final Button buttonG6 = (Button) findViewById(R.id.g6);
		final Button buttonF6 = (Button) findViewById(R.id.f6);
	    
		final Button buttonC5 = (Button) findViewById(R.id.c5);
		final Button buttonB5 = (Button) findViewById(R.id.b5);
		final Button buttonBb5 = (Button) findViewById(R.id.bb5);
	    
		final Button buttonE5 = (Button) findViewById(R.id.e5);
		final Button buttonD5 = (Button) findViewById(R.id.d5);
		final Button buttonDb5 = (Button) findViewById(R.id.db5);
	    
		final Button buttonG5 = (Button) findViewById(R.id.g5);
		final Button buttonGb5 = (Button) findViewById(R.id.gb5);
		final Button buttonF5 = (Button) findViewById(R.id.f5);
	    
		final Button buttonG4 = (Button) findViewById(R.id.g4);
		final Button buttonA4 = (Button) findViewById(R.id.a4);
		final Button buttonB4 = (Button) findViewById(R.id.b4);
	    
		final Button buttonC3 = (Button) findViewById(R.id.c3);
		final Button buttonD3 = (Button) findViewById(R.id.d3);
		final Button buttonE3 = (Button) findViewById(R.id.e3);
		
		final Context context = getBaseContext();
		
		buttonAb6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, Ab6);
            }
        });
		
		buttonG6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, G6);
            }
        });
		
		buttonF6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, F6);
            }
        });
		
		buttonC5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, C5);
            }
        });
		
		buttonB5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, B5);
            }
        });
		
		buttonBb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, Bb5);
            }
        });
		
		buttonE5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, E5);
            }
        });
		
		buttonD5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, D5);
            }
        });
		
		buttonDb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, Db5);
            }
        });

		buttonG5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, G5);
            }
        });
		
		buttonGb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, Gb5);
            }
        });
		
		buttonF5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, F5);
            }
        });
		
		buttonB4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, B4);
            }
        });
		
		buttonA4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, A4);
            }
        });
		
		buttonG4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, G4);
            }
        });
		
		buttonE3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, E3);
            }
        });
		
		buttonD3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, D3);
            }
        });
		
		buttonC3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(context, C3);
            }
        });
	}
	
	/** Populate the SoundPool*/
	public static void initSounds(Context context) {
	    soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
		soundPoolMap = new HashMap(3);     
	
		//soundPoolMap.put( Ab6, soundPool.load(context, R.raw.b5, 1) );
		soundPoolMap.put( Ab6, soundPool.load(context, Ab6, 1) );
		soundPoolMap.put( G6, soundPool.load(context, G6, 2) );
		soundPoolMap.put( F6, soundPool.load(context, F6, 3) );
		
		soundPoolMap.put( C5, soundPool.load(context,  C5,  4) );
		soundPoolMap.put( B5, soundPool.load(context,  B5,  5) );
		soundPoolMap.put( Bb5, soundPool.load(context, Bb5, 6) );
		
		soundPoolMap.put( E5, soundPool.load(context,  E5,  7) );
		soundPoolMap.put( D5, soundPool.load(context,  D5,  8) );
		soundPoolMap.put( Db5, soundPool.load(context, Db5, 9) );
		
		soundPoolMap.put( G5, soundPool.load(context,  G5,   10) );
		soundPoolMap.put( Gb5, soundPool.load(context, Gb5,  11) );
		soundPoolMap.put( F5, soundPool.load(context,  F5,   12) );
		
		soundPoolMap.put( B4, soundPool.load(context,  B4,  13) );
		soundPoolMap.put( A4, soundPool.load(context,  A4,  14) );
		soundPoolMap.put( G4, soundPool.load(context, G4,  15) );
		
		soundPoolMap.put( E3, soundPool.load(context,  E3, 16) );
		soundPoolMap.put( D3, soundPool.load(context,  D3,  17) );
		soundPoolMap.put( C3, soundPool.load(context,  C3,  18) );
		
	}

	 /** Play a given sound in the soundPool */
	 public static void playSound(Context context, int soundID) {
		 if(soundPool == null || soundPoolMap == null){
			 initSounds(context);
		 }
		 float volume = (float) 1.0; // whatever in the range = 0.0 to 1.0

		 //play sound with same right and left volume, with a priority of 1, 
		 // zero repeats (i.e play once), and a playback rate of 1f
		 soundPool.play((Integer) soundPoolMap.get(soundID), volume, volume, 1, 0, 1f);
	 }

}