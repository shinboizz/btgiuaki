package com.example.btgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Music extends AppCompatActivity {
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musiczz);

    }

    public void play(View view){
        if(player == null){
            player = MediaPlayer.create(this,R.raw.song );
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopplayer();
                }
            });
        }
        player.start();

    }
    public void pause(View view){
        if(player != null){
            player.pause();
        }

    }
    public void stop(View view){
        stopplayer();

    }
    private void stopplayer(){
        if(player != null){
            player.release();
            player = null ;
            Toast.makeText(this,"Media relead",Toast.LENGTH_SHORT).show();
        };
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopplayer();
    }
}