package com.quran.ramadn.qurancopy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_splash);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

            mySong=MediaPlayer.create(Splash_Activity.this,R.raw.ayah);
                mySong.start();
            Thread timer=new Thread(){
                public void run(){
                    try{
                        sleep(6000);
                    }catch(InterruptedException e){
                        e.printStackTrace();

                    }finally{
                        nextActivity();
                        }}} ;

            timer.start();
    }
    public void nextActivity(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    protected void onPause(){
        super.onPause();
        mySong.release();
        finish();
    }
}