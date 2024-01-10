package com.example.pmydm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

/**
 * Esta clase actuara como un servicio a inicializar cuando
 * se de la condicion en una nota que hayamos creado.
 */
public class Alarma extends Service {

    MediaPlayer reproductor;

    /**
     * Este metodo crea e inicializa el servicio mediante un intento,
     * en este caso usamos un MediaPlayer que inicializamos como una alarma.
     *
     * @param intent
     * @param flags
     * @param startId
     * @return START_STICKY permite revivir el servicio cuando vuelva a disponer de memoria sufuciente.
     */
    public int onStartCommand(Intent intent, int flags, int startId){
        reproductor = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        reproductor.setLooping(true);
        reproductor.start();

        return START_STICKY;
    }

    /**
     * Este metodo se usara para detener y destruir el servicio.
     */
    public void onDestroy(){
        super.onDestroy();
        reproductor.stop();
    }

    /**
     * Este metodo se usa cuando el servicio se ejecuta unicamente en segundo plano.
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
