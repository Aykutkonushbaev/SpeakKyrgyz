package com.example.shopping_list;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity implements OnClickListener, OnLoadCompleteListener {
	
	private SKDataSource dataSource;
	TextView tv1;
	TextView tv2;
	Button btn;
	String audio;
	final int MAX_STREAMS = 5;
	int streamID;
	int soundID;
	//SoundPool sp;
	private static final String TAG = "myLogs";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        
        dataSource = new SKDataSource(this);
        dataSource.open();
        final Intent intent = getIntent();
        final long id = intent.getLongExtra(DatabaseHelper.COLUMN_GROUP_ID, 0);
        
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button1);
        
        tv1.setText(intent.getStringExtra(DatabaseHelper.COLUMN_TRANSLATION));
        tv2.setText(intent.getStringExtra(DatabaseHelper.COLUMN_TRANSCRIPT));
        audio = intent.getStringExtra(DatabaseHelper.COLUMN_AUDIO);
//        Uri myUri = ....;
        
//        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
//        sp.setOnLoadCompleteListener(this);
        
//        soundID = sp.load(this, R.raw.audio1, 1);
        
        btn.setOnClickListener(this);
        
	}
	
	@Override
	public void onClick(View v) {
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("" + audio, "raw", "com.example.shopping_list"));
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            mediaPlayer.start();
	 }

	@Override
	public void onLoadComplete(SoundPool arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
