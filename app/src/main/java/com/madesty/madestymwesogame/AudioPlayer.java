package com.madesty.madestymwesogame;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Aiko on 9/21/2016.
 */
public class AudioPlayer extends Service{

    private MediaPlayer song1;
    private MediaPlayer song2;
    private boolean play = false;

    @Override
    public void onCreate(){
        super.onCreate();
        song1 = MediaPlayer.create(this, R.raw.danceofthebumblebee);
        song2 = MediaPlayer.create(this, R.raw.fanfare);
        song1.setAudioStreamType(AudioManager.STREAM_MUSIC);
        song2.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }

    public int onStartCommand(Intent intent, int flags, int startid){
        song1.start();
        return 1;
    }

    public void onStart(){

    }

    public void setVolume(int vol){
        song1.setVolume(vol, vol);
    }

    public void onPause(){
        song1.pause();
    }

    public void onStop(){
        song1.stop();
    }

    @Override
    public void onDestroy(){
        song1.stop();
        song1.release();
        song2.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
