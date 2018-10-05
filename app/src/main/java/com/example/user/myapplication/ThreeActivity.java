package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThreeActivity extends AppCompatActivity {
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        init();
    }

    private void init() {
        getSupportActionBar().setTitle(R.string.player);
    }

    public void clkBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v;
            Log.i("test", b.getText().toString());

            if(b.getId() == R.id.music_1){

                doStop();
                mp = MediaPlayer.create(ThreeActivity.this, R.raw.ohmygirl_remember_me);
                mp.start();
            }else if(b.getId() == R.id.music_2){
                doStop();
                mp = MediaPlayer.create(ThreeActivity.this, R.raw.lsd_thunderclouds);
                mp.start();
            }else if(b.getId() == R.id.btn_1){
                String get_text = b.getText().toString();
                if(mp == null){
                    return;
                }

                if(get_text.equals(getString(R.string.pause))){
                    //일시정지
                    mp.pause();
                    b.setText(R.string.start);
                }else{
                    //재생
                    mp.start();
                    b.setText(R.string.pause);
                }
            }else if(b.getId() == R.id.btn_2){
                doStop();

                String get_text = b.getText().toString();
                if(get_text.equals(getString(R.string.pause))){
                    //일시정지
                    b.setText(R.string.start);
                }
            }
        }
    }

    public void doStop(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
