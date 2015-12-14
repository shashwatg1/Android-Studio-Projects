package com.example.shashwatgupta.intents;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.example.shashwatgupta.intents";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    long futuretime=System.currentTimeMillis()+5000;
                    while(futuretime>System.currentTimeMillis()){
                        synchronized (this){
                            try{
                                wait(futuretime-System.currentTimeMillis());
                                Log.i(TAG, "service is doing something");
                            }catch (Exception e){}
                        }

                    }

                }
            }
        };

        Thread myThread = new Thread(r);
        myThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
