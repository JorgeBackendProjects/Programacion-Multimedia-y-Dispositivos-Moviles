package com.example.actividad9;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class Alarma extends Service {

    MediaPlayer reproductor;

    public int onStartCommand(Intent intent, int flags, int startId) {
        reproductor = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        reproductor.setLooping(true);
        reproductor.start();
        return START_STICKY;
    }

    public void onDestroit(){
        super.onDestroy();
        //Parada del reproductor
        reproductor.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}